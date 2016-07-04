package es.unizar.disco.simulation.ui.views;

import java.awt.Desktop;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IDE.SharedImages;
import org.eclipse.ui.part.ViewPart;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.editors.RootedReadOnlyEcoreEditor;
import es.unizar.disco.simulation.ui.launcher.providers.DelegatedColumnLabelProvider;

public class InvocationsView extends ViewPart {

	public static final String ID = "es.unizar.disco.simulation.ui.views.InvocationsView";

	private static final String UNKNOWN = "<Unknown>";

	private static final int COLUMN_RIGHT_MARGIN = 20;

	private TableViewer viewer;

	private Action newViewAction;

	private Action refreshAction;

	private Action clearRegistryAction;

	private Action saveRegistryAction;

	private Action linkFolderAsProjectAction;

	private Action openFolderAction;

	private Action openInvocationAction;

	private Action exportVariablesAction;

	private EContentAdapter contentAdapter = new EContentAdapter() {
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);
			if (notification.getFeature() == InvocationPackage.Literals.SIMULATION_INVOCATION__START
					|| notification.getFeature() == InvocationPackage.Literals.SIMULATION_INVOCATION__END
					|| notification.getFeature() == InvocationPackage.Literals.SIMULATION_INVOCATION__STATUS) {
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						viewer.update(notification.getNotifier(), null);
					}
				});
			}
		};
	};

	public void createPartControl(Composite parent) {

		viewer = new TableViewer(parent, SWT.SINGLE | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);

		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);

		final AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		final TableViewerColumn idViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		idViewerColumn.setLabelProvider(new IdColumnLabelProvider(labelProvider));
		idViewerColumn.getColumn().setText("Identifier");
		idViewerColumn.getColumn().setWidth(280);

		final TableViewerColumn startViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		startViewerColumn.setLabelProvider(new StartColumnLabelProvider(labelProvider));
		startViewerColumn.getColumn().setText("Started");
		startViewerColumn.getColumn().setWidth(180);

		final TableViewerColumn endViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		endViewerColumn.setLabelProvider(new EndColumnLabelProvider(labelProvider));
		endViewerColumn.getColumn().setText("Finished");
		endViewerColumn.getColumn().setWidth(180);

		final TableViewerColumn statusViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		statusViewerColumn.setLabelProvider(new StatusColumnLabelProvider(labelProvider));
		statusViewerColumn.getColumn().setText("Status");
		statusViewerColumn.getColumn().setWidth(80);

		final TableViewerColumn scenarioViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		scenarioViewerColumn.setLabelProvider(new ScenarioColumnLabelProvider(labelProvider));
		scenarioViewerColumn.getColumn().setText("Scenario");
		scenarioViewerColumn.getColumn().setWidth(400);

		final TableViewerColumn modelViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		modelViewerColumn.setLabelProvider(new ModelColumnLabelProvider(labelProvider));
		modelViewerColumn.getColumn().setText("Resource");
		modelViewerColumn.getColumn().setWidth(400);

		// @formatter:off
		viewer.setContentProvider(new ObservableListContentProvider());
		viewer.setInput(EMFObservables.observeList(SimulationInvocationsRegistry.INSTANCE.getRegistry(), InvocationPackage.Literals.INVOCATIONS_REGISTRY__INVOCATIONS));
		// @formatter:on

		boolean pack = !SimulationInvocationsRegistry.INSTANCE.getRegistry().getInvocations().isEmpty();
		for (TableColumn column : viewer.getTable().getColumns()) {
			column.setMoveable(true);
			if (pack) {
				column.pack();
				column.setWidth(column.getWidth() + COLUMN_RIGHT_MARGIN);
			}
		}

		// Handle changes in the registry
		SimulationInvocationsRegistry.INSTANCE.getResourceSet().eAdapters().add(contentAdapter);
		viewer.getControl().addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				SimulationInvocationsRegistry.INSTANCE.getResourceSet().eAdapters().remove(contentAdapter);
			}
		});

		getSite().setSelectionProvider(viewer);

		makeActions();
		hookDoubleClickAction();
		hookContextMenu();
		contributeToActionBars();
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(clearRegistryAction);
		manager.add(saveRegistryAction);
		manager.add(openFolderAction);
		manager.add(linkFolderAsProjectAction);
		manager.add(new Separator());
		manager.add(refreshAction);
		manager.add(new Separator());
		manager.add(newViewAction);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(clearRegistryAction);
		manager.add(new Separator());
		manager.add(openFolderAction);
		manager.add(new Separator());
		manager.add(newViewAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(exportVariablesAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void makeActions() {
		newViewAction = new Action() {
			public void run() {
				IWorkbenchPage page = getSite().getPage();
				try {
					page.showView(ID, UUID.randomUUID().toString(), IWorkbenchPage.VIEW_ACTIVATE);
				} catch (PartInitException e) {
					DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
				}
			}
		};
		newViewAction.setText("New Invocation Registry View");
		newViewAction.setToolTipText("Opens a new instance of this view");
		newViewAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));

		clearRegistryAction = new Action() {
			public void run() {
				SimulationInvocationsRegistry.INSTANCE.clear();
			}
		};
		clearRegistryAction.setText("Delete Registry");
		clearRegistryAction.setToolTipText("Deletes all de entries and files currently shown in this registry");
		clearRegistryAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_REMOVEALL));

		saveRegistryAction = new Action() {
			public void run() {
				try {
					SimulationInvocationsRegistry.INSTANCE.save();
				} catch (IOException e) {
					ErrorDialog.openError(getSite().getShell(), "Error", "Unable to save registry",
							new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
				}
			}
		};
		saveRegistryAction.setText("Save Registry");
		saveRegistryAction.setToolTipText("Writes the changes in the registry on disk");
		saveRegistryAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));

		linkFolderAsProjectAction = new Action() {
			public void run() {
				InputDialog dialog = new InputDialog(getSite().getShell(), "Project name", "Name for the project", null, new IInputValidator() {
					@Override
					public String isValid(String newText) {
						if (StringUtils.isBlank(newText)) {
							return "Project name cannot be blank";
						} else if (ResourcesPlugin.getWorkspace().getRoot().getProject("/" + newText).exists()) {
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
							IFolder registry = project.getFolder(SimulationInvocationsRegistry.REGISTRY_DIRECTORY_LOCATION.lastSegment());
							IFile file = project.getFile(SimulationInvocationsRegistry.REGISTRY_LOCATION.lastSegment());
							try {
								project.create(subMonitor.newChild(1));
								project.open(subMonitor.newChild(1));
								registry.createLink(SimulationInvocationsRegistry.REGISTRY_DIRECTORY_LOCATION, IResource.NONE, subMonitor.newChild(1));
								file.createLink(SimulationInvocationsRegistry.REGISTRY_LOCATION, IResource.NONE, subMonitor.newChild(1));
							} catch (CoreException e) {
								return new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e);
							}
							return Status.OK_STATUS;
						}
					};
					job.schedule();
					try {
						job.join();
					} catch (InterruptedException e) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable to create project",
								new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
					}
					if (!job.getResult().isOK()) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable to create project", job.getResult());
					}
				}
			}

			@Override
			public boolean isEnabled() {
				return Desktop.isDesktopSupported();
			}
		};
		linkFolderAsProjectAction.setText("Link Registry in New Project");
		linkFolderAsProjectAction.setToolTipText("Creates a Project with its contents linked to the registry contents");
		linkFolderAsProjectAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(SharedImages.IMG_OBJ_PROJECT));

		openFolderAction = new Action() {
			public void run() {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.open(SimulationInvocationsRegistry.BASE_LOCATION.toFile());
					} catch (IOException e) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable open folder",
								new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
					}
				}
			}

			@Override
			public boolean isEnabled() {
				return Desktop.isDesktopSupported();
			}
		};
		openFolderAction.setText("Open Registry Directory");
		openFolderAction.setToolTipText("Open the folder containing the registry files in using the system's file browser");
		openFolderAction
				.setImageDescriptor(DiceSimulationUiPlugin.getDefault().getImageRegistry().getDescriptor(DiceSimulationUiPlugin.IMG_ETOOL16_GO_TO_FOLDER));

		refreshAction = new Action() {
			public void run() {
				viewer.refresh(true);
			}
		};
		refreshAction.setText("Refresh viewer");
		refreshAction.setToolTipText("Forces a refresh of the viewer's contents");
		refreshAction.setImageDescriptor(DiceSimulationUiPlugin.getDefault().getImageRegistry().getDescriptor(DiceSimulationUiPlugin.IMG_ETOOL16_REFRESH));

		openInvocationAction = new Action() {
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				SimulationInvocation invocation = (SimulationInvocation) selection.getFirstElement();
				IWorkbench workbench = PlatformUI.getWorkbench();
				IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
				try {
					SimulationInvocationsRegistry.INSTANCE.save();
					page.openEditor(new URIEditorInput(EcoreUtil.getURI(invocation)), RootedReadOnlyEcoreEditor.ID);
				} catch (IOException e) {
					ErrorDialog.openError(getSite().getShell(), "Error", "Unable to save registry data",
							new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
				} catch (PartInitException e) {
					ErrorDialog.openError(getSite().getShell(), "Error", "Unable open Simulation Invocation",
							new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
				}
			}
		};
		openInvocationAction.setText("Open Simulation Invocation");
		openInvocationAction.setToolTipText("Opens the Simulation invocation in the Ecore Reflective editor");
		openInvocationAction
				.setImageDescriptor(DiceSimulationUiPlugin.getDefault().getImageRegistry().getDescriptor(DiceSimulationUiPlugin.IMG_OBJ16_EMF_EDITOR));

		exportVariablesAction = new Action() {
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				SimulationInvocation invocation = (SimulationInvocation) selection.getFirstElement();
				SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
				dialog.setBlockOnOpen(true);
				if (dialog.open() == Window.OK) {
					IPath path = dialog.getResult();
					Resource resource = new XMIResourceImpl(URI.createFileURI(path.toFile().toString()));
					resource.getContents().addAll(EcoreUtil.copyAll(invocation.getVariableConfiguration().toPrimitiveAssignments()));
					try {
						resource.save(Collections.emptyMap());
					} catch (IOException e) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Error saving variable values",
								new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
					}
				}

			}
		};
		exportVariablesAction.setText("Export Invocation Variables...");
		exportVariablesAction.setToolTipText("Exports the Simulation Invocation Variables to an XMI file");
		exportVariablesAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));

	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				openInvocationAction.run();
			}
		});
	}

	private void hookContextMenu() {
		MenuManager manager = new MenuManager("#PopupMenu");
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		Menu menu = manager.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(manager, viewer);
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private class ModelColumnLabelProvider extends InvocationColumnLabelProvider {

		public ModelColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		protected String doGetText(SimulationInvocation invocation) {
			try {
				return invocation.getDefinition().getDomainResource().getUri().toString();
			} catch (Throwable t) {
				return UNKNOWN;
			}
		}
	}

	private class StartColumnLabelProvider extends InvocationColumnLabelProvider {
		public StartColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		protected String doGetText(SimulationInvocation invocation) {
			return invocation.getStart() != null ? invocation.getStart().toString() : UNKNOWN;
		}
	}

	private class EndColumnLabelProvider extends InvocationColumnLabelProvider {
		public EndColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		protected String doGetText(SimulationInvocation invocation) {
			return invocation.getEnd() != null ? invocation.getEnd().toString() : UNKNOWN;
		}
	}

	private class IdColumnLabelProvider extends InvocationColumnLabelProvider {
		public IdColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		protected String doGetText(SimulationInvocation invocation) {
			return invocation.getIdentifier();
		}

		@Override
		public Image getImage(Object element) {
			return labelProvider.getImage(element);
		}
	}

	private class ScenarioColumnLabelProvider extends InvocationColumnLabelProvider {
		public ScenarioColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		protected String doGetText(SimulationInvocation invocation) {
			try {
				EcoreUtil.resolveAll(invocation);
				return labelProvider.getText(invocation.getDefinition().getActiveScenario());
			} catch (Throwable t) {
				return "<Unknown>";
			}
		}

		@Override
		public Image doGetImage(SimulationInvocation invocation) {
			try {
				EcoreUtil.resolveAll(invocation);
				return labelProvider.getImage(invocation.getDefinition().getActiveScenario());
			} catch (Throwable t) {
				return null;
			}
		}
	}

	private class StatusColumnLabelProvider extends InvocationColumnLabelProvider {
		public StatusColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		protected String doGetText(SimulationInvocation invocation) {
			return invocation.getStatus().getLiteral();
		}

		@Override
		protected Image doGetImage(SimulationInvocation invocation) {
			switch (invocation.getStatus().getValue()) {
				case SimulationStatus.FINISHED_VALUE:
					return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_FINISHED);
				case SimulationStatus.FAILED_VALUE:
				case SimulationStatus.KILLED_VALUE:
					return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_FAILED);
				case SimulationStatus.RUNNING_VALUE:
					return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_RUNNING);
				case SimulationStatus.WAITING_VALUE:
					return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_WAITING);
				case SimulationStatus.UNKNOWN_VALUE:
				default:
					return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_UNKNOWN);
			}
		}
	}

	private abstract class InvocationColumnLabelProvider extends DelegatedColumnLabelProvider {

		public InvocationColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		public String getText(Object element) {
			return this.doGetText((SimulationInvocation) element);
		}

		@Override
		public Image getImage(Object element) {
			return this.doGetImage((SimulationInvocation) element);
		}

		protected String doGetText(SimulationInvocation invocation) {
			return super.getText(invocation);
		}

		protected Image doGetImage(SimulationInvocation invocation) {
			return null;
		}
	}
}
