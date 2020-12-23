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

import javax.measure.Unit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.pnml.m2m.utils.ConstantUtils;
import es.unizar.disco.simulation.greatspn.ssh.GspnSshSimulationPlugin;
import es.unizar.disco.simulation.models.datatypes.NonStandardUnits;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import fr.lip6.move.pnml.ptnet.Place;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class ActivityResponseTimeCalculatorSpark extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// Activity response time
		//
		// **Activities with a closed pattern**
		//
		// Pattern:
		//		[T_Delay]------> (subnet) --->[Tend]
		//        `----->(PlaceConcurrentUsers)---^
		//
		//respT = mean_number_tokens(PlaceConcurrentUsers)/throughput(T_end)
		// @formatter:off
		//

		if (!isAdequateFor(domainElement)) {
			throw new IllegalArgumentException(MessageFormat.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity'", domainElement));
		}
		
		// @formatter:off
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(domainElement, toolResult, traceSet);
		List<PlaceInfo> placeInfos = infos
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		List<TransitionInfo> transitionInfos = infos
				.stream()
				.filter(i -> i instanceof TransitionInfo)
				.map(i -> (TransitionInfo) i)
				.collect(Collectors.toList());
		// @formatter:on
		
		BigDecimal concurrentUsers = getInitialNumberOfConcurrentUsersFromActivity(placeInfos, toolResult, traceSet);
		BigDecimal meanThroughput = getMeanThrougputOfActivity(transitionInfos, toolResult, traceSet);

		BigDecimal responseTime = concurrentUsers.divide(meanThroughput, MathContext.DECIMAL64);
		String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

		DomainMeasure measure = buildMeasure(responseTime, getResultsUnit(transitionInfos,toolResult,traceSet), targetUnit);
		measure.setDefinition(definition);
		return measure;
	}
	
	private String getResultsUnit(List<TransitionInfo> transitionInfos, ToolResult toolResult, TraceSet traceSet) {
		return transitionInfos.get(0).getUnit();
	}

	protected TransitionInfo findFirstTransitionInfoOfRuleTransitionInfo(String rule, TraceSet traceSet, List<TransitionInfo> transitionInfos) {

		for (Trace trace : traceSet.getTraces()) {
			if (rule.equals(trace.getRule())) {
				for (TransitionInfo info : transitionInfos) {
					if (trace.getToAnalyzableElement().equals(info.getAnalyzedElement())) {
						DiceLogger.logInfo(GspnSshSimulationPlugin.getDefault(),
								MessageFormat.format("Found Transition id ''{0}'' with througput ''{1}''",
										info.getAnalyzedElement().toString(), info.getThroughput().doubleValue()));
						return info;
					}

				}
			}
		}
		throw new RuntimeException(
				MessageFormat.format("Not found any Place created from the transformation rule ''{0}''", rule));

	}
	
	protected PlaceInfo findFirstPlaceInfoOfRulePlaceInfo(String rule, TraceSet traceSet, List<PlaceInfo> placeInfos) {

		for (Trace trace : traceSet.getTraces()) {
			if (rule.equals(trace.getRule())) {
				for (PlaceInfo info : placeInfos) {
					if (trace.getToAnalyzableElement().equals(info.getAnalyzedElement())) {
						DiceLogger.logInfo(GspnSshSimulationPlugin.getDefault(),
								MessageFormat.format("Found Place id ''{0}'' with mean number of tokes ''{1}''",
										info.getAnalyzedElement().toString(), info.getMeanNumberOfTokens().doubleValue()));
						return info;
					}

				}
			}
		}
		throw new RuntimeException(
				MessageFormat.format("Not found any Place created from the transformation rule ''{0}''", rule));

	}

	private BigDecimal getMeanThrougputOfActivity(List<TransitionInfo> transitionInfos, ToolResult toolResult,TraceSet traceSet) {
		TransitionInfo transitionInfo = findFirstTransitionInfoOfRuleTransitionInfo(ConstantUtils.getPlaceConcurrentUsersTrace(), traceSet, transitionInfos);
		
		BigDecimal throughput = new BigDecimal(0.0);
		throughput = throughput.add(new BigDecimal(transitionInfo.getThroughput().doubleValue()));
		return throughput;
	}
	
	private BigDecimal getInitialNumberOfConcurrentUsersFromActivity(List<PlaceInfo> placesInfos, ToolResult toolResult, TraceSet traceSet) {		
		PlaceInfo placeInfo = findFirstPlaceInfoOfRulePlaceInfo(ConstantUtils.getPlaceConcurrentUsersTrace(), traceSet, placesInfos);
		Place place = (Place) placeInfo.getAnalyzedElement();		
		BigDecimal initialMarking = new BigDecimal(place.getInitialMarking().getText());
		
		return initialMarking;
	}
	
	private DomainMeasure buildMeasure(BigDecimal rawValue, String sourceInversedUnit, String targetUnit) {
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();

		try {
			// Try to convert

			Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(sourceInversedUnit).inverse();
			Unit<?> toUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(targetUnit);
			measure.setUnit(toUnit.toString());
			measure.setValue(fromUnit.getConverterToAny(toUnit).convert(rawValue));
		} catch (Throwable t) {
			try {
				// If this fails, use the base unit
				Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(sourceInversedUnit).inverse();
				measure.setUnit(Units.SECOND.toString());
				measure.setValue(fromUnit.getConverterToAny(Units.SECOND).convert(rawValue));
			} catch (Throwable t2) {
				// If everything fails, don't use any unit
				measure.setUnit(NonStandardUnits.UNSPECIFIED.getLiteral());
				measure.setValue(rawValue);
			}
		}
		return measure;
	}

	@Override
	public Boolean isAdequateFor(EObject domainElement) {
		return (domainElement instanceof Activity);
	}
}
