package es.unizar.disco.ssh.providers.local;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.ssh.providers.local.messages"; //$NON-NLS-1$
	public static String LocalConnectionProvider_selfConfigUnsupportedError;
	public static String LocalConnectionProvider_unableFindFileError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
