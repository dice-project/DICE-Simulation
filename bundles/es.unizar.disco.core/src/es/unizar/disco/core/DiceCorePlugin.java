package es.unizar.disco.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class DiceCorePlugin extends Plugin {


	public static final String PLUGIN_ID = "es.unizar.disco.core"; //$NON-NLS-1$

	private static DiceCorePlugin plugin;
	
	/**
	 * The constructor.
	 */
	public DiceCorePlugin() {
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
	public static DiceCorePlugin getDefault() {
		return plugin;
	}


}
