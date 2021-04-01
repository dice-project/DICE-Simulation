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
package test.es.unizar.disco.simulation.tests.connection;

import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;

import es.unizar.disco.ssh.providers.IHostProvider;
import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;

public class TestConnectionProvider implements IHostProvider, IUserPasswordAuthProvider {

	private static final String CONFIG_FILE 	= "/test/resources/config.properties"; //$NON-NLS-1$
	
	private static final String HOST_PROPERTY 			= "host"; //$NON-NLS-1$
	private static final String PORT_PROPERTY 			= "port"; //$NON-NLS-1$
	private static final String USER_PROPERTY 			= "user"; //$NON-NLS-1$
	private static final String PASSWORD_PROPERTY 		= "password"; //$NON-NLS-1$

	private Properties properties = new Properties();
	
	public TestConnectionProvider() throws IOException {
		properties.load(getClass().getResourceAsStream(CONFIG_FILE));
	}
	
	@Override
	public String getHost() {
		return properties.getProperty(HOST_PROPERTY);
	}

	@Override
	public int getPort() {
		return Integer.valueOf(properties.getProperty(PORT_PROPERTY));
	}

	@Override
	public String getUser() {
		return properties.getProperty(USER_PROPERTY);
	}

	@Override
	public String getPassword() {
		return properties.getProperty(PASSWORD_PROPERTY);
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void configure() throws CoreException {
		// Do nothing
	}
}
