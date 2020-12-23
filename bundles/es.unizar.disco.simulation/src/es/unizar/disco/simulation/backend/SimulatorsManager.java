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
package es.unizar.disco.simulation.backend;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.preferences.PreferenceConstants;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulatorConstants;

public final class SimulatorsManager {

	public static final SimulatorsManager INSTANCE = new SimulatorsManager();

	private SimulatorsManager() {
	}

	/**
	 * Returns a list of the currently contributed simulation back-ends
	 * 
	 * @return
	 */
	public List<String> getSimulationBackends() {
		List<String> backends = new ArrayList<>();

		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(SimulatorConstants.EXTENSION_ID);

		for (IConfigurationElement configElement : configElements) {
			backends.add(configElement.getAttribute(SimulatorConstants.ID_ATTR));
		}

		return backends;
	}

	/**
	 * 
	 * Returns the back-end with the highest priority
	 * 
	 * @return
	 */
	public String getDefaultSimulationBackend() {
		// TODO: Change this implementation in the future by using priorities
		IEclipsePreferences node = InstanceScope.INSTANCE.getNode(DiceSimulationPlugin.PLUGIN_ID);
		String defaultBackend = node.get(PreferenceConstants.PRIORITY_BACKEND, null);
		if (defaultBackend == null) {
			List<String> backends = getSimulationBackends();
			if (!backends.isEmpty()) {
				defaultBackend = backends.get(0);
				node.put(PreferenceConstants.PRIORITY_BACKEND, defaultBackend);
			}
		}
		return defaultBackend;
	}

	/**
	 * Returns an instance of the {@link ISimulator} identified by
	 * <code>id</code>
	 * 
	 * @param id
	 *            the {@link ISimulator} identifier
	 * @return the {@link ISimulator} instance
	 * @throws CoreException
	 *             if the instance cannot be created
	 */
	public ISimulator getSimulator(String id) throws CoreException {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(SimulatorConstants.EXTENSION_ID);

		for (IConfigurationElement configElement : configElements) {
			String configId = configElement.getAttribute(SimulatorConstants.ID_ATTR);
			if (StringUtils.equals(id, configId)) {
				return (ISimulator) configElement.createExecutableExtension(SimulatorConstants.SIMULATOR_ATTR);
			}
		}
		return null;
	}
}
