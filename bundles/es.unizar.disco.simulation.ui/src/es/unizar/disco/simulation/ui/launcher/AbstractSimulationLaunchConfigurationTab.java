/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
package es.unizar.disco.simulation.ui.launcher;

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
		return getControl() != null && getControl().isVisible();
	}
}