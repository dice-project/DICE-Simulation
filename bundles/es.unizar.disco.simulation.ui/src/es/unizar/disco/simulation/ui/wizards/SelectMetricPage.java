package es.unizar.disco.simulation.ui.wizards;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.ui.wizards.PlotWizard.WizardData;

public class SelectMetricPage extends WizardPage {

	private WizardData data;

	protected SelectMetricPage(WizardData data) {
		super("Select Measurement");
		this.data = data;
		setTitle("Select Measurement");
		setDescription("Select the measurement result to plot in the Y axis");
		initialize();
	}

	protected void initialize() {
		if (data.getMeasures().size() == 1) {
			data.setSelectedMeasure(data.getMeasures().get(0));
		} else {
			setPageComplete(false);
		}
	}

	@Override
	public void createControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new GridLayout());

		TableViewer viewer = new TableViewer(top, SWT.BORDER | SWT.SINGLE);
		viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));

		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);

		viewer.setLabelProvider(labelProvider);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(data.getMeasures());
		
		if(data.getSelectedMeasure()!=null){
			viewer.setSelection(new StructuredSelection(data.getSelectedMeasure()));
		}
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = viewer.getStructuredSelection();
				if (!selection.isEmpty()) {
					data.setSelectedMeasure((DomainMeasureDefinition) selection.getFirstElement());
					setPageComplete(true);
				}
			}
		});
		
		setControl(top);
	}
}
