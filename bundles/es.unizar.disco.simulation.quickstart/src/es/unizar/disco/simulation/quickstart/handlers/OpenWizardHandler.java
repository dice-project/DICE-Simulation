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
package es.unizar.disco.simulation.quickstart.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.quickstart.DiceQuickStartUiPlugin;
import es.unizar.disco.simulation.quickstart.wizards.ImportExampleProjectWizard;

public class OpenWizardHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(ImportExampleProjectWizard.WIZARD_ID);
		try {
			if (descriptor != null) {
				IWizard wizard = descriptor.createWizard();
				Shell shell = Display.getCurrent() != null ? Display.getCurrent().getActiveShell() : Display.getDefault().getActiveShell();
				WizardDialog wd = new WizardDialog(shell.getShell(), wizard);
				wd.setTitle(wizard.getWindowTitle());
				wd.open();
			}
		} catch (CoreException e) {
			DiceLogger.logException(DiceQuickStartUiPlugin.getDefault(), e);
		}
		return null;
	}

}
