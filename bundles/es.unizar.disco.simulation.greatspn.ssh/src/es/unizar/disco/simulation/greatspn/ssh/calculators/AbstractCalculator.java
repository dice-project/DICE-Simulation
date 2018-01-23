package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.greatspn.ssh.GspnSshSimulationPlugin;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
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
	
	protected Number findFirstTransitionInfoOfRule(String rule, TraceSet traceSet,
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
	
	protected Number findFirstPlaceInfoOfRule(String rule, TraceSet traceSet,
			List<PlaceInfo> placeInfos) {

		for (Trace trace : traceSet.getTraces()) {
			if (rule.equals(trace.getRule())) {
				for (PlaceInfo info : placeInfos) {
					if (trace.getToAnalyzableElement().equals(info.getAnalyzedElement())) {
						DiceLogger.logInfo(GspnSshSimulationPlugin.getDefault(),
								MessageFormat.format("Found Place id ''{0}'' with mean number of tokes ''{1}''",
										info.getAnalyzedElement().toString(), info.getMeanNumberOfTokens().doubleValue()));
						return info.getMeanNumberOfTokens();
					}

				}
			}
		}
		throw new RuntimeException(
				MessageFormat.format("Not found any Place created from the transformation rule ''{0}''", rule));

	}
	
	protected PlaceInfo findFirstPlaceInfoOfRuleInfo(String rule, TraceSet traceSet,
			List<PlaceInfo> placeInfos) {

		for (Trace trace : traceSet.getTraces()) {
			if (rule.equals(trace.getRule())) {
				for (PlaceInfo info : placeInfos) {
					if (trace.getToAnalyzableElement().equals(info.getAnalyzedElement())) {
						DiceLogger.logInfo(GspnSshSimulationPlugin.getDefault(),
								MessageFormat.format("Found Place id ''{0}'' with mean number of tokes ''{1}''",
										info.getAnalyzedElement().toString(), info.getMeanNumberOfTokens().doubleValue()));
						return info;
					}

				}
			}
		}
		throw new RuntimeException(
				MessageFormat.format("Not found any Place created from the transformation rule ''{0}''", rule));

	}
	
	protected TransitionInfo findFirstTransitionInfoOfRuleInfo(String rule, TraceSet traceSet,
			List<TransitionInfo> transitionInfos) {

		for (Trace trace : traceSet.getTraces()) {
			if (rule.equals(trace.getRule())) {
				for (TransitionInfo info : transitionInfos) {
					if (trace.getToAnalyzableElement().equals(info.getAnalyzedElement())) {
						DiceLogger.logInfo(GspnSshSimulationPlugin.getDefault(),
								MessageFormat.format("Found Transition id ''{0}'' with throughput ''{1}''",
										info.getAnalyzedElement().toString(), info.getThroughput().doubleValue()));
						return info;
					}

				}
			}
		}
		throw new RuntimeException(
				MessageFormat.format("Not found any transition created from the transformation rule ''{0}''", rule));

	}
}
