package es.unizar.disco.simulation.ui.tester;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;

public class PapyrusElementExtensionTester extends PropertyTester {

	private static final String EXTENSION_PROPERTY = "extension";

	public PapyrusElementExtensionTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		IResource resource = Platform.getAdapterManager().getAdapter(receiver, IResource.class);
		if (resource != null && EXTENSION_PROPERTY.equals(property)) {
			return StringUtils.equals(resource.getFileExtension(), (CharSequence) expectedValue);
		}
		return false;
	}
}
