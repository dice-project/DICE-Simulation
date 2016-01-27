package es.unizar.disco.ssh.ui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.ssh.ui.internal.SecurePreferenceStoreDelegate;
import es.unizar.disco.ssh.ui.preferences.PreferenceConstants;
import es.unizar.disco.ssh.ui.preferences.PreferenceConstants.PreferenceType;

/**
 * The activator class controls the plug-in life cycle
 */
public class DiceSshConnectorUiPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "es.unizar.disco.ssh.ui"; //$NON-NLS-1$

	// The shared instance
	private static DiceSshConnectorUiPlugin plugin;
	
	private IPreferenceStore store;
	
	/**
	 * The constructor
	 */
	public DiceSshConnectorUiPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static DiceSshConnectorUiPlugin getDefault() {
		return plugin;
	}
	
	@Override
	public IPreferenceStore getPreferenceStore() {
		if (store == null) {
			try {
				store = new SecurePreferenceStoreDecorator(super.getPreferenceStore());
			} catch (IOException e) {
				DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), e);
				store = super.getPreferenceStore();
			}
		}
		return store;
	}
	
	private static class SecurePreferenceStoreDecorator implements IPersistentPreferenceStore {
		
		private static final URI LOCATION = getDefault().getStateLocation().append("secure.store").toFile().toURI();
		
		private final IPreferenceStore plainStore;
		private final IPreferenceStore securePlainStore;
		private final IPreferenceStore secureEncryptedStore;

		public SecurePreferenceStoreDecorator(IPreferenceStore store) throws MalformedURLException, IOException {
			this.plainStore = store;
			this.securePlainStore = new SecurePreferenceStoreDelegate(SecurePreferencesFactory.open(LOCATION.toURL(), null), false);
			this.secureEncryptedStore = new SecurePreferenceStoreDelegate(SecurePreferencesFactory.open(LOCATION.toURL(), null), true);
		}
		
		public void addPropertyChangeListener(IPropertyChangeListener listener) {
			plainStore.addPropertyChangeListener(listener);
			securePlainStore.addPropertyChangeListener(listener);
			secureEncryptedStore.addPropertyChangeListener(listener);
		}
		public boolean contains(String name) {
			return plainStore.contains(name) || securePlainStore.contains(name) || secureEncryptedStore.contains(name);
		}
		public void firePropertyChangeEvent(String name, Object oldValue, Object newValue) {
			getStoreFor(name).firePropertyChangeEvent(name, oldValue, newValue);
		}
		public boolean getBoolean(String name) {
			return getStoreFor(name).getBoolean(name);
		}
		public boolean getDefaultBoolean(String name) {
			return getStoreFor(name).getDefaultBoolean(name);
		}
		public double getDefaultDouble(String name) {
			return getStoreFor(name).getDefaultDouble(name);
		}
		public float getDefaultFloat(String name) {
			return getStoreFor(name).getDefaultFloat(name);
		}
		public int getDefaultInt(String name) {
			return getStoreFor(name).getDefaultInt(name);
		}
		public long getDefaultLong(String name) {
			return getStoreFor(name).getDefaultLong(name);
		}
		public String getDefaultString(String name) {
			return getStoreFor(name).getDefaultString(name);
		}
		public double getDouble(String name) {
			return getStoreFor(name).getDouble(name);
		}
		public float getFloat(String name) {
			return getStoreFor(name).getFloat(name);
		}
		public int getInt(String name) {
			return getStoreFor(name).getInt(name);
		}
		public long getLong(String name) {
			return getStoreFor(name).getLong(name);
		}
		public String getString(String name) {
			return getStoreFor(name).getString(name);
		}
		public boolean isDefault(String name) {
			return getStoreFor(name).isDefault(name);
		}
		public boolean needsSaving() {
			return plainStore.needsSaving() || securePlainStore.needsSaving() || secureEncryptedStore.needsSaving();
		}
		public void putValue(String name, String value) {
			getStoreFor(name).putValue(name, value);
		}
		public void removePropertyChangeListener(IPropertyChangeListener listener) {
			plainStore.removePropertyChangeListener(listener);
			securePlainStore.removePropertyChangeListener(listener);
			secureEncryptedStore.removePropertyChangeListener(listener);
		}
		public void setDefault(String name, double value) {
			getStoreFor(name).setDefault(name, value);
		}
		public void setDefault(String name, float value) {
			getStoreFor(name).setDefault(name, value);
		}
		public void setDefault(String name, int value) {
			getStoreFor(name).setDefault(name, value);
		}
		public void setDefault(String name, long value) {
			getStoreFor(name).setDefault(name, value);
		}
		public void setDefault(String name, String defaultObject) {
			getStoreFor(name).setDefault(name, defaultObject);
		}
		public void setDefault(String name, boolean value) {
			getStoreFor(name).setDefault(name, value);
		}
		public void setToDefault(String name) {
			getStoreFor(name).setToDefault(name);
		}
		public void setValue(String name, double value) {
			getStoreFor(name).setValue(name, value);
		}
		public void setValue(String name, float value) {
			getStoreFor(name).setValue(name, value);
		}
		public void setValue(String name, int value) {
			getStoreFor(name).setValue(name, value);
		}
		public void setValue(String name, long value) {
			getStoreFor(name).setValue(name, value);
		}
		public void setValue(String name, String value) {
			getStoreFor(name).setValue(name, value);
		}
		public void setValue(String name, boolean value) {
			getStoreFor(name).setValue(name, value);
		}
		
		private IPreferenceStore getStoreFor(String preference) {
			if (PreferenceConstants.getEnum(preference).getType() == PreferenceType.SECURE_PLAIN) {
				return securePlainStore;
			} else if (PreferenceConstants.getEnum(preference).getType() == PreferenceType.SECURE_ENCRYPTED) {
				return secureEncryptedStore;
			} else {
				return plainStore;
			}
		}
		@Override
		public void save() throws IOException {
			if (plainStore instanceof IPersistentPreferenceStore) {
				((IPersistentPreferenceStore) plainStore).save();
			}
			if (securePlainStore instanceof IPersistentPreferenceStore) {
				((IPersistentPreferenceStore) securePlainStore).save();
			}
			if (secureEncryptedStore instanceof IPersistentPreferenceStore) {
				((IPersistentPreferenceStore) secureEncryptedStore).save();
			}
		}
	}
}
