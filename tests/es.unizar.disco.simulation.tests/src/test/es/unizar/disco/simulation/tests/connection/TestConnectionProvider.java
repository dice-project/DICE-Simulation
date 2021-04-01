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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.internal.registry.ExtensionRegistry;
import org.eclipse.core.runtime.ContributorFactoryOSGi;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.junit.Assert;

import es.unizar.disco.ssh.providers.IHostProvider;
import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;

public class TestConnectionProvider implements IHostProvider, IUserPasswordAuthProvider {

	private static boolean registered = false;

	private static final String BUNDLE_ID = "es.unizar.disco.simulation.tests"; //$NON-NLS-1$
	private static final String CONFIG_FILE = "/test/resources/config.properties"; //$NON-NLS-1$

	private static final String HOST_PROPERTY = "host"; //$NON-NLS-1$
	private static final String PORT_PROPERTY = "port"; //$NON-NLS-1$
	private static final String USER_PROPERTY = "user"; //$NON-NLS-1$
	private static final String PASSWORD_PROPERTY = "password"; //$NON-NLS-1$
	
	// @formatter:off
	private static final String PLUGIN = 
			  "<plugin>"
			+ "   <extension"
			+ "         point=\"es.unizar.disco.ssh.connectionProviders\">"
			+ "      <ConnectionProvider"
			+ "            hostProvider=\"test.es.unizar.disco.simulation.tests.connection.TestConnectionProvider\""
			+ "            id=\"es.unizar.disco.simulation.tests.testConnectionProvider\""
			+ "            name=\"Test Connection Provider\""
			+ "            priority=\"9\">"
			+ "         <UserPasswordAuthProvider"
			+ "               authProvider=\"test.es.unizar.disco.simulation.tests.connection.TestConnectionProvider\">"
			+ "         </UserPasswordAuthProvider>"
			+ "      </ConnectionProvider>"
			+ "   </extension>"
			+ "</plugin>";
	// @formatter:on

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

	/**
	 * Registers this ConnectionProvider using the dedicated extension point as
	 * specified in the {@link #PLUGIN} constant. We must register it manually
	 * to avoid colliding or shadowing other non-test connection providers
	 * 
	 * IMPORTANT!! This Connection provider has the highest priority, and can't
	 * be unregistered using standard methods once registered.
	 * 
	 * CAVEAT!! This method makes use of non-API methods (see 
	 * {@link ExtensionRegistry#getTemporaryUserToken()}) and may be affected by
	 * future changes. In such a case, we can simply lower the proirity set and
	 * ask developers to manually activate this test provider when they want to
	 * make use of it. 
	 */
	public static void register() {
		if (!registered) {
			final IExtensionRegistry registry = RegistryFactory.getRegistry();
			final IContributor contributor = ContributorFactoryOSGi.createContributor(Platform.getBundle(BUNDLE_ID));
			final boolean success = registry.addContribution(
					new ByteArrayInputStream(PLUGIN.getBytes()), contributor,
					false, null, null,
					((ExtensionRegistry) registry).getTemporaryUserToken());
			Assert.assertTrue("Unable to register TestConnectionProvider", success);
		}
	}
}
