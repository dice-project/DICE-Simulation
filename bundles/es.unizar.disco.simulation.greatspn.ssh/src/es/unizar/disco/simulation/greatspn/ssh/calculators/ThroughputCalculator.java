package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;

public class ThroughputCalculator extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// Throughput is directly obtained from a TransitionInfo corresponding
		// to the input domain element
		//
		// Pattern:
		//		--->[T]--->
		// 		
		// throughput = throughput(T)
		//
		// @formatter:on
		//

		// @formatter:off
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(domainElement, toolResult, traceSet);
		List<TransitionInfo> transitionInfos = infos
				.stream()
				.filter(i -> i instanceof TransitionInfo)
				.map(i -> (TransitionInfo) i)
				.collect(Collectors.toList());
		// @formatter:on

		if (transitionInfos.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'TransitionInfos' found for ''{0}''. Expected 1, but found ''{1}''", domainElement, transitionInfos.size()));
		} else {
			TransitionInfo transitionInfo = transitionInfos.get(0);
			DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
			measure.setDefinition(definition);
			try {
				// Try to convert
				String targetUnit = definition.getVslExpressionEntries().get("unit");
				measure.setUnit(targetUnit);
				measure.setValue(convert(transitionInfo.getValue(), transitionInfo.getUnit().toString(), targetUnit));
			} catch (Throwable t) {
				// If anything fails, use the base unit
				measure.setUnit(transitionInfo.getUnit());
				measure.setValue(transitionInfo.getValue());
			}
			return measure;
		}
	}
}
