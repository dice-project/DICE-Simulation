package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.datatypes.Resource;
import es.unizar.disco.simulation.models.datatypes.impl.DatatypesFactoryImpl;
import es.unizar.disco.simulation.models.definition.CustomDatatypesFactory;

public class CustomDatatypesFactoryImpl extends DatatypesFactoryImpl implements CustomDatatypesFactory {

	public CustomDatatypesFactoryImpl() {
		super();
	}
	
	@Override
	public Resource createResource() {
		Resource resource = new CustomResourceImpl();
		return resource;
	}
}

