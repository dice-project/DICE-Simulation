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
package es.unizar.disco.simulation.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.ILaunchable;

public class LaunchableDummyAdapterFactory implements IAdapterFactory {
	
	private final Class<?>[] adapterTypes = { ILaunchable.class };

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		// Implementing this is not actually required for ILaunchable
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return adapterTypes;
	}

}
