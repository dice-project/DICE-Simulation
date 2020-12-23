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
package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Node;

import es.unizar.disco.simulation.models.datatypes.NonStandardUnits;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import fr.lip6.move.pnml.ptnet.Place;

public class UtilizationCalculator extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		// 
		// Utilization
		// ** Only for elements that denote a Resource **
		// 
		// Pattern:
		// 		- - ->(P)- - ->
		//
		// utilization = (initial_marking(P) - mean_n_tokens(P)) /initial_marking(P)
		//
		// @formatter:on
		//

		// @formatter:off
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(domainElement, toolResult, traceSet);
		List<PlaceInfo> placeInfos = infos
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		// @formatter:on

		if (placeInfos.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected 1, but found ''{1}''", domainElement,
					placeInfos.size()));
		} else {
			PlaceInfo placeInfo = placeInfos.get(0);
			Place place = (Place) placeInfo.getAnalyzedElement();

			BigDecimal meanNumberToken = new BigDecimal(placeInfo.getMeanNumberOfTokens().toString());
			BigDecimal initialMarking = new BigDecimal(place.getInitialMarking().getText());
			BigDecimal result = initialMarking.subtract(meanNumberToken).divide(initialMarking, MathContext.DECIMAL64).multiply(new BigDecimal(100));

			// This is always a percentage, ignore whatever the
			// DomainMeasureDefinition defines
			DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
			measure.setDefinition(definition);
			measure.setUnit(NonStandardUnits.PERCENTAGE.getLiteral());
			measure.setValue(result);
			return measure;
		}
	}

	@Override
	public Boolean isAdequateFor(EObject domainElement) {
		return (domainElement instanceof Device) || 
				(domainElement instanceof Node) ||
				(domainElement instanceof Artifact);
	}
}
