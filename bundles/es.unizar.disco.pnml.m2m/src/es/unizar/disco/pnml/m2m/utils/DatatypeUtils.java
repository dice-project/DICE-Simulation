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
package es.unizar.disco.pnml.m2m.utils;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

import es.unizar.disco.pnextensions.pnutils.DataTypeUtils;
import es.unizar.disco.pnextensions.pnutils.PnutilsFactory;

public class DatatypeUtils {
	
	private static final DataTypeUtils DATATYPE_UTILS = PnutilsFactory.eINSTANCE.createDataTypeUtils();

	@Operation(contextual=true)
	public static URI createURI(String uri) throws URISyntaxException {
		return DATATYPE_UTILS.createURI(uri);
	}
	
	@Operation(contextual=true)
	public static StringBuffer createLongString(String string) {
		return DATATYPE_UTILS.createLongString(string);
	}
}