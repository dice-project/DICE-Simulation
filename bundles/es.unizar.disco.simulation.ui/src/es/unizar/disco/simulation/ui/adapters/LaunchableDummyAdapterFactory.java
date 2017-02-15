package es.unizar.disco.simulation.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.ILaunchable;

public class LaunchableDummyAdapterFactory implements IAdapterFactory {
	
	private final Class<?>[] adapterTypes = { ILaunchable.class };

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		// Implementing this is not actually required for ILaunchable
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return adapterTypes;
	}

}
