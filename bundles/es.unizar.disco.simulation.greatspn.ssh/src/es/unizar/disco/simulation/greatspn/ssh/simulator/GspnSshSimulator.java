/**
 * 
 */
package es.unizar.disco.simulation.greatspn.ssh.simulator;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.security.PublicKey;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.NullOutputStream;
import org.apache.commons.io.output.TeeOutputStream;
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
import es.unizar.disco.pnextensions.pnconstants.BaseUnitsConstants;
import es.unizar.disco.pnml.m2t.templates.gspn.GenerateGspn;
import es.unizar.disco.simulation.greatspn.ssh.GspnSshSimulationPlugin;
import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.datatypes.NonStandardUnits;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.SimulationParameters;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import es.unizar.disco.simulation.models.wnsim.WnsimElementInfo;
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
import fr.lip6.move.pnml.ptnet.PnObject;
import fr.lip6.move.pnml.ptnet.ToolInfo;
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
import tec.units.ri.unit.Units;

/**
 * @author Abel G�mez <abel.gomez@unizar.es>
 *
 */
public class GspnSshSimulator implements ISimulator {

	private class GspnProcess extends Process {

		private class ResultBuilder extends Thread {

			private static final String STR_HEADER_1 = "USE : WNSIM netname [-f first_tr_length][-t tr_length][-m min_btc][-M max_btc][-a approx][-c conf_level][-s seed][-o start]";
			private static final String STR_HEADER_2 = "Send files netname.net, .def to e-mail address";
			private static final String STR_HEADER_3 = "greatspn@di.unito.it if you find any bug.";

			private static final String STR_PARSING_ERROR = "Syntax error while parsing";
			private static final String STR_INITIAL_DEAD_MARKING = "ERROR : initial dead marking !";

			private static final String STS_SEPARATOR = "--";
			private static final String STS_BATCH_HEADER = "| ";
			private static final String STS_DEAD_MARKING = "ERROR : Dead marking reached at simulation step";
			private static final String STS_START_END = "Start batch number";
			private static final String STS_CURRENT_TIME = "Current time";
			private static final String STS_EFFICIENCY = "Efficiency --->";
			private static final String STS_TIME_REQUIRED = "Time required for";
			private static final String STS_MALLOC = "MALLOC";
			private static final String STS_PUSH = "PUSH";
			private static final String STS_POP = "POP";

			private static final String REX_SEPARATOR = "^-+$";
			private static final String REX_TRANSITION_INFO = "Throughput of (?<transition>\\S+) \\(\\S+ \\): (?<cilower>\\S+) <= X <= (?<ciupper>\\S+)";
			private static final String REX_PLACE_INFO = "Mean n\\.of tokens in (?<place>\\S+) : (?<cilower>\\S+) <= mu <= (?<ciupper>\\S+)";
			private static final String REX_VALUE = "Value (?<value>\\S+) Mean Value \\S+ Accuracy \\S+";

			private WnsimResult latestResult;
			private WnsimResult currentResult;

			private BufferedReader reader;

			public ResultBuilder(InputStream stream) {
				this.reader = new BufferedReader(new InputStreamReader(stream));
			}

			public WnsimResult getLatestResult() {
				return latestResult;
			}

			@Override
			public void run() {
				String line;
				try {
					// The header always is:
					//
					//
					// --------------------------------------------------------------------------------------------------
					// USE : WNSIM netname [-f first_tr_length][-t tr_length][-m
					// min_btc][-M max_btc][-a approx][-c conf_level][-s
					// seed][-o start]
					// --------------------------------------------------------------------------------------------------
					//
					// Send files netname.net, .def to e-mail address
					// greatspn@di.unito.it if you find any bug.
					// --------------------------------------------------------------------------------------------------
					//

					// Check that the stream starts by the header:
					boolean error = false;
					try {
						// @formatter:off
						if (!reader.readLine().trim().isEmpty()) error = true;
						if (!reader.readLine().trim().isEmpty()) error = true;
						if (!reader.readLine().matches(REX_SEPARATOR)) error = true;
						if (!reader.readLine().equals(STR_HEADER_1)) error = true;
						if (!reader.readLine().matches(REX_SEPARATOR)) error = true;
						if (!reader.readLine().trim().isEmpty()) error = true;
						if (!reader.readLine().equals(STR_HEADER_2)) error = true;
						if (!reader.readLine().equals(STR_HEADER_3)) error = true;
						if (!reader.readLine().matches(REX_SEPARATOR)) error = true;
						if (!reader.readLine().trim().isEmpty()) error = true; 
						// @formatter:on
					} catch (NullPointerException e) {
						error = true;
					}

					// Fatal error, the tool returned an unexpected result
					if (error) {
						throw new RuntimeException("Unexpected content found in WNSIM stdout");
					}

					Pattern transPattern = Pattern.compile(REX_TRANSITION_INFO);
					Pattern placePattern = Pattern.compile(REX_PLACE_INFO);
					Pattern valuePattern = Pattern.compile(REX_VALUE);
					Matcher matcher;
					WnsimElementInfo info = null;
					// Process the result
					while ((line = reader.readLine()) != null) {
						if (line.trim().isEmpty()) {
							continue;
						} else if (line.startsWith(STS_SEPARATOR)) {
							continue;
						} else if (line.startsWith(STS_BATCH_HEADER)) {
							continue;
						} else if (line.startsWith(STS_CURRENT_TIME)) {
							continue;
						} else if (line.startsWith(STS_START_END)) {
							latestResult = currentResult;
							currentResult = WnsimFactory.eINSTANCE.createWnsimResult();
							currentResult.setTimestamp(Calendar.getInstance().getTime());
							continue;
						} else if ((matcher = transPattern.matcher(line.trim())).matches()) {
							String id = matcher.group("transition");
							String lower = matcher.group("cilower");
							String upper = matcher.group("ciupper");
							info = WnsimFactory.eINSTANCE.createTransitionInfo();
							currentResult.getInfos().add(info);
							info.setAnalyzedElement(findEObject(id));
							info.getConfidenceInterval().add((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, lower));
							info.getConfidenceInterval().add((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, upper));
							continue;
						} else if ((matcher = placePattern.matcher(line.trim())).matches()) {
							String id = matcher.group("place");
							String lower = matcher.group("cilower");
							String upper = matcher.group("ciupper");
							info = WnsimFactory.eINSTANCE.createPlaceInfo();
							currentResult.getInfos().add(info);
							info.setAnalyzedElement(findEObject(id));
							info.getConfidenceInterval().add((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, lower));
							info.getConfidenceInterval().add((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, upper));
							continue;
						} else if ((matcher = valuePattern.matcher(line.trim())).matches()) {
							String value = matcher.group("value");
							if (info instanceof PlaceInfo) {
								((PlaceInfo) info).setMeanNumberOfTokens((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, value));
							} else if (info instanceof TransitionInfo) {
								((TransitionInfo) info).setThroughput((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, value));
								((TransitionInfo) info).setUnit(getBaseFrequencyUnit());
							} else {
								throw new RuntimeException("Expected PlaceInfo or TransitionInfo");
							}
							continue;
						} else if (line.startsWith(STS_EFFICIENCY)) {
							continue;
						} else if (line.startsWith(STS_TIME_REQUIRED)) {
							continue;
						} else if (line.startsWith(STS_MALLOC)) {
							continue;
						} else if (line.startsWith(STS_PUSH)) {
							continue;
						} else if (line.startsWith(STS_POP)) {
							continue;
							// Errors at the end: they are the least common
						} else if (line.equals(STR_PARSING_ERROR)) {
							throw new RuntimeException(line);
						} else if (line.equals(STR_INITIAL_DEAD_MARKING)) {
							throw new RuntimeException(line);
						} else if (line.startsWith(STS_DEAD_MARKING)) {
							throw new RuntimeException(line);
						} else {
							DiceLogger.logWarning(GspnSshSimulationPlugin.getDefault(), "Unmatched line while processing WNSIM output: " + line);
						}
					}
					latestResult = currentResult;
				} catch (IOException e) {
					if (!killed) {
						DiceLogger.logException(GspnSshSimulationPlugin.getDefault(), e);
					}
				}
			}
		};

		private class NoHostVerifier implements HostKeyVerifier {
			@Override
			public boolean verify(String s, int i, PublicKey publicKey) {
				return true;
			}
		}

		private SSHClient ssh;
		private Session simulationSession;
		private Command simulationCommand;
		private OutputStream outputStream;
		private InputStream inputStream;
		private InputStream errorStream;
		private Thread simulationFinishedThread;
		private ResultBuilder resultBuilder;

		private String remoteWorkingDir;
		private String identifier;
		private volatile boolean finished = false;
		private volatile boolean killed = false;
		private volatile int exitValue = RET_CODE_UNKNOWN_ERROR;

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
			try {
				ssh.loadKnownHosts();
			} catch (IOException e) {
				DiceLogger.logWarning(GspnSshSimulationPlugin.getDefault(), "Unable to load 'known_hosts' file",e);
			}
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
			StringBuilder builder = new StringBuilder(); //$NON-NLS-1$
			if (options.containsKey(SimulationParameters.BINARY_FILE_PATH.getLiteral())) {
				builder.append(options.get(SimulationParameters.BINARY_FILE_PATH.getLiteral()));
			} else {
				builder.append("/usr/local/GreatSPN/bin/WNSIM");
			}
			builder.append(" %s/%s ");
			for (Entry<String, String> option : options.entrySet()) {
				if (option.getKey().startsWith("-")) {
					// Include only options that represent a command line parameter
					// i.e., ignore the BINARY_FILE_PATH option
					builder.append(MessageFormat.format("{0} {1} ", option.getKey(), option.getValue())); //$NON-NLS-1$
				}
			}
			simulationCommand = simulationSession.exec(String.format(builder.toString(), remoteWorkingDir, identifier));
			
			PipedOutputStream stdoutOutputStream = new PipedOutputStream();

			resultBuilder = new ResultBuilder(new PipedInputStream(stdoutOutputStream));
			resultBuilder.start();

			inputStream = new TeeInputStream(simulationCommand.getInputStream(), stdoutOutputStream, true);
			errorStream = new TeeInputStream(simulationCommand.getErrorStream(), new NullOutputStream(), true);
			outputStream = new TeeOutputStream(simulationCommand.getOutputStream(), new NullOutputStream());

			simulationFinishedThread = addSimulationFinishedHook(simulationCommand);
		}

		private Thread addSimulationFinishedHook(final Channel channel) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						resultBuilder.join();
						channel.join();
						try (Session catSession = ssh.startSession();
								Command catCommand = catSession.exec(String.format("cat %s/%s.simres", remoteWorkingDir, identifier)) //$NON-NLS-1$
						) {
							catCommand.join();
							rawResults = IOUtils.readFully(catCommand.getInputStream()).toByteArray();
							finished = true;
							exitValue = simulationCommand.getExitStatus() != null ? simulationCommand.getExitStatus() : RET_CODE_UNKNOWN_ERROR;
						}
					} catch (ConnectionException e) {
						DiceLogger.logError(GspnSshSimulationPlugin.getDefault(),
								MessageFormat.format(Messages.GspnSshSimulator_connClosedError, ssh.getRemoteHostname(), ssh.getRemotePort()), e);
					} catch (InterruptedException e) {
						DiceLogger.logException(GspnSshSimulationPlugin.getDefault(), e);
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
			return outputStream;
		}

		@Override
		public InputStream getInputStream() {
			if (simulationCommand == null) {
				throw new IllegalStateException(Messages.GspnSshSimulator_connNotEstablishedError);
			}
			return inputStream;
		}

		@Override
		public InputStream getErrorStream() {
			if (simulationCommand == null) {
				throw new IllegalStateException(Messages.GspnSshSimulator_connNotEstablishedError);
			}
			return errorStream;
		}

		@Override
		public int waitFor() throws InterruptedException {
			if (simulationFinishedThread == null) {
				throw new IllegalThreadStateException(Messages.GspnSshSimulator_threadNotStartedError);
			}
			simulationFinishedThread.join();
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
			killed = true;
			exitValue = RET_CODE_KILLED;
			IOUtils.closeQuietly(ssh, simulationSession, simulationCommand);
		}

		public ResultBuilder getResultBuilder() {
			return resultBuilder;
		}
	}

	private byte[] rawResults = new byte[0];
	private PetriNet petriNet;
	private GspnProcess gspnProcess;

	@Override
	public Process simulate(String id, List<EObject> analyzableModel, TraceSet traces, Map<String, String> options, IProgressMonitor monitor)
			throws SimulationException {

		SubMonitor subMonitor = SubMonitor.convert(monitor, 2);

		if (analyzableModel.size() != 1) {
			throw new SimulationException(new IllegalArgumentException(
					MessageFormat.format("Unexpected number of model elements, expecting 1 EObject, found {0}", analyzableModel.size())));
		} else if (!(analyzableModel.get(0) instanceof PetriNetDoc)) {
			throw new SimulationException(new IllegalArgumentException("Unexpected analyzable model type, expecting ''fr.lip6.move.pnml.ptnet.PetriNetDoc'' but received '" + analyzableModel.get(0).getClass().toString()+"'"));
		}

		PetriNetDoc petriNetDoc = (PetriNetDoc) analyzableModel.get(0);
		if (petriNetDoc.getNets().size() != 1) {
			throw new SimulationException(new IllegalArgumentException(
					MessageFormat.format("Unexpected number of model elements, expecting 1 EObject, found {0}", petriNetDoc.getNets().size())));
		} else if (!(petriNetDoc.getNets().get(0) instanceof PetriNet)) {
			throw new SimulationException(new IllegalArgumentException("Unexpected analyzable model type, expecting ''fr.lip6.move.pnml.ptnet.PetriNet''"));
		}

		File targetDir = GspnSshSimulationPlugin.getDefault().getStateLocation().append(id).toFile();
		
		if (!targetDir.exists()) {
			if (!targetDir.mkdirs()) {
				throw new SimulationException(MessageFormat.format("Unable to create temporaty directory ''{0}''", targetDir));
			}
		}

		gspnProcess = new GspnProcess(id);

		try {
			petriNet = petriNetDoc.getNets().get(0);

			// Run M2T transformation with a copy
			// Thus, we can change the ID, which is used to compute the file
			// name
			PetriNet copy = EcoreUtil.copy(petriNet);
			copy.setId(id);

			File[] inputFiles = generateGspnFiles(copy, targetDir, subMonitor.newChild(1));

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
		if (gspnProcess != null && gspnProcess.getResultBuilder() != null) {
			return gspnProcess.getResultBuilder().getLatestResult();
		}
		return null;
	}

	@Override
	public InputStream getRawResult() {
		return new ByteArrayInputStream(Arrays.copyOf(rawResults, rawResults.length));
	}

	Map<String, EObject> mappings;

	private EObject findEObject(String id) {
		if (mappings == null && petriNet != null) {
			mappings = new HashMap<>();
			for (Iterator<EObject> it = petriNet.eAllContents(); it.hasNext();) {
				EObject eObject = it.next();
				if (eObject instanceof PnObject) {
					mappings.put(((PnObject) eObject).getId(), eObject);
				}
			}
		}
		return mappings != null ? mappings.get(id) : null;
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
		return new File[] { targetDir.toPath().resolve(model.getId() + ".net").toFile(), targetDir.toPath().resolve(model.getId() + ".def").toFile() };
	}

	private static final String VALUE_PATTERN = "<value grammar=\"(.+)\">(.+)</value>";

	public String getBaseTimeUnit() throws IllegalArgumentException {
		if (petriNet != null) {
			for (ToolInfo info : petriNet.getToolspecifics()) {
				Matcher matcher = Pattern.compile(VALUE_PATTERN).matcher(info.getFormattedXMLBuffer());
				if (matcher.matches() && BaseUnitsConstants.BASE_TIME_UNIT.getLiteral().equals(matcher.group(1))) {
					try {
						return matcher.group(2);
					} catch (Throwable t) {
						DiceLogger.logError(GspnSshSimulationPlugin.getDefault(), t);
					}
				}
			}
		}
		return NonStandardUnits.TICK.getLiteral();
	}

	public String getBaseFrequencyUnit() throws IllegalArgumentException {
		String unit = getBaseTimeUnit();
		if (StringUtils.equals(unit, NonStandardUnits.TICK.getLiteral())) {
			return NonStandardUnits.EVENTS_PER_TICK.getLiteral();
		} else if (StringUtils.equals(unit, Units.SECOND.toString())) {
			return Units.HERTZ.toString();
		} else {
			throw new RuntimeException(MessageFormat.format("Unexpected time unit ''{0}''", unit));
		}
	}

}
