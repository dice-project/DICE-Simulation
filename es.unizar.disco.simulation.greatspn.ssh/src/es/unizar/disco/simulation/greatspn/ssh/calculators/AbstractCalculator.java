package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;

public abstract class AbstractCalculator {

	protected static Set<AnalyzableElementInfo> findInfosForDomainElement(EObject domainElement, ToolResult toolResult, TraceSet traceSet) {
		Set<AnalyzableElementInfo> infos = new HashSet<>();
		for (Trace trace : findTraces(domainElement, traceSet)) {
			AnalyzableElementInfo info = findAnalyzableElementInfo(trace.getToAnalyzableElement(), toolResult);
			if (info != null) {
				infos.add(info);
			}
		}
		return infos;
	}
	
	protected static AnalyzableElementInfo findAnalyzableElementInfo(EObject analyzableElement, ToolResult toolResult) {
		for (AnalyzableElementInfo info : toolResult.getInfos()) {
			if (analyzableElement.equals(info.getAnalyzedElement())) {
				return info;
			}
		}
		return null;
	}
	
	protected static Set<Trace> findTraces(EObject domainElement, TraceSet traceSet) {
		Set<Trace> traces = new HashSet<>();
		for (Trace trace : traceSet.getTraces()) {
			if (domainElement.equals(trace.getFromDomainElement())) {
				traces.add(trace);
			}
		}
		return traces;
	}
}
