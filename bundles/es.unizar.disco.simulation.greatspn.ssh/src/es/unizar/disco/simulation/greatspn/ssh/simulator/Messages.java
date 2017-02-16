package es.unizar.disco.simulation.greatspn.ssh.simulator;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.greatspn.ssh.simulator.messages"; //$NON-NLS-1$
	public static String GspnSshSimulator_commandNotFinishedError;
	public static String GspnSshSimulator_connClosedError;
	public static String GspnSshSimulator_connInfoNotFoundError;
	public static String GspnSshSimulator_connNotEstablishedError;
	public static String GspnSshSimulator_providerNotFoundError;
	public static String GspnSshSimulator_threadNotStartedError;
	public static String GspnSshSimulator_unableEstablishConnError;
	public static String GspnSshSimulator_unableLaunchError;
	public static String GspnSshSimulator_unableSetupFilesError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
