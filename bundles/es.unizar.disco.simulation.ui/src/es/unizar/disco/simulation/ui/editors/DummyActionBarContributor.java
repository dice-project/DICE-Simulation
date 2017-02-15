package es.unizar.disco.simulation.ui.editors;

import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPage;

public class DummyActionBarContributor extends EditingDomainActionBarContributor {
	
	public DummyActionBarContributor() {
	}
	
	@Override
	public void shareGlobalActions(IPage page, IActionBars actionBars) {
	}
	
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
	}
}