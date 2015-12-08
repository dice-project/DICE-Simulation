package es.unizar.disco.ssh.providers.local;

import java.io.IOException;
import java.util.Properties;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.ssh.DiceSshConnector;
import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;

public class LocalUserPasswordAuthProvider implements IUserPasswordAuthProvider {

	@Override
	public String getUser() {
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("connection.properties"));
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnector.getDefault(), e);
		}
		return properties.getProperty("user", "");
	}

	@Override
	public String getPassword() {
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("connection.properties"));
		} catch (IOException e) {
			DiceLogger.logException(DiceSshConnector.getDefault(), e);
		}
		return properties.getProperty("password", "");
	}

}
