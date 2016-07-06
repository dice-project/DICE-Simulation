package es.unizar.disco.simulation.launcher;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.debug.core.model.RuntimeProcess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.statushandlers.StatusManager;

import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.backend.SimulatorsManager;
import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureConverter;
import es.unizar.disco.simulation.models.simresult.SimresultFactory;
import es.unizar.disco.simulation.models.simresult.SimulationResult;
import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
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

				Job killJob = new Job("Kill job") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						if (simulationProcess.isAlive()) {
							invocation.setStatus(SimulationStatus.KILLED);
							simulationProcess.destroyForcibly();
						}
						return Status.OK_STATUS;
					}
				};
				
				ZonedDateTime universalTime = OffsetDateTime.ofInstant(definition.getMaxExecutionTime().toInstant(), ZoneOffset.systemDefault()).atZoneSimilarLocal(ZoneOffset.UTC);
				
				killJob.schedule(universalTime.toInstant().toEpochMilli());
				
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
					for (DomainMeasureDefinition measureDefinition : definition.getMeasuresToCompute()) {
						EObject measuredElement = measureDefinition.getMeasuredElement();
						String measure = measureDefinition.getMeasure();
						SimulationResult simulationResult = SimresultFactory.eINSTANCE.createSimulationResult();
						for (AnalyzableElementInfo info : findInfosForDomainElement(measuredElement, invocation.getTraceSet(), invocation.getToolResult())) {
							MeasureConverter converter = DiceMetricsUtils.getConverter(info.getClass(), measure);
							DomainMeasure domainMeasure = converter.convert(info);
							domainMeasure.setDefinition(measureDefinition);
							simulationResult.getMeasures().add(domainMeasure);
						}
						invocation.setResult(simulationResult);
					}
				}
			}
		}
		if (!status.isOK()) {
			throw new CoreException(status);
		}
	}

	private static Set<AnalyzableElementInfo> findInfosForDomainElement(EObject domainelement, TraceSet traceSet, ToolResult toolResult) {
		Set<AnalyzableElementInfo> infos = new HashSet<>();
		for (Trace trace : findTraces(traceSet, domainelement)) {
			AnalyzableElementInfo info = findAnalyzableElementInfo(toolResult, trace.getToAnalyzableElement());
			if (info != null) {
				infos.add(info);
			}
		}
		return infos;
	}
	
	private static AnalyzableElementInfo findAnalyzableElementInfo(ToolResult toolResult, EObject eObject) {
		for (AnalyzableElementInfo info : toolResult.getInfos()) {
			if (eObject.equals(info.getAnalyzedElement())) {
				return info;
			}
		}
		return null;
	}
	
	private static Set<Trace> findTraces(TraceSet traceSet, EObject eObject) {
		Set<Trace> traces = new HashSet<>();
		for (Trace trace : traceSet.getTraces()) {
			if (eObject.equals(trace.getFromDomainElement())) {
				traces.add(trace);
			}
		}
		return traces;
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
