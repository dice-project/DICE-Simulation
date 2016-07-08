package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public abstract class AbstractCalculator {
	{
		// The unit library seems to skip some of the base SI units when registering them
		SimpleUnitFormat.getInstance().alias(Units.HERTZ, "Hz");
	}
	
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
	
	protected static Number convert(Number value, String fromStringUnit, String toStringUnit) throws UnconvertibleException, IncommensurableException {
		// The unit library seems unable to parse some of the base SI units
		
		Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(fromStringUnit);
		Unit<?> toUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(toStringUnit);
		
		UnitConverter converter = fromUnit.getConverterToAny(toUnit);
		return new BigDecimal(converter.convert(value).toString());
	}
	
}
