package es.unizar.disco.simulation.models.util;

import es.unizar.disco.simulation.models.marteconstants.SupportedMetrics;

public class MarteMetricsUtils {

	public static String getStereotypeName(SupportedMetrics metric) {
		return metric.getLiteral().split("#")[0];
	}

	public static String getTaggedValueName(SupportedMetrics metric) {
		return metric.getLiteral().split("#")[1];
	}
	
}
