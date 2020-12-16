package test.es.unizar.disco.simulation.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPlugin;
import org.junit.BeforeClass;

import com.masdes.dam.Basic_Data_Types.Basic_Data_TypesPackage;
import com.masdes.dam.Complex_Data_Types.Complex_Data_TypesPackage;
import com.masdes.dam.Core.CorePackage;
import com.masdes.dam.DAM.DAMPackage;

import es.unizar.disco.dice.DICE.DICEPackage;
import es.unizar.disco.dice.DPIM.DPIMPackage;
import es.unizar.disco.simulation.models.builders.IAnalyzableModelBuilder.ModelResult;
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
	static boolean firstTime = false;

	@BeforeClass
	public static void configureTests() throws IOException, URISyntaxException {
		loadDefaultModels();
		loadSshConfig();

	}

	private static void loadSshConfig() throws FileNotFoundException, IOException {
		Properties prop = new Properties();

		prop.load(new FileInputStream("src/test/resources/config.properties"));
		DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.PROVIDER.toString(),
				PreferenceConstants.PASSWORD_PROVIDER.toString());

		DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.HOST.toString(),
				prop.getProperty(PreferenceConstants.HOST.toString()));

		DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.PORT.toString(),
				prop.getProperty(PreferenceConstants.PORT.toString()));

		DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.USERNAME.toString(),
				prop.getProperty(PreferenceConstants.USERNAME.toString()));

		// DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setDefault(PreferenceConstants.PASSWORD.toString(),
		// prop.getProperty(PreferenceConstants.PASSWORD.toString()));
		DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().setValue(PreferenceConstants.PASSWORD.toString(),
				prop.getProperty(PreferenceConstants.PASSWORD.toString()));
		// DiceSshConnectorUiPlugin.getDefault().getPreferenceStore().putValue(PreferenceConstants.PASSWORD.toString(),
		// prop.getProperty(PreferenceConstants.PASSWORD.toString()));

		// ((IPersistentPreferenceStore)
		// DiceSshConnectorUiPlugin.getDefault().getPreferenceStore()).save();

	}

	public static void loadDefaultModels() throws IOException, URISyntaxException {

		System.out.println("Loading models from registry");

		loadModels("cb745d8a-44f7-46de-9167-7ce0e822f048", TEST_FILES_UUID);

	}

	public static void loadModels(String defmodel, String invmodel) throws IOException {


		final URI defURI = URI.createFileURI(Paths
				.get("src/test/resources/" + defmodel + ".def" + "." + XMIResource.XMI_NS).toFile().getAbsolutePath());
		System.out.println("defURI is: " + defURI);

		final URI invURI = URI.createFileURI(Paths
				.get("src/test/resources/" + invmodel + ".inv" + "." + XMIResource.XMI_NS).toFile().getAbsolutePath());
		System.out.println("defURI is: " + invURI);

		definition = (SimulationDefinition) loadResourceFromUri(defURI);
		invocation = (SimulationInvocation) loadResourceFromUri(invURI);

		//loadProfilesAndRegisterTheirPackages();

	}

	public static Model loadUMLModel(String modelpath) throws IOException {
		final URI modelURI = URI
				.createFileURI(Paths.get("src/test/resources/" + modelpath + ".uml").toFile().getAbsolutePath());
		System.out.println("umlModelURI is: " + modelURI);
		return (Model) loadResourceFromUri(modelURI);

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

	protected void saveAnalyzbleModelResult(ModelResult result, String name) throws IOException {

		final URI producedAAM_URI = URI.createFileURI(Paths.get(name).toFile().getAbsolutePath());

		Resource producedModelResource = getResourceSet().createResource(producedAAM_URI);
		producedModelResource.getContents().add(result.getModel().get(0));
		producedModelResource.save(Collections.EMPTY_MAP);

	}
	
	
	@SuppressWarnings("unused")
	private static void loadProfilesAndRegisterTheirPackages() {

		Object o = DICEPackage.eINSTANCE;
		DICEPackage.eINSTANCE.getEFactoryInstance();
		o = DPIMPackage.eINSTANCE;
		DPIMPackage.eINSTANCE.getEFactoryInstance();
		o = org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eINSTANCE;
		org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eINSTANCE.getEFactoryInstance();
		o = DAMPackage.eINSTANCE;
		o = Basic_Data_TypesPackage.eINSTANCE;
		Basic_Data_TypesPackage.eINSTANCE.getEFactoryInstance();
		o = Complex_Data_TypesPackage.eINSTANCE;
		Complex_Data_TypesPackage.eINSTANCE.getEFactoryInstance();
		DAMPackage.eINSTANCE.getEFactoryInstance();
		o = CorePackage.eINSTANCE;
		CorePackage.eINSTANCE.getEFactoryInstance();

		for (ProfileApplication profileApplication : ((Element) definition.getActiveScenario()).getModel()
				.getAllProfileApplications()) {

			profileApplication.getAppliedProfile().define();
			printReportOnProfile(profileApplication.getAppliedProfile());
			List<EObject> list = ((Element) definition.getActiveScenario()).getModel()
					.applyProfile(profileApplication.getAppliedProfile());
		}
		checkIfModelHasAppliedStereotypes(((Element) definition.getActiveScenario()).getModel(), "  ");

		EcorePlugin.getPlatformResourceMap().put("pathmap://Papyrus_PROFILES/",
				URI.createFileURI(Paths.get("src/test/resources/").toFile().getAbsolutePath()).appendSegment(""));
		EcorePlugin.getPlatformResourceMap().put("pathmap://DICE_PROFILES/",
				URI.createFileURI(Paths.get("src/test/resources/").toFile().getAbsolutePath()).appendSegment(""));
		EcorePlugin.getPlatformResourceMap().put("pathmap://DAM_PROFILES/",
				URI.createFileURI(Paths.get("src/test/resources/").toFile().getAbsolutePath()).appendSegment(""));
		EcorePlugin.getPlatformResourceMap().put("pathmap://Papyrus_PROFILES/MARTE.profile.uml#_4bV20APMEdyuUt-4qHuVvQ",
				URI.createFileURI(Paths.get("src/test/resources/MARTE.profile.uml").toFile().getAbsolutePath())
						.appendFragment("_4bV20APMEdyuUt-4qHuVvQ"));

		UMLPlugin.getEPackageNsURIToProfileLocationMap().put(
				"pathmap://Papyrus_PROFILES/MARTE.profile.uml#_4bV20APMEdyuUt-4qHuVvQ",
				URI.createFileURI(Paths.get("src/test/resources/MARTE.profile.uml").toFile().getAbsolutePath())
						.appendFragment("_4bV20APMEdyuUt-4qHuVvQ"));

		UMLPlugin.getEPackageNsURIToProfileLocationMap().put("pathmap://DICE_PROFILES/",
				URI.createURI("platform:/plugin/es.unizar.disco.dice.static.profile/resources/"));
		EcorePlugin.getPlatformResourceMap().put("pathmap://DICE_PROFILES/",
				URI.createFileURI("platform:/plugin/es.unizar.disco.dice.static.profile/resources/"));
		UMLPlugin.getEPackageNsURIToProfileLocationMap().put("pathmap://DICE_LIBRARIES/",
				URI.createURI("platform:/plugin/es.unizar.disco.dice.static.profile/resources/"));
		EcorePlugin.getPlatformResourceMap().put("pathmap://DICE_LIBRARIES/",
				URI.createFileURI("platform:/plugin/es.unizar.disco.dice.static.profile/resources/"));

		UMLPlugin.getEPackageNsURIToProfileLocationMap().put("pathmap://DAM_PROFILES/",
				URI.createURI("platform:/plugin/com.masdes.dam.static.profile/resources/"));
		EcorePlugin.getPlatformResourceMap().put("pathmap://DAM_PROFILES/",
				URI.createFileURI("platform:/plugin/com.masdes.dam.static.profile/resources/"));

		UMLPlugin.getEPackageNsURIToProfileLocationMap().put(
				"pathmap://DICE_PROFILES/DICE.profile.uml#_gFr1YOebEeWj7ZPL8JeBTQ",
				URI.createFileURI(Paths.get("src/test/resources/DICE.profile.uml").toFile().getAbsolutePath())
						.appendFragment("_gFr1YOebEeWj7ZPL8JeBTQ"));

	}

	private static void checkIfModelHasAppliedStereotypes(Element model, String leftSpace) {

		for (Element element : model.getOwnedElements()) {
			System.out.println(leftSpace + "I'm Element " + element.toString());
			System.out.println(leftSpace + "I have applied stereotypes ( " + element.getAppliedStereotypes().size()
					+ " ) , which are: ");
			element.getAppliedStereotypes()
					.forEach((i -> System.out.println(leftSpace + "   Stereotype name is " + i.getQualifiedName())));
			if (element.getAppliedStereotypes().size() > 0 && element
					.getAppliedStereotype(element.getAppliedStereotypes().get(0).getQualifiedName()) != null) {
				System.out.println(leftSpace + "and I can enter "
						+ element.getAppliedStereotype(element.getAppliedStereotypes().get(0).getQualifiedName())
								.getName()
						+ " and the isStereotypeApplied returns: "
						+ element.isStereotypeApplied(element.getAppliedStereotypes().get(0)));
			}
			System.out.println(leftSpace + " and I can apply all of these stereotypes:("
					+ element.getApplicableStereotypes().size() + "):::");
			element.getApplicableStereotypes()
					.forEach((i -> System.out.println(leftSpace + "   Stereotype name is " + i.getQualifiedName())));
			System.out.println(leftSpace + "And I own these elements");
			checkIfModelHasAppliedStereotypes(element, leftSpace + "   ");
		}

	}

	private static void printReportOnProfile(Profile profile) {

		System.out.println("SHOWING INFO OF PROFILE " + profile.getQualifiedName());
		System.out.println("         Label: " + profile.getLabel());
		System.out.println("         Members: ");
		profile.getMembers().forEach((i -> System.out
				.println("                         Member of class" + i.getClass() + " and name" + i.getName())));
		System.out.println("         OwnedElements: ");
		profile.getOwnedElements().forEach((i -> System.out
				.println("                         Member of class" + i.getClass() + " and toString" + i.toString())));

	}

	protected boolean contains(List<? extends PackageableElement> elements, String stereotypeName) {

		for (PackageableElement e : elements) {

			if (e instanceof Device) {
				System.out.println("Device " + e.getName() ); 
				if(listContainStereotype(((Device) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
				if(contains(((Device )e).getNestedNodes(),stereotypeName)){
					return true;
				}
			}
			if (e instanceof Node) {
				System.out.println("Node " + e.getName() ); 
				if(listContainStereotype(((Node) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
				if(contains(((Node )e).getNestedNodes(),stereotypeName)){
					return true;
				}
				if(contains(((Node )e).getDeployments(), stereotypeName)){
					return true;
				}

				
			}
			if (e instanceof Artifact) {
				System.out.println("Artifact " + e.getName() ); 
				if(listContainStereotype(((Artifact) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
				if(contains(((Artifact )e).getNestedArtifacts(),stereotypeName)){
					return true;
				}
			}
			
			if (e instanceof CommunicationPath) {
				System.out.println("Communication Path " + e.getName() );
				if(listContainStereotype(((CommunicationPath) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
			}
			if (e instanceof Deployment) {
				System.out.println("Deployment " + e.getName() ); 
				if(listContainStereotype(((Deployment) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
			}
			
			if (e instanceof Dependency) {
				System.out.println("Dependency " + e.getName() ); 
				if(listContainStereotype(((Dependency) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
			}
		}

		return false;
	}

	private boolean listContainStereotype(EList<Stereotype> appliedStereotypes, String stereotypeName) {
		for (Stereotype s : appliedStereotypes) {
			if(s.getName().equalsIgnoreCase(stereotypeName)){return true;}
		}
		return false;
	}
	
	
	protected Element getStereotypedElement(List<? extends PackageableElement> elements, String stereotypeName) {

		for (PackageableElement e : elements) {

			if (e instanceof Device) {
				System.out.println("Device " + e.getName() ); 
				if(listContainStereotype(((Device) e).getAppliedStereotypes(),stereotypeName)){
					return  e;
				}
				if(contains(((Device )e).getNestedNodes(),stereotypeName)){
					return getStereotypedElement(((Device )e).getNestedNodes(),stereotypeName);
				}
			}
			if (e instanceof Node) {
				System.out.println("Node " + e.getName() ); 
				if(listContainStereotype(((Node) e).getAppliedStereotypes(),stereotypeName)){
					return e;
				}
				if(contains(((Node )e).getNestedNodes(),stereotypeName)){
					return getStereotypedElement(((Node )e).getNestedNodes(),stereotypeName);
				}
				if(contains(((Node )e).getDeployments(), stereotypeName)){
					return getStereotypedElement(((Node )e).getDeployments(), stereotypeName);
				}

				
			}
			if (e instanceof Artifact) {
				System.out.println("Artifact " + e.getName() ); 
				if(listContainStereotype(((Artifact) e).getAppliedStereotypes(),stereotypeName)){
					return  e;
				}
				if(contains(((Artifact )e).getNestedArtifacts(),stereotypeName)){
					return getStereotypedElement(((Artifact )e).getNestedArtifacts(),stereotypeName);
				}
			}
			
			if (e instanceof CommunicationPath) {
				System.out.println("Communication Path " + e.getName() );
				if(listContainStereotype(((CommunicationPath) e).getAppliedStereotypes(),stereotypeName)){
					return e;
				}
			}
			if (e instanceof Deployment) {
				System.out.println("Deployment " + e.getName() ); 
				if(listContainStereotype(((Deployment) e).getAppliedStereotypes(),stereotypeName)){
					return  e;
				}
			}
			
			if (e instanceof Dependency) {
				System.out.println("Dependency " + e.getName() ); 
				if(listContainStereotype(((Dependency) e).getAppliedStereotypes(),stereotypeName)){
					return  e;
				}
			}
		}

		return null;
	}



	
}
