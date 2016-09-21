/**
 */
package es.unizar.disco.simulation.models.invocation.impl;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.InvocationsRegistry;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocations Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.impl.InvocationsRegistryImpl#getInvocations <em>Invocations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvocationsRegistryImpl extends MinimalEObjectImpl.Container implements InvocationsRegistry {
	/**
	 * The cached value of the '{@link #getInvocations() <em>Invocations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocations()
	 * @generated
	 * @ordered
	 */
	protected EList<SimulationInvocation> invocations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvocationsRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvocationPackage.Literals.INVOCATIONS_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimulationInvocation> getInvocations() {
		if (invocations == null) {
			invocations = new EObjectResolvingEList<SimulationInvocation>(SimulationInvocation.class, this, InvocationPackage.INVOCATIONS_REGISTRY__INVOCATIONS);
		}
		return invocations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InvocationPackage.INVOCATIONS_REGISTRY__INVOCATIONS:
				return getInvocations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InvocationPackage.INVOCATIONS_REGISTRY__INVOCATIONS:
				getInvocations().clear();
				getInvocations().addAll((Collection<? extends SimulationInvocation>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InvocationPackage.INVOCATIONS_REGISTRY__INVOCATIONS:
				getInvocations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InvocationPackage.INVOCATIONS_REGISTRY__INVOCATIONS:
				return invocations != null && !invocations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InvocationsRegistryImpl
