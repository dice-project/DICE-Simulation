package es.unizar.disco.simulation.models.definition.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import es.unizar.disco.simulation.models.datatypes.DatatypesFactory;
import es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment;
import es.unizar.disco.simulation.models.definition.InputVariable;
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

	@Override
	public EList<PrimitiveVariableAssignment> toPrimitiveAssignments() {
		EList<PrimitiveVariableAssignment> assignments = new BasicEList<>();
		for (VariableAssignment assignment : getAssignments()) {
			PrimitiveVariableAssignment primitiveAssignment = DatatypesFactory.eINSTANCE.createPrimitiveVariableAssignment();
			primitiveAssignment.setVariable("$" + assignment.getVariable().getName());
			primitiveAssignment.setValue(assignment.getValue().getValue());
			assignments.add(primitiveAssignment);
		}
		return ECollections.unmodifiableEList(assignments);
	}
	
	@Override
	public VariableAssignment findAssignment(InputVariable variable) {
		for (VariableAssignment assignment : getAssignments()) {
			if (variable.equals(assignment.getVariable())) {
				return assignment;
			}
		}
		return null;
	}
}
