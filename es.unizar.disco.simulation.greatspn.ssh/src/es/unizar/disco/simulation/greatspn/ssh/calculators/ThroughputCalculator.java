package es.unizar.disco.simulation.greatspn.ssh.calculators;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;

public class ThroughputCalculator extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, ToolResult toolResult, TraceSet traceSet) {
		for (AnalyzableElementInfo info : findInfosForDomainElement(domainElement, toolResult, traceSet)) {
			if (info instanceof TransitionInfo) {
				TransitionInfo transitionInfo = (TransitionInfo) info;
				DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
				measure.setUnit(transitionInfo.getUnit());
				measure.setValue(transitionInfo.getValue());
				return measure;
			}
		}
		return null;
	}
}
