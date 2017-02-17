package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
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
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import fr.lip6.move.pnml.ptnet.Arc;
import fr.lip6.move.pnml.ptnet.Place;
import fr.lip6.move.pnml.ptnet.Transition;

public class ThroughputCalculatorBolt extends AbstractCalculator implements MeasureCalculator {

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
		
		List<PlaceInfo> placeInfos = infos
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		// @formatter:on

		if (placeInfos.size() != 2) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected 2, but found ''{1}''", domainElement,
					placeInfos.size()));
		} else {
			PlaceInfo placeInfo = placeInfos.get(0);
			Place place = (Place) placeInfo.getAnalyzedElement();
			
			/* Get the place that is initialized with the parallelism (tokens) */ 
			for (PlaceInfo pInfo : placeInfos) {
				Place p = (Place) pInfo.getAnalyzedElement();
				if (p.getInitialMarking() != null){
					placeInfo = pInfo;
					place = p;
				}
			}
			
			/* Get all the timed transitions corresponding to the Spout/Bolt */
			/* All the timed transitions have an arc going to the place 
			 * initialized with the parallelism (tokens) */
			List<Arc> inArcs = place.getInArcs();
			
			String targetUnit = definition.getVslExpressionEntries().get("unit");
			
			DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
			measure.setDefinition(definition);
			measure.setUnit(targetUnit);
			measure.setValue(BigDecimal.ZERO);
			
			/* At least, we need one timed transition for computing the throughput */
			if (inArcs.size() >= 1){
				String transitionUnit = null;
				BigDecimal mean = new BigDecimal("0.0");
				for (Arc arc : inArcs){
					Transition tr = (Transition) arc.getSource();
					//AnalyzableElementInfo transitionInfo = findAnalyzableElementInfo(tr, toolResult);
					TransitionInfo transitionInfo = (TransitionInfo) findAnalyzableElementInfo(tr, toolResult);
					transitionUnit =  transitionInfo.getUnit().toString();
					//BigDecimal thru = new BigDecimal(transitionInfo.getThroughput().toString());
					BigDecimal thru = new BigDecimal(transitionInfo.getValue().toString());
					mean = mean.add(thru);
				}
				mean.divide(new BigDecimal(inArcs.size()));
				
				try {
					// Try to convert
					// Unit of the last transition
					measure.setUnit(targetUnit);
					measure.setValue(convert(mean, transitionUnit, targetUnit));
				} catch (Throwable t) {
					// If anything fails, use the base unit
					measure.setUnit(transitionUnit);
					measure.setValue(mean);
				}
			}
			return measure;
		}
	}
}
