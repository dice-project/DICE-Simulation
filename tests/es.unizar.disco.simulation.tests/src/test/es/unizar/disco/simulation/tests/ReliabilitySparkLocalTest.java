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
import static org.junit.Assert.assertEquals;

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
import org.eclipse.uml2.uml.Model;
import org.junit.Before;
import org.junit.Test;

import com.masdes.dam.Complex_Data_Types.DaFailure;
import com.masdes.dam.Complex_Data_Types.DaRepair;


import es.unizar.disco.pnml.m2m.builder.SparkScenario2PnmlReliabilityResourceBuilder;
import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.launcher.Messages;
import es.unizar.disco.simulation.local.calculators.AvailabilityCalculatorSpark;
import es.unizar.disco.simulation.local.calculators.ReliabilityCalculatorSpark;
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
import fr.lip6.move.pnml.ptnet.PetriNet;
import fr.lip6.move.pnml.ptnet.PetriNetDoc;
import fr.lip6.move.pnml.ptnet.PnObject;
import fr.lip6.move.pnml.ptnet.Transition;
import fr.lip6.move.pnml.ptnet.Place;

public class ReliabilitySparkLocalTest extends AbstractTest {

	final static String DEFINITION_FILENAME = "c3d6d6a1-6531-43c1-8fa3-f8c3ee0151ab";
	final static String INVOCATION_FILENAME = "86f60c62-46c3-4bdc-940b-408535b5e26b";

	final static String RELATIVE_PATH = "reliabilitySpark/";
	
	final static String UML_FILENAME = "SparkReliability";


	private final String RELIABILITY = "reliability";
	private final String SSAVAIL = "ssAvail";
	
	@Before
	public void loadParticularModels() throws IOException {
		loadModels(RELATIVE_PATH + DEFINITION_FILENAME, RELATIVE_PATH + INVOCATION_FILENAME);

	}

	@Test
	public void testLoadProfiledModel() throws IOException {

		Model model = loadUMLModel(RELATIVE_PATH + UML_FILENAME);
		
	
		assertTrue("The " + UML_FILENAME + " model does not contain zookeeper stereotype", contains(model.getPackagedElements(),"SparkNode"));
		Element computNode = getStereotypedElement(model.getPackagedElements(),"SparkNode");
		assertTrue("The HadoopComputationNode stereotype does not contatin  information about blackout ",
				(((List<DaFailure>)computNode.getValue(computNode.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Spark::SparkNode"), "failure")).get(0).getMTTF().get(0)!=null));
		assertTrue("The HadoopComputationNode stereotype does not contatin  informationabout blackout recovering", 
				(((List<DaRepair>)computNode.getValue(computNode.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Spark::SparkNode"), "repair")).get(0).getMTTR().get(0)!=null));
	}
	

	@Test
	public void testCreationNet() throws IOException {
		// writing over the initial "definition"
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new SparkScenario2PnmlReliabilityResourceBuilder();

		System.out.println("Creating net of active scenario: " + invocation.getDefinition().getActiveScenario());
		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());

		IStatus status = result.getStatus();
		System.out.println("STatus of translation was: " + status.getSeverity() + "   " + status.getMessage() );
		assertNotEquals("Status of translation was ERROR with message " + status.getMessage(), IStatus.ERROR, status.getSeverity());
		assertNotNull("The translated model in result was null", result.getModel());
		assertFalse("The result had a list of translated models, but its size was 0", result.getModel().size() == 0);
		assertNotNull("The first element in the list of translated models was null", result.getModel().get(0));
		assertTrue("The generated net did not contain the expected structure information", resultIsMeaningful(result));

		
	}

	


	@Test
	public void testResults()
			throws SimulationException, CoreException, InterruptedException, IOException {

		//FOR Reliability: There are 3 resources with MTTF each of 1.5h. It is calculated the reliability of the system at T=4h. 
		//The result should be a Reliability of 0.193. Accepted between 0.18 and 0.195
		//FOR AVAILABILITY: 2h average time to fail. 360s to repair. It can accept jobs 95.23% . We accept between 95% and 96%
		
		//Compute results:
		
		SimulationDefinition fullExecutionDefinition = definition;
		IAnalyzableModelBuilder builder = new SparkScenario2PnmlReliabilityResourceBuilder();

		System.out.println("Creating net of active scenario: " + invocation.getDefinition().getActiveScenario());
		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());
		
		invocation.getAnalyzableModel().set(0, result.getModel().get(0));
		invocation.setTraceSet(result.getTraceSet());
		
		DomainMeasure[] measures = launchAnalysis(fullExecutionDefinition);
		DomainMeasure reliability= measures[0];
		
		assertTrue("The reliability is null", reliability!=null);
		assertTrue("The relaibility is below 0.18 with value " + reliability.getValue().doubleValue(), reliability.getValue().doubleValue()>0.18);
		assertTrue("The reliability is above 0.195 with value " + reliability.getValue().doubleValue(), reliability.getValue().doubleValue()<0.195);
		
		DomainMeasure availability =measures[1];
		assertTrue("The availability is null", availability!=null);
		assertTrue("The availability is below 95% with value" + availability.getValue().doubleValue(), availability.getValue().doubleValue()>95);
		assertTrue("The availability is above 96% with value" + availability.getValue().doubleValue(), availability.getValue().doubleValue()<96);

	}


	
	
	private DomainMeasure[] launchAnalysis(SimulationDefinition definition)
			throws SimulationException, CoreException, InterruptedException, IOException {

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
				return new DomainMeasure[] {calculateResultsReliability(invocation), calculateResultsAvailability(invocation)};
				
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

	private boolean resultIsMeaningful(ModelResult result) {


		PetriNetDoc producedAnalyzableModel = (PetriNetDoc)  result.getModel().get(0);
		System.out.println("produced model= " + producedAnalyzableModel.toString());
		PetriNet pn = producedAnalyzableModel.getNets().get(0);
		List<PnObject> pnobjects = pn.getPages().get(0).getObjects();
		//There should be 
		
		//4 places and 4 transitions
		int numplaces = pnobjects.stream()
		.filter(n -> n instanceof Place) 
		.map(n -> (Place) n)
		.collect(Collectors.toList())
		.size();
		assertEquals("Number of places found was " + numplaces, 4,  numplaces);
		
		int numtransitions = pnobjects.stream()
				.filter(n -> n instanceof Transition) 
				.map(n -> (Transition) n)
				.collect(Collectors.toList())
				.size();
		assertEquals("Number of transitions found was " + numtransitions, 4,  numtransitions);
		
		
		//one of the places should contain as many tokens as resource multiplicity
				//TODO
		//one of the places should contain one token
				//TODO
		//two of the places shouldn't contain any token
				//TODO
		//one of the transitions should be timed with rate the inverse of the MTTF
				//TODO
		return true;
	}

	private DomainMeasure calculateResultsReliability(SimulationInvocation invocation) {

		invocation.setResult(SimresultFactory.eINSTANCE.createSimulationResult());
		ReliabilityCalculatorSpark calculator = new ReliabilityCalculatorSpark();
		DomainMeasureDefinition measureDefinition = invocation.getDefinition().getMeasuresToCompute().get(0);
		for (int i = 0; i < invocation.getDefinition().getMeasuresToCompute().size(); i++) {
			DomainMeasureDefinition measureDefinitioni = invocation.getDefinition().getMeasuresToCompute().get(i);
			System.out.println("Measure definition: " + i + "  " + measureDefinitioni.getMeasure() + " to string:"
					+ measureDefinitioni.toString() + " its measured element: "
					+ measureDefinition.getMeasuredElement().toString());
			System.out.println("Trying to cast to Element and to print the getClass and the toString: "
					+ ((Element) measureDefinition.getMeasuredElement()).getClass() + "     To String      "
					+ ((Element) measureDefinition.getMeasuredElement()).toString());
			
			if(RELIABILITY.equalsIgnoreCase(measureDefinitioni.getMeasure())){
				measureDefinition = measureDefinitioni;
			}
			

		}
		assertTrue("Measures to compute contains something different from two elements",
				invocation.getDefinition().getMeasuresToCompute().size() == 2);

		EObject measuredElement = measureDefinition.getMeasuredElement();

		// Look for the first calculator that is able to handle
		// the measure for the given scenario type

		DomainMeasure mttf = calculator.calculate(measuredElement, measureDefinition, invocation.getToolResult(),
				invocation.getTraceSet());

		return mttf;

		
	}
	

	private DomainMeasure calculateResultsAvailability(SimulationInvocation invocation) {
		invocation.setResult(SimresultFactory.eINSTANCE.createSimulationResult());
		AvailabilityCalculatorSpark calculator = new AvailabilityCalculatorSpark();
		DomainMeasureDefinition measureDefinition = invocation.getDefinition().getMeasuresToCompute().get(0);
		for (int i = 0; i < invocation.getDefinition().getMeasuresToCompute().size(); i++) {
			DomainMeasureDefinition measureDefinitioni = invocation.getDefinition().getMeasuresToCompute().get(i);
			System.out.println("Measure definition: " + i + "  " + measureDefinitioni.getMeasure() + " to string:"
					+ measureDefinitioni.toString() + " its measured element: "
					+ measureDefinition.getMeasuredElement().toString());
			System.out.println("Trying to cast to Element and to print the getClass and the toString: "
					+ ((Element) measureDefinition.getMeasuredElement()).getClass() + "     To String      "
					+ ((Element) measureDefinition.getMeasuredElement()).toString());
			
			if(SSAVAIL.equalsIgnoreCase(measureDefinitioni.getMeasure())){
				measureDefinition = measureDefinitioni;
			}
			

		}
		assertTrue("Measures to compute contains something different from two elements",
				invocation.getDefinition().getMeasuresToCompute().size() == 2);

		EObject measuredElement = measureDefinition.getMeasuredElement();

		// Look for the first calculator that is able to handle
		// the measure for the given scenario type

		DomainMeasure availability = calculator.calculate(measuredElement, measureDefinition, invocation.getToolResult(),
				invocation.getTraceSet());

		return availability;
	}

}