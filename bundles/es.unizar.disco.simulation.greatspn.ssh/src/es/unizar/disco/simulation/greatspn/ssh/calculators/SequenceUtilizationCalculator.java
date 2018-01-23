package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.ExecutionSpecification;
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
import fr.lip6.move.pnml.ptnet.Place;

public class SequenceUtilizationCalculator extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		// 
		// Utilization
		// ** Only for elements that denote a Resource **
		// 
		// Pattern:
		// 		- - ->(P)- - ->
		//
		// utilization = (initial_marking(P) - mean_n_tokens(P)) /initial_marking(P)
		//
		// @formatter:on
		//
		
		if (!isAdequateFor(domainElement)) {
			throw new IllegalArgumentException(MessageFormat.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Lifeline'", domainElement));
		}
		
		Lifeline lifeline = (Lifeline) domainElement;
		List<InteractionFragment> interactionFragments = lifeline.getCoveredBys();
		// @formatter:on
		
		// Validate there's only one interaction fragment
		if (interactionFragments.size() < 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'InteractionFragment' found in Interaction ''{0}''. Expected more than 1, but found ''{1}''",
					domainElement, interactionFragments.size()));
		}

		/*BigDecimal meanNumberToken = getMeanTokensLifeline(interactionFragments, toolResult, traceSet); //(placeInfo.getMeanNumberOfTokens().toString()) */
		BigDecimal meanNumberTokenWorking = getMeanTokenstWorkingLifeline(interactionFragments, toolResult, traceSet); //(placeInfo.getMeanNumberOfTokens().toString())
		//BigDecimal meanNumberTokenWaiting = getMeanTokenstWaitingQueueLifeline(interactionFragments, toolResult, traceSet); 
		BigDecimal initialMarking = getInitialMarkingLifeline(lifeline, toolResult, traceSet); //(place.getInitialMarking().getText());

		BigDecimal result = initialMarking.subtract(meanNumberTokenWorking).divide(initialMarking, MathContext.DECIMAL64).multiply(new BigDecimal(100));
		/*BigDecimal result = initialMarking.subtract(meanNumberTokenWaiting);
		result = result.subtract(meanNumberTokenWorking).divide(initialMarking, MathContext.DECIMAL64).multiply(new BigDecimal(100));*/

		// This is always a percentage, ignore whatever the
		// DomainMeasureDefinition defines
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
		measure.setDefinition(definition);
		measure.setUnit(NonStandardUnits.PERCENTAGE.getLiteral());
		measure.setValue(result);
		return measure;
	}
	
	private BigDecimal getMeanTokenstWorkingLifeline(List<InteractionFragment> interactionFragments, ToolResult toolResult, TraceSet traceSet) {
		BigDecimal meanTokensPlaceInfoList = new BigDecimal(0.0, MathContext.DECIMAL64);
		for (InteractionFragment interactionFragment : interactionFragments) {
			if (interactionFragment instanceof ExecutionSpecification) {
				Set<AnalyzableElementInfo> infos = findInfosForDomainElement(interactionFragment, toolResult, traceSet);
				List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
						.map(i -> (PlaceInfo) i).collect(Collectors.toList());
				for (PlaceInfo pInfo : placesInfos){
					meanTokensPlaceInfoList = meanTokensPlaceInfoList.add(new BigDecimal(pInfo.getMeanNumberOfTokens().doubleValue()));
				}
			}
		}
		return meanTokensPlaceInfoList;
	}
	
	private BigDecimal getMeanTokenstWaitingQueueLifeline(List<InteractionFragment> interactionFragments, ToolResult toolResult, TraceSet traceSet) {
		BigDecimal meanTokensPlaceInfoList = new BigDecimal(0.0, MathContext.DECIMAL64);
		for (InteractionFragment interactionFragment : interactionFragments) {
			if (!(interactionFragment instanceof ExecutionSpecification)) {
				Set<AnalyzableElementInfo> infos = findInfosForDomainElement(interactionFragment, toolResult, traceSet);
				List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
						.map(i -> (PlaceInfo) i).collect(Collectors.toList());
				for (PlaceInfo pInfo : placesInfos){
					meanTokensPlaceInfoList = meanTokensPlaceInfoList.add(new BigDecimal(pInfo.getMeanNumberOfTokens().doubleValue()));
				}
			}
		}
		return meanTokensPlaceInfoList;
	}
	
	private BigDecimal getMeanTokensLifeline(List<InteractionFragment> interactionFragments, ToolResult toolResult, TraceSet traceSet) {
		BigDecimal meanTokensPlaceInfoList = new BigDecimal(0.0, MathContext.DECIMAL64);
		for (InteractionFragment interactionFragment : interactionFragments) {
			Set<AnalyzableElementInfo> infos = findInfosForDomainElement(interactionFragment, toolResult, traceSet);
			List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
					.map(i -> (PlaceInfo) i).collect(Collectors.toList());
			for (PlaceInfo pInfo : placesInfos){
				meanTokensPlaceInfoList = meanTokensPlaceInfoList.add(new BigDecimal(pInfo.getMeanNumberOfTokens().doubleValue()));
			}
		}
		return meanTokensPlaceInfoList;
	}
		
	private BigDecimal getInitialMarkingLifeline(Lifeline lifeLine, ToolResult toolResult, TraceSet traceSet) {
		BigDecimal initialMarking = new BigDecimal(0.0, MathContext.DECIMAL64);
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(lifeLine, toolResult, traceSet);
		List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i).collect(Collectors.toList());
		if (!placesInfos.isEmpty()) {
			PlaceInfo placeInfo = findFirstPlaceInfoOfRuleInfo(ConstantUtils.getPlaceConcurrentUsersTrace(), traceSet, placesInfos);
			Place place = (Place) placeInfo.getAnalyzedElement();
			initialMarking = new BigDecimal(place.getInitialMarking().getText(), MathContext.DECIMAL64);
		}	
		//return  new BigDecimal(findFirstPlaceInfoOfRule(ConstantUtils.getPlaceConcurrentUsersTrace(), traceSet,	placesInfos).doubleValue());
		return initialMarking;
	}
	
	private BigDecimal getInitialMarkingLifeline2(Lifeline lifeLine, ToolResult toolResult, TraceSet traceSet) {
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(lifeLine, toolResult, traceSet);
		List<PlaceInfo> placesInfos = infos.stream().filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i).collect(Collectors.toList());
		
		return  new BigDecimal(findFirstPlaceInfoOfRule(ConstantUtils.getPlaceConcurrentUsersTrace(), traceSet,	placesInfos).doubleValue());
	}

	@Override
	public Boolean isAdequateFor(EObject domainElement) {
		return (domainElement instanceof Lifeline);
	}
}
