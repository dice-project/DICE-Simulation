package es.unizar.disco.simulation.models.definition.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.InputVariableValue;

public class CustomInputVariableImpl extends InputVariableImpl {
	
	private static final String DELIM = ",";

	@Override
	public String serializeValues() {
		List<String> values = new ArrayList<>();
		for (InputVariableValue value : getValues()) {
			values.add(value.getValue().toString());
		}
		return StringUtils.join(values.toArray(), DELIM);
	}
	
	@Override
	public void deserializeValues(String values) {
		StringTokenizer tokenizer = new StringTokenizer(values, DELIM);
		while (tokenizer.hasMoreElements()) {
			String token = tokenizer.nextToken();
			InputVariableValue value = DefinitionFactory.eINSTANCE.createInputVariableValue();
			Number number = (Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, token);
			value.setValue(number);
			getValues().add(value);
		}
	}
}
