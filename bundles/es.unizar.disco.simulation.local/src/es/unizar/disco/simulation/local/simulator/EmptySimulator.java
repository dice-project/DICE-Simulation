package es.unizar.disco.simulation.local.simulator;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.WnsimFactory;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulationException;

public class EmptySimulator implements ISimulator {

	private class VoidProcess extends Process {

		InputStream in = IOUtils.toInputStream("");
		OutputStream out = new ByteArrayOutputStream();
		InputStream err = IOUtils.toInputStream("");
		
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int exitValue() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public InputStream getErrorStream() {
			// TODO Auto-generated method stub
			return err;
		}

		@Override
		public InputStream getInputStream() {
			// TODO Auto-generated method stub
			return in;
		}

		@Override
		public OutputStream getOutputStream() {
			// TODO Auto-generated method stub
			return out;
		}

		@Override
		public int waitFor() throws InterruptedException {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	@Override
	public Process simulate(String id, List<EObject> analyzableModel, TraceSet traces, Map<String, String> options,
			IProgressMonitor monitor) throws SimulationException {

		return new VoidProcess();		
		
	}

	@Override
	public ToolResult getToolResult() {
		return WnsimFactory.eINSTANCE.createWnsimResult();
	}

	@Override
	public InputStream getRawResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
