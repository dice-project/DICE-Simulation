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
package es.unizar.disco.simulation.ui.wizards;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.ui.wizards.PlotWizard.WizardData;

class NewPlotFileCreationPage extends WizardNewFileCreationPage {

	public NewPlotFileCreationPage(WizardData data) {
		super("New Plot File", getDefaultSelection(data.invocationSet));
		setTitle("New Plot File");
		setDescription("Set the plot data file");
		setFileExtension("plot");
		setFileName("data.plot");
		setAllowExistingResources(true);
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		validatePage();
	}

	private static IStructuredSelection getDefaultSelection(InvocationSet invocationSet) {
		try {
			URI uri = invocationSet.getDefinition().getDomainResource().getUri();
			String path = uri.toPlatformString(true);
			return new StructuredSelection(ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path)));
		} catch (Throwable t) {
			// This error can be ignored
			// Nothing to report
		}
		return new StructuredSelection();
	}
}
