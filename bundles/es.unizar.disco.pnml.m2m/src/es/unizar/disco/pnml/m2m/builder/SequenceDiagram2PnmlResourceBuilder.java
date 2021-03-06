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
package es.unizar.disco.pnml.m2m.builder;

import org.eclipse.emf.common.util.URI;

import es.unizar.disco.pnml.m2m.PnmlM2mPlugin;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;

public class SequenceDiagram2PnmlResourceBuilder extends AbstractPnmlResourceBuilder implements IAnalyzableModelBuilder {

	@Override
	protected URI getTransformationUri() {
		return URI.createURI(PnmlM2mPlugin.DPIM_SD2PNML_TRANSFORMATION_URI);
	}
}
