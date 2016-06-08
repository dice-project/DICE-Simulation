package es.unizar.disco.simulation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.framework.BundleContext;

import es.unizar.disco.simulation.preferences.PreferenceConstants;
import es.unizar.disco.simulation.simulators.SimulatorConstants;

public class DiceSimulationPlugin extends Plugin {

	public static final String PLUGIN_ID = "es.unizar.disco.simulation"; //$NON-NLS-1$

	public static final String SIMULATION_LAUNCH_CONFIGURATION_TYPE = "es.unizar.disco.simulation.ui.launchConfigurationType"; //$NON-NLS-1$

	private static DiceSimulationPlugin plugin;

	/**
	 * The constructor.
	 */
	public DiceSimulationPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static DiceSimulationPlugin getDefault() {
		return plugin;
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
		IEclipsePreferences node = InstanceScope.INSTANCE.getNode(PLUGIN_ID);
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

}
