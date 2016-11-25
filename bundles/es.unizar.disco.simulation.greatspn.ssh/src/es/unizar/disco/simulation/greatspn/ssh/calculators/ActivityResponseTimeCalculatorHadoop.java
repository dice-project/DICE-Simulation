package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.measure.Unit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.util.UMLUtil;

/**/
import es.unizar.disco.pnml.m2t.utils.PnmlToolInfoUtils;
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
import fr.lip6.move.pnml.ptnet.Arc;
import fr.lip6.move.pnml.ptnet.Place;
import fr.lip6.move.pnml.ptnet.ToolInfo;
import fr.lip6.move.pnml.ptnet.Transition;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.format.SimpleUnitFormat.Flavor;
import tec.units.ri.unit.Units;

public class ActivityResponseTimeCalculatorHadoop extends AbstractCalculator implements MeasureCalculator {

/******/
	class MyFunctionWithState {
	    private int myVar = 0;
	    public int call() {
	      myVar++;
	      return myVar;
	    }
	 }
    
	private MyFunctionWithState func = new MyFunctionWithState();
/******/
    
	private static final String HADOOP_WORKLOAD_EVENT = "DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopWorkloadEvent";
	private static final String HADOOP_POPULATION = "hadoopPopulation";

	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// Activity response time
		// **Activities with an open pattern**
		//
		// Pattern:
		//		[T_ini]---> (subnet) --->[T_end]
		//
		// respT = sum(mean_number_tokens(subnet)) / throughput(T_end)
		//
		//
		// **Activities with a closed pattern**
		//
		// Pattern:
		//		[P]---> (subnet) --->[T]
		//        ^------------------�
		//
		// respT = (sum(mean_number_tokens(subnet)) - mean_number_tokens(P)) / throughput(T)
		//
		// @formatter:off
		//
		
		if (!(domainElement instanceof Activity)) {
			throw new IllegalArgumentException(MessageFormat.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity'", domainElement));
		}
		
		Activity activity = (Activity) domainElement;
		// @formatter:off
		List<InitialNode> initialNodes = activity.getOwnedNodes()
				.stream()
				.filter(n -> n instanceof InitialNode)
				.map(n -> (InitialNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		// Validate there's only one initial node
		if (initialNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'InitialNodes' found in Activity ''{0}''. Expected 1, but found ''{1}''",
					domainElement, initialNodes.size()));
		}

		// Validate it defines a pattern
		InitialNode initialNode = initialNodes.get(0);
		String hadoopPopulation = (String) UMLUtil.getTaggedValue(initialNode, HADOOP_WORKLOAD_EVENT, HADOOP_POPULATION);
		if (hadoopPopulation == null) {
			throw new RuntimeException(
					MessageFormat.format("InitialNode ''{0}'' in Activity ''{1}'' does not define a valid workload", initialNode, domainElement));
		}
				
		return calculateClosed(activity, definition, toolResult, traceSet);
	}

	private DomainMeasure calculateClosed(Activity activity, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// Pattern:
		// [P]---> (subnet) --->[T]
		// ^------------------�
		//
		// respT = (sum(mean_number_tokens(subnet)) - mean_number_tokens(P)) /
		// throughput(T)
		List<InitialNode> initialNodes = activity.getOwnedNodes().stream().filter(n -> n instanceof InitialNode).map(n -> (InitialNode) n)
				.collect(Collectors.toList());
		List<ActivityFinalNode> finalNodes = activity.getOwnedNodes().stream().filter(n -> n instanceof ActivityFinalNode).map(n -> (ActivityFinalNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		if (initialNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'InitialNodes' found for ''{0}''. Expected 1, but found ''{1}''", activity,
					initialNodes.size()));
		} else if (finalNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'ActivityFinalNodes' found for ''{0}''. Expected 1, but found ''{1}''",
					activity, finalNodes.size()));
		} else {
			// @formatter:off
			InitialNode initialNode = initialNodes.get(0);
			Set<AnalyzableElementInfo> intialNodeInfos = findInfosForDomainElement(initialNode, toolResult, traceSet);
			List<PlaceInfo> placeInfos = intialNodeInfos
					.stream()
					.filter(i -> i instanceof PlaceInfo)
					.map(i -> (PlaceInfo) i)
					.collect(Collectors.toList());
			
			FinalNode finalNode = finalNodes.get(0);
			Set<AnalyzableElementInfo> finalNodeInfos = findInfosForDomainElement(finalNode, toolResult, traceSet);
			List<TransitionInfo> transitionInfos = finalNodeInfos
					.stream()
					.filter(i -> i instanceof TransitionInfo)
					.map(i -> (TransitionInfo) i)
					.collect(Collectors.toList());
			// @formatter:on
			
			/**/
			int index = func.call();
			/**/
			
			if (placeInfos.size() < index) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected at least ''{1}'', but found ''{2}''",
						initialNode, index, placeInfos.size()));
			}
			if (transitionInfos.size() < index) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'TransitionInfos' found for ''{0}''. Expected at least ''{1}'', but found ''{2}''",
						finalNode, index, transitionInfos.size()));
			}
			
			// COMMENT:
			//
			// We assume that the activity is the scenario, and as such, all the
			// places in the PetriNet must belong to the subnet for which we
			// want to calculate the responseTime with the exception of the
			// place corresponding to the InitialNode. This way, we include all
			// the places in the sum with the exception of that one.
			//
			//
			
			long sum = 0;
			for (PlaceInfo info : toolResult.getInfos().stream().filter(i -> i instanceof PlaceInfo).map(i -> (PlaceInfo) i).collect(Collectors.toList())) {
				Place p = (Place) info.getAnalyzedElement();
				if (hasColor (p, index)) {
					sum += info.getMeanNumberOfTokens().longValue();
				}
			}
			
			//PlaceInfo placeInfo = placeInfos.get(0);
			//TransitionInfo transitionInfo = transitionInfos.get(0);

			PlaceInfo placeInfo = getPlaceInfoByColor (placeInfos, index);
			TransitionInfo transitionInfo = getTransitionInfoByColor (transitionInfos, index);
			
			BigDecimal dividend = new BigDecimal(sum - placeInfo.getValue().longValue());
			BigDecimal divisor = new BigDecimal(transitionInfo.getThroughput().toString());

			BigDecimal rawValue = dividend.divide(divisor, MathContext.DECIMAL64);
			String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

			DomainMeasure measure = buildMeasure(rawValue, transitionInfo.getUnit(), targetUnit);
			measure.setDefinition(definition);
			return measure;
		}
	}

	private boolean hasColor (Transition trans, int index){
		boolean hasCol = false;
		PnmlToolInfoUtils converter = new PnmlToolInfoUtils();
		Iterator<ToolInfo> itr = trans.getToolspecifics().iterator();
		while (itr.hasNext()){
			ToolInfo t = (ToolInfo) itr.next();	
			if (PnmlToolInfoUtils.isColor(t)){
				hasCol = hasCol || 
						(Integer.valueOf(converter.getColorNameIndex(t)) == index); 
				if (hasCol) break;
			}
		}
		return hasCol;
	}
	
	private boolean hasColor (Place place, int index){
		boolean hasCol = false;
		PnmlToolInfoUtils converter = new PnmlToolInfoUtils();
		Iterator<ToolInfo> itr = place.getToolspecifics().iterator();
		while (itr.hasNext()){
			ToolInfo t = (ToolInfo) itr.next();	
			if (PnmlToolInfoUtils.isColor(t)){
				hasCol = hasCol || 
						(Integer.valueOf(converter.getColorNameIndex(t)) == index); 
				if (hasCol) break;
			}
		}
		return hasCol;
	}
	
	
	private PlaceInfo getPlaceInfoByColor (List<PlaceInfo> placeInfos, int index){
		Iterator<PlaceInfo> itt = placeInfos.iterator();
		List<PlaceInfo> placeInfoStartList = new ArrayList<PlaceInfo>();
		
		/* Select all the 'start' places of the Petri net
		 * Discard the 'id' places */
		PlaceInfo pInfo = null;
		Place p;
		while (itt.hasNext()){
			pInfo = (PlaceInfo) itt.next();
			p = (Place) pInfo.getAnalyzedElement();
			
			List<Arc> inArcsList = p.getInArcs();
			List<Arc> outArcsList = p.getOutArcs();
							
			if (inArcsList.size() < 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of input arcs for place ''{0}'', found ''{1}''",
						p, inArcsList.size()));
			}
			
			if (outArcsList.size() < 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of output arcs for place ''{0}'', found ''{1}''",
						p, outArcsList.size()));
			}
			
			/* The 'start' place has different inTrans and outTrans */
			Transition inTrans = (Transition) inArcsList.get(0).getSource();
			Transition outTrans = (Transition) outArcsList.get(0).getTarget();
			if (inTrans != outTrans){
				placeInfoStartList.add(pInfo);
			}
		}
		
		Iterator<PlaceInfo> itr = placeInfoStartList.iterator();
		while (itr.hasNext()){
			pInfo = itr.next();
			p = (Place) pInfo.getAnalyzedElement();
			/* The 'start' place in the Petri net has only a single colour */
			if (p.getToolspecifics().size() == 0) {
				throw new RuntimeException(MessageFormat.format("No ToolInfo found in place ''{0}''", p));
			}
			/* Search for the 'start' place of the Petri net with the color associated to name 'index' */
			if (hasColor (p, index)) break;
		}
		/*
		 * Place 'place' has the right colour.
		 */
		return pInfo;
	}
	
	private TransitionInfo getTransitionInfoByColor (List<TransitionInfo> transitionInfos, int index){
		Iterator<TransitionInfo> itt2 = transitionInfos.iterator();
		List<TransitionInfo> transitionInfoEndList = new ArrayList<TransitionInfo>();
		
		/* Select all the 'end' transitions of the Petri net
		 * Discard the 'think' transitions */
		TransitionInfo tInfo = null;
		Transition t;
		while (itt2.hasNext()){
			tInfo = (TransitionInfo) itt2.next();
			t = (Transition) tInfo.getAnalyzedElement();
			
			List<Arc> inArcsList = t.getInArcs();
			List<Arc> outArcsList = t.getOutArcs();
							
			if (inArcsList.size() < 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of input arcs for transition ''{0}'', found ''{1}''",
						t, inArcsList.size()));
			}
			
			if (outArcsList.size() < 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of output arcs for transition ''{0}'', found ''{1}''",
						t, outArcsList.size()));
			}
			
			/* The 'end' transition has different inPlace and outPlace */
			Place inPlace = (Place) inArcsList.get(0).getSource();
			Place outPlace = (Place) outArcsList.get(0).getTarget();
			if (inPlace != outPlace){
				transitionInfoEndList.add(tInfo);
			}
		}
		
		Iterator<TransitionInfo> itr2 = transitionInfoEndList.iterator();
		while (itr2.hasNext()){
			tInfo = itr2.next();
			t = (Transition) tInfo.getAnalyzedElement();
			
			/* The 'end' transition in the Petri net has only a single colour */
			if (t.getToolspecifics().size() == 0) {
				throw new RuntimeException(MessageFormat.format("No ToolInfo found in transition ''{0}''", t));
			}
			/* Search for the 'end' transition of the Petri net with the color associated to name 'index' */
			if (hasColor (t, index)) break;
		}
		return tInfo;
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
}
