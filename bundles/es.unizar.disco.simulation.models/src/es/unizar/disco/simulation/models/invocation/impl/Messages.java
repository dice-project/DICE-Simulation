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

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.models.invocation.impl.messages"; //$NON-NLS-1$
	public static String CustomSimulationInvocation_builderNotFound;
	public static String CustomSimulationInvocation_extPoint_analyzableProperty;
	public static String CustomSimulationInvocation_extPoint_builder;
	public static String CustomSimulationInvocation_extPoint_metaclass;
	public static String CustomSimulationInvocation_extPoint_priority;
	public static String CustomSimulationInvocation_extPoint_scenario;
	public static String CustomSimulationInvocation_nameOfExtPoints;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
