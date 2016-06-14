package es.unizar.disco.simulation.launcher;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;

import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {
	
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		
		try {
			
			final ResourceSet resourceSet = new ResourceSetImpl();

			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_simulatingTaskTilte, IProgressMonitor.UNKNOWN);
			
			final SimulationDefinition definition = reifySimulationDefinition(configuration);
			
			final URI workingArea = definition.getWorkingArea();
			
			Resource defResource = resourceSet.createResource(buildUri(workingArea, definition.getIdentifier()));
			defResource.getContents().add(definition);
			
			for (SimulationInvocation invocation : definition.getInvocations()) {
				Resource invResource = resourceSet.createResource(buildUri(workingArea, invocation.getIdentifier()));
				invResource.getContents().add(invocation);
				final Resource analyzableResource = invocation.getAnalyzableResource().getResource();
			}

			for (Resource resource : resourceSet.getResources()) {
				resource.save(Collections.emptyMap());
			}
			
//			
//			Map<String, String> simulationAttrs = new HashMap<>();
//			simulationAttrs.put(DebugPlugin.ATTR_LAUNCH_TIMESTAMP, Calendar.getInstance().getTime().toString());
//			
//			PetriNetConfig pnConfig = getPetriNetConfig(configuration);
//	
//			final boolean keepIntermediateFiles = configuration.getAttribute(KEEP_INTERMEDIATE_FILES, false);
//			final File intermediateFilesDir = getIntermediateFilesDir(configuration);
//	
//			final File umlFile = getInputFile(configuration);
//			final File configFile = Paths.get(intermediateFilesDir.toURI()).resolve("dump.pnconfig").toFile(); //$NON-NLS-1$
//			final File pnmlFile = Paths.get(intermediateFilesDir.toURI()).resolve("net.pnml.xmi").toFile(); //$NON-NLS-1$
//			final File gspnNetFile = Paths.get(intermediateFilesDir.toURI()).resolve("net.gspn.net").toFile(); //$NON-NLS-1$
//			final File gspnDefFile = Paths.get(intermediateFilesDir.toURI()).resolve("net.gspn.def").toFile(); //$NON-NLS-1$
//			final File resultFile = Paths.get(intermediateFilesDir.toURI()).resolve("result.txt").toFile(); //$NON-NLS-1$
//
//			try {
//				try {
//					dumpConfig(pnConfig, configFile, new SubProgressMonitor(monitor, 1));
//					transformUmlToPnml(umlFile, pnConfig, pnmlFile, new SubProgressMonitor(monitor, 1));
//					transformPnmlToGspn(pnmlFile, intermediateFilesDir, new SubProgressMonitor(monitor, 1));
//				} finally {
//					// Refresh workspace if intermediate files were stored in it
//					if (keepIntermediateFiles) {
//						for (IContainer container : ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(intermediateFilesDir.toURI())) {
//							container.refreshLocal(IResource.DEPTH_ONE, new SubProgressMonitor(monitor, 1));
//						}
//					}
//				}
//				String id = simulationDefinition.getBackend();
//				final ISimulator simulator = SimulatorsManager.INSTANCE.getSimulator(id);
//				if (simulator == null) {
//					throw new SimulationException(MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulatorNotFoundError, id));
//				}
//				String netName = new Path(gspnNetFile.getName()).removeFileExtension().toString();
//				
//				// TODO: change this quick & dirty way to show the raw results
//				final Process simulationProcess = simulator.simulate(netName, gspnNetFile, gspnDefFile);
//				final RuntimeProcess runtimeProcess = new RuntimeProcess(launch, simulationProcess, getSimulationName(simulator.getId()), simulationAttrs);
//				new Thread(new Runnable() {
//					@Override
//					public void run() {
//						try {
//							simulationProcess.waitFor();
//							ByteArrayOutputStream out = new ByteArrayOutputStream();
//							IOUtils.copy(simulator.getRawResult(), out);
//							runtimeProcess.setAttribute(DebugPlugin.ATTR_ENVIRONMENT, "*** SIMULATION RAW RESULTS ***\n" + out.toString()); //$NON-NLS-1$
//							
//							try (FileWriter writer = new FileWriter(resultFile);) {
//								writer.write(out.toString());
//							} catch (IOException e) {
//								DiceLogger.logException(DiceSimulationPlugin.getDefault(), e);
//							}
//						} catch (InterruptedException | IOException e) {
//							DiceLogger.logException(DiceSimulationPlugin.getDefault(), e);
//						} finally {
//							// Refresh workspace if intermediate files were stored in it
//							if (keepIntermediateFiles) {
//								for (IContainer container : ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(intermediateFilesDir.toURI())) {
//									try {
//										container.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
//									} catch (CoreException e) {
//										DiceLogger.logException(DiceSimulationPlugin.getDefault(), e);
//									}
//								}
//							}
//						}
//					}
//				}).start();
//				
//			} catch (IOException | SimulationException e) {
//				throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
//			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
		} finally {
			monitor.done();
		}
	}


	private SimulationDefinition reifySimulationDefinition(ILaunchConfiguration configuration) throws CoreException {
		SimulationDefinition simulationDefinition = DefinitionFactory.eINSTANCE.createSimulationDefinition();
		
		SimulationDefinitionConfigurationHandler handler = SimulationDefinitionConfigurationHandler.create(simulationDefinition);
		handler.initializeResourceUri(configuration);
		handler.initializeIdentifier(configuration);
		handler.initializeInputVariables(configuration);
		handler.initializeOutputVariables(configuration);
		handler.initializeActiveScenario(configuration);
		handler.initializeSelectedMeasures(configuration);
		handler.initializeActiveConfigurations(configuration);
		handler.initializeParameters(configuration);
		handler.initializeMaxExecutionTime(configuration);
		handler.initializeWorkingArea(configuration);
		handler.initializeBackend(configuration, DiceSimulationPlugin.getDefault().getDefaultSimulationBackend());
		return simulationDefinition;
	}

//	private static void transformPnmlToGspn(File pnmlFile, File intermediateFilesDir, IProgressMonitor monitor) throws IOException {
//		if (monitor == null) {
//			monitor = new NullProgressMonitor();
//		}
//		try {
//			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_generatingGspnTaskTitle, 1);
//			GenerateGspn gspnGenerator = new GenerateGspn(URI.createFileURI(pnmlFile.getAbsolutePath()), intermediateFilesDir, new ArrayList<EObject>());
//			AcceleoPreferences.switchForceDeactivationNotifications(true);
//			gspnGenerator.doGenerate(BasicMonitor.toMonitor(new SubProgressMonitor(monitor, 1)));
//		} finally {
//			monitor.done();
//		}
//	}
//	
//	private static String getSimulationName(String id) {
//		return MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulationName, id.toString());
//	}

	private static URI buildUri(URI workingArea, String identifier) {
		return workingArea.appendSegment(identifier).appendFileExtension(XMIResource.XMI_NS);
	}
}
