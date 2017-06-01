package es.unizar.disco.simulation.local.calculators;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;

public abstract class AbstractCalculator {

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
	
	private boolean listContainStereotype(EList<Stereotype> appliedStereotypes, String stereotypeName) {
		for (Stereotype s : appliedStereotypes) {
			if(s.getName().equalsIgnoreCase(stereotypeName)){return true;}
		}
		return false;
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
	
}
