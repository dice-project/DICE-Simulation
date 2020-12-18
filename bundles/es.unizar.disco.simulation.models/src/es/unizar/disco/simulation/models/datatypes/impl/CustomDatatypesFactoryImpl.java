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

import es.unizar.disco.simulation.models.datatypes.CustomDatatypesFactory;
import es.unizar.disco.simulation.models.datatypes.Resource;

public class CustomDatatypesFactoryImpl extends DatatypesFactoryImpl implements CustomDatatypesFactory {

	public CustomDatatypesFactoryImpl() {
		super();
	}
	
	@Override
	public Resource createResource() {
		return new CustomResourceImpl();
	}
}

