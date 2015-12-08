package es.unizar.disco.simulation.simulators;

import java.io.File;
import java.io.InputStream;

public interface ISimulator {
	
	public Process simulate(String subject, File... inputFiles) throws SimulationException;

	public InputStream getRawResult();

}
