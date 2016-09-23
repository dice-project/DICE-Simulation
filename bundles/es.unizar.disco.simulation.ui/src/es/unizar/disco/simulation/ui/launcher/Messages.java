package es.unizar.disco.simulation.ui.launcher;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.ui.launcher.messages"; //$NON-NLS-1$
	public static String MainLaunchConfigurationTab_browseLabel;
	public static String MainLaunchConfigurationTab_mainTabTitle;
	public static String MainLaunchConfigurationTab_modelLabel;
	public static String MainLaunchConfigurationTab_NFPtoCalculate;
	public static String SimulationLaunchShortcut_unexpectedArgError;
	public static String SimulationLaunchShortcut_unknownModeError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
