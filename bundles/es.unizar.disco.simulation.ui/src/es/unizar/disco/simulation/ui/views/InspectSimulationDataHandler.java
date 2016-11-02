package es.unizar.disco.simulation.ui.views;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.editors.RootedReadOnlyEcoreEditor;

public class InspectSimulationDataHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell shell = HandlerUtil.getActiveShellChecked(event);

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);

		if (selection.getFirstElement() instanceof SimulationInvocation) {
			SimulationInvocation invocation = (SimulationInvocation) selection.getFirstElement();
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			try {
				SimulationInvocationsRegistry.INSTANCE.save();
				page.openEditor(new URIEditorInput(EcoreUtil.getURI(invocation)), RootedReadOnlyEcoreEditor.ID);
			} catch (IOException e) {
				ErrorDialog.openError(shell, "Error", "Unable to save registry data",
						new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
			} catch (PartInitException e) {
				ErrorDialog.openError(shell, "Error", "Unable open Simulation Invocation",
						new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
			}
		}
		return null;
	}

}
