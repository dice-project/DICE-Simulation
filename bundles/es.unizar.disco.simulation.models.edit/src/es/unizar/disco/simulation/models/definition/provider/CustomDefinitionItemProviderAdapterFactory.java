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

import org.eclipse.emf.common.notify.Adapter;


public class CustomDefinitionItemProviderAdapterFactory extends DefinitionItemProviderAdapterFactory {

	@Override
	public Adapter createInputVariableAdapter() {
		if (inputVariableItemProvider == null) {
			inputVariableItemProvider = new CustomInputVariableItemProvider(this);
		}

		return inputVariableItemProvider;
	}
	
	@Override
	public Adapter createInputVariableValueAdapter() {
		if (inputVariableValueItemProvider == null) {
			inputVariableValueItemProvider = new CustomInputVariableValueItemProvider(this);
		}
		
		return inputVariableValueItemProvider;
	}
	
	@Override
	public Adapter createVariableConfigurationAdapter() {
		if (variableConfigurationItemProvider == null) {
			variableConfigurationItemProvider = new CustomVariableConfigurationItemProvider(this);
		}
		
		return variableConfigurationItemProvider;
	}
	
	@Override
	public Adapter createVariableAssignmentAdapter() {
		if (variableAssignmentItemProvider == null) {
			variableAssignmentItemProvider = new CustomVariableAssignmentItemProvider(this);
		}
		
		return variableAssignmentItemProvider;
	}
}
