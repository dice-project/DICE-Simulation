package es.unizar.disco.simulation.simulators;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;

public interface ISimulator {
	
	public static final int RET_CODE_OK = 0;
	
	public static final int RET_CODE_KILLED = -10;
	
	public static final int RET_CODE_UNKNOWN_ERROR = Integer.MIN_VALUE;
	
	
	public Process simulate(String id, List<EObject> analyzableModel, TraceSet traces, Map<String, String> options, IProgressMonitor monitor) throws SimulationException;
	
	public ToolResult getToolResult();

	public InputStream getRawResult();

}
