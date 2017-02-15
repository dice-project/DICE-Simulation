package es.unizar.disco.simulation.registry;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;

import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.invocation.InvocationFactory;
import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.InvocationSet;
import es.unizar.disco.simulation.models.invocation.InvocationsRegistry;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.simresult.SimulationResult;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.traces.TraceSet;

/**
 * A global registry that handles and persists {@link SimulationInvocation}s
 * 
 * This class is not thread safe
 * 
 * @author agomez
 *
 */
public class SimulationInvocationsRegistry {

	EContentAdapter invocationAdapter = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getFeature() == InvocationPackage.Literals.SIMULATION_INVOCATION__RESULT
					|| notification.getFeature() == InvocationPackage.Literals.SIMULATION_INVOCATION__TOOL_RESULT) {
				resourcefyInvocation((SimulationInvocation) notification.getNotifier());
			}
		};
	};

	public static final SimulationInvocationsRegistry INSTANCE = new SimulationInvocationsRegistry();

	public static final IPath BASE_LOCATION = DiceSimulationPlugin.getDefault().getStateLocation().makeAbsolute();

	public static final IPath REGISTRY_DIRECTORY_LOCATION = BASE_LOCATION.append("invocations");

	public static final File FILES_DIRECTORY = REGISTRY_DIRECTORY_LOCATION.toFile();

	public static final IPath REGISTRY_LOCATION = BASE_LOCATION.append("registry.xmi");

	private static final URI REGISTRY_URI = URI.createFileURI(REGISTRY_LOCATION.toString());

	private ResourceSet resourceSet;

	private Resource resource;

	private InvocationsRegistry registry;

	private SimulationInvocationsRegistry() {
	}

	/**
	 * Adds a new {@link SimulationInvocation} to the registry. The changes in
	 * the registry are not saved on disk until {@link #save()} is called
	 * 
	 * @param invocation
	 */
	public synchronized void register(SimulationInvocation invocation) {
		InvocationSet invocationSet = findInvocationSet(invocation);
		if (invocationSet == null) {
			invocationSet = InvocationFactory.eINSTANCE.createInvocationSet();
			invocationSet.setDefinition(invocation.getDefinition());
			getRegistry().getInvocationSets().add(invocationSet);
		}
		if (!invocationSet.getInvocations().contains(invocation)) {
			resourcefyInvocation(invocation);
			invocationSet.getInvocations().add(invocation);
			invocation.eAdapters().add(invocationAdapter);
		}
	}

	private InvocationSet findInvocationSet(SimulationInvocation invocation) {
		SimulationDefinition definition = invocation.getDefinition();
		for (InvocationSet set : getRegistry().getInvocationSets()) {
			if (StringUtils.equals(set.getIdentifier(), definition.getIdentifier())) {
				return set;
			}
		}
		return null;
	}

	/**
	 * Deletes all the information on the registry and all its associated files
	 */
	public synchronized void clear() {
		Object[] invocationSets = getRegistry().getInvocationSets().toArray();
		// Iterate over an array to avoid ConcurrentModificationExceptions
		for (Object set : invocationSets) {
			// Use EcoreUtil.delete(...) to ensure a proper deletion
			EcoreUtil.delete((EObject) set, true);
		}
		// Delete all resources
		for (Iterator<Resource> it = getResourceSet().getResources().iterator(); it.hasNext();) {
			Resource resource = it.next();
			if (resource != getResource()) {
				it.remove();
			}
		}

		FileUtils.deleteQuietly(FILES_DIRECTORY);
		FileUtils.deleteQuietly(new File(REGISTRY_URI.toFileString()));
	}

	/**
	 * Saves the registry on disk discarding dangling HREF references. This
	 * method behaves like <code>save(true)</code>.
	 * 
	 * @throws IOException
	 */
	public synchronized void save() throws IOException {
		save(true);
	}

	/**
	 * Saves the registry on disk. If discard is set to true, dangling HREF
	 * references will be ignored.
	 * 
	 * @param discard
	 *            whether dangling HREF references will be discarded or not
	 * @throws IOException
	 */
	public synchronized void save(boolean discard) throws IOException {
		if (!FILES_DIRECTORY.exists()) {
			if (!FILES_DIRECTORY.mkdirs()) {
				throw new RuntimeException(
						MessageFormat.format("Unable to create directory ''{0}''", FILES_DIRECTORY.toString()));
			}
		}
		Map<String, String> options = new HashMap<>();
		if (discard) {
			options.put(XMIResource.OPTION_PROCESS_DANGLING_HREF, XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		}
		for (Resource resource : getResourceSet().getResources()) {
			URI baseLocationUri = URI.createFileURI(BASE_LOCATION.toString());
			if (resource.getURI().toString().startsWith(baseLocationUri.toString())) {
				resource.save(options);
			}
		}
	}

	/**
	 * Returns the instance of the {@link InvocationsRegistry} that contains all
	 * the registered {@link SimulationInvocation}s
	 * <p/>
	 * <b>Warning!</b> clients obtaining the {@link InvocationsRegistry} should
	 * not modify it
	 * 
	 * @return the {@link InvocationsRegistry}
	 */
	public synchronized InvocationsRegistry getRegistry() {
		if (registry == null) {
			if (getResource().getContents().isEmpty()) {
				registry = InvocationFactory.eINSTANCE.createInvocationsRegistry();
				getResource().getContents().add(registry);
			} else {
				registry = (InvocationsRegistry) getResource().getContents().get(0);
			}
		}
		return registry;
	}

	public synchronized ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	private synchronized Resource getResource() {
		if (resource == null) {
			try {
				if (new File(REGISTRY_URI.toFileString()).exists()) {
					resource = getResourceSet().getResource(REGISTRY_URI, true);
				} else {
					resource = getResourceSet().createResource(REGISTRY_URI);
					resource.save(Collections.emptyMap());
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return resource;
	}

	private synchronized void resourcefyInvocation(SimulationInvocation invocation) {
		final URI baseUri = URI.createFileURI(FILES_DIRECTORY.getPath());

		final URI defURI = baseUri.appendSegment(invocation.getDefinition().getIdentifier()).appendFileExtension("def")
				.appendFileExtension(XMIResource.XMI_NS);
		final URI invURI = baseUri.appendSegment(invocation.getIdentifier()).appendFileExtension("inv")
				.appendFileExtension(XMIResource.XMI_NS);
		final URI anmURI = baseUri.appendSegment(invocation.getIdentifier()).appendFileExtension("anm")
				.appendFileExtension(XMIResource.XMI_NS);
		final URI trcURI = baseUri.appendSegment(invocation.getIdentifier()).appendFileExtension("trc")
				.appendFileExtension(XMIResource.XMI_NS);
		final URI trsURI = baseUri.appendSegment(invocation.getIdentifier()).appendFileExtension("trs")
				.appendFileExtension(XMIResource.XMI_NS);
		final URI resURI = baseUri.appendSegment(invocation.getIdentifier()).appendFileExtension("res")
				.appendFileExtension(XMIResource.XMI_NS);

		// Save the invocation
		if (invocation != null && invocation.eResource() == null) {
			Resource invResource = getResourceSet().createResource(invURI);
			invResource.getContents().add(invocation);
		}

		// Save the definition
		SimulationDefinition definition = invocation.getDefinition();
		if (definition != null && definition.eResource() == null) {
			Resource defResource = getResourceSet().createResource(defURI);
			defResource.getContents().add(definition);
		}
		// Save the analyzable model
		EList<EObject> analyzableModel = invocation.getAnalyzableModel();
		if (!analyzableModel.isEmpty() && analyzableModel.get(0).eResource() == null) {
			Resource anmResource = getResourceSet().createResource(anmURI);
			anmResource.getContents().addAll(analyzableModel);
		}

		// Save the traces
		TraceSet traceSet = invocation.getTraceSet();
		if (traceSet != null && traceSet.eResource() == null) {
			Resource trcResource = getResourceSet().createResource(trcURI);
			trcResource.getContents().add(traceSet);
		}

		// Save the tool result
		ToolResult toolResult = invocation.getToolResult();
		if (toolResult != null && toolResult.eResource() == null) {
			Resource trsResource = getResourceSet().createResource(trsURI);
			trsResource.getContents().add(toolResult);
		}

		// Save the result
		SimulationResult result = invocation.getResult();
		if (result != null && result.eResource() == null) {
			Resource resResource = getResourceSet().createResource(resURI);
			resResource.getContents().add(result);
		}
	}
}
