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
package es.unizar.disco.simulation.models.measures.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;

public class CustomDomainMeasureDefinitionItemProvider extends DomainMeasureDefinitionItemProvider {

	public CustomDomainMeasureDefinitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		DomainMeasureDefinition definition = (DomainMeasureDefinition)object;
		StringBuilder builder = new StringBuilder();
		builder.append(definition.getMeasure());
		String expression = definition.getVslExpression();
		if (expression != null && expression.length() > 0) {
			builder.append(": ");
			builder.append(expression);
		}
		return builder.toString();
	}
	
}
