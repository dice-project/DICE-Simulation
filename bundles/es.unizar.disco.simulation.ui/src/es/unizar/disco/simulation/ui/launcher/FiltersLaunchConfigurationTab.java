package es.unizar.disco.simulation.ui.launcher;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TableColumn;

import es.unizar.disco.core.collections.AlphanumComparator;
import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.core.ui.util.UiConstants;
import es.unizar.disco.simulation.launcher.SimulationDefinitionConfigurationHandler;
import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.Variable;
import es.unizar.disco.simulation.models.definition.VariableAssignment;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.launcher.providers.DelegatedColumnLabelProvider;

public class FiltersLaunchConfigurationTab extends AbstractSimulationLaunchConfigurationTab {

	private static final int DEFAULT_COLUMN_WIDTH = 50;

	protected final EContentAdapter contentAdapter = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__MEASURES_TO_COMPUTE
					|| notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS) {
				if (FiltersLaunchConfigurationTab.this.isActive()) {
					updateLaunchConfigurationDialog();
				}
			} else if (notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS) {
				MessageFormat format = new MessageFormat("{0,choice,0#No|1#Only {0}|1<{0}} possible configuration{0,choice,0#s|1#|1<s} available");
				numberOfConfigs.setValue(format.format(new Object[] { simulationDefinition.getPossibleConfigurations().size() }));
				rebuildConfigsViewer = true;
			}
		};
	};

	private WritableValue numberOfConfigs = new WritableValue();

	private DynamicColumnsManager dynColumnsManager;

	private boolean rebuildConfigsViewer = false;

	private CheckboxTableViewer varConfigsViewer;

	private final SimulationDefinitionConfigurationHandler handler;
	
	public FiltersLaunchConfigurationTab(SimulationDefinition simulationDefinition) {
		super(simulationDefinition);
		handler = SimulationDefinitionConfigurationHandler.create(simulationDefinition);
		this.simulationDefinition.eAdapters().add(contentAdapter);
	}

	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		final FillLayout topFillLayout = new FillLayout(SWT.VERTICAL);
		topFillLayout.marginHeight = UiConstants.DEFAULT_MARGIN_WIDTH;
		topFillLayout.marginWidth = UiConstants.DEFAULT_MARGIN_HEIGHT;
		topFillLayout.spacing = UiConstants.DEFAULT_SPACING;
		topComposite.setLayout(topFillLayout);

		final AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		SashForm sashGroup = new SashForm(topComposite, SWT.VERTICAL);

		{ // Metrics Group
			final Group group = new Group(sashGroup, SWT.NONE);

			group.setLayout(new GridLayout(1, false));
			group.setText("Measures");

			final Composite tableComposite = new Composite(group, SWT.NONE);
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			final CheckboxTableViewer measuresViewer = CheckboxTableViewer.newCheckList(tableComposite,
					SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
			measuresViewer.getTable().setLinesVisible(true);
			measuresViewer.getTable().setHeaderVisible(true);

			measuresViewer.getTable().addListener(SWT.EraseItem, new Listener() {
				public void handleEvent(Event event) {
					event.detail &= ~SWT.SELECTED;
					event.detail &= ~SWT.HOT;
				}
			});

			measuresViewer.setContentProvider(new ObservableListContentProvider());
			measuresViewer.setInput(EMFProperties.list(DefinitionPackage.Literals.SIMULATION_DEFINITION__DECLARED_MEASURES).observe(simulationDefinition));

			final TableViewerColumn measuresViewerColumn = new TableViewerColumn(measuresViewer, SWT.NONE);
			measuresViewerColumn.setLabelProvider(new DelegatedColumnLabelProvider(labelProvider));
			measuresViewerColumn.getColumn().setText("Measure");

			final TableViewerColumn domainElementViewerColumn = new TableViewerColumn(measuresViewer, SWT.NONE);
			domainElementViewerColumn.setLabelProvider(new DomainElementColumnLabelProvider(labelProvider));
			domainElementViewerColumn.getColumn().setText("Domain Element");

			final TableViewerColumn variableViewerColumn = new TableViewerColumn(measuresViewer, SWT.NONE);
			variableViewerColumn.setLabelProvider(new OutputVariableColumnLabelProvider(labelProvider));
			variableViewerColumn.getColumn().setText("Output Variable");
			
			final TableColumnLayout tableLayout = new TableColumnLayout();
			tableLayout.setColumnData(measuresViewerColumn.getColumn(), new ColumnWeightData(2));
			tableLayout.setColumnData(domainElementViewerColumn.getColumn(), new ColumnWeightData(2));
			tableLayout.setColumnData(variableViewerColumn.getColumn(), new ColumnWeightData(1));
			tableComposite.setLayout(tableLayout);

			// @formatter:off
			IObservableSet selectedMeasuresEmfSource = EMFProperties
					.set(DefinitionPackage.Literals.SIMULATION_DEFINITION__MEASURES_TO_COMPUTE)
					.observe(simulationDefinition);
			// @formatter:on

			IViewerObservableSet selectedMeasuresGuiTarget = ViewerProperties.checkedElements(DomainMeasureDefinition.class).observe(measuresViewer);
			context.bindSet(selectedMeasuresEmfSource, selectedMeasuresGuiTarget);
		}

		{ // Sensitivity Analysis Group
			final Group group = new Group(sashGroup, SWT.NONE);

			group.setLayout(new GridLayout(2, false));
			group.setText("Sensitivity analysis");

			final Composite tableComposite = new Composite(group, SWT.NONE);
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			varConfigsViewer = CheckboxTableViewer.newCheckList(tableComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
			varConfigsViewer.getTable().setLinesVisible(true);
			varConfigsViewer.getTable().setHeaderVisible(true);

			varConfigsViewer.setContentProvider(new ObservableListContentProvider());
			varConfigsViewer
					.setInput(EMFProperties.list(DefinitionPackage.Literals.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS).observe(simulationDefinition));
			varConfigsViewer.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					// Return empty String
					// Only used by the first (empty) column
					return "";
				}

				@Override
				public Image getImage(Object element) {
					return labelProvider.getImage(element);
				}
			});
			varConfigsViewer.setComparator(new ConfigurationsViewerComparator());

			// First column contains the checkbox and is empty
			final TableColumn emptyColumn = new TableColumn(varConfigsViewer.getTable(), SWT.NONE);
			emptyColumn.setWidth(50);
			emptyColumn.setResizable(false);

			dynColumnsManager = new DynamicColumnsManager(varConfigsViewer);

			tableComposite.setLayout(new FillLayout());

			final Composite buttonsComposite = new Composite(group, SWT.NONE);
			buttonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
			GridLayout buttonsLayout = new GridLayout(1, false);
			buttonsLayout.marginWidth = 0;
			buttonsLayout.marginHeight = 0;
			buttonsComposite.setLayout(buttonsLayout);

			final Composite topButtonsComposite = new Composite(buttonsComposite, SWT.NONE);
			topButtonsComposite.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, true, true));
			topButtonsComposite.setLayout(buttonsLayout);

			final Button checkAllButton = new Button(topButtonsComposite, SWT.PUSH);
			checkAllButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			checkAllButton.setText("&Check All");

			final Button uncheckAllButton = new Button(topButtonsComposite, SWT.PUSH);
			uncheckAllButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			uncheckAllButton.setText("&Uncheck All");

			final Button checkSelectedButton = new Button(topButtonsComposite, SWT.PUSH);
			checkSelectedButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			checkSelectedButton.setText("Check &Selected");

			final Button uncheckSelectedButton = new Button(topButtonsComposite, SWT.PUSH);
			uncheckSelectedButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			uncheckSelectedButton.setText("U&ncheck Selected");

			final Composite bottomButtonsComposite = new Composite(buttonsComposite, SWT.NONE);
			bottomButtonsComposite.setLayoutData(new GridData(SWT.BOTTOM, SWT.FILL, true, false));
			bottomButtonsComposite.setLayout(buttonsLayout);

			final Button fitButton = new Button(bottomButtonsComposite, SWT.PUSH);
			fitButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			fitButton.setText("&Fit to Content");

			final Button sameSizeButton = new Button(bottomButtonsComposite, SWT.PUSH);
			sameSizeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			sameSizeButton.setText("Make Same &Width");

			final Composite sizeComposite = new Composite(bottomButtonsComposite, SWT.NONE);
			sizeComposite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
			GridLayout widthLayout = new GridLayout(2, false);
			widthLayout.marginWidth = 0;
			widthLayout.marginHeight = 0;
			sizeComposite.setLayout(widthLayout);

			final Label widthLabel = new Label(sizeComposite, SWT.NONE);
			widthLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			widthLabel.setText("Width:");

			final Spinner widthSpinner = new Spinner(sizeComposite, SWT.BORDER);
			widthSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			widthSpinner.setMaximum(999);
			widthSpinner.setMinimum(0);
			widthSpinner.setSelection(DEFAULT_COLUMN_WIDTH);

			Label totalCombinationsText = new Label(group, SWT.NONE);
			totalCombinationsText.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, false, 2, 1));

			checkAllButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					simulationDefinition.getActiveConfigurations().addAll(simulationDefinition.getPossibleConfigurations());
				}
			});

			uncheckAllButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					simulationDefinition.getActiveConfigurations().clear();
				}
			});

			checkSelectedButton.addSelectionListener(new SelectionAdapter() {
				@SuppressWarnings("unchecked")
				@Override
				public void widgetSelected(SelectionEvent e) {
					simulationDefinition.getActiveConfigurations().addAll(varConfigsViewer.getStructuredSelection().toList());
				}
			});

			uncheckSelectedButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					simulationDefinition.getActiveConfigurations().removeAll(varConfigsViewer.getStructuredSelection().toList());
				}
			});

			fitButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					dynColumnsManager.fitColumns();
				}
			});

			sameSizeButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					dynColumnsManager.setWidth(widthSpinner.getSelection());
				}
			});

			// @formatter:off
			IObservableSet selectedConfigsEmfSource = EMFProperties
					.set(DefinitionPackage.Literals.SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS)
					.observe(simulationDefinition);
			// @formatter:on
			IViewerObservableSet selectedConfigsGuiTarget = ViewerProperties.checkedElements(VariableConfiguration.class).observe(varConfigsViewer);
			IObservableValue numberConfigsObservableValue = WidgetProperties.text().observe(totalCombinationsText);

			context.bindSet(selectedConfigsEmfSource, selectedConfigsGuiTarget);
			context.bindValue(numberOfConfigs, numberConfigsObservableValue);
		}

		sashGroup.setWeights(new int[] { 1, 2 });

		setControl(topComposite);
	}

	@Override
	public String getName() {
		return "Filters";
	}

	@Override
	public Image getImage() {
		return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_FILTERS_TAB);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			// Once the scenario has been restored, the domain measures are
			// synchronized.
			// If we had a custom selection, select those that were previously
			// saved
			handler.initializeSelectedMeasures(configuration);
			// The same applies for the active configurations
			handler.initializeActiveConfigurations(configuration);
			
		} catch (CoreException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// Since the domain measures are obtained from the domain model, we only
		// need to store which of them are selected
		// We save the selected measures only if not all of them are selected
		handler.saveSelectedMeasures(configuration);
		// The same applies for the active configurations
		handler.saveActiveConfigurations(configuration);
	}

	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		super.activated(workingCopy);
		if (rebuildConfigsViewer) {
			dynColumnsManager.reload();
			rebuildConfigsViewer = false;
		}
		varConfigsViewer.refresh();
	}

	
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if (simulationDefinition.getMeasuresToCompute().isEmpty()) {
			setErrorMessage("At least one Measure must be selected to be computed");
			return false;
		} 
		if (!simulationDefinition.getInputVariables().isEmpty() && simulationDefinition.getActiveConfigurations().isEmpty()) {
			setErrorMessage("At least one Configuration for the Input Variables must be selected");
			return false;
		}
		for (DomainMeasureDefinition measureDefinition : simulationDefinition.getMeasuresToCompute()) {
			String source = measureDefinition.getVslExpressionEntries().get("source");
			if (source != null && !StringUtils.equals(source, "req") && measureDefinition.getOutputVariable() == null) {
				setErrorMessage(MessageFormat.format("The Scenario does not declare an Output Variable for the Domain Measure ''{0}''",
						measureDefinition.getVslExpression()));
				return false;
			}
		}

		setErrorMessage(null);
		return true;
	}
	
	private class DomainElementColumnLabelProvider extends DelegatedColumnLabelProvider {

		public DomainElementColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		public String getText(Object element) {
			return labelProvider.getText(((DomainMeasureDefinition) element).getMeasuredElement());
		}

		@Override
		public Image getImage(Object element) {
			return labelProvider.getImage(((DomainMeasureDefinition) element).getMeasuredElement());
		}
	}

	private class OutputVariableColumnLabelProvider extends DelegatedColumnLabelProvider {

		private final OutputVariable OUTPUT_VARIABLE = DefinitionFactory.eINSTANCE.createOutputVariable();
		
		public OutputVariableColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		public String getText(Object element) {
			OutputVariable outputVariable = ((DomainMeasureDefinition) element).getOutputVariable();
			return outputVariable != null ? labelProvider.getText(outputVariable) : "<Undefined Output Variable>";
		}

		@Override
		public Image getImage(Object element) {
			return labelProvider.getImage(OUTPUT_VARIABLE);
		}

	}
	
	private class DynamicColumnsManager {

		private List<TableViewerColumn> columns = new ArrayList<>();

		private final class VariableValueColumnLabelProvider extends ColumnLabelProvider {
			private final Variable variable;

			public VariableValueColumnLabelProvider(Variable variable) {
				this.variable = variable;
			}

			@Override
			public String getText(Object element) {
				VariableConfiguration config = (VariableConfiguration) element;
				for (VariableAssignment assignment : config.getAssignments()) {
					if (this.variable.equals(assignment.getVariable())) {
						return EcoreUtil.convertToString(DatatypesPackage.Literals.NUMBER, assignment.getValue().getValue());
					}
				}
				return "null";
			}
		}

		private final TableViewer viewer;

		public DynamicColumnsManager(TableViewer viewer) {
			this.viewer = viewer;
			this.reload();
		}

		public void reload() {
			for (TableViewerColumn column : columns) {
				column.getColumn().dispose();
			}
			columns.clear();
			TreeSet<String> vars = new TreeSet<>(new AlphanumComparator());
			vars.addAll(simulationDefinition.getInputVariablesMap().keySet());
			for (final String var : vars) {
				final TableViewerColumn column = createTableViewerColumn(var, DEFAULT_COLUMN_WIDTH);
				column.setLabelProvider(new VariableValueColumnLabelProvider(simulationDefinition.getVariablesMap().get(var)));
				column.getColumn().addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						ConfigurationsViewerComparator comparator = (ConfigurationsViewerComparator) viewer.getComparator();
						comparator.setVariable(var);
						int dir = comparator.getDirection();
						viewer.getTable().setSortDirection(dir);
						viewer.getTable().setSortColumn(column.getColumn());
						viewer.refresh();
					}
				});
				columns.add(column);
			}
		}

		private TableViewerColumn createTableViewerColumn(String title, int bound) {
			final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
			final TableColumn column = viewerColumn.getColumn();
			column.setText(title);
			column.setWidth(bound);
			column.setResizable(true);
			column.setMoveable(true);
			column.setAlignment(SWT.RIGHT);
			return viewerColumn;
		}

		public void fitColumns() {
			for (TableViewerColumn column : columns) {
				column.getColumn().pack();
			}
		}

		public void setWidth(int width) {
			for (TableViewerColumn column : columns) {
				column.getColumn().setWidth(width);
			}
		}
	}

	public class ConfigurationsViewerComparator extends ViewerComparator {
		private String varName = "";
		private static final int DESCENDING = 1;
		private int direction = DESCENDING;

		public ConfigurationsViewerComparator() {
			direction = DESCENDING;
		}

		public int getDirection() {
			return direction == 1 ? SWT.DOWN : SWT.UP;
		}

		public void setVariable(String varName) {
			if (varName == this.varName) {
				// Same column as last sort; toggle the direction
				direction = 1 - direction;
			} else {
				// New column; do an ascending sort
				this.varName = varName;
				direction = DESCENDING;
			}
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			if (varName.isEmpty()) {
				return 0;
			}
			InputVariableValue v1 = null;
			InputVariableValue v2 = null;
			for (VariableAssignment assignment : ((VariableConfiguration) e1).getAssignments()) {
				if (assignment.getVariable().getName().equals(varName)) {
					v1 = assignment.getValue();
					break;
				}
			}
			for (VariableAssignment assignment : ((VariableConfiguration) e2).getAssignments()) {
				if (assignment.getVariable().getName().equals(varName)) {
					v2 = assignment.getValue();
					break;
				}
			}
			int rc = new BigDecimal(v1.getValue().toString()).compareTo(new BigDecimal(v2.getValue().toString()));
			// If descending order, flip the direction
			if (direction == DESCENDING) {
				rc = -rc;
			}
			return rc;
		}

	}
}
