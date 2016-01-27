package es.unizar.disco.ssh.providers.local;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.ssh.DiceSshConnectorPlugin;
import es.unizar.disco.ssh.providers.IHostProvider;
import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;

public class LocalConnectionProvider implements IHostProvider, IUserPasswordAuthProvider {

	private static final String CONNECTION_PROPERTIES 	= "connection.properties";
	
	private static final String HOST_PROPERTY 			= "host";
	private static final String HOST_PROPERTY_DEFAULT 	= "localhost";
	private static final String PORT_PROPERTY 			= "port";
	private static final String PORT_PROPERTY_DEFAULT 	= "22";
	private static final String USER_PROPERTY 			= "user";
	private static final String PASSWORD_PROPERTY 		= "password";

	@Override
	public String getHost() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty(HOST_PROPERTY, HOST_PROPERTY_DEFAULT);
	}

	@Override
	public int getPort() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return Integer.valueOf(properties.getProperty(PORT_PROPERTY, PORT_PROPERTY_DEFAULT));
	}

	@Override
	public String getUser() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty(USER_PROPERTY, StringUtils.EMPTY);
	}

	@Override
	public String getPassword() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty(PASSWORD_PROPERTY, StringUtils.EMPTY);
	}

	private InputStream getPropertiesStream() throws IOException {
		InputStream propertiesStream = getClass().getResourceAsStream(CONNECTION_PROPERTIES);
		if (propertiesStream == null) {
			throw new IOException(MessageFormat.format("Unable to find ''{0}'' file", CONNECTION_PROPERTIES));
		}
		return propertiesStream;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void configure() throws CoreException {
		throw new CoreException(
				new Status(IStatus.INFO, DiceSshConnectorPlugin.PLUGIN_ID,
				MessageFormat.format("''{0}'' does not support self-configuration", LocalConnectionProvider.class.getName())));
	}
}
