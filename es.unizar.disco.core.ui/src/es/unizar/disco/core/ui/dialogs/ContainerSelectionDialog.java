package es.unizar.disco.core.ui.dialogs;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class ContainerSelectionDialog extends ElementTreeSelectionDialog {

	public ContainerSelectionDialog(Shell parent) {
		this(parent, null);
	}
	
	public ContainerSelectionDialog(Shell parent, IResource initialSelection) {
		super(parent, WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider(), new WorkbenchContentProvider());
		this.setAllowMultiple(false);
		this.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof IContainer;
			}
		});
		this.setTitle("Container Selection"); //$NON-NLS-1$
		this.setMessage("Select a directory from the workspace:"); //$NON-NLS-1$
		this.setInput(ResourcesPlugin.getWorkspace().getRoot());
		this.setComparator(new ResourceComparator(ResourceComparator.NAME));
		
		if (initialSelection != null) {
			this.setInitialSelection(initialSelection);
		} else {
			ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof IResource) {
					IResource resource = (IResource) structuredSelection.getFirstElement();
					if (resource instanceof IContainer) {
						this.setInitialSelection(resource);
					} else if (resource.getParent() != null) {
						this.setInitialSelection(resource.getParent());
					}
				}
			}
		}
	}

	public IContainer getContainer() {
		return (IContainer) getFirstResult();
	}
	
	
}
