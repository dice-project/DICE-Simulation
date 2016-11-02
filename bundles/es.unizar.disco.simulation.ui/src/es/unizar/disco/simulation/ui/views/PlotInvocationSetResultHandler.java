package es.unizar.disco.simulation.ui.views;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.ui.wizards.PlotWizard;

public class PlotInvocationSetResultHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell shell = HandlerUtil.getActiveShellChecked(event);

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);

		if (selection.getFirstElement() instanceof InvocationSet) {
			InvocationSet invocationSet = (InvocationSet) selection.getFirstElement();
			WizardDialog dialog = new WizardDialog(shell, new PlotWizard(invocationSet));
			dialog.open();
		}
		return null;
	}

}
