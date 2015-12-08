/**
 */
package es.unizar.disco.pnconfig.impl;

import es.unizar.disco.pnconfig.AnalysisType;
import es.unizar.disco.pnconfig.PetriNetConfig;
import es.unizar.disco.pnconfig.PnconfigPackage;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Petri Net Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.pnconfig.impl.PetriNetConfigImpl#getAnalysisType <em>Analysis Type</em>}</li>
 *   <li>{@link es.unizar.disco.pnconfig.impl.PetriNetConfigImpl#getVariableAssignments <em>Variable Assignments</em>}</li>
 *   <li>{@link es.unizar.disco.pnconfig.impl.PetriNetConfigImpl#getInitialMarking <em>Initial Marking</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PetriNetConfigImpl extends MinimalEObjectImpl.Container implements PetriNetConfig {
	/**
	 * The default value of the '{@link #getAnalysisType() <em>Analysis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisType()
	 * @generated
	 * @ordered
	 */
	protected static final AnalysisType ANALYSIS_TYPE_EDEFAULT = AnalysisType.TRANSIENT;

	/**
	 * The cached value of the '{@link #getAnalysisType() <em>Analysis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisType()
	 * @generated
	 * @ordered
	 */
	protected AnalysisType analysisType = ANALYSIS_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariableAssignments() <em>Variable Assignments</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAssignments()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Float> variableAssignments;

	/**
	 * The cached value of the '{@link #getInitialMarking() <em>Initial Marking</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialMarking()
	 * @generated
	 * @ordered
	 */
	protected Map.Entry<String, Float> initialMarking;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PetriNetConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PnconfigPackage.Literals.PETRI_NET_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisType getAnalysisType() {
		return analysisType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisType(AnalysisType newAnalysisType) {
		AnalysisType oldAnalysisType = analysisType;
		analysisType = newAnalysisType == null ? ANALYSIS_TYPE_EDEFAULT : newAnalysisType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PnconfigPackage.PETRI_NET_CONFIG__ANALYSIS_TYPE, oldAnalysisType, analysisType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Float> getVariableAssignments() {
		if (variableAssignments == null) {
			variableAssignments = new EcoreEMap<String,Float>(PnconfigPackage.Literals.ESTRING_TO_EFLOAT_OBJECTS_MAP, EStringToEFloatObjectsMapImpl.class, this, PnconfigPackage.PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS);
		}
		return variableAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Map.Entry<String, Float> getInitialMarking() {
		if (initialMarking != null && ((EObject)initialMarking).eIsProxy()) {
			InternalEObject oldInitialMarking = (InternalEObject)initialMarking;
			initialMarking = (Map.Entry<String, Float>)eResolveProxy(oldInitialMarking);
			if (initialMarking != oldInitialMarking) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PnconfigPackage.PETRI_NET_CONFIG__INITIAL_MARKING, oldInitialMarking, initialMarking));
			}
		}
		return initialMarking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Float> basicGetInitialMarking() {
		return initialMarking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialMarking(Map.Entry<String, Float> newInitialMarking) {
		Map.Entry<String, Float> oldInitialMarking = initialMarking;
		initialMarking = newInitialMarking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PnconfigPackage.PETRI_NET_CONFIG__INITIAL_MARKING, oldInitialMarking, initialMarking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PnconfigPackage.PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS:
				return ((InternalEList<?>)getVariableAssignments()).basicRemove(otherEnd, msgs);
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
			case PnconfigPackage.PETRI_NET_CONFIG__ANALYSIS_TYPE:
				return getAnalysisType();
			case PnconfigPackage.PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS:
				if (coreType) return getVariableAssignments();
				else return getVariableAssignments().map();
			case PnconfigPackage.PETRI_NET_CONFIG__INITIAL_MARKING:
				if (resolve) return getInitialMarking();
				return basicGetInitialMarking();
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
			case PnconfigPackage.PETRI_NET_CONFIG__ANALYSIS_TYPE:
				setAnalysisType((AnalysisType)newValue);
				return;
			case PnconfigPackage.PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS:
				((EStructuralFeature.Setting)getVariableAssignments()).set(newValue);
				return;
			case PnconfigPackage.PETRI_NET_CONFIG__INITIAL_MARKING:
				setInitialMarking((Map.Entry<String, Float>)newValue);
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
			case PnconfigPackage.PETRI_NET_CONFIG__ANALYSIS_TYPE:
				setAnalysisType(ANALYSIS_TYPE_EDEFAULT);
				return;
			case PnconfigPackage.PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS:
				getVariableAssignments().clear();
				return;
			case PnconfigPackage.PETRI_NET_CONFIG__INITIAL_MARKING:
				setInitialMarking((Map.Entry<String, Float>)null);
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
			case PnconfigPackage.PETRI_NET_CONFIG__ANALYSIS_TYPE:
				return analysisType != ANALYSIS_TYPE_EDEFAULT;
			case PnconfigPackage.PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS:
				return variableAssignments != null && !variableAssignments.isEmpty();
			case PnconfigPackage.PETRI_NET_CONFIG__INITIAL_MARKING:
				return initialMarking != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (analysisType: ");
		result.append(analysisType);
		result.append(')');
		return result.toString();
	}

} //PetriNetConfigImpl
