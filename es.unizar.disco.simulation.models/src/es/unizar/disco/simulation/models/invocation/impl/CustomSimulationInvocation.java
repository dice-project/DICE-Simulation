package es.unizar.disco.simulation.models.invocation.impl;

import org.eclipse.emf.common.util.URI;

import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class CustomSimulationInvocation extends SimulationInvocationImpl implements SimulationInvocation {

	@Override
	public URI getDomainResource() {
		if (getDefinition() != null && getDefinition().getDomainResource() != null) {
			return getDefinition().getDomainResource().getUri();
		}
		return null;
	}
	
}
