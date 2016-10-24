package es.unizar.disco.simulation.ui.views;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class LinkFolderAsProjectHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShellChecked(event);
		InputDialog dialog = new InputDialog(shell, "Project name", "Name for the project", null,
				new IInputValidator() {
					@Override
					public String isValid(String newText) {
						if (StringUtils.isBlank(newText)) {
							return "Project name cannot be blank";
						} else if (ResourcesPlugin.getWorkspace().getRoot().getProject("/" + newText)
								.exists()) {
							return MessageFormat.format("Project ''{0}'' already exists", "/" + newText);
						}
						return null;
					}
				});
		if (dialog.open() == Dialog.OK) {
			final String projectName = dialog.getValue();
			Job job = new Job("Create project") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					SubMonitor subMonitor = SubMonitor.convert(monitor, "Create project", 4);
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
					IFolder registry = project
							.getFolder(SimulationInvocationsRegistry.REGISTRY_DIRECTORY_LOCATION.lastSegment());
					IFile file = project.getFile(SimulationInvocationsRegistry.REGISTRY_LOCATION.lastSegment());
					try {
						project.create(subMonitor.newChild(1));
						project.open(subMonitor.newChild(1));
						registry.createLink(SimulationInvocationsRegistry.REGISTRY_DIRECTORY_LOCATION,
								IResource.NONE, subMonitor.newChild(1));
						file.createLink(SimulationInvocationsRegistry.REGISTRY_LOCATION, IResource.NONE,
								subMonitor.newChild(1));
					} catch (CoreException e) {
						return new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID,
								e.getLocalizedMessage(), e);
					}
					return Status.OK_STATUS;
				}
			};
			job.schedule();
			try {
				job.join();
			} catch (InterruptedException e) {
				ErrorDialog.openError(shell, "Error", "Unable to create project", new Status(
						IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
			}
			if (!job.getResult().isOK()) {
				ErrorDialog.openError(shell, "Error", "Unable to create project",
						job.getResult());
			}
		}		return null;
	}

}
