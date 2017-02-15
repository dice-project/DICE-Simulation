package es.unizar.disco.simulation.models.measures.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;

public class CustomDomainMeasureDefinition extends DomainMeasureDefinitionImpl implements DomainMeasureDefinition {

	@Override
	public String getVslExpression() {
		List<String> stringEntries = new ArrayList<>();
		for (Entry<String, String> entry : getVslExpressionEntries()) {
			stringEntries.add(entry.getKey() + "=" + entry.getValue());
		}
		return "(" + StringUtils.join(stringEntries, ", ") + ")";
	}

	@Override
	public void setVslExpression(String newVslExpression) {
		if (newVslExpression == null) {
			throw new NullPointerException("VSL expression must not be null");
		}
		newVslExpression = newVslExpression.trim();
		if (!newVslExpression.startsWith("(") || !newVslExpression.endsWith(")")) {
			throw new IllegalVslExpressionException(MessageFormat.format("VSL expression ''{0}'' is not a valid tuple", newVslExpression));
		}
		newVslExpression = StringUtils.removeStart(newVslExpression, "(");
		newVslExpression = StringUtils.removeEnd(newVslExpression, ")");

		// Order entries by their key
		TreeMap<String, String> entries = new TreeMap<String, String>();
		for (String segment : newVslExpression.split(",")) {
			String[] entry = segment.split("=");
			if (entry.length != 2) {
				throw new IllegalVslExpressionException(MessageFormat.format("VSL expression entry ''{0}'' is not a valid assignment", segment));
			}
			String key = entry[0].trim();
			String value = entry[1].trim();
			entries.put(key, value);
		}

		getVslExpressionEntries().clear();
		getVslExpressionEntries().putAll(entries);
	}

	@Override
	public OutputVariable basicGetOutputVariable() {
		String vslExpression = getVslExpression();
		if (Pattern.compile("\\$\\w+.\\$\\w+").matcher(vslExpression).matches()) {
			throw new IllegalVslExpressionException(MessageFormat.format("VSL expression ''{0}'' contains more than one variable", vslExpression));
		}
		Pattern varPattern = Pattern.compile(".*\\$(\\w+).*");
		Matcher matcher = varPattern.matcher(vslExpression);
		if (matcher.matches()) {
			String var = matcher.group(1);
			return getSimulationDefinition().getOutputVariablesMap().get(var);
		}
		return null;
	}
}
