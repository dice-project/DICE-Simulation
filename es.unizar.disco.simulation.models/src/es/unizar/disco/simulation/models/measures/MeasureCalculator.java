package es.unizar.disco.simulation.models.measures;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;

public interface MeasureCalculator {
	
	public DomainMeasure calculate(EObject domainElement, ToolResult toolResult, TraceSet traceSet);

}
