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
package es.unizar.disco.simulation.models.simresult.provider;

import org.eclipse.emf.common.notify.Adapter;

public class CustomSimresultItemProviderAdapterFactory extends SimresultItemProviderAdapterFactory {

	@Override
	public Adapter createSimulationResultAdapter() {
		if (simulationResultItemProvider == null) {
			simulationResultItemProvider = new CustomSimulationResultItemProvider(this);
		}
		
		return simulationResultItemProvider;
	}
}
