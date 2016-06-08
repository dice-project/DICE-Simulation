package es.unizar.disco.simulation.models.datatypes;

import es.unizar.disco.simulation.models.datatypes.DatatypesFactory;
import es.unizar.disco.simulation.models.datatypes.Resource;

public interface CustomDatatypesFactory extends DatatypesFactory {

	@Override
	Resource createResource();
	
}
