package es.unizar.disco.ssh.providers.local;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.ssh.DiceSshConnectorPlugin;
import es.unizar.disco.ssh.providers.IHostProvider;
import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;

public class LocalConnectionProvider implements IHostProvider, IUserPasswordAuthProvider {

	private static final String CONNECTION_PROPERTIES = "connection.properties";

	@Override
	public String getHost() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty("host", "localhost");
	}

	@Override
	public int getPort() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return Integer.valueOf(properties.getProperty("port", "22"));
	}

	@Override
	public String getUser() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty("user", "");
	}

	@Override
	public String getPassword() {
		Properties properties = new Properties();
		try {
			properties.load(getPropertiesStream());
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnectorPlugin.getDefault(), e);
		}
		return properties.getProperty("password", "");
	}

	private InputStream getPropertiesStream() throws IOException {
		InputStream propertiesStream = getClass().getResourceAsStream(CONNECTION_PROPERTIES);
		if (propertiesStream == null) {
			throw new IOException(MessageFormat.format("Unable to find ''{0}'' file", CONNECTION_PROPERTIES));
		}
		return propertiesStream;
	}
}
