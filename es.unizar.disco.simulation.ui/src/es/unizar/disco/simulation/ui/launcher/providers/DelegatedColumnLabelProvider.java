package es.unizar.disco.simulation.ui.launcher.providers;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

public class DelegatedColumnLabelProvider extends ColumnLabelProvider {
	
	protected ILabelProvider labelProvider;
	
	public DelegatedColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
		this.labelProvider = delegatedLabelProvider;
	}

	@Override
	public String getText(Object element) {
		return labelProvider.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		return labelProvider.getImage(element);
	}
}