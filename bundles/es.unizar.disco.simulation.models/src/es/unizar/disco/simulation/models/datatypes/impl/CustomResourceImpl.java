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
package es.unizar.disco.simulation.models.datatypes.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class CustomResourceImpl extends ResourceImpl {

	private ResourceSet internalResourceSet;

	@Override
	public void setUri(URI newUri) {
		URI oldUri = super.getUri();
		super.setUri(newUri);
		if (newUri != oldUri) {
			resource = null;
		}
	}

	@Override
	public Resource getResource() {
		Resource resource = super.getResource();
		if (resource == null) {
			if (super.getUri() != null) {
				try {
					ResourceSet resourceSet = getResourceSet();
					resource = resourceSet.getResource(super.getUri(), true);
				} catch (Throwable t) {
					// We only care about getting a valid Resource
					// from a domainResourceURI ignoring any error
				}
			}
		}
		return resource;
	}

	private ResourceSet getResourceSet() {
		if (eResource() != null && eResource().getResourceSet() != null) {
			return eResource().getResourceSet();
		}
		if (internalResourceSet == null) {
			internalResourceSet = new ResourceSetImpl();
		}
		return internalResourceSet;
	}
}
