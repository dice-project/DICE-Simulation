package es.unizar.disco.simulation.ui.launcher;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.ui.launcher.messages"; //$NON-NLS-1$
	public static String MainLaunchConfigurationTab_analysisTypeLabel;
	public static String MainLaunchConfigurationTab_browseLabel;
	public static String MainLaunchConfigurationTab_browsLabel;
	public static String MainLaunchConfigurationTab_errorTitle;
	public static String MainLaunchConfigurationTab_inputNotExistsError;
	public static String MainLaunchConfigurationTab_intermediateDirNotExistError;
	public static String MainLaunchConfigurationTab_intermediateFilesLabel;
	public static String MainLaunchConfigurationTab_invalidFloatError;
	public static String MainLaunchConfigurationTab_invalidUmlFileError;
	public static String MainLaunchConfigurationTab_mainTabTitle;
	public static String MainLaunchConfigurationTab_modelLabel;
	public static String MainLaunchConfigurationTab_noDirForIntermediateError;
	public static String MainLaunchConfigurationTab_noInpuntError;
	public static String MainLaunchConfigurationTab_notUml2InputError;
	public static String MainLaunchConfigurationTab_saveIntermediateLabel;
	public static String MainLaunchConfigurationTab_steadyLabel;
	public static String MainLaunchConfigurationTab_transientLabel;
	public static String MainLaunchConfigurationTab_unableParserError;
	public static String MainLaunchConfigurationTab_valueLabel;
	public static String MainLaunchConfigurationTab_variableLabel;
	public static String MainLaunchConfigurationTab_variablesLabel;
	public static String SimulationLaunchShortcut_unexpectedArgError;
	public static String SimulationLaunchShortcut_unknownModeError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
