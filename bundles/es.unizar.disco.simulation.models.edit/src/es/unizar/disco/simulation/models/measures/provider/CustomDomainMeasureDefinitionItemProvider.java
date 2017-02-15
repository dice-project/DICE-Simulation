package es.unizar.disco.simulation.models.measures.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;

public class CustomDomainMeasureDefinitionItemProvider extends DomainMeasureDefinitionItemProvider {

	public CustomDomainMeasureDefinitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		DomainMeasureDefinition definition = (DomainMeasureDefinition)object;
		StringBuilder builder = new StringBuilder();
		builder.append(definition.getMeasure());
		String expression = definition.getVslExpression();
		if (expression != null && expression.length() > 0) {
			builder.append(": ");
			builder.append(expression);
		}
		return builder.toString();
	}
	
}
