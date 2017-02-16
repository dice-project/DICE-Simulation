package es.unizar.disco.ssh.ui.internal;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.ssh.ui.DiceSshConnectorUiPlugin;

public class SecurePreferenceStoreDelegate implements IPersistentPreferenceStore {

	private static final String DEFAULT_PREFERENCES = "default-values"; //$NON-NLS-1$
	
	private Set<IPropertyChangeListener> listeners = new HashSet<>();
	private ISecurePreferences preferences;
	private ISecurePreferences defaultPreferences;
	private boolean isDirty = false;
	private final boolean encrypt;

	public SecurePreferenceStoreDelegate(ISecurePreferences securePreferences, boolean encrypt) {
		this.preferences = securePreferences;
		this.encrypt = encrypt;
		this.defaultPreferences = securePreferences.node(DEFAULT_PREFERENCES);
	}
	
	@Override
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void firePropertyChangeEvent(String name, Object oldValue, Object newValue) {
		for (IPropertyChangeListener listener : listeners) {
			listener.propertyChange(new PropertyChangeEvent(this, name, oldValue, newValue));
		}
	}

	@Override
	public boolean contains(String name) {
		return Arrays.asList(preferences.keys()).contains(name) || Arrays.asList(defaultPreferences.keys()).contains(name) ;
	}

	@Override
	public void setToDefault(String name) {
		if (!Arrays.asList(preferences.keys()).contains(name)) {
			return;
		} else {
			String oldValue = getString(name);
			preferences.remove(name);
			isDirty = true;
			firePropertyChangeEvent(name, oldValue, null);
		}
	}

	@Override
	public boolean isDefault(String name) {
		return !Arrays.asList(preferences.keys()).contains(name) && Arrays.asList(defaultPreferences.keys()).contains(name);
	}

	@Override
	public boolean needsSaving() {
		return isDirty;
	}
	
	@Override
	public void save() throws IOException {
		preferences.flush();
		defaultPreferences.flush();
		isDirty = false;
	}

	@Override
	public boolean getBoolean(String name) {
		try {
			return preferences.getBoolean(name, getDefaultBoolean(name));
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return BOOLEAN_DEFAULT_DEFAULT;
	}

	@Override
	public double getDouble(String name) {
		try {
			return preferences.getDouble(name, getDefaultDouble(name));
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return DOUBLE_DEFAULT_DEFAULT;
	}

	@Override
	public float getFloat(String name) {
		try {
			return preferences.getFloat(name, getDefaultFloat(name));
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return FLOAT_DEFAULT_DEFAULT;
	}

	@Override
	public int getInt(String name) {
		try {
			return preferences.getInt(name, getDefaultInt(name));
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return INT_DEFAULT_DEFAULT;
	}

	@Override
	public long getLong(String name) {
		try {
			return preferences.getLong(name, getDefaultLong(name));
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return LONG_DEFAULT_DEFAULT;
	}

	@Override
	public String getString(String name) {
		try {
			return preferences.get(name, getDefaultString(name));
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return STRING_DEFAULT_DEFAULT;
	}

	@Override
	public boolean getDefaultBoolean(String name) {
		try {
			return defaultPreferences.getBoolean(name, BOOLEAN_DEFAULT_DEFAULT);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return BOOLEAN_DEFAULT_DEFAULT;
	}

	@Override
	public double getDefaultDouble(String name) {
		try {
			return defaultPreferences.getDouble(name, DOUBLE_DEFAULT_DEFAULT);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return DOUBLE_DEFAULT_DEFAULT;
	}

	@Override
	public float getDefaultFloat(String name) {
		try {
			return defaultPreferences.getFloat(name, FLOAT_DEFAULT_DEFAULT);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return FLOAT_DEFAULT_DEFAULT;
	}

	@Override
	public int getDefaultInt(String name) {
		try {
			return defaultPreferences.getInt(name, INT_DEFAULT_DEFAULT);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return INT_DEFAULT_DEFAULT;
	}

	@Override
	public long getDefaultLong(String name) {
		try {
			return defaultPreferences.getLong(name, LONG_DEFAULT_DEFAULT);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return LONG_DEFAULT_DEFAULT;
	}

	@Override
	public String getDefaultString(String name) {
		try {
			return defaultPreferences.get(name, STRING_DEFAULT_DEFAULT);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableDecryptValueError, name), e);
		}
		return STRING_DEFAULT_DEFAULT;
	}

	@Override
	public void setDefault(String name, double value) {
		try {
			defaultPreferences.putDouble(name, value, encrypt);
			isDirty = true;
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setDefault(String name, float value) {
		try {
			defaultPreferences.putFloat(name, value, encrypt);
			isDirty = true;
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setDefault(String name, int value) {
		try {
			defaultPreferences.putInt(name, value, encrypt);
			isDirty = true;
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setDefault(String name, long value) {
		try {
			defaultPreferences.putLong(name, value, encrypt);
			isDirty = true;
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setDefault(String name, String defaultObject) {
		try {
			defaultPreferences.put(name, defaultObject, encrypt);
			isDirty = true;
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setDefault(String name, boolean value) {
		try {
			defaultPreferences.putBoolean(name, value, encrypt);
			isDirty = true;
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}			
	}

	@Override
	public void setValue(String name, double value) {
		try {
			Double oldValue = null;
			if (contains(name)) {
				oldValue = preferences.getDouble(name, DOUBLE_DEFAULT_DEFAULT);
			}
			preferences.putDouble(name, value, encrypt);
			isDirty = true;
			firePropertyChangeEvent(name, oldValue, value);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setValue(String name, float value) {
		try {
			Float oldValue = null;
			if (contains(name)) {
				oldValue = preferences.getFloat(name, FLOAT_DEFAULT_DEFAULT);
			}
			preferences.putFloat(name, value, encrypt);
			isDirty = true;
			firePropertyChangeEvent(name, oldValue, value);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setValue(String name, int value) {
		try {
			Integer oldValue = null;
			if (contains(name)) {
				oldValue = preferences.getInt(name, INT_DEFAULT_DEFAULT);
			}
			preferences.putInt(name, value, encrypt);
			isDirty = true;
			firePropertyChangeEvent(name, oldValue, value);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setValue(String name, long value) {
		try {
			Long oldValue = null;
			if (contains(name)) {
				oldValue = preferences.getLong(name, LONG_DEFAULT_DEFAULT);
			}
			preferences.putLong(name, value, encrypt);
			isDirty = true;
			firePropertyChangeEvent(name, oldValue, value);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setValue(String name, String value) {
		try {
			String oldValue = null;
			if (contains(name)) {
				oldValue = preferences.get(name, STRING_DEFAULT_DEFAULT);
			}
			preferences.put(name, value, encrypt);
			isDirty = true;
			firePropertyChangeEvent(name, oldValue, value);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void setValue(String name, boolean value) {
		try {
			Boolean oldValue = null;
			if (contains(name)) {
				oldValue = preferences.getBoolean(name, BOOLEAN_DEFAULT_DEFAULT);
			}
			preferences.putBoolean(name, value, encrypt);
			isDirty = true;
			firePropertyChangeEvent(name, oldValue, value);
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}

	@Override
	public void putValue(String name, String value) {
		try {
			preferences.put(name, value, encrypt);
			isDirty = true;
		} catch (StorageException e) {
			DiceLogger.logException(DiceSshConnectorUiPlugin.getDefault(), MessageFormat.format(Messages.SecurePreferenceStoreDelegate_unableStoreValueError, name), e);
		}
	}
	
}