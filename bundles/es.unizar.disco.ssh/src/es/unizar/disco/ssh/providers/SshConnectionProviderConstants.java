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
package es.unizar.disco.ssh.providers;

public final class SshConnectionProviderConstants {
	
	private SshConnectionProviderConstants() {
	}

	public static final String EXTENSION_ID = "es.unizar.disco.ssh.connectionProviders"; //$NON-NLS-1$
	
	public static final String ID_ATTR = "id"; //$NON-NLS-1$

	public static final String NAME_ATTR = "name"; //$NON-NLS-1$

	public static final String ICON_ATTR = "icon"; //$NON-NLS-1$

	public static final String PRIORITY_ATTR = "priority"; //$NON-NLS-1$
	
	public static final String DESCRIPTION_ATTR = "description"; //$NON-NLS-1$

	public static final String HOST_PROVIDER_ATTR = "hostProvider"; //$NON-NLS-1$

	public static final String AUTH_PROVIDER_ATTR = "authProvider"; //$NON-NLS-1$

}
