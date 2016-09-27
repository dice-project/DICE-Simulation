
package es.unizar.disco.simulation.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Element;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.pnml.m2m.builder.AbstractPnmlResourceBuilder;
import es.unizar.disco.pnml.m2m.builder.ActivityDiagram2PnmlReliabilityResourceBuilder;
import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder.ModelResult;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;

public class ReliabilityNetGenerationTest {

	public ResourceSet resourceSet;

	//Hopefully "definition" will not be required (in case that the "invocation" has the bidirectional reference)
	public SimulationDefinition definition;
	public SimulationInvocation invocation;

	@BeforeClass
	public void loadModels() throws IOException {
		System.out.println("Loading models from registry");
		final URI baseUri = URI.createFileURI(SimulationInvocationsRegistry.FILES_DIRECTORY.getPath());
		final URI defURI = baseUri.appendSegment("e4012c46-f3bb-41fe-99c2-1ffdba8cb4ef").appendFileExtension("def")
				.appendFileExtension(XMIResource.XMI_NS);
		final URI invURI = baseUri.appendSegment("f37f3e0e-4950-4ae7-a1b9-8deec412efe4").appendFileExtension("inv")
				.appendFileExtension(XMIResource.XMI_NS);

		definition = (SimulationDefinition) loadResourceFromUri(defURI);

		invocation = (SimulationInvocation) loadResourceFromUri(invURI);

	}

	private EObject loadResourceFromUri(URI theURI) throws IOException {
		Resource theResource = getResourceSet().getResource(theURI, true);
		theResource.load(Collections.EMPTY_MAP);
		return theResource.getContents().get(0);
	}

	public synchronized ResourceSet getResourceSet() {

		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	@Test
	public void testCreationNet() {
		//writing over the initial "definition"
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder translator = new ActivityDiagram2PnmlReliabilityResourceBuilder();
		
		ModelResult result = translator.createAnalyzableModel((Element) definition.getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());
		IStatus status = result.getStatus();
		if (status.getSeverity() != IStatus.ERROR) {
			super.getAnalyzableModel().addAll(result.getModel());
			super.setTraceSet(result.getTraceSet());
		}
		
		translator.createAnalyzableModel(element, assignments)
	}

}