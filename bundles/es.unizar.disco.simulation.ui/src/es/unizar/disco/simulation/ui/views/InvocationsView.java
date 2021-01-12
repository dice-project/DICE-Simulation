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
package es.unizar.disco.simulation.ui.views;

import java.text.MessageFormat;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
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
import es.unizar.disco.simulation.ui.launcher.providers.DelegatedColumnLabelProvider;

public class InvocationsView extends ViewPart {


	public static final String ID = "es.unizar.disco.simulation.ui.views.InvocationsView";

	private static final String STATE_TOGGLE = "org.eclipse.ui.commands.toggleState";

	private static final String COMMAND_SHOW_VIEW_ON_CHANGE = "es.unizar.disco.simulation.ui.commands.showViewOnChange";

	private static final String COMMAND_OPEN_RESULT = "es.unizar.disco.simulation.ui.commands.openSimulationResult";

	private static final String UNKNOWN = "<Unknown>";

	private TreeViewer invocationsViewer;

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
							if (visibleOnChange()) {
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
			// Although the dummy column cannot be moved, the other columns can.
			// This Move Listener ensures that if a column is moved to the right
			// of the dummy column, the position of the dummy column is restored
			@Override
			public void handleEvent(Event event) {
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

		hookDoubleClickAction();
		hookContextMenu();
	}

	private boolean visibleOnChange() {
		ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		Command command = service.getCommand(COMMAND_SHOW_VIEW_ON_CHANGE);
		return (boolean) command.getState(STATE_TOGGLE).getValue();
	}
	
	private void hookDoubleClickAction() {
		invocationsViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				try {
					IHandlerService service = (IHandlerService) getSite().getService(IHandlerService.class);
					service.executeCommand(COMMAND_OPEN_RESULT, null);
				} catch (ExecutionException | NotDefinedException | NotEnabledException | NotHandledException e) {
					ErrorDialog.openError(getSite().getShell(), "Error", "Unable to open the Simulation Result",
							new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
				}
			}
		});
	}

	private void hookContextMenu() {
		MenuManager manager = new MenuManager();
		Menu menu = manager.createContextMenu(invocationsViewer.getControl());
		invocationsViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(manager, invocationsViewer);
	}

	public void setFocus() {
		invocationsViewer.getControl().setFocus();
	}

	public void refresh() {
		invocationsViewer.refresh(true);
	}
	
	
	private class AbstractColumnLabelProvider extends DelegatedColumnLabelProvider {
		public AbstractColumnLabelProvider(ILabelProvider delegatedLabelProvider) {
			super(delegatedLabelProvider);
		}
		
		@Override
		public Color getBackground(Object element) {
			if (element instanceof InvocationSet) {
				return getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			}
			return super.getBackground(element);
		}
		
		@Override
		public Color getForeground(Object element) {
			if (element instanceof InvocationSet) {
				return getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_INFO_FOREGROUND);
			}
			return super.getForeground(element);
		}
	}
	
	private class IdColumnLabelProvider extends AbstractColumnLabelProvider {
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
					return MessageFormat.format("{0} [{1}]", labelProvider.getText(set.getDefinition().getActiveScenario()), set.getIdentifier());
				} catch (Throwable t) {
					DiceLogger.logError(DiceSimulationUiPlugin.getDefault(), t);
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
					DiceLogger.logError(DiceSimulationUiPlugin.getDefault(), t);
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
				DiceLogger.logError(DiceSimulationUiPlugin.getDefault(), t);
			}
			return null;
		}
	}

	private class StartColumnLabelProvider extends AbstractColumnLabelProvider {
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
	}

	private class EndColumnLabelProvider extends AbstractColumnLabelProvider {
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
	}

	private class StatusColumnLabelProvider extends AbstractColumnLabelProvider {
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
		
		@Override
		public Color getForeground(Object element) {
			if (element instanceof InvocationSet) {
				return getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_INFO_FOREGROUND);
			}
			return super.getForeground(element);
		}
	}

	private class TreeFactoryImpl implements IObservableFactory<Object, IObservableList<?>> {
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

	private class TreeStructureAdvisorImpl extends TreeStructureAdvisor {
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
