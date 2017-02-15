package es.unizar.disco.simulation.models.invocation.impl;

import es.unizar.disco.simulation.models.invocation.CustomInvocationFactory;
import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class CustomInvocationFactoryImpl extends InvocationFactoryImpl implements CustomInvocationFactory {

	@Override
	public SimulationInvocation createSimulationInvocation() {
		return new CustomSimulationInvocationImpl();
	}
	
	@Override
	public InvocationSet createInvocationSet() {
		return new CustomInvocationSetImpl();
	}
	
}
