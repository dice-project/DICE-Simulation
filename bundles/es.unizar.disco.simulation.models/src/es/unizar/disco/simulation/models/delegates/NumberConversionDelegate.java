package es.unizar.disco.simulation.models.delegates;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate;

public class NumberConversionDelegate implements ConversionDelegate {

	public static class Factory implements EDataType.Internal.ConversionDelegate.Factory {
		@Override
		public ConversionDelegate createConversionDelegate(EDataType eDataType) {
			return new NumberConversionDelegate();
		}
	}
	
	@Override
	public String convertToString(Object value) {
		return value != null ? value.toString() : null;
	}

	@Override
	public Object createFromString(String literal) {
		try {
			return NumberFormat.getInstance(Locale.ROOT).parse(literal);
		} catch (ParseException e) {
			// Fail silently, it's expected to receive unparseable literals (e.g. bad user input)
		}
		return null;
	}
}
