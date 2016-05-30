package es.unizar.disco.simulation.ui.launcher;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

public abstract class AbstractSimulationLaunchConfigurationTab extends AbstractLaunchConfigurationTab {
	
	private final DataBindingContext context = new DataBindingContext();
	
	protected final EContentAdapter contentAdapter = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			boolean update = false;
			switch (notification.getEventType()) {
				// Update only on events that modified the model 
				case Notification.ADD:
				case Notification.ADD_MANY:
				case Notification.MOVE:
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					update = true;
					break;
				case Notification.SET:
				case Notification.UNSET:
					if (!notification.isTouch()) { 
						update = true;
					}
					break;
				default:
					break;
			}
			if (update) {
				updateLaunchConfigurationDialog();
			}
		};
	};
	
	protected DataBindingContext getContext() {
		return context;
	}
	
	protected static String defaultToString(Object obj) {
		return obj != null ? StringUtils.defaultString(obj.toString()) : StringUtils.EMPTY;
	}
	
	
}