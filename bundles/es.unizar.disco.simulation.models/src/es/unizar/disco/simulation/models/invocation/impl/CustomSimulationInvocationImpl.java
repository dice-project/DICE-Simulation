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
package es.unizar.disco.simulation.models.invocation.impl;

import java.text.MessageFormat;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.models.DiceModelsPlugin;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder.ModelResult;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class CustomSimulationInvocationImpl extends SimulationInvocationImpl implements SimulationInvocation {

	private static final String EXTENSION_ID = Messages.CustomSimulationInvocation_nameOfExtPoints;
	private static final String BUILDER = Messages.CustomSimulationInvocation_extPoint_builder;
	private static final String PRIORITY = Messages.CustomSimulationInvocation_extPoint_priority;
	private static final String METACLASS = Messages.CustomSimulationInvocation_extPoint_metaclass;
	private static final String SCENARIO = Messages.CustomSimulationInvocation_extPoint_scenario;
	private static final String ANALYZABLE_PROPERTY = Messages.CustomSimulationInvocation_extPoint_analyzableProperty;

	@Override
	public String getIdentifier() {
		if (identifier == null) {
			identifier = UUID.randomUUID().toString();
		}
		return identifier;
	}

	@Override
	public EList<EObject> getAnalyzableModel() {
		if (analyzableModel == null && isAutoBuild()) {
			IStatus status = buildAnalyzableModel();
			if (status.getSeverity() == IStatus.ERROR) {
				throw new RuntimeException(status.getMessage(), status.getException());
			}
		}
		return super.getAnalyzableModel();
	}

	@Override
	public IStatus buildAnalyzableModel() {
		IAnalyzableModelBuilder builder = findAnalyzableResourceBuilder();
		if (builder == null) {
			throw new RuntimeException(MessageFormat.format(Messages.CustomSimulationInvocation_builderNotFound,
					getDefinition().getDomainResource().getUri()));
		}
		ModelResult result = builder.createAnalyzableModel((Element) getDefinition().getActiveScenario(),
				getVariableConfiguration().toPrimitiveAssignments());
		IStatus status = result.getStatus();
		if (status.getSeverity() != IStatus.ERROR) {
			super.getAnalyzableModel().addAll(result.getModel());
			super.setTraceSet(result.getTraceSet());
		}
		return status;
	}

	private IAnalyzableModelBuilder findAnalyzableResourceBuilder() {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_ID);
		int oldPriority = Integer.MIN_VALUE;
		IAnalyzableModelBuilder priorityBuilder = null;
		for (IConfigurationElement configElement : configElements) {
			int priority = Integer.valueOf(configElement.getAttribute(PRIORITY));
			DiceLogger.logInfo(DiceModelsPlugin.getDefault(), "Checking whether plugin " + configElement.getAttribute("builder") + "Is the chosen one for the m2m");
			if (priority > oldPriority) {
				String metaclass = configElement.getAttribute(METACLASS);
				String stereotypeName = configElement.getAttribute(SCENARIO);
				String computableNFPofextension = configElement.getAttribute(ANALYZABLE_PROPERTY);
				Element scenario = (Element) getDefinition().getActiveScenario();
				String propertyTypeToCompute = getDefinition().getNfpToCompute().toString();				
				Stereotype stereotype = scenario.getAppliedStereotype(stereotypeName);
				if (StringUtils.equals(metaclass, scenario.eClass().getInstanceTypeName())
						&& scenario.isStereotypeApplied(stereotype)
						&& propertyTypeToCompute.equalsIgnoreCase(computableNFPofextension)) {
					oldPriority = priority;
					DiceLogger.logInfo(DiceModelsPlugin.getDefault(), configElement.getAttribute("builder") + " is the best builder up to now");
					
					try {
						DiceLogger.logInfo(DiceModelsPlugin.getDefault(), "Creating an excecutable extension of " + configElement.getAttribute(BUILDER));
						priorityBuilder = (IAnalyzableModelBuilder) configElement.createExecutableExtension(BUILDER);
					} catch (CoreException e) {
						DiceLogger.logInfo(DiceModelsPlugin.getDefault(), "The creation of excecutable extension of " + configElement.getAttribute(BUILDER) + " throws a CoreException");
						throw new RuntimeException(e);
					}
				}
			}
		}
		return priorityBuilder;
	}
}
