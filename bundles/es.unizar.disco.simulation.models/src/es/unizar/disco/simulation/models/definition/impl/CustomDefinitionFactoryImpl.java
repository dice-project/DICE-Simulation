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

