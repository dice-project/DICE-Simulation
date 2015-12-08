package es.unizar.disco.ssh.providers;

import java.io.File;

public interface IKeyAuthProvider extends IAuthProvider {

	public File getKeyFile();
	
	public String getPassphrase();
	
}
