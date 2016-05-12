package es.unizar.disco.simulation.ui.launcher;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import es.unizar.disco.core.ui.dialogs.FileSelectionDialog;
import es.unizar.disco.core.ui.util.UiConstants;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.dialogs.UmlFileSelectionDialog;

public class MainLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	protected EditingDomain editingDomain;
	
	public MainLaunchConfigurationTab(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}
	
	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, true));
		
		{ // Model Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
			
			group.setLayout(new GridLayout(2,  false));
			group.setText(Messages.MainLaunchConfigurationTab_modelLabel);
			
			final Text inputFileText = new Text(group, SWT.BORDER);
			inputFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			
			final Button fileButton = new Button(group, SWT.NONE);
			fileButton.setText(Messages.MainLaunchConfigurationTab_browseLabel);

			final GridData buttonsGridData = new GridData(SWT.CENTER, SWT.CENTER, false, false);
			buttonsGridData.widthHint = 100;
			fileButton.setLayoutData(buttonsGridData);
			
			fileButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileSelectionDialog dialog = new UmlFileSelectionDialog(getShell());
					dialog.open();
				}
			});
		}
		
		final SashForm sashGroup = new SashForm(topComposite, SWT.VERTICAL | SWT.SMOOTH);
		GridData sashLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		sashLayoutData.heightHint = 0;
		sashGroup.setLayoutData(sashLayoutData);
		
		
		{ // Scenarios Group
			final Group group = new Group(sashGroup, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
			group.setLayout(new GridLayout(1,  false));
			group.setText("Scenarios");
			
			final Composite tableComposite = new Composite(group, SWT.NONE);
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
			final TableViewer viewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
			viewer.getTable().setLinesVisible(true);
			viewer.getTable().setHeaderVisible(false);

			viewer.setContentProvider(new ArrayContentProvider());
			viewer.setInput(null);
			
			final TableViewerColumn scenarioViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
			viewer.getTable().setSortColumn(scenarioViewerColumn.getColumn());

			final TableColumnLayout tableLayout = new TableColumnLayout();
			tableLayout.setColumnData(scenarioViewerColumn.getColumn(), new ColumnWeightData(1));
			tableComposite.setLayout(tableLayout);
		}

		{ // Variables Group
			final Composite varsComposite = new Composite(sashGroup, SWT.NONE);
			varsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			final FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);
			fillLayout.spacing = UiConstants.DEFAULT_SPACING;
			varsComposite.setLayout(fillLayout);
			
			{
				final Group outputGroup = new Group(varsComposite, SWT.NONE);
				outputGroup.setLayout(new GridLayout(1,  true));
				outputGroup.setText("Output variables (read-only)");
				
				final Composite tableComposite = new Composite(outputGroup, SWT.NONE);
				tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				
				final TableViewer viewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
				viewer.getTable().setLinesVisible(true);
				viewer.getTable().setHeaderVisible(true);
	
				viewer.setContentProvider(new ArrayContentProvider());
				viewer.setInput(null);
				
				final TableViewerColumn variableViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
				variableViewerColumn.getColumn().setText("Variable");
				viewer.getTable().setSortColumn(variableViewerColumn.getColumn());
	
				final TableColumnLayout tableLayout = new TableColumnLayout();
				tableLayout.setColumnData(variableViewerColumn.getColumn(), new ColumnWeightData(1));
				tableComposite.setLayout(tableLayout);
			}
			{
				final Group inputGroup = new Group(varsComposite, SWT.NONE);
				inputGroup.setLayout(new GridLayout(1,  true));
				inputGroup.setText("Input variables");
				
				final Composite tableComposite = new Composite(inputGroup, SWT.NONE);
				tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				
				final TableViewer viewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
				viewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				viewer.getTable().setLinesVisible(true);
				viewer.getTable().setHeaderVisible(true);
				
				viewer.setContentProvider(new ArrayContentProvider());
				viewer.setInput(null);
				
				final TableViewerColumn variableViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
				variableViewerColumn.getColumn().setText("Variable");
				viewer.getTable().setSortColumn(variableViewerColumn.getColumn());
				
				final TableColumnLayout tableLayout = new TableColumnLayout();
				tableLayout.setColumnData(variableViewerColumn.getColumn(), new ColumnWeightData(1));
				tableComposite.setLayout(tableLayout);
			}
		}

		sashGroup.setWeights(new int [] {1, 2});
		setControl(topComposite);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public String getName() {
		return Messages.MainLaunchConfigurationTab_mainTabTitle;
	}

	@Override
	public Image getImage() {
		return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_MAIN_TAB);
	}
}
