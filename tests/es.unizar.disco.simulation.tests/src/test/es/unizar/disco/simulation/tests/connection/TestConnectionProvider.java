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

	/**
	 * This connection provider should be only enabled globally when running JUnit tests
	 */
	private static boolean enabled = false;

	private static final String CONFIG_FILE = "/test/resources/config.properties"; //$NON-NLS-1$

	private static final String HOST_PROPERTY = "host"; //$NON-NLS-1$
	private static final String PORT_PROPERTY = "port"; //$NON-NLS-1$
	private static final String USER_PROPERTY = "user"; //$NON-NLS-1$
	private static final String PASSWORD_PROPERTY = "password"; //$NON-NLS-1$
	
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
		// ATTENTION! this method provides the enabled state for both 
		// IHostProvider and IUserPasswordAuthProvider. Bear in mind, 
		// however, that in this case both providers must be enabled 
		// at the same time (and IUserPasswordAuthProvider state won't
		// be requested is IHostProvider is indeed enabled)
		return enabled;
	}

	@Override
	public void configure() throws CoreException {
		// Do nothing
	}

	public static void enable() {
		enabled = true;
	}

	public static void disable() {
		enabled = false;
	}
}
