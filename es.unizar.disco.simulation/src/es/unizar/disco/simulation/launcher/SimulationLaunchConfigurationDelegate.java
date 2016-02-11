package es.unizar.disco.simulation.launcher;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.debug.core.model.RuntimeProcess;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.pnconfig.PetriNetConfig;
import es.unizar.disco.pnconfig.util.PetriNetConfigSerializer;
import es.unizar.disco.pnml.m2m.PnmlM2mPlugin;
import es.unizar.disco.pnml.m2t.templates.gspn.GenerateGspn;
import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulationException;
import es.unizar.disco.simulation.simulators.SimulatorConstants;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String INPUT_FILE = "INPUT_MODEL"; //$NON-NLS-1$

	public static final String KEEP_INTERMEDIATE_FILES= "KEEP_INTERMEDIATE_FILES"; //$NON-NLS-1$
	
	public static final String INTERMEDIATE_FILES_DIR = "INTERMEDIATE_FILES_FOLDER"; //$NON-NLS-1$

	public static final String SIMULATION_CONFIGURATION = "SIMULATION_CONFIGURATION"; //$NON-NLS-1$

	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		try {
			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_simulatingTaskTilte, IProgressMonitor.UNKNOWN);
			
			Map<String, String> simulationAttrs = new HashMap<>();
			simulationAttrs.put(DebugPlugin.ATTR_LAUNCH_TIMESTAMP, Calendar.getInstance().getTime().toString());
			
			PetriNetConfig pnConfig = getPetriNetConfig(configuration);
	
			final boolean keepIntermediateFiles = configuration.getAttribute(KEEP_INTERMEDIATE_FILES, false);
			final File intermediateFilesDir = getIntermediateFilesDir(configuration);
	
			final File umlFile = getInputFile(configuration);
			final File configFile = Paths.get(intermediateFilesDir.toURI()).resolve("dump.pnconfig").toFile(); //$NON-NLS-1$
			final File pnmlFile = Paths.get(intermediateFilesDir.toURI()).resolve("net.pnml.xmi").toFile(); //$NON-NLS-1$
			final File gspnNetFile = Paths.get(intermediateFilesDir.toURI()).resolve("net.gspn.net").toFile(); //$NON-NLS-1$
			final File gspnDefFile = Paths.get(intermediateFilesDir.toURI()).resolve("net.gspn.def").toFile(); //$NON-NLS-1$
			final File resultFile = Paths.get(intermediateFilesDir.toURI()).resolve("result.txt").toFile(); //$NON-NLS-1$

			try {
				try {
					dumpConfig(pnConfig, configFile, new SubProgressMonitor(monitor, 1));
					transformUmlToPnml(umlFile, pnConfig, pnmlFile, new SubProgressMonitor(monitor, 1));
					transformPnmlToGspn(pnmlFile, intermediateFilesDir, new SubProgressMonitor(monitor, 1));
				} finally {
					// Refresh workspace if intermediate files were stored in it
					if (keepIntermediateFiles) {
						for (IContainer container : ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(intermediateFilesDir.toURI())) {
							container.refreshLocal(IResource.DEPTH_ONE, new SubProgressMonitor(monitor, 1));
						}
					}
				}
				String id = "es.unizar.disco.simulation.greatspn.ssh.gspnSshSimulator"; //$NON-NLS-1$
				final ISimulator simulator = getSimulator(id);
				if (simulator == null) {
					throw new SimulationException(MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulatorNotFoundError, id));
				}
				String netName = new Path(gspnNetFile.getName()).removeFileExtension().toString();
				
				// TODO: change this quick & dirty way to show the raw results
				final Process simulationProcess = simulator.simulate(netName, gspnNetFile, gspnDefFile);
				final RuntimeProcess runtimeProcess = new RuntimeProcess(launch, simulationProcess, getSimulationName(simulator.getId()), simulationAttrs);
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							simulationProcess.waitFor();
							ByteArrayOutputStream out = new ByteArrayOutputStream();
							IOUtils.copy(simulator.getRawResult(), out);
							runtimeProcess.setAttribute(DebugPlugin.ATTR_ENVIRONMENT, "*** SIMULATION RAW RESULTS ***\n" + out.toString()); //$NON-NLS-1$
							
							try (FileWriter writer = new FileWriter(resultFile);) {
								writer.write(out.toString());
							} catch (IOException e) {
								DiceLogger.logException(DiceSimulationPlugin.getDefault(), e);
							}
						} catch (InterruptedException | IOException e) {
							DiceLogger.logException(DiceSimulationPlugin.getDefault(), e);
						} finally {
							// Refresh workspace if intermediate files were stored in it
							if (keepIntermediateFiles) {
								for (IContainer container : ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(intermediateFilesDir.toURI())) {
									try {
										container.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
									} catch (CoreException e) {
										DiceLogger.logException(DiceSimulationPlugin.getDefault(), e);
									}
								}
							}
						}
					}
				}).start();
				
			} catch (IOException | SimulationException e) {
				throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
			}
		} finally {
			monitor.done();
		}
	}
	
	private File getInputFile(ILaunchConfiguration configuration) throws CoreException {
		String inputFileUriString = configuration.getAttribute(INPUT_FILE, StringUtils.EMPTY);
		java.net.URI inputFileUri;
		inputFileUri = java.net.URI.create(inputFileUriString);
		File inputFile = new File(inputFileUri);
		if (!inputFile.isFile()) {
			throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, 
					MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_invalidLocationError, inputFile)));
		}
		return inputFile;
	}
	
	private File getIntermediateFilesDir(ILaunchConfiguration configuration) throws CoreException {
		File intermediateFilesDir;
		if (configuration.getAttribute(KEEP_INTERMEDIATE_FILES, false)) {
			String intermediateFilesDirUriString = configuration.getAttribute(INTERMEDIATE_FILES_DIR, StringUtils.EMPTY);
			java.net.URI intermediateFilesDirUri;
			intermediateFilesDirUri = java.net.URI.create(intermediateFilesDirUriString);
			intermediateFilesDir = new File(intermediateFilesDirUri);
		} else {
			try {
				intermediateFilesDir = Files.createTempDirectory("dice-simulation-", new FileAttribute[] {}).toFile(); //$NON-NLS-1$
				intermediateFilesDir.deleteOnExit();
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, 
						Messages.SimulationLaunchConfigurationDelegate_unableCreateTempFileError, e));
			}
		}
		if (!intermediateFilesDir.isDirectory()) {
			throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, 
					MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_invalidLocationIntermediateFilesError, intermediateFilesDir)));
		}
		return intermediateFilesDir;
	}
	
	private PetriNetConfig getPetriNetConfig(ILaunchConfiguration configuration) throws CoreException {
		String serializedConfig = configuration.getAttribute(SIMULATION_CONFIGURATION, StringUtils.EMPTY);
		try {
			return PetriNetConfigSerializer.deserialize(serializedConfig);
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, 
					MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_unableDeserializeError, serializedConfig), e));
		}
	}

	private void dumpConfig(PetriNetConfig pnConfig, File pnConfigFile, IProgressMonitor monitor) throws IOException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		try {
			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_dumpingTaskTitle, 1);
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource configResource = resourceSet.createResource(URI.createFileURI(pnConfigFile.getAbsolutePath()));
			configResource.getContents().add(pnConfig);
			configResource.save(Collections.emptyMap());
			monitor.worked(1);
		} finally {
			monitor.done();
		}
	}

	
	private void transformUmlToPnml(File umlFile, PetriNetConfig pnConfig, File pnmlFile, IProgressMonitor monitor) throws IOException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		try {
			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_generatingPnmlTaskTitle, 1);
			ResourceSet resourceSet = new ResourceSetImpl();
			
			TransformationExecutor executor = new TransformationExecutor(URI.createURI(PnmlM2mPlugin.AD2PNML_TRANSFORMATION_URI));
	
			ExecutionContextImpl context = new ExecutionContextImpl();
			
			Resource umlResource = resourceSet.getResource(URI.createFileURI(umlFile.getAbsolutePath()), true);
			EList<EObject> inObjects = umlResource.getContents();
	
			ModelExtent ad = new BasicModelExtent(inObjects);
			ModelExtent config = new BasicModelExtent(Arrays.asList(new EObject[] { pnConfig }));
			ModelExtent res = new BasicModelExtent();
	
			ExecutionDiagnostic result = executor.execute(context, ad, config, res);
	
			if (result.getSeverity() == Diagnostic.OK) {
				Resource pnmlResource = resourceSet.createResource(URI.createFileURI(pnmlFile.getAbsolutePath()));
				pnmlResource.getContents().addAll(res.getContents());
				pnmlResource.save(Collections.emptyMap());
			} else {
				DiceLogger.log(DiceSimulationPlugin.getDefault(), BasicDiagnostic.toIStatus(result));
			}
			monitor.worked(1);
		} finally {
			monitor.done();
		}
	}

	private void transformPnmlToGspn(File pnmlFile, File intermediateFilesDir, IProgressMonitor monitor) throws IOException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		try {
			monitor.beginTask(Messages.SimulationLaunchConfigurationDelegate_generatingGspnTaskTitle, 1);
			GenerateGspn gspnGenerator = new GenerateGspn(URI.createFileURI(pnmlFile.getAbsolutePath()), intermediateFilesDir, new ArrayList<EObject>());
			AcceleoPreferences.switchForceDeactivationNotifications(true);
			gspnGenerator.doGenerate(BasicMonitor.toMonitor(new SubProgressMonitor(monitor, 1)));
		} finally {
			monitor.done();
		}
	}
	
	private ISimulator getSimulator(String id) throws CoreException {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(SimulatorConstants.EXTENSION_ID);
		
		for (IConfigurationElement configElement : configElements) {
			String configId = configElement.getAttribute(SimulatorConstants.ID_ATTR);
			if (StringUtils.equals(id, configId)) {
				return (ISimulator) configElement.createExecutableExtension(SimulatorConstants.SIMULATOR_ATTR);
			}
		}
		return null;
	}
	

	private static String getSimulationName(String id) {
		return MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulationName, id.toString());
	}
}
