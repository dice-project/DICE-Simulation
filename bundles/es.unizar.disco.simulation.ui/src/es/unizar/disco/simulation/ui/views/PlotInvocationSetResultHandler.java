/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
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
