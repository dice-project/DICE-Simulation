/**
 */
package es.unizar.disco.simulation.models.toolresult.impl;

import es.unizar.disco.simulation.models.datatypes.Unit;

import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolresultPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analyzable Element Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.toolresult.impl.AnalyzableElementInfoImpl#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.toolresult.impl.AnalyzableElementInfoImpl#getAnalyzedElement <em>Analyzed Element</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.toolresult.impl.AnalyzableElementInfoImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AnalyzableElementInfoImpl extends MinimalEObjectImpl.Container implements AnalyzableElementInfo {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Number VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Number value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnalyzedElement() <em>Analyzed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzedElement()
	 * @generated
	 * @ordered
	 */
	protected EObject analyzedElement;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final Unit UNIT_EDEFAULT = Unit.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected Unit unit = UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalyzableElementInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolresultPackage.Literals.ANALYZABLE_ELEMENT_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Number newValue) {
		Number oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolresultPackage.ANALYZABLE_ELEMENT_INFO__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getAnalyzedElement() {
		if (analyzedElement != null && analyzedElement.eIsProxy()) {
			InternalEObject oldAnalyzedElement = (InternalEObject)analyzedElement;
			analyzedElement = eResolveProxy(oldAnalyzedElement);
			if (analyzedElement != oldAnalyzedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ToolresultPackage.ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT, oldAnalyzedElement, analyzedElement));
			}
		}
		return analyzedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetAnalyzedElement() {
		return analyzedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalyzedElement(EObject newAnalyzedElement) {
		EObject oldAnalyzedElement = analyzedElement;
		analyzedElement = newAnalyzedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolresultPackage.ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT, oldAnalyzedElement, analyzedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(Unit newUnit) {
		Unit oldUnit = unit;
		unit = newUnit == null ? UNIT_EDEFAULT : newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolresultPackage.ANALYZABLE_ELEMENT_INFO__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__VALUE:
				return getValue();
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT:
				if (resolve) return getAnalyzedElement();
				return basicGetAnalyzedElement();
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__UNIT:
				return getUnit();
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
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__VALUE:
				setValue((Number)newValue);
				return;
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT:
				setAnalyzedElement((EObject)newValue);
				return;
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__UNIT:
				setUnit((Unit)newValue);
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
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT:
				setAnalyzedElement((EObject)null);
				return;
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__UNIT:
				setUnit(UNIT_EDEFAULT);
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
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT:
				return analyzedElement != null;
			case ToolresultPackage.ANALYZABLE_ELEMENT_INFO__UNIT:
				return unit != UNIT_EDEFAULT;
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
		result.append(" (value: ");
		result.append(value);
		result.append(", unit: ");
		result.append(unit);
		result.append(')');
		return result.toString();
	}

} //AnalyzableElementInfoImpl
