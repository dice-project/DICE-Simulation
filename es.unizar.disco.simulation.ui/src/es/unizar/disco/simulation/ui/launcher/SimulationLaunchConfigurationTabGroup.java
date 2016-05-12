package es.unizar.disco.simulation.ui.launcher;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

public class SimulationLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	EditingDomain editingDomain;

	public SimulationLaunchConfigurationTabGroup() {
		// @formatter:off
		editingDomain = new AdapterFactoryEditingDomain(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE),
				new BasicCommandStack());
		// @formatter:on
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		// @formatter:off
		setTabs(new ILaunchConfigurationTab[] { 
				new MainLaunchConfigurationTab(editingDomain), 
				new ParametersLaunchConfigurationTab(editingDomain), 
				new FiltersLaunchConfigurationTab(editingDomain), 
				new AdvancedLaunchConfigurationTab(editingDomain), 
				new CommonTab() });
		// @formatter:on
	}

}
