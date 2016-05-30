package es.unizar.disco.simulation.ui.launcher;

import java.util.UUID;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.launcher.SimulationLaunchConfigurationDelegate;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class SimulationLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		// Tabs are added programmatically instead of using the "org.eclipse.debug.ui.launchConfigurationTabs" 
		// extension point to preserve the ordering
		// @formatter:off
		setTabs(new ILaunchConfigurationTab[] { 
				new MainLaunchConfigurationTab(), 
				new FiltersLaunchConfigurationTab(), 
				new ParametersLaunchConfigurationTab(), 
				new AdvancedLaunchConfigurationTab(), 
				new CommonTab() });
		// @formatter:on
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			if (!configuration.hasAttribute(SimulationLaunchConfigurationDelegate.SIMULATION_DEFINITION__IDENTIFIER)) {
				ILaunchConfigurationWorkingCopy workingCopy = configuration.getWorkingCopy();
				workingCopy.setAttribute(SimulationLaunchConfigurationDelegate.SIMULATION_DEFINITION__IDENTIFIER, UUID.randomUUID().toString());
				workingCopy.doSave();
			}
		} catch (CoreException e) {
			DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
		}
		super.initializeFrom(configuration);
	}
}
