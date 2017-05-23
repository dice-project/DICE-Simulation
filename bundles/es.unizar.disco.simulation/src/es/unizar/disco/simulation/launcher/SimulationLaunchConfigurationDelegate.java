package es.unizar.disco.simulation.launcher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.simresult.SimresultFactory;
import es.unizar.disco.simulation.models.util.DiceMetricsUtils;
import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulationException;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {

		// Create submonitor with unknown worked
		SubMonitor subMonitor = SubMonitor.convert(monitor,
				Messages.SimulationLaunchConfigurationDelegate_simulatingTaskTilte, IProgressMonitor.UNKNOWN);

		final SimulationDefinition definition = reifySimulationDefinition(configuration);

		ControllingProcess controllingProcess = new ControllingProcess(launch, definition.getIdentifier());

		MultiStatus globalStatus = new MultiStatus(DiceSimulationPlugin.PLUGIN_ID, 0,
				MessageFormat.format("Simulation ''{0}'' finished with errors", definition.getIdentifier()), null);

		try {
			controllingProcess.log(new Status(IStatus.INFO, DiceSimulationPlugin.PLUGIN_ID, MessageFormat.format(
					"Validating analizable model for simulation definition ''{0}''...", definition.getIdentifier())));

			IStatus validateStatus = validateAnalyzableModel(definition);

			if (!validateStatus.isOK()) {
				DiceLogger.log(DiceSimulationPlugin.getDefault(), validateStatus);
				controllingProcess.log(validateStatus);
			}

			registerInvocations(definition.getInvocations());

			// Set the remaining ticks
			subMonitor.setWorkRemaining(definition.getInvocations().size());

			for (int i = 0; i < definition.getInvocations().size(); i++) {

				SimulationInvocation invocation = definition.getInvocations().get(i);

				controllingProcess.log(new Status(IStatus.INFO, DiceSimulationPlugin.PLUGIN_ID,
						MessageFormat.format("Launching invocation ''{0}''", invocation.getIdentifier())));

				MultiStatus invocationStatus = new MultiStatus(DiceSimulationPlugin.PLUGIN_ID, 0, null, null);

				try {
					final ISimulator simulator = SimulatorsManager.INSTANCE.getSimulator(definition.getBackend());

					subMonitor.subTask(MessageFormat.format("Launching Simulation {0} out of {1}", i + 1,
							definition.getInvocations().size()));

					invocation.setStart(Calendar.getInstance().getTime());

					if (controllingProcess.isTerminated()) {
						throw new InterruptedException();
					}

					if (simulator == null) {
						throw new SimulationException(MessageFormat.format(
								Messages.SimulationLaunchConfigurationDelegate_simulatorNotFoundError,
								definition.getBackend()));
					}
					invocation.setStatus(SimulationStatus.RUNNING);

					// @formatter:off
					Process simulationProcess = simulator.simulate(invocation.getIdentifier(),
							invocation.getAnalyzableModel(), invocation.getTraceSet(), definition.getParameters().map(),
							subMonitor.newChild(1));
					// @formatter:on

					IProcess runtimeProcess = DebugPlugin.newProcess(launch, simulationProcess,
							MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulationName,
									invocation.getIdentifier()),
							null);
					runtimeProcess.setAttribute(DebugPlugin.ATTR_LAUNCH_TIMESTAMP,
							Calendar.getInstance().getTime().toString());
					runtimeProcess.setAttribute(DebugPlugin.ATTR_ENVIRONMENT, definition.getParameters().toString());

					// @formatter:off
					ZonedDateTime universalTime = OffsetDateTime
							.ofInstant(definition.getMaxExecutionTime().toInstant(), ZoneOffset.systemDefault())
							.atZoneSimilarLocal(ZoneOffset.UTC);
					registerKillHook(invocation, simulationProcess, universalTime.toInstant().toEpochMilli());
					// @formatter:on

					simulationProcess.waitFor();
					if (simulationProcess.exitValue() != 0) {
						if (simulationProcess.exitValue() == ISimulator.RET_CODE_KILLED) {
							invocation.setStatus(SimulationStatus.KILLED);
						}
						invocationStatus.add(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
								MessageFormat.format(
										"Simulation process for invocation ''{0}'' exited with error ''{1}''",
										invocation.getIdentifier(), simulationProcess.exitValue())));
					}
					if (simulator.getToolResult() != null) {
						invocation.setToolResult(simulator.getToolResult());
						invocationStatus.merge(buildResult(invocation));
					}
				} catch (InterruptedException e) {
					invocation.setStatus(SimulationStatus.KILLED);
				} catch (Throwable t) {
					invocationStatus
							.add(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, t.getLocalizedMessage(), t));
				} finally {
					invocation.setEnd(Calendar.getInstance().getTime());
					globalStatus.merge(invocationStatus);
					controllingProcess.log(invocationStatus);
					if (invocation.getStatus() == SimulationStatus.KILLED) {
						controllingProcess.log(new Status(IStatus.CANCEL, DiceSimulationPlugin.PLUGIN_ID,
								MessageFormat.format("Invocation ''{0}'' killed", invocation.getIdentifier())));
					} else {
						if (invocationStatus.isOK()) {
							invocation.setStatus(SimulationStatus.FINISHED);
							controllingProcess.log(new Status(IStatus.INFO, DiceSimulationPlugin.PLUGIN_ID,
									MessageFormat.format("Invocation ''{0}'' finished", invocation.getIdentifier())));
						} else {
							invocation.setStatus(SimulationStatus.FAILED);
							controllingProcess.log(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
									MessageFormat.format("Invocation ''{0}'' failed", invocation.getIdentifier())));
						}
					}
				}
			}
		} finally {
			controllingProcess.terminate();
			if (!globalStatus.isOK()) {
				throw new CoreException(globalStatus);
			}
		}
	}

	private SimulationDefinition reifySimulationDefinition(ILaunchConfiguration configuration) throws CoreException {
		SimulationDefinition simulationDefinition = DefinitionFactory.eINSTANCE.createSimulationDefinition();

		simulationDefinition.setAutoSync(true);

		SimulationDefinitionConfigurationHandler handler = SimulationDefinitionConfigurationHandler
				.create(simulationDefinition);
		handler.initializeResourceUri(configuration);
		handler.initializeInputVariables(configuration);
		handler.initializeOutputVariables(configuration);
		handler.initializeActiveScenario(configuration);
		handler.initializeSelectedMeasures(configuration);
		handler.initializeActiveConfigurations(configuration);
		handler.initializeParameters(configuration);
		handler.initializeMaxExecutionTime(configuration);
		handler.initializeNFPtoCompute(configuration);
		handler.initializeBackend(configuration, DiceSimulationPlugin.getDefault().getDefaultSimulationBackend());

		// Re-build invocations
		simulationDefinition.getInvocations();

		simulationDefinition.setAutoSync(false);

		return simulationDefinition;
	}

	private IStatus validateAnalyzableModel(SimulationDefinition definition) throws CoreException {
		// Check that the analyzable model can be built without errors.
		// The errors should be the same for all possible configuration,
		// thus, we only test the first one
		final IStatus status = definition.getInvocations().get(0).buildAnalyzableModel();
		if (status.getSeverity() == IStatus.ERROR) {
			throw new CoreException(status);
		}
		return status;
	}

	private void registerInvocations(List<SimulationInvocation> invocations) {
		for (SimulationInvocation invocation : invocations) {
			invocation.setAutoBuild(true);
			invocation.setStatus(SimulationStatus.WAITING);
			SimulationInvocationsRegistry.INSTANCE.register(invocation);
		}
	}

	private void registerKillHook(SimulationInvocation invocation, Process simulationProcess, long delay) {
		new Thread() {
			public void run() {
				try {
					// Wait, approximately, the max time to kill the process
					sleep(delay);
					if (simulationProcess.isAlive()) {
						invocation.setStatus(SimulationStatus.KILLED);
						simulationProcess.destroyForcibly();
					}
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}.start();
	}

	private IStatus buildResult(SimulationInvocation invocation) {

		MultiStatus status = new MultiStatus(DiceSimulationPlugin.PLUGIN_ID, 0, null, null);

		invocation.setResult(SimresultFactory.eINSTANCE.createSimulationResult());

		for (DomainMeasureDefinition measureDefinition : invocation.getDefinition().getMeasuresToCompute()) {
			EObject measuredElement = measureDefinition.getMeasuredElement();

			// Look for the first calculator that is able to handle
			// the measure for the given scenario type
			if (DiceMetricsUtils.metricComputedBelongsToSelectedNFPtypeToCompute(
					invocation.getDefinition().getNfpToCompute(), measureDefinition.getMeasure())) {
				MeasureCalculator calculator = null;
				for (String scenarioName : invocation.getDefinition().getScenarioStereotypes()) {
					calculator = DiceMetricsUtils.getCalculator((Element) measuredElement,
							measureDefinition.getMeasure(), scenarioName, invocation.getToolResult().getClass());
					if (calculator != null) {
						break;
					}
				}

				if (calculator == null) {
					status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
							MessageFormat.format("Unable to find a ''{0}'' calculator for ''{1}'' ",
									measureDefinition.getMeasure(), measuredElement)));
				} else {
					DomainMeasure domainMeasure = calculator.calculate(measuredElement, measureDefinition,
							invocation.getToolResult(), invocation.getTraceSet());
					if (domainMeasure == null) {
						status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
								MessageFormat.format("Unable to calculate measure ''{0}'' for ''{1}'' ",
										measureDefinition.getMeasure(), measuredElement)));
					} else {
						domainMeasure.setDefinition(measureDefinition);
						invocation.getResult().getMeasures().add(domainMeasure);
					}
				}
			}
		}

		return status;
	}

	private class ControllingProcess extends PlatformObject implements IProcess {

		private class MonitoredByteOutputStream implements IStreamMonitor {

			private ByteArrayOutputStream stream = new ByteArrayOutputStream();
			private OutputStreamWriter writer = new OutputStreamWriter(stream);
			private List<IStreamListener> listeners = Collections.synchronizedList(new ArrayList<IStreamListener>());

			@Override
			public void removeListener(IStreamListener listener) {
				listeners.remove(listener);
			}

			@Override
			public synchronized String getContents() {
				String contents = stream.toString();
				stream.reset();
				return contents;
			}

			@Override
			public void addListener(IStreamListener listener) {
				listeners.add(listener);
			}

			private void notifyChanged(String text) {
				for (IStreamListener listener : listeners) {
					listener.streamAppended(text, this);
				}
			}

			public synchronized void write(String text) {
				try {
					writer.append(text);
					notifyChanged(text);
				} catch (IOException e) {
					// Should not happen
				}
			}
		}

		private IStreamsProxy streamsProxy = new IStreamsProxy() {
			MonitoredByteOutputStream outputStreamMonitor = new MonitoredByteOutputStream();
			MonitoredByteOutputStream errorStreamMonitor = new MonitoredByteOutputStream();

			@Override
			public void write(String input) throws IOException {
			}

			@Override
			public IStreamMonitor getOutputStreamMonitor() {
				return outputStreamMonitor;
			}

			@Override
			public IStreamMonitor getErrorStreamMonitor() {
				return errorStreamMonitor;
			}
		};

		private int exitValue = 0;
		private String id;
		private ILaunch launch;
		private volatile boolean terminated = false;

		public ControllingProcess(ILaunch launch, String id) {
			this.launch = launch;
			this.id = id;
			fireCreationEvent();
			launch.addProcess(this);
		}

		@Override
		public boolean canTerminate() {
			return !terminated;
		}

		@Override
		public boolean isTerminated() {
			return terminated;
		}

		@Override
		public void terminate() throws DebugException {
			if (!terminated) {
				fireTerminateEvent();
				terminated = true;
				launch.terminate();
			}
		}

		@Override
		public String getLabel() {
			return MessageFormat.format("Global control process for simulation {0}", id);
		}

		@Override
		public ILaunch getLaunch() {
			return launch;
		}

		@Override
		public IStreamsProxy getStreamsProxy() {
			return streamsProxy;
		}

		public void log(IStatus status) {
			if (!status.isMultiStatus()) {
				logStatus(status);
			} else {
				for (IStatus child : status.getChildren()) {
					logStatus(child);
				}
			}
		}

		private void logStatus(IStatus status) {
			MonitoredByteOutputStream stdout = (MonitoredByteOutputStream) getStreamsProxy().getOutputStreamMonitor();
			MonitoredByteOutputStream stderr = (MonitoredByteOutputStream) getStreamsProxy().getErrorStreamMonitor();
			switch (status.getSeverity()) {
			case IStatus.OK:
				stdout.write("[OK] " + status.getMessage() + "\n");
				break;
			case IStatus.INFO:
				stdout.write("[INFO] " + status.getMessage() + "\n");
				break;
			case IStatus.WARNING:
				stderr.write("[WARNING] " + status.getMessage() + "\n");
				break;
			case IStatus.ERROR:
				stderr.write("[ERROR] " + status.getMessage() + "\n");
				break;
			case IStatus.CANCEL:
				stderr.write("[CANCEL] " + status.getMessage() + "\n");
				break;
			default:
				stdout.write(status.getMessage() + "\n");
				break;
			}
		}

		@Override
		public void setAttribute(String key, String value) {
			fireChangeEvent();
		}

		@Override
		public String getAttribute(String key) {
			return null;
		}

		@Override
		public int getExitValue() throws DebugException {
			return exitValue;
		}

		protected void fireCreationEvent() {
			fireEvent(new DebugEvent(this, DebugEvent.CREATE));
		}

		protected void fireEvent(DebugEvent event) {
			DebugPlugin manager = DebugPlugin.getDefault();
			if (manager != null) {
				manager.fireDebugEventSet(new DebugEvent[] { event });
			}
		}

		protected void fireTerminateEvent() {
			fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
		}

		protected void fireChangeEvent() {
			fireEvent(new DebugEvent(this, DebugEvent.CHANGE));
		}

		@SuppressWarnings("unchecked")
		@Override
		public <T> T getAdapter(Class<T> adapter) {
			if (adapter.equals(IProcess.class)) {
				return (T) this;
			}
			if (adapter.equals(IDebugTarget.class)) {
				ILaunch launch = getLaunch();
				IDebugTarget[] targets = launch.getDebugTargets();
				for (int i = 0; i < targets.length; i++) {
					if (this.equals(targets[i].getProcess())) {
						return (T) targets[i];
					}
				}
				return null;
			}
			if (adapter.equals(ILaunch.class)) {
				return (T) getLaunch();
			}
			// CONTEXTLAUNCHING
			if (adapter.equals(ILaunchConfiguration.class)) {
				return (T) getLaunch().getLaunchConfiguration();
			}
			return super.getAdapter(adapter);
		}
	}
}
