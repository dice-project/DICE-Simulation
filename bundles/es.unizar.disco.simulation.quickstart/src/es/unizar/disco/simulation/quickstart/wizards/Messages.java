package es.unizar.disco.simulation.quickstart.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.quickstart.wizards.messages"; //$NON-NLS-1$
	public static String ImportExampleProjectWizard_caseInsensitiveExistsError;
	public static String ImportExampleProjectWizard_description;
	public static String ImportExampleProjectWizard_generalProblem;
	public static String ImportExampleProjectWizard_internalError;
	public static String ImportExampleProjectWizard_operationLabel;
	public static String ImportExampleProjectWizard_title;
	public static String ImportExampleProjectWizard_unableCreateContainersError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
