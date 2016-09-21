package es.unizar.disco.pnml.m2m.utils;

import java.math.BigDecimal;

import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class UnitUtils {
	{
		// The unit library seems to skip some of the base SI units when registering them
		SimpleUnitFormat.getInstance().alias(Units.HERTZ, "Hz");
	}

	@Operation(contextual = true)
	public static BigDecimal convert(Double value, String fromStringUnit, String toStringUnit) throws UnconvertibleException, IncommensurableException {
		Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(fromStringUnit);
		Unit<?> toUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(toStringUnit);

		UnitConverter converter = fromUnit.getConverterToAny(toUnit);
		return new BigDecimal(converter.convert(value).toString());
	}

}
