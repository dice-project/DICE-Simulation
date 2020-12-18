/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
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
