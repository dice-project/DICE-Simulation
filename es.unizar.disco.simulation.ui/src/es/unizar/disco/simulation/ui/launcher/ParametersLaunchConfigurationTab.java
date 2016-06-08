package es.unizar.disco.simulation.ui.launcher;

import static es.unizar.disco.simulation.launcher.SimulationLaunchConfigurationDelegate.SIMULATION_DEFINITION__MAX_EXECUTION_TIME;
import static es.unizar.disco.simulation.launcher.SimulationLaunchConfigurationDelegate.SIMULATION_DEFINITION__PARAMETERS;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.core.ui.util.Highlighter;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.wnsim.SimulationParameters;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.launcher.strategies.IntegerToStringStrategy;
import es.unizar.disco.simulation.ui.launcher.strategies.StringToIntegerStrategy;

public class ParametersLaunchConfigurationTab extends AbstractSimulationLaunchConfigurationTab {

	protected final EContentAdapter contentAdapter = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__MAX_EXECUTION_TIME ||
					notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__PARAMETERS ||
					notification.getFeature() == DefinitionPackage.Literals.SIMULATION_PARAMETER__VALUE) {
				if (ParametersLaunchConfigurationTab.this.isActive()) {
					updateLaunchConfigurationDialog();
				}
			}
		};
	};
	
	public ParametersLaunchConfigurationTab(SimulationDefinition simulationDefinition) {
		super(simulationDefinition);
		this.simulationDefinition.eAdapters().add(contentAdapter);
	}

	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, true));

		{ // General Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

			group.setLayout(new GridLayout(2, false));
			group.setText("General");

			final Label maxTimeLabel = createLabel(group, "Maximum simulation execution time");
			maxTimeLabel.setToolTipText("Time after which the simulation will be aborted");
			final DateTime maxTimeDateTime = new DateTime(group, SWT.TIME);
			maxTimeDateTime.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
			maxTimeDateTime.setTime(1, 0, 0);

			Highlighter.addHighlight(group, maxTimeLabel, maxTimeDateTime);

			// @formatter:off
			IObservableValue maxExecTimeEmfObservable = EMFProperties.value(
					DefinitionPackage.Literals.SIMULATION_DEFINITION__MAX_EXECUTION_TIME)
					.observe(simulationDefinition);
			context.bindValue(maxExecTimeEmfObservable, WidgetProperties.selection().observe(maxTimeDateTime));
			// @formatter:on
		}

		{ // WNSIM Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

			group.setLayout(new GridLayout(2, false));
			group.setText("Simulation parameters");

			final Label confidenceLabel = createLabel(group, "Confidence level (%)");
			confidenceLabel.setToolTipText("Confidence level (%)");

			final Combo confidenceCombo = createCombo(group, new String[] { "60", "70", "80", "90", "95", "99" }, 4);

			final Label accuracyLabel = createLabel(group, "Accuracy (%)");
			accuracyLabel.setToolTipText("Accuracy of the results, i.e., half-width of the confidence interval");

			final Spinner accuracySpinner = createSpinner(group, 1, 20, 5);

			final Label seedLabel = createLabel(group, "Seed");
			seedLabel.setToolTipText("Seed for the generation of pseudo-random numbers");

			final Spinner seedSpinner = createSpinner(group, 1, Short.MAX_VALUE, 31415);

			final Label firstTrLenLabel = createLabel(group, "First transient period length ");
			firstTrLenLabel.setToolTipText("Length of the transient period in terms of the number of transition firings");

			final Spinner firstTrLenSpinner = createSpinner(group, 1, Integer.MAX_VALUE, 1000);

			final Label trLenLabel = createLabel(group, "Transient period length");
			trLenLabel.setToolTipText("Length of the transient period between two batches in terms of the number of transition firings");

			final Spinner trLenSpinner = createSpinner(group, 1, Short.MAX_VALUE, 1000);

			final Label minBatchLenLabel = createLabel(group, "Minimum batch length");
			minBatchLenLabel.setToolTipText("Minimum batch length in terms of the number of transition firings");

			final Spinner minBatchLenSpinner = createSpinner(group, 1, Short.MAX_VALUE, 1000);

			final Label maxBatchLenLabel = createLabel(group, "Maximum batch length");
			maxBatchLenLabel.setToolTipText("Maximum batch length in terms of the number of transition firings");

			final Spinner maxBatchLenSpinner = createSpinner(group, 1, Short.MAX_VALUE, 2000);

			final Label startTimeLabel = createLabel(group, "Tracing starting point");
			startTimeLabel.setToolTipText("Starting time for debug output");

			final Spinner startTimeSpinner = createSpinner(group, 0, Short.MAX_VALUE, 0);

			Highlighter.addHighlight(group, confidenceLabel, confidenceCombo);
			Highlighter.addHighlight(group, accuracyLabel, accuracySpinner);
			Highlighter.addHighlight(group, seedLabel, seedSpinner);
			Highlighter.addHighlight(group, firstTrLenLabel, firstTrLenSpinner);
			Highlighter.addHighlight(group, trLenLabel, trLenSpinner);
			Highlighter.addHighlight(group, minBatchLenLabel, minBatchLenSpinner);
			Highlighter.addHighlight(group, maxBatchLenLabel, maxBatchLenSpinner);
			Highlighter.addHighlight(group, startTimeLabel, startTimeSpinner);

			IObservableMap observableMap = EMFProperties.map(DefinitionPackage.Literals.SIMULATION_DEFINITION__PARAMETERS).observe(simulationDefinition);

			IObservableValue confLevelEmfObservable = Observables.observeMapEntry(observableMap, SimulationParameters.CONF_LEVEL.getName());
			IObservableValue accuracyEmfObservable = Observables.observeMapEntry(observableMap, SimulationParameters.APPROX.getName());
			IObservableValue seedEmfObservable = Observables.observeMapEntry(observableMap, SimulationParameters.SEED.getName());
			IObservableValue firstTrLenEmfObservable = Observables.observeMapEntry(observableMap, SimulationParameters.FIRST_TR_LENGTH.getName());
			IObservableValue trLenEmfObservable = Observables.observeMapEntry(observableMap, SimulationParameters.TR_LENGTH.getName());
			IObservableValue minBatchEmfObservable = Observables.observeMapEntry(observableMap, SimulationParameters.MIN_BTC.getName());
			IObservableValue maxBatchEmfObservable = Observables.observeMapEntry(observableMap, SimulationParameters.MAX_BTC.getName());
			IObservableValue startEmfObservable = Observables.observeMapEntry(observableMap, SimulationParameters.START.getName());

			StringToIntegerStrategy s2iStrategy = new StringToIntegerStrategy();
			IntegerToStringStrategy i2sStrategy = new IntegerToStringStrategy();

			context.bindValue(confLevelEmfObservable, WidgetProperties.selection().observe(confidenceCombo));
			context.bindValue(accuracyEmfObservable, WidgetProperties.selection().observe(accuracySpinner), s2iStrategy, i2sStrategy);
			context.bindValue(seedEmfObservable, WidgetProperties.selection().observe(seedSpinner), s2iStrategy, i2sStrategy);
			context.bindValue(firstTrLenEmfObservable, WidgetProperties.selection().observe(firstTrLenSpinner), s2iStrategy, i2sStrategy);
			context.bindValue(trLenEmfObservable, WidgetProperties.selection().observe(trLenSpinner), s2iStrategy, i2sStrategy);
			context.bindValue(minBatchEmfObservable, WidgetProperties.selection().observe(minBatchLenSpinner), s2iStrategy, i2sStrategy);
			context.bindValue(maxBatchEmfObservable, WidgetProperties.selection().observe(maxBatchLenSpinner), s2iStrategy, i2sStrategy);
			context.bindValue(startEmfObservable, WidgetProperties.selection().observe(startTimeSpinner), s2iStrategy, i2sStrategy);

		}

		setControl(topComposite);
	}

	@Override
	public String getName() {
		return "Parameters";
	}

	@Override
	public Image getImage() {
		return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_PARAMS_TAB);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			Map<String, String> parameters = configuration.getAttribute(SIMULATION_DEFINITION__PARAMETERS, new HashMap<String, String>());
			for (Entry<String, String> entry : parameters.entrySet()) {
				if (!StringUtils.equals(entry.getValue(), simulationDefinition.getParameters().get(entry.getKey()))) {
					simulationDefinition.getParameters().put(entry.getKey(), entry.getValue());
				}
			}
			Date maxExecTime = (Date) EcoreUtil.createFromString(EcorePackage.Literals.EDATE,
					configuration.getAttribute(SIMULATION_DEFINITION__MAX_EXECUTION_TIME, (String) null));
			if (maxExecTime != null && !maxExecTime.equals(simulationDefinition.getMaxExecutionTime())) {
				simulationDefinition.setMaxExecutionTime(maxExecTime);
			}
		} catch (CoreException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SIMULATION_DEFINITION__PARAMETERS, simulationDefinition.getParameters().map());
		configuration.setAttribute(SIMULATION_DEFINITION__MAX_EXECUTION_TIME,
				EcoreUtil.convertToString(EcorePackage.Literals.EDATE, simulationDefinition.getMaxExecutionTime()));
	}

	private static final int RIGHT_COL_WIDTH = 40;

	protected static Label createLabel(Composite parent, String text) {
		final Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false));
		label.setText(text);
		return label;
	}

	protected static Combo createCombo(Composite parent, String[] options, int selection) {
		final GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gridData.widthHint = RIGHT_COL_WIDTH;

		final Combo combo = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);
		combo.setLayoutData(gridData);
		for (String option : options) {
			combo.add(option);
		}
		combo.select(selection);
		return combo;
	}

	protected static Spinner createSpinner(Composite parent, int min, int max, int defValue) {
		final GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gridData.widthHint = RIGHT_COL_WIDTH;

		final Spinner spinner = new Spinner(parent, SWT.BORDER);
		spinner.setLayoutData(gridData);
		spinner.setMinimum(min);
		spinner.setMaximum(max);
		spinner.setSelection(defValue);

		return spinner;
	}
}
