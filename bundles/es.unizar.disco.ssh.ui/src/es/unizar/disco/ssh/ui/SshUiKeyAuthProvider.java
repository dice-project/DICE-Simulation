package es.unizar.disco.ssh.ui;

import org.apache.commons.lang.StringUtils;

import es.unizar.disco.ssh.providers.IKeyAuthProvider;
import es.unizar.disco.ssh.ui.preferences.PreferenceConstants;

public class SshUiKeyAuthProvider implements IKeyAuthProvider {

	@Override
	public String getUser() {
		return DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.USERNAME.toString());
	}

	@Override
	public boolean isEnabled() {
		return StringUtils.equals(
				DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.PROVIDER.toString()),
				PreferenceConstants.KEY_PROVIDER.toString());
	}

	@Override
	public String getPrivateKey() {
		return DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.KEY.toString());
	}

	@Override
	public String getPassphrase() {
		return DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.PASSPHRASE.toString());
	}

}
