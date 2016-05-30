package es.unizar.disco.simulation.ui.launcher.strategies;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.emf.common.util.URI;

public class StringToUriStrategy extends UpdateValueStrategy {
	@Override
	public Object convert(Object value) {
		return StringUtils.isNotBlank((String) value) ? URI.createURI(value.toString()) : null;
	}
}

