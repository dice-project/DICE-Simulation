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
