package es.unizar.disco.simulation.models.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.models.DiceModelsPlugin;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;

@SuppressWarnings("unused")
public class DiceMetricsUtils {

	private static final String EXTENSION_ID = "es.unizar.disco.simulation.models.supported_metrics";
	
	private static final String ELEMENT_METRIC = "Metric";
	private static final String ELEMENT_METRIC_TAG = "MetricTag";
	private static final String ELEMENT_CONVERTER = "Converter";
	
	
	private static final String METRIC_TAG_ID = "id";
	
	private static final String METRIC_NAME = "name";
	private static final String METRIC_STEREOTYPE = "stereotype";
	private static final String METRIC_TAG = "tag";
	private static final String METRIC_CONVERTER = "converter";

	private static final String CONVERTER_ID = "id";
	private static final String CONVERTER_METRIC = "metric";
	private static final String CONVERTER_DOMAIN_ELEMENT = "domainElement";
	private static final String CONVERTER_CLASS = "class";

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
			IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
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


	public static MeasureCalculator getCalculator(Class<?> clazz, String measure) {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for (IConfigurationElement configElement : configElements) {
			if (ELEMENT_CONVERTER.equals(configElement.getName())) {
				try {
					if (StringUtils.equals(measure, configElement.getAttribute(CONVERTER_METRIC)) &&
							Class.forName(configElement.getAttribute(CONVERTER_DOMAIN_ELEMENT)).isAssignableFrom(clazz)) {
						return (MeasureCalculator) configElement.createExecutableExtension(CONVERTER_CLASS);
					}
				} catch (ClassNotFoundException | CoreException e) {
					// In case of error, log it and ignore the defective entry
					DiceLogger.logException(DiceModelsPlugin.getDefault(), e);
				}
			}
		}
		return null;
	}
}
