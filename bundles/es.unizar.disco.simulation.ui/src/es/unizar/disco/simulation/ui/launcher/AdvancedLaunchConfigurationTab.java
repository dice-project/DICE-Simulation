package es.unizar.disco.simulation.ui.launcher;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.launcher.SimulationDefinitionConfigurationHandler;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.preferences.PreferenceConstants;

public class AdvancedLaunchConfigurationTab extends AbstractSimulationLaunchConfigurationTab {

	protected final Adapter adapter = new AdapterImpl() {
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__IDENTIFIER |
					notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__BACKEND) {
				if (AdvancedLaunchConfigurationTab.this.isActive()) {
					updateLaunchConfigurationDialog();
				}
			}
		};
	};

	
	private final SimulationDefinitionConfigurationHandler handler;

	public AdvancedLaunchConfigurationTab(SimulationDefinition simulationDefinition) {
		super(simulationDefinition);
		handler = SimulationDefinitionConfigurationHandler.create(simulationDefinition);
		this.simulationDefinition.eAdapters().add(adapter);
	}

	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, true));

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
			String preferredBackend = DiceSimulationUiPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.BACKEND);
			handler.initializeBackend(configuration, preferredBackend);

		} catch (CoreException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		handler.saveBackend(configuration);
	}
}
