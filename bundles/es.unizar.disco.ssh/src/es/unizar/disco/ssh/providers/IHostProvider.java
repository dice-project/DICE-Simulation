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

}
