package es.unizar.disco.simulation.local.simulator;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulationException;

public class EmptySimulator implements ISimulator {

	@Override
	public Process simulate(String id, List<EObject> analyzableModel, TraceSet traces, Map<String, String> options,
			IProgressMonitor monitor) throws SimulationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolResult getToolResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getRawResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
