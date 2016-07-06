package es.unizar.disco.simulation.greatspn.ssh.calculators;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.datatypes.Unit;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import fr.lip6.move.pnml.ptnet.Place;

public class UtilizationCalculator extends AbstractCalculator implements MeasureCalculator {

	@Override
	public DomainMeasure calculate(EObject domainElement, ToolResult toolResult, TraceSet traceSet) {
		// Utilization
		// ** Only in Places that denote a Resource **
		//		utilization = (initial_marking - mean_n_tokens) / initial_marking
		for (AnalyzableElementInfo info : findInfosForDomainElement(domainElement, toolResult, traceSet)) {
			if (info instanceof PlaceInfo) {
				PlaceInfo placeInfo = (PlaceInfo) info;
				BigDecimal meanNumberToken = new BigDecimal(placeInfo.getMeanNumberOfTokens().toString());
				Place place = (Place) placeInfo.getAnalyzedElement();
				BigDecimal initialMarking = new BigDecimal(place.getInitialMarking().getText());
				BigDecimal result = initialMarking.subtract(meanNumberToken).divide(initialMarking);
				DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
				measure.setUnit(Unit.PERCENTAGE);
				measure.setValue(result);
				return measure;
			}
		}
		return null;
	}

}
