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
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;

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

		if (!(domainElement instanceof Activity)) {
			throw new IllegalArgumentException(MessageFormat.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity'", domainElement));
		}
		
		Activity activity = (Activity) domainElement;
		//get InitialNode. The place that stores the mean number of events (N of little law) is created from the initial node
		// @formatter:off
		List<InitialNode> initialNodes = activity.getOwnedNodes()
				.stream()
				.filter(n -> n instanceof InitialNode)
				.map(n -> (InitialNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		// Validate there's only one initial node
		if (initialNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'InitialNodes' found in Activity ''{0}''. Expected 1, but found ''{1}''",
					domainElement, initialNodes.size()));
		}
		
		//get FinalNodes
		List<ActivityFinalNode> finalNodes = activity.getOwnedNodes()
				.stream()
				.filter(n -> n instanceof ActivityFinalNode)
				.map(n -> (ActivityFinalNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		
		//BigDecimal concurrentUsers = getMeanNumberOfConcurrentUsersFromInitialNode(initialNodes.get(0), toolResult, traceSet);
		BigDecimal concurrentUsers = getInitialNumberOfConcurrentUsersFromInitialNode(initialNodes.get(0), toolResult, traceSet);
		BigDecimal meanThroughput = getMeanThrougputOfFinalNodes(finalNodes, toolResult, traceSet);

		BigDecimal responseTime = concurrentUsers.divide(meanThroughput, MathContext.DECIMAL64);
		String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

		DomainMeasure measure = buildMeasure(responseTime, getResultsUnit(finalNodes.get(0),toolResult,traceSet), targetUnit);
		measure.setDefinition(definition);
		return measure;
		
		/*String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

		DomainMeasure measure = buildMeasure(rawValue, transitionInfo.getUnit(), targetUnit);
		measure.setDefinition(definition);
		return measure;*/
	}
	
	private String getResultsUnit(ActivityFinalNode finalNode, ToolResult toolResult, TraceSet traceSet) {
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(finalNode, toolResult, traceSet);
		List<TransitionInfo> transitionInfos = infos
				.stream()
				.filter(i -> i instanceof TransitionInfo)
				.map(i -> (TransitionInfo) i)
				.collect(Collectors.toList());
		return transitionInfos.get(0).getUnit();
	}

	private BigDecimal getMeanThrougputOfFinalNodes(List<ActivityFinalNode> finalNodes, ToolResult toolResult,TraceSet traceSet) {

		BigDecimal throughput = new BigDecimal(0.0);
		for(FinalNode finalNode : finalNodes){
		
			Set<AnalyzableElementInfo> infos = findInfosForDomainElement(finalNode, toolResult, traceSet);
			List<TransitionInfo> transitionInfos = infos
					.stream()
					.filter(i -> i instanceof TransitionInfo)
					.map(i -> (TransitionInfo) i)
					.collect(Collectors.toList());
		
			for(TransitionInfo transitionInfo : transitionInfos){
				throughput = throughput.add(new BigDecimal(transitionInfo.getThroughput().doubleValue()));
			}

		}
		return throughput;
	}
	
	protected PlaceInfo findFirstPlaceInfoOfRulePlaceInfo(String rule, TraceSet traceSet,
			List<PlaceInfo> placeInfos) {

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
	
	private BigDecimal getMeanNumberOfConcurrentUsersFromInitialNode(InitialNode initialNode, ToolResult toolResult, TraceSet traceSet) {
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(initialNode, toolResult, traceSet);
		List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i).collect(Collectors.toList());

		return new BigDecimal(findFirstPlaceInfoOfRule(ConstantUtils.getPlaceConcurrentUsersTrace(), traceSet,	placesInfos).doubleValue());
		
	}
	
	private BigDecimal getInitialNumberOfConcurrentUsersFromInitialNode(InitialNode initialNode, ToolResult toolResult, TraceSet traceSet) {
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(initialNode, toolResult, traceSet);
		List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i).collect(Collectors.toList());
		
		
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
}
