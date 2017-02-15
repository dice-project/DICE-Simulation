package es.unizar.disco.simulation.ui.dialogs;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.UMLPackage;

import es.unizar.disco.core.ui.dialogs.FileSelectionDialog;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class UmlFileSelectionDialog extends FileSelectionDialog {

	private final class IsUmlFileStatusValidator extends IsFileStatusValidator {
		@Override
		public IStatus validate(Object[] selection) {
			IStatus superResult = super.validate(selection);
			if (!superResult.isOK()) {
				return superResult;
			} else {
				IFile file = (IFile) selection[0];
				if (isUmlModel(new File(file.getLocationURI()))) {
					return new Status(IStatus.OK, DiceSimulationUiPlugin.PLUGIN_ID, "");
				} else {
					return new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, "Selected element is not a valid UML2 file");
				}
			}
		}
	}

	public UmlFileSelectionDialog(Shell parent) {
		this(parent, null);
	}

	public UmlFileSelectionDialog(Shell parent, IResource initialSelection) {
		super(parent, initialSelection);
		this.setValidator(new IsUmlFileStatusValidator());
	}

	private static boolean isUmlModel(File file) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = null;
		try { 
			resource = resourceSet.getResource(org.eclipse.emf.common.util.URI.createFileURI(file.getAbsolutePath()), true);
			EObject eObject = resource.getContents().get(0);
			if (UMLPackage.eINSTANCE.getNsURI().equals(eObject.eClass().getEPackage().getNsURI())) {
				return true;
			} else {
				return false;
			}
		} catch (Throwable t) {
			// Unable to get the first root element
			// The file is not a valid EMF resource
		}
		return false;
	}
}


