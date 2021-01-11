package org.eclipse.ui.intro.fragment;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.internal.intro.impl.IntroPlugin;

public class QRootePreferenceInitializer extends AbstractPreferenceInitializer {

	public QRootePreferenceInitializer() {
	}

	@Override
	public void initializeDefaultPreferences() {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(IntroPlugin.PLUGIN_ID);
		preferences.put("INTRO_START_PAGE", "qroot");
	}

}
