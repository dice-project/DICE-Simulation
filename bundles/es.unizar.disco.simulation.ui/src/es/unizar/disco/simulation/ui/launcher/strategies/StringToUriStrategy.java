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
package es.unizar.disco.simulation.ui.launcher.strategies;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.emf.common.util.URI;

public class StringToUriStrategy extends UpdateValueStrategy {
	@Override
	public Object convert(Object value) {
		return StringUtils.isNotBlank((String) value) ? URI.createURI(value.toString()) : null;
	}
}

