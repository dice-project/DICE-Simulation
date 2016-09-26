package es.unizar.disco.simulation.models.invocation.impl;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.models.invocation.impl.messages"; //$NON-NLS-1$
	public static String CustomSimulationInvocation_builderNotFound;
	public static String CustomSimulationInvocation_extPoint_analyzableProperty;
	public static String CustomSimulationInvocation_extPoint_builder;
	public static String CustomSimulationInvocation_extPoint_metaclass;
	public static String CustomSimulationInvocation_extPoint_priority;
	public static String CustomSimulationInvocation_extPoint_scenario;
	public static String CustomSimulationInvocation_nameOfExtPoints;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
