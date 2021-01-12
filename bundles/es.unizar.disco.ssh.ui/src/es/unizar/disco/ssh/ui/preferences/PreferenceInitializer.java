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
package es.unizar.disco.ssh.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import es.unizar.disco.ssh.ui.DiceSshConnectorUiPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = DiceSshConnectorUiPlugin.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.HOST.toString(), "localhost"); //$NON-NLS-1$
		store.setDefault(PreferenceConstants.PORT.toString(), 22);
		store.setDefault(PreferenceConstants.PROVIDER.toString(), PreferenceConstants.PASSWORD_PROVIDER.toString());
		store.setDefault(PreferenceConstants.USERNAME.toString(), "");
		store.setDefault(PreferenceConstants.KEY.toString(), "");
		store.setDefault(PreferenceConstants.PASSWORD.toString(), "");
	}

}
