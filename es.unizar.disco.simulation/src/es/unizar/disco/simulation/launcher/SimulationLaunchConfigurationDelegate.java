package es.unizar.disco.simulation.launcher;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.debug.core.model.RuntimeProcess;
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
import es.unizar.disco.simulation.models.simresult.SimulationResult;
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

		{
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

		for (SimulationInvocation invocation : definition.getInvocations()) {
			invocation.setAutoBuild(true);
			invocation.setStatus(SimulationStatus.WAITING);
			SimulationInvocationsRegistry.INSTANCE.register(invocation);
		}

		// Set the remaining ticks
		subMonitor.setWorkRemaining(definition.getInvocations().size());

		MultiStatus status = new MultiStatus(DiceSimulationPlugin.PLUGIN_ID, 0, null, null);

		for (int i = 0; i < definition.getInvocations().size(); i++) {

			SimulationInvocation invocation = definition.getInvocations().get(i);

			final ISimulator simulator = SimulatorsManager.INSTANCE.getSimulator(definition.getBackend());

			try {

				if (simulator == null) {
					throw new SimulationException(
							MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulatorNotFoundError, definition.getBackend()));
				}

				subMonitor.subTask(MessageFormat.format("Running Simulation {0} out of {1}", i + 1, definition.getInvocations().size()));

				invocation.setStart(Calendar.getInstance().getTime());
				invocation.setStatus(SimulationStatus.RUNNING);

				// @formatter:off
				Process simulationProcess = simulator.simulate(
						invocation.getIdentifier(),
						invocation.getAnalyzableModel(),
						invocation.getTraceSet(),
						definition.getParameters().map(),
						subMonitor.newChild(1));
				// @formatter:on

				RuntimeProcess runtimeProcess = new RuntimeProcess(launch, simulationProcess,
						MessageFormat.format(Messages.SimulationLaunchConfigurationDelegate_simulationName, invocation.getIdentifier().toString()), null);
				runtimeProcess.setAttribute(DebugPlugin.ATTR_LAUNCH_TIMESTAMP, Calendar.getInstance().getTime().toString());
				runtimeProcess.setAttribute(DebugPlugin.ATTR_ENVIRONMENT, definition.getParameters().toString());

				// @formatter:off
				ZonedDateTime universalTime = OffsetDateTime.ofInstant(definition.getMaxExecutionTime().toInstant(), ZoneOffset.systemDefault()).atZoneSimilarLocal(ZoneOffset.UTC);
				new Thread() {
					public void run() {
						try {
							sleep(universalTime.toInstant().toEpochMilli());
							if (simulationProcess.isAlive()) {
								invocation.setStatus(SimulationStatus.KILLED);
								simulationProcess.destroyForcibly();
							}
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				}.start();
				// @formatter:on

				simulationProcess.waitFor();
				if (simulationProcess.exitValue() == 0) {
					invocation.setStatus(SimulationStatus.FINISHED);
				}
			} catch (SimulationException | InterruptedException e) {
				status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
			} finally {
				invocation.setEnd(Calendar.getInstance().getTime());
				if (invocation.getStatus() == SimulationStatus.RUNNING
						|| invocation.getStatus() == SimulationStatus.WAITING
						|| invocation.getStatus() == SimulationStatus.UNKNOWN) {
					invocation.setStatus(SimulationStatus.FAILED);
				}
				if (simulator.getToolResult() != null) {
					invocation.setToolResult(simulator.getToolResult());
					SimulationResult simulationResult = SimresultFactory.eINSTANCE.createSimulationResult();
					invocation.setResult(simulationResult);
					for (DomainMeasureDefinition measureDefinition : definition.getMeasuresToCompute()) {
						EObject measuredElement = measureDefinition.getMeasuredElement();
						MeasureCalculator calculator = DiceMetricsUtils.getCalculator((Element) measuredElement, measureDefinition.getMeasure());
						if (calculator == null) {
							invocation.setStatus(SimulationStatus.FAILED);
							status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
									MessageFormat.format("Unable to find a ''{0}'' calculator for ''{1}'' ", measureDefinition.getMeasure(), measuredElement)));
						} else {
							DomainMeasure domainMeasure = calculator.calculate(measuredElement, invocation.getToolResult(), invocation.getTraceSet());
							if (domainMeasure == null) {
								invocation.setStatus(SimulationStatus.FAILED);
								status.merge(new Status(IStatus.ERROR, DiceSimulationPlugin.PLUGIN_ID,
										MessageFormat.format("Unable to calculate measure ''{0}'' for ''{1}'' ", measureDefinition.getMeasure(), measuredElement)));
							} else {
								domainMeasure.setDefinition(measureDefinition);
								simulationResult.getMeasures().add(domainMeasure);
							}
						}
					}
				}
			}
		}
		if (!status.isOK()) {
			throw new CoreException(status);
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

		simulationDefinition.setAutoSync(false);

		return simulationDefinition;
	}
}
