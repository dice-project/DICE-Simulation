package es.unizar.disco.core.ui.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

import es.unizar.disco.core.ui.DiceCoreUiPlugin;

public class FileSelectionDialog extends ElementTreeSelectionDialog {

	public class IsFileStatusValidator implements ISelectionStatusValidator {
		@Override
		public IStatus validate(Object[] selection) {
			if (selection.length == 1 && selection[0] instanceof IFile) {
				return new Status(IStatus.OK, DiceCoreUiPlugin.PLUGIN_ID, "");
			} else {
				return new Status(IStatus.ERROR, DiceCoreUiPlugin.PLUGIN_ID, Messages.FileSelectionDialog_notFileError);
			}
		}
	}

	public FileSelectionDialog(Shell parent) {
		this(parent, null);
	}
	
	public FileSelectionDialog(Shell parent, IResource initialSelection) {
		super(parent, WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider(), new WorkbenchContentProvider());
		this.setAllowMultiple(false);
		this.setTitle(Messages.FileSelectionDialog_dialogTitle);
		this.setMessage(Messages.FileSelectionDialog_dialogMessage); 
		
		this.setInput(ResourcesPlugin.getWorkspace().getRoot());
		
		this.setComparator(new ResourceComparator(ResourceComparator.NAME));
		
		this.setValidator(new IsFileStatusValidator());
		
		if (initialSelection != null) {
			this.setInitialSelection(initialSelection);
		} else {
			ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof IResource) {
					this.setInitialSelection(structuredSelection.getFirstElement());
				}
			}
		}
	}

	public IFile getFile() {
		return (IFile) getFirstResult();
	}
	
	
}
