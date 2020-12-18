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
package es.unizar.disco.simulation.ui.editors;

import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPage;

public class DummyActionBarContributor extends EditingDomainActionBarContributor {
	
	public DummyActionBarContributor() {
	}
	
	@Override
	public void shareGlobalActions(IPage page, IActionBars actionBars) {
	}
	
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
	}
}