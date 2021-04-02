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

import org.eclipse.core.runtime.CoreException;

public interface IHostProvider {

	/**
	 * Return the host (IP or domain name) to connect to
	 * 
	 * @return The <code>host</code> as a {@link String}
	 */
	public String getHost();

	/**
	 * Return the port to connect to
	 * 
	 * @return The <code>port</code>
	 */
	public int getPort();

	/**
	 * Asks the provider to self-configure. Calling this method may ask the user
	 * to initialize the {@link IHostProvider} configuration if it involves user
	 * interaction.
	 *
	 * @throws CoreException
	 *             if the {@link IHostProvider} cannot be configured or an error
	 *             occurs
	 */
	public void configure() throws CoreException;

	/**
	 * Returns whether this {@link IHostProvider} is enabled and can be used to
	 * connect to an SSH server
	 * 
	 * @return
	 */
	public boolean isEnabled();
}
