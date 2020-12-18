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

import java.util.UUID;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class NewViewHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchSite site = HandlerUtil.getActiveSiteChecked(event);
		IWorkbenchPage page = site.getPage();
		try {
			page.showView(InvocationsView.ID, UUID.randomUUID().toString(), IWorkbenchPage.VIEW_ACTIVATE);
		} catch (PartInitException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		}
		return null;
	}

}
