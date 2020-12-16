package es.unizar.disco.simulation.models.datatypes.impl;

import es.unizar.disco.simulation.models.datatypes.CustomDatatypesFactory;
import es.unizar.disco.simulation.models.datatypes.Resource;

public class CustomDatatypesFactoryImpl extends DatatypesFactoryImpl implements CustomDatatypesFactory {

	public CustomDatatypesFactoryImpl() {
		super();
	}
	
	@Override
	public Resource createResource() {
		return new CustomResourceImpl();
	}
}

