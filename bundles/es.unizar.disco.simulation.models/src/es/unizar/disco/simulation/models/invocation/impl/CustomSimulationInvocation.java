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

import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder.ModelResult;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class CustomSimulationInvocation extends SimulationInvocationImpl implements SimulationInvocation {

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
			if (priority > oldPriority) {
				String metaclass = configElement.getAttribute(METACLASS);
				String stereotypeName = configElement.getAttribute(SCENARIO);
				String computableNFPofextension = configElement.getAttribute(ANALYZABLE_PROPERTY);
				Element scenario = (Element) getDefinition().getActiveScenario();
				String propertyTypeToCompute = getDefinition().getNfpToCompute().toString();
				Stereotype stereotype = scenario.getApplicableStereotype(stereotypeName);
				if (StringUtils.equals(metaclass, scenario.eClass().getInstanceTypeName())
						&& scenario.isStereotypeApplied(stereotype)
						&& propertyTypeToCompute.equalsIgnoreCase(computableNFPofextension)) {
					oldPriority = priority;
					try {
						priorityBuilder = (IAnalyzableModelBuilder) configElement.createExecutableExtension(BUILDER);
					} catch (CoreException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		return priorityBuilder;
	}
}
