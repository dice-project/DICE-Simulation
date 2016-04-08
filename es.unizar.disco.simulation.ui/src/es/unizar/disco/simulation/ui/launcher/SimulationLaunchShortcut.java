package es.unizar.disco.simulation.ui.launcher;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.launcher.SimulationLaunchConfigurationDelegate;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class SimulationLaunchShortcut implements ILaunchShortcut {

	@Override
	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				launch(structuredSelection.getFirstElement(), mode);
			}
		}
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		IEditorInput input = editor.getEditorInput();
		IFile file = (IFile) input.getAdapter(IFile.class);
		if (file != null) {
			launch(file, mode);
		}
	}

	protected void launch(Object type, String mode) {
		UmlModel model = type instanceof UmlModel ? (UmlModel) type : ((IAdaptable) type).getAdapter(UmlModel.class);
		if (model == null) {
			DiceLogger.logError(DiceSimulationUiPlugin.getDefault(),
					MessageFormat.format(Messages.SimulationLaunchShortcut_unexpectedArgError, 
					DiceSimulationPlugin.SIMULATION_LAUNCH_CONFIGURATION_TYPE,model));
			return;
		}
		
		if (!ILaunchManager.RUN_MODE.equals(mode)) {
			DiceLogger.logWarning(DiceSimulationUiPlugin.getDefault(),
					MessageFormat.format(Messages.SimulationLaunchShortcut_unknownModeError, mode, model));
		}

		try {
            ILaunchConfiguration launchConfiguration = findLaunchConfiguration(model, mode);
            if (launchConfiguration != null) {
				Shell shell =  PlatformUI.getWorkbench().getDisplay().getActiveShell();
				DebugUITools.openLaunchConfigurationDialogOnGroup(
						shell, new StructuredSelection(launchConfiguration), IDebugUIConstants.ID_RUN_LAUNCH_GROUP, null);
			} 
        } catch (CoreException e) {
        	DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
        }
    }

	
	protected ILaunchConfiguration findLaunchConfiguration(UmlModel model, String mode) throws CoreException {
		
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		
		ILaunchConfigurationType simLaunchConfigurationType = launchManager.getLaunchConfigurationType(DiceSimulationPlugin.SIMULATION_LAUNCH_CONFIGURATION_TYPE);
		
		ILaunchConfiguration[] existingConfigs = launchManager.getLaunchConfigurations(simLaunchConfigurationType);
		
		// We search through the existing configurations if the actual configuration has been previously defined
		for (ILaunchConfiguration previousConfiguration : existingConfigs) {
			String previousFile = previousConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.INPUT_FILE, StringUtils.EMPTY); 
			if (previousFile.equals(model.getURI().toString())) {
				return previousConfiguration;
			}
		}
		
		String name = model.getURI().trimFileExtension().lastSegment();
		String casedName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		ILaunchConfigurationWorkingCopy launchConf = simLaunchConfigurationType.newInstance(null, casedName);
		launchConf.setAttribute(SimulationLaunchConfigurationDelegate.INPUT_FILE, model.getURI().toString());
		ILaunchConfiguration result = launchConf.doSave();
		
		return result;
	}
}