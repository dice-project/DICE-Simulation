package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.measure.Unit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
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
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class SequenceResponseTimeCalculator extends AbstractCalculator implements MeasureCalculator {

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
		// @formatter:on

		// Validate there's at least one lifeline
		if (lifeLines.size() < 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'Lifelines' found in Interaction ''{0}''. Expected more than 1, but found ''{1}''",
					domainElement, lifeLines.size()));
		}
		
		BigDecimal meanThroughput = getMeanThrougputOfLifeLines(lifeLines, toolResult, traceSet);		
		BigDecimal meanImplicitMarking = getMeanNumberOfTokensImplicitPlace(lifeLines, toolResult, traceSet);

		BigDecimal responseTime = meanImplicitMarking.divide(meanThroughput, MathContext.DECIMAL64);
		String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

		List<InteractionFragment> interactionFragments = interaction.getFragments();
		List<ExecutionSpecification> executionFragments = new ArrayList<ExecutionSpecification>();
		for (InteractionFragment interactionFragment : interactionFragments){
			if (interactionFragment instanceof ExecutionSpecification){
				executionFragments.add((ExecutionSpecification) interactionFragment);
			}
		}

		DomainMeasure measure = buildMeasure(responseTime, getResultsUnit(executionFragments.get(0),toolResult,traceSet), targetUnit);
		measure.setDefinition(definition);
		return measure;
	}
	
	private BigDecimal getMeanNumberOfTokensImplicitPlace(List<Lifeline> lifeLines, ToolResult toolResult, TraceSet traceSet) {
		BigDecimal meanNumber = new BigDecimal(0.0, MathContext.DECIMAL64);
		BigDecimal listSize = new BigDecimal(0.0, MathContext.DECIMAL64);

		for (Lifeline lifeLine : lifeLines) {
			Set<AnalyzableElementInfo> infos = findInfosForDomainElement(lifeLine, toolResult, traceSet);
			List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
					.map(i -> (PlaceInfo) i).collect(Collectors.toList());
			if (!placesInfos.isEmpty()) {
				try{
					PlaceInfo placeInfo = findFirstPlaceInfoOfRuleInfo(ConstantUtils.getImplicitPlaceSequenceDiagram(), traceSet, placesInfos);
					BigDecimal meanMarking = new BigDecimal(placeInfo.getMeanNumberOfTokens().doubleValue(), MathContext.DECIMAL64);
					meanNumber = meanNumber.add(meanMarking, MathContext.DECIMAL64);
					listSize = listSize.add(new BigDecimal(1.0, MathContext.DECIMAL64));
				}catch(RuntimeException e1){
					/* No implicit place has been found */
				}
			}			
		}
		
		if (listSize.doubleValue() > 0.0){
			return meanNumber.divide(listSize, MathContext.DECIMAL64);
		} else {
			return listSize;
		}
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
	
	private String getResultsUnit(ExecutionSpecification executionFragment, ToolResult toolResult, TraceSet traceSet) {
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(executionFragment, toolResult, traceSet);
		List<TransitionInfo> transitionInfos = infos
				.stream()
				.filter(i -> i instanceof TransitionInfo)
				.map(i -> (TransitionInfo) i)
				.collect(Collectors.toList());
		return transitionInfos.get(0).getUnit();
	}
	
	private DomainMeasure buildMeasure(BigDecimal rawValue, String sourceInversedUnit, String targetUnit) {
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();

		try {
			// Try to convert

			Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(sourceInversedUnit).inverse();
			Unit<?> toUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(targetUnit);
			measure.setUnit(toUnit.toString());
			measure.setValue(fromUnit.getConverterToAny(toUnit).convert(rawValue));
		} catch (Throwable t) {
			try {
				// If this fails, use the base unit
				Unit<?> fromUnit = SimpleUnitFormat.getInstance(Flavor.ASCII).parse(sourceInversedUnit).inverse();
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
