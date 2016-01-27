package es.unizar.disco.ssh.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.PreferencesUtil;

import es.unizar.disco.ssh.providers.IHostProvider;
import es.unizar.disco.ssh.ui.preferences.PreferenceConstants;
import es.unizar.disco.ssh.ui.preferences.SshConnectionProviderPreferencePage;

public class SshUiHostProvider implements IHostProvider {

	@Override
	public String getHost() {
		return DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.HOST.toString());
	}

	@Override
	public int getPort() {
		return DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getInt(PreferenceConstants.PORT.toString());
	}

	@Override
	public void configure() {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				PreferencesUtil.createPreferenceDialogOn(Display.getDefault().getActiveShell(), SshConnectionProviderPreferencePage.ID, null, null).open();
			}
		});
	}
}
