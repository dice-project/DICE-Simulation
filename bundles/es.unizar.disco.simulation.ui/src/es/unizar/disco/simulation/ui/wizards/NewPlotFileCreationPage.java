package es.unizar.disco.simulation.ui.wizards;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.ui.wizards.PlotWizard.WizardData;

class NewPlotFileCreationPage extends WizardNewFileCreationPage {

	public NewPlotFileCreationPage(WizardData data) {
		super("New Plot File", getDefaultSelection(data.invocationSet));
		setTitle("New Plot File");
		setDescription("Set the plot data file");
		setFileExtension("plot");
		setFileName("data.plot");
		setAllowExistingResources(true);
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		validatePage();
	}

	private static IStructuredSelection getDefaultSelection(InvocationSet invocationSet) {
		try {
			URI uri = invocationSet.getDefinition().getDomainResource().getUri();
			String path = uri.toPlatformString(true);
			return new StructuredSelection(ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path)));
		} catch (Throwable t) {
			// This error can be ignored
			// Nothing to report
		}
		return new StructuredSelection();
	}
}
