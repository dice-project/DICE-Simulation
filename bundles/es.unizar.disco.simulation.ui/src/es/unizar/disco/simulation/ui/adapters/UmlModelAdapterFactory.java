package es.unizar.disco.simulation.ui.adapters;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.services.resourceloading.OnDemandLoadingModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;

public class UmlModelAdapterFactory implements IAdapterFactory {

	private final Class<?>[] adapterTypes = { UmlModel.class };

	
	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		IResource resource = Platform.getAdapterManager().getAdapter(adaptableObject, IResource.class);
		if (UmlModel.class.equals(adapterType) && resource != null) {
			OnDemandLoadingModelSet modelSet = new OnDemandLoadingModelSet();
			modelSet.createModels(URI.createFileURI(resource.getLocation().toString()));
			return adapterType.cast(UmlUtils.getUmlModel(modelSet));
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return adapterTypes;
	}

}
