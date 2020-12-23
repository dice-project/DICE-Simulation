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
package es.unizar.disco.simulation.ui.launcher.providers;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

public class DelegatedColumnLabelProvider extends ColumnLabelProvider {
	
	protected ILabelProvider labelProvider;
	
	public DelegatedColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
		this.labelProvider = delegatedLabelProvider;
	}

	@Override
	public String getText(Object element) {
		return labelProvider.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		return labelProvider.getImage(element);
	}
}