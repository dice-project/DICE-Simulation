package es.unizar.disco.simulation.greatspn.ssh;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class GspnSshSimulationPlugin extends Plugin {


	public static final String PLUGIN_ID = "es.unizar.disco.simulation.greatspn.ssh"; //$NON-NLS-1$

	private static GspnSshSimulationPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public GspnSshSimulationPlugin() {
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
	public static GspnSshSimulationPlugin getDefault() {
		return plugin;
	}


}
