package es.unizar.disco.simulation.ui.tester;

import org.eclipse.core.expressions.PropertyTester;

import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class InvocationHasResultTester extends PropertyTester {

	private static final String EXTENSION_PROPERTY = "hasResult";
	
	public InvocationHasResultTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof SimulationInvocation) {
			SimulationInvocation invocation = (SimulationInvocation) receiver;
			if (EXTENSION_PROPERTY.equals(property) && invocation.getResult() != null) {
				return true;
			}
		}
		return false;
	}

}
