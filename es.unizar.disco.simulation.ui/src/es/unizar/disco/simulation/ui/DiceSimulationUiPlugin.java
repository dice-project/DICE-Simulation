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
	public static final String IMG_OBJ16_FAILED = "IMG_OBJ16_FAILED"; //$NON-NLS-1$
	public static final String IMG_OBJ16_FINISHED = "IMG_OBJ16_FINISHED"; //$NON-NLS-1$
	public static final String IMG_OBJ16_RUNNING = "IMG_OBJ16_RUNNING"; //$NON-NLS-1$
	public static final String IMG_OBJ16_WAITING = "IMG_OBJ16_WAITING"; //$NON-NLS-1$
	public static final String IMG_OBJ16_UNKNOWN = "IMG_OBJ16_UNKNOWN"; //$NON-NLS-1$
	public static final String IMG_OBJ16_EMF_EDITOR = "IMG_OBJ16_EMF_EDITOR"; //$NON-NLS-1$
	public static final String IMG_ETOOL16_UP = "IMG_ETOOL16_UP"; //$NON-NLS-1$
	public static final String IMG_ETOOL16_DOWN = "IMG_ETOOL16_DOWN"; //$NON-NLS-1$
	public static final String IMG_ETOOL16_GO_TO_FOLDER = "IMG_ETOOL16_GO_TO_FOLDER"; //$NON-NLS-1$
	public static final String IMG_ETOOL16_REFRESH = "IMG_ETOOL16_REFRESH"; //$NON-NLS-1$
	public static final String IMG_EVIEW16_SIMULATION_REGISTRY = "IMG_EVIEW16_SIMULATION_REGISTRY"; //$NON-NLS-1$
	
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
	private static ImageDescriptor getImageDescriptor(String path) {
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
		reg.put(IMG_OBJ16_FAILED, getImageDescriptor("icons/full/obj16/failed.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_FINISHED, getImageDescriptor("icons/full/obj16/finished.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_RUNNING, getImageDescriptor("icons/full/obj16/running.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_WAITING, getImageDescriptor("icons/full/obj16/waiting.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_UNKNOWN, getImageDescriptor("icons/full/obj16/unknown.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_OBJ16_EMF_EDITOR, getImageDescriptor("icons/full/obj16/emf_editor.gif").createImage()); //$NON-NLS-1$
		reg.put(IMG_ETOOL16_UP, getImageDescriptor("icons/full/etool16/up.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_ETOOL16_DOWN, getImageDescriptor("icons/full/etool16/down.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_ETOOL16_GO_TO_FOLDER, getImageDescriptor("icons/full/etool16/go_to_folder.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_ETOOL16_REFRESH, getImageDescriptor("icons/full/etool16/refresh.png").createImage()); //$NON-NLS-1$
		reg.put(IMG_EVIEW16_SIMULATION_REGISTRY, getImageDescriptor("icons/full/eview16/simulation_registry.png").createImage()); //$NON-NLS-1$
	}
}
