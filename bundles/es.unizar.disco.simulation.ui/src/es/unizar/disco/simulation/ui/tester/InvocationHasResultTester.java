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
package es.unizar.disco.simulation.ui.tester;

import org.eclipse.core.expressions.PropertyTester;

import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class InvocationHasResultTester extends PropertyTester {

	private static final String EXTENSION_PROPERTY = "hasResult";
	
	public InvocationHasResultTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof SimulationInvocation) {
			SimulationInvocation invocation = (SimulationInvocation) receiver;
			if (EXTENSION_PROPERTY.equals(property) && invocation.getResult() != null) {
				return true;
			}
		}
		return false;
	}

}
