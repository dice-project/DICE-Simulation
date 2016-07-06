package es.unizar.disco.simulation.greatspn.ssh.calculators;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;

public class ActionResponseTimeCalculator extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, ToolResult toolResult, TraceSet traceSet) {
		// Response time:
		// Red abierta:
		//		respT = Sumatorio(n_medio_tokens) / throughput_trans_cierre
		// Red cerrada :
		//		respT = (Sumatorio(n_medio_token) - (n_medio_token_place_inicial)) / throughput_trans_cierre 
		return null;
	}

}
