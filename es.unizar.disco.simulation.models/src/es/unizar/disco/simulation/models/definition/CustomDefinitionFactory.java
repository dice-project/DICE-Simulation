package es.unizar.disco.simulation.models.definition;

public interface CustomDefinitionFactory extends DefinitionFactory {

	@Override
	SimulationDefinition createSimulationDefinition();
	
	@Override
	InputVariable createInputVariable();
	
	@Override
	VariableConfiguration createVariableConfiguration();
}
