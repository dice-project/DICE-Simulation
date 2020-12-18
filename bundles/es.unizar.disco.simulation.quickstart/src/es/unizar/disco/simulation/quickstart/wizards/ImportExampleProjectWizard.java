/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
package es.unizar.disco.simulation.quickstart.wizards;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.undo.CreateProjectOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.osgi.framework.Bundle;

import es.unizar.disco.pnml.m2m.PnmlM2mPlugin;
import es.unizar.disco.simulation.quickstart.DiceQuickStartUiPlugin;

public class ImportExampleProjectWizard extends Wizard implements INewWizard {

	private static final String EXAMPLES_DIRECTORY = "examples/"; //$NON-NLS-1$

	public static final String WIZARD_ID = "es.unizar.disco.simulation.quickstart.wizards.ExampleProjectWizard"; //$NON-NLS-1$

    private IWorkbench workbench;

    protected IStructuredSelection selection;
	
	private WizardNewProjectCreationPage mainPage;

	private IProject newProject;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
    }
	
	@Override
	public void addPages() {
		super.addPages();

		mainPage = new WizardNewProjectCreationPage("diceNewExampleProjectPage") { //$NON-NLS-1$
			@Override
			public void createControl(Composite parent) {
				super.createControl(parent);
				createWorkingSetGroup((Composite) getControl(), getSelection(),
						new String[] { "org.eclipse.ui.resourceWorkingSetPage" }); //$NON-NLS-1$
				Dialog.applyDialogFont(getControl());
			}
		};
		mainPage.setTitle(Messages.ImportExampleProjectWizard_title);
		mainPage.setDescription(Messages.ImportExampleProjectWizard_description);
		this.addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
		createNewProject();

		if (newProject == null) {
			return false;
		}
		
		populateProject(newProject);

		IWorkingSet[] workingSets = mainPage.getSelectedWorkingSets();
		getWorkbench().getWorkingSetManager().addToWorkingSets(newProject, workingSets);

		BasicNewProjectResourceWizard.selectAndReveal(newProject, getWorkbench().getActiveWorkbenchWindow());
		
		// If active view is maximized and is the "introview", restore it to
		// reveal the newly created project
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        final IViewReference viewRef = page.findViewReference("org.eclipse.ui.internal.introview", null);
        if (viewRef != null && page.getPartState(viewRef) == IWorkbenchPage.STATE_MAXIMIZED) {
            PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
                @Override
                public void run() {
                    page.setPartState(viewRef, IWorkbenchPage.STATE_RESTORED);
                }
            });
        }		
		return true;
	}

	private IProject createNewProject() {
		if (newProject != null) {
			return newProject;
		}

		// Get a project handle
		final IProject newProjectHandle = mainPage.getProjectHandle();

		// Get a project descriptor
		URI location = null;
		if (!mainPage.useDefaults()) {
			location = mainPage.getLocationURI();
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
		description.setLocationURI(location);

		// Create the new project operation
		IRunnableWithProgress op = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				CreateProjectOperation op = new CreateProjectOperation(description, Messages.ImportExampleProjectWizard_operationLabel);
				try {
					op.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
				} catch (ExecutionException e) {
					throw new InvocationTargetException(e);
				}
			}
		};

		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			Throwable t = e.getTargetException();
			if (t instanceof ExecutionException && t.getCause() instanceof CoreException) {
				CoreException cause = (CoreException) t.getCause();
				StatusAdapter status;
				if (cause.getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
					status = new StatusAdapter(new Status(IStatus.WARNING, DiceQuickStartUiPlugin.PLUGIN_ID,
							MessageFormat.format(Messages.ImportExampleProjectWizard_caseInsensitiveExistsError, newProjectHandle.getName()),
							cause));
				} else {
					status = new StatusAdapter(new Status(cause.getStatus().getSeverity(),
							DiceQuickStartUiPlugin.PLUGIN_ID,
							Messages.ImportExampleProjectWizard_generalProblem, 
							cause));
				}
				status.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, Messages.ImportExampleProjectWizard_generalProblem);
				StatusManager.getManager().handle(status, StatusManager.BLOCK);
			} else {
				StatusAdapter status = new StatusAdapter(new Status(IStatus.WARNING, DiceQuickStartUiPlugin.PLUGIN_ID,
						MessageFormat.format(Messages.ImportExampleProjectWizard_internalError, t.getMessage()), t));
				status.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, Messages.ImportExampleProjectWizard_generalProblem);
				StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);
			}
			return null;
		}

		newProject = newProjectHandle;

		return newProject;
	}
	
	private static void populateProject(IProject project) {
		List<String> filePaths = new ArrayList<>();
		Bundle bundle = Platform.getBundle(PnmlM2mPlugin.PLUGIN_ID);
		try {
			File bundleFile = FileLocator.getBundleFile(bundle);
			// Instead of copying directly from the filesystem of the jarred
			// file we list the available files within the EXAMPLES_DIRECTORY
			// (depending on the type of bundle we have, i.e., jarred or
			// unjarred), and we later use the standard Eclipse copy mechanism
			// using FileLocator.openStream(...)
			if (bundleFile.isDirectory()) {
				// It's an unjarred bundle
				File examplesDir = new File(bundleFile.toURI().resolve(EXAMPLES_DIRECTORY));
				for (File listedFile :FileUtils.listFiles(examplesDir, null, true)) {
					filePaths.add(examplesDir.toURI().relativize(listedFile.toURI()).toString());
				}
			} else {
				// It's a jarred bundle
				try (ZipFile zipFile = new ZipFile(bundleFile)) {
					Enumeration<? extends ZipEntry> entries = zipFile.entries();
					while (entries.hasMoreElements()) {
						ZipEntry entry = entries.nextElement();
						if (!entry.isDirectory() && entry.getName().startsWith(EXAMPLES_DIRECTORY)) {
							filePaths.add(entry.getName().replaceFirst(EXAMPLES_DIRECTORY, ""));
						}
					}
				}
			}
			
			// Perform copy from the available file paths
			for (String filePath : filePaths) {
				IFile file = project.getFile(filePath);
				createParents(file);
				file.create(FileLocator.openStream(bundle, new Path(EXAMPLES_DIRECTORY.concat(filePath)), false), true, new NullProgressMonitor());
			}
		} catch (IOException | CoreException e) {
			StatusAdapter status = new StatusAdapter(new Status(IStatus.WARNING, DiceQuickStartUiPlugin.PLUGIN_ID,
					MessageFormat.format(Messages.ImportExampleProjectWizard_internalError, e.getMessage()), e));
			status.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, Messages.ImportExampleProjectWizard_generalProblem);
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);
		}
	}
	
	private static void createParents(IFile file) throws CoreException {
		Stack<IContainer> needsToBeCreated = new Stack<>();
		{
			IContainer parent = file.getParent();
			while (!parent.exists()) {
				needsToBeCreated.push(parent);
				parent = parent.getParent();
			}
		}
		while (!needsToBeCreated.isEmpty()) {
			IContainer container = needsToBeCreated.pop();
			if (container instanceof IFolder) {
				IFolder folder = (IFolder) container;
				folder.create(true, true, new NullProgressMonitor());
			} else {
				throw new CoreException(new Status(IStatus.ERROR, DiceQuickStartUiPlugin.PLUGIN_ID, 
						MessageFormat.format(Messages.ImportExampleProjectWizard_unableCreateContainersError, file.getParent().getRawLocation())));
			}

		}
	}
	
	public IWorkbench getWorkbench() {
		if (workbench == null) {
			workbench = PlatformUI.getWorkbench();
		}
		return workbench;
	}
	
    public IStructuredSelection getSelection() {
        return selection;
    }
}
