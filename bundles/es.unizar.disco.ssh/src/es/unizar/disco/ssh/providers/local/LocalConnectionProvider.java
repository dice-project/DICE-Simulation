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
package es.unizar.disco.ssh.providers.local;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.ssh.DiceSshConnectorPlugin;
import es.unizar.disco.ssh.providers.IHostProvider;
import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;

public class LocalConnectionProvider implements IHostProvider, IUserPasswordAuthProvider {

	private static final String CONNECTION_PROPERTIES 	= "connection.properties"; //$NON-NLS-1$
	
	private static final String HOST_PROPERTY 			= "host"; //$NON-NLS-1$
	private static final String HOST_PROPERTY_DEFAULT 	= "localhost"; //$NON-NLS-1$
	private static final String PORT_PROPERTY 			= "port"; //$NON-NLS-1$
	private static final String PORT_PROPERTY_DEFAULT 	= "22"; //$NON-NLS-1$
	private static final String USER_PROPERTY 			= "user"; //$NON-NLS-1$
	private static final String PASSWORD_PROPERTY 		= "password"; //$NON-NLS-1$

	@Override
	public String getHost() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty(HOST_PROPERTY, HOST_PROPERTY_DEFAULT);
	}

	@Override
	public int getPort() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return Integer.valueOf(properties.getProperty(PORT_PROPERTY, PORT_PROPERTY_DEFAULT));
	}

	@Override
	public String getUser() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty(USER_PROPERTY, "");
	}

	@Override
	public String getPassword() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty(PASSWORD_PROPERTY, "");
	}

	private InputStream getPropertiesStream() throws IOException {
		InputStream propertiesStream = getClass().getResourceAsStream(CONNECTION_PROPERTIES);
		if (propertiesStream == null) {
			throw new IOException(MessageFormat.format(Messages.LocalConnectionProvider_unableFindFileError, CONNECTION_PROPERTIES));
		}
		return propertiesStream;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void configure() throws CoreException {
		throw new CoreException(
				new Status(IStatus.INFO, DiceSshConnectorPlugin.PLUGIN_ID,
				MessageFormat.format(Messages.LocalConnectionProvider_selfConfigUnsupportedError, LocalConnectionProvider.class.getName())));
	}
}
