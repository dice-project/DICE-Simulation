package es.unizar.disco.simulation.launcher;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Element;

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
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {

		// Create submonitor with unknown worked
		SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.SimulationLaunchConfigurationDelegate_simulatingTaskTilte, IProgressMonitor.UNKNOWN);

		final SimulationDefinition definition = reifySimulationDefinition(configuration);
		validateAnalyzableModel(definition);
		registerInvocations(definition.getInvocations());

		// Set the remaining ticks
		subMonitor.setWorkRemaining(definition.getInvocations().size());

		MultiStatus globalStatus = new MultiStatus(DiceSimulationPlugin.PLUGIN_ID, 0, null, null);

		for (int i = 0; i < definition.getInvocations().size(); i++) {

			MultiStatus invocationStatus = new MultiStatus(DiceSimulationPlugin.PLUGIN_ID, 0, null, null);

			SimulationInvocation invocation = definition.getInvocations().get(i);

			final ISimulator simulator = SimulatorsManager.INSTANCE.getSimulator(definition.getBackend());

			subMonitor.subTask(MessageFormat.format("Launching Simulation {0} out of {1}", i + 1, definition.getInvocations().size()));

			invocation.setStart(Calendar.getInstance().getTime());

			try {
				if (simulator == null) {
					throw new SimulationException(
							MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulatorNotFoundError, definition.getBackend()));
				}
				invocation.setStatus(SimulationStatus.RUNNING);

				// @formatter:off
				Process simulationProcess = simulator.simulate(
						invocation.getIdentifier(),
						invocation.getAnalyzableModel(),
						invocation.getTraceSet(),
						definition.getParameters().map(),
						subMonitor.newChild(1));
				// @formatter:on

				IProcess runtimeProcess = DebugPlugin.newProcess(launch, simulationProcess,
						MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulationName, invocation.getIdentifier()), null);
				runtimeProcess.setAttribute(DebugPlugin.ATTR_LAUNCH_TIMESTAMP, Calendar.getInstance().getTime().toString());
				runtimeProcess.setAttribute(DebugPlugin.ATTR_ENVIRONMENT, definition.getParameters().toString());

				// @formatter:off
				ZonedDateTime universalTime = OffsetDateTime.ofInstant(definition.getMaxExecutionTime().toInstant(), ZoneOffset.systemDefault()).atZoneSimilarLocal(ZoneOffset.UTC);
				registerKillHook(invocation, simulationProcess, universalTime.toInstant().toEpochMilli());
				// @formatter:on

				simulationProcess.waitFor();
				if (simulationProcess.exitValue() != 0) {
					if (simulationProcess.exitValue() == ISimulator.RET_CODE_KILLED) {
						invocation.setStatus(SimulationStatus.KILLED);
					}
					invocationStatus.add(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, MessageFormat.format(
							"Simulation process for invocation ''{0}'' exited with error ''{1}''", invocation.getIdentifier(), simulationProcess.exitValue())));
				}
				if (simulator.getToolResult() != null) {
					invocation.setToolResult(simulator.getToolResult());
					invocationStatus.merge(buildResult(invocation));
				}
			} catch (InterruptedException e) {
				invocation.setStatus(SimulationStatus.KILLED);
			} catch (Throwable t) {
				invocationStatus.add(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, t.getLocalizedMessage(), t));
			} finally {
				invocation.setEnd(Calendar.getInstance().getTime());
				if (invocation.getStatus() != SimulationStatus.KILLED) {
					if (invocationStatus.isOK()) {
						invocation.setStatus(SimulationStatus.FINISHED);
					} else {
						invocation.setStatus(SimulationStatus.FAILED);
					}
				}
				globalStatus.merge(invocationStatus);
			}
		}
		if (!globalStatus.isOK()) {
			throw new CoreException(globalStatus);
		}
	}

	private SimulationDefinition reifySimulationDefinition(ILaunchConfiguration configuration) throws CoreException {
		SimulationDefinition simulationDefinition = DefinitionFactory.eINSTANCE.createSimulationDefinition();

		simulationDefinition.setAutoSync(true);

		SimulationDefinitionConfigurationHandler handler = SimulationDefinitionConfigurationHandler.create(simulationDefinition);
		handler.initializeResourceUri(configuration);
		handler.initializeInputVariables(configuration);
		handler.initializeOutputVariables(configuration);
		handler.initializeActiveScenario(configuration);
		handler.initializeSelectedMeasures(configuration);
		handler.initializeActiveConfigurations(configuration);
		handler.initializeParameters(configuration);
		handler.initializeMaxExecutionTime(configuration);
		handler.initializeBackend(configuration, DiceSimulationPlugin.getDefault().getDefaultSimulationBackend());

		// Re-build invocations
		simulationDefinition.getInvocations();

		simulationDefinition.setAutoSync(false);

		return simulationDefinition;
	}

	private void validateAnalyzableModel(SimulationDefinition definition) throws CoreException {
		// Check that the analyzable model can be built without errors.
		// The errors should be the same for all possible configuration,
		// thus, we only test the first one
		final IStatus status = definition.getInvocations().get(0).buildAnalyzableModel();
		if (status.getSeverity() == IStatus.ERROR) {
			throw new CoreException(status);
		} else if (!status.isOK()) {
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}
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
			MeasureCalculator calculator = null;
			for (String scenarioName : invocation.getDefinition().getScenarioStereotypes()) {
				calculator = DiceMetricsUtils.getCalculator((Element) measuredElement, measureDefinition.getMeasure(), scenarioName,
						invocation.getToolResult().getClass());
				if (calculator != null) {
					break;
				}
			}

			if (calculator == null) {
				status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
						MessageFormat.format("Unable to find a ''{0}'' calculator for ''{1}'' ", measureDefinition.getMeasure(), measuredElement)));
			} else {
				DomainMeasure domainMeasure = calculator.calculate(measuredElement, measureDefinition, invocation.getToolResult(), invocation.getTraceSet());
				if (domainMeasure == null) {
					status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
							MessageFormat.format("Unable to calculate measure ''{0}'' for ''{1}'' ", measureDefinition.getMeasure(), measuredElement)));
				} else {
					domainMeasure.setDefinition(measureDefinition);
					invocation.getResult().getMeasures().add(domainMeasure);
				}
			}
		}

		return status;
	}
}
