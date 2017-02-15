package es.unizar.disco.simulation.models.datatypes.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class CustomResourceImpl extends ResourceImpl {

	private ResourceSet internalResourceSet;

	@Override
	public void setUri(URI newUri) {
		URI oldUri = super.getUri();
		super.setUri(newUri);
		if (newUri != oldUri) {
			resource = null;
		}
	}

	@Override
	public Resource getResource() {
		Resource resource = super.getResource();
		if (resource == null) {
			if (super.getUri() != null) {
				try {
					ResourceSet resourceSet = getResourceSet();
					resource = resourceSet.getResource(super.getUri(), true);
				} catch (Throwable t) {
					// We only care about getting a valid Resource
					// from a domainResourceURI ignoring any error
				}
			}
		}
		return resource;
	}

	private ResourceSet getResourceSet() {
		if (eResource() != null && eResource().getResourceSet() != null) {
			return eResource().getResourceSet();
		}
		if (internalResourceSet == null) {
			internalResourceSet = new ResourceSetImpl();
		}
		return internalResourceSet;
	}
}
