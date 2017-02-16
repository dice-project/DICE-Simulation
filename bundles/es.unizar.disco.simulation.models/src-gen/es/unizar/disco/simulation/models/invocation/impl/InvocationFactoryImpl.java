/**
 */
package es.unizar.disco.simulation.models.invocation.impl;

import es.unizar.disco.simulation.models.invocation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvocationFactoryImpl extends EFactoryImpl implements InvocationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InvocationFactory init() {
		try {
			InvocationFactory theInvocationFactory = (InvocationFactory)EPackage.Registry.INSTANCE.getEFactory(InvocationPackage.eNS_URI);
			if (theInvocationFactory != null) {
				return theInvocationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InvocationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case InvocationPackage.SIMULATION_INVOCATION: return createSimulationInvocation();
			case InvocationPackage.INVOCATIONS_REGISTRY: return createInvocationsRegistry();
			case InvocationPackage.INVOCATION_SET: return createInvocationSet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationInvocation createSimulationInvocation() {
		SimulationInvocationImpl simulationInvocation = new SimulationInvocationImpl();
		return simulationInvocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationsRegistry createInvocationsRegistry() {
		InvocationsRegistryImpl invocationsRegistry = new InvocationsRegistryImpl();
		return invocationsRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationSet createInvocationSet() {
		InvocationSetImpl invocationSet = new InvocationSetImpl();
		return invocationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationPackage getInvocationPackage() {
		return (InvocationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InvocationPackage getPackage() {
		return InvocationPackage.eINSTANCE;
	}

} //InvocationFactoryImpl
