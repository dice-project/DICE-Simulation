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

public class CustomVariableAssignmentItemProvider extends VariableAssignmentItemProvider {

	public CustomVariableAssignmentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		StringBuilder builder = new StringBuilder(getString("_UI_VariableAssignment_type"));
		VariableAssignment assignment = (VariableAssignment) object;
		if (assignment != null) {
			builder.append(": ");
			if (assignment.getVariable() != null) {
				builder.append(assignment.getVariable().getName());
			}
			builder.append("=");
			if (assignment.getValue() != null) {
				builder.append(assignment.getValue().getValue());
			}
		}
		return builder.toString();
	}

}
