package test.es.unizar.disco.simulation.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.junit.BeforeClass;

import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.registry.SimulationInvocationsRegistry;
import es.unizar.disco.ssh.ui.DiceSshConnectorUiPlugin;
import es.unizar.disco.ssh.ui.preferences.PreferenceConstants;

public abstract class AbstractTest {

	
		
		public static ResourceSet resourceSet;
	
	// Hopefully "definition" will not be required (in case that the
		// "invocation" has the bidirectional reference)
		public static SimulationDefinition definition;
		public static SimulationInvocation invocation;

		// final static URI baseUri =
		// URI.createFileURI(SimulationInvocationsRegistry.FILES_DIRECTORY.getPath());
		final static URI baseUri = URI.createFileURI(SimulationInvocationsRegistry.FILES_DIRECTORY.getPath());
		final static String TEST_FILES_UUID = "cfcac620-a901-4526-b631-097bed907210";

		@BeforeClass
		public static void configureTests()throws IOException, URISyntaxException {
			loadModels();
			loadSshConfig();
			
		}
		private static void loadSshConfig() throws FileNotFoundException, IOException {
			Properties prop = new Properties();
			
			
			prop.load(new FileInputStream("src/test/resources/config.properties"));
			DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.PROVIDER.toString(),PreferenceConstants.PASSWORD_PROVIDER.toString());
			
			
			DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.HOST.toString(), prop.getProperty(PreferenceConstants.HOST.toString()));
			
			DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.PORT.toString(), prop.getProperty(PreferenceConstants.PORT.toString()));
			
			DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.USERNAME.toString(), prop.getProperty(PreferenceConstants.USERNAME.toString()));
			
			//DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setDefault(PreferenceConstants.PASSWORD.toString(), prop.getProperty(PreferenceConstants.PASSWORD.toString()));
			DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.PASSWORD.toString(), prop.getProperty(PreferenceConstants.PASSWORD.toString()));
			//DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().putValue(PreferenceConstants.PASSWORD.toString(), prop.getProperty(PreferenceConstants.PASSWORD.toString()));
			
			//((IPersistentPreferenceStore) DiceSshConnectorUiPlugin.getDefault().getPreferenceStore()).save();
			
			
		}
		public static void loadModels() throws IOException, URISyntaxException {

			System.out.println("Loading models from registry");

			// final URI defURI =
			// URI.createFileURI(Paths.get(ReliabilityNetGenerationTest.class.getResource("e4012c46-f3bb-41fe-99c2-1ffdba8cb4ef"
			// + ".def" + "." +
			// XMIResource.XMI_NS).toURI()).toFile().getAbsolutePath());
			final URI defURI = URI.createFileURI(
					Paths.get("src/test/resources/cb745d8a-44f7-46de-9167-7ce0e822f048" + ".def" + "." + XMIResource.XMI_NS)
							.toFile().getAbsolutePath());
			System.out.println("defURI is: " + defURI);

			final URI invURI = URI
					.createFileURI(Paths.get("src/test/resources/" + TEST_FILES_UUID + ".inv" + "." + XMIResource.XMI_NS)
							.toFile().getAbsolutePath());
			System.out.println("defURI is: " + invURI);
			// baseUri.appendSegment(TEST_FILES_UUID).appendFileExtension("inv")
			// .appendFileExtension(XMIResource.XMI_NS);

			definition = (SimulationDefinition) loadResourceFromUri(defURI);

			invocation = (SimulationInvocation) loadResourceFromUri(invURI);

		}

		protected static EObject loadResourceFromUri(URI theURI) throws IOException {
			Resource theResource = getResourceSet().getResource(theURI, true);
			theResource.load(Collections.EMPTY_MAP);
			return theResource.getContents().get(0);
		}

		protected static synchronized ResourceSet getResourceSet() {

			if (resourceSet == null) {
				resourceSet = new ResourceSetImpl();
			}
			return resourceSet;
		}
	
}
