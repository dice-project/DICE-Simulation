package es.unizar.disco.ssh.ui.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.ssh.ui.internal.messages"; //$NON-NLS-1$
	public static String SecurePreferenceStoreDelegate_unableDecryptValueError;
	public static String SecurePreferenceStoreDelegate_unableStoreValueError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
