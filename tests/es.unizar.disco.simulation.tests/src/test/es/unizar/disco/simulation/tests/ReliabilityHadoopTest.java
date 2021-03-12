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
import org.junit.experimental.categories.Category;

import com.masdes.dam.Complex_Data_Types.DaFailure;
import com.masdes.dam.Complex_Data_Types.DaRepair;

import es.unizar.disco.pnml.m2m.builder.HadoopScenario2PnmlReliabilityResourceBuilder;
import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.greatspn.ssh.calculators.AvailabilityCalculatorHadoop;
import es.unizar.disco.simulation.greatspn.ssh.calculators.ReliabilityMTTFCalculatorHadoop;
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
import fr.lip6.move.pnml.ptnet.PetriNet;
import fr.lip6.move.pnml.ptnet.PetriNetDoc;
import fr.lip6.move.pnml.ptnet.PnObject;
import fr.lip6.move.pnml.ptnet.Transition;
import fr.lip6.move.pnml.ptnet.Place;

public class ReliabilityHadoopTest extends AbstractTest {

	final static String DEFINITION_FILENAME = "f388179a-3dfc-4567-a002-f786fd9bd813";
	final static String INVOCATION_FILENAME = "9261cd96-6ea6-4e44-b003-253fe8d4cbb7";
	
	final static String RELATIVE_PATH = "reliabilityHadoop/";
	
	final static String UML_FILENAME = "reliabilityHadoop";


	private final String FAILURE = "failure";
	private final String SSAVAIL = "ssAvail";
	
	@Before
	public void loadParticularModels() throws IOException {
		loadModels(RELATIVE_PATH + DEFINITION_FILENAME, RELATIVE_PATH + INVOCATION_FILENAME);

	}

	@Test
	public void testLoadProfiledModel() throws IOException {

		Model model = loadUMLModel(RELATIVE_PATH + UML_FILENAME);
		
	
		assertTrue("The " + UML_FILENAME + " model does not contain zookeeper stereotype", contains(model.getPackagedElements(),"HadoopComputationNode"));
		Element computNode = getStereotypedElement(model.getPackagedElements(),"HadoopComputationNode");
		assertTrue("The HadoopComputationNode stereotype does not contatin  information about blackout ",
				(((List<DaFailure>)computNode.getValue(computNode.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopComputationNode"), "failure")).get(0).getMTTF().get(0)!=null));
		assertTrue("The HadoopComputationNode stereotype does not contatin  informationabout blackout recovering", 
				(((List<DaRepair>)computNode.getValue(computNode.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Hadoop::HadoopComputationNode"), "repair")).get(0).getMTTR().get(0)!=null));
	}
	

	@Test
	public void testCreationNet() throws IOException {
		// writing over the initial "definition"
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new HadoopScenario2PnmlReliabilityResourceBuilder();

		System.out.println("Creating net of active scenario: " + invocation.getDefinition().getActiveScenario());
		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());

		IStatus status = result.getStatus();
		System.out.println("STatus of translation was: " + status.getSeverity() + "   " + status.getMessage() );
		saveAnalyzbleModelResult(result, "target/test/resources/output"+UML_FILENAME+".anm" + "." + XMIResource.XMI_NS);
		assertNotEquals("Status of translation was ERROR with message " + status.getMessage(), IStatus.ERROR, status.getSeverity());
		assertNotNull("The translated model in result was null", result.getModel());
		assertFalse("The result had a list of translated models, but its size was 0", result.getModel().size() == 0);
		assertNotNull("The first element in the list of translated models was null", result.getModel().get(0));
		assertTrue("The generated net did not contain the expected structure information", resultIsMeaningful(result));

		
	}

	


	@Test
	@Category(IntegrationTest.class)
	public void testResults()
			throws SimulationException, CoreException, InterruptedException, IOException {

		//FOR MTTF: There are 2 resources with MTTF each of 1h. The result should be a MTTF of around 1.5h . Accepted between 1.2 and 1.8h
		//FOR AVAILABILITY: 2h time to be expulsed. 180s to repair. 97.5% . We accept between 95% and 99%
		
		//Compute results:
		
		SimulationDefinition fullExecutionDefinition = definition;
		IAnalyzableModelBuilder builder = new HadoopScenario2PnmlReliabilityResourceBuilder();

		System.out.println("Creating net of active scenario: " + invocation.getDefinition().getActiveScenario());
		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());
		
		invocation.getAnalyzableModel().set(0, result.getModel().get(0));
		invocation.setTraceSet(result.getTraceSet());
		
		DomainMeasure[] measures = launchAnalysis(fullExecutionDefinition);
		DomainMeasure mttf= measures[0];
		
		assertTrue("The MTTF is null", mttf!=null);
		assertTrue("The MTTF is below 1.2h with value " + mttf.getValue().doubleValue(), mttf.getValue().doubleValue()>(1.2*3600.0));
		assertTrue("The MTTF is above 1.8h with value " + mttf.getValue().doubleValue(), mttf.getValue().doubleValue()<(1.8*3600));
		
		DomainMeasure availability =measures[1];
		assertTrue("The availability is null", availability!=null);
		assertTrue("The availability is below 95% with value" + availability.getValue().doubleValue(), availability.getValue().doubleValue()>95);
		assertTrue("The availability is above 99% with value" + availability.getValue().doubleValue(), availability.getValue().doubleValue()<99);

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
				return new DomainMeasure[] {calculateResultsMTTF(invocation), calculateResultsAvailability(invocation)};
				
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

	private DomainMeasure calculateResultsMTTF(SimulationInvocation invocation) {

		invocation.setResult(SimresultFactory.eINSTANCE.createSimulationResult());
		ReliabilityMTTFCalculatorHadoop calculator = new ReliabilityMTTFCalculatorHadoop();
		DomainMeasureDefinition measureDefinition = invocation.getDefinition().getMeasuresToCompute().get(0);
		for (int i = 0; i < invocation.getDefinition().getMeasuresToCompute().size(); i++) {
			DomainMeasureDefinition measureDefinitioni = invocation.getDefinition().getMeasuresToCompute().get(i);
			System.out.println("Measure definition: " + i + "  " + measureDefinitioni.getMeasure() + " to string:"
					+ measureDefinitioni.toString() + " its measured element: "
					+ measureDefinition.getMeasuredElement().toString());
			System.out.println("Trying to cast to Element and to print the getClass and the toString: "
					+ ((Element) measureDefinition.getMeasuredElement()).getClass() + "     To String      "
					+ ((Element) measureDefinition.getMeasuredElement()).toString());
			
			if(FAILURE.equalsIgnoreCase(measureDefinitioni.getMeasure())){
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
		AvailabilityCalculatorHadoop calculator = new AvailabilityCalculatorHadoop();
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