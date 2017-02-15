package es.unizar.disco.ssh.providers;

public interface IKeyAuthProvider extends IAuthProvider {

	public String getPrivateKey();
	
	public String getPassphrase();
	
}
