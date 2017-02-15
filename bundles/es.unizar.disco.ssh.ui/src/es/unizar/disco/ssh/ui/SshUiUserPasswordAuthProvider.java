package es.unizar.disco.ssh.ui;

import org.apache.commons.lang.StringUtils;

import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;
import es.unizar.disco.ssh.ui.preferences.PreferenceConstants;

public class SshUiUserPasswordAuthProvider implements IUserPasswordAuthProvider {

	@Override
	public boolean isEnabled() {
		return StringUtils.equals(
				DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.PROVIDER.toString()),
				PreferenceConstants.PASSWORD_PROVIDER.toString());
	}
	
	@Override
	public String getUser() {
		return DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.USERNAME.toString());
	}

	@Override
	public String getPassword() {
		return DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.PASSWORD.toString());
	}

}
