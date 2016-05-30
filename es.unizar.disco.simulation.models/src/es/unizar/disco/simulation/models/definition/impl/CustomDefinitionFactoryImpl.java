package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.definition.CustomDefinitionFactory;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;

public class CustomDefinitionFactoryImpl extends DefinitionFactoryImpl implements CustomDefinitionFactory {

	public CustomDefinitionFactoryImpl() {
		super();
	}
	
	@Override
	public SimulationDefinition createSimulationDefinition() {
		SimulationDefinition simulationDefinition = new CustomSimulationDefinitionImpl();
		return simulationDefinition;
	}
	
	@Override
	public InputVariable createInputVariable() {
		InputVariable inputVariable = new CustomInputVariableImpl();
		return inputVariable;
	}
	
}

