package es.unizar.disco.ssh;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class DiceSshConnectorPlugin extends Plugin {


	public static final String PLUGIN_ID = "es.unizar.disco.ssh"; //$NON-NLS-1$

	private static DiceSshConnectorPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public DiceSshConnectorPlugin() {
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
	public static DiceSshConnectorPlugin getDefault() {
		return plugin;
	}


}