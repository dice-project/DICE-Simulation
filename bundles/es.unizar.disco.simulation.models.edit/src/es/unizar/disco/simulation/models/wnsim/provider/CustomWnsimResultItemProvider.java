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

import java.util.Date;

import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.wnsim.WnsimResult;

public class CustomWnsimResultItemProvider extends WnsimResultItemProvider {

	public CustomWnsimResultItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		Date timestamp = ((WnsimResult)object).getTimestamp();

		StringBuilder builder = new StringBuilder("Simulation Tool Result");
		builder.append(" [");
		builder.append(timestamp);
		builder.append("]");
		
		return builder.toString();
	}
}
