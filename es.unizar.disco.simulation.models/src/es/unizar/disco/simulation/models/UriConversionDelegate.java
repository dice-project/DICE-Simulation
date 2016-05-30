package es.unizar.disco.simulation.models;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate;

public class UriConversionDelegate implements ConversionDelegate {

	public static class Factory implements EDataType.Internal.ConversionDelegate.Factory {
		@Override
		public ConversionDelegate createConversionDelegate(EDataType eDataType) {
			return new UriConversionDelegate();
		}
	}
	
	@Override
	public String convertToString(Object value) {
		return value != null ?  value.toString() : null;
	}

	@Override
	public Object createFromString(String literal) {
		return URI.createURI(literal);
	}
}