package es.unizar.disco.simulation.ui.views;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;

public class ClearRegistryHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		SimulationInvocationsRegistry.INSTANCE.clear();
		return null;
	}

}
