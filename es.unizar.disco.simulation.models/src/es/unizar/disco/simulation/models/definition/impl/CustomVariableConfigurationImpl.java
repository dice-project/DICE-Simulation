package es.unizar.disco.simulation.models.definition.impl;

import java.util.HashMap;
import java.util.Map;

import es.unizar.disco.simulation.models.definition.VariableAssignment;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;

public class CustomVariableConfigurationImpl extends VariableConfigurationImpl implements VariableConfiguration {

	@Override
	public boolean isEquivalent(VariableConfiguration config) {
		if (config.getAssignments().size() != this.getAssignments().size()) {
			return false;
		} else {
			Map<String, Number> thisAssignments = new HashMap<String, Number>();
			for (VariableAssignment assignment : this.getAssignments()) {
				thisAssignments.put(assignment.getVariable().getName(), assignment.getValue().getValue());
			}
			Map<String, Number> otherAssignments = new HashMap<String, Number>();
			for (VariableAssignment assignment : config.getAssignments()) {
				otherAssignments.put(assignment.getVariable().getName(), assignment.getValue().getValue());
			}
			return thisAssignments.entrySet().containsAll(otherAssignments.entrySet());
		}
	}
	
}
