package es.unizar.disco.pnml.m2m.utils;
import java.net.URI;
import java.net.URISyntaxException;

import es.unizar.disco.pnextensions.pnutils.DataTypeUtils;
import es.unizar.disco.pnextensions.pnutils.PnutilsFactory;

public class PnmlDatatypesUtil {
	
	private static final DataTypeUtils DATATYPE_UTILS = PnutilsFactory.eINSTANCE.createDataTypeUtils();

	public PnmlDatatypesUtil() {
	}
	
	public static URI createURI(String uri) throws URISyntaxException {
		return DATATYPE_UTILS.createURI(uri);
	}
	
	public static StringBuffer createLongString(String string) {
		return DATATYPE_UTILS.createLongString(string);
	}
}