package es.unizar.disco.simulation.models;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class DiceModelsPlugin extends Plugin {
	
	public static final String PLUGIN_ID = "es.unizar.disco.simulation.models"; //$NON-NLS-1$

	private static DiceModelsPlugin plugin;

	/**
	 * The constructor.
	 */
	public DiceModelsPlugin() {
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
	public static DiceModelsPlugin getDefault() {
		return plugin;
	}
}
