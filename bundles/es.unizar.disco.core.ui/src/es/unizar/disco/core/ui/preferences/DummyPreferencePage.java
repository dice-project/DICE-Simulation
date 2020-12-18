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
package es.unizar.disco.core.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class DummyPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public DummyPreferencePage() {
		super(GRID);
		setDescription(Messages.DummyPreferencePage_preferencesDescription);
	}
	
	public void createFieldEditors() {
	}

	public void init(IWorkbench workbench) {
	}
	
}