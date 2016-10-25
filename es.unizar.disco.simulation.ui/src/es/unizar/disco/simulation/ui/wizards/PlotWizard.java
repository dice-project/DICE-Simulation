package es.unizar.disco.simulation.ui.wizards;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class PlotWizard extends Wizard {

	protected class WizardData {

		final InvocationSet invocationSet;

		private InputVariable selectedVariable;

		private DomainMeasureDefinition selectedMeasure;
		
		public WizardData(InvocationSet invocationSet) {
			this.invocationSet = invocationSet;
		}

		public List<SimulationInvocation> getInvocations() {
			return invocationSet.getInvocations();
		}

		public List<InputVariable> getInputVariables() {
			return invocationSet.getDefinition().getInputVariables();
		}

		public List<DomainMeasureDefinition> getMeasures() {
			return invocationSet.getDefinition().getMeasuresToCompute();
		}

		public void setSelectedVariable(InputVariable variable) {
			selectedVariable = variable;
		}

		InputVariable getSelectedVariable() {
			return selectedVariable;
		}

		public void setSelectedMeasure(DomainMeasureDefinition measure) {
			selectedMeasure = measure;
		}

		DomainMeasureDefinition getSelectedMeasure() {
			return selectedMeasure;
		}
	}

	WizardData data;
	private NewPlotFileCreationPage newFilePage;

	public PlotWizard(InvocationSet invocationSet) {
		this.data = new WizardData(invocationSet);
		setWindowTitle("Plot Simulation Results");
	}

	@Override
	public void addPages() {
		newFilePage = new NewPlotFileCreationPage(data);
		addPage(newFilePage);
		addPage(new SelectVariablePage(data));
		addPage(new SelectMetricPage(data));
	}

	@Override
	public boolean performFinish() {
		
		PlotBuilder builder = PlotBuilder.build(data);

		if (builder.error()) {
			// @formatter:off
			boolean cont = MessageDialog.openQuestion(getShell(), 
					"Missing data",
					"The invocations have missing data for the selected configuration."
					+ " Continue with the available data?");
			// @formatter:on
			if (!cont) {
				return false;
			}
		}
		
		try {
			IFile file = newFilePage.createNewFile();
			getContainer().run(true, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
					try {
						file.setContents(new ByteArrayInputStream(builder.getBytes()), IResource.KEEP_HISTORY & IResource.FORCE, subMonitor.newChild(1));
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
				}
			});
		} catch (InvocationTargetException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		} catch (InterruptedException e) {
			// Cancel requested nothing to do
		}
		
		return true;
	}

}
