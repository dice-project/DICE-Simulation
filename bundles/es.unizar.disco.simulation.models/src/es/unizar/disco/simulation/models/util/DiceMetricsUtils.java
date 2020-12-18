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
package es.unizar.disco.simulation.models.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.models.DiceModelsPlugin;
import es.unizar.disco.simulation.models.datatypes.ComputableNFPtype;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.toolresult.ToolResult;

@SuppressWarnings("unused")
public class DiceMetricsUtils {

	private static final String EXTENSION_ID = "es.unizar.disco.simulation.models.supported_metrics";

	private static final String ELEMENT_METRIC = "Metric";
	private static final String ELEMENT_METRIC_TAG = "MetricTag";
	private static final String ELEMENT_CALCULATOR = "CALCULATOR";

	private static final String METRIC_TAG_ID = "id";
	private static final String METRIC_TAG_FAMILY_NFP = "familyNFPproperty";

	private static final String METRIC_NAME = "name";
	private static final String METRIC_STEREOTYPE = "stereotype";
	private static final String METRIC_TAG = "tag";
	private static final String METRIC_ANALYZABLE_PROPERTY = "analyzableProperty";

	private static final String CALCULATOR_SCENARIO = "scenario";
	private static final String CALCULATOR_TOOL_RESULT = "toolResult";
	private static final String CALCULATOR_CLASS = "class";

	public static class Metric {
		public final String stereotype;
		public final String tag;

		public Metric(String stereotype, String tag) {
			this.stereotype = stereotype;
			this.tag = tag;
		};
	}

	private static Set<Metric> metrics;

	public static Set<Metric> getSupportedMetrics() {
		if (metrics == null) {
			metrics = new HashSet<>();
			IConfigurationElement[] configElements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(EXTENSION_ID);
			for (IConfigurationElement configElement : configElements) {
				if (ELEMENT_METRIC.equals(configElement.getName())) {
					String stereotype = configElement.getAttribute(METRIC_STEREOTYPE);
					String tag = configElement.getAttribute(METRIC_TAG);
					metrics.add(new Metric(stereotype, tag));
				}
			}
		}
		return Collections.unmodifiableSet(metrics);
	}

	/*public static MeasureCalculator getCalculator(Element element, String measure, String scenarioStereotype,
			Class<? extends ToolResult> clazz) {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_ID);
		for (IConfigurationElement configElement : configElements) {
			if (ELEMENT_METRIC.equals(configElement.getName())) {
				try {
					Stereotype stereotype = element
							.getAppliedStereotype(configElement.getAttribute(METRIC_STEREOTYPE));
					if (StringUtils.equals(measure, configElement.getAttribute(METRIC_TAG))
							&& element.isStereotypeApplied(stereotype)) {

						for (IConfigurationElement calculatorConfigElement : configElement.getChildren()) {
							if (StringUtils.equals(scenarioStereotype,
									calculatorConfigElement.getAttribute(CALCULATOR_SCENARIO))
									&& Class.forName(calculatorConfigElement.getAttribute(CALCULATOR_TOOL_RESULT))
											.isAssignableFrom(clazz)) {
								return (MeasureCalculator) calculatorConfigElement
										.createExecutableExtension(CALCULATOR_CLASS);
							}

						}
					}
				} catch (CoreException | ClassNotFoundException | InvalidRegistryObjectException e) {
					// In case of error, log it and ignore the defective entry
					DiceLogger.logException(DiceModelsPlugin.getDefault(), e);
				}
			}
		}
		return null;
	}*/
	
	/*public static MeasureCalculator getCalculator(Element element, String measure, String scenarioStereotype, SimulationInvocation invocation) {
		Class<? extends ToolResult> clazz = invocation.getToolResult().getClass();
		EObject activeScenario = invocation.getDefinition().getActiveScenario();
		if (activeScenario.equals()){}
		*/
	public static MeasureCalculator getCalculator(Element element, String measure, String scenarioStereotype,
			Class<? extends ToolResult> clazz) {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_ID);
		for (IConfigurationElement configElement : configElements) {
			if (ELEMENT_METRIC.equals(configElement.getName())) {
				try {
					Stereotype stereotype = element
							.getAppliedStereotype(configElement.getAttribute(METRIC_STEREOTYPE));
					if (StringUtils.equals(measure, configElement.getAttribute(METRIC_TAG))
							&& element.isStereotypeApplied(stereotype)) {

						for (IConfigurationElement calculatorConfigElement : configElement.getChildren()) {
							if (StringUtils.equals(scenarioStereotype,
									calculatorConfigElement.getAttribute(CALCULATOR_SCENARIO))
									&& Class.forName(calculatorConfigElement.getAttribute(CALCULATOR_TOOL_RESULT))
											.isAssignableFrom(clazz)) {
								Object cScenario = calculatorConfigElement.getAttribute(CALCULATOR_SCENARIO);//
								/* return (MeasureCalculator) calculatorConfigElement
										.createExecutableExtension(CALCULATOR_CLASS); */
								MeasureCalculator mesCalc = (MeasureCalculator) calculatorConfigElement.createExecutableExtension(CALCULATOR_CLASS);
								if (mesCalc.isAdequateFor(element)){
									return mesCalc;
								}
							}

						}
					}
				} catch (CoreException | ClassNotFoundException | InvalidRegistryObjectException e) {
					// In case of error, log it and ignore the defective entry
					DiceLogger.logException(DiceModelsPlugin.getDefault(), e);
				}
			}
		}
		return null;
	}

	public static boolean metricComputedBelongsToSelectedNFPtypeToCompute(ComputableNFPtype chosenNFPtoCompute,
			String measureInModel) {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_ID);
		for (IConfigurationElement configElement : configElements) {
			if (ELEMENT_METRIC_TAG.equals(configElement.getName())) {
				if (measureInModel.equalsIgnoreCase(configElement.getAttribute(METRIC_TAG_ID)) && (chosenNFPtoCompute
						.getLiteral().equalsIgnoreCase(configElement.getAttribute(METRIC_TAG_FAMILY_NFP)))) {
					return true;
				}
			}

		}
		return false;
	}
}
