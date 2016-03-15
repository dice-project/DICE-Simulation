package es.unizar.disco.pnml.m2m.utils;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

import es.unizar.disco.pnextensions.pnutils.DataTypeUtils;
import es.unizar.disco.pnextensions.pnutils.PnutilsFactory;

public class PnmlDatatypesUtil {
	
	private static final DataTypeUtils DATATYPE_UTILS = PnutilsFactory.eINSTANCE.createDataTypeUtils();

	@Operation(contextual=true)
	public static URI createURI(String uri) throws URISyntaxException {
		return DATATYPE_UTILS.createURI(uri);
	}
	
	@Operation(contextual=true)
	public static StringBuffer createLongString(String string) {
		return DATATYPE_UTILS.createLongString(string);
	}
}