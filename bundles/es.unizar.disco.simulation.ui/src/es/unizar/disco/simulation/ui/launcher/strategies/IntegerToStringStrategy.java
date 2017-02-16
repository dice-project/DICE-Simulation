package es.unizar.disco.simulation.ui.launcher.strategies;

import org.eclipse.core.databinding.UpdateValueStrategy;

public class IntegerToStringStrategy extends UpdateValueStrategy {
	@Override
	public Object convert(Object value) {
		return value != null ? value.toString() : null;
	}
}