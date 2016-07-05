package es.unizar.disco.simulation.models.measures;

import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;

public interface MeasureConverter {
	
	public DomainMeasure convert(AnalyzableElementInfo info);

}
