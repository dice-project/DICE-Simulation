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

import java.text.MessageFormat;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class RefreshViewHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = HandlerUtil.getActiveSite(event).getPage().getActivePart();
		if (part instanceof InvocationsView) {
			InvocationsView view = (InvocationsView) part;
			view.refresh();
		} else {
			DiceLogger.logError(DiceSimulationUiPlugin.getDefault(), MessageFormat.format(
					"Unexpected part. Expecting expecting ''{0}'' but found ''{1}'' ", InvocationsView.ID, part));
		}
		return null;
	}

}
