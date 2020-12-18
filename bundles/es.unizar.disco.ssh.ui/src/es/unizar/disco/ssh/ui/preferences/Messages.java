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

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.ssh.ui.preferences.messages"; //$NON-NLS-1$
	public static String SshConnectionProviderPreferencePage_authLabel;
	public static String SshConnectionProviderPreferencePage_hostLabel;
	public static String SshConnectionProviderPreferencePage_invalidFormatError;
	public static String SshConnectionProviderPreferencePage_invalidHostError;
	public static String SshConnectionProviderPreferencePage_keyEmptyError;
	public static String SshConnectionProviderPreferencePage_keyLabel;
	public static String SshConnectionProviderPreferencePage_passphraseLabel;
	public static String SshConnectionProviderPreferencePage_passwordLabel;
	public static String SshConnectionProviderPreferencePage_portLabel;
	public static String SshConnectionProviderPreferencePage_prefsDescription;
	public static String SshConnectionProviderPreferencePage_remoteServerLabel;
	public static String SshConnectionProviderPreferencePage_unexpectedInputError;
	public static String SshConnectionProviderPreferencePage_unknownFormatError;
	public static String SshConnectionProviderPreferencePage_userLabel;
	public static String SshConnectionProviderPreferencePage_usernameEmptyError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
