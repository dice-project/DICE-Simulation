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
package es.unizar.disco.simulation.quickstart.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "es.unizar.disco.simulation.quickstart.wizards.messages"; //$NON-NLS-1$
	public static String ImportExampleProjectWizard_caseInsensitiveExistsError;
	public static String ImportExampleProjectWizard_description;
	public static String ImportExampleProjectWizard_generalProblem;
	public static String ImportExampleProjectWizard_internalError;
	public static String ImportExampleProjectWizard_operationLabel;
	public static String ImportExampleProjectWizard_title;
	public static String ImportExampleProjectWizard_unableCreateContainersError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
