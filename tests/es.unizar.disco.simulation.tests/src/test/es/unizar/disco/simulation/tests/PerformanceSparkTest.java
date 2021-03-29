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

package test.es.unizar.disco.simulation.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.unizar.disco.pnml.m2m.builder.SparkActivityDiagram2PnmlResourceBuilder;
import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.greatspn.ssh.calculators.ActivityResponseTimeCalculatorSpark;
import es.unizar.disco.simulation.launcher.Messages;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder.ModelResult;
import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.simresult.SimresultFactory;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulationException;
import fr.lip6.move.pnml.ptnet.Arc;
import fr.lip6.move.pnml.ptnet.PetriNetDoc;
import fr.lip6.move.pnml.ptnet.PnObject;
import fr.lip6.move.pnml.ptnet.Transition;
import fr.lip6.move.pnml.ptnet.Place;

public class PerformanceSparkTest extends AbstractTest {

	final static String DEFINITION_FILENAME = "feb0caa4-89a4-4c90-8903-ddd65a58aec3";
	final static String INVOCATION_FILENAME = "2f6fd7f5-ab6b-4827-87e8-9410952da65b";

	final static String RELATIVE_PATH = "performanceSpark/";

	final static String UML_FILENAME = "model";

	@Before
	public void loadParticularModels() throws IOException {
		loadModels(RELATIVE_PATH + DEFINITION_FILENAME, RELATIVE_PATH + INVOCATION_FILENAME);

	}

	@Test
	public void testLoadProfiledModel() throws IOException {

		Model model = loadUMLModel(RELATIVE_PATH + UML_FILENAME);

		assertTrue("The " + UML_FILENAME + " model does not contain hadoop operation stereotype", contains(model.getPackagedElements(),"SparkScenario"));
		System.out.println("The " + UML_FILENAME + " contains : " + model.getPackagedElements());

		Activity sparkScenario = (Activity) getStereotypedElement(model.getPackagedElements(),"SparkScenario");

		System.out.println("The spark scenario contains: " + sparkScenario);
		System.out.println("The spark scenario contains stereotypes: " + sparkScenario.getAppliedStereotypes());
		System.out.println("The spark scenario contains nodes: " + sparkScenario.getNodes());

		//Element hadoopOpElement = getStereotypedElement(model.getPackagedElements(),"HadoopOperation");
		int count = 0;
		for (ActivityNode sparkNode : sparkScenario.getNodes()) {
			if ((sparkNode.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Spark::SparkTransformation") != null) || 
				(sparkNode.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Spark::SparkAction") != null)) {
				count++;
			}
        }

		assertTrue("The " + UML_FILENAME + " model does not contain spark operation stereotype", count > 0);

		Element computNode = getStereotypedElement(model.getPackagedElements(),"SparkNode");
		System.out.println("The spark scenario contains SparkNode: " + computNode);

		assertTrue("The SparkNode stereotype does not contain information about number of cores ",
				(computNode.getValue(computNode.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Spark::SparkNode"), "nCores")!=null));
	}

	@Test
	public void testCreationNet() throws IOException {
		// writing over the initial "definition"
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new SparkActivityDiagram2PnmlResourceBuilder();

		System.out.println("Definition: " + definition);
		System.out.println("Model: " + invocation.getAnalyzableModel());
		System.out.println("Measures: " + definition.getDeclaredMeasures());
		System.out.println("VariableConfig: " + invocation.getVariableConfiguration());
		System.out.println("Assignments: " + invocation.getVariableConfiguration().toPrimitiveAssignments());
		System.out.println("Scenarios: " + definition.getScenarios());
		System.out.println("Creating net of active scenario: " + definition.getActiveScenario());

		ModelResult result = builder.createAnalyzableModel((Element) definition.getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());

		IStatus status = result.getStatus();
		System.out.println("Status of translation was: " + status.getSeverity() + "   " + status.getMessage() );
		saveAnalyzbleModelResult(result, "target/test/resources/output"+UML_FILENAME+".anm" + "." + XMIResource.XMI_NS);
		assertNotEquals("Status of translation was ERROR", IStatus.ERROR, status.getSeverity());
		assertNotNull("The translated model in result was null", result.getModel());
		assertFalse("The result had a list of translated models, but its size was 0", result.getModel().size() == 0);
		assertNotNull("The first element in the list of translated models was null", result.getModel().get(0));

	}

	@Test
	public void testNetIsClosed() {
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new SparkActivityDiagram2PnmlResourceBuilder();

		ModelResult result = builder.createAnalyzableModel((Element) definition.getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());

		PetriNetDoc netresult = (PetriNetDoc) result.getModel().get(0);
		List<PnObject> listPNelements = netresult.getNets().get(0).getPages().get(0).getObjects();

		boolean onePlaceFound=false;
		boolean oneEntered=false;
		for (PnObject pnelement : listPNelements) {

			Place place = null;
			Transition trans = null;
			Arc ar = null;

			/* All places have, at least, one input arc and one output arc */
			if (pnelement instanceof Place) {
				place = (Place) pnelement;
				if (place != null && place.getName() != null) {
    				onePlaceFound=true;
					oneEntered=true;
					assertTrue("The place did not contain at least one input arc", place.getInArcs().size() >= 1);
					assertTrue("The input arc of the place comes from a null element",
							place.getInArcs().get(0).getSource() != null);
					assertTrue("The place did not contain at least one output arc", place.getOutArcs().size() >= 1);
					for (Arc arc : place.getOutArcs()) {
						assertTrue("The arc id " + arc.getId() + " originated in the place goes to a null element",
								arc.getTarget() != null);
					}
				}
			}
			/* All transition have, at least, one input arc and one output arc */
			else if (pnelement instanceof Transition){
				trans = (Transition) pnelement;
				assertTrue("The transition did not contain at least one input arc", trans.getInArcs().size() >= 1);
				assertTrue("The input arc of the transition comes from a null element",
						trans.getInArcs().get(0).getSource() != null);
				assertTrue("The transition did not contain at least one output arc", trans.getOutArcs().size() >= 1);
				for (Arc arc : trans.getOutArcs()) {
					assertTrue("The arc id " + arc.getId() + " originated in the transition goes to a null element",
							arc.getTarget() != null);
				}
			}
			/* All arcs have one source (place/transition) and one target (place/transition) */
			else if (pnelement instanceof Arc){
				ar = (Arc) pnelement;
				assertTrue("The arc did not have a source", ar.getSource() != null);
				assertTrue("The arc did not have a target", ar.getTarget() != null);
			}
		}
		assertTrue("The was not found any place among the PN elements", onePlaceFound);
		assertTrue("The place with the requested characteristics was not found in any of the iterations along the PN elements", oneEntered);

	}

	@Test
	@Category(IntegrationTest.class)
	public void testResults()
			throws SimulationException, CoreException, InterruptedException, IOException {

		definition = invocation.getDefinition();

		IAnalyzableModelBuilder builder = new SparkActivityDiagram2PnmlResourceBuilder();

		System.out.println("Creating net of active scenario: " + definition.getActiveScenario());
		ModelResult result = builder.createAnalyzableModel((Element) definition.getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());
		invocation.getAnalyzableModel().addAll(result.getModel());
		invocation.setTraceSet(result.getTraceSet());
		saveAnalyzbleModelResult(result, RELATIVE_PATH + INVOCATION_FILENAME + ".anm" + "." + XMIResource.XMI_NS);

		DomainMeasure respt = launchAnalysis(definition);
		assertTrue("The response time measure is null ", respt != null);
		assertTrue("The value of the response time measure is null", respt.getValue() != null);
		assertTrue("The responseTime is NOT higher than 0. Concretely " + respt.getValue().doubleValue(),
		respt.getValue().doubleValue() > 0.0);
		assertTrue("The responseTime is NOT between 0.5 and 2 s. Concretely " + respt.getValue().doubleValue(),
		(respt.getValue().doubleValue() > 0.5) && (respt.getValue().doubleValue() < 2.0));
	}

	
	private DomainMeasure launchAnalysis(SimulationDefinition definition)
			throws SimulationException, CoreException, InterruptedException, IOException {

		SimulationInvocation invocation = definition.getInvocations().get(0);

		//invocation.setAutoBuild(true);
		invocation.setStatus(SimulationStatus.WAITING);

		try {
			final ISimulator simulator = SimulatorsManager.INSTANCE.getSimulator(definition.getBackend());

			if (simulator == null) {
				throw new SimulationException(
						MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulatorNotFoundError,
								definition.getBackend()));
			}
			invocation.setStatus(SimulationStatus.RUNNING);

			//invocation.getAnalyzableModel().remove(0);

			// @formatter:off
			Process simulationProcess = simulator.simulate(invocation.getIdentifier(), invocation.getAnalyzableModel(),
					invocation.getTraceSet(), definition.getParameters().map(), new NullProgressMonitor());
			// @formatter:on

			System.out.println("Performance test. Simulate call executed, now entering in the waitFor");

			readOutputsThreads(simulationProcess);
			simulationProcess.waitFor();
			System.out.println("Wait for passed!");
			if (simulator.getToolResult() != null) {
				invocation.setToolResult(simulator.getToolResult());
				return calculateResults(invocation, "RespT");
			}
		} finally {

		}
		return null;
	}

	private void readOutputsThreads(Process simulationProcess) {
		Thread errorThread = new Thread() {

			@Override
			public void run() {
				try {
					InputStreamReader isr = new InputStreamReader(simulationProcess.getErrorStream());
					BufferedReader br = new BufferedReader(isr);
					String line = null;

					while ((line = br.readLine()) != null)
						System.out.println(line);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}

		};

		errorThread.start();
		Thread stdoutThread = new Thread() {
			@Override
			public void run() {
				try {
					InputStreamReader isr = new InputStreamReader(simulationProcess.getInputStream());
					BufferedReader br = new BufferedReader(isr);
					String line = null;
					String previousLine = null;
					while ((line = br.readLine()) != null) {
						previousLine = line;// do nothing
											// System.out.println(line);
					}
					System.out.println("LastLine of simulation: " + previousLine);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		};

		stdoutThread.start();

	}

	private DomainMeasure calculateResults(SimulationInvocation invocation, String chosenMeasure) {

		invocation.setResult(SimresultFactory.eINSTANCE.createSimulationResult());
		ActivityResponseTimeCalculatorSpark calculator = new ActivityResponseTimeCalculatorSpark();
		DomainMeasureDefinition measureDefinition = invocation.getDefinition().getMeasuresToCompute().get(0);
		for (int i = 0; i < invocation.getDefinition().getMeasuresToCompute().size(); i++) {
			DomainMeasureDefinition measureDefinitioni = invocation.getDefinition().getMeasuresToCompute().get(i);
			System.out.println("Measure definition: " + i + "  " + measureDefinitioni.getMeasure() + " to string:"
					+ measureDefinitioni.toString() + " its measured element: "
					+ measureDefinition.getMeasuredElement().toString());
			System.out.println("Trying to cast to Element and to print the getClass and the toString: "
					+ ((Element) measureDefinition.getMeasuredElement()).getClass() + "     To String      "
					+ ((Element) measureDefinition.getMeasuredElement()).toString());
			
			if(measureDefinitioni.getMeasure().equalsIgnoreCase(chosenMeasure)){
				measureDefinition = measureDefinitioni;
			}

		}
		assertTrue(chosenMeasure + " was not found on the measures to compute" + 
					invocation.getDefinition().
					getMeasuresToCompute().
					stream().
					map(i -> i.getMeasure()).
					collect(Collectors.toList()).toString(),
					measureDefinition.getMeasure().equalsIgnoreCase(chosenMeasure));

		assertTrue("Measures to compute contains something different from three elements",
				invocation.getDefinition().getMeasuresToCompute().size() == 3);

		EObject measuredElement = measureDefinition.getMeasuredElement();

		// Look for the first calculator that is able to handle
		// the measure for the given scenario type

		return calculator.calculate(measuredElement, measureDefinition, invocation.getToolResult(),
				invocation.getTraceSet());

	}

}