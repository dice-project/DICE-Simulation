package es.unizar.disco.simulation.models.invocation;

public interface CustomInvocationFactory extends InvocationFactory {
	
	@Override
	SimulationInvocation createSimulationInvocation();

}
