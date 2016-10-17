package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.FinalNode;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.pnml.m2m.utils.ConstantUtils;
import es.unizar.disco.simulation.greatspn.ssh.GspnSshSimulationPlugin;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;

public class ScenarioReliabilityCalculator extends AbstractCalculator implements MeasureCalculator {

	/**
	 * The result is the proportion of the throughput of the transition without
	 * fail of the final node (successful executions), divided by the sum of the
	 * throughputs of the transitions of the final node (all executions)
	 */
	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult,
			TraceSet traceSet) {

		// From other calculators:
		if (!(domainElement instanceof Activity)) {
			throw new IllegalArgumentException(MessageFormat
					.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity' but type ''{1}''", domainElement, domainElement.getClass()));
		}

		Activity activity = (Activity) domainElement;
		// @formatter:off

		List<ActivityFinalNode> finalNodes = activity.getOwnedNodes().stream()
				.filter(n -> n instanceof ActivityFinalNode).map(n -> (ActivityFinalNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		if (finalNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format(
					"Unexpected number of 'ActivityFinalNodes' found for ''{0}''. Expected 1, but found ''{1}''",
					activity, finalNodes.size()));
		} else {

			// @formatter:off
			FinalNode finalNode = finalNodes.get(0);
			return calculateFromFinalNode(finalNode, toolResult, traceSet, activity, definition, true);

		}

	}

	private DomainMeasure calculateFromFinalNode(FinalNode finalNode, ToolResult toolResult, TraceSet traceSet,
			Activity activity, DomainMeasureDefinition definition, boolean calculatingReliability) {

		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(finalNode, toolResult, traceSet);
		List<TransitionInfo> transitionInfos = infos.stream().filter(i -> i instanceof TransitionInfo)
				.map(i -> (TransitionInfo) i).collect(Collectors.toList());
		// @formatter:on

		// This comparison with 2 is new for reliability because the petri net
		// creates two transitions for the final node.
		if (transitionInfos.size() != 2) {
			throw new RuntimeException(MessageFormat.format(
					"Unexpected number of 'TransitionInfos' found for ''{0}''. Expected 2, but found ''{1}''", activity,
					transitionInfos.size()));
		}

		// get the transition that represents the failed executions
		Number failingThroughput = findFirstAnalyzableElementInfoOfRule(ConstantUtils.getFail(), traceSet,
				transitionInfos);
		Number successfulExecThroughput = findFirstAnalyzableElementInfoOfRule(ConstantUtils.getOK(), traceSet,
				transitionInfos);

		BigDecimal dividend;
		if (calculatingReliability) {
			dividend = new BigDecimal(successfulExecThroughput.doubleValue());
		}
		else{//Calculating unreliability
			dividend = new BigDecimal(failingThroughput.doubleValue());
		}
		BigDecimal divisor = new BigDecimal(failingThroughput.doubleValue() + successfulExecThroughput.doubleValue());
		System.out.println("Reliability Computation: dividing: " + dividend + " by " + divisor);
		DiceLogger.logInfo(GspnSshSimulationPlugin.getDefault(),
				"Reliability Computation: dividing: " + dividend + " by " + divisor);

		BigDecimal probSuccessExecution = dividend.divide(divisor, MathContext.DECIMAL64);

		return createDomainMeasure(probSuccessExecution, definition);
	}

	private DomainMeasure createDomainMeasure(BigDecimal probSuccessExecution, DomainMeasureDefinition definition) {
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
		// TODO: DomainMeasure has associated the units in which the value is
		// given. Since the returned value is a probability
		// I leave the value undefined. Maybe this will bring some problem in
		// the future
		measure.setValue(probSuccessExecution);
		measure.setDefinition(definition);
		return measure;
	}

	private Number findFirstAnalyzableElementInfoOfRule(String rule, TraceSet traceSet,
			List<TransitionInfo> transitionInfos) {

		for (Trace trace : traceSet.getTraces()) {
			if (rule.equals(trace.getRule())) {
				for (TransitionInfo info : transitionInfos) {
					if (trace.getToAnalyzableElement().equals(info.getAnalyzedElement())) {
						DiceLogger.logInfo(GspnSshSimulationPlugin.getDefault(),
								MessageFormat.format("Found Transition id ''{0}'' with throughput ''{1}''",
										info.getAnalyzedElement().toString(), info.getThroughput().doubleValue()));
						return info.getThroughput();
					}

				}
			}
		}
		throw new RuntimeException(
				MessageFormat.format("Not found any transition created from the transformation rule ''{0}''", rule));

	}

	public DomainMeasure calculateUnreliability(EObject domainElement, DomainMeasureDefinition definition,
			ToolResult toolResult, TraceSet traceSet) {

		// From other calculators:
		if (!(domainElement instanceof Activity)) {
			throw new IllegalArgumentException(MessageFormat
					.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity'", domainElement));
		}

		Activity activity = (Activity) domainElement;
		// @formatter:off

		List<ActivityFinalNode> finalNodes = activity.getOwnedNodes().stream()
				.filter(n -> n instanceof ActivityFinalNode).map(n -> (ActivityFinalNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		if (finalNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format(
					"Unexpected number of 'ActivityFinalNodes' found for ''{0}''. Expected 1, but found ''{1}''",
					activity, finalNodes.size()));
		} else {

			// @formatter:off
			FinalNode finalNode = finalNodes.get(0);
			return calculateFromFinalNode(finalNode, toolResult, traceSet, activity, definition, false);

		}

	}
}
