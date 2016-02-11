package es.unizar.disco.core.ui.dialogs;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.core.ui.dialogs.messages"; //$NON-NLS-1$
	public static String FileSelectionDialog_dialogMessage;
	public static String FileSelectionDialog_dialogTitle;
	public static String FileSelectionDialog_notFileError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
