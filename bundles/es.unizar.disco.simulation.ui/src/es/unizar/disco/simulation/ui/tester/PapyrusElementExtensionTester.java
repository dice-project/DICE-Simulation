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
package es.unizar.disco.simulation.ui.tester;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;

public class PapyrusElementExtensionTester extends PropertyTester {

	private static final String EXTENSION_PROPERTY = "extension";

	public PapyrusElementExtensionTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		IResource resource = Platform.getAdapterManager().getAdapter(receiver, IResource.class);
		if (resource != null && EXTENSION_PROPERTY.equals(property)) {
			return StringUtils.equals(resource.getFileExtension(), (String) expectedValue);
		}
		return false;
	}
}
