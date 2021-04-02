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
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
