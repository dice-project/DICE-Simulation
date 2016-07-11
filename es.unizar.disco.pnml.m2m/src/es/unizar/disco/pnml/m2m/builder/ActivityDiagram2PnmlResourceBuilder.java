package es.unizar.disco.pnml.m2m.builder;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.uml2.uml.Element;

import es.unizar.disco.pnml.m2m.PnmlM2mPlugin;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder;
import es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment;
import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.traces.TracesFactory;

public class ActivityDiagram2PnmlResourceBuilder implements IAnalyzableModelBuilder {

	public class StatusLog implements Log {

		private final MultiStatus status;

		public StatusLog(Element element) {
			status = new MultiStatus(PnmlM2mPlugin.PLUGIN_ID, 0, null, null);
		}

		public void log(int level, String message, Object param) {
			String recordStr = MessageFormat.format("Level {0} - {1}, data: {2}", level, message, String.valueOf(param)); //$NON-NLS-1$
			logRecord(recordStr);
		}

		public void log(int level, String message) {
			String recordStr = MessageFormat.format("Level {0} - {1}", level, message); //$NON-NLS-1$
			logRecord(recordStr);
		}

		public void log(String message, Object param) {
			String recordStr = MessageFormat.format("{0}, data: {1}", message, String.valueOf(param)); //$NON-NLS-1$
			logRecord(recordStr);
		}

		public void log(String message) {
			logRecord(message);
		}

		private void logRecord(String recordStr) {
			Pattern pattern = Pattern.compile("(?:Level \\d+ - )?ASSERT \\[(\\w+)\\] failed at \\(\\S+\\) : (.+)");
			Matcher matcher = pattern.matcher(recordStr);
			if (matcher.matches()) {
				String severity = matcher.group(1);
				status.add(new Status(toSeverity(severity), PnmlM2mPlugin.PLUGIN_ID, matcher.group(2)));
			} else {
				status.add(new Status(IStatus.INFO, PnmlM2mPlugin.PLUGIN_ID, recordStr));
			}
		}

		public IStatus getStatus() {
			return status;
		}

		private int toSeverity(String severity) {
			switch (severity) {
				case "warning":
					return IStatus.WARNING;
				case "error":
					return IStatus.ERROR;
				case "fatal":
					return IStatus.ERROR;
				default:
					return IStatus.INFO;
			}
		}
	}

	@Override
	public ModelResult createAnalyzableModel(Element element, List<PrimitiveVariableAssignment> assignments) {
		TransformationExecutor executor = new TransformationExecutor(URI.createURI(PnmlM2mPlugin.AD2PNML_TRANSFORMATION_URI));
		ExecutionContextImpl context = new ExecutionContextImpl();
		StatusLog statusLog = new StatusLog(element);
		context.setLog(statusLog);

		ModelExtent model = new BasicModelExtent(Arrays.asList(new EObject[] { element }));
		ModelExtent vars = new BasicModelExtent(assignments);
		ModelExtent res = new BasicModelExtent();
		ModelExtent traces = new BasicModelExtent();

		ExecutionDiagnostic result = executor.execute(context, model, vars, res, traces);

		TraceSet traceSet = TracesFactory.eINSTANCE.createTraceSet();
		for (EObject trace : traces.getContents()) {
			traceSet.getTraces().add((Trace) trace);
		}
		
		IStatus status = null;
		if (result.getSeverity() == Diagnostic.OK) {
			if (statusLog.getStatus().getSeverity() == IStatus.WARNING) {
				status = new MultiStatus(PnmlM2mPlugin.PLUGIN_ID, 0, MessageFormat.format("Transformation executed with warnings while processing ''{0}''", element), null);
			} else if (statusLog.getStatus().getSeverity() == IStatus.ERROR) {
				status = new MultiStatus(PnmlM2mPlugin.PLUGIN_ID, 0, MessageFormat.format("Transformation executed with errors while processing ''{0}''", element), null);
			} else {
				status = new MultiStatus(PnmlM2mPlugin.PLUGIN_ID, 0, MessageFormat.format("Transformation executed on ''{0}''", element), null);
			}
			((MultiStatus) status).addAll(statusLog.getStatus());
		} else {
			status = new Status(IStatus.ERROR, PnmlM2mPlugin.PLUGIN_ID, result.getMessage());
		}
		
		return new IAnalyzableModelBuilder.ModelResult(res.getContents(), traceSet, status);
	}
}
