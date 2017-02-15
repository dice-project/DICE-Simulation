package es.unizar.disco.simulation.models.simresult.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.simresult.SimulationResult;

public class CustomSimulationResultItemProvider extends SimulationResultItemProvider {

	public CustomSimulationResultItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		StringBuilder builder = new StringBuilder(getString("_UI_SimulationResult_type"));
		SimulationResult result = (SimulationResult) object;
		builder.append(result.getInvocation() != null ? " " + result.getInvocation().getIdentifier() : " (no identifier available)");
		return builder.toString();
	}

}
