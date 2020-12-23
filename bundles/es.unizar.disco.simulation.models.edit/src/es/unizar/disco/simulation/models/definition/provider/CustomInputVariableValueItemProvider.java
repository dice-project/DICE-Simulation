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
package es.unizar.disco.simulation.models.definition.provider;


import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.definition.InputVariableValue;

public class CustomInputVariableValueItemProvider extends InputVariableValueItemProvider {

	public CustomInputVariableValueItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		Number labelValue = ((InputVariableValue)object).getValue();
		return labelValue != null ? labelValue.toString() : "";
	}
}
