package es.unizar.disco.simulation.greatspn.ssh.converters;

import java.text.MessageFormat;

import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.MeasureConverter;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;

public class ThroughputConverter implements MeasureConverter {

	@Override
	public DomainMeasure convert(AnalyzableElementInfo info) {
		if (!(info instanceof TransitionInfo)) {
			throw new IllegalArgumentException(MessageFormat.format("Unexpected 'AnalizableElementInfo' found: '{0}', expecting 'TransitionInfo'", info));
		}
		TransitionInfo transitionInfo = (TransitionInfo) info;
		DomainMeasure measure = MeasuresFactory.eINSTANCE.createDomainMeasure();
		measure.setUnit(transitionInfo.getUnit());
		measure.setValue(transitionInfo.getValue());
		return measure;
	}

}
