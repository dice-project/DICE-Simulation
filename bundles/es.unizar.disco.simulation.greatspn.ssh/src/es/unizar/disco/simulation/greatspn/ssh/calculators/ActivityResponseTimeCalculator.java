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
import org.eclipse.uml2.uml.util.UMLUtil;

import es.unizar.disco.pnml.m2m.utils.ConstantUtils;
import es.unizar.disco.simulation.models.datatypes.NonStandardUnits;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class ActivityResponseTimeCalculator extends AbstractCalculator implements MeasureCalculator {

	private static final String GA_WORKLOAD_EVENT = "MARTE::MARTE_AnalysisModel::GQAM::GaWorkloadEvent";
	private static final String GA_WORKLOAD_EVENT__PATTERN = "pattern";

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// Activity response time
		// **Activities with an open pattern**
		//
		// Pattern:
		//		[T_ini]---> (subnet) ----------->[T_end]
		//			`----->(PlaceConcurrentUsers)---^
		//respT = mean_number_tokens(PlaceConcurrentUsers)/throughput(T_end)
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

		
		BigDecimal concurrentUsers = getMeanNumberOfConcurrentUsersFromUnitialNode(initialNodes.get(0), toolResult, traceSet);
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

	private BigDecimal getMeanNumberOfConcurrentUsersFromUnitialNode(InitialNode initialNode, ToolResult toolResult, TraceSet traceSet) {
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(initialNode, toolResult, traceSet);
		List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i).collect(Collectors.toList());

		return new BigDecimal(findFirstPlaceInfoOfRule(ConstantUtils.getPlaceConcurrentUsersTrace(), traceSet,	placesInfos).doubleValue());
		
	}
	
	public DomainMeasure calculateDeprecated(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// Activity response time
		// **Activities with an open pattern**
		//
		// Pattern:
		//		[T_ini]---> (subnet) --->[T_end]
		//
		// Deprecated: respT = sum(mean_number_tokens(subnet)) / throughput(T_end)
		//respT = mean_number_tokens(PlaceConcurrentUsers)/throughput(T_end)
		//
		// **Activities with a closed pattern**
		//
		// Pattern:
		//		[P]---> (subnet) --->[T]
		//        ^------------------´
		//
		// Deprecated:respT = (sum(mean_number_tokens(subnet)) - mean_number_tokens(P)) / throughput(T)
		//respT = mean_number_tokens(PlaceConcurrentUsers)/throughput(T_end)
		// @formatter:off
		//
		
		if (!(domainElement instanceof Activity)) {
			throw new IllegalArgumentException(MessageFormat.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity'", domainElement));
		}
		
		Activity activity = (Activity) domainElement;
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

		// Validate it defines a pattern
		InitialNode initialNode = initialNodes.get(0);
		String pattern = (String) UMLUtil.getTaggedValue(initialNode, GA_WORKLOAD_EVENT, GA_WORKLOAD_EVENT__PATTERN);
		if (pattern == null) {
			throw new RuntimeException(
					MessageFormat.format("InitialNode ''{0}'' in Activity ''{1}'' does not define a valid workload", initialNode, domainElement));
		}

		// Validate in contains a known valid pattern
		String[] splits = pattern.trim().split("=");
		if (splits.length <= 0) {
			throw new RuntimeException(MessageFormat.format("Invalid workload definition ''{0}'' in InitialNode ''{1}''", pattern, initialNode));
		}
		switch (splits[0]) {
		case "open":
			return calculateOpen(activity, definition, toolResult, traceSet);
		case "closed":
			return calculateClosed(activity, definition, toolResult, traceSet);
		default:
			throw new RuntimeException(MessageFormat.format("Invalid workload definition ''{0}'' in InitialNode ''{1}''", pattern, initialNode));
		}
	}

	private DomainMeasure calculateOpen(Activity activity, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// Pattern:
		// [T_ini]---> (subnet) --->[T_end]
		//
		// respT = sum(mean_number_tokens(subnet)) / throughput(T_end)

		// @formatter:off
		List<ActivityFinalNode> finalNodes = activity.getOwnedNodes()
				.stream()
				.filter(n -> n instanceof ActivityFinalNode)
				.map(n -> (ActivityFinalNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		if (finalNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'ActivityFinalNodes' found for ''{0}''. Expected 1, but found ''{1}''",
					activity, finalNodes.size()));
		} else {
			// @formatter:off
			FinalNode finalNode = finalNodes.get(0);
			Set<AnalyzableElementInfo> infos = findInfosForDomainElement(finalNode, toolResult, traceSet);
			List<TransitionInfo> transitionInfos = infos
					.stream()
					.filter(i -> i instanceof TransitionInfo)
					.map(i -> (TransitionInfo) i)
					.collect(Collectors.toList());
			// @formatter:on
			if (transitionInfos.size() != 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'TransitionInfos' found for ''{0}''. Expected 1, but found ''{1}''",
						activity, transitionInfos.size()));
			}
			
			// COMMENT:
			//
			// We assume that the activity is the scenario, and as such, all the
			// places in the PetriNet must belong to the subnet for which we
			// want to calculate the responseTime. This way, we include all the
			// places in the sum.
			//
			//
			
			long sum = 0;
			for (PlaceInfo info : toolResult.getInfos().stream().filter(i -> i instanceof PlaceInfo).map(i -> (PlaceInfo) i).collect(Collectors.toList())) {
				sum += info.getMeanNumberOfTokens().longValue();
			}
			
			TransitionInfo transitionInfo = transitionInfos.get(0);

			BigDecimal dividend = new BigDecimal(sum);
			BigDecimal divisor = new BigDecimal(transitionInfo.getThroughput().toString());

			BigDecimal rawValue = dividend.divide(divisor, MathContext.DECIMAL64);
			String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

			DomainMeasure measure = buildMeasure(rawValue, transitionInfo.getUnit(), targetUnit);
			measure.setDefinition(definition);
			return measure;
		}
	}

	private DomainMeasure calculateClosed(Activity activity, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// Pattern:
		// [P]---> (subnet) --->[T]
		// ^------------------´
		//
		// respT = (sum(mean_number_tokens(subnet)) - mean_number_tokens(P)) /
		// throughput(T)
		List<InitialNode> initialNodes = activity.getOwnedNodes().stream().filter(n -> n instanceof InitialNode).map(n -> (InitialNode) n)
				.collect(Collectors.toList());
		List<ActivityFinalNode> finalNodes = activity.getOwnedNodes().stream().filter(n -> n instanceof ActivityFinalNode).map(n -> (ActivityFinalNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		if (initialNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'InitialNodes' found for ''{0}''. Expected 1, but found ''{1}''", activity,
					initialNodes.size()));
		} else if (finalNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'ActivityFinalNodes' found for ''{0}''. Expected 1, but found ''{1}''",
					activity, finalNodes.size()));
		} else {
			// @formatter:off
			InitialNode initialNode = initialNodes.get(0);
			Set<AnalyzableElementInfo> intialNodeInfos = findInfosForDomainElement(initialNode, toolResult, traceSet);
			List<PlaceInfo> placeInfos = intialNodeInfos
					.stream()
					.filter(i -> i instanceof PlaceInfo)
					.map(i -> (PlaceInfo) i)
					.collect(Collectors.toList());
			
			FinalNode finalNode = finalNodes.get(0);
			Set<AnalyzableElementInfo> finalNodeInfos = findInfosForDomainElement(finalNode, toolResult, traceSet);
			List<TransitionInfo> transitionInfos = finalNodeInfos
					.stream()
					.filter(i -> i instanceof TransitionInfo)
					.map(i -> (TransitionInfo) i)
					.collect(Collectors.toList());
			// @formatter:on
			if (placeInfos.size() != 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected 1, but found ''{1}''",
						initialNode, placeInfos.size()));
			} else if (transitionInfos.size() != 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'TransitionInfos' found for ''{0}''. Expected 1, but found ''{1}''",
						finalNode, transitionInfos.size()));
			}
			
			// COMMENT:
			//
			// We assume that the activity is the scenario, and as such, all the
			// places in the PetriNet must belong to the subnet for which we
			// want to calculate the responseTime with the exception of the
			// place corresponding to the InitialNode. This way, we include all
			// the places in the sum with the exception of that one.
			//
			//
			
			long sum = 0;
			for (PlaceInfo info : toolResult.getInfos().stream().filter(i -> i instanceof PlaceInfo).map(i -> (PlaceInfo) i).collect(Collectors.toList())) {
				sum += info.getMeanNumberOfTokens().longValue();
			}
			
			PlaceInfo placeInfo = placeInfos.get(0);
			TransitionInfo transitionInfo = transitionInfos.get(0);

			BigDecimal dividend = new BigDecimal(sum - placeInfo.getValue().longValue());
			BigDecimal divisor = new BigDecimal(transitionInfo.getThroughput().toString());

			BigDecimal rawValue = dividend.divide(divisor, MathContext.DECIMAL64);
			String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

			DomainMeasure measure = buildMeasure(rawValue, transitionInfo.getUnit(), targetUnit);
			measure.setDefinition(definition);
			return measure;
		}
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
