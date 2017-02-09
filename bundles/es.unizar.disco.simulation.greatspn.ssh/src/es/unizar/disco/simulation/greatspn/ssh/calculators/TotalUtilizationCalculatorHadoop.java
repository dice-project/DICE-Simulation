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
import org.eclipse.uml2.uml.Element;
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

public class TotalUtilizationCalculatorHadoop extends AbstractCalculator implements MeasureCalculator {

	private static final String HADOOP_COMPUTATION_NODE = "DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopComputationNode";
	private static final String HADOOP_NCORES = "nCores";
	
	private double getInitialMarkingColor (Place place, int index){				
		PnmlToolInfoUtils converter = new PnmlToolInfoUtils();
		Iterator<ToolInfo> itr = place.getToolspecifics().iterator();
		while (itr.hasNext()){
			ToolInfo t = (ToolInfo) itr.next();	
			if (PnmlToolInfoUtils.isColor(t) &&
			   (Integer.valueOf(converter.getColorNameValue(t)) == index) ){
				return PnmlToolInfoUtils.getnumElementsColor(t).doubleValue();
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

		Element hadoopComputationCore = (Element) domainElement;	
		Object nCores_list = UMLUtil.getTaggedValue(hadoopComputationCore, HADOOP_COMPUTATION_NODE, HADOOP_NCORES);
		int num_colors = 0;
		
		if ( (nCores_list != null) &&
			 (nCores_list instanceof EList<?>))  {
			num_colors = ((EList<?>) nCores_list).size();
		}
		
		// @formatter:off
		Set<AnalyzableElementInfo> infos = findInfosForDomainElement(domainElement, toolResult, traceSet);
		List<PlaceInfo> placeInfosRes = infos
				.stream()
				.filter(i -> i instanceof PlaceInfo)
				.map(i -> (PlaceInfo) i)
				.collect(Collectors.toList());
		// @formatter:on

		if (placeInfosRes.size() != 1) {
			throw new RuntimeException(MessageFormat.format("Unexpected number of 'PlaceInfos' found for ''{0}''. Expected 1, but found ''{1}''", domainElement,
					placeInfosRes.size()));
		} else {		
			PlaceInfo placeInfoRes = placeInfosRes.get(0);
			Place placeRes = (Place) placeInfoRes.getAnalyzedElement();

			int initialMarkingByColor = 0;
			for (int index = 0; index < num_colors; index++){
				initialMarkingByColor += getInitialMarkingColor(placeRes, index);
			}

			BigDecimal meanNumberToken = new BigDecimal(placeInfoRes.getMeanNumberOfTokens().toString());
			//BigDecimal initialMarking = new BigDecimal(place.getInitialMarking().getText());
			BigDecimal initialMarking = new BigDecimal(initialMarkingByColor);
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
}
