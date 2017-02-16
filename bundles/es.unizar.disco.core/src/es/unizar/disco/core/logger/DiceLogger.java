package es.unizar.disco.core.logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

public abstract class DiceLogger {
	
	public static void log(Plugin plugin, IStatus status) {
		plugin.getLog().log(status);
	}
	
	public static void logInfo(Plugin plugin, String message) {
		log(plugin, new Status(IStatus.INFO, plugin.getBundle().getSymbolicName(), message));
	}
	
	public static void logInfo(Plugin plugin, String message, Throwable t) {
		log(plugin, new Status(IStatus.INFO, plugin.getBundle().getSymbolicName(), message, t));
	}
	
	public static void logWarning(Plugin plugin, String message) {
		log(plugin, new Status(IStatus.WARNING, plugin.getBundle().getSymbolicName(), message));
	}
	
	public static void logWarning(Plugin plugin, String message, Throwable t) {
		log(plugin, new Status(IStatus.WARNING, plugin.getBundle().getSymbolicName(), message, t));
	}

    public static void logError(Plugin plugin, String message) {
    	log(plugin, new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), message));
    }
    
    public static void logError(Plugin plugin, Throwable t) {
    	log(plugin, new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), Messages.DiceLogger_unexpectedError, t));
    }
    
    public static void logError(Plugin plugin, String message, Throwable t) {
    	log(plugin, new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), message, t));
    }

    public static void logException(Plugin plugin, Exception e) {
    	logError(plugin, e);
    }
    
    public static void logException(Plugin plugin, String message, Exception e) {
    	logError(plugin, message, e);
    }
}
