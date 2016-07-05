package es.unizar.disco.simulation.models.wnsim.provider;

import java.util.Date;

import org.eclipse.emf.common.notify.AdapterFactory;

import es.unizar.disco.simulation.models.wnsim.WnsimResult;

public class CustomWnsimResultItemProvider extends WnsimResultItemProvider {

	public CustomWnsimResultItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		Date timestamp = ((WnsimResult)object).getTimestamp();

		StringBuilder builder = new StringBuilder("Simulation Tool Result");
		builder.append("[");
		builder.append(timestamp);
		builder.append("]");
		
		return builder.toString();
	}
}
