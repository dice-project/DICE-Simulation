package es.unizar.disco.simulation.ui.launcher;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import es.unizar.disco.core.collections.AlphanumComparator;
import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.core.ui.dialogs.FileSelectionDialog;
import es.unizar.disco.simulation.launcher.SimulationDefinitionConfigurationHandler;
import es.unizar.disco.simulation.models.datatypes.ComputableNFPtype;
import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.dialogs.UmlFileSelectionDialog;
import es.unizar.disco.simulation.ui.launcher.providers.DelegatedColumnLabelProvider;
import es.unizar.disco.simulation.ui.launcher.strategies.NotNullTobooleanStrategy;
import es.unizar.disco.simulation.ui.launcher.strategies.StringToUriStrategy;
import es.unizar.disco.simulation.ui.launcher.strategies.UriToStringStrategy;
import es.unizar.disco.simulation.ui.util.UriConverter;

public class MainLaunchConfigurationTab extends AbstractSimulationLaunchConfigurationTab {

	protected final EContentAdapter contentAdapter = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getFeature() == DatatypesPackage.Literals.RESOURCE__URI
					|| notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__ACTIVE_SCENARIO
					|| notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__INPUT_VARIABLES
					|| notification.getFeature() == DefinitionPackage.Literals.INPUT_VARIABLE__VALUES
					|| notification.getFeature() == DefinitionPackage.Literals.INPUT_VARIABLE_VALUE__VALUE) {
				if (MainLaunchConfigurationTab.this.isActive()) {
					updateLaunchConfigurationDialog();
				}
			}
		};
	};

	private final SimulationDefinitionConfigurationHandler handler;

	public MainLaunchConfigurationTab(SimulationDefinition simulationDefinition) {
		super(simulationDefinition);
		handler = SimulationDefinitionConfigurationHandler.create(simulationDefinition);
		this.simulationDefinition.eAdapters().add(contentAdapter);
	}

	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, true));

		createModelGroup(topComposite);

		final SashForm sashGroup = new SashForm(topComposite, SWT.VERTICAL | SWT.SMOOTH);
		GridData sashLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		sashLayoutData.heightHint = 0;

		sashGroup.setLayoutData(sashLayoutData);
		createScenariosGroup(sashGroup);

		// Differentiate between performance and reliability
		createNFPselectionGroup(sashGroup);
		// TODO: show the minimum set of variables that are of interest for the
		// NFP to calculate
		createVariableGroup(sashGroup);
		sashGroup.setWeights(new int[] { 2, 1, 4 });

		setControl(topComposite);
	}

	private void createNFPselectionGroup(Composite composite) {
		final Group group = new Group(composite, SWT.SHADOW_ETCHED_IN);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		group.setLayout(new GridLayout(1, false));
		group.setText(Messages.MainLaunchConfigurationTab_NFPtoCalculate);

		final Button perfOption = new Button(group, SWT.RADIO);
		perfOption.setText("Performance");
		final Button reliabOption = new Button(group, SWT.RADIO);
		reliabOption.setText("Reliability");

		SelectObservableValue selectedButtonObservable = new SelectObservableValue();
		selectedButtonObservable.addOption(ComputableNFPtype.PERFORMANCE,
				WidgetProperties.selection().observe(perfOption));
		selectedButtonObservable.addOption(ComputableNFPtype.RELIABILITY,
				WidgetProperties.selection().observe(reliabOption));

		IObservableValue nfpSelection = EMFProperties
				.value(DefinitionPackage.Literals.SIMULATION_DEFINITION__NFP_TO_COMPUTE).observe(simulationDefinition);

		context.bindValue(selectedButtonObservable, nfpSelection, new UpdateValueStrategy() {
			@Override
			public Object convert(Object value) {
				return ComputableNFPtype.get(((String) value).toUpperCase());
			}
		}, null);

	}

	private void createModelGroup(Composite topComposite) {
		final Group group = new Group(topComposite, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		group.setLayout(new GridLayout(2, false));
		group.setText(Messages.MainLaunchConfigurationTab_modelLabel);

		final Text inputFileText = new Text(group, SWT.BORDER | SWT.READ_ONLY);
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
				String inputResource = inputFileText.getText();
				if (StringUtils.isNotBlank(inputResource)) {
					final Path inputResourcePath = new Path(URI.createURI(inputResource).toPlatformString(true));
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(inputResourcePath);
					dialog.setInitialSelection(file);
				}
				if (dialog.open() == Dialog.OK) {
					inputFileText
							.setText(UriConverter.toPlatformResourceUri(dialog.getFile().getLocationURI()).toString());
				}
			}
		});

		// @formatter:off
		IObservableValue inputResourceEmfSource = EMFProperties
				.value(FeaturePath.fromList(DefinitionPackage.Literals.SIMULATION_DEFINITION__DOMAIN_RESOURCE,
						DatatypesPackage.Literals.RESOURCE__URI))
				.observe(simulationDefinition);
		// @formatter:on

		IObservableValue inputResourceGuiTarget = WidgetProperties.text(SWT.Modify).observe(inputFileText);
		context.bindValue(inputResourceEmfSource, inputResourceGuiTarget, new UriToStringStrategy(),
				new StringToUriStrategy());
	}

	private void createScenariosGroup(Composite composite) {
		final Group group = new Group(composite, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		group.setLayout(new GridLayout(1, false));
		group.setText("Active scenario"); //$NON-NLS-1$

		final Composite tableComposite = new Composite(group, SWT.NONE);
		tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final TableViewer scenariosViewer = new TableViewer(tableComposite,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.NO_SCROLL | SWT.V_SCROLL);
		scenariosViewer.getTable().setLinesVisible(true);
		scenariosViewer.getTable().setHeaderVisible(false);

		scenariosViewer.setContentProvider(new ObservableListContentProvider());
		scenariosViewer.setInput(EMFProperties.list(DefinitionPackage.Literals.SIMULATION_DEFINITION__SCENARIOS)
				.observe(simulationDefinition));
		scenariosViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));

		final TableColumn column = new TableColumn(scenariosViewer.getTable(), SWT.NONE);

		final TableColumnLayout tableLayout = new TableColumnLayout();
		tableLayout.setColumnData(column, new ColumnWeightData(1));
		tableComposite.setLayout(tableLayout);

		// @formatter:off
		IObservableValue activeScenarioEmfSource = EMFProperties
				.value(DefinitionPackage.Literals.SIMULATION_DEFINITION__ACTIVE_SCENARIO).observe(simulationDefinition);
		// @formatter:on

		IObservableValue activeScenarioGuiTarget = ViewerProperties.singleSelection().observe(scenariosViewer);
		context.bindValue(activeScenarioEmfSource, activeScenarioGuiTarget);
	}

	private void createVariableGroup(Composite composite) {

		final SashForm sashGroup = new SashForm(composite, SWT.HORIZONTAL | SWT.SMOOTH);
		GridData sashLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		sashLayoutData.heightHint = 0;

		// Observable that holds the currently selected variable
		final IViewerObservableValue variablesSelectionObservable;
		// The variables viewer, needs to be refreshed when the values of the
		// currently selected variable change
		final TableViewer variablesViewer;

		{
			final Group inputGroup = new Group(sashGroup, SWT.NONE);
			inputGroup.setLayout(new GridLayout(1, true));
			inputGroup.setText("Variables"); //$NON-NLS-1$

			final Composite tableComposite = new Composite(inputGroup, SWT.NONE);
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			variablesViewer = new TableViewer(tableComposite,
					SWT.BORDER | SWT.FULL_SELECTION | SWT.NO_SCROLL | SWT.V_SCROLL);
			variablesViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			variablesViewer.getTable().setLinesVisible(true);
			variablesViewer.getTable().setHeaderVisible(false);

			variablesViewer.setContentProvider(new ObservableListContentProvider());
			variablesViewer
					.setInput(EMFProperties.list(DefinitionPackage.Literals.SIMULATION_DEFINITION__INPUT_VARIABLES)
							.observe(simulationDefinition));
			variablesViewer.setLabelProvider(new AdapterFactoryLabelProvider(
					new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
			variablesViewer.setComparator(new ViewerComparator(new AlphanumComparator()));

			final TableColumn column = new TableColumn(variablesViewer.getTable(), SWT.NONE);

			final TableColumnLayout tableLayout = new TableColumnLayout();
			tableLayout.setColumnData(column, new ColumnWeightData(1));
			tableComposite.setLayout(tableLayout);

			// @formatter:off
			IObservableValue variablesEmfSource = EMFProperties
					.value(DefinitionPackage.Literals.SIMULATION_DEFINITION__INPUT_VARIABLES)
					.observe(simulationDefinition);
			// @formatter:on

			IObservableValue variablesGuiTarget = ViewerProperties.input().observe(variablesViewer);
			context.bindValue(variablesEmfSource, variablesGuiTarget);

			variablesSelectionObservable = ViewerProperties.singleSelection().observe(variablesViewer);
		}
		{

			final Group valuesGroup = new Group(sashGroup, SWT.NONE);
			GridLayout valuesGroupLayout = new GridLayout(2, false);
			valuesGroupLayout.verticalSpacing = 0;
			valuesGroup.setLayout(valuesGroupLayout);
			valuesGroup.setText("Values"); //$NON-NLS-1$

			final Text valuesText = new Text(valuesGroup, SWT.BORDER);
			valuesText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

			final Button addButton = new Button(valuesGroup, SWT.PUSH);
			addButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));

			final Composite tableComposite = new Composite(valuesGroup, SWT.NONE);
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			final TableViewer valuesViewer = new TableViewer(tableComposite,
					SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION | SWT.NO_SCROLL | SWT.V_SCROLL);
			valuesViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			valuesViewer.getTable().setLinesVisible(true);
			valuesViewer.getTable().setHeaderVisible(false);

			valuesViewer.setContentProvider(new ObservableListContentProvider());

			final IObservableList selectedVariableValuesObservable = EMFProperties
					.list(DefinitionPackage.Literals.INPUT_VARIABLE__VALUES)
					.observeDetail(variablesSelectionObservable);
			valuesViewer.setInput(selectedVariableValuesObservable);

			final TableViewerColumn valuesViewerColumn = new TableViewerColumn(valuesViewer, SWT.NONE);
			valuesViewerColumn.setLabelProvider(new DelegatedColumnLabelProvider(new AdapterFactoryLabelProvider(
					new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE))));
			valuesViewerColumn.setEditingSupport(new ValuesEditingSupport(valuesViewer, variablesViewer));

			TableViewerEditor.create(valuesViewer, new DoubleClickActivationStrategy(valuesViewer),
					ColumnViewerEditor.TABBING_HORIZONTAL | ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
							| ColumnViewerEditor.TABBING_VERTICAL | ColumnViewerEditor.KEYBOARD_ACTIVATION);

			final TableColumnLayout tableLayout = new TableColumnLayout();
			tableLayout.setColumnData(valuesViewerColumn.getColumn(), new ColumnWeightData(1));
			tableComposite.setLayout(tableLayout);

			final Composite tableButtonsComposite = new Composite(valuesGroup, SWT.NONE);
			tableButtonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
			tableButtonsComposite.setLayout(new FillLayout(SWT.VERTICAL));

			final Button deleteButton = new Button(tableButtonsComposite, SWT.PUSH);
			deleteButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ELCL_REMOVE));

			final Button deleteAllButton = new Button(tableButtonsComposite, SWT.PUSH);
			deleteAllButton
					.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ELCL_REMOVEALL));

			final Button upButton = new Button(tableButtonsComposite, SWT.PUSH);
			upButton.setImage(
					DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_ETOOL16_UP));

			final Button downButton = new Button(tableButtonsComposite, SWT.PUSH);
			downButton.setImage(DiceSimulationUiPlugin.getDefault().getImageRegistry()
					.get(DiceSimulationUiPlugin.IMG_ETOOL16_DOWN));

			valuesText.addFocusListener(new SwitchDefaultFocusListener(addButton));

			addButton.addSelectionListener(new AddButtonSelectionAdapter(variablesSelectionObservable, variablesViewer,
					valuesViewer, valuesText));
			deleteButton
					.addSelectionListener(new DeleteButtonSelectionAdapter(variablesSelectionObservable, valuesViewer));
			deleteAllButton.addSelectionListener(new DeleteAllButtonSelectionAdapter(variablesSelectionObservable));
			upButton.addSelectionListener(new UpButtonSelectionAdapter(variablesSelectionObservable, valuesViewer));
			downButton.addSelectionListener(new DownButtonSelectionAdapter(variablesSelectionObservable, valuesViewer));

			selectedVariableValuesObservable.addListChangeListener(new IListChangeListener() {
				@Override
				public void handleListChange(ListChangeEvent event) {
					Object value = variablesSelectionObservable.getValue();
					if (value != null) {
						variablesViewer.update(value, null);
					}
				}
			});

			variablesViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					valuesText.setFocus();
				}
			});

			final ControlDecoration valueTextDecoration = new ControlDecoration(valuesText, SWT.TOP | SWT.LEFT);
			valueTextDecoration.setImage(FieldDecorationRegistry.getDefault()
					.getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
			valueTextDecoration.setDescriptionText("Single numeric values add a single entry\n" //$NON-NLS-1$
					+ "Space-separated values add multiple entries (e.g. '1 2.3 4.56')\n" //$NON-NLS-1$
					+ "Three values separated by semicolons between square brackets [lower; limit; increment]\n" //$NON-NLS-1$
					+ "add a range of values (e.g. '[1; 5; 1]' is equivalent to '1 2 3 4 5')"); //$NON-NLS-1$
			valueTextDecoration.setShowOnlyOnFocus(true);

			final NotNullTobooleanStrategy notNullToBooleanStrategy = new NotNullTobooleanStrategy();
			context.bindValue(WidgetProperties.enabled().observe(valuesText), variablesSelectionObservable, null,
					notNullToBooleanStrategy);
			context.bindValue(WidgetProperties.enabled().observe(valuesViewer.getTable()), variablesSelectionObservable,
					null, notNullToBooleanStrategy);
			context.bindValue(WidgetProperties.enabled().observe(addButton), variablesSelectionObservable, null,
					notNullToBooleanStrategy);
			context.bindValue(WidgetProperties.enabled().observe(deleteButton), variablesSelectionObservable, null,
					notNullToBooleanStrategy);
			context.bindValue(WidgetProperties.enabled().observe(deleteAllButton), variablesSelectionObservable, null,
					notNullToBooleanStrategy);
			context.bindValue(WidgetProperties.enabled().observe(upButton), variablesSelectionObservable, null,
					notNullToBooleanStrategy);
			context.bindValue(WidgetProperties.enabled().observe(downButton), variablesSelectionObservable, null,
					notNullToBooleanStrategy);
		}

		sashGroup.setLayoutData(sashLayoutData);
	}

	@Override
	public String getName() {
		return Messages.MainLaunchConfigurationTab_mainTabTitle;
	}

	@Override
	public Image getImage() {
		return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_MAIN_TAB);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			// Set the domain resource
			handler.initializeResourceUri(configuration);
			// Add the previously saved input variables
			handler.initializeInputVariables(configuration);
			// Add the previously saved output variables (not shown in this GUI)
			handler.initializeOutputVariables(configuration);
			// If we do not have and active scenario, or it has changed, try to
			// restore it in the model. This will trigger a cleanup of the
			// invalid/unused variables
			handler.initializeActiveScenario(configuration);
		} catch (CoreException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		handler.saveResourceUri(configuration);
		handler.saveActiveScenario(configuration);
		handler.saveInputVariables(configuration);
		handler.saveOutputVariables(configuration);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if (simulationDefinition.getDomainResource().getUri() == null) {
			setErrorMessage("A domain UML model must be selected"); //$NON-NLS-1$
			return false;
		}
		if (simulationDefinition.getScenarios().isEmpty()) {
			setErrorMessage("The selected model does not declare any Scenarios"); //$NON-NLS-1$
			return false;
		}
		if (simulationDefinition.getActiveScenario() == null) {
			setErrorMessage("An active scenario must be selected"); //$NON-NLS-1$
			return false;
		}
		for (InputVariable inputVariable : simulationDefinition.getInputVariables()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(inputVariable);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				if (!diagnostic.getChildren().isEmpty()) {
					setErrorMessage(diagnostic.getChildren().get(0).getMessage());
				} else {
					setErrorMessage(diagnostic.getMessage());
				}
				return false;
			}
		}
		setErrorMessage(null);
		return true;
	}

	/**
	 * {@link FocusListener} that changes and restores the {@link Shell} default
	 * button to a specific {@link Button}
	 * 
	 * @author agomez
	 *
	 */
	private final class SwitchDefaultFocusListener implements FocusListener {

		private final Button addButton;

		private Button prevDefaultButton;

		private SwitchDefaultFocusListener(Button addButton) {
			this.addButton = addButton;
		}

		@Override
		public void focusLost(FocusEvent e) {
			getShell().setDefaultButton(prevDefaultButton);
		}

		@Override
		public void focusGained(FocusEvent e) {
			prevDefaultButton = getShell().getDefaultButton();
			getShell().setDefaultButton(addButton);
		}
	}

	/**
	 * {@link ColumnViewerEditorActivationStrategy} that enables editing by
	 * double clicking
	 * 
	 * @author agomez
	 *
	 */
	private final class DoubleClickActivationStrategy extends ColumnViewerEditorActivationStrategy {
		private DoubleClickActivationStrategy(ColumnViewer viewer) {
			super(viewer);
		}

		protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
			// Enable editor only with mouse double click
			if (event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION) {
				return true;
			}
			return false;
		}
	}

	/**
	 * {@link SelectionAdapter} of the add button of this
	 * {@link AbstractLaunchConfigurationTab}
	 * 
	 * @author agomez
	 *
	 */
	private final class AddButtonSelectionAdapter extends SelectionAdapter {

		private final Text valuesText;

		private final IViewerObservableValue variablesSelectionObservable;

		private final TableViewer detailsViewer;

		private final TableViewer masterViewer;

		private AddButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable, TableViewer master,
				TableViewer detail, Text valuesText) {
			this.valuesText = valuesText;
			this.variablesSelectionObservable = variablesSelectionObservable;
			this.detailsViewer = detail;
			this.masterViewer = master;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {

			if (valuesText.getText().isEmpty()) {
				int selected = masterViewer.getTable().getSelectionIndex();
				int index = (selected + 1) % (masterViewer.getTable().getItemCount());
				masterViewer.setSelection(new StructuredSelection(masterViewer.getElementAt(index)), true);
			}

			List<InputVariableValue> newValues = new ArrayList<>();
			InputVariable variable = (InputVariable) variablesSelectionObservable.getValue();
			String text = valuesText.getText().trim();

			Pattern listPattern = Pattern.compile("^(-?\\d*(\\.\\d+)?\\s*)+$"); //$NON-NLS-1$
			Matcher listMatcher = listPattern.matcher(text);
			if (listMatcher.matches()) {
				StringTokenizer tokenizer = new StringTokenizer(text, " "); //$NON-NLS-1$
				while (tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken();
					InputVariableValue value = DefinitionFactory.eINSTANCE.createInputVariableValue();
					value.setValue((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, token));
					newValues.add(value);
				}
			} else {
				Pattern rangePattern = Pattern.compile(
						"^\\[\\s*(?<start>-?\\d*(?:\\.\\d+)?)\\s*;\\s*(?<limit>-?\\d*(?:\\.\\d+)?)\\s*;\\s*(?<increment>-?\\d*(?:\\.\\d+)?)\\s*\\]$"); //$NON-NLS-1$
				Matcher rangeMatcher = rangePattern.matcher(text);
				if (rangeMatcher.matches()) {
					// We perform the calculations using big decimals to avoid
					// rounding issues
					BigDecimal start = new BigDecimal(rangeMatcher.group("start")); //$NON-NLS-1$
					BigDecimal limit = new BigDecimal(rangeMatcher.group("limit")); //$NON-NLS-1$
					BigDecimal increment = new BigDecimal(rangeMatcher.group("increment")); //$NON-NLS-1$
					// @formatter:off
					if ((increment.compareTo(BigDecimal.ZERO)) != 0) { // increment
																		// != 0
						// We calculate increment and decrement intervals
						// separately since it's
						// easier to implement when the upper limit is inclusive
						if (limit.subtract(start).compareTo(BigDecimal.ZERO) > 0
								&& increment.compareTo(BigDecimal.ZERO) > 0) { // limit
																				// -
																				// start
																				// >
																				// 0
																				// &&
																				// increment
																				// >
																				// 0
							// Incrementing intervals
							for (BigDecimal number = start; number.compareTo(limit) <= 0; number = number
									.add(increment)) {
								InputVariableValue value = DefinitionFactory.eINSTANCE.createInputVariableValue();
								value.setValue(number);
								newValues.add(value);
							}
						} else if (limit.subtract(start).compareTo(BigDecimal.ZERO) < 0
								&& increment.compareTo(BigDecimal.ZERO) < 0) { // limit
																				// -
																				// start
																				// <
																				// 0
																				// &&
																				// increment
																				// <
																				// 0
							// Decrementing intervals
							for (BigDecimal number = start; number.compareTo(limit) >= 0; number = number
									.add(increment)) {
								InputVariableValue value = DefinitionFactory.eINSTANCE.createInputVariableValue();
								value.setValue(number);
								newValues.add(value);
							}
						}
						// @formatter:on
					}
				}
			}
			if (!newValues.isEmpty()) {
				boolean doit = true;
				if (newValues.size() > 10) {
					MessageBox dialog = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
					dialog.setText("Continue"); //$NON-NLS-1$
					dialog.setMessage(MessageFormat.format(
							"You are about to add {0} new values. Adding too many variable values may take some time and, in extreme cases, may even crash your IDE.\nAre you sure you want to continue?", //$NON-NLS-1$
							newValues.size()));
					if (dialog.open() == SWT.CANCEL) {
						doit = false;
					}
				}
				if (doit) {
					variable.getValues().addAll(newValues);
					valuesText.setText(""); //$NON-NLS-1$
					detailsViewer.setSelection(new StructuredSelection(newValues));
				}
			}
			valuesText.setFocus();
		}
	}

	/**
	 * {@link SelectionAdapter} of the delete button of this
	 * {@link AbstractLaunchConfigurationTab}
	 * 
	 * @author agomez
	 *
	 */
	private final class DeleteButtonSelectionAdapter extends SelectionAdapter {
		private final IViewerObservableValue variablesSelectionObservable;
		private final TableViewer valuesViewer;

		private DeleteButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable,
				TableViewer valuesViewer) {
			this.variablesSelectionObservable = variablesSelectionObservable;
			this.valuesViewer = valuesViewer;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			InputVariable variable = (InputVariable) variablesSelectionObservable.getValue();
			variable.getValues().removeAll(valuesViewer.getStructuredSelection().toList());
		}
	}

	/**
	 * {@link SelectionAdapter} of the delete all button of this
	 * {@link AbstractLaunchConfigurationTab}
	 * 
	 * @author agomez
	 *
	 */
	private final class DeleteAllButtonSelectionAdapter extends SelectionAdapter {
		private final IViewerObservableValue variablesSelectionObservable;

		private DeleteAllButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable) {
			this.variablesSelectionObservable = variablesSelectionObservable;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			InputVariable variable = (InputVariable) variablesSelectionObservable.getValue();
			variable.getValues().clear();
		}
	}

	/**
	 * {@link SelectionAdapter} of the move up button of this
	 * {@link AbstractLaunchConfigurationTab}
	 * 
	 * @author agomez
	 *
	 */
	private final class UpButtonSelectionAdapter extends SelectionAdapter {
		private final TableViewer valuesViewer;
		private final IViewerObservableValue variablesSelectionObservable;

		private UpButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable,
				TableViewer valuesViewer) {
			this.valuesViewer = valuesViewer;
			this.variablesSelectionObservable = variablesSelectionObservable;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			InputVariable variable = (InputVariable) variablesSelectionObservable.getValue();
			List<?> selection = valuesViewer.getStructuredSelection().toList();
			for (Object value : selection) {
				int currentPos = variable.getValues().indexOf(value);
				if (currentPos == 0) {
					continue;
				} else if (selection.contains(variable.getValues().get(currentPos - 1))) {
					continue;
				} else {
					variable.getValues().move(currentPos - 1, currentPos);
				}
			}
		}
	}

	/**
	 * {@link SelectionAdapter} of the move down button of this
	 * {@link AbstractLaunchConfigurationTab}
	 * 
	 * @author agomez
	 *
	 */
	private final class DownButtonSelectionAdapter extends SelectionAdapter {
		private final IViewerObservableValue variablesSelectionObservable;
		private final TableViewer valuesViewer;

		private DownButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable,
				TableViewer valuesViewer) {
			this.variablesSelectionObservable = variablesSelectionObservable;
			this.valuesViewer = valuesViewer;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			InputVariable variable = (InputVariable) variablesSelectionObservable.getValue();
			List<?> selection = valuesViewer.getStructuredSelection().toList();
			Collections.reverse(selection);
			for (Object value : selection) {
				int currentPos = variable.getValues().indexOf(value);
				if (currentPos == variable.getValues().size() - 1) {
					continue;
				} else if (selection.contains(variable.getValues().get(currentPos + 1))) {
					continue;
				} else {
					variable.getValues().move(currentPos + 1, currentPos);
				}
			}
		}
	}

	private class ValuesEditingSupport extends EditingSupport {

		final private TableViewer master;

		final private CellEditor editor;

		public ValuesEditingSupport(TableViewer detail, TableViewer master) {
			super(detail);
			this.editor = new TextCellEditor(detail.getTable());
			this.master = master;
		}

		@Override
		protected void setValue(Object element, Object value) {
			Number number = (Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, (String) value);
			InputVariableValue inputVariableValue = (InputVariableValue) element;
			inputVariableValue.setValue(number);
			getViewer().update(element, null);
			master.update(inputVariableValue.getVariable(), null);
		}

		@Override
		protected Object getValue(Object element) {
			return EcoreUtil.convertToString(DatatypesPackage.Literals.NUMBER,
					((InputVariableValue) element).getValue());
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
}
