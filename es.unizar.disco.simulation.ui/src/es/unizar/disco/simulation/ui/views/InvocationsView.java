package es.unizar.disco.simulation.ui.views;

import java.awt.Desktop;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
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
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
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
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.models.invocation.InvocationsRegistry;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.editors.RootedReadOnlyEcoreEditor;
import es.unizar.disco.simulation.ui.launcher.providers.DelegatedColumnLabelProvider;

public class InvocationsView extends ViewPart {

	public static final String ID = "es.unizar.disco.simulation.ui.views.InvocationsView";

	private static final String UNKNOWN = "<Unknown>";

	private volatile boolean visibleOnChange = true;

	private TreeViewer invocationsViewer;

	private Action newViewAction;

	private Action refreshAction;

	private Action makeVisibleAction;

	private Action clearRegistryAction;

	private Action saveRegistryAction;

	private Action linkFolderAsProjectAction;

	private Action openFolderAction;

	private Action openResultAction;

	private Action openInvocationAction;

	private Action exportVariablesAction;

	private EContentAdapter contentAdapter = new EContentAdapter() {
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);
			if (notification.getNotifier() instanceof InvocationSet
					&& notification.getFeature() == InvocationPackage.Literals.INVOCATION_SET__INVOCATIONS) {
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						invocationsViewer.refresh(notification.getNotifier(), true);
					}
				});
			}
			if (notification.getNotifier() instanceof SimulationInvocation
					&& (notification.getFeature() == InvocationPackage.Literals.SIMULATION_INVOCATION__START
							|| notification.getFeature() == InvocationPackage.Literals.SIMULATION_INVOCATION__END
							|| notification.getFeature() == InvocationPackage.Literals.SIMULATION_INVOCATION__STATUS)) {
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						SimulationInvocation invocation = (SimulationInvocation) notification.getNotifier();
						invocationsViewer.update(invocation.getInvocationSet(), null);
						invocationsViewer.update(invocation, null);
						invocationsViewer.setExpandedState(invocation.getInvocationSet(), true);
						invocationsViewer.reveal(invocation);
						if (getSite() != null) {
							IWorkbenchSiteProgressService service = getSite()
									.getAdapter(IWorkbenchSiteProgressService.class);
							if (service != null) {
								service.warnOfContentChange();
							}
							if (visibleOnChange) {
								getSite().getPage().activate(getSite().getPart());
							}
						}
					}
				});
			}
		};
	};

	public void createPartControl(Composite parent) {

		invocationsViewer = new TreeViewer(parent, SWT.SINGLE | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);

		invocationsViewer.getTree().setLinesVisible(true);
		invocationsViewer.getTree().setHeaderVisible(true);

		final AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		final TreeViewerColumn idViewerColumn = new TreeViewerColumn(invocationsViewer, SWT.NONE);
		idViewerColumn.setLabelProvider(new IdColumnLabelProvider(labelProvider));
		idViewerColumn.getColumn().setText("Simulation");
		idViewerColumn.getColumn().setWidth(500);
		idViewerColumn.getColumn().setMoveable(true);

		final TreeViewerColumn startViewerColumn = new TreeViewerColumn(invocationsViewer, SWT.NONE);
		startViewerColumn.setLabelProvider(new StartColumnLabelProvider(labelProvider));
		startViewerColumn.getColumn().setText("Started");
		startViewerColumn.getColumn().setWidth(180);
		startViewerColumn.getColumn().setMoveable(true);

		final TreeViewerColumn endViewerColumn = new TreeViewerColumn(invocationsViewer, SWT.NONE);
		endViewerColumn.setLabelProvider(new EndColumnLabelProvider(labelProvider));
		endViewerColumn.getColumn().setText("Finished");
		endViewerColumn.getColumn().setWidth(180);
		endViewerColumn.getColumn().setMoveable(true);

		final TreeViewerColumn statusViewerColumn = new TreeViewerColumn(invocationsViewer, SWT.NONE);
		statusViewerColumn.setLabelProvider(new StatusColumnLabelProvider(labelProvider));
		statusViewerColumn.getColumn().setText("Status");
		statusViewerColumn.getColumn().setWidth(80);
		statusViewerColumn.getColumn().setMoveable(true);

		final TreeViewerColumn dummyViewerColumn = new TreeViewerColumn(invocationsViewer, SWT.NONE);
		dummyViewerColumn.setLabelProvider(new DummyColumnLabelProvider());
		dummyViewerColumn.getColumn().setMoveable(false);
		dummyViewerColumn.getColumn().setResizable(false);

		{
			// We use a dummy last column and we compute its size manually
			// since:
			//
			// 1- If we use a normal layout, the background of the rows is only
			// limited to the areas covered by a LabelProvider (i.e. an empty
			// white space is left at the end of the row)
			//
			// 2- When using a TreeColumnLayout, rows cannot exceed the Tree's
			// size
			//
			Listener resizeListener = new Listener() {
				@Override
				public void handleEvent(Event event) {
					computeDummyColumnSize();
				}

				private void computeDummyColumnSize() {
					Tree tree = invocationsViewer.getTree();
					TreeColumn[] columns = tree.getColumns();
					TreeColumn dummyColumn = columns[columns.length - 1];
					int width = tree.getSize().x;
					for (int i = 0; i < columns.length - 1; i++) {
						width -= columns[i].getWidth();
					}
					if (width >= 0) {
						dummyColumn.setWidth(width);
					}
				}
			};

			idViewerColumn.getColumn().addListener(SWT.Resize, resizeListener);
			startViewerColumn.getColumn().addListener(SWT.Resize, resizeListener);
			endViewerColumn.getColumn().addListener(SWT.Resize, resizeListener);
			statusViewerColumn.getColumn().addListener(SWT.Resize, resizeListener);
			invocationsViewer.getTree().addListener(SWT.Resize, resizeListener);
		}

		dummyViewerColumn.getColumn().addListener(SWT.Move, new Listener() {
			@Override
			public void handleEvent(Event event) {
				// Although the dummy column cannot be moved, the other columns can.
				// This Move Listener ensures that if a column is moved to the right
				// of the dummy column, the position of the dummy column is restored
				int[] orders = invocationsViewer.getTree().getColumnOrder();
				int dummyMovedTo = -1;
				for (int i = 0; i < orders.length; i++) {
					if (orders[i] == orders.length - 1) {
						dummyMovedTo = i;
						break;
					}
				}
				if (dummyMovedTo != orders.length - 1) {
					orders[dummyMovedTo] = orders[orders.length - 1];
					orders[orders.length - 1] = orders.length - 1;
					invocationsViewer.getTree().setColumnOrder(orders);
				}
			}
		});
		
		ColumnViewerToolTipSupport.enableFor(invocationsViewer);

		// @formatter:off
		invocationsViewer.setContentProvider(
				new ObservableListTreeContentProvider(new TreeFactoryImpl(), new TreeStructureAdvisorImpl()));
		invocationsViewer.setInput(EMFObservables.observeList(SimulationInvocationsRegistry.INSTANCE.getRegistry(),
				InvocationPackage.Literals.INVOCATIONS_REGISTRY__INVOCATION_SETS));
		// @formatter:on

		// Handle changes in the registry
		SimulationInvocationsRegistry.INSTANCE.getResourceSet().eAdapters().add(contentAdapter);
		invocationsViewer.getControl().addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				SimulationInvocationsRegistry.INSTANCE.getResourceSet().eAdapters().remove(contentAdapter);
			}
		});

		getSite().setSelectionProvider(invocationsViewer);

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
		manager.add(makeVisibleAction);
		manager.add(newViewAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(openResultAction);
		manager.add(openInvocationAction);
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
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
		newViewAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));

		clearRegistryAction = new Action() {
			public void run() {
				SimulationInvocationsRegistry.INSTANCE.clear();
			}
		};
		clearRegistryAction.setText("Delete Registry");
		clearRegistryAction.setToolTipText("Deletes all de entries and files currently shown in this registry");
		clearRegistryAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_REMOVEALL));

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
		saveRegistryAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));

		linkFolderAsProjectAction = new Action() {
			public void run() {
				InputDialog dialog = new InputDialog(getSite().getShell(), "Project name", "Name for the project", null,
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
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable to create project", new Status(
								IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
					}
					if (!job.getResult().isOK()) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable to create project",
								job.getResult());
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
		linkFolderAsProjectAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(SharedImages.IMG_OBJ_PROJECT));

		openFolderAction = new Action() {
			public void run() {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.open(SimulationInvocationsRegistry.BASE_LOCATION.toFile());
					} catch (IOException e) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable open folder", new Status(
								IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
					}
				}
			}

			@Override
			public boolean isEnabled() {
				return Desktop.isDesktopSupported();
			}
		};
		openFolderAction.setText("Open Registry Directory");
		openFolderAction
				.setToolTipText("Open the folder containing the registry files in using the system's file browser");
		openFolderAction.setImageDescriptor(DiceSimulationUiPlugin.getDefault().getImageRegistry()
				.getDescriptor(DiceSimulationUiPlugin.IMG_ETOOL16_GO_TO_FOLDER));

		refreshAction = new Action() {
			public void run() {
				invocationsViewer.refresh(true);
			}
		};
		refreshAction.setText("Refresh Viewer");
		refreshAction.setToolTipText("Forces a refresh of the viewer's contents");
		refreshAction.setImageDescriptor(DiceSimulationUiPlugin.getDefault().getImageRegistry()
				.getDescriptor(DiceSimulationUiPlugin.IMG_ETOOL16_REFRESH));

		makeVisibleAction = new Action() {

			@Override
			public int getStyle() {
				return IAction.AS_CHECK_BOX;
			}

			@Override
			public void setChecked(boolean checked) {
				visibleOnChange = !visibleOnChange;
			}

			@Override
			public boolean isChecked() {
				return visibleOnChange;
			}
		};
		makeVisibleAction.setText("Show View on Change");
		makeVisibleAction.setToolTipText("Show view when contents change");
		makeVisibleAction.setImageDescriptor(DiceSimulationUiPlugin.getDefault().getImageRegistry()
				.getDescriptor(DiceSimulationUiPlugin.IMG_ETOOL16_MAKE_VISIBLE));

		openInvocationAction = new Action() {
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) invocationsViewer.getSelection();
				if (selection.getFirstElement() instanceof SimulationInvocation) {
					SimulationInvocation invocation = (SimulationInvocation) selection.getFirstElement();
					IWorkbench workbench = PlatformUI.getWorkbench();
					IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
					try {
						SimulationInvocationsRegistry.INSTANCE.save();
						page.openEditor(new URIEditorInput(EcoreUtil.getURI(invocation)), RootedReadOnlyEcoreEditor.ID);
					} catch (IOException e) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable to save registry data", new Status(
								IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
					} catch (PartInitException e) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable open Simulation Invocation",
								new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(),
										e));
					}
				}
			}
		};
		openInvocationAction.setText("Inspect Simulation Invocation Data");
		openInvocationAction.setToolTipText("Opens the Simulation invocation in the Ecore Reflective editor");
		openInvocationAction.setImageDescriptor(DiceSimulationUiPlugin.getDefault().getImageRegistry()
				.getDescriptor(DiceSimulationUiPlugin.IMG_OBJ16_SIMULATION_INVOCATION));

		openResultAction = new Action() {
			{
				invocationsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) invocationsViewer.getSelection();
						if (!selection.isEmpty() && selection.getFirstElement() instanceof SimulationInvocation) {
							SimulationInvocation invocation = (SimulationInvocation) selection.getFirstElement();
							if (invocation.getResult() == null) {
								setEnabled(false);
							} else {
								setEnabled(true);
							}
						}
					}
				});
			}

			public void run() {
				IStructuredSelection selection = (IStructuredSelection) invocationsViewer.getSelection();
				if (selection.getFirstElement() instanceof SimulationInvocation) {
					SimulationInvocation invocation = (SimulationInvocation) selection.getFirstElement();
					if (invocation.getResult() == null) {
						return;
					}
					IWorkbench workbench = PlatformUI.getWorkbench();
					IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
					try {
						SimulationInvocationsRegistry.INSTANCE.save();
						page.openEditor(new URIEditorInput(EcoreUtil.getURI(invocation.getResult())),
								RootedReadOnlyEcoreEditor.ID);
					} catch (IOException e) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable to save registry data", new Status(
								IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
					} catch (PartInitException e) {
						ErrorDialog.openError(getSite().getShell(), "Error", "Unable open Simulation Results",
								new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(),
										e));
					}
				}
			}
		};
		openResultAction.setText("Open Simulation Result");
		openResultAction.setToolTipText("Opens the Simulation result in the Ecore Reflective editor");
		openResultAction.setImageDescriptor(DiceSimulationUiPlugin.getDefault().getImageRegistry()
				.getDescriptor(DiceSimulationUiPlugin.IMG_OBJ16_SIMULATION_RESULT));

		exportVariablesAction = new Action() {
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) invocationsViewer.getSelection();
				if (selection.getFirstElement() instanceof SimulationInvocation) {
					SimulationInvocation invocation = (SimulationInvocation) selection.getFirstElement();
					SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
					dialog.setBlockOnOpen(true);
					if (dialog.open() == Window.OK) {
						IPath path = dialog.getResult();
						Resource resource = new XMIResourceImpl(URI.createFileURI(path.toFile().toString()));
						resource.getContents().addAll(
								EcoreUtil.copyAll(invocation.getVariableConfiguration().toPrimitiveAssignments()));
						try {
							resource.save(Collections.emptyMap());
						} catch (IOException e) {
							ErrorDialog.openError(getSite().getShell(), "Error", "Error saving variable values",
									new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(),
											e));
						}
					}
				}
			}
		};
		exportVariablesAction.setText("Export Invocation Variables...");
		exportVariablesAction.setToolTipText("Exports the Simulation Invocation Variables to an XMI file");
		exportVariablesAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));

	}

	private void hookDoubleClickAction() {
		invocationsViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				openResultAction.run();
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
		Menu menu = manager.createContextMenu(invocationsViewer.getControl());
		invocationsViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(manager, invocationsViewer);
	}

	public void setFocus() {
		invocationsViewer.getControl().setFocus();
	}

	private class IdColumnLabelProvider extends DelegatedColumnLabelProvider {
		public IdColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof SimulationInvocation) {
				SimulationInvocation invocation = (SimulationInvocation) element;
				return invocation.getIdentifier();
			} else if (element instanceof InvocationSet) {
				InvocationSet set = (InvocationSet) element;
				EcoreUtil.resolveAll(set);
				try {
					return labelProvider.getText(set.getDefinition().getActiveScenario());
				} catch (Throwable t) {
				}
			}
			return null;
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof SimulationInvocation) {
				return labelProvider.getImage(element);
			} else if (element instanceof InvocationSet) {
				try {
					EcoreUtil.resolveAll((EObject) element);
					InvocationSet set = (InvocationSet) element;
					return labelProvider.getImage(set.getDefinition().getActiveScenario());
				} catch (Throwable t) {
				}
			}
			return null;
		}

		@Override
		public String getToolTipText(Object element) {
			try {
				if (element instanceof SimulationInvocation) {
					SimulationInvocation invocation = (SimulationInvocation) element;
					return invocation.getDefinition().getDomainResource().getUri().toString();
				} else if (element instanceof InvocationSet) {
					InvocationSet set = (InvocationSet) element;
					return set.getDefinition().getDomainResource().getUri().toString();
				}
			} catch (Throwable t) {
			}
			return null;
		}

		@Override
		public Color getBackground(Object element) {
			if (element instanceof InvocationSet) {
				return getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			}
			return super.getBackground(element);
		}
	}

	private class StartColumnLabelProvider extends DelegatedColumnLabelProvider {
		public StartColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof SimulationInvocation) {
				SimulationInvocation invocation = (SimulationInvocation) element;
				return invocation.getStart() != null ? invocation.getStart().toString() : UNKNOWN;
			} else if (element instanceof InvocationSet) {
				InvocationSet set = (InvocationSet) element;
				return set.getStart() != null ? set.getStart().toString() : UNKNOWN;
			}
			return null;
		}

		@Override
		public Image getImage(Object element) {
			return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_CLOCK);
		}

		@Override
		public Color getBackground(Object element) {
			if (element instanceof InvocationSet) {
				return getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			}
			return super.getBackground(element);
		}
	}

	private class EndColumnLabelProvider extends DelegatedColumnLabelProvider {
		public EndColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof SimulationInvocation) {
				SimulationInvocation invocation = (SimulationInvocation) element;
				return invocation.getEnd() != null ? invocation.getEnd().toString() : UNKNOWN;
			} else if (element instanceof InvocationSet) {
				InvocationSet set = (InvocationSet) element;
				return set.getEnd() != null ? set.getEnd().toString() : UNKNOWN;
			}
			return null;
		}

		@Override
		public Image getImage(Object element) {
			return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_CLOCK);
		}

		@Override
		public Color getBackground(Object element) {
			if (element instanceof InvocationSet) {
				return getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			}
			return super.getBackground(element);
		}
	}

	private class StatusColumnLabelProvider extends DelegatedColumnLabelProvider {
		public StatusColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof SimulationInvocation) {
				SimulationInvocation invocation = (SimulationInvocation) element;
				return invocation.getStatus().getLiteral();
			} else if (element instanceof InvocationSet) {
				InvocationSet set = (InvocationSet) element;
				return set.getStatus().getLiteral();
			}
			return null;
		}

		@Override
		public Image getImage(Object element) {
			SimulationStatus status = null;
			if (element instanceof SimulationInvocation) {
				SimulationInvocation invocation = (SimulationInvocation) element;
				status = invocation.getStatus();
			} else if (element instanceof InvocationSet) {
				InvocationSet set = (InvocationSet) element;
				status = set.getStatus();
			}
			switch (status) {
			case FINISHED:
				return DiceSimulationUiPlugin.getDefault().getImageRegistry()
						.get(DiceSimulationUiPlugin.IMG_OBJ16_FINISHED);
			case FAILED:
			case KILLED:
				return DiceSimulationUiPlugin.getDefault().getImageRegistry()
						.get(DiceSimulationUiPlugin.IMG_OBJ16_FAILED);
			case RUNNING:
				return DiceSimulationUiPlugin.getDefault().getImageRegistry()
						.get(DiceSimulationUiPlugin.IMG_OBJ16_RUNNING);
			case WAITING:
				return DiceSimulationUiPlugin.getDefault().getImageRegistry()
						.get(DiceSimulationUiPlugin.IMG_OBJ16_WAITING);
			case UNKNOWN:
			default:
				return DiceSimulationUiPlugin.getDefault().getImageRegistry()
						.get(DiceSimulationUiPlugin.IMG_OBJ16_UNKNOWN);
			}
		}

		@Override
		public Color getBackground(Object element) {
			if (element instanceof InvocationSet) {
				return getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			}
			return super.getBackground(element);
		}
	}

	private class DummyColumnLabelProvider extends ColumnLabelProvider {
		
		@Override
		public String getText(Object element) {
			return null;
		}
		
		@Override
		public Color getBackground(Object element) {
			if (element instanceof InvocationSet) {
				return getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			}
			return super.getBackground(element);
		}
	}

	private static class TreeFactoryImpl implements IObservableFactory<Object, IObservableList<?>> {
		@SuppressWarnings("unchecked")
		@Override
		public IObservableList<?> createObservable(Object target) {
			if (target instanceof IObservableList<?>) {
				return (IObservableList<?>) target;
			} else if (target instanceof InvocationsRegistry) {
				return EMFProperties.list(InvocationPackage.eINSTANCE.getInvocationsRegistry_InvocationSets())
						.observe(target);
			} else if (target instanceof InvocationSet) {
				return EMFProperties.list(InvocationPackage.eINSTANCE.getInvocationSet_Invocations()).observe(target);
			}

			return null;
		}
	}

	private static class TreeStructureAdvisorImpl extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {
			if (element instanceof SimulationInvocation) {
				return ((SimulationInvocation) element).getDefinition();
			}
			return null;
		}

		@Override
		public Boolean hasChildren(Object element) {
			if (element instanceof InvocationsRegistry
					&& (((InvocationsRegistry) element).getInvocationSets().size() > 0)) {
				return Boolean.TRUE;
			} else if (element instanceof InvocationSet && (((InvocationSet) element).getInvocations().size() > 0)) {
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
	}
}
