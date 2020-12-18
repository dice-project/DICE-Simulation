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
package es.unizar.disco.simulation.models.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class DiceStereotypesUtils {

	private static final String EXTENSION_ID = "es.unizar.disco.simulation.models.supported_scenarios";

	private static final String STEREOTYPE_NAME = "stereotypeName";

	private static Set<String> stereotypes;

	public static Set<String> getScenariosStereotypes() {
		if (stereotypes == null) {
			stereotypes = new HashSet<>();
			IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
			for (IConfigurationElement configElement : configElements) {
				stereotypes.add(configElement.getAttribute(STEREOTYPE_NAME));
			}
		}
		return Collections.unmodifiableSet(stereotypes);
	}
}
