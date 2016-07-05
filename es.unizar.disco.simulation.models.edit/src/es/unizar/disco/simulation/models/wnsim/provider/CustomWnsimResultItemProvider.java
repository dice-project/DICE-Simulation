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
		Date labelValue = ((WnsimResult)object).getTimestamp();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_WnsimResult_type") :
			getString("_UI_WnsimResult_type") + " [" + label + "]";
	}
}
