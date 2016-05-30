package es.unizar.disco.simulation.ui.launcher.providers;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

public class ValuesColumnLabelProvider extends ColumnLabelProvider {
	private ILabelProvider labelProvider;
	
	public ValuesColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
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