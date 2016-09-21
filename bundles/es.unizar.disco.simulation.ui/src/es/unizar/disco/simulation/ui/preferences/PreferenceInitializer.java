package es.unizar.disco.simulation.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = DiceSimulationUiPlugin.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.BACKEND, DiceSimulationPlugin.getDefault().getDefaultSimulationBackend());
	}

}
