package es.unizar.disco.simulation.ui.launcher.providers;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.definition.InputVariableValue;

public class ValuesEditingSupport extends EditingSupport {
	
	private CellEditor editor;
	
	public ValuesEditingSupport(TableViewer viewer) {
		super(viewer);
		this.editor = new TextCellEditor(viewer.getTable());
	}

	@Override
	protected void setValue(Object element, Object value) {
		Number number = (Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, (String) value);
		((InputVariableValue) element).setValue(number);
		getViewer().update(element, null);
	}

	@Override
	protected Object getValue(Object element) {
		return EcoreUtil.convertToString(DatatypesPackage.Literals.NUMBER, ((InputVariableValue) element).getValue());
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return editor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}
}