package es.unizar.disco.simulation.models.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class DiceMetricsUtils {

	private static final String EXTENSION_ID = "es.unizar.disco.simulation.models.supported_metrics";
	
	private static final String STEREOTYPE = "stereotype";
	
	private static final String TAG = "tag";

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
				String stereotype = configElement.getAttribute(STEREOTYPE);
				String tag = configElement.getAttribute(TAG);
				metrics.add(new Metric(stereotype, tag));
			}
		}
		return Collections.unmodifiableSet(metrics);
	}

}
