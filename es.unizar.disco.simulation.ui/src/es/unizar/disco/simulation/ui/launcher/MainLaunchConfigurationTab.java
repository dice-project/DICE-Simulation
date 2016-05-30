package es.unizar.disco.simulation.ui.launcher;

import static es.unizar.disco.simulation.launcher.SimulationLaunchConfigurationDelegate.SIMULATION_DEFINITION__ACTIVE_SCENARIO;
import static es.unizar.disco.simulation.launcher.SimulationLaunchConfigurationDelegate.SIMULATION_DEFINITION__DOMAIN_RESOURCE_URI;
import static es.unizar.disco.simulation.launcher.SimulationLaunchConfigurationDelegate.SIMULATION_DEFINITION__INPUT_VARIABLES;
import static es.unizar.disco.simulation.launcher.SimulationLaunchConfigurationDelegate.SIMULATION_DEFINITION__OUTPUT_VARIABLES;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
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
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.core.ui.dialogs.FileSelectionDialog;
import es.unizar.disco.simulation.models.datatypes.DatatypesFactory;
import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.Variable;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.dialogs.UmlFileSelectionDialog;
import es.unizar.disco.simulation.ui.launcher.providers.ValuesColumnLabelProvider;
import es.unizar.disco.simulation.ui.launcher.providers.ValuesEditingSupport;
import es.unizar.disco.simulation.ui.launcher.strategies.NotNullTobooleanStrategy;
import es.unizar.disco.simulation.ui.launcher.strategies.StringToUriStrategy;
import es.unizar.disco.simulation.ui.launcher.strategies.UriToStringStrategy;
import es.unizar.disco.simulation.ui.util.UriConverter;

public class MainLaunchConfigurationTab extends AbstractSimulationLaunchConfigurationTab {

	private final SimulationDefinition simulationDefinition;
	
	public MainLaunchConfigurationTab() {
		this.simulationDefinition = DefinitionFactory.eINSTANCE.createSimulationDefinition();
		this.simulationDefinition.setDomainResource(DatatypesFactory.eINSTANCE.createResource());
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
		createVariableGroup(sashGroup);
		sashGroup.setWeights(new int[] { 1, 2 });
		sashGroup.setSashWidth(5);

		setControl(topComposite);
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
					inputFileText.setText(UriConverter.toPlatformResourceUri(dialog.getFile().getLocationURI()).toString());
				}
			}
		});

		// @formatter:off
		IObservableValue inputResourceEmfSource = EMFProperties
				.value(FeaturePath.fromList(DefinitionPackage.Literals.SIMULATION_DEFINITION__DOMAIN_RESOURCE, DatatypesPackage.Literals.RESOURCE__URI))
				.observe(simulationDefinition);
		// @formatter:on
		
		IObservableValue inputResourceGuiTarget = WidgetProperties.text(SWT.Modify).observe(inputFileText);
		getContext().bindValue(inputResourceEmfSource, inputResourceGuiTarget, new UriToStringStrategy(), new StringToUriStrategy());
	}

	private void createScenariosGroup(Composite composite) {
		final Group group = new Group(composite, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		group.setLayout(new GridLayout(1, false));
		group.setText("Active scenario");

		final Composite tableComposite = new Composite(group, SWT.NONE);
		tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final TableViewer scenariosViewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.NO_SCROLL | SWT.V_SCROLL);
		scenariosViewer.getTable().setLinesVisible(true);
		scenariosViewer.getTable().setHeaderVisible(false);

		scenariosViewer.setContentProvider(new ObservableListContentProvider());
		scenariosViewer.setInput(EMFProperties.list(DefinitionPackage.Literals.SIMULATION_DEFINITION__SCENARIOS).observe(simulationDefinition));
		scenariosViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		
		final TableColumn column = new TableColumn(scenariosViewer.getTable(), SWT.NONE);

		final TableColumnLayout tableLayout = new TableColumnLayout();
		tableLayout.setColumnData(column, new ColumnWeightData(1));
		tableComposite.setLayout(tableLayout);

		// @formatter:off
		IObservableValue activeScenarioEmfSource = EMFProperties
				.value(DefinitionPackage.Literals.SIMULATION_DEFINITION__ACTIVE_SCENARIO)
				.observe(simulationDefinition);
		// @formatter:on

		IObservableValue activeScenarioGuiTarget = ViewerProperties.singleSelection().observe(scenariosViewer);
		getContext().bindValue(activeScenarioEmfSource, activeScenarioGuiTarget);
	}

	private void createVariableGroup(Composite composite) {

		final SashForm sashGroup = new SashForm(composite, SWT.HORIZONTAL | SWT.SMOOTH);
		GridData sashLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		sashLayoutData.heightHint = 0;

		final IViewerObservableValue variablesSelectionObservable;
		final TableViewer variablesViewer;
		{
			final Group inputGroup = new Group(sashGroup, SWT.NONE);
			inputGroup.setLayout(new GridLayout(1, true));
			inputGroup.setText("Variables");

			final Composite tableComposite = new Composite(inputGroup, SWT.NONE);
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			variablesViewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.NO_SCROLL | SWT.V_SCROLL);
			variablesViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			variablesViewer.getTable().setLinesVisible(true);
			variablesViewer.getTable().setHeaderVisible(false);

			variablesViewer.setContentProvider(new ObservableListContentProvider());
			variablesViewer.setInput(EMFProperties.list(DefinitionPackage.Literals.SIMULATION_DEFINITION__VARIABLES).observe(simulationDefinition));
			variablesViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
			variablesViewer.setSorter(new ViewerSorter());
			variablesViewer.setFilters(new ViewerFilter[] { new InputVariablesFilter()});
			
			final TableColumn column = new TableColumn(variablesViewer.getTable(), SWT.NONE);

			final TableColumnLayout tableLayout = new TableColumnLayout();
			tableLayout.setColumnData(column, new ColumnWeightData(1));
			tableComposite.setLayout(tableLayout);
			
			// @formatter:off
			IObservableValue variablesEmfSource = EMFProperties
					.value(DefinitionPackage.Literals.SIMULATION_DEFINITION__VARIABLES)
					.observe(simulationDefinition);
			// @formatter:on

			IObservableValue variablesGuiTarget = ViewerProperties.input().observe(variablesViewer);
			getContext().bindValue(variablesEmfSource, variablesGuiTarget);
			
			variablesSelectionObservable = ViewerProperties.singleSelection().observe(variablesViewer);
		}
		{
			
			final Group valuesGroup = new Group(sashGroup, SWT.NONE);
			GridLayout valuesGroupLayout = new GridLayout(2, false);
			valuesGroupLayout.verticalSpacing = 0;
			valuesGroup.setLayout(valuesGroupLayout);
			valuesGroup.setText("Values");

			final Text valuesText = new Text(valuesGroup, SWT.BORDER);
			valuesText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			
			final Button addButton = new Button(valuesGroup, SWT.PUSH);
			addButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));
			
			final Composite tableComposite = new Composite(valuesGroup, SWT.NONE);
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			final TableViewer valuesViewer = new TableViewer(tableComposite, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION | SWT.NO_SCROLL | SWT.V_SCROLL);
			valuesViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			valuesViewer.getTable().setLinesVisible(true);
			valuesViewer.getTable().setHeaderVisible(false);

			valuesViewer.setContentProvider(new ObservableListContentProvider());
			
			final IObservableList selectedVariableValuesObservable = EMFProperties.list(DefinitionPackage.Literals.INPUT_VARIABLE__VALUES).observeDetail(variablesSelectionObservable);
			valuesViewer.setInput(selectedVariableValuesObservable);
			
			final TableViewerColumn valuesViewerColumn = new TableViewerColumn(valuesViewer, SWT.NONE);
			valuesViewerColumn.setLabelProvider(new ValuesColumnLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE))));
			valuesViewerColumn.setEditingSupport(new ValuesEditingSupport(valuesViewer));

			TableViewerEditor.create(valuesViewer, new DoubleClickActivationStrategy(valuesViewer), ColumnViewerEditor.TABBING_HORIZONTAL | 
			    ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR | 
			    ColumnViewerEditor.TABBING_VERTICAL |
			    ColumnViewerEditor.KEYBOARD_ACTIVATION);
			
			
			final TableColumnLayout tableLayout = new TableColumnLayout();
			tableLayout.setColumnData(valuesViewerColumn.getColumn(), new ColumnWeightData(1));
			tableComposite.setLayout(tableLayout);

			final Composite tableButtonsComposite = new Composite(valuesGroup, SWT.NONE);
			tableButtonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
			tableButtonsComposite.setLayout(new FillLayout(SWT.VERTICAL));
			
			final Button deleteButton = new Button(tableButtonsComposite, SWT.PUSH);
			deleteButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
			
			final Button upButton = new Button(tableButtonsComposite, SWT.PUSH);
			upButton.setImage(DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_ETOOL16_UP));
			
			final Button downButton = new Button(tableButtonsComposite, SWT.PUSH);
			downButton.setImage(DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_ETOOL16_DOWN));

			valuesText.addFocusListener(new SwitchDefaultFocusListener(addButton));
		
			addButton.addSelectionListener(new AddButtonSelectionAdapter(variablesSelectionObservable, valuesViewer, valuesText));
			deleteButton.addSelectionListener(new DeleteButtonSelectionAdapter(variablesSelectionObservable, valuesViewer));
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
			
			final ControlDecoration valueTextDecoration = new ControlDecoration(valuesText, SWT.TOP | SWT.LEFT);
			valueTextDecoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
			valueTextDecoration.setDescriptionText("Single numeric values add a single entry\n"
					+ "Space-separated values add multiple entries (e.g. '1 2.3 4.56')\n"
					+ "Three values separated by semicolons between square brackets [lower; limit; increment]\n"
					+ "add a range of values (e.g. '[1; 5; 1]' is equivalent to '1 2 3 4 5')");
			valueTextDecoration.setShowOnlyOnFocus(true);
			
			final NotNullTobooleanStrategy notNullToBooleanStrategy = new NotNullTobooleanStrategy();
			getContext().bindValue(WidgetProperties.enabled().observe(valuesText), variablesSelectionObservable, null, notNullToBooleanStrategy);
			getContext().bindValue(WidgetProperties.enabled().observe(valuesViewer.getTable()), variablesSelectionObservable, null, notNullToBooleanStrategy);
			getContext().bindValue(WidgetProperties.enabled().observe(addButton), variablesSelectionObservable, null, notNullToBooleanStrategy);
			getContext().bindValue(WidgetProperties.enabled().observe(deleteButton), variablesSelectionObservable, null, notNullToBooleanStrategy);
			getContext().bindValue(WidgetProperties.enabled().observe(upButton), variablesSelectionObservable, null, notNullToBooleanStrategy);
			getContext().bindValue(WidgetProperties.enabled().observe(downButton), variablesSelectionObservable, null, notNullToBooleanStrategy);
		}
		
		sashGroup.setLayoutData(sashLayoutData);
		sashGroup.setSashWidth(5);
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
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.removeAttribute(SIMULATION_DEFINITION__DOMAIN_RESOURCE_URI);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			URI domainResourceUri = URI.createURI(configuration.getAttribute(SIMULATION_DEFINITION__DOMAIN_RESOURCE_URI, ""));
			URI activeScenarioUri = URI.createURI(configuration.getAttribute(SIMULATION_DEFINITION__ACTIVE_SCENARIO, ""));
			Map<String, String> inputVarsInfo = configuration.getAttribute(SIMULATION_DEFINITION__INPUT_VARIABLES, new HashMap<String, String>());
			Map<String, String> outputVarsInfo = configuration.getAttribute(SIMULATION_DEFINITION__OUTPUT_VARIABLES, new HashMap<String, String>());
			
			if (!domainResourceUri.equals(simulationDefinition.getDomainResource().getUri())) {
				simulationDefinition.getDomainResource().setUri(domainResourceUri);
			}

			for (Entry<String, String> entry : inputVarsInfo.entrySet()) {
				String varName = entry.getKey();
				if (simulationDefinition.getVariable(varName) == null){
					InputVariable var = DefinitionFactory.eINSTANCE.createInputVariable();
					var.setName(varName);
					var.deserializeValues(entry.getValue());
					simulationDefinition.getVariables().add(var);
				}
			}
			
			for (Entry<String, String> entry : outputVarsInfo.entrySet()) {
				String varName = entry.getKey();
				if (simulationDefinition.getVariable(varName) == null){
					OutputVariable var = DefinitionFactory.eINSTANCE.createOutputVariable();
					var.setName(varName);
					simulationDefinition.getVariables().add(var);
				}
			}

			if (simulationDefinition.getActiveScenario() == null || EcoreUtil.getURI(simulationDefinition.getActiveScenario()).equals(activeScenarioUri)) {
				for (EObject scenario : simulationDefinition.getScenarios()) {
					if (EcoreUtil.getURI(scenario).equals(activeScenarioUri)) {
						simulationDefinition.setActiveScenario(scenario);
					}
				}
			}
		} catch (CoreException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SIMULATION_DEFINITION__DOMAIN_RESOURCE_URI, defaultToString(simulationDefinition.getDomainResource().getUri()));
		EObject activeScenario = simulationDefinition.getActiveScenario();
		if (activeScenario != null) {
			configuration.setAttribute(SIMULATION_DEFINITION__ACTIVE_SCENARIO, EcoreUtil.getURI(activeScenario).toString());
		} else {
			configuration.removeAttribute(SIMULATION_DEFINITION__ACTIVE_SCENARIO);
		}
		Map<String, String> inputVarsInfo = new HashMap<>();
		Map<String, String> outputVarsInfo = new HashMap<>();
		for (Variable var : simulationDefinition.getVariables()) {
			String varName = var.getName();
			if (var instanceof InputVariable) {
				inputVarsInfo.put(varName, ((InputVariable) var).serializeValues());
			} else {
				outputVarsInfo.put(varName, StringUtils.EMPTY);
			}
		}
		configuration.setAttribute(SIMULATION_DEFINITION__INPUT_VARIABLES, inputVarsInfo);
		configuration.setAttribute(SIMULATION_DEFINITION__OUTPUT_VARIABLES, outputVarsInfo);
	}

	private final class InputVariablesFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return element instanceof InputVariable;
		}
	}

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

	private final class AddButtonSelectionAdapter extends SelectionAdapter {
		
		private final Text valuesText;
		
		private final IViewerObservableValue variablesSelectionObservable;
	
		private final TableViewer valuesViewer;
		
		private AddButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable, TableViewer valuesViewer, Text valuesText) {
			this.valuesText = valuesText;
			this.variablesSelectionObservable = variablesSelectionObservable;
			this.valuesViewer = valuesViewer;
		}
	
		@Override
		public void widgetSelected(SelectionEvent e) {
			List<InputVariableValue> newValues = new ArrayList<>();
			InputVariable variable = (InputVariable) variablesSelectionObservable.getValue();
			String text = valuesText.getText().trim();
	
			Pattern listPattern = Pattern.compile("^(-?\\d*(\\.\\d+)?\\s*)+$");
			Matcher listMatcher = listPattern.matcher(text);
			if (listMatcher.matches()) {
				StringTokenizer tokenizer = new StringTokenizer(text, " ");
				while (tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken();
					InputVariableValue value = DefinitionFactory.eINSTANCE.createInputVariableValue();
					value.setValue((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, token));
					newValues.add(value);
				}
			} else {
				Pattern rangePattern = Pattern.compile("^\\[\\s*(?<start>-?\\d*(?:\\.\\d+)?)\\s*;\\s*(?<limit>-?\\d*(?:\\.\\d+)?)\\s*;\\s*(?<increment>-?\\d*(?:\\.\\d+)?)\\s*\\]$");
				Matcher rangeMatcher = rangePattern.matcher(text);
				if (rangeMatcher.matches()) {
					double start = new Double(rangeMatcher.group("start"));
					double limit = new Double(rangeMatcher.group("limit"));
					double increment = new Double(rangeMatcher.group("increment"));
					if (Math.abs(limit - start - increment) < Math.abs(limit - start)) { 
						for (Double number = start; number <= limit; number += increment) {
							InputVariableValue value = DefinitionFactory.eINSTANCE.createInputVariableValue();
							value.setValue(number);
							newValues.add(value);
						}
					}
				}
			}
			if (!newValues.isEmpty()) {
				variable.getValues().addAll(newValues);
				valuesText.setText(StringUtils.EMPTY);
				valuesViewer.setSelection(new StructuredSelection(newValues));
			}
			valuesText.setFocus();
		}
	}

	private final class DeleteButtonSelectionAdapter extends SelectionAdapter {
		private final IViewerObservableValue variablesSelectionObservable;
		private final TableViewer valuesViewer;
	
		private DeleteButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable, TableViewer valuesViewer) {
			this.variablesSelectionObservable = variablesSelectionObservable;
			this.valuesViewer = valuesViewer;
		}
	
		@Override
		public void widgetSelected(SelectionEvent e) {
			InputVariable variable = (InputVariable) variablesSelectionObservable.getValue();
			variable.getValues().removeAll(valuesViewer.getStructuredSelection().toList());
		}
	}

	private final class UpButtonSelectionAdapter extends SelectionAdapter {
		private final TableViewer valuesViewer;
		private final IViewerObservableValue variablesSelectionObservable;
	
		private UpButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable, TableViewer valuesViewer) {
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
					variable.getValues().move(currentPos - 1 , currentPos);
				}
			}
		}
	}

	private final class DownButtonSelectionAdapter extends SelectionAdapter {
		private final IViewerObservableValue variablesSelectionObservable;
		private final TableViewer valuesViewer;
	
		private DownButtonSelectionAdapter(IViewerObservableValue variablesSelectionObservable, TableViewer valuesViewer) {
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
					variable.getValues().move(currentPos + 1 , currentPos);
				}
			}
		}
	}
}
