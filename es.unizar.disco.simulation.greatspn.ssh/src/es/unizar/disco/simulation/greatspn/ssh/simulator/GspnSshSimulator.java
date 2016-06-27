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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.pnml.m2t.templates.gspn.GenerateGspn;
import es.unizar.disco.simulation.greatspn.ssh.GspnSshSimulationPlugin;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.WnsimFactory;
import es.unizar.disco.simulation.models.wnsim.WnsimResult;
import es.unizar.disco.simulation.simulators.ISimulator;
import es.unizar.disco.simulation.simulators.SimulationException;
import es.unizar.disco.ssh.providers.IAuthProvider;
import es.unizar.disco.ssh.providers.IHostProvider;
import es.unizar.disco.ssh.providers.IKeyAuthProvider;
import es.unizar.disco.ssh.providers.IUserPasswordAuthProvider;
import es.unizar.disco.ssh.providers.SshConnectionProviderConstants;
import fr.lip6.move.pnml.ptnet.PetriNet;
import fr.lip6.move.pnml.ptnet.PetriNetDoc;
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
import net.schmizz.sshj.userauth.password.PasswordUtils;

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
		private String identifier;
		private volatile boolean finished = false;
		private volatile int exitValue = Integer.MIN_VALUE;

		public GspnProcess(String identifier) {
			this.identifier = identifier;
			this.remoteWorkingDir = String.format("/tmp/%s", identifier); //$NON-NLS-1$
		}

		public void initialize(File... inputFiles) throws IOException {
			if (ssh == null) {
				throw new IllegalStateException(Messages.GspnSshSimulator_connNotEstablishedError);
			}
			SFTPClient sftpClient = null;
			try {
				sftpClient = ssh.newSFTPClient();
				sftpClient.mkdirs(remoteWorkingDir);
				for (File file : inputFiles) {
					sftpClient.put(file.getCanonicalPath(), remoteWorkingDir + "/" + file.getName()); //$NON-NLS-1$
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
			ssh.getConnection().getKeepAlive().setKeepAliveInterval(5); // every
																		// 60sec

			if (authProvider instanceof IUserPasswordAuthProvider) {
				IUserPasswordAuthProvider userPassProvider = (IUserPasswordAuthProvider) authProvider;
				ssh.authPassword(userPassProvider.getUser(), userPassProvider.getPassword());
			} else if (authProvider instanceof IKeyAuthProvider) {
				IKeyAuthProvider keyProvider = (IKeyAuthProvider) authProvider;
				KeyProvider keys = ssh.loadKeys(keyProvider.getPrivateKey(), null,
						!StringUtils.isEmpty(keyProvider.getPassphrase()) ? PasswordUtils.createOneOff(keyProvider.getPassphrase().toCharArray()) : null);
				ssh.authPublickey(keyProvider.getUser(), keys);
			}
		}

		public void launch(Map<String, String> options) throws IOException {
			simulationSession = ssh.startSession();
			StringBuilder builder = new StringBuilder("/usr/local/GreatSPN/bin/WNSIM %s/%s ");
			for (Entry<String, String> option : options.entrySet()) {
				builder.append(MessageFormat.format("-{0} {1}", option.getKey(), option.getValue()));
			}
			simulationCommand = simulationSession.exec(String.format(builder.toString(), remoteWorkingDir, identifier)); //$NON-NLS-1$
			simulationFinishedThread = addSimulationFinishedHook(simulationCommand);
		}

		private Thread addSimulationFinishedHook(final Channel channel) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						channel.join();
						try (Session catSession = ssh.startSession();
								Command catCommand = catSession.exec(String.format("cat %s/%s.simres", remoteWorkingDir, identifier)) //$NON-NLS-1$
						) {
							catCommand.join();
							rawResults = IOUtils.readFully(catCommand.getInputStream()).toByteArray();
							finished = true;
							exitValue = simulationCommand.getExitStatus() != null ? simulationCommand.getExitStatus() : 1;
						}
					} catch (ConnectionException e) {
						DiceLogger.logError(GspnSshSimulationPlugin.getDefault(),
								MessageFormat.format(Messages.GspnSshSimulator_connClosedError, ssh.getRemoteHostname(), ssh.getRemotePort()), e);
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
				throw new IllegalStateException(Messages.GspnSshSimulator_connNotEstablishedError);
			}
			return simulationCommand.getOutputStream();
		}

		@Override
		public InputStream getInputStream() {
			if (simulationCommand == null) {
				throw new IllegalStateException(Messages.GspnSshSimulator_connNotEstablishedError);
			}
			return simulationCommand.getInputStream();
		}

		@Override
		public InputStream getErrorStream() {
			if (simulationCommand == null) {
				throw new IllegalStateException(Messages.GspnSshSimulator_connNotEstablishedError);
			}
			return simulationCommand.getErrorStream();
		}

		@Override
		public int waitFor() throws InterruptedException {
			if (simulationFinishedThread == null) {
				throw new IllegalThreadStateException(Messages.GspnSshSimulator_threadNotStartedError);
			}
			simulationFinishedThread.join();
			// If no exit status found, return 1 (error)
			return exitValue;
		}

		@Override
		public int exitValue() {
			if (simulationCommand.isOpen() && finished == false) {
				throw new IllegalThreadStateException(Messages.GspnSshSimulator_commandNotFinishedError);
			}
			return exitValue;
		}

		@Override
		public void destroy() {
			IOUtils.closeQuietly(ssh, simulationSession, simulationCommand);
		}
	}

	private byte[] rawResults = new byte[0];

	@Override
	public Process simulate(String id, List<EObject> analyzableModel, TraceSet traces, Map<String, String> options, IProgressMonitor monitor)
			throws SimulationException {

		SubMonitor subMonitor = SubMonitor.convert(monitor, 2);

		if (analyzableModel.size() != 1) {
			throw new SimulationException(new IllegalArgumentException(
					MessageFormat.format("Unexpected number of model elements, expecting 1 EObject, found {0}", analyzableModel.size())));
		} else if (!(analyzableModel.get(0) instanceof PetriNetDoc)) {
			throw new SimulationException(new IllegalArgumentException("Unexpected analyzable model type, expecting ''fr.lip6.move.pnml.ptnet.PetriNetDoc''"));
		} 

		PetriNetDoc petriNetDoc = (PetriNetDoc) analyzableModel.get(0);
		if (petriNetDoc.getNets().size() != 1) {
			throw new SimulationException(new IllegalArgumentException(
					MessageFormat.format("Unexpected number of model elements, expecting 1 EObject, found {0}", petriNetDoc.getNets().size())));
		} else if (!(petriNetDoc.getNets().get(0) instanceof PetriNet)) {
			throw new SimulationException(new IllegalArgumentException("Unexpected analyzable model type, expecting ''fr.lip6.move.pnml.ptnet.PetriNet''"));
		} 

		GspnProcess gspnProcess = new GspnProcess(id);

		File targetDir = GspnSshSimulationPlugin.getDefault().getStateLocation().append(id).toFile();
		targetDir.deleteOnExit();
		try {
			
			if (!targetDir.exists()) {
				if (!targetDir.mkdirs()) {
					throw new SimulationException(MessageFormat.format("Unable to create temporaty directory ''{0}''", targetDir));
				}
			}

			PetriNet petriNet = EcoreUtil.copy(petriNetDoc.getNets().get(0));
			petriNet.setId(id);
			
			File[] inputFiles = generateGspnFiles(petriNet, targetDir, subMonitor.newChild(1));

			IHostProvider hostProvider = null;
			IAuthProvider authProvider = null;

			try {
				IConfigurationElement configElement = getConnectionProvider();
				if (configElement == null) {
					throw new SimulationException(Messages.GspnSshSimulator_providerNotFoundError);
				}

				hostProvider = (IHostProvider) configElement.createExecutableExtension(SshConnectionProviderConstants.HOST_PROVIDER_ATTR);
				for (IConfigurationElement child : configElement.getChildren()) {
					// Try to connect using each one of the authentication
					// provider as they are declared
					IAuthProvider childAuthProvider = (IAuthProvider) child.createExecutableExtension(SshConnectionProviderConstants.AUTH_PROVIDER_ATTR);
					if (childAuthProvider.isEnabled()) {
						authProvider = childAuthProvider;
						break;
					}
				}
				if (authProvider == null) {
					hostProvider.configure();
				}
				gspnProcess.connect(hostProvider, authProvider);

			} catch (CoreException e) {
				throw new SimulationException(Messages.GspnSshSimulator_connInfoNotFoundError, e);
			} catch (IOException e) {
				throw new SimulationException(MessageFormat.format(Messages.GspnSshSimulator_unableEstablishConnError,
						authProvider != null ? authProvider.getUser() : null, hostProvider.getHost(), hostProvider.getPort()), e);
			}

			try {
				gspnProcess.initialize(inputFiles);
			} catch (IOException e) {
				throw new SimulationException(MessageFormat.format(Messages.GspnSshSimulator_unableSetupFilesError, Arrays.asList(inputFiles)), e);
			}

			gspnProcess.launch(options);
			
		} catch (Throwable t) {
			throw new SimulationException(t.getLocalizedMessage(), t);
		}
		return gspnProcess;
	}

	@Override
	public ToolResult getToolResult() {
		WnsimResult toolResult = WnsimFactory.eINSTANCE.createWnsimResult();
		toolResult.setTimestamp(Calendar.getInstance().getTime());
		return toolResult;
	}

	@Override
	public InputStream getRawResult() {
		return new ByteArrayInputStream(Arrays.copyOf(rawResults, rawResults.length));
	}

	private IConfigurationElement getConnectionProvider() throws SimulationException {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(SshConnectionProviderConstants.EXTENSION_ID);

		int currentPriority = -1;
		IConfigurationElement prioritaryElement = null;
		for (IConfigurationElement configElement : configElements) {
			int elementPriority = Integer.valueOf(configElement.getAttribute(SshConnectionProviderConstants.PRIORITY_ATTR));
			if (elementPriority > currentPriority) {
				currentPriority = elementPriority;
				prioritaryElement = configElement;
			}
		}
		return prioritaryElement;
	}

	private static File[] generateGspnFiles(PetriNet model, File targetDir, IProgressMonitor monitor) throws IOException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
		GenerateGspn gspnGenerator = new GenerateGspn(model, targetDir, new ArrayList<EObject>());
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		gspnGenerator.doGenerate(BasicMonitor.toMonitor(subMonitor.newChild(1)));
		return new File[] {
				targetDir.toPath().resolve(model.getId() + ".net").toFile(),
				targetDir.toPath().resolve(model.getId() + ".def").toFile()
		};
	}

}
