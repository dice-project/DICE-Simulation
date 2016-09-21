package es.unizar.disco.simulation;

import java.util.List;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;

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
		SimulationInvocationsRegistry.INSTANCE.save();
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
		return SimulatorsManager.INSTANCE.getSimulationBackends();
	}

	/**
	 * 
	 * Returns the back-end with the highest priority
	 * 
	 * @return
	 */
	public String getDefaultSimulationBackend() {
		return SimulatorsManager.INSTANCE.getDefaultSimulationBackend();
	}

}
