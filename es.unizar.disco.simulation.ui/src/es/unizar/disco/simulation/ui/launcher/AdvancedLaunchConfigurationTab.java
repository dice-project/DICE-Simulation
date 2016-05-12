package es.unizar.disco.simulation.ui.launcher;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import es.unizar.disco.core.ui.dialogs.ContainerSelectionDialog;
import es.unizar.disco.simulation.ui.DiceSimulationUiPlugin;

public class AdvancedLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	protected EditingDomain editingDomain;
	
	public AdvancedLaunchConfigurationTab(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}
	
	@Override
	public void createControl(Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, true));
		
		{ // Intermediate Files Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
			
			group.setLayout(new GridLayout(2,  false));
			group.setText("Intermediate Files");

			final Button saveIntermediateButton = new Button(group, SWT.CHECK);
			saveIntermediateButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			saveIntermediateButton.setText("&Save intermediate files in the workspace");
			
			final Text inputFileText = new Text(group, SWT.BORDER);
			inputFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			
			final Button fileButton = new Button(group, SWT.NONE);
			fileButton.setText(Messages.MainLaunchConfigurationTab_browseLabel);

			final GridData buttonsGridData = new GridData(SWT.CENTER, SWT.CENTER, false, false);
			buttonsGridData.widthHint = 100;
			fileButton.setLayoutData(buttonsGridData);
			
			fileButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell());
					dialog.open();
				}
			});
		}
		
		{ // Simulation Backend Group

			final Group group = new Group(topComposite, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
			
			group.setLayout(new GridLayout(1,  false));
			group.setText("Simulation backend");

			Combo simBackendCombo = new Combo(group, SWT.READ_ONLY);
			simBackendCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
						
		}
		setControl(topComposite);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public String getName() {
		return "Advanced";
	}

	@Override
	public Image getImage() {
		return DiceSimulationUiPlugin.getDefault().getImageRegistry().get(DiceSimulationUiPlugin.IMG_OBJ16_ADVANCED_TAB);
	}
}
