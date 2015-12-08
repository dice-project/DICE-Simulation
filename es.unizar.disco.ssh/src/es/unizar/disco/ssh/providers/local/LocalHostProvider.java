package es.unizar.disco.ssh.providers.local;

import java.io.IOException;
import java.util.Properties;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.ssh.DiceSshConnector;
import es.unizar.disco.ssh.providers.IHostProvider;

public class LocalHostProvider implements IHostProvider {

	@Override
	public String getHost() {
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("connection.properties"));
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnector.getDefault(), e);
		}
		return properties.getProperty("host", "");
	}

	@Override
	public int getPort() {
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("connection.properties"));
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnector.getDefault(), e);
		}
		return Integer.valueOf(properties.getProperty("port", ""));
	}

}
