package es.unizar.disco.simulation.launcher;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.launcher.messages"; //$NON-NLS-1$
	public static String SimulationLaunchConfigurationDelegate_dumpingTaskTitle;
	public static String SimulationLaunchConfigurationDelegate_generatingGspnTaskTitle;
	public static String SimulationLaunchConfigurationDelegate_generatingPnmlTaskTitle;
	public static String SimulationLaunchConfigurationDelegate_invalidLocationError;
	public static String SimulationLaunchConfigurationDelegate_invalidLocationIntermediateFilesError;
	public static String SimulationLaunchConfigurationDelegate_simulatingTaskTilte;
	public static String SimulationLaunchConfigurationDelegate_simulationName;
	public static String SimulationLaunchConfigurationDelegate_simulatorNotFoundError;
	public static String SimulationLaunchConfigurationDelegate_unableCreateTempFileError;
	public static String SimulationLaunchConfigurationDelegate_unableDeserializeError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
