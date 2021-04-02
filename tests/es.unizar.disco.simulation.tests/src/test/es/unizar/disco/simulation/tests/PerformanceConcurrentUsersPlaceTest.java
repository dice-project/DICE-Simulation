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
import org.eclipse.uml2.uml.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.unizar.disco.pnml.m2m.builder.ActivityDiagram2PnmlResourceBuilder;
import es.unizar.disco.pnml.m2m.utils.ConstantUtils;
import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.greatspn.ssh.calculators.ActivityResponseTimeCalculator;
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
import fr.lip6.move.pnml.ptnet.Place;
import fr.lip6.move.pnml.ptnet.PnObject;

public class PerformanceConcurrentUsersPlaceTest extends AbstractTest {

	final static String DEFINITION_FILENAME = "15777ece-6c9b-46a3-89c5-a23c2edd99ab";
	final static String INVOCATION_FILENAME = "fbd9fa21-dff8-448d-897a-7e51e07dc5f9";

	final static String RELATIVE_PATH = "performanceDpim/";
	
	final static String UML_FILENAME = "modelPoseidoniaReliab";
	
	@Before
	public void loadParticularModels() throws IOException {
		loadModels(RELATIVE_PATH + DEFINITION_FILENAME, RELATIVE_PATH + INVOCATION_FILENAME);

	}

	@Test
	public void testCreationNet() throws IOException {

		// writing over the initial "definition"
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new ActivityDiagram2PnmlResourceBuilder();

		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());

		IStatus status = result.getStatus();
		assertNotEquals("Status of translation was ERROR", IStatus.ERROR, status.getSeverity());
		assertNotNull("The translated model in result was null", result.getModel());
		assertFalse("The result had a list of translated models, but its size was 0", result.getModel().size() == 0);
		assertNotNull("The first element in the list of translated models was null", result.getModel().get(0));

		/*saveAnalyzbleModelResult(result,
				"target/test/resources/outputModelPoseidoniaResources.anm" + "." + XMIResource.XMI_NS);*/
	}

	@Test
	public void testNetIsClosedByConcurrentUsersPlace() {
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new ActivityDiagram2PnmlResourceBuilder();

		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());

		PetriNetDoc netresult = (PetriNetDoc) result.getModel().get(0);
		List<PnObject> listPNelements = netresult.getNets().get(0).getPages().get(0).getObjects();
		
		boolean onePlaceFound=false;
		boolean oneEntered=false;
		for (PnObject pnelement : listPNelements) {

			Place place = null;
			try {
				place = (Place) pnelement;
			} catch (ClassCastException e) {// nothing to do, it was not a
											// place
			}
			if (place != null && place.getName() != null) {
				onePlaceFound=true;
				if (place.getName().getText().equalsIgnoreCase(ConstantUtils.getUsers())) {
					oneEntered=true;
					assertTrue("The place did not contain exactly one input arc", place.getInArcs().size() == 1);
					assertTrue("The input arc of the place comes from a null element",
							place.getInArcs().get(0).getSource() != null);
					assertTrue("The place did not contain at least one output arc", place.getOutArcs().size() >= 1);
					for (Arc arc : place.getOutArcs()) {
						assertTrue("The arc id " + arc.getId() + " originated in the place goes to a null element",
								arc.getTarget() != null);
					}
				}

			}

		}
		
		assertTrue("The was not found any place among the PN elements", onePlaceFound);
		assertTrue("The place with the requested characteristics was not found in any of the iterations along the PN elements", oneEntered);

	}

	@Test
	@Category(IntegrationTest.class)
	public void testRespTimeResultIsCalculated()
			throws SimulationException, CoreException, InterruptedException, IOException {

		definition = invocation.getDefinition();

		IAnalyzableModelBuilder builder = new ActivityDiagram2PnmlResourceBuilder();

		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());
		// invocation.getAnalyzableModel().addAll(result.getModel());
		invocation.setTraceSet(result.getTraceSet());

		DomainMeasure respt = launchAnalysis(definition);
		assertTrue("The response time measure is null ", respt != null);
		assertTrue("The value of the response time measure is null", respt.getValue() != null);
		assertTrue("The responseTime is NOT higher than 0. Concretely " + respt.getValue().doubleValue(),
				respt.getValue().doubleValue() > 0.0);

	}

	// when we need to compare analysis results
	private DomainMeasure launchAnalysis(SimulationDefinition definition)
			throws SimulationException, CoreException, InterruptedException, IOException {

		invocation.setAutoBuild(true);
		invocation.setStatus(SimulationStatus.WAITING);

		SimulationInvocation invocation = definition.getInvocations().get(0);

		try {
			final ISimulator simulator = SimulatorsManager.INSTANCE.getSimulator(definition.getBackend());

			if (simulator == null) {
				throw new SimulationException(
						MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulatorNotFoundError,
								definition.getBackend()));
			}
			invocation.setStatus(SimulationStatus.RUNNING);

			// @formatter:off
			Process simulationProcess = simulator.simulate(invocation.getIdentifier(), invocation.getAnalyzableModel(),
					invocation.getTraceSet(), definition.getParameters().map(), new NullProgressMonitor());
			// @formatter:on

			System.out.println("Reliability test. Simulate call executed, now entering in the waitFor");

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
		ActivityResponseTimeCalculator calculator = new ActivityResponseTimeCalculator();
		DomainMeasureDefinition measureDefinition = invocation.getDefinition().getMeasuresToCompute().get(0);
		
		for (int i = 0; i < invocation.getDefinition().getMeasuresToCompute().size(); i++) {
			DomainMeasureDefinition measureDefinitioni = invocation.getDefinition().getMeasuresToCompute().get(i);
			/* System.out.println("Measure definition: " + i + "  " + measureDefinitioni.getMeasure() + " to string:"
					+ measureDefinitioni.toString() + " its measured element: ");
			System.out.println("Trying to cast to Element and to print the getClass: "
					+ ((Element) measureDefinition.getMeasuredElement()).getClass()); */
			if(measureDefinitioni.getMeasure().equalsIgnoreCase(chosenMeasure)){
				measureDefinition=measureDefinitioni;
			}
			
		}
		assertTrue(
				chosenMeasure + " was not found on the measures to compute" + invocation.getDefinition().getMeasuresToCompute()
						.stream().map(i -> i.getMeasure()).collect(Collectors.toList()).toString(),
				measureDefinition.getMeasure().equalsIgnoreCase(chosenMeasure));

		EObject measuredElement = measureDefinition.getMeasuredElement();

		// Look for the first calculator that is able to handle
		// the measure for the given scenario type

		return calculator.calculate(measuredElement, measureDefinition, invocation.getToolResult(),
				invocation.getTraceSet());

	}

}