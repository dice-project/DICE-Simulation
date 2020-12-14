
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

import es.unizar.disco.pnml.m2m.builder.StormScenario2PnmlReliabilityResourceBuilder;
import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.greatspn.ssh.calculators.ReliabilityMTTFCalculatorStorm;
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

public class ReliabilityStormTest extends AbstractTest {

	final static String DEFINITION_FILENAME = "165d07a2-a8a0-4359-83c6-822b40f479cc";
	final static String INVOCATION_FILENAME = "6a008097-ebcb-42bf-99ca-05ecd190c14b";

	final static String UML_FILENAME = "wikistatsStorm";

	@Before
	public void loadParticularModels() throws IOException {
		loadModels(DEFINITION_FILENAME, INVOCATION_FILENAME);

	}

	@Test
	public void testLoadProfiledModel() throws IOException {

		Model model = loadUMLModel(UML_FILENAME);
		int sessionTimeout = 30000;
		
	
		assertTrue("The " + UML_FILENAME + " model does not contain zookeeper stereotype", contains(model.getPackagedElements(),"StormZookeeper"));
		Element zookeeperElement = getStereotypedElement(model.getPackagedElements(),"StormZookeeper");
//				model.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Storm::StormZookeeper") != null);
		assertTrue("The StormZookeeper stereotype does not contatin contain session timeout of " + sessionTimeout,
				((Integer) zookeeperElement.getValue(zookeeperElement.getAppliedStereotype("DICE::DICE_UML_Extensions::DTSM::Storm::StormZookeeper"), "sessionTimeout")).intValue()==sessionTimeout);
	}
	
	
	@Test
	public void testCreationNet() throws IOException {
		// writing over the initial "definition"
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new StormScenario2PnmlReliabilityResourceBuilder();

		System.out.println("Creating net of active scenario: " + invocation.getDefinition().getActiveScenario());
		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());


		IStatus status = result.getStatus();
		assertNotEquals("Status of translation was ERROR", IStatus.ERROR, status.getSeverity());
		assertNotNull("The translated model in result was null", result.getModel());
		assertFalse("The result had a list of translated models, but its size was 0", result.getModel().size() == 0);
		assertNotNull("The first element in the list of translated models was null", result.getModel().get(0));
		assertTrue("The generated net did not contain the expected information", resultIsMeaningful(result));

		saveAnalyzbleModelResult(result, "target/test/resources/output"+UML_FILENAME+".anm" + "." + XMIResource.XMI_NS);
	}

	


	@Test
	@Category(IntegrationTest.class)
	public void testResults()
			throws SimulationException, CoreException, InterruptedException, IOException {

		//There are 3 resources with MTTF each of 10h. The result should be a MTTF of around 18.33h . Accepted between 18 and 18.5h
		
		//Compute results:
		
		SimulationDefinition fullExecutionDefinition = definition;
		IAnalyzableModelBuilder builder = new StormScenario2PnmlReliabilityResourceBuilder();

		System.out.println("Creating net of active scenario: " + invocation.getDefinition().getActiveScenario());
		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());
		
		invocation.getAnalyzableModel().set(0, result.getModel().get(0));
		invocation.setTraceSet(result.getTraceSet());
		
		DomainMeasure mttf = launchAnalysis(fullExecutionDefinition);
		assertTrue("The MTTF is null", mttf!=null);
		assertTrue("The MTTF is below 18h with value " + mttf.getValue().doubleValue(), mttf.getValue().doubleValue()>(18.0));
		assertTrue("The MTTF is above 18.5h with value " + mttf.getValue().doubleValue(), mttf.getValue().doubleValue()<(18.5));

	}


	private DomainMeasure launchAnalysis(SimulationDefinition definition)
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
			/*
			 * IProcess runtimeProcess = DebugPlugin.newProcess(launch,
			 * simulationProcess, MessageFormat.format(Messages.
			 * SimulationLaunchConfigurationDelegate_simulationName,
			 * invocation.getIdentifier()), null);
			 * runtimeProcess.setAttribute(DebugPlugin.ATTR_LAUNCH_TIMESTAMP,
			 * Calendar.getInstance().getTime().toString());
			 * runtimeProcess.setAttribute(DebugPlugin.ATTR_ENVIRONMENT,
			 * definition.getParameters().toString());
			 */
			// readOutputs(simulationProcess);
			readOutputsThreads(simulationProcess);
			simulationProcess.waitFor();
			System.out.println("Wait for passed!");
			if (simulator.getToolResult() != null) {
				invocation.setToolResult(simulator.getToolResult());
				return calculateResults(invocation);
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

		// final URI anmURI = URI
		// .createFileURI(Paths.get("src/test/resources/" + TEST_FILES_UUID +
		// ".anm" + "." + XMIResource.XMI_NS)
		// .toFile().getAbsolutePath());
		PetriNetDoc producedAnalyzableModel = (PetriNetDoc)  result.getModel().get(0);
		System.out.println("produced model= " + producedAnalyzableModel.toString());
		PetriNet pn = producedAnalyzableModel.getNets().get(0);
		List<PnObject> pnobjects = pn.getPages().get(0).getObjects();
		//There should be 
		
		//2 places and 2 transitions
		int numplaces = pnobjects.stream()
		.filter(n -> n instanceof Place) 
		.map(n -> (Place) n)
		.collect(Collectors.toList())
		.size();
		assertEquals("Number of places found was " + numplaces, 2,  numplaces);
		
		int numtransitions = pnobjects.stream()
				.filter(n -> n instanceof Transition) 
				.map(n -> (Transition) n)
				.collect(Collectors.toList())
				.size();
				assertEquals("Number of transitions found was " + numtransitions, 2,  numtransitions);
		
		//one of the places should contain as many tokens as resource multiplicity
				//TODO
		//one of the transitions should be timed with rate the inverse of the MTTF
				//TODO
		return true;
	}

	private DomainMeasure calculateResults(SimulationInvocation invocation) {

		invocation.setResult(SimresultFactory.eINSTANCE.createSimulationResult());
		ReliabilityMTTFCalculatorStorm calculator = new ReliabilityMTTFCalculatorStorm();
		DomainMeasureDefinition measureDefinition = invocation.getDefinition().getMeasuresToCompute().get(0);
		for (int i = 0; i < invocation.getDefinition().getMeasuresToCompute().size(); i++) {
			DomainMeasureDefinition measureDefinitioni = invocation.getDefinition().getMeasuresToCompute().get(i);
			System.out.println("Measure definition: " + i + "  " + measureDefinitioni.getMeasure() + " to string:"
					+ measureDefinitioni.toString() + " its measured element: "
					+ measureDefinition.getMeasuredElement().toString());
			System.out.println("Trying to cast to Element and to print the getClass and the toString: "
					+ ((Element) measureDefinition.getMeasuredElement()).getClass() + "     To String      "
					+ ((Element) measureDefinition.getMeasuredElement()).toString());

		}
		assertTrue("Measures to compute contains more than one element",
				invocation.getDefinition().getMeasuresToCompute().size() == 1);

		EObject measuredElement = measureDefinition.getMeasuredElement();

		// Look for the first calculator that is able to handle
		// the measure for the given scenario type

		DomainMeasure mttf = calculator.calculate(measuredElement, measureDefinition, invocation.getToolResult(),
				invocation.getTraceSet());

		return mttf;

		/*
		 * MultiStatus status = new MultiStatus(DiceSimulationPlugin.PLUGIN_ID,
		 * 0, null, null); System.out.println("Test CalculateREsults step1");
		 * invocation.setResult(SimresultFactory.eINSTANCE.
		 * createSimulationResult());
		 * System.out.println("Test CalculateREsults step2"); for
		 * (DomainMeasureDefinition measureDefinition :
		 * invocation.getDefinition().getMeasuresToCompute()) { EObject
		 * measuredElement = measureDefinition.getMeasuredElement();
		 * System.out.println("Test CalculateREsults step3");
		 * 
		 * // Look for the first calculator that is able to handle // the
		 * measure for the given scenario type MeasureCalculator calculator =
		 * null; for (String scenarioName :
		 * invocation.getDefinition().getScenarioStereotypes()) {
		 * System.out.println("Test CalculateREsults step4"); calculator =
		 * DiceMetricsUtils.getCalculator((Element) measuredElement,
		 * measureDefinition.getMeasure(), scenarioName,
		 * invocation.getToolResult().getClass());
		 * System.out.println("Test CalculateREsults step5"); if (calculator !=
		 * null) { break; } System.out.println("Test CalculateREsults step6"); }
		 * 
		 * if (calculator == null) { status.merge(new Status(IStatus.ERROR,
		 * DiceSimulationPlugin.PLUGIN_ID, MessageFormat.
		 * format("Unable to find a ''{0}'' calculator for ''{1}'' ",
		 * measureDefinition.getMeasure(), measuredElement))); } else {
		 * System.out.println("Test CalculateREsults step7"); DomainMeasure
		 * domainMeasure = calculator.calculate(measuredElement,
		 * measureDefinition, invocation.getToolResult(),
		 * invocation.getTraceSet());
		 * System.out.println("Test CalculateREsults step8"); if (domainMeasure
		 * == null) { System.out.println("Test CalculateREsults step9");
		 * status.merge(new Status(IStatus.ERROR,
		 * DiceSimulationPlugin.PLUGIN_ID, MessageFormat.
		 * format("Unable to calculate measure ''{0}'' for ''{1}'' ",
		 * measureDefinition.getMeasure(), measuredElement)));
		 * System.out.println("Test CalculateREsults step10"); } else {
		 * System.out.println("Test CalculateREsults step11");
		 * domainMeasure.setDefinition(measureDefinition);
		 * System.out.println("Test CalculateREsults step12");
		 * invocation.getResult().getMeasures().add(domainMeasure);
		 * System.out.println("Test CalculateREsults step13"); }
		 * 
		 * } }
		 * 
		 * return invocation.getResult().getMeasures().get(0);
		 */

	}

}