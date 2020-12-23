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
package es.unizar.disco.simulation.models.delegates;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate;

public class UriConversionDelegate implements ConversionDelegate {

	public static class Factory implements EDataType.Internal.ConversionDelegate.Factory {
		@Override
		public ConversionDelegate createConversionDelegate(EDataType eDataType) {
			return new UriConversionDelegate();
		}
	}
	
	@Override
	public String convertToString(Object value) {
		return value != null ?  value.toString() : null;
	}

	@Override
	public Object createFromString(String literal) {
		return URI.createURI(literal);
	}
}