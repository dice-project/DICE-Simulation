package es.unizar.disco.simulation.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class DiceSimulationUiPlugin extends AbstractUIPlugin {

	// Image constants
	public static final String IMG_OBJ16_CLOCK = "IMG_OBJ16_CLOCK"; //$NON-NLS-1$
	public static final String IMG_OBJ16_MAIN_TAB = "IMG_OBJ16_MAIN_TAB"; //$NON-NLS-1$
	public static final String IMG_OBJ16_PARAMS_TAB = "IMG_OBJ16_PARAMS_TAB"; //$NON-NLS-1$
	public static final String IMG_OBJ16_FILTERS_TAB = "IMG_OBJ16_FILTERS_TAB"; //$NON-NLS-1$
	public static final String IMG_OBJ16_ADVANCED_TAB = "IMG_OBJ16_ADVANCED_TAB"; //$NON-NLS-1$
	
	// The plug-in ID
	public static final String PLUGIN_ID = "es.unizar.disco.simulation.ui"; //$NON-NLS-1$

	// The shared instance
	private static DiceSimulationUiPlugin plugin;
	
	/**
	 * The constructor
	 */
	public DiceSimulationUiPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static DiceSimulationUiPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		reg.put(IMG_OBJ16_CLOCK, getImageDescriptor("icons/full/obj16/clock.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_MAIN_TAB, getImageDescriptor("icons/full/obj16/main_tab.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_PARAMS_TAB, getImageDescriptor("icons/full/obj16/params_tab.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_FILTERS_TAB, getImageDescriptor("icons/full/obj16/filters_tab.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_ADVANCED_TAB, getImageDescriptor("icons/full/obj16/advanced_tab.png").createImage()); //$NON-NLS-1$
	}
}
