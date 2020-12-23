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
package es.unizar.disco.simulation.greatspn.ssh.simulator;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.greatspn.ssh.simulator.messages"; //$NON-NLS-1$
	public static String GspnSshSimulator_commandNotFinishedError;
	public static String GspnSshSimulator_connClosedError;
	public static String GspnSshSimulator_connInfoNotFoundError;
	public static String GspnSshSimulator_connNotEstablishedError;
	public static String GspnSshSimulator_providerNotFoundError;
	public static String GspnSshSimulator_threadNotStartedError;
	public static String GspnSshSimulator_unableEstablishConnError;
	public static String GspnSshSimulator_unableLaunchError;
	public static String GspnSshSimulator_unableSetupFilesError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
