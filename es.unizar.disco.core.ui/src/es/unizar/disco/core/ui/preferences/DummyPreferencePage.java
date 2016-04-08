package es.unizar.disco.core.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class DummyPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public DummyPreferencePage() {
		super(GRID);
		setDescription(Messages.DummyPreferencePage_preferencesDescription);
	}
	
	public void createFieldEditors() {
	}

	public void init(IWorkbench workbench) {
	}
	
}