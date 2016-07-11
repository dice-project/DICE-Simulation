package es.unizar.disco.simulation.models.definition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.definition.VariableAssignment;

public class CustomVariableAssignmentItemProvider extends VariableAssignmentItemProvider {

	public CustomVariableAssignmentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		StringBuilder builder = new StringBuilder(getString("_UI_VariableAssignment_type"));
		VariableAssignment assignment = (VariableAssignment) object;
		if (assignment != null) {
			builder.append(": ");
			if (assignment.getVariable() != null) {
				builder.append(assignment.getVariable().getName());
			}
			builder.append("=");
			if (assignment.getValue() != null) {
				builder.append(assignment.getValue().getValue());
			}
		}
		return builder.toString();
	}

}
