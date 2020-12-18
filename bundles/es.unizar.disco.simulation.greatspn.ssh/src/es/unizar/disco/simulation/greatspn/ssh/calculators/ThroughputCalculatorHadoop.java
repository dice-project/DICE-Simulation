/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.util.UMLUtil;

import es.unizar.disco.pnml.m2t.utils.PnmlToolInfoUtils;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import fr.lip6.move.pnml.ptnet.Arc;
import fr.lip6.move.pnml.ptnet.Place;
import fr.lip6.move.pnml.ptnet.ToolInfo;
import fr.lip6.move.pnml.ptnet.Transition;

public class ThroughputCalculatorHadoop extends AbstractCalculator implements MeasureCalculator {

	private static final String HADOOP_SCENARIO = "DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopScenario";
	private static final String HADOOP_THRU = "throughput";

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
	
	@Override
	public DomainMeasure calculate(EObject domainElement, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet) {
		// @formatter:off
		//
		// Throughput is directly obtained from a TransitionInfo corresponding
		// to the input domain element
		//
		// Pattern:
		//		--->[T]--->
		// 		
		// throughput = throughput(T)
		//		
		
		// From other calculators:
		if (!isAdequateFor(domainElement)) {
			throw new IllegalArgumentException(MessageFormat
					.format("Domain element ''{0}'' is not of type 'org.eclipse.uml2.uml.Activity' but type ''{1}''", domainElement, domainElement.getClass()));
		}

		Activity activity = (Activity) domainElement;
		
		/**/
		Object thru_expr_list = UMLUtil.getTaggedValue(activity, HADOOP_SCENARIO, HADOOP_THRU);
		String thru_name = definition.getVslExpressionEntries().get("expr") != null ? definition.getVslExpressionEntries().get("expr") : null;
		
		/* A MapReduce diagram in UML can have several types of users (i.e., colors).
		 * For instance, [T1, T2, T3] represents the 'throughput' for 
		 * three different kind of users. */
		/* In case of having several users, we must decide which 'throughput' we
		 * have to calculate. */
		int index = 0;
		int num_colors = 1;
		/* thru_expr_list = [T1, T2, T3] */
		/* thru_expr = Ti = (expr=$Ti, statQ=mean, source=calc)
		 * thru_name = $Ti */
		if ( (thru_expr_list != null) &&
			 (thru_expr_list instanceof EList<?>))  {
			num_colors = ((EList<?>) thru_expr_list).size();
			for (Object respT_expr : (EList<?>) thru_expr_list) {
				if (contains(respT_expr,thru_name)) break;
				index++;
			}
		}
		/**/
		
		// @formatter:off
		List<InitialNode> initialNodes = activity.getOwnedNodes()
				.stream()
				.filter(n -> n instanceof InitialNode)
				.map(n -> (InitialNode) n)
				.collect(Collectors.toList());

		// Validate there's only one initial node
		if (initialNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'InitialNodes' found in Activity ''{0}''. Expected 1, but found ''{1}''",
					domainElement, initialNodes.size()));
		}

		// Validate it defines a pattern
		InitialNode initialNode = initialNodes.get(0);
		//String hadoopPopulation = (String) UMLUtil.getTaggedValue(initialNode, HADOOP_WORKLOAD_EVENT, HADOOP_POPULATION);
		Object hadoopPopulation = UMLUtil.getTaggedValue(initialNode, HADOOP_WORKLOAD_EVENT, HADOOP_POPULATION);
		if (hadoopPopulation == null) {
			throw new RuntimeException(
					MessageFormat.format("InitialNode ''{0}'' in Activity ''{1}'' does not define a valid workload, obtained the following pattern ''{2}''", initialNode, domainElement, hadoopPopulation));
		}
		
		
		List<ActivityFinalNode> finalNodes = activity.getOwnedNodes().stream()
				.filter(n -> n instanceof ActivityFinalNode).map(n -> (ActivityFinalNode) n)
				.collect(Collectors.toList());
		// @formatter:on
		
		if (finalNodes.size() != 1) {
			throw new RuntimeException(MessageFormat.format(
					"Unexpected number of 'ActivityFinalNodes' found for ''{0}''. Expected 1, but found ''{1}''",
					activity, finalNodes.size()));
		} else {
			// @formatter:off
			FinalNode finalNode = finalNodes.get(0);
			return calculateFromFinalNode(finalNode, toolResult, traceSet, activity, definition, true, index, num_colors);

		}		
	}

	private DomainMeasure calculateFromFinalNode(FinalNode finalNode, ToolResult toolResult, TraceSet traceSet,
			Activity activity, DomainMeasureDefinition definition, boolean calculatingReliability, int index, int num_colors) {

		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(finalNode, toolResult, traceSet);
		List<TransitionInfo> transitionInfos = infos
				.stream()
				.filter(i -> i instanceof TransitionInfo)
				.map(i -> (TransitionInfo) i)
				.collect(Collectors.toList());
		// @formatter:on

		/*
		 * int num_colors = func.call();
		 * int index = num_colors-1;
		*/
		
		if (transitionInfos.size() < num_colors) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'TransitionInfos' found for ''{0}''. Expected at least ''{1}'', but found ''{1}''", finalNode, num_colors, transitionInfos.size()));
		} else {
			//TransitionInfo transitionInfo = transitionInfos.get(0);
			TransitionInfo transitionInfo = getTransitionInfoByColor (transitionInfos, index);
			DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
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
			}
			return measure;
		}
	}

	@Override
	public Boolean isAdequateFor(EObject domainElement) {
		return (domainElement instanceof Activity);
	}
}
