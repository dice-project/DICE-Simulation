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
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.definition.CustomDefinitionFactory;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;

public class CustomDefinitionFactoryImpl extends DefinitionFactoryImpl implements CustomDefinitionFactory {

	public CustomDefinitionFactoryImpl() {
		super();
	}
	
	@Override
	public SimulationDefinition createSimulationDefinition() {
		return new CustomSimulationDefinitionImpl();
	}
	
	@Override
	public InputVariable createInputVariable() {
		return new CustomInputVariableImpl();
	}
	
	@Override
	public VariableConfiguration createVariableConfiguration() {
		return new CustomVariableConfigurationImpl();
	}
}

