package es.unizar.disco.simulation.ui.editors;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.stream.Collectors;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.LineStyle;
import org.eclipse.birt.chart.model.attribute.MarkerType;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.type.LineSeries;
import org.eclipse.birt.chart.model.type.impl.LineSeriesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPartConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.statushandlers.StatusManager;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;
import es.unizar.disco.simulation.ui.plot.PlotData;
import es.unizar.disco.simulation.ui.plot.PlotData.Pair;

public class PlotEditor extends MultiPageEditorPart {

	public static final String ID = "es.unizar.disco.simulation.ui.editors.PlotEditor";

	private ChartCanvas canvas;

	private PlotData data;

	private TextEditor textEditor;

	private IResourceChangeListener resourceChangeListener = new EditorResourceChangeListener();

	private Action copyAction = new CopyAction();

	private Action exportAction = new ExportAction();

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (input instanceof IFileEditorInput) {
			setInput(input);
			IFile file = getFileEditorInput().getFile();
			try {
				data = PlotData.deserialize(file.getContents());
			} catch (IOException | CoreException e) {
				throw new PartInitException(MessageFormat.format("Unable to retrieve plot data from ''{0}''", file), e);
			}
		} else {
			throw new PartInitException(MessageFormat.format("Unsupported editor input type ''{0}''", input));
		}
		setSite(site);
		setPartName(input.getName());

		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);

		firePropertyChange(IWorkbenchPartConstants.PROP_INPUT);
		firePropertyChange(IWorkbenchPartConstants.PROP_TITLE);
	}

	@Override
	protected void createPages() {
		{
			// Add page for the chart
			canvas = new ChartCanvas(getContainer(), SWT.NONE);
			ChartBuilder builder = new ChartBuilder(data);
			builder.build();
			canvas.setChart(builder.getChart());
			addPage(canvas);

			MenuManager manager = new MenuManager();
			Menu menu = manager.createContextMenu(canvas);
			canvas.setMenu(menu);
			manager.add(copyAction);
			manager.add(new Separator());
			manager.add(exportAction);
		}
		{
			// Add page for the text editor
			try {
				textEditor = new PlotTextEditor();
				addPage(textEditor, getEditorInput());
			} catch (PartInitException e) {
				DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
			}
		}
		setPageText(0, "Plot");
		setPageText(1, "Source");
	}

	private FileEditorInput getFileEditorInput() {
		return (FileEditorInput) getEditorInput();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return textEditor.isSaveAsAllowed();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		textEditor.doSave(monitor);
	}

	@Override
	public void doSaveAs() {
		textEditor.doSaveAs();
	}

	@Override
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		if (newPageIndex == 0) {
			try {
				String contents = textEditor.getDocumentProvider().getDocument(getFileEditorInput()).get();
				data = PlotData.deserialize(new ByteArrayInputStream(contents.getBytes()));
				getSite().getShell().getDisplay().syncExec(new Runnable() {
					@Override
					public void run() {
						ChartBuilder builder = new ChartBuilder(data);
						builder.build();
						canvas.setChart(builder.getChart());
						canvas.redraw();
					}
				});
			} catch (IOException e) {
				// Should not happen with the ByteArrayInputStream
				DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
			}
		}
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		super.dispose();
	}

	private class ChartBuilder {

		private PlotData data;
		private ChartWithAxes chart = null;

		private Axis xAxis = null;
		private Axis yAxis = null;

		public ChartBuilder(PlotData data) {
			this.data = data;
		}

		public Chart getChart() {
			return chart;
		}

		public void build() {
			createChart();
			buildTitle();
			buildXAxis();
			buildYAxis();
			buildXSeries();
			buildYSeries();
		}

		private void buildTitle() {
			chart.getTitle().getLabel().getCaption().setValue(String.valueOf(data.id()));
			chart.getTitle().getLabel().getCaption().getFont().setSize(14);
			chart.getLegend().setVisible(false);
		}

		private void createChart() {
			chart = ChartWithAxesImpl.create();
		}

		private void buildXAxis() {
			xAxis = chart.getPrimaryBaseAxes()[0];

			xAxis.getTitle().setVisible(true);
			xAxis.getTitle().getCaption().setValue(MessageFormat.format("{0}" + (data.xUnit() != null ? " ({1})" : ""), data.xLabel(), data.xUnit()));
			xAxis.getTitle().getCaption().getFont().setBold(false);
			xAxis.getTitle().getCaption().getFont().setSize(13);

			xAxis.getLabel().setVisible(true);
			xAxis.getLabel().getCaption().getFont().setSize(9);

			xAxis.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);

			xAxis.setType(AxisType.TEXT_LITERAL);
			xAxis.getOrigin().setType(IntersectionType.VALUE_LITERAL);
		}

		private void buildYAxis() {
			yAxis = chart.getPrimaryOrthogonalAxis(xAxis);

			yAxis.getTitle().setVisible(true);
			yAxis.getTitle().getCaption().setValue(MessageFormat.format("{0}" + (data.yUnit() != null ? " ({1})" : ""), data.yLabel(), data.yUnit()));
			yAxis.getTitle().getCaption().getFont().setBold(false);
			yAxis.getTitle().getCaption().getFont().setRotation(90);
			yAxis.getTitle().getCaption().getFont().setSize(13);

			yAxis.getLabel().setVisible(true);
			yAxis.getLabel().getCaption().getFont().setSize(9);

			yAxis.getMajorGrid().getLineAttributes().setVisible(true);
			yAxis.getMajorGrid().getLineAttributes().setColor(ColorDefinitionImpl.GREY());
			yAxis.getMajorGrid().getLineAttributes().setStyle(LineStyle.DASHED_LITERAL);
			yAxis.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);

			yAxis.setType(AxisType.LINEAR_LITERAL);
			yAxis.getOrigin().setType(IntersectionType.VALUE_LITERAL);

		}

		private void buildXSeries() {

			NumberDataSet categoryValues = NumberDataSetImpl.create(data.data().stream().map(Pair::series).collect(Collectors.toList()));

			Series seCategory = SeriesImpl.create();
			seCategory.setDataSet(categoryValues);

			SeriesDefinition sdX = SeriesDefinitionImpl.create();
			xAxis.getSeriesDefinitions().add(sdX);
			sdX.getSeries().add(seCategory);
		}

		private void buildYSeries() {

			NumberDataSet orthoValuesDataSet = NumberDataSetImpl.create(data.data().stream().map(Pair::value).collect(Collectors.toList()));

			LineSeries ls = (LineSeries) LineSeriesImpl.create();
			ls.setPaletteLineColor(false);
			ls.setDataSet(orthoValuesDataSet);
			ls.getLineAttributes().setColor(ColorDefinitionImpl.RED().darker().darker());
			ls.getMarkers().forEach(m -> m.setType(MarkerType.CIRCLE_LITERAL));
			ls.getMarkers().forEach(m -> m.setSize(3));
			ls.getLabel().setVisible(true);
			ls.setCurve(true);

			SeriesDefinition sdY = SeriesDefinitionImpl.create();
			sdY.getSeriesPalette().update(ColorDefinitionImpl.RED());
			yAxis.getSeriesDefinitions().add(sdY);
			sdY.getSeries().add(ls);
		}
	}

	private class CopyAction extends Action {
		public CopyAction() {
			super("&Copy", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		}

		@Override
		public void run() {
			Clipboard clipboard = new Clipboard(getSite().getShell().getDisplay());
			clipboard.setContents(new ImageData[] { canvas.getImageData() }, new Transfer[] { ImageTransfer.getInstance() });
		}
	}

	private class ExportAction extends Action {
		public ExportAction() {
			super("&Export as image file...", DiceSimulationUiPlugin.getDefault().getImageRegistry().getDescriptor(DiceSimulationUiPlugin.IMG_ETOOL16_IMAGE));
		}

		@Override
		public void run() {
			ExportDialog dialog = new ExportDialog(getSite().getShell(), canvas.getSize().x, canvas.getSize().y);
			if (dialog.open() == Dialog.OK) {
				ExportDialog.ExportData exportData = dialog.getData();
				try {
					PluginSettings pluginSettings = PluginSettings.instance();
					Generator generator = Generator.instance();
					IDeviceRenderer render = pluginSettings.getDevice(exportData.getDevice().getDeviceString());
					render.setProperty(IDeviceRenderer.FILE_IDENTIFIER, exportData.getFile());
					Bounds bounds = BoundsImpl.create(0, 0, exportData.getWidth(), exportData.getHeight());
					bounds.scale(72d / render.getDisplayServer().getDpiResolution());
					GeneratedChartState state = generator.build(render.getDisplayServer(), canvas.getChart(), bounds, null);
					generator.render(render, state);
				} catch (ChartException e) {
					StatusManager.getManager().handle(new Status(IStatus.ERROR, DiceSimulationUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e),
							StatusManager.LOG | StatusManager.SHOW);
				}
			}
		}
	}

	private final class EditorResourceChangeListener implements IResourceChangeListener {
		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
				@Override
				public boolean visit(IResourceDelta delta) throws CoreException {
					IFile file = getFileEditorInput().getFile();
					if (delta.getResource().equals(file)) {
						switch (delta.getKind()) {
						case IResourceDelta.CHANGED:
							handleChange();
							return false;
						case IResourceDelta.REMOVED:
							handleRemove();
						default:
							break;
						}
					}
					return true;
				}
			};
			try {
				event.getDelta().accept(visitor);
			} catch (CoreException e) {
				DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
			}
		}

		private void handleChange() {
			IFile file = getFileEditorInput().getFile();
			try {
				data = PlotData.deserialize(file.getContents());
				getSite().getShell().getDisplay().syncExec(new Runnable() {
					@Override
					public void run() {
						ChartBuilder builder = new ChartBuilder(data);
						builder.build();
						canvas.setChart(builder.getChart());
						canvas.redraw();
					}
				});
			} catch (IOException | CoreException e) {
				DiceLogger.logException(DiceSimulationUiPlugin.getDefault(), e);
			}
		}

		private void handleRemove() {
			getSite().getShell().getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					getEditorSite().getPage().closeEditor(PlotEditor.this, false);
				}
			});
		}
	}
}
