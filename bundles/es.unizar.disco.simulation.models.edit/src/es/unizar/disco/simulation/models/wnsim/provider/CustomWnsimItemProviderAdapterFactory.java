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

import org.eclipse.emf.common.notify.Adapter;

public class CustomWnsimItemProviderAdapterFactory extends WnsimItemProviderAdapterFactory {

	@Override
	public Adapter createWnsimResultAdapter() {
		if (wnsimResultItemProvider == null) {
			wnsimResultItemProvider = new CustomWnsimResultItemProvider(this);
		}
		
		return wnsimResultItemProvider;
	}
	
	@Override
	public Adapter createTransitionInfoAdapter() {
		if (transitionInfoItemProvider == null) {
			transitionInfoItemProvider = new CustomTransitionInfoItemProvider(this);
		}
		
		return transitionInfoItemProvider;
	}
	
	@Override
	public Adapter createPlaceInfoAdapter() {
		if (placeInfoItemProvider == null) {
			placeInfoItemProvider = new CustomPlaceInfoItemProvider(this);
		}
		
		return placeInfoItemProvider;
	}
}
