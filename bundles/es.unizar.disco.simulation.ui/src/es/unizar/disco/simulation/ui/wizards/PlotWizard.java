package es.unizar.disco.simulation.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.statushandlers.StatusManager;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;
import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.editors.PlotEditor;
import es.unizar.disco.simulation.ui.plot.PlotData;
import es.unizar.disco.simulation.ui.plot.PlotData.Pair;

public class PlotWizard extends Wizard {

	protected class WizardData {

		final InvocationSet invocationSet;

		private InputVariable selectedVariable;

		private DomainMeasureDefinition selectedMeasure;

		public WizardData(InvocationSet invocationSet) {
			this.invocationSet = invocationSet;
		}

		public List<InputVariable> getInputVariables() {
			return invocationSet.getDefinition().getInputVariables();
		}

		public List<DomainMeasureDefinition> getMeasures() {
			return invocationSet.getDefinition().getMeasuresToCompute();
		}

		public InputVariable getSelectedVariable() {
			return selectedVariable;
		}
		
		public void setSelectedVariable(InputVariable variable) {
			selectedVariable = variable;
		}

		public DomainMeasureDefinition getSelectedMeasure() {
			return selectedMeasure;
		}
		
		public void setSelectedMeasure(DomainMeasureDefinition measure) {
			selectedMeasure = measure;
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

		Collector collector = Collector.collect(data);

		if (collector.error()) {
			// @formatter:off
			boolean cont = MessageDialog.openQuestion(getShell(), 
					"Missing data",
					"The chosen invocation set has missing data for the selected configuration."
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
						PlotData data = collector.plotData();
						ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
						data.serialize(byteOutputStream);
						// @formatter:off
						file.setContents(
								new ByteArrayInputStream(byteOutputStream.toByteArray()),
								IResource.KEEP_HISTORY | IResource.FORCE,
								subMonitor.newChild(1));
						// @formatter:on
						Display.getDefault().syncExec(new Runnable() {
							@Override
							public void run() {
								IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
								try {
									page.openEditor(new FileEditorInput(file), PlotEditor.ID);
								} catch (PartInitException e) {
									DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
								}
							}
						});
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					} catch (IOException e) {
						// Should never happen, since we are using a
						// ByteArrayOutputStream
						throw new InvocationTargetException(e);
					}
				}
			});
		} catch (InvocationTargetException e) {
			// @formatter:off
			StatusManager.getManager().handle(
					new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getCause().getLocalizedMessage(), e.getCause()),
					StatusManager.LOG | StatusManager.SHOW);
			return false;
			// @formatter:on
		} catch (InterruptedException e) {
			// Cancel requested: nothing to do
		}

		return true;
	}

	private static class Collector {

		private PlotData plotData;
		private boolean error = false;

		private Collector() {
		}

		public static Collector collect(WizardData wizardData) {
			Collector collector = new Collector();
			List<Pair<Number, Number>> values = new ArrayList<>();
			String yUnit = wizardData.selectedMeasure.getVslExpressionEntries().get("unit");
			for (SimulationInvocation invocation : wizardData.invocationSet.getInvocations()) {
				Number variableValue = null;
				Number measureValue = null;
				try {
					for (DomainMeasure measure : invocation.getResult().getMeasures()) {
						if (wizardData.selectedMeasure.equals(measure.getDefinition())) {
							VariableConfiguration configuration = invocation.getVariableConfiguration();
							variableValue = configuration.findAssignment(wizardData.selectedVariable).getValue().getValue();
							measureValue = measure.getValue();
							if (yUnit == null) {
								yUnit = measure.getUnit();
							} else {
								Assert.isTrue(yUnit.equals(measure.getUnit()), "All measures must have the same Unit");
							}
						}
					}
				} catch (NullPointerException e) {
					collector.error = true;
				} finally {
					values.add(new Pair<Number, Number>(invocation.getIdentifier(), variableValue, measureValue));
				}
			}
			// @formatter:off
			collector.plotData = PlotData
					.build(wizardData.invocationSet.getIdentifier())
					.xLabel(wizardData.selectedVariable.getName())
					.yLabel(wizardData.selectedMeasure.getMeasure())
					.yUnit(yUnit)
					.data(values);
			// @formatter:on
			return collector;
		}

		public boolean error() {
			return error;
		}

		public PlotData plotData() {
			return plotData;
		}
	}
}
