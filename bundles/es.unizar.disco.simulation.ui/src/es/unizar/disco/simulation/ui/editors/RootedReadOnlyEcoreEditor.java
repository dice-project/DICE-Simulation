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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;

public class RootedReadOnlyEcoreEditor extends EcoreEditor {
	
	public static final String ID = "es.unizar.disco.simulation.ui.editors.readonlyEcoreEditor";

	public void createModel() {
		super.createModel();
		URI resourceURI = EditUIUtil.getURI(getEditorInput(), editingDomain.getResourceSet().getURIConverter());
		editingDomain.getResourceToReadOnlyMap().put(editingDomain.getResourceSet().getResource(resourceURI, true), true);
	}
	
	@Override
	public void createPages() {
		super.createPages();
		URI resourceURI = EditUIUtil.getURI(getEditorInput(), editingDomain.getResourceSet().getURIConverter());
		selectionViewer.setInput(editingDomain.getResourceSet().getResource(resourceURI, true));
	}
	
	@Override
	protected void handleActivateGen() {
		// Do nothing, to avoid resetting the readonly state of resources in the AdapterFactoryEditingDomain
	}

	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.create();
		saveAsDialog.setMessage(EcoreEditorPlugin.INSTANCE.getString("_UI_SaveAs_message"));
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				Resource currentResource = resourceSet.getResources().get(0);
				URI newURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				
				Resource newResource = resourceSet.createResource(newURI);
				newResource.getContents().addAll(EcoreUtil.copyAll(currentResource.getContents()));
				resourceSet.getResources().remove(0);
				resourceSet.getResources().move(0, newResource);

				IFileEditorInput modelFile = new FileEditorInput(file);
				setInputWithNotify(modelFile);
				setPartName(file.getName());
				doSave(getActionBars().getStatusLineManager().getProgressMonitor());
			}
		}
	}
}