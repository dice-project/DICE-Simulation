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

import java.text.MessageFormat;
import java.util.Set;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

import es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment;

public class MathUtils {

	@Operation(contextual = true)
	public static String eval(String expression, Set<PrimitiveVariableAssignment> vars) {
		try {
		    JexlEngine engine = new JexlBuilder().create();
		    JexlExpression expr = engine.createExpression(expression);
		    JexlContext context = new MapContext();
		    for (PrimitiveVariableAssignment var : vars) {
		    	context.set(var.getVariable(), var.getValue());
		    }
		    return expr.evaluate(context).toString();
		} catch (Throwable t) {
			throw new RuntimeException(MessageFormat.format("Unable to 'eval()' expression ''{0}'': ''{1}''}", expression, t.getLocalizedMessage()), t);
		}
	}
}
