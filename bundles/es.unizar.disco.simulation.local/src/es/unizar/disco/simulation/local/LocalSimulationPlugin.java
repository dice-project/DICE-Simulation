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
