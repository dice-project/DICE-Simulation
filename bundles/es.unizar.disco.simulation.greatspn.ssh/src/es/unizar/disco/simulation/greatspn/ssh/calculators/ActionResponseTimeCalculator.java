package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.measure.Unit;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.datatypes.NonStandardUnits;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class ActionResponseTimeCalculator extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// Action response time
		// ** Only for Actions with a single place and a single transition **
		//
		// Pattern:
		//		(P)-->[T]
		//
		// respT = mean_n_tokens(P) / throughput(T)
		//
		// @formatter:off
		//


		// @formatter:off
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(domainElement, toolResult, traceSet);
		List<PlaceInfo> placeInfos = infos
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		List<TransitionInfo> transitionInfos = infos
				.stream()
				.filter(i -> i instanceof TransitionInfo)
				.map(i -> (TransitionInfo) i)
				.collect(Collectors.toList());
		// @formatter:on

		if (placeInfos.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected 1, but found ''{1}''", domainElement, placeInfos.size()));
		} else if (transitionInfos.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'TransitionInfos' found for ''{0}''. Expected 1, but found ''{1}''", domainElement, transitionInfos.size()));
		} else {
			PlaceInfo placeInfo = placeInfos.get(0);
			TransitionInfo transitionInfo = transitionInfos.get(0);
			
			BigDecimal dividend = new BigDecimal(placeInfo.getMeanNumberOfTokens().toString());
			BigDecimal divisor = new BigDecimal(transitionInfo.getThroughput().toString());

			DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
			measure.setDefinition(definition);
			BigDecimal rawValue = dividend.divide(divisor, MathContext.DECIMAL64);
			
			try {
				// Try to convert
				String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";
				Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(transitionInfo.getUnit()).inverse();
				Unit<?> toUnit =  SimpleUnitFormat.getInstance(Flavor.ASCII).parse(targetUnit);
				measure.setUnit(toUnit.toString());
				measure.setValue(fromUnit.getConverterToAny(toUnit).convert(rawValue));
			} catch (Throwable t) {
				try {
					// If this fails, use the base unit
					Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(transitionInfo.getUnit()).inverse();
					measure.setUnit(Units.SECOND.toString());
					measure.setValue(fromUnit.getConverterToAny(Units.SECOND).convert(rawValue));
				} catch (Throwable t2) {
					// If everything fails, don't use any unit
					measure.setUnit(NonStandardUnits.UNSPECIFIED.getLiteral());
					measure.setValue(rawValue);
				}
			}
			
			return measure;
		}

	}

}
