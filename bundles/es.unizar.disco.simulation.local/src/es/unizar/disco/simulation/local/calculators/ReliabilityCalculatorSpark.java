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
package es.unizar.disco.simulation.local.calculators;

import java.math.BigDecimal;
import java.text.MessageFormat;

import javax.measure.Unit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.pnml.m2m.utils.ConstantUtils;
import es.unizar.disco.pnml.m2t.utils.PnmlToolInfoUtils;
import es.unizar.disco.simulation.local.LocalSimulationPlugin;
import es.unizar.disco.simulation.models.datatypes.NonStandardUnits;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
import fr.lip6.move.pnml.ptnet.Place;
import fr.lip6.move.pnml.ptnet.Transition;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class ReliabilityCalculatorSpark implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult,
			TraceSet traceSet) {


		//Trace set has information. ToolResult is empty.
		
				// From other calculators:
				if (!isAdequateFor(domainElement)) {
					throw new IllegalArgumentException(MessageFormat
							.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity' but type ''{1}''", domainElement, domainElement.getClass()));
				}
				
				//Look for SparkNode element. Look its info in DaComponent. Get the MTTF and MTTR. Calculate availability from them
				
				Float rateFail = Float.valueOf(1);
				double missionTime= 0.0;
				int numServers = 1;
				PnmlToolInfoUtils pnmlutils = new PnmlToolInfoUtils();
				//get from trace the transition information of the closing transition
				for (Trace trace : traceSet.getTraces()) {
					//the trace of interest
					if(ConstantUtils.getMTTFvms().equalsIgnoreCase(trace.getRule())){
						//Get the rate of the Transition
						Transition trans = ((Transition)trace.getToAnalyzableElement());
						
					
						if(PnmlToolInfoUtils.isExponential(trans)){
							rateFail = pnmlutils.getTransitionRate(trans);
						}
					}
					if(trace.getRule()!=null && trace.getRule().startsWith(ConstantUtils.getMissionTime())){
						//get the repair rate
						DiceLogger.logInfo(LocalSimulationPlugin.getDefault(), "Mission time: " + trace.getRule());
						missionTime = Double.valueOf(trace.getRule().substring(trace.getRule().lastIndexOf("_")+1));
						
					}
					if(ConstantUtils.getVmsActive().equalsIgnoreCase(trace.getRule())){
						Place place = ((Place)trace.getToAnalyzableElement());
						numServers = place.getInitialMarking().getText().intValue();
					}
				}
							
				double reliabilityValue= computeReliabilityParallel(rateFail.doubleValue(), missionTime, numServers);
						BigDecimal measuredecimal = new BigDecimal(reliabilityValue);
						//String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";
						String targetUnit = "";
						DomainMeasure measure = buildMeasure(measuredecimal, "", targetUnit);
						measure.setDefinition(definition);
						return measure;
						
						
			}

	private double computeReliabilityParallel(double lambda, double t, int numServers) {
		double reliabServer = Math.exp(-1.0*lambda*t);
		double unreliabServer= 1.0-reliabServer;
		double reliabSystem = 1.0-Math.pow(unreliabServer, numServers);
		return reliabSystem;
	}

	private DomainMeasure buildMeasure(BigDecimal rawValue, String sourceInversedUnit, String targetUnit) {
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();

		try {
			// Try to convert

			Unit<?> toUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(targetUnit);
			measure.setUnit(toUnit.toString());
			measure.setValue(rawValue);
		} catch (Throwable t) {
			try {
				DiceLogger.logWarning(LocalSimulationPlugin.getDefault(),
						"There was an exception with the common unit management (no unit for reliability, it's a probability). Acting as default");
				// If this fails, use the base unit
				Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(sourceInversedUnit).inverse();
				measure.setUnit("%");
				measure.setValue(fromUnit.getConverterToAny(Units.SECOND).convert(rawValue));
			} catch (Throwable t2) {
				// If everything fails, don't use any unit
				DiceLogger.logWarning(LocalSimulationPlugin.getDefault(),
						"There has been trown a Second Exception with the auxiliar unit PERCENTAGE management");
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
