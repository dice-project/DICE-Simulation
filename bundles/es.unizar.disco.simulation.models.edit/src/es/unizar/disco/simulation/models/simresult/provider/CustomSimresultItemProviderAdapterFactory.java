package es.unizar.disco.simulation.models.simresult.provider;

import org.eclipse.emf.common.notify.Adapter;

public class CustomSimresultItemProviderAdapterFactory extends SimresultItemProviderAdapterFactory {

	@Override
	public Adapter createSimulationResultAdapter() {
		if (simulationResultItemProvider == null) {
			simulationResultItemProvider = new CustomSimulationResultItemProvider(this);
		}
		
		return simulationResultItemProvider;
	}
}
