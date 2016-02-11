package es.unizar.disco.simulation.quickstart.actions;

import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.eclipse.ui.wizards.IWizardDescriptor;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.quickstart.DiceQuickStartUiPlugin;
import es.unizar.disco.simulation.quickstart.wizards.ImportExampleProjectWizard;

public class OpenWizardAction implements IIntroAction {

	@Override
	public void run(IIntroSite site, Properties params) {
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(ImportExampleProjectWizard.WIZARD_ID);
		try {
			if (descriptor != null) {
				IWizard wizard = descriptor.createWizard();
				WizardDialog wd = new WizardDialog(site.getShell(), wizard);
				wd.setTitle(wizard.getWindowTitle());
				wd.open();
			}
		} catch (CoreException e) {
			DiceLogger.logException(DiceQuickStartUiPlugin.getDefault(), e);
		}
	}
}
