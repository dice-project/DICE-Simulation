package es.unizar.disco.simulation.ui.launcher;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;

import es.unizar.disco.simulation.models.definition.SimulationDefinition;

public abstract class AbstractSimulationLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	protected final SimulationDefinition simulationDefinition;

	protected final DataBindingContext context = new DataBindingContext();

	public AbstractSimulationLaunchConfigurationTab(SimulationDefinition simulationDefinition) {
		this.simulationDefinition = simulationDefinition;
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	protected boolean isActive() {
		return getControl().isVisible();
	}

	protected static String defaultToString(Object obj) {
		return obj != null ? StringUtils.defaultString(obj.toString()) : "";
	}
}