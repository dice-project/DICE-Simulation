package es.unizar.disco.simulation.models.definition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.definition.VariableAssignment;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;

public class CustomVariableConfigurationItemProvider extends VariableConfigurationItemProvider {

	public CustomVariableConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		VariableConfiguration config = (VariableConfiguration) object;
		StringBuilder builder = new StringBuilder();
		builder.append(getString("_UI_VariableConfiguration_type"));
		if (!config.getAssignments().isEmpty()) {
			builder.append(": ");
			for (VariableAssignment assignment : config.getAssignments()) {
				builder.append(assignment.getVariable().getName());
				builder.append("=");
				builder.append(assignment.getValue().getValue());
				builder.append(", ");
			}
			builder.setLength(builder.length() - 2);
		}
		return builder.toString();
	}
}
