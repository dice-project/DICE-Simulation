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
package es.unizar.disco.simulation.models.definition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.definition.VariableAssignment;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;

public class CustomVariableConfigurationItemProvider extends VariableConfigurationItemProvider {

	public CustomVariableConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		VariableConfiguration config = (VariableConfiguration) object;
		StringBuilder builder = new StringBuilder();
		builder.append(getString("_UI_VariableConfiguration_type"));
		if (!config.getAssignments().isEmpty()) {
			builder.append(": ");
			for (VariableAssignment assignment : config.getAssignments()) {
				builder.append(assignment.getVariable().getName());
				builder.append("=");
				builder.append(assignment.getValue().getValue());
				builder.append(", ");
			}
			builder.setLength(builder.length() - 2);
		}
		return builder.toString();
	}
}
