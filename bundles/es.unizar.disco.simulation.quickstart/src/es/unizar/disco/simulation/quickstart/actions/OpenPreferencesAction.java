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
