package es.unizar.disco.simulation.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		try {
			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_simulatingTaskTilte, IProgressMonitor.UNKNOWN);
			
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
//				String id = "es.unizar.disco.simulation.greatspn.ssh.gspnSshSimulator"; //$NON-NLS-1$
//				final ISimulator simulator = getSimulator(id);
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
		} finally {
			monitor.done();
		}
	}
	
//	private static File getInputFile(ILaunchConfiguration configuration) throws CoreException {
//		String inputFileUriString = configuration.getAttribute(INPUT_FILE, StringUtils.EMPTY);
//		java.net.URI inputFileUri;
//		inputFileUri = java.net.URI.create(inputFileUriString);
//		File inputFile = new File(inputFileUri);
//		if (!inputFile.isFile()) {
//			throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, 
//					MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_invalidLocationError, inputFile)));
//		}
//		return inputFile;
//	}
//	
//	private static File getIntermediateFilesDir(ILaunchConfiguration configuration) throws CoreException {
//		File intermediateFilesDir;
//		if (configuration.getAttribute(KEEP_INTERMEDIATE_FILES, false)) {
//			String intermediateFilesDirUriString = configuration.getAttribute(INTERMEDIATE_FILES_DIR, StringUtils.EMPTY);
//			java.net.URI intermediateFilesDirUri;
//			intermediateFilesDirUri = java.net.URI.create(intermediateFilesDirUriString);
//			intermediateFilesDir = new File(intermediateFilesDirUri);
//		} else {
//			try {
//				intermediateFilesDir = Files.createTempDirectory("dice-simulation-", new FileAttribute[] {}).toFile(); //$NON-NLS-1$
//				intermediateFilesDir.deleteOnExit();
//			} catch (IOException e) {
//				throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, 
//						Messages.SimulationLaunchConfigurationDelegate_unableCreateTempFileError, e));
//			}
//		}
//		if (!intermediateFilesDir.isDirectory()) {
//			throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, 
//					MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_invalidLocationIntermediateFilesError, intermediateFilesDir)));
//		}
//		return intermediateFilesDir;
//	}
//	
//	private static PetriNetConfig getPetriNetConfig(ILaunchConfiguration configuration) throws CoreException {
//		String serializedConfig = configuration.getAttribute(SIMULATION_CONFIGURATION, StringUtils.EMPTY);
//		try {
//			return PetriNetConfigSerializer.deserialize(serializedConfig);
//		} catch (IOException e) {
//			throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, 
//					MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_unableDeserializeError, serializedConfig), e));
//		}
//	}
//
//	private static void dumpConfig(PetriNetConfig pnConfig, File pnConfigFile, IProgressMonitor monitor) throws IOException {
//		if (monitor == null) {
//			monitor = new NullProgressMonitor();
//		}
//		try {
//			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_dumpingTaskTitle, 1);
//			ResourceSet resourceSet = new ResourceSetImpl();
//			Resource configResource = resourceSet.createResource(URI.createFileURI(pnConfigFile.getAbsolutePath()));
//			configResource.getContents().add(pnConfig);
//			configResource.save(Collections.emptyMap());
//			monitor.worked(1);
//		} finally {
//			monitor.done();
//		}
//	}
//
//	
//	private static void transformUmlToPnml(File umlFile, PetriNetConfig pnConfig, File pnmlFile, IProgressMonitor monitor) throws IOException {
//		if (monitor == null) {
//			monitor = new NullProgressMonitor();
//		}
//		try {
//			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_generatingPnmlTaskTitle, 1);
//			ResourceSet resourceSet = new ResourceSetImpl();
//			
//			TransformationExecutor executor = new TransformationExecutor(URI.createURI(PnmlM2mPlugin.AD2PNML_TRANSFORMATION_URI));
//	
//			ExecutionContextImpl context = new ExecutionContextImpl();
//			
//			Resource umlResource = resourceSet.getResource(URI.createFileURI(umlFile.getAbsolutePath()), true);
//			EList<EObject> inObjects = umlResource.getContents();
//	
//			ModelExtent ad = new BasicModelExtent(inObjects);
//			ModelExtent config = new BasicModelExtent(Arrays.asList(new EObject[] { pnConfig }));
//			ModelExtent res = new BasicModelExtent();
//	
//			ExecutionDiagnostic result = executor.execute(context, ad, config, res);
//	
//			if (result.getSeverity() == Diagnostic.OK) {
//				Resource pnmlResource = resourceSet.createResource(URI.createFileURI(pnmlFile.getAbsolutePath()));
//				pnmlResource.getContents().addAll(res.getContents());
//				pnmlResource.save(Collections.emptyMap());
//			} else {
//				DiceLogger.log(DiceSimulationPlugin.getDefault(), BasicDiagnostic.toIStatus(result));
//			}
//			monitor.worked(1);
//		} finally {
//			monitor.done();
//		}
//	}
//
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
//	private static ISimulator getSimulator(String id) throws CoreException {
//		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(SimulatorConstants.EXTENSION_ID);
//		
//		for (IConfigurationElement configElement : configElements) {
//			String configId = configElement.getAttribute(SimulatorConstants.ID_ATTR);
//			if (StringUtils.equals(id, configId)) {
//				return (ISimulator) configElement.createExecutableExtension(SimulatorConstants.SIMULATOR_ATTR);
//			}
//		}
//		return null;
//	}
//	
//
//	private static String getSimulationName(String id) {
//		return MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulationName, id.toString());
//	}
}
