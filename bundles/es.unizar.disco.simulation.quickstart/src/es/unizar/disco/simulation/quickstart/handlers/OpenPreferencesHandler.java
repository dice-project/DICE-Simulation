package es.unizar.disco.simulation.quickstart.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.PreferencesUtil;

public class OpenPreferencesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PreferencesUtil.createPreferenceDialogOn(Display.getDefault().getActiveShell(), 
				"es.unizar.disco.ssh.ui.preferences.SshConnectionProviderPreferencePage", null, null).open(); ////$NON-NLS-1$
		return null;
	}

}
