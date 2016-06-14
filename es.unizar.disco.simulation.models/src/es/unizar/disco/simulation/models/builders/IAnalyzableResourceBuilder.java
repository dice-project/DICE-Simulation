package es.unizar.disco.simulation.models.builders;

import org.eclipse.emf.common.util.URI;

import es.unizar.disco.simulation.models.datatypes.Resource;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public interface IAnalyzableResourceBuilder {

	public Resource createAnalyzableResource(SimulationInvocation invocation, URI resourceURI) throws BuildException;
	
}
