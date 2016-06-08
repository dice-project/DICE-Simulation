package es.unizar.disco.ssh.ui.preferences;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.DomainValidator;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.WritableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.dialog.ValidationMessageProvider;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.preference.PreferencePageSupport;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.ssh.ui.DiceSshConnectorUiPlugin;


public class SshConnectionProviderPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	
	public static final String ID = "es.unizar.disco.ssh.ui.preferences.SshConnectionProviderPreferencePage"; //$NON-NLS-1$
	
	private IObservableMap preferencesMap = new WritableMap();
	private DataBindingContext context;
	
	public SshConnectionProviderPreferencePage() {
		setPreferenceStore(DiceSshConnectorUiPlugin.getDefault().getPreferenceStore());
		setDescription(Messages.SshConnectionProviderPreferencePage_prefsDescription);
	}

	@Override
	public void init(IWorkbench workbench) {
		context = new DataBindingContext();
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, false));
		
		GridData labelGridData = new GridData(SWT.FILL, SWT.TOP, false, false);
		labelGridData.widthHint = 100;
	
		{
			{
				// UI Declaration
				final Group serverGroup = new Group(topComposite, SWT.NONE);
				serverGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
				serverGroup.setText(Messages.SshConnectionProviderPreferencePage_remoteServerLabel);
				serverGroup.setLayout(new GridLayout(2, false));

				final Label serverLabel = new Label(serverGroup, SWT.NONE);
				serverLabel.setText(Messages.SshConnectionProviderPreferencePage_hostLabel);
				serverLabel.setLayoutData(labelGridData);

				final Text serverText = new Text(serverGroup, SWT.BORDER);
				serverText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

				final Label portLabel = new Label(serverGroup, SWT.NONE);
				portLabel.setText(Messages.SshConnectionProviderPreferencePage_portLabel);
				portLabel.setLayoutData(labelGridData);

				final Spinner portSpinner = new Spinner(serverGroup, SWT.BORDER);
				portSpinner.setMinimum(0);
				portSpinner.setMaximum(0xFFFF);
				portSpinner.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));

				// Data binding
				//
				// Observables for the Widgets
				final ISWTObservableValue hostTextObservable = WidgetProperties.text(SWT.Modify).observe(serverText);
				final ISWTObservableValue portSpinnerObservable = WidgetProperties.selection().observe(portSpinner);

				// Observables for the data model
				final IObservableValue hostObservable = Observables.observeMapEntry(preferencesMap, PreferenceConstants.HOST);
				final IObservableValue portObservable = Observables.observeMapEntry(preferencesMap, PreferenceConstants.PORT);

				// Observables for the data model
				// Host binding
				final Binding hostBinding = context.bindValue(hostTextObservable, hostObservable,
						new UpdateValueStrategy().setBeforeSetValidator(new HostValidator()), null);
				ControlDecorationSupport.create(hostBinding, SWT.TOP | SWT.LEFT);
				// Port binding
				context.bindValue(portSpinnerObservable, portObservable, 
						null,
						new UpdateValueStrategy().setConverter(StringToNumberConverter.toInteger(true)));
			}
			{
				// UI Declaration
				final Group authGroup = new Group(topComposite, SWT.NONE);
				authGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				authGroup.setText(Messages.SshConnectionProviderPreferencePage_authLabel);
				authGroup.setLayout(new GridLayout(2, false));

				final Label userLabel = new Label(authGroup, SWT.NONE);
				userLabel.setText(Messages.SshConnectionProviderPreferencePage_userLabel);
				userLabel.setLayoutData(labelGridData);

				final Text userText = new Text(authGroup, SWT.BORDER);
				userText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

				final Button passwordAuthButton = new Button(authGroup, SWT.RADIO);
				passwordAuthButton.setLayoutData(labelGridData);
				passwordAuthButton.setText(Messages.SshConnectionProviderPreferencePage_passwordLabel);

				final Text passwordText = new Text(authGroup, SWT.BORDER | SWT.PASSWORD);
				passwordText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

				final Button keyAuthButton = new Button(authGroup, SWT.RADIO);
				keyAuthButton.setLayoutData(labelGridData);
				keyAuthButton.setText(Messages.SshConnectionProviderPreferencePage_keyLabel);

				final Text keyText = new Text(authGroup, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
				keyText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

				// Dummy label to create a spacer
				new Label(authGroup, SWT.NONE).setLayoutData(labelGridData);

				final Label passphraseLabel = new Label(authGroup, SWT.NONE);
				passphraseLabel.setText(Messages.SshConnectionProviderPreferencePage_passphraseLabel);
				passphraseLabel.setLayoutData(labelGridData);

				// Dummy label to create a spacer
				new Label(authGroup, SWT.NONE).setLayoutData(labelGridData);

				final Text passphraseText = new Text(authGroup, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
				passphraseText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

				// Data binding
				//
				// Observables for the widgets
				final ISWTObservableValue userTextObservable = WidgetProperties.text(SWT.Modify).observe(userText);
				final ISWTObservableValue passwordAuthButtonObservable = WidgetProperties.selection().observe(passwordAuthButton);
				final ISWTObservableValue keyAuthButtonObservable = WidgetProperties.selection().observe(keyAuthButton);
				final ISWTObservableValue passwordTextObservable = WidgetProperties.text(SWT.Modify).observe(passwordText);
				final ISWTObservableValue keyTextObservable = WidgetProperties.text(SWT.Modify).observe(keyText);
				final ISWTObservableValue passphraseTextObservable = WidgetProperties.text(SWT.Modify).observe(passphraseText);
				// Observables for the widgets' state (widgets that need to be disabled)
				final ISWTObservableValue passwordTextEnabledObservable = WidgetProperties.enabled().observe(passwordText);
				final ISWTObservableValue keyTextEnabledObservable = WidgetProperties.enabled().observe(keyText);
				final ISWTObservableValue passphraseTextEnabledObservable = WidgetProperties.enabled().observe(passphraseText);

				// Observables for the data model
				final IObservableValue userObservable = Observables.observeMapEntry(preferencesMap, PreferenceConstants.USERNAME);
				final IObservableValue authObservable = Observables.observeMapEntry(preferencesMap, PreferenceConstants.PROVIDER);
				final IObservableValue passwordObservable = Observables.observeMapEntry(preferencesMap, PreferenceConstants.PASSWORD);
				final IObservableValue keyObservable = Observables.observeMapEntry(preferencesMap, PreferenceConstants.KEY);
				final IObservableValue passphraseObservable = Observables.observeMapEntry(preferencesMap, PreferenceConstants.PASSPHRASE);

				// Bindings
				// Username binding
				final Binding userBinding = context.bindValue(userTextObservable, userObservable,
						new UpdateValueStrategy().setBeforeSetValidator(new UsernameValidator()), null);
				ControlDecorationSupport.create(userBinding, SWT.TOP | SWT.LEFT);

				// Auth type binding
				final SelectObservableValue authButtonsObservable = new SelectObservableValue(String.class);
				authButtonsObservable.addOption(PreferenceConstants.PASSWORD_PROVIDER.toString(), passwordAuthButtonObservable);
				authButtonsObservable.addOption(PreferenceConstants.KEY_PROVIDER.toString(), keyAuthButtonObservable);
				context.bindValue(authButtonsObservable, authObservable);

				// Password binding
				context.bindValue(passwordTextObservable, passwordObservable);

				// Key binding
				final Binding keyTextBinding = context.bindValue(keyTextObservable, keyObservable,
						new UpdateValueStrategy().setBeforeSetValidator(new KeyValidator()),
						null);
				ControlDecorationSupport.create(keyTextBinding, SWT.TOP | SWT.LEFT);
				{
					// Force validation of the Key Text widget when the auth type changes
					authButtonsObservable.addValueChangeListener(new IValueChangeListener() {
						@Override
						public void handleValueChange(ValueChangeEvent event) {
							keyTextBinding.validateTargetToModel();
						}
					});
				}
				
				// Passphrase binding
				context.bindValue(passphraseTextObservable, passphraseObservable);
				
				// Enablement of Authorization type widgets binding
				context.bindValue(passwordAuthButtonObservable, passwordTextEnabledObservable);
				context.bindValue(keyAuthButtonObservable, keyTextEnabledObservable);
				context.bindValue(keyAuthButtonObservable, passphraseTextEnabledObservable);


			}
		}
		
		PreferencePageSupport pageSupport = PreferencePageSupport.create(this, context);
		pageSupport.setValidationMessageProvider(new ValidationMessageProvider());

		// Force Validation
		preferencesMap.clear();
		applyData(getPreferenceStore());
		for (@SuppressWarnings("unchecked")
		Iterator<Binding> it = context.getBindings().iterator(); it.hasNext();) {
			Binding binding = it.next();
			binding.validateTargetToModel();
		}
		
		return topComposite;
	}

	@Override
	public void applyData(Object data) {
		if (data instanceof IPreferenceStore) {
			IPreferenceStore store = (IPreferenceStore) data;
			for (PreferenceConstants constant : PreferenceConstants.values()) {
				if (store.contains(constant.toString())) {
					preferencesMap.put(constant, store.getString(constant.toString()));
				}
			}
		} else {
			DiceLogger.log(
					DiceSshConnectorUiPlugin.getDefault(),
					new Status(IStatus.ERROR, DiceSshConnectorUiPlugin.PLUGIN_ID,
							MessageFormat.format(Messages.SshConnectionProviderPreferencePage_unexpectedInputError, data)));
		}
	}
	
	@Override
	public boolean performOk() {
		if (!isValid()) {
			return false;
		} else {
			for (PreferenceConstants constant : PreferenceConstants.values()) {
				if (preferencesMap.get(constant) != null) { 
					getPreferenceStore().setValue(constant.toString(), preferencesMap.get(constant).toString());
				}
			}
			return true;
		}
	}

	@Override
	protected void performDefaults() {
		for (PreferenceConstants constant : PreferenceConstants.values()) {
			preferencesMap.put(constant, getPreferenceStore().getDefaultString(constant.toString()));
		}
	}

	private final class HostValidator implements IValidator {
		@Override
		public IStatus validate(Object value) {
			if (InetAddressValidator.getInstance().isValid(value.toString()) || 
					DomainValidator.getInstance(true).isValid(value.toString())) {
				return ValidationStatus.ok();
			}
			return ValidationStatus.error(Messages.SshConnectionProviderPreferencePage_invalidHostError);
		}
	}

	private final class UsernameValidator implements IValidator {
		@Override
		public IStatus validate(Object value) {
			if (value != null && StringUtils.isNotBlank(value.toString())) {
				return ValidationStatus.ok();
			}
			return ValidationStatus.error(Messages.SshConnectionProviderPreferencePage_usernameEmptyError);
		}
	}

	private final class KeyValidator implements IValidator {
		
		@Override
		public IStatus validate(Object value) {
			if (!PreferenceConstants.KEY_PROVIDER.toString().equals(preferencesMap.get(PreferenceConstants.PROVIDER))) {
				// Provider is disabled, any value is valid
				return ValidationStatus.ok();
			}
			if (value == null || StringUtils.isBlank(value.toString())) {
				// Key is blank
				return ValidationStatus.error(Messages.SshConnectionProviderPreferencePage_keyEmptyError);
			}
			// Try to parse key to check format
			PemReader reader = new PemReader(new InputStreamReader(new ByteArrayInputStream(value.toString().getBytes())));
			try {
				PemObject pemObject = reader.readPemObject();
				if (pemObject != null && pemObject.getType() != null) { 
					return ValidationStatus.ok();
				} else {
					return ValidationStatus.error(Messages.SshConnectionProviderPreferencePage_unknownFormatError);
				}
			} catch (IOException e) {
				return ValidationStatus.error(Messages.SshConnectionProviderPreferencePage_invalidFormatError);
			} finally {
				IOUtils.closeQuietly(reader);
			}
		}
	}
}