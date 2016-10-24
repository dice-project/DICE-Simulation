package test.es.unizar.disco.profiles.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Test;

import test.es.unizar.disco.simulation.tests.AbstractTest;

public class DdsmTest extends AbstractTest {

	@Test
	public void testPresenceStereotypes() throws IOException {

		Model depl = (Model) loadUMLModel("ddsm/ddsmTest").getPackagedElements().get(0);
		System.out.println("model name is: " + depl.getName());

		assertTrue("Cannot get element Node with stereotype DdsmKafka", contains(depl.getPackagedElements(), "DdsmKafka"));
		assertTrue("Cannot get element Node with stereotype DdsmInternalComponent", contains(depl.getPackagedElements(), "DdsmInternalComponent"));
		assertTrue("Cannot get element Node with stereotype DdsmNimbus", contains(depl.getPackagedElements(), "DdsmNimbus"));
		assertTrue("Cannot get element Node with stereotype DdsmPort", contains(depl.getPackagedElements(), "DdsmPort"));
		assertTrue("Cannot get element Node with stereotype DdsmResource", contains(depl.getPackagedElements(), "DdsmResource"));
		assertTrue("Cannot get element Node with stereotype DdsmStormCluster", contains(depl.getPackagedElements(), "DdsmStormCluster"));
		assertTrue("Cannot get element Node with stereotype DdsmSupervisor", contains(depl.getPackagedElements(), "DdsmSupervisor"));
		assertTrue("Cannot get element Node with stereotype DdsmVm", contains(depl.getPackagedElements(), "DdsmVm"));
		assertTrue("Cannot get element Node with stereotype DdsmYarnResourceManager", contains(depl.getPackagedElements(), "DdsmYarnResourceManager"));
		assertTrue("Cannot get element Node with stereotype DdsmZookeeperServer", contains(depl.getPackagedElements(), "DdsmZookeeperServer"));
		assertTrue("Cannot get element Node with stereotype JobSubmission", contains(depl.getPackagedElements(), "JobSubmission"));
		
	

	}

	private boolean contains(List<? extends PackageableElement> elements, String stereotypeName) {

		for (PackageableElement e : elements) {

			if (e instanceof Device) {
				System.out.println("Device " + e.getName() ); printListStereotypes(e.getAppliedStereotypes());
				if(listContainStereotype(((Device) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
				if(contains(((Device )e).getNestedNodes(),stereotypeName)){
					return true;
				}
			}
			if (e instanceof Node) {
				System.out.println("Node " + e.getName() ); printListStereotypes(e.getAppliedStereotypes());
				if(listContainStereotype(((Node) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
				if(contains(((Node )e).getNestedNodes(),stereotypeName)){
					return true;
				}

				
			}
			if (e instanceof Artifact) {
				System.out.println("Artifact " + e.getName() ); printListStereotypes(e.getAppliedStereotypes());
				if(listContainStereotype(((Artifact) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
				if(contains(((Artifact )e).getNestedArtifacts(),stereotypeName)){
					return true;
				}
			}
			
			if (e instanceof CommunicationPath) {
				System.out.println("Communication Path " + e.getName() ); printListStereotypes(e.getAppliedStereotypes());
				if(listContainStereotype(((CommunicationPath) e).getAppliedStereotypes(),stereotypeName)){
					return true;
				}
			}
			if (e instanceof Deployment) {
				System.out.println("Deployment " + e.getName() ); printListStereotypes(e.getAppliedStereotypes());
				if(listContainStereotype(((Deployment) e).getAppliedStereotypes(),stereotypeName)){
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

	private void printListStereotypes(EList<Stereotype> appliedStereotypes) {
		for (Stereotype s : appliedStereotypes) {
			System.out.println("Stereotype: " + s.getKeyword() + " label " + s.getLabel() + " name " + s.getName()
					+ " qualified name " + s.getQualifiedName() + " attributes " + s.getAllAttributes().toString());
		}

	}

}
