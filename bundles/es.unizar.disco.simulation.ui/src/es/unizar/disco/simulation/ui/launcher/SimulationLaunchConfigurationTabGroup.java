package es.unizar.disco.simulation.ui.launcher;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import es.unizar.disco.simulation.models.datatypes.DatatypesFactory;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;

public class SimulationLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	private final SimulationDefinition simulationDefinition = DefinitionFactory.eINSTANCE.createSimulationDefinition();

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		// Tabs are added programmatically instead of using the "org.eclipse.debug.ui.launchConfigurationTabs" 
		// extension point to preserve the ordering
		// @formatter:off
		this.simulationDefinition.setAutoSync(true);
		this.simulationDefinition.setDomainResource(DatatypesFactory.eINSTANCE.createResource());
		setTabs(new ILaunchConfigurationTab[] { 
				new MainLaunchConfigurationTab(simulationDefinition), 
				new FiltersLaunchConfigurationTab(simulationDefinition), 
				new ParametersLaunchConfigurationTab(simulationDefinition), 
				new AdvancedLaunchConfigurationTab(simulationDefinition), 
				new CommonTab() });
		// @formatter:on
	}
}
