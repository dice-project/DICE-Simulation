/**
 * 
 */
package es.unizar.disco.simulation.greatspn.ssh.simulator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PublicKey;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.UUID;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.core.util.StringUtils;
import es.unizar.disco.simulation.greatspn.ssh.GspnSshSimulationPlugin;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulationException;
import es.unizar.disco.ssh.providers.IAuthProvider;
import es.unizar.disco.ssh.providers.IHostProvider;
import es.unizar.disco.ssh.providers.IKeyAuthProvider;
import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;
import es.unizar.disco.ssh.providers.SshConnectionProviderConstants;
import net.schmizz.keepalive.KeepAliveProvider;
import net.schmizz.sshj.DefaultConfig;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.connection.channel.Channel;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;
import net.schmizz.sshj.userauth.keyprovider.KeyProvider;

/**
 * @author Abel Gómez <abel.gomez@unizar.es>
 *
 */
public class GspnSshSimulator implements ISimulator {

	private class GspnProcess extends Process {
		
		private class NoHostVerifier implements HostKeyVerifier {
			@Override
			public boolean verify(String s, int i, PublicKey publicKey) {
				return true;
			}
		}

		private SSHClient ssh;
		private Session simulationSession;
		private Command simulationCommand;
		private Thread simulationFinishedThread;
		
		private String remoteWorkingDir;
		private String subject;
		private volatile boolean finished = false;
		private volatile int exitValue = Integer.MIN_VALUE;
		
		public GspnProcess(String subject) {
			this.subject = subject;
			this.remoteWorkingDir = String.format("/tmp/%s", getId());
		}
		
		public void initialize(File... inputFiles) throws IOException {
			if (ssh == null) {
				throw new IllegalStateException("Connection not established");
			} 
			SFTPClient sftpClient = null;
			try {
				sftpClient = ssh.newSFTPClient();
				sftpClient.mkdirs(remoteWorkingDir);
				for (File file : inputFiles) {
					sftpClient.put(file.getCanonicalPath(), remoteWorkingDir + "/" + file.getName());
				}
			} finally {
				IOUtils.closeQuietly(sftpClient);
			}
		}
		
		public void connect(IHostProvider hostProvider, IAuthProvider authProvider) throws IOException {
	        DefaultConfig defaultConfig = new DefaultConfig();
	        defaultConfig.setKeepAliveProvider(KeepAliveProvider.KEEP_ALIVE);
			ssh = new SSHClient(defaultConfig);
	        ssh.loadKnownHosts();
			ssh.addHostKeyVerifier(new NoHostVerifier());
	        ssh.connect(hostProvider.getHost(), hostProvider.getPort());
	        ssh.getConnection().getKeepAlive().setKeepAliveInterval(5); //every 60sec

			if (authProvider instanceof IUserPasswordAuthProvider) {
				IUserPasswordAuthProvider userPassProvider = (IUserPasswordAuthProvider) authProvider;
				ssh.authPassword(userPassProvider.getUser(), userPassProvider.getPassword());
			} else if (authProvider instanceof IKeyAuthProvider) {
				IKeyAuthProvider keyProvider = (IKeyAuthProvider) authProvider;
				KeyProvider keys = ssh.loadKeys(keyProvider.getKeyFile().getAbsolutePath(), keyProvider.getPassphrase());
				ssh.authPublickey(keyProvider.getUser(), keys);
			}
		}
		
		public void launch() throws IOException {
	        simulationSession = ssh.startSession();
	        simulationCommand = simulationSession.exec(
	        		String.format("/usr/local/GreatSPN/bin/WNSIM %s/%s", remoteWorkingDir, subject));
	        simulationFinishedThread = addSimulationFinishedHook(simulationCommand);
		}
		
		private Thread addSimulationFinishedHook(final Channel channel) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						channel.join();
						try (
							Session catSession = ssh.startSession(); 
							Command catCommand = catSession.exec(String.format("cat %s/%s.simres", remoteWorkingDir, subject))
						) {
					        catCommand.join();
					        rawResults = IOUtils.readFully(catCommand.getInputStream()).toByteArray();
					        finished = true;
					        exitValue = simulationCommand.getExitStatus() != null ? simulationCommand.getExitStatus() : 1;
						}
					} catch (ConnectionException e) {
						DiceLogger.logError(GspnSshSimulationPlugin.getDefault(), 
								MessageFormat.format("Connection to ''{0}:{1}'' was closed unexpectedly", ssh.getRemoteHostname(), ssh.getRemotePort()),e);
					} catch (IOException e) {
						DiceLogger.logException(GspnSshSimulationPlugin.getDefault(), e);
					} finally {
						IOUtils.closeQuietly(ssh, simulationSession, simulationCommand);
					}
				}
			};
			thread.start();
			return thread;
		}
		
		@Override
		public OutputStream getOutputStream() {
			if (simulationCommand == null) {
				throw new IllegalStateException("Connection not established");
			}
			return simulationCommand.getOutputStream();
		}

		@Override
		public InputStream getInputStream() {
			if (simulationCommand == null) {
				throw new IllegalStateException("Connection not established");
			}
			return simulationCommand.getInputStream();
		}

		@Override
		public InputStream getErrorStream() {
			if (simulationCommand == null) {
				throw new IllegalStateException("Connection not established");
			}
			return simulationCommand.getErrorStream();
		}

		@Override
		public int waitFor() throws InterruptedException {
			if (simulationFinishedThread == null) {
				throw new IllegalThreadStateException("Waiting thread not started yet");
			}
			simulationFinishedThread.join();
			// If no exit status found, return 1 (error)
			return exitValue;
		}

		@Override
		public int exitValue() {
			if (simulationCommand.isOpen() && finished == false) {
				throw new IllegalThreadStateException("The command has not finished yet");
			}
			return exitValue;
		}

		@Override
		public void destroy() {
			IOUtils.closeQuietly(ssh, simulationSession, simulationCommand);
		}	
	}

	private String id = UUID.randomUUID().toString();
	private byte[] rawResults = new byte[0];
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public Process simulate(String subject, File... inputFiles) throws SimulationException {
		GspnProcess gspnProcess = new GspnProcess(subject);
	
		IHostProvider hostProvider = null;
		IAuthProvider authProvider = null;
		try {
			IConfigurationElement configElement = getConnectionProvider(SshConnectionProviderConstants.DEFAUL_LOCAL_PROVIDER_ID);
			if (configElement == null) {
				throw new SimulationException(MessageFormat.format("Unable to find connection provider ''{0}''", 
						SshConnectionProviderConstants.DEFAUL_LOCAL_PROVIDER_ID));
			}

			hostProvider = (IHostProvider) configElement.createExecutableExtension(SshConnectionProviderConstants.HOST_PROVIDER_ATTR);
			authProvider = (IAuthProvider) configElement.getChildren()[0].createExecutableExtension(SshConnectionProviderConstants.AUTH_PROVIDER_ATTR);
			
			gspnProcess.connect(hostProvider, authProvider);
		} catch (CoreException e) {
			throw new SimulationException("Unable to gather connection information", e);
		} catch (IOException e) {
			throw new SimulationException(
					MessageFormat.format("Unable to establish a connection with ''{0}@{1}:{2}''", 
							authProvider.getUser(), hostProvider.getHost(), hostProvider.getPort()), e);
		}
		try {
			gspnProcess.initialize(inputFiles);
		} catch (IOException e) {
			throw new SimulationException(MessageFormat.format("Unable to setup input files ''{0}''", Arrays.asList(inputFiles)), e);
		}
		try {
			gspnProcess.launch();
		} catch (IOException e) {
			throw new SimulationException("Unable to launch the remote simulation", e);
		}
		
		return gspnProcess;
	}
	
	
	
	@Override
	public InputStream getRawResult() {
		return new ByteArrayInputStream(Arrays.copyOf(rawResults, rawResults.length));
	}

	private IConfigurationElement getConnectionProvider(String id) throws SimulationException {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(SshConnectionProviderConstants.EXTENSION_ID);
		
		for (IConfigurationElement configElement : configElements) {
			String configId = configElement.getAttribute(SshConnectionProviderConstants.ID_ATTR);
			if (StringUtils.equals(id,  configId)) {
				return configElement;
			}
		}
		return null;
	}
}
