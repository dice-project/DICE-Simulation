/**
 */
package es.unizar.disco.simulation.models.wnsim.impl;

import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import es.unizar.disco.simulation.models.wnsim.WnsimPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.wnsim.impl.TransitionInfoImpl#getMeanNumberOfTokens <em>Mean Number Of Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionInfoImpl extends WnsimElementInfoImpl implements TransitionInfo {
	/**
	 * The default value of the '{@link #getMeanNumberOfTokens() <em>Mean Number Of Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanNumberOfTokens()
	 * @generated
	 * @ordered
	 */
	protected static final Float MEAN_NUMBER_OF_TOKENS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeanNumberOfTokens() <em>Mean Number Of Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanNumberOfTokens()
	 * @generated
	 * @ordered
	 */
	protected Float meanNumberOfTokens = MEAN_NUMBER_OF_TOKENS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WnsimPackage.Literals.TRANSITION_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getMeanNumberOfTokens() {
		return meanNumberOfTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeanNumberOfTokens(Float newMeanNumberOfTokens) {
		Float oldMeanNumberOfTokens = meanNumberOfTokens;
		meanNumberOfTokens = newMeanNumberOfTokens;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WnsimPackage.TRANSITION_INFO__MEAN_NUMBER_OF_TOKENS, oldMeanNumberOfTokens, meanNumberOfTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WnsimPackage.TRANSITION_INFO__MEAN_NUMBER_OF_TOKENS:
				return getMeanNumberOfTokens();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WnsimPackage.TRANSITION_INFO__MEAN_NUMBER_OF_TOKENS:
				setMeanNumberOfTokens((Float)newValue);
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
			case WnsimPackage.TRANSITION_INFO__MEAN_NUMBER_OF_TOKENS:
				setMeanNumberOfTokens(MEAN_NUMBER_OF_TOKENS_EDEFAULT);
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
			case WnsimPackage.TRANSITION_INFO__MEAN_NUMBER_OF_TOKENS:
				return MEAN_NUMBER_OF_TOKENS_EDEFAULT == null ? meanNumberOfTokens != null : !MEAN_NUMBER_OF_TOKENS_EDEFAULT.equals(meanNumberOfTokens);
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
		result.append(" (meanNumberOfTokens: ");
		result.append(meanNumberOfTokens);
		result.append(')');
		return result.toString();
	}

} //TransitionInfoImpl
