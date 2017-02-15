/**
 */
package es.unizar.disco.simulation.models.simresult.impl;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import es.unizar.disco.simulation.models.measures.DomainMeasure;

import es.unizar.disco.simulation.models.simresult.SimresultPackage;
import es.unizar.disco.simulation.models.simresult.SimulationResult;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.simresult.impl.SimulationResultImpl#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.simresult.impl.SimulationResultImpl#getMeasures <em>Measures</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulationResultImpl extends MinimalEObjectImpl.Container implements SimulationResult {
	/**
	 * The cached value of the '{@link #getInvocation() <em>Invocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocation()
	 * @generated
	 * @ordered
	 */
	protected SimulationInvocation invocation;

	/**
	 * The cached value of the '{@link #getMeasures() <em>Measures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasures()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainMeasure> measures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimresultPackage.Literals.SIMULATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationInvocation getInvocation() {
		if (invocation != null && invocation.eIsProxy()) {
			InternalEObject oldInvocation = (InternalEObject)invocation;
			invocation = (SimulationInvocation)eResolveProxy(oldInvocation);
			if (invocation != oldInvocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimresultPackage.SIMULATION_RESULT__INVOCATION, oldInvocation, invocation));
			}
		}
		return invocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationInvocation basicGetInvocation() {
		return invocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvocation(SimulationInvocation newInvocation, NotificationChain msgs) {
		SimulationInvocation oldInvocation = invocation;
		invocation = newInvocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimresultPackage.SIMULATION_RESULT__INVOCATION, oldInvocation, newInvocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvocation(SimulationInvocation newInvocation) {
		if (newInvocation != invocation) {
			NotificationChain msgs = null;
			if (invocation != null)
				msgs = ((InternalEObject)invocation).eInverseRemove(this, InvocationPackage.SIMULATION_INVOCATION__RESULT, SimulationInvocation.class, msgs);
			if (newInvocation != null)
				msgs = ((InternalEObject)newInvocation).eInverseAdd(this, InvocationPackage.SIMULATION_INVOCATION__RESULT, SimulationInvocation.class, msgs);
			msgs = basicSetInvocation(newInvocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimresultPackage.SIMULATION_RESULT__INVOCATION, newInvocation, newInvocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainMeasure> getMeasures() {
		if (measures == null) {
			measures = new EObjectContainmentEList<DomainMeasure>(DomainMeasure.class, this, SimresultPackage.SIMULATION_RESULT__MEASURES);
		}
		return measures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimresultPackage.SIMULATION_RESULT__INVOCATION:
				if (invocation != null)
					msgs = ((InternalEObject)invocation).eInverseRemove(this, InvocationPackage.SIMULATION_INVOCATION__RESULT, SimulationInvocation.class, msgs);
				return basicSetInvocation((SimulationInvocation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimresultPackage.SIMULATION_RESULT__INVOCATION:
				return basicSetInvocation(null, msgs);
			case SimresultPackage.SIMULATION_RESULT__MEASURES:
				return ((InternalEList<?>)getMeasures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimresultPackage.SIMULATION_RESULT__INVOCATION:
				if (resolve) return getInvocation();
				return basicGetInvocation();
			case SimresultPackage.SIMULATION_RESULT__MEASURES:
				return getMeasures();
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
			case SimresultPackage.SIMULATION_RESULT__INVOCATION:
				setInvocation((SimulationInvocation)newValue);
				return;
			case SimresultPackage.SIMULATION_RESULT__MEASURES:
				getMeasures().clear();
				getMeasures().addAll((Collection<? extends DomainMeasure>)newValue);
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
			case SimresultPackage.SIMULATION_RESULT__INVOCATION:
				setInvocation((SimulationInvocation)null);
				return;
			case SimresultPackage.SIMULATION_RESULT__MEASURES:
				getMeasures().clear();
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
			case SimresultPackage.SIMULATION_RESULT__INVOCATION:
				return invocation != null;
			case SimresultPackage.SIMULATION_RESULT__MEASURES:
				return measures != null && !measures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SimulationResultImpl
