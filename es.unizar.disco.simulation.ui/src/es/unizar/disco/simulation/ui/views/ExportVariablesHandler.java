package es.unizar.disco.simulation.ui.views;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class ExportVariablesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell shell = HandlerUtil.getActiveShellChecked(event);

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);

		if (selection.getFirstElement() instanceof SimulationInvocation) {
			SimulationInvocation invocation = (SimulationInvocation) selection.getFirstElement();
			SaveAsDialog dialog = new SaveAsDialog(shell);
			dialog.setBlockOnOpen(true);
			if (dialog.open() == Window.OK) {
				IPath path = dialog.getResult();
				URI uri = URI.createFileURI(path.toFile().toString());
				Resource resource = new XMIResourceImpl(uri);
				resource.getContents()
						.addAll(EcoreUtil.copyAll(invocation.getVariableConfiguration().toPrimitiveAssignments()));
				try {
					resource.save(Collections.emptyMap());
					IWorkbench workbench = PlatformUI.getWorkbench();
					IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
					page.openEditor(new URIEditorInput(uri), "org.eclipse.emf.ecore.presentation.ReflectiveEditorID");
				} catch (IOException e) {
					ErrorDialog.openError(shell, "Error", "Error saving variable values",
							new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
				} catch (PartInitException e) {
					ErrorDialog.openError(shell, "Error", MessageFormat.format("Unable to open editor for ''{0}''", uri),
							new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
				}
			}
		}
		return null;
	}

}
