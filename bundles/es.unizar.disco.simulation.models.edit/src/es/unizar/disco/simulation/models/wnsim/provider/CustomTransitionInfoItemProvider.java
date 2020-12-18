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
package es.unizar.disco.simulation.models.wnsim.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

import es.unizar.disco.simulation.models.wnsim.WnsimElementInfo;

public class CustomTransitionInfoItemProvider extends TransitionInfoItemProvider {

	AdapterFactory factory = new ReflectiveItemProviderAdapterFactory();
	
	public CustomTransitionInfoItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		WnsimElementInfo info = (WnsimElementInfo) object;
		EObject analyzableElement = info.getAnalyzedElement();
		IItemLabelProvider labelProvider = (IItemLabelProvider) factory.adapt(analyzableElement, IItemLabelProvider.class);

		StringBuilder builder = new StringBuilder();
		builder.append(labelProvider.getText(analyzableElement));
		builder.append(" [Throughput = ");
		builder.append(info.getValue());
		builder.append("; ci = ");
		builder.append(info.getConfidenceInterval().size() >= 1 ? info.getConfidenceInterval().get(0) : "unknown");
		builder.append(" <= X <= ");
		builder.append(info.getConfidenceInterval().size() >= 2 ? info.getConfidenceInterval().get(1) : "unknown");
		builder.append("]");

		return builder.toString();
	}
	
}
