package es.unizar.disco.simulation.models.measures.impl;

import es.unizar.disco.simulation.models.measures.CustomMeasuresFactory;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;

public class CustomMeasuresFactoryImpl extends MeasuresFactoryImpl implements CustomMeasuresFactory {

	public CustomMeasuresFactoryImpl() {
		super();
	}

	@Override
	public DomainMeasureDefinition createDomainMeasureDefinition() {
		return new CustomDomainMeasureDefinition();
	}

}
