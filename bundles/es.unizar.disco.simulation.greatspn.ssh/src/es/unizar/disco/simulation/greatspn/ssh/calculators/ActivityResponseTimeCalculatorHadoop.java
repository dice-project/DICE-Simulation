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

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
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
    
	private static final String HADOOP_SCENARIO = "DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopScenario";
	private static final String HADOOP_RESPT = "respT";
	
	private static final String HADOOP_WORKLOAD_EVENT = "DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopWorkloadEvent";
	private static final String HADOOP_POPULATION = "hadoopPopulation";

	private boolean contains(Object respT_expr, String respT_name){
		boolean isPresent = false;
		if (respT_expr instanceof String && StringUtils.isNotBlank((String) respT_expr)) {
			String[] elem = StringUtils.split((String) respT_expr, ",()=");
			for (String elem_val : elem) {
				isPresent = isPresent || elem_val.equals(respT_name); 
				if (isPresent) break;
			}
		}
		return isPresent;
	}
	


	private double getInitialMarkingColor (Place place, int index){				
		PnmlToolInfoUtils converter = new PnmlToolInfoUtils();
		Iterator<ToolInfo> itr = place.getToolspecifics().iterator();
		while (itr.hasNext()){
			ToolInfo t = (ToolInfo) itr.next();	
			if (PnmlToolInfoUtils.isColor(t) &&
			   (Integer.valueOf(converter.getColorNameValue(t)) == index) ){
				double val = PnmlToolInfoUtils.getnumElementsColor(t).doubleValue();
				return val;
			}
		}
		return 0.0;
	}
	
	private boolean hasColor (Transition trans, int index){
		boolean hasCol = false;
		PnmlToolInfoUtils converter = new PnmlToolInfoUtils();
		Iterator<ToolInfo> itr = trans.getToolspecifics().iterator();
		while (itr.hasNext()){
			ToolInfo t = (ToolInfo) itr.next();	
			if (PnmlToolInfoUtils.isColor(t)){
				hasCol = hasCol || 
						(Integer.valueOf(converter.getColorNameValue(t)) == index); 
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
						(Integer.valueOf(converter.getColorNameValue(t)) == index); 
				if (hasCol) break;
			}
		}
		return hasCol;
	}
	

	private List<PlaceInfo> getStartPlaceInfos (List<PlaceInfo> placeInfos){
		Iterator<PlaceInfo> itt = placeInfos.iterator();
		List<PlaceInfo> placeInfoStartList = new ArrayList<PlaceInfo>();
		
		/* Select all the 'start' places of the Petri net
		 * Discard the 'id' places */
		
		while (itt.hasNext()){
			PlaceInfo pInfo = (PlaceInfo) itt.next();
			Place p = (Place) pInfo.getAnalyzedElement();
			
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
			
			/* The 'start' place has only a single colour */
			if ((inTrans != outTrans) &&
				(p.getToolspecifics().size() == 1)) {
				placeInfoStartList.add(pInfo);
			}			
		}
		return placeInfoStartList;
	}
	
	private List<PlaceInfo> getPlaceInfosByColor (List<PlaceInfo> placeInfos, int index){
		Iterator<PlaceInfo> itt = placeInfos.iterator();
		List<PlaceInfo> placeInfoStartList = new ArrayList<PlaceInfo>();
		
		/* Select all the places of the Petri net with 'index' colour */
		while (itt.hasNext()){
			PlaceInfo pInfo = itt.next();
			Place p = (Place) pInfo.getAnalyzedElement();
			if (p.getToolspecifics().size() == 0) {
				throw new RuntimeException(MessageFormat.format("No ToolInfo found in place ''{0}''", p));
			}
			if (hasColor (p, index)){
				placeInfoStartList.add(pInfo);
			}
		}
		return placeInfoStartList;
	}

	private List<TransitionInfo> getEndTransitionInfos (List<TransitionInfo> transitionInfos){
		Iterator<TransitionInfo> itt2 = transitionInfos.iterator();
		List<TransitionInfo> transitionInfoEndList = new ArrayList<TransitionInfo>();
		
		/* Select all the 'end' transitions of the Petri net
		 * Discard the 'think' transitions */
		while (itt2.hasNext()){
			TransitionInfo tInfo = (TransitionInfo) itt2.next();
			Transition t = (Transition) tInfo.getAnalyzedElement();
			
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
		return transitionInfoEndList;
	}
	
	private List<TransitionInfo> getTransitionInfosByColor (List<TransitionInfo> transitionInfos, int index){
		Iterator<TransitionInfo> itt = transitionInfos.iterator();
		List<TransitionInfo> transitionInfoEndList = new ArrayList<TransitionInfo>();
		
		/* Select all the transitions of the Petri net with 'index' colour */
		while (itt.hasNext()){
			TransitionInfo tInfo = itt.next();
			Transition t = (Transition) tInfo.getAnalyzedElement();
			
			if (t.getToolspecifics().size() == 0) {
				throw new RuntimeException(MessageFormat.format("No ToolInfo found in transition ''{0}''", t));
			}
			if (hasColor (t, index)){
				transitionInfoEndList.add(tInfo);	
			}
		}
		return transitionInfoEndList;
	}
	
	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// Activity response time
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
		
		/* Find out for which color we have to compute the respT metric */
		Object respT_expr_list = UMLUtil.getTaggedValue(activity, HADOOP_SCENARIO, HADOOP_RESPT);
		String respT_name = definition.getVslExpressionEntries().get("expr") != null ? definition.getVslExpressionEntries().get("expr") : null;
		
		/* A MapReduce diagram in UML can have several types of users (i.e., colors).
		 * For instance, [respT1, respT2, respT3] represents the 'response time' for 
		 * three different kind of users. */
		/* In case of having several users, we must decide which 'response time' we
		 * have to calculate. */
		int index = 0;
		int num_colors_respT = 1;
		/* respT_expr_list = [respT1, respT2, respT3] */
		/* respT_expr = respTi = (expr=$RTi, statQ=mean, source=calc)
		 * respT_name = $RTi */
		if ( (respT_expr_list != null) &&
			 (respT_expr_list instanceof EList<?>))  {
			num_colors_respT = ((EList<?>) respT_expr_list).size();
			for (Object respT_expr : (EList<?>) respT_expr_list) {
				if (contains(respT_expr,respT_name)) break;
				index++;
			}
		}
		
		// @formatter:off
		List<InitialNode> initialNodes = activity.getOwnedNodes()
				.stream()
				.filter(n -> n instanceof InitialNode)
				.map(n -> (InitialNode) n)
				.collect(Collectors.toList());
		// @formatter:on

		/* Validate that the color i of respTi is in the range [1.. max_number_colors],
		 where max_number_colors is defined indirectly by the initial node */
		// Validate there's only one initial node
		if (initialNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'InitialNodes' found in Activity ''{0}''. Expected 1, but found ''{1}''",
					domainElement, initialNodes.size()));
		}

		// Validate it defines a pattern
		InitialNode initialNode = initialNodes.get(0);
		Object hadoopPopulation = UMLUtil.getTaggedValue(initialNode, HADOOP_WORKLOAD_EVENT, HADOOP_POPULATION);
		if (hadoopPopulation == null) {
			throw new RuntimeException(
					MessageFormat.format("InitialNode ''{0}'' in Activity ''{1}'' does not define a valid workload, obtained the following pattern ''{2}''", initialNode, domainElement, hadoopPopulation));
		}
		
		int num_colors_population = ((EList<?>) hadoopPopulation).size();		
		if (num_colors_population  < num_colors_respT) {
			throw new RuntimeException(
					MessageFormat.format("The HadoopScenario in Activity ''{0}'' defines more response times (''{1}'') than Hadoop populations (''{2}'')", domainElement, num_colors_population, num_colors_respT));
		}
		return calculateClosedByColor(activity, definition, toolResult, traceSet, index, num_colors_respT);
	}

	private DomainMeasure calculateClosedByColor(Activity activity, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet, int index, int num_colors) {
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
						
			if (placeInfos.size() < num_colors) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected at least ''{1}'', but found ''{2}''",
						initialNode, num_colors, placeInfos.size()));
			}
			if (transitionInfos.size() < num_colors) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'TransitionInfos' found for ''{0}''. Expected at least ''{1}'', but found ''{2}''",
						finalNode, num_colors, transitionInfos.size()));
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
			
			List<PlaceInfo> placeInfoList = getPlaceInfosByColor (placeInfos, index);
			List<PlaceInfo> placeInfoStartList = getStartPlaceInfos (placeInfoList);
			
			if (placeInfoStartList.size() != 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'Start' places in the Petri Net: found ''{0}''. Expected only one",
						placeInfoStartList.size()));
			}
			
			PlaceInfo placeInfo = placeInfoStartList.get(0);			
			Place p = (Place) placeInfo.getAnalyzedElement();
			
			List<TransitionInfo> transitionInfoList = getTransitionInfosByColor (transitionInfos, index);
			List<TransitionInfo> transitionInfoEndList = getEndTransitionInfos (transitionInfoList);
			
			if (transitionInfoEndList.size() != 1) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'End' transitions in the Petri Net: found ''{0}''. Expected only one",
						transitionInfoEndList.size()));
			}
			
			TransitionInfo transitionInfo = transitionInfoEndList.get(0);
			
			double initialMarking = getInitialMarkingColor(p, index);
			double meanMarking = placeInfo.getValue().doubleValue();
			
			BigDecimal dividend = new BigDecimal(initialMarking - meanMarking);
			BigDecimal divisor = new BigDecimal(transitionInfo.getThroughput().toString());

			BigDecimal rawValue = dividend.divide(divisor, MathContext.DECIMAL64);
			String targetUnit = definition.getVslExpressionEntries().get("unit") != null ? definition.getVslExpressionEntries().get("unit") : "s";

			DomainMeasure measure = buildMeasure(rawValue, transitionInfo.getUnit(), targetUnit);
			measure.setDefinition(definition);
			return measure;
		}
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
