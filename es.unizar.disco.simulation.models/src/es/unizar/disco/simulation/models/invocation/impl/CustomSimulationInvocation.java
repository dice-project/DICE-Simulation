package es.unizar.disco.simulation.models.invocation.impl;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import es.unizar.disco.simulation.models.builders.BuildException;
import es.unizar.disco.simulation.models.builders.IAnalyzableResourceBuilder;
import es.unizar.disco.simulation.models.datatypes.Resource;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class CustomSimulationInvocation extends SimulationInvocationImpl implements SimulationInvocation {

	private static final String EXTENSION_ID = "es.unizar.disco.simulation.models.analyzable_resource_builder";
	private static final String BUILDER = "builder";
	private static final String PRIORITY = "priority";
	private static final String METACLASS = "metaclass";
	private static final String SCENARIO = "scenario";

	@Override
	public URI getDomainResource() {
		if (getDefinition() != null && getDefinition().getDomainResource() != null) {
			return getDefinition().getDomainResource().getUri();
		}
		return null;
	}

	@Override
	public Resource getAnalyzableResource() {
		if (super.getAnalyzableResource() == null) {
			try {
				IAnalyzableResourceBuilder builder = findAnalyzableResourceBuilder();
				if (builder == null) {
					throw new RuntimeException(
							MessageFormat.format("Unable to build a proper IAnalizableResourceBuilder for ''{0}''", getDefinition().getDomainResource().getUri()));
				}
				URI resourceUri = getDefinition().getWorkingArea().appendSegment(getIdentifier()).appendFileExtension("pnml").appendFileExtension(XMIResource.XMI_NS);
				setAnalyzableResource(builder.createAnalyzableResource(this, resourceUri));
			} catch (BuildException e) {
				throw new RuntimeException(e);
			}
		}
		return super.getAnalyzableResource();
	}

	private IAnalyzableResourceBuilder findAnalyzableResourceBuilder() {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		int oldPriority = Integer.MIN_VALUE;
		for (IConfigurationElement configElement : configElements) {
			int priority = Integer.valueOf(configElement.getAttribute(PRIORITY));
			if (priority > oldPriority) {
				oldPriority = priority;
				String metaclass = configElement.getAttribute(METACLASS);
				String stereotypeName = configElement.getAttribute(SCENARIO);
				Element scenario = (Element) getDefinition().getActiveScenario();
				Stereotype stereotype = scenario.getApplicableStereotype(stereotypeName);
				if (StringUtils.equals(metaclass, scenario.eClass().getInstanceTypeName()) && scenario.isStereotypeApplied(stereotype)) {
					try {
						return (IAnalyzableResourceBuilder) configElement.createExecutableExtension(BUILDER);
					} catch (CoreException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		return null;
	}
}
