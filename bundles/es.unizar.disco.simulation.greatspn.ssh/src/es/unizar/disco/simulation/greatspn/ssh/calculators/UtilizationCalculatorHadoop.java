package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.util.UMLUtil;

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
import fr.lip6.move.pnml.ptnet.Place;
import fr.lip6.move.pnml.ptnet.ToolInfo;

public class UtilizationCalculatorHadoop extends AbstractCalculator implements MeasureCalculator {

	private static final String HADOOP_SCENARIO = "DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopScenario";
	private static final String HADOOP_UTILIZATION = "utilization";
	
	private static final String HADOOP_WORKLOAD_EVENT = "DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopWorkloadEvent";
	private static final String HADOOP_POPULATION = "hadoopPopulation";
	
	private boolean contains(Object util_expr, String util_name){
		boolean isPresent = false;
		if (util_expr instanceof String && StringUtils.isNotBlank((String) util_expr)) {
			String[] elem = StringUtils.split((String) util_expr, ",()=");
			for (String elem_val : elem) {
				isPresent = isPresent || elem_val.equals(util_name); 
				if (isPresent) break;
			}
		}
		return isPresent;
	}
	
	private int numColorSets (Place place){
		Set<String> setColorSets = new HashSet<String>();
		PnmlToolInfoUtils converter = new PnmlToolInfoUtils();
		Iterator<ToolInfo> itr = place.getToolspecifics().iterator();
		while (itr.hasNext()){
			ToolInfo t = (ToolInfo) itr.next();	
			if (PnmlToolInfoUtils.isColor(t)){
				setColorSets.add(converter.getColorSetNameColor(t));
			}
		}
		return setColorSets.size();
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
	
	private List<PlaceInfo> getPlaceInfosExec (List<PlaceInfo> placeInfos){
		Iterator<PlaceInfo> itt = placeInfos.iterator();
		List<PlaceInfo> placeInfosExecList = new ArrayList<PlaceInfo>();
		
		/* Select all the 'mapExec'/'redExec' places of the Petri net */
		while (itt.hasNext()){
			PlaceInfo pInfo = (PlaceInfo) itt.next();
			Place p = (Place) pInfo.getAnalyzedElement();				
			if (numColorSets(p) == 3) {
				placeInfosExecList.add(pInfo);
			}
		}
		return placeInfosExecList;
	}
	
	private List<PlaceInfo> getPlaceInfosByColor (List<PlaceInfo> placeInfos, int index){
		Iterator<PlaceInfo> itt = placeInfos.iterator();
		List<PlaceInfo> placeInfosByColor = new ArrayList<PlaceInfo>();
		
		/* Select all the places of the Petri net with color 'index' */
		while (itt.hasNext()){
			PlaceInfo pInfo = itt.next();
			Place p = (Place) pInfo.getAnalyzedElement();
			if (hasColor (p, index)) placeInfosByColor.add(pInfo);
		}		
		return placeInfosByColor;
	}

	private double getInitialMarkingColor (Place place, int index){				
		PnmlToolInfoUtils converter = new PnmlToolInfoUtils();
		Iterator<ToolInfo> itr = place.getToolspecifics().iterator();
		while (itr.hasNext()){
			ToolInfo t = (ToolInfo) itr.next();	
			if (PnmlToolInfoUtils.isColor(t) &&
			   (Integer.valueOf(converter.getColorNameValue(t)) == index) ){
				return PnmlToolInfoUtils.getnumElementsColor(t).doubleValue();
				/*double val = PnmlToolInfoUtils.getnumElementsColor(t).doubleValue();
				return val;*/
			}
		}
		return 0.0;
	}
	
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
		
		if (!(domainElement instanceof Activity)) {
			throw new IllegalArgumentException(MessageFormat.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity'", domainElement));
		}
		
		Activity activity = (Activity) domainElement;
		
		Object util_expr_list = UMLUtil.getTaggedValue(activity, HADOOP_SCENARIO, HADOOP_UTILIZATION);
		String util_name = definition.getVslExpressionEntries().get("expr") != null ? definition.getVslExpressionEntries().get("expr") : null;
				
		/* A MapReduce diagram in UML can have several types of users (i.e., colors).
		 * For instance, [util1, util2, util3] represents the 'utilization' for 
		 * three different kind of users. */
		/* In case of having several users, we must decide which 'response time' we
		 * have to calculate. */
		int index = 0;
		int num_colors_util = 1;
		/* util_expr_list = [util1, util2, util3] */
		/* util_expr = utili = (expr=$Ui, statQ=mean, source=calc)
		 * util_name = $Ui */
		if ( (util_expr_list != null) &&
			 (util_expr_list instanceof EList<?>))  {
			num_colors_util = ((EList<?>) util_expr_list).size();
			for (Object util_expr : (EList<?>) util_expr_list) {
				if (contains(util_expr,util_name)) break;
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
		
		// @formatter:off
		//List<ActivityPartition> activityPartitions = activity.getPartitions();
		List<ActivityGroup> activityPartitions = activity.getGroups();
		// @formatter:on
		

		// Validate there are two partitions (map and reduce)
		if (activityPartitions.size() != 2) {
				throw new RuntimeException(MessageFormat.format("Unexpected number of 'ActivityPartition' found for ''{0}''. Expected 2, but found ''{1}''", domainElement,
						activityPartitions.size()));
		}
		
		int num_colors_population = ((EList<?>) hadoopPopulation).size();		
		if (num_colors_population  < num_colors_util) {
			throw new RuntimeException(
					MessageFormat.format("The HadoopScenario in Activity ''{0}'' defines more utilizations (''{1}'') than Hadoop populations (''{2}'')", domainElement, num_colors_population, num_colors_util));
		}
		return calculateUtilizationByColor(activity, definition, toolResult, traceSet, index, num_colors_util);
	}
	
	private DomainMeasure calculateUtilizationByColor(Activity activity, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet, int index, int num_colors) {
		/*
		 * For Color i
		 * mean number of tokens in execution / initial number of tokens in resources
		 * mean number of tokens in execution = mean number of tokens in mapExec + mean number of tokens in redExec 
		*/
		
		/* Find the 'resources' place */
		List<ActivityGroup> activityPartitions = activity.getGroups();	
		ActivityPartition activityPartitionMap = (ActivityPartition) activityPartitions.get(0);
		ActivityPartition activityPartitionRed = (ActivityPartition) activityPartitions.get(1);
		Element hadoopComputationCore = activityPartitionMap.getRepresents().getOwner();
		Set<AnalyzableElementInfo> activityPartitionInfosCore = findInfosForDomainElement(hadoopComputationCore , toolResult, traceSet); /* Core */			
		
		List<PlaceInfo> placeInfosRes = activityPartitionInfosCore
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		
		PlaceInfo placeInfoRes = placeInfosRes.get(0);
		Place placeRes = (Place) placeInfoRes.getAnalyzedElement();
		
		double initialMarkingByColor = getInitialMarkingColor(placeRes, index);
		
		/* Find the 'mapExec' place */
		ActivityNode mapPhase = activityPartitionMap.getContainedNodes().get(0);
		Set<AnalyzableElementInfo> mapInfos = findInfosForDomainElement(mapPhase, toolResult, traceSet);
		List<PlaceInfo> placeInfosMap = mapInfos
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		
		List<PlaceInfo> placeInfosMapExec = getPlaceInfosExec(placeInfosMap);
		List<PlaceInfo> placeInfosMapExecColor = getPlaceInfosByColor (placeInfosMapExec, index);
		PlaceInfo placeInfoMapExecColor = placeInfosMapExecColor.get(0);
		
		/* Find the 'redExec' place */
		ActivityNode redPhase = activityPartitionRed.getContainedNodes().get(0);
		Set<AnalyzableElementInfo> redInfos = findInfosForDomainElement(redPhase, toolResult, traceSet);
		List<PlaceInfo> placeInfosRed = redInfos
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		List<PlaceInfo> placeInfosRedExec = getPlaceInfosExec(placeInfosRed);
		List<PlaceInfo> placeInfosRedExecColor = getPlaceInfosByColor (placeInfosRedExec, index);
		PlaceInfo placeInfoRedExecColor = placeInfosRedExecColor.get(0);
		
		double meanNumberTokenByColor = placeInfoMapExecColor.getMeanNumberOfTokens().doubleValue() +
										placeInfoRedExecColor.getMeanNumberOfTokens().doubleValue();
		
		BigDecimal meanNumberTokenInUse = new BigDecimal(meanNumberTokenByColor);
		BigDecimal initialMarking = new BigDecimal(initialMarkingByColor);
		BigDecimal result = meanNumberTokenInUse.divide(initialMarking, MathContext.DECIMAL64).multiply(new BigDecimal(100));

		// This is always a percentage, ignore whatever the
		// DomainMeasureDefinition defines
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
		measure.setDefinition(definition);
		measure.setUnit(NonStandardUnits.PERCENTAGE.getLiteral());
		measure.setValue(result);
		return measure;
	}
}
