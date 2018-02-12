package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.measure.Unit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;

import es.unizar.disco.pnml.m2m.utils.ConstantUtils;
import es.unizar.disco.simulation.models.datatypes.NonStandardUnits;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class SequenceThroughputCalculator extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// @formatter:off

		if (!isAdequateFor(domainElement)) {
			throw new IllegalArgumentException(MessageFormat.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Interaction'", domainElement));
		}
		
		Interaction interaction = (Interaction) domainElement;
		// @formatter:off
		List<Lifeline> lifeLines = interaction.getLifelines();
		
		// Validate there's at least one lifeline
		if (lifeLines.size() < 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'Lifelines' found in Interaction ''{0}''. Expected more than 1, but found ''{1}''",
					domainElement, lifeLines.size()));
		}
		
		BigDecimal meanThroughput = getMeanThrougputOfLifeLines(lifeLines, toolResult, traceSet);
		// @formatter:on

		String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "Hz"; 
		DomainMeasure measure = buildMeasure(meanThroughput, getResultsUnit(lifeLines,toolResult,traceSet), targetUnit);
		measure.setDefinition(definition);
		
		/*DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
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
		}*/
		return measure;
	}

	private BigDecimal getMeanThrougputOfLifeLines(List<Lifeline> lifelines, ToolResult toolResult,TraceSet traceSet) {
		BigDecimal meanThru = new BigDecimal(0.0, MathContext.DECIMAL64);
		BigDecimal listSize = new BigDecimal(0.0, MathContext.DECIMAL64);
		
		for (Lifeline lifeline : lifelines){	
			Set<AnalyzableElementInfo> infos = findInfosForDomainElement(lifeline, toolResult, traceSet);
			List<TransitionInfo> transitionInfos = infos
					.stream()
					.filter(i -> i instanceof TransitionInfo)
					.map(i -> (TransitionInfo) i)
					.collect(Collectors.toList());
			if (!transitionInfos.isEmpty()) {
				TransitionInfo transitionInfo = findFirstTransitionInfoOfRuleInfo(ConstantUtils.getTransitionEndSequence(), traceSet, transitionInfos);
				meanThru = meanThru.add(new BigDecimal(transitionInfo.getThroughput().doubleValue(), MathContext.DECIMAL64));
				listSize = listSize.add(new BigDecimal(1.0, MathContext.DECIMAL64));
			}
		}
		
		if (listSize.doubleValue() > 0.0){
			return meanThru.divide(listSize, MathContext.DECIMAL64);
		} else {
			return listSize;
		}
	}

	private String getResultsUnit(List<Lifeline> lifelines, ToolResult toolResult, TraceSet traceSet) {
		String res = null;
		for (Lifeline lifeline : lifelines){	
			Set<AnalyzableElementInfo> infos = findInfosForDomainElement(lifeline, toolResult, traceSet);
			List<TransitionInfo> transitionInfos = infos
					.stream()
					.filter(i -> i instanceof TransitionInfo)
					.map(i -> (TransitionInfo) i)
					.collect(Collectors.toList());
			if (!transitionInfos.isEmpty()) {
				TransitionInfo transitionInfo = findFirstTransitionInfoOfRuleInfo(ConstantUtils.getTransitionEndSequence(), traceSet, transitionInfos);
				res = transitionInfo.getUnit();
				break;
			}
		}
		return res;
	}
	
	private DomainMeasure buildMeasure(BigDecimal rawValue, String sourceUnit, String targetUnit) {
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();

		try {
			// Try to convert

			Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(sourceUnit);
			Unit<?> toUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(targetUnit);
			measure.setUnit(toUnit.toString());
			measure.setValue(fromUnit.getConverterToAny(toUnit).convert(rawValue));
		} catch (Throwable t) {
			try {
				// If this fails, use the base unit
				Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(sourceUnit);
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
	
	@Override
	public Boolean isAdequateFor(EObject domainElement) {
		return (domainElement instanceof Interaction);
	}

}
