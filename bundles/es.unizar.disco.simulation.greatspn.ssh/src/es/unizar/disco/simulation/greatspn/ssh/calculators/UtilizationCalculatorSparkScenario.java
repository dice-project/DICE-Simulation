package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

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
import fr.lip6.move.pnml.ptnet.Place;

public class UtilizationCalculatorSparkScenario extends AbstractCalculator implements MeasureCalculator {

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
	
	private BigDecimal getMeanNumberOfUsersFromActivity(List<PlaceInfo> placesInfos, ToolResult toolResult, TraceSet traceSet) {
		return new BigDecimal(findFirstPlaceInfoOfRule(ConstantUtils.getUsers(), traceSet, placesInfos).doubleValue());		
	}

	private BigDecimal getInitialNumberOfUsersFromActivity(List<PlaceInfo> placesInfos, ToolResult toolResult, TraceSet traceSet) {		
			PlaceInfo placeInfo = findFirstPlaceInfoOfRulePlaceInfo(ConstantUtils.getUsers(), traceSet, placesInfos);
			Place place = (Place) placeInfo.getAnalyzedElement();		
			BigDecimal initialMarking = new BigDecimal(place.getInitialMarking().getText());
			
			return initialMarking;
	}
	
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

		if (placeInfos.size() != 2) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected 3, but found ''{1}''", domainElement,
					placeInfos.size()));
		} else {
			BigDecimal meanNumberToken = getMeanNumberOfUsersFromActivity(placeInfos, toolResult, traceSet);
			BigDecimal initialMarking = getInitialNumberOfUsersFromActivity(placeInfos, toolResult, traceSet);
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
}
