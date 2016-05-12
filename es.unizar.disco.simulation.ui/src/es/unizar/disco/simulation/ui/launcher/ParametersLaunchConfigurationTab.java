package es.unizar.disco.simulation.ui.launcher;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.edit.domain.EditingDomain;
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

import es.unizar.disco.core.ui.util.Highlighter;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class ParametersLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	private static final int RIGHT_COL_WIDTH = 40;
	
	protected EditingDomain editingDomain;
	
	public ParametersLaunchConfigurationTab(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, true));
		
		{ // General Group
			
			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			
			group.setLayout(new GridLayout(2,  false));
			group.setText("General");
			
			final Label maxTimeLabel = createLabel(group, "Maximum execution time");
			maxTimeLabel.setToolTipText("Time after which the simulation will be aborted");
			final DateTime maxTimeDateTime = new DateTime(group, SWT.TIME);
			maxTimeDateTime.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
			maxTimeDateTime.setTime(1, 0, 0);

			Highlighter.addHighlight(group, maxTimeLabel, maxTimeDateTime);
		}
		
		{ // WNSIM Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			
			group.setLayout(new GridLayout(2,  false));
			group.setText("Simulation parameters");
			
			final Label confidenceLabel = createLabel(group, "Confidence level (%)");
			final Combo confidenceCombo = createCombo(group, new String []{ "60", "70", "80", "90", "95", "99"}, 4);
			confidenceLabel.setToolTipText("Confidence level (%)");
			
			final Label accuracyLabel = createLabel(group, "Accuracy (%)");
			final Spinner accuracySpinner = createSpinner(group, 1, 20, 5);
			accuracyLabel.setToolTipText("Accuracy of the results, i.e., half-width of the confidence interval");

			final Label seedLabel = createLabel(group, "Seed");
			final Spinner seedSpinner = createSpinner(group, 1, Short.MAX_VALUE, 31415);
			seedLabel.setToolTipText("Seed for the generation of pseudo-random numbers");
			
			final Label firstTrLenLabel = createLabel(group, "First transient period length ");
			final Spinner firstTrLenSpinner = createSpinner(group, 1, Integer.MAX_VALUE, 1000);
			firstTrLenLabel.setToolTipText("Length of the transient period in terms of the number of transition firings");

			final Label trLenLabel = createLabel(group, "Transient period length");
			final Spinner trLenSpinner = createSpinner(group, 1, Short.MAX_VALUE, 1000);
			trLenLabel.setToolTipText("Length of the transient period between two batches in terms of the number of transition firings");
			
			final Label minBatchLenLabel = createLabel(group, "Minimum batch length");
			final Spinner minBatchLenSpinner = createSpinner(group, 1, Short.MAX_VALUE, 1000);
			minBatchLenLabel.setToolTipText("Minimum batch length in terms of the number of transition firings");

			final Label maxBatchLenLabel = createLabel(group, "Maximum batch length");
			final Spinner maxBatchLenSpinner = createSpinner(group, 1, Short.MAX_VALUE, 2000);
			maxBatchLenLabel.setToolTipText("Maximum batch length in terms of the number of transition firings");
			
			final Label startTimeLabel = createLabel(group, "Tracing starting point");
			final Spinner startTimeSpinner = createSpinner(group, 0, Short.MAX_VALUE, 0);
			startTimeLabel.setToolTipText("Starting time for debug output");
			
			Highlighter.addHighlight(group, confidenceLabel, confidenceCombo);
			Highlighter.addHighlight(group, accuracyLabel, accuracySpinner);
			Highlighter.addHighlight(group, seedLabel, seedSpinner);
			Highlighter.addHighlight(group, firstTrLenLabel, firstTrLenSpinner);
			Highlighter.addHighlight(group, trLenLabel, trLenSpinner);
			Highlighter.addHighlight(group, minBatchLenLabel, minBatchLenSpinner);
			Highlighter.addHighlight(group, maxBatchLenLabel, maxBatchLenSpinner);
			Highlighter.addHighlight(group, startTimeLabel, startTimeSpinner);
		}

		setControl(topComposite);
	}

	private static Label createLabel(Composite parent, String text) {
		final Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false));
		label.setText(text);
		return label;
	}

	private static Combo createCombo(Composite parent, String[] options, int selection) {
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

	private static Spinner createSpinner(Composite parent, int min, int max, int defValue) {
		final GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gridData.widthHint = RIGHT_COL_WIDTH;
		
		final Spinner spinner = new Spinner(parent, SWT.BORDER);
		spinner.setLayoutData(gridData);
		spinner.setMinimum(min);
		spinner.setMaximum(max);
		spinner.setSelection(defValue);
		
		return spinner;
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
		return "Parameters";
	}

	@Override
	public Image getImage() {
		return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_PARAMS_TAB);
	}
	
}
