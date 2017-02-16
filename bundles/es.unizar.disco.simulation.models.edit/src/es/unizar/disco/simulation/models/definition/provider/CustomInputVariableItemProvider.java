package es.unizar.disco.simulation.models.definition.provider;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;

public class CustomInputVariableItemProvider extends InputVariableItemProvider {

	public CustomInputVariableItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		InputVariable inputVariable = (InputVariable) object;
		StringBuilder builder = new StringBuilder(super.getText(object));
		if (!inputVariable.getValues().isEmpty()) {
			builder.append(" = { ");
			for (InputVariableValue value : inputVariable.getValues()) {
				builder.append(EcoreUtil.convertToString(DatatypesPackage.Literals.NUMBER, value.getValue()));
				builder.append(", ");
			}
			builder.setLength(builder.length() - 2);
			builder.append(" }");
		}
		return builder.toString();
	}
}
