package es.unizar.disco.simulation.models.wnsim.provider;

import org.eclipse.emf.common.notify.Adapter;

public class CustomWnsimItemProviderAdapterFactory extends WnsimItemProviderAdapterFactory {

	@Override
	public Adapter createWnsimResultAdapter() {
		if (wnsimResultItemProvider == null) {
			wnsimResultItemProvider = new CustomWnsimResultItemProvider(this);
		}
		
		return wnsimResultItemProvider;
	}
	
	@Override
	public Adapter createTransitionInfoAdapter() {
		if (transitionInfoItemProvider == null) {
			transitionInfoItemProvider = new CustomTransitionInfoItemProvider(this);
		}
		
		return transitionInfoItemProvider;
	}
	
	@Override
	public Adapter createPlaceInfoAdapter() {
		if (placeInfoItemProvider == null) {
			placeInfoItemProvider = new CustomPlaceInfoItemProvider(this);
		}
		
		return placeInfoItemProvider;
	}
}
