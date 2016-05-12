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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import es.unizar.disco.core.ui.util.UiConstants;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class FiltersLaunchConfigurationTab extends AbstractLaunchConfigurationTab {


	
	protected EditingDomain editingDomain;
	
	public FiltersLaunchConfigurationTab(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		final FillLayout topFillLayout = new FillLayout(SWT.VERTICAL);
		topFillLayout.marginHeight = UiConstants.DEFAULT_MARGIN_WIDTH;
		topFillLayout.marginWidth = UiConstants.DEFAULT_MARGIN_HEIGHT;
		topFillLayout.spacing = UiConstants.DEFAULT_SPACING;
		topComposite.setLayout(topFillLayout);

		{ // Metrics Group
			final Group group = new Group(topComposite, SWT.NONE);
			
			group.setLayout(new GridLayout(1,  false));
			group.setText("Measures");
			
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

		{ // Sensitivity Analysis Group
			final Group group = new Group(topComposite, SWT.NONE);
			
			group.setLayout(new GridLayout(1,  false));
			group.setText("Sensitivity analysis");
			
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
		return "Filters";
	}

	@Override
	public Image getImage() {
		return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_FILTERS_TAB);
	}
	
}
