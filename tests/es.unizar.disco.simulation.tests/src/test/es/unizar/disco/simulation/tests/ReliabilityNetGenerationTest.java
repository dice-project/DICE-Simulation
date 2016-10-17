
package test.es.unizar.disco.simulation.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Element;
import org.junit.Test;

import es.unizar.disco.pnml.m2m.builder.ActivityDiagram2PnmlReliabilityResourceBuilder;
import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.greatspn.ssh.calculators.ScenarioReliabilityCalculator;
import es.unizar.disco.simulation.launcher.Messages;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder.ModelResult;
import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.simresult.SimresultFactory;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulationException;
import fr.lip6.move.pnml.ptnet.PetriNetDoc;
import fr.lip6.move.pnml.ptnet.PnObject;
import fr.lip6.move.pnml.ptnet.Transition;

public class ReliabilityNetGenerationTest extends AbstractTest{

	

	

	@Test
	public void testCreationNet() throws IOException {
		// writing over the initial "definition"
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new ActivityDiagram2PnmlReliabilityResourceBuilder();

		/*
		 * System.out.println("definiton to raw string: " +
		 * invocation.getDefinition().toString());
		 * System.out.println("identifier of definition: " +
		 * invocation.getDefinition().getIdentifier());
		 * System.out.println("string of active scenario: " +
		 * invocation.getDefinition().getActiveScenario().toString() +
		 * " and isEproxy returns " +
		 * invocation.getDefinition().getActiveScenario().eIsProxy() );
		 */
		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());

		IStatus status = result.getStatus();
		assertNotEquals("Status of translation was ERROR", IStatus.ERROR, status.getSeverity());
		assertNotNull("The translated model in result was null", result.getModel());
		assertFalse("The result had a list of translated models, but its size was 0", result.getModel().size() == 0);
		assertNotNull("The first element in the list of translated models was null", result.getModel().get(0));
		assertTrue("The generated net did not contain the expected information", resultIsMeaningful(result));

		saveAnalyzbleModelResult(result);
	}

	@Test
	public void testNotDoublePriorityToolInfo() {
		definition = invocation.getDefinition();
		IAnalyzableModelBuilder builder = new ActivityDiagram2PnmlReliabilityResourceBuilder();

		ModelResult result = builder.createAnalyzableModel((Element) invocation.getDefinition().getActiveScenario(),
				invocation.getVariableConfiguration().toPrimitiveAssignments());

		PetriNetDoc netresult = (PetriNetDoc) result.getModel().get(0);
		List<PnObject> listPNelements = netresult.getNets().get(0).getPages().get(0).getObjects();
		for (PnObject pnelement : listPNelements) {
			Transition transition = null;
			try {
				transition = (Transition) pnelement;
			} catch (ClassCastException e) {// nothig to do, it was not a
											// transittion
			}
			if (transition != null) {
				assertFalse(
						"Found a trasition with more than one toolSpecifics, its name is: " + transition.getName()
								+ " and its string representation is " + transition.toString(),
						transition.getToolspecifics().size() > 1);
			}

		}

	}

	@Test
	public void testSucccesAndFailureProbabilitySumOne()
			throws SimulationException, CoreException, InterruptedException, IOException {

		SimulationDefinition fullExecutionDefinition = (SimulationDefinition) loadResourceFromUri(
				URI.createFileURI(Paths.get("src/test/resources/reliabilityResults/2d8afa5a-618c-465b-8a2a-d4dd2d8789ff"
						+ ".def" + "." + XMIResource.XMI_NS).toFile().getAbsolutePath()));
		DomainMeasure sum = launchAnalysis(fullExecutionDefinition);
		assertTrue("The sum of Reliability and Unreliability is null", sum != null);
		assertTrue("The sum of Reliability and Unreliability is less than 0.95. Concretely: "
				+ sum.getValue().doubleValue(), sum.getValue().doubleValue() > 0.95);
		assertTrue("The sum of Reliability and Unreliability is null. Concretely: " + sum.getValue().doubleValue(),
				sum.getValue().doubleValue() < 1.05);

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
			/*IProcess runtimeProcess = DebugPlugin.newProcess(launch, simulationProcess,
					MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulationName, invocation.getIdentifier()), null);
			runtimeProcess.setAttribute(DebugPlugin.ATTR_LAUNCH_TIMESTAMP, Calendar.getInstance().getTime().toString());
			runtimeProcess.setAttribute(DebugPlugin.ATTR_ENVIRONMENT, definition.getParameters().toString());
*/			
			//readOutputs(simulationProcess);
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
		 Thread errorThread = new Thread(){
			 
			 @Override
			 public void run()
			    {
			        try
			        {
			            InputStreamReader isr = new InputStreamReader(simulationProcess.getErrorStream());
			            BufferedReader br = new BufferedReader(isr);
			            String line=null;
			           
			            while ( (line = br.readLine()) != null)
			              System.out.println(line);    
			            } catch (IOException ioe)
			              {
			                ioe.printStackTrace();  
			              }
			    }
			 
			 
		 };
		 
		 
		 errorThread.start();
		 Thread stdoutThread = new Thread(){
			 @Override
			 public void run()
			    {
			        try
			        {
			            InputStreamReader isr = new InputStreamReader(simulationProcess.getInputStream());
			            BufferedReader br = new BufferedReader(isr);
			            String line=null;
			            String previousLine=null;
			            while ( (line = br.readLine()) != null){
			            	  previousLine=line;// do nothing  System.out.println(line);    
			            }
			            System.out.println("LastLine of simulation: " + previousLine);
			        	} catch (IOException ioe)
			              {
			                ioe.printStackTrace();  
			              }
			    }
		 };
		 
		 
		 
		 stdoutThread.start();

		
	}
	

	private void saveAnalyzbleModelResult(ModelResult result) throws IOException {

		final URI producedAAM_URI = URI
				.createFileURI(Paths.get("target/test/resources/outputPosidonia.anm" + "." + XMIResource.XMI_NS)
						.toFile().getAbsolutePath());

		Resource producedModelResource = getResourceSet().createResource(producedAAM_URI);
		producedModelResource.getContents().add(result.getModel().get(0));
		producedModelResource.save(Collections.EMPTY_MAP);

	}

	private boolean resultIsMeaningful(ModelResult result) {

		// final URI anmURI = URI
		// .createFileURI(Paths.get("src/test/resources/" + TEST_FILES_UUID +
		// ".anm" + "." + XMIResource.XMI_NS)
		// .toFile().getAbsolutePath());
		EObject producedAnalyzableModel = result.getModel().get(0);
		System.out.println("produced model= " + producedAnalyzableModel.toString());
		/*-TraceSet traceSet = TracesFactory.eINSTANCE.createTraceSet();
			for (EObject trace : traces.getContents()) {
				traceSet.getTraces().add((Trace) trace);
			}
				if (status.getSeverity() != IStatus.ERROR) {
				super.getAnalyzableModel().addAll(result.getModel());
				super.setTraceSet(result.getTraceSet());
			}
		*/
		return true;
	}

	private DomainMeasure calculateResults(SimulationInvocation invocation) {

		invocation.setResult(SimresultFactory.eINSTANCE.createSimulationResult());
		ScenarioReliabilityCalculator calculator = new ScenarioReliabilityCalculator();
		DomainMeasureDefinition measureDefinition = invocation.getDefinition().getMeasuresToCompute().get(0);
		for(int i=0; i<invocation.getDefinition().getMeasuresToCompute().size();i++){
			DomainMeasureDefinition measureDefinitioni = invocation.getDefinition().getMeasuresToCompute().get(i);
			System.out.println("Measure definition: " + i + "  " + measureDefinitioni.getMeasure() + 
					" to string:" + measureDefinitioni.toString() + " its measured element: " + measureDefinition.getMeasuredElement().toString());
			System.out.println("Trying to cast to Element and to print the getClass and the toString: " + 
					((Element) measureDefinition.getMeasuredElement()).getClass() + "     To String      " +  
					((Element) measureDefinition.getMeasuredElement()).toString());
			
		}
		assertTrue("Measures to compute contains more than one element", invocation.getDefinition().getMeasuresToCompute().size()==1);

		EObject measuredElement = measureDefinition.getMeasuredElement();

		// Look for the first calculator that is able to handle
		// the measure for the given scenario type

		DomainMeasure reliab = calculator.calculate(measuredElement, measureDefinition, invocation.getToolResult(),
				invocation.getTraceSet());
				
						DomainMeasure unreliab = calculator.calculateUnreliability(measuredElement, measureDefinition,
				invocation.getToolResult(), invocation.getTraceSet());
		DomainMeasure sum = MeasuresFactory.eINSTANCE.createDomainMeasure();
		sum.setValue(reliab.getValue().doubleValue() + unreliab.getValue().doubleValue());
		return sum;
		
		
		/*MultiStatus status = new MultiStatus(DiceSimulationPlugin.PLUGIN_ID, 0, null, null);
		System.out.println("Test CalculateREsults step1");
		invocation.setResult(SimresultFactory.eINSTANCE.createSimulationResult());
		System.out.println("Test CalculateREsults step2");
		for (DomainMeasureDefinition measureDefinition : invocation.getDefinition().getMeasuresToCompute()) {
			EObject measuredElement = measureDefinition.getMeasuredElement();
			System.out.println("Test CalculateREsults step3");

			// Look for the first calculator that is able to handle
			// the measure for the given scenario type
			MeasureCalculator calculator = null;
			for (String scenarioName : invocation.getDefinition().getScenarioStereotypes()) {
				System.out.println("Test CalculateREsults step4");
				calculator = DiceMetricsUtils.getCalculator((Element) measuredElement, measureDefinition.getMeasure(), scenarioName,
						invocation.getToolResult().getClass());
				System.out.println("Test CalculateREsults step5");
				if (calculator != null) {
					break;
				}
				System.out.println("Test CalculateREsults step6");
			}

			if (calculator == null) {
				status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
						MessageFormat.format("Unable to find a ''{0}'' calculator for ''{1}'' ", measureDefinition.getMeasure(), measuredElement)));
			} else {
				System.out.println("Test CalculateREsults step7");
				DomainMeasure domainMeasure = calculator.calculate(measuredElement, measureDefinition, invocation.getToolResult(), invocation.getTraceSet());
				System.out.println("Test CalculateREsults step8");
				if (domainMeasure == null) {
					System.out.println("Test CalculateREsults step9");
					status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
							MessageFormat.format("Unable to calculate measure ''{0}'' for ''{1}'' ", measureDefinition.getMeasure(), measuredElement)));
					System.out.println("Test CalculateREsults step10");
				} else {
					System.out.println("Test CalculateREsults step11");
					domainMeasure.setDefinition(measureDefinition);
					System.out.println("Test CalculateREsults step12");
					invocation.getResult().getMeasures().add(domainMeasure);
					System.out.println("Test CalculateREsults step13");
				}
				
			}
		}
		
		return invocation.getResult().getMeasures().get(0);
		*/

	}

}