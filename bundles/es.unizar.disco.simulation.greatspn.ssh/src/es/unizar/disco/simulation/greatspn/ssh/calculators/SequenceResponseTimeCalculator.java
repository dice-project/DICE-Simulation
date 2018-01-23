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
import fr.lip6.move.pnml.ptnet.Place;
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
		List<InteractionFragment> interactionFragments = interaction.getFragments();
		List<ExecutionSpecification> executionFragments = new ArrayList<ExecutionSpecification>();
		for (InteractionFragment interactionFragment : interactionFragments){
			if (interactionFragment instanceof ExecutionSpecification){
				executionFragments.add((ExecutionSpecification) interactionFragment);
			}
		}
		
		// @formatter:on

		// Validate there's only one initial node
		if (lifeLines.size() < 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'Lifelines' found in Interaction ''{0}''. Expected more than 1, but found ''{1}''",
					domainElement, lifeLines.size()));
		}
			
		BigDecimal meanInitialMarking = getMeanNumberOfInitialMarkings(lifeLines, toolResult, traceSet);
		BigDecimal meanThroughput = getMeanThrougputOfInteraction(interaction, toolResult, traceSet);

		BigDecimal responseTime = meanInitialMarking.divide(meanThroughput, MathContext.DECIMAL64);
		String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

		//DomainMeasure measure = buildMeasure(responseTime, getResultsUnit(interactionFragments.get(0),toolResult,traceSet), targetUnit);
		//DomainMeasure measure = buildMeasure(responseTime, getResultsUnit(interactionActions.get(0),toolResult,traceSet), targetUnit);
		DomainMeasure measure = buildMeasure(responseTime, getResultsUnit(executionFragments.get(0),toolResult,traceSet), targetUnit);
		measure.setDefinition(definition);
		return measure;
	}
	
	private BigDecimal getMeanNumberOfInitialMarkings(List<Lifeline> lifeLines, ToolResult toolResult, TraceSet traceSet) {
		BigDecimal meanNumber = new BigDecimal(0.0, MathContext.DECIMAL64);
		BigDecimal listSize = new BigDecimal(0.0, MathContext.DECIMAL64);
		//BigDecimal listSize = new BigDecimal(lifeLines.size());

		for (Lifeline lifeLine : lifeLines) {
			Set<AnalyzableElementInfo> infos = findInfosForDomainElement(lifeLine, toolResult, traceSet);
			List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
					.map(i -> (PlaceInfo) i).collect(Collectors.toList());
			if (!placesInfos.isEmpty()) {
				PlaceInfo placeInfo = findFirstPlaceInfoOfRuleInfo(ConstantUtils.getPlaceConcurrentUsersTrace(), traceSet, placesInfos);
				Place place = (Place) placeInfo.getAnalyzedElement();
				BigDecimal initialMarking = new BigDecimal(place.getInitialMarking().getText(), MathContext.DECIMAL64);
				meanNumber = meanNumber.add(initialMarking, MathContext.DECIMAL64);
				listSize = listSize.add(new BigDecimal(1.0, MathContext.DECIMAL64));
			}			
		}
		
		if (listSize.doubleValue() > 0.0){
			return meanNumber.divide(listSize, MathContext.DECIMAL64);
		} else {
			return listSize;
		}
	}
	
	private BigDecimal getMeanThrougputOfInteraction(Interaction interaction, ToolResult toolResult,TraceSet traceSet) {

		BigDecimal throughput = new BigDecimal(0.0);
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(interaction, toolResult, traceSet);
		List<TransitionInfo> transitionInfos = infos
				.stream()
				.filter(i -> i instanceof TransitionInfo)
				.map(i -> (TransitionInfo) i)
				.collect(Collectors.toList());
		for(TransitionInfo transitionInfo : transitionInfos){
			throughput = throughput.add(new BigDecimal(transitionInfo.getThroughput().doubleValue()));
		}
		return throughput;
	}

	//private String getResultsUnit(InteractionFragment interactionFragment, ToolResult toolResult, TraceSet traceSet) {
	//private String getResultsUnit(Action interactionAction, ToolResult toolResult, TraceSet traceSet) {
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
