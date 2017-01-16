package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.ExecutableNode;
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

	private static final String HADOOP_COMPUTATION = "DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopComputationNode";
	private static final String HADOOP_NCORES = "nCores";
	
	/*private boolean contains(Object respT_expr, String respT_name){
		boolean isPresent = false;
		if (respT_expr instanceof String && StringUtils.isNotBlank((String) respT_expr)) {
			String[] elem = StringUtils.split((String) respT_expr, ",()=");
			for (String elem_val : elem) {
				isPresent = isPresent || elem_val.equals(respT_name); 
				if (isPresent) break;
			}
		}
		return isPresent;
	}*/
	
	/* private double getMeanMarkingColor (PlaceInfo placeInfo, int index){
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
	 */

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

		// @formatter:off
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(domainElement, toolResult, traceSet);
		List<PlaceInfo> placeInfos = infos
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		// @formatter:on

		if (placeInfos.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected 1, but found ''{1}''", domainElement,
					placeInfos.size()));
		} else {
			PlaceInfo placeInfo = placeInfos.get(0);
			Place place = (Place) placeInfo.getAnalyzedElement();
			
			ExecutableNode execution_node = (ExecutableNode) domainElement;
			//Activity activity = (Activity) domainElement;
			Object nCore_list = UMLUtil.getTaggedValue(execution_node, HADOOP_COMPUTATION, HADOOP_NCORES);
			//String nCore_name = definition.getVslExpressionEntries().get("expr") != null ? definition.getVslExpressionEntries().get("expr") : null;
			
			int num_colors = ((EList<?>) nCore_list).size();
			double sum = 0.0;
			for (int i = 0; i < num_colors; i++) {
				sum = getInitialMarkingColor(place, i);
			}		

			BigDecimal meanNumberToken = new BigDecimal(placeInfo.getMeanNumberOfTokens().toString());
			//BigDecimal initialMarking = new BigDecimal(place.getInitialMarking().getText());
			BigDecimal initialMarking = new BigDecimal(sum);
			BigDecimal result = initialMarking.subtract(meanNumberToken).divide(initialMarking, MathContext.DECIMAL64).multiply(new BigDecimal(100));

			// This is always a percentage, ignore whatever the
			// DomainMeasureDefinition defines
			DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
			measure.setDefinition(definition);
			measure.setUnit(NonStandardUnits.PERCENTAGE.getLiteral());
			measure.setValue(result);
			return measure;
		}
	}
	
	/*private DomainMeasure calculateColor(Activity activity, DomainMeasureDefinition definition, ToolResult toolResult, TraceSet traceSet, int index, int num_colors) {
		PlaceInfo placeInfo = placeInfos.get(0);
		Place place = (Place) placeInfo.getAnalyzedElement();
		
		ExecutableNode execution_node = (ExecutableNode) domainElement;
		//Activity activity = (Activity) domainElement;
		Object nCore_list = UMLUtil.getTaggedValue(execution_node, HADOOP_COMPUTATION, HADOOP_NCORES);
		String nCore_name = definition.getVslExpressionEntries().get("expr") != null ? definition.getVslExpressionEntries().get("expr") : null;
		
		int initial_marking
		int num_colors = ((EList<?>) nCore_list).size();
		for (int i = 0; i < num_colors; i++) {
			sum = getInitialMarkingColor(place, index);
		}
		
		

		BigDecimal meanNumberToken = new BigDecimal(placeInfo.getMeanNumberOfTokens().toString());
		BigDecimal initialMarking = new BigDecimal(place.getInitialMarking().getText());
		BigDecimal result = initialMarking.subtract(meanNumberToken).divide(initialMarking, MathContext.DECIMAL64).multiply(new BigDecimal(100));

		// This is always a percentage, ignore whatever the
		// DomainMeasureDefinition defines
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
		measure.setDefinition(definition);
		measure.setUnit(NonStandardUnits.PERCENTAGE.getLiteral());
		measure.setValue(result);
		return measure;
	}*/
}
