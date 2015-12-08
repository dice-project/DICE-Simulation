package es.unizar.disco.simulation.simulators;

import java.io.IOException;

import org.eclipse.core.resources.IFile;

public interface IGspnProvider {

	public void setup(IFile inputFile) throws IOException;
	
	public String[] getGspnExecutionCommand() throws IOException;
	
	public void cleanup() throws IOException;
	
}
