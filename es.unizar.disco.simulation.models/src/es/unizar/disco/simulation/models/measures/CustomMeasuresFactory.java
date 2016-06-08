package es.unizar.disco.simulation.models.measures;

public interface CustomMeasuresFactory extends MeasuresFactory {

	@Override
	DomainMeasureDefinition createDomainMeasureDefinition();
	
}
