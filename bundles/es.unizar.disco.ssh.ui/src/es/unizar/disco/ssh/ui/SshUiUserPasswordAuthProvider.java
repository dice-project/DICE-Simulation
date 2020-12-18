/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
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
