package es.unizar.disco.simulation.quickstart.actions;

import java.util.Properties;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;

public class OpenPreferencesAction implements IIntroAction {

	@Override
	public void run(IIntroSite site, Properties params) {
		PreferencesUtil.createPreferenceDialogOn(Display.getDefault().getActiveShell(), 
				"es.unizar.disco.ssh.ui.preferences.SshConnectionProviderPreferencePage", null, null).open(); ////$NON-NLS-1$
	}
}
