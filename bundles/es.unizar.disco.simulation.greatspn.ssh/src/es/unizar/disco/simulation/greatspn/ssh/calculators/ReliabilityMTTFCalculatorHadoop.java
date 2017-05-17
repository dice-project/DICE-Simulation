package es.unizar.disco.simulation.greatspn.ssh.calculators;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;

public class ReliabilityMTTFCalculatorHadoop extends AbstractCalculator implements MeasureCalculator {

	/**
	 *The result is the throughput of the subnet of the Petri net that represents all the resources in the platform and its mean failure time.
	 *Same calculation than in Storm case
	 */
	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult,
			TraceSet traceSet) {

		return (new ReliabilityMTTFCalculatorStorm()).calculate(domainElement, definition, toolResult, traceSet);
	}
}
