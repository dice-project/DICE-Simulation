package es.unizar.disco.simulation.ui.launcher.strategies;

import org.eclipse.core.databinding.UpdateValueStrategy;

public class StringToIntegerStrategy extends UpdateValueStrategy {
	@Override
	public Object convert(Object value) {
		 try {
			 return Integer.parseInt(value.toString());
		 } catch (NumberFormatException e) {
			 return null;
		 }
	}
}

