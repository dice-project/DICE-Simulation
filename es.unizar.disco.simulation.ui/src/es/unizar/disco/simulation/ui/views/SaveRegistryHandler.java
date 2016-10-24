package es.unizar.disco.simulation.ui.views;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class SaveRegistryHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShellChecked(event);
		try {
			SimulationInvocationsRegistry.INSTANCE.save();
		} catch (IOException e) {
			ErrorDialog.openError(shell, "Error", "Unable to save registry",
					new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
		}
		return null;
	}

}
