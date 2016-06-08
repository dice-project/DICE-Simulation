package es.unizar.disco.simulation.ui.preferences;

import java.util.List;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class SimulationUiPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public SimulationUiPreferencePage() {
		super(GRID);
		setPreferenceStore(DiceSimulationUiPlugin.getDefault().getPreferenceStore());
		setDescription("Simulation preferences");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		List<String> backends = DiceSimulationPlugin.getDefault().getSimulationBackends();
		String[][] options = new String[backends.size()][2];
		for (int i = 0; i < backends.size(); i++) {
			options[i][0] = backends.get(i);
			options[i][1] = backends.get(i);
		}
		addField(new ComboFieldEditor(PreferenceConstants.BACKEND, 
				"&Preferred Simulation backend:", 
				options,
				getFieldEditorParent()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}