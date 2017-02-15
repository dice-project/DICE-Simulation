package es.unizar.disco.simulation.models.measures.provider;

import org.eclipse.emf.common.notify.Adapter;

public class CustomMeasuresItemProviderAdapterFactory extends MeasuresItemProviderAdapterFactory {
	
	@Override
	public Adapter createDomainMeasureDefinitionAdapter() {
		if (domainMeasureDefinitionItemProvider == null) {
			domainMeasureDefinitionItemProvider = new CustomDomainMeasureDefinitionItemProvider(this);
		}
		
		return domainMeasureDefinitionItemProvider;
	}
	
	@Override
	public Adapter createDomainMeasureAdapter() {
		if (domainMeasureItemProvider == null) {
			domainMeasureItemProvider = new CustomDomainMeasureItemProvider(this);
		}
		
		return domainMeasureItemProvider;
	}
}
