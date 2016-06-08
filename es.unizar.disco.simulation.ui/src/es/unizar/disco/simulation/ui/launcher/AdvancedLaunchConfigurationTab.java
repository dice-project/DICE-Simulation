package es.unizar.disco.simulation.ui.launcher;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.core.ui.dialogs.ContainerSelectionDialog;
import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.launcher.SimulationDefinitionConfigurationHandler;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.launcher.strategies.StringToUriStrategy;
import es.unizar.disco.simulation.ui.launcher.strategies.UriToStringStrategy;
import es.unizar.disco.simulation.ui.preferences.PreferenceConstants;
import es.unizar.disco.simulation.ui.util.UriConverter;

public class AdvancedLaunchConfigurationTab extends AbstractSimulationLaunchConfigurationTab {

	private final SimulationDefinitionConfigurationHandler handler;

	public AdvancedLaunchConfigurationTab(SimulationDefinition simulationDefinition) {
		super(simulationDefinition);
		handler = SimulationDefinitionConfigurationHandler.create(simulationDefinition);
	}

	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, true));

		{ // Identifier Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

			group.setLayout(new GridLayout(1, false));
			group.setText("Simulation Identifier");

			final Text uuidText = new Text(group, SWT.BORDER | SWT.READ_ONLY);
			uuidText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

			IObservableValue uuidEmfSource = EMFProperties.value(DefinitionPackage.Literals.SIMULATION_DEFINITION__IDENTIFIER).observe(simulationDefinition);

			IObservableValue uuidGuiTarget = WidgetProperties.text(SWT.Modify).observe(uuidText);
			context.bindValue(uuidEmfSource, uuidGuiTarget);
		}

		{ // Intermediate Files Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

			group.setLayout(new GridLayout(2, false));
			group.setText("Working Area");

			final Text workingAreaText = new Text(group, SWT.BORDER | SWT.READ_ONLY);
			workingAreaText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

			final Button workingAreaButton = new Button(group, SWT.NONE);
			workingAreaButton.setText(Messages.MainLaunchConfigurationTab_browseLabel);

			final GridData buttonsGridData = new GridData(SWT.CENTER, SWT.CENTER, false, false);
			buttonsGridData.widthHint = 100;
			workingAreaButton.setLayoutData(buttonsGridData);

			workingAreaButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell());
					String workingArea = workingAreaText.getText();
					if (StringUtils.isNotBlank(workingArea)) {
						String platformString = URI.createURI(workingArea).toPlatformString(true);
						if (platformString != null) {
							final Path workingAreaPath = new Path(platformString);
							IContainer container = ResourcesPlugin.getWorkspace().getRoot().getFolder(workingAreaPath);
							dialog.setInitialSelection(container);
						}
					}
					if (dialog.open() == Dialog.OK) {
						workingAreaText.setText(UriConverter.toPlatformResourceUri(dialog.getContainer().getLocationURI()).toString());
					}
				}
			});

			IObservableValue workingAreaEmfSource = EMFProperties.value(DefinitionPackage.Literals.SIMULATION_DEFINITION__WORKING_AREA)
					.observe(simulationDefinition);

			IObservableValue workingAreaGuiTarget = WidgetProperties.text(SWT.Modify).observe(workingAreaText);
			context.bindValue(workingAreaEmfSource, workingAreaGuiTarget, new UriToStringStrategy(), new StringToUriStrategy());
		}

		{ // Simulation Backend Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

			group.setLayout(new GridLayout(1, false));
			group.setText("Simulation backend");

			Combo simBackendCombo = new Combo(group, SWT.READ_ONLY);
			simBackendCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			for (String backend : DiceSimulationPlugin.getDefault().getSimulationBackends()) {
				simBackendCombo.add(backend);
			}
			// @formatter:off
			IObservableValue selectedBackendEmfSource = EMFProperties
					.value(DefinitionPackage.Literals.SIMULATION_DEFINITION__BACKEND)
					.observe(simulationDefinition);
			// @formatter:on

			IObservableValue selectedBackendGuiTarget = WidgetProperties.selection().observe(simBackendCombo);
			context.bindValue(selectedBackendEmfSource, selectedBackendGuiTarget);
		}
		setControl(topComposite);
	}

	@Override
	public String getName() {
		return "Advanced";
	}

	@Override
	public Image getImage() {
		return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_ADVANCED_TAB);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			handler.initializeIdentifier(configuration);
			handler.initializeWorkingArea(configuration);
			String preferredBackend = DiceSimulationUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.BACKEND);
			handler.initializeBackend(configuration, preferredBackend);

		} catch (CoreException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		handler.saveWorkingArea(configuration);
		handler.saveBackend(configuration);
	}
}
