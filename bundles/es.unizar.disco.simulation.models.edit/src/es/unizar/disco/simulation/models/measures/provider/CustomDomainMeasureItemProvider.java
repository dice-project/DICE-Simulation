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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

import es.unizar.disco.simulation.models.measures.DomainMeasure;

public class CustomDomainMeasureItemProvider extends DomainMeasureItemProvider {

	AdapterFactory factory = new ReflectiveItemProviderAdapterFactory();

	
	public CustomDomainMeasureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		DomainMeasure measure = (DomainMeasure) object;
		StringBuilder builder = new StringBuilder(getString("_UI_DomainMeasure_type"));
		builder.append(": ");
		builder.append(measure.getDefinition() != null? measure.getDefinition().getMeasure() : "unknown measure");
		builder.append(" = ");
		builder.append(measure.getValue());
		builder.append(" (unit: ");
		builder.append(measure.getUnit());
		builder.append(")");
		builder.append(" [Domain Element: ");
		if (measure.getDefinition() != null && measure.getDefinition().getMeasuredElement() != null) { 
			EObject measuredElement = measure.getDefinition().getMeasuredElement();
			IItemLabelProvider labelProvider = (IItemLabelProvider) factory.adapt(measuredElement, IItemLabelProvider.class);
			builder.append(labelProvider.getText(measuredElement));
		} else {
			builder.append("unknown measured element");
		}
		builder.append("]");
		return builder.toString();
	}
	
}
