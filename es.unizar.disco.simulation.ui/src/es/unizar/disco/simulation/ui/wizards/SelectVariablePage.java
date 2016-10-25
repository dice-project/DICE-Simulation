package es.unizar.disco.simulation.ui.wizards;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.ui.wizards.PlotWizard.WizardData;

public class SelectVariablePage extends WizardPage {

	private WizardData data;

	protected SelectVariablePage(WizardData data) {
		super("Select Variable");
		this.data = data;
		setTitle("Select Variable");
		setDescription("Select the variable to plot in the X axis");
		initialize();
	}
	
	protected void initialize() {
		if (data.getInputVariables().size() == 1) {
			data.setSelectedVariable(data.getInputVariables().get(0));
		} else {
			setPageComplete(false);
		}
	}

	@Override
	public void createControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
        top.setLayout(new GridLayout());
        
		TableViewer viewer = new TableViewer(top);
		viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);

		viewer.setLabelProvider(labelProvider);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(data.getInputVariables());
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = viewer.getStructuredSelection();
				if (!selection.isEmpty()) {
					data.setSelectedVariable((InputVariable) selection.getFirstElement());
					setPageComplete(true);
				}
			}
		});
		
        setControl(top);
	}
}
