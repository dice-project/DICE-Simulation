package es.unizar.disco.simulation.ui.editors;

import java.io.File;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * {@link TitleAreaDialog} that captures the information to export "something"
 * as an image file
 * 
 * @author agomez
 *
 */
public class ExportDialog extends TitleAreaDialog {

	public enum Device {
		// @formatter:off
		PNG("dv.PNG"),
		BMP("dv.BMP"), 
		GIF("dv.GIF"), 
		JPG("dv.JPG"), 
		SVG("dv.SVG"), 
		PDF("dv.PDF");
		// @formatter:on

		private String device;

		private Device(String device) {
			this.device = device;
		}

		public String getDeviceString() {
			return device;
		}
	}

	/**
	 * Immutable class containing the values introduced in an
	 * {@link ExportDialog}
	 * 
	 * @author agomez
	 *
	 */
	public class ExportData {
		private int width;
		private int height;
		private Device device;
		private String file;

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public Device getDevice() {
			return device;
		}

		public String getFile() {
			return file;
		}
	}

	private final DataBindingContext context = new DataBindingContext();
	private final WritableValue<Integer> width = new WritableValue<Integer>();
	private final WritableValue<Integer> height = new WritableValue<Integer>();
	private final WritableValue<Device> device = new WritableValue<Device>();
	private final WritableValue<String> file = new WritableValue<String>();
	private final WritableValue<Boolean> keepAspectRatio = new WritableValue<Boolean>();
	private final float ratio;

	/**
	 * Creates an {@link ExportDialog} with the default size for the output
	 * image file
	 * 
	 * @param parentShell
	 */
	public ExportDialog(Shell parentShell) {
		this(parentShell, 800, 600);
	}

	/**
	 * Creates an {@link ExportDialog} using <code>width</code> and
	 * <code>height</code> as the default values for the size of the output
	 * image.
	 * 
	 * @param parentShell
	 * @param width
	 * @param height
	 */
	public ExportDialog(Shell parentShell, int width, int height) {
		super(parentShell);
		this.width.setValue(width);
		this.height.setValue(height);
		this.file.setValue("");
		this.device.setValue(Device.PNG);
		this.keepAspectRatio.setValue(true);
		this.ratio = (float) width / (float) height;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Export plot as an image");
		setMessage("Set the export configuration", IMessageProvider.INFORMATION);
		getShell().setText("Export plot");
		setHelpAvailable(false);
		addValueChangeListeners();
		validate();
	}

	private void addValueChangeListeners() {
		file.addValueChangeListener(new IValueChangeListener<String>() {
			@Override
			public void handleValueChange(ValueChangeEvent<? extends String> event) {
				validate();
			}
		});
	}

	protected void validate() {
		final File file = new File(this.file.getValue());
		final File directory = file.getParentFile();
		final IPath path = new Path(this.file.getValue());

		if (file.isDirectory()) {
			setErrorMessage("Invalid file path, a directory exists in the same location");
		} else if (directory == null) {
			setErrorMessage("Invalid file location");
		} else if (!directory.exists()) {
			setErrorMessage("File location does not exist");
		} else if (path.hasTrailingSeparator() || path.lastSegment().endsWith(".")) {
			setErrorMessage("Invalid file path");
		} else {
			setErrorMessage(null);
		}
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite top = new Composite(area, SWT.NONE);
		top.setLayoutData(new GridData(GridData.FILL_BOTH));
		top.setLayout(new GridLayout());
		createFileGroup(top);
		createImagePropertiesGroup(top);
		return top;
	}

	private void createFileGroup(Composite parent) {
		Group fileGroup = new Group(parent, SWT.NONE);
		fileGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fileGroup.setText("File Properties");
		fileGroup.setLayout(new GridLayout());
		createFileComposite(fileGroup);
		createFormatComposite(fileGroup);
	}

	private void createFileComposite(Composite parent) {
		Composite fileComposite = new Composite(parent, SWT.NONE);
		fileComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fileComposite.setLayout(new GridLayout(2, false));

		Text fileText = new Text(fileComposite, SWT.BORDER);
		fileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Button browseButton = new Button(fileComposite, SWT.PUSH);
		browseButton.setLayoutData(new GridData());
		browseButton.setText("&Browse");
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
				String extension = device.getValue().toString().toLowerCase();
				dialog.setFilterExtensions(new String[] { "*." + extension, "*.*" });
				String path = dialog.open();
				if (path != null) {
					file.setValue(path);
				}
			}
		});
		context.bindValue(WidgetProperties.text(SWT.Modify).observe(fileText), file);
	}

	private void createFormatComposite(Composite parent) {
		Composite formatComposite = new Composite(parent, SWT.NONE);
		formatComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		formatComposite.setLayout(new GridLayout(2, false));

		Label formatLabel = new Label(formatComposite, SWT.NONE);
		formatLabel.setLayoutData(new GridData());
		formatLabel.setText("Format:");

		ComboViewer formatCombo = new ComboViewer(formatComposite, SWT.READ_ONLY);
		formatCombo.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		formatCombo.setContentProvider(ArrayContentProvider.getInstance());
		formatCombo.setLabelProvider(new LabelProvider());
		formatCombo.setInput(Device.values());
		context.bindValue(WidgetProperties.selection().observe(formatCombo.getControl()), device, new UpdateValueStrategy() {
			@Override
			public Object convert(Object value) {
				return Device.valueOf((String) value);
			}
		}, new UpdateValueStrategy() {
			@Override
			public Object convert(Object value) {
				return ((Device) value).toString();
			}
		});
	}

	private void createImagePropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		propertiesGroup.setText("Image Properties");
		propertiesGroup.setLayout(new GridLayout(5, true));
		Label widthLabel = new Label(propertiesGroup, SWT.NONE);
		widthLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		widthLabel.setText("Width:");
		Spinner widthSpinner = new Spinner(propertiesGroup, SWT.BORDER);
		widthSpinner.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		widthSpinner.setMinimum(0);
		widthSpinner.setMaximum(Short.MAX_VALUE);
		Button ratioButton = new Button(propertiesGroup, SWT.TOGGLE);
		ratioButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		ratioButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ELCL_SYNCED));
		ratioButton.setToolTipText("Keep aspect ratio");
		Label heightLabel = new Label(propertiesGroup, SWT.NONE);
		heightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		heightLabel.setText("Height:");
		Spinner heightSpinner = new Spinner(propertiesGroup, SWT.BORDER);
		heightSpinner.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		heightSpinner.setMinimum(0);
		heightSpinner.setMaximum(Short.MAX_VALUE);

		context.bindValue(WidgetProperties.selection().observe(ratioButton), keepAspectRatio);
		context.bindValue(WidgetProperties.selection().observe(widthSpinner), width);
		context.bindValue(WidgetProperties.selection().observe(heightSpinner), height);

		widthSpinner.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (keepAspectRatio.getValue()) {
					keepAspectRatio.setValue(false);
					height.setValue((int) (((float) width.getValue()) / ratio));
					keepAspectRatio.setValue(true);
				}
			}
		});

		heightSpinner.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (keepAspectRatio.getValue()) {
					keepAspectRatio.setValue(false);
					width.setValue((int) (((float) height.getValue()) * ratio));
					keepAspectRatio.setValue(true);
				}
			}
		});
	}

	/**
	 * Returns an {@link ExportData} instance with the values configures in the
	 * {@link ExportDialog}.
	 * 
	 * @return
	 */
	public ExportData getData() {
		ExportData data = new ExportData();
		data.width = width.getValue();
		data.height = height.getValue();
		data.device = device.getValue();
		data.file = file.getValue();
		return data;
	}
}