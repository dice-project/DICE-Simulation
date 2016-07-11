/**
 */
package es.unizar.disco.simulation.models.wnsim.impl;

import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.WnsimPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Place Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.wnsim.impl.PlaceInfoImpl#getMeanNumberOfTokens <em>Mean Number Of Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlaceInfoImpl extends WnsimElementInfoImpl implements PlaceInfo {
	/**
	 * The default value of the '{@link #getMeanNumberOfTokens() <em>Mean Number Of Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanNumberOfTokens()
	 * @generated
	 * @ordered
	 */
	protected static final Number MEAN_NUMBER_OF_TOKENS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeanNumberOfTokens() <em>Mean Number Of Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanNumberOfTokens()
	 * @generated
	 * @ordered
	 */
	protected Number meanNumberOfTokens = MEAN_NUMBER_OF_TOKENS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WnsimPackage.Literals.PLACE_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number getMeanNumberOfTokens() {
		return meanNumberOfTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeanNumberOfTokens(Number newMeanNumberOfTokens) {
		Number oldMeanNumberOfTokens = meanNumberOfTokens;
		meanNumberOfTokens = newMeanNumberOfTokens;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WnsimPackage.PLACE_INFO__MEAN_NUMBER_OF_TOKENS, oldMeanNumberOfTokens, meanNumberOfTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number getValue() {
		return meanNumberOfTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WnsimPackage.PLACE_INFO__MEAN_NUMBER_OF_TOKENS:
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
			case WnsimPackage.PLACE_INFO__MEAN_NUMBER_OF_TOKENS:
				setMeanNumberOfTokens((Number)newValue);
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
			case WnsimPackage.PLACE_INFO__MEAN_NUMBER_OF_TOKENS:
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
			case WnsimPackage.PLACE_INFO__MEAN_NUMBER_OF_TOKENS:
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case WnsimPackage.PLACE_INFO___GET_VALUE:
				return getValue();
		}
		return super.eInvoke(operationID, arguments);
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

} //PlaceInfoImpl
