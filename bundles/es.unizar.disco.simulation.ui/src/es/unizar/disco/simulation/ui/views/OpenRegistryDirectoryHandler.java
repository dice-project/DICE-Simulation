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

import java.awt.Desktop;
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

public class OpenRegistryDirectoryHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShellChecked(event);
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(SimulationInvocationsRegistry.BASE_LOCATION.toFile());
			} catch (IOException e) {
				ErrorDialog.openError(shell, "Error", "Unable open folder", new Status(
						IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
			}
		}
		return null;
	}

}
