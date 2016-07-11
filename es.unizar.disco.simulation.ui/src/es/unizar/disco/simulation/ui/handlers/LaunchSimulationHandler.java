package es.unizar.disco.simulation.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import es.unizar.disco.simulation.ui.launcher.SimulationLaunchShortcut;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class LaunchSimulationHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public LaunchSimulationHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ILaunchShortcut launchShortcut = new SimulationLaunchShortcut();
		launchShortcut.launch(window.getActivePage().getActiveEditor(), ILaunchManager.RUN_MODE);
		return null;
	}
}
