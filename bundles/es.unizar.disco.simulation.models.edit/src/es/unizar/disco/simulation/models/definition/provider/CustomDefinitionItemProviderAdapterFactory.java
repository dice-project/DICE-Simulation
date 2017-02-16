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
