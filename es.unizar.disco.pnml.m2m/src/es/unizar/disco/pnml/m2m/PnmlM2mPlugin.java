package es.unizar.disco.pnml.m2m;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PnmlM2mPlugin implements BundleActivator {
	
	public static final String PLUGIN_ID = "es.unizar.disco.pnml.m2m"; //$NON-NLS-1$

	public static final String DPIM_AD2PNML_TRANSFORMATION_URI = "platform:/plugin/" + PLUGIN_ID + "/transformations/dpim-ad2pnml.qvto"; //$NON-NLS-1$ //$NON-NLS-2$

	public static final String DPIM_SD2PNML_TRANSFORMATION_URI = "platform:/plugin/" + PLUGIN_ID + "/transformations/dpim-sd2pnml.qvto"; //$NON-NLS-1$ //$NON-NLS-2$
	
	public static final String DTSM_STORM_AD2PNML_TRANSFORMATION_URI = "platform:/plugin/" + PLUGIN_ID + "/transformations/dtsm-storm-ad2pnml.qvto"; //$NON-NLS-1$ //$NON-NLS-2$
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		PnmlM2mPlugin.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		PnmlM2mPlugin.context = null;
	}

}
