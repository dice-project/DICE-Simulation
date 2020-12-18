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
package es.unizar.disco.simulation.local;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import es.unizar.disco.core.logger.DiceLogger;

public class LocalSimulationPlugin extends Plugin {

	private static LocalSimulationPlugin plugin;

	//private static final String PLUGIN_ID = "es.unizar.disco.simulation.local";
	
	/**
	 * The constructor.
	 */
	public LocalSimulationPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		// Cleanup the state location
				// Should only contain the temporary files created by GspnSshSimulator
				try {
					FileUtils.forceDelete(getStateLocation().toFile());
				} catch (IllegalStateException | IOException e) {
					DiceLogger.logException(LocalSimulationPlugin.getDefault(), e);
				}
				super.stop(context);
				plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static LocalSimulationPlugin getDefault() {
		return plugin;
	}

	
}
