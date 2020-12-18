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
package es.unizar.disco.simulation.models.invocation.impl;

import es.unizar.disco.simulation.models.invocation.CustomInvocationFactory;
import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class CustomInvocationFactoryImpl extends InvocationFactoryImpl implements CustomInvocationFactory {

	@Override
	public SimulationInvocation createSimulationInvocation() {
		return new CustomSimulationInvocationImpl();
	}
	
	@Override
	public InvocationSet createInvocationSet() {
		return new CustomInvocationSetImpl();
	}
	
}
