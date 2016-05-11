/**
 */
package es.unizar.disco.simulation.models.measures.impl;

import es.unizar.disco.simulation.models.datatypes.Unit;

import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureImpl#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureImpl#getMeasuredElement <em>Measured Element</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DomainMeasureImpl extends MinimalEObjectImpl.Container implements DomainMeasure {
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
	 * The cached value of the '{@link #getMeasuredElement() <em>Measured Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredElement()
	 * @generated
	 * @ordered
	 */
	protected EObject measuredElement;

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
	protected DomainMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasuresPackage.Literals.DOMAIN_MEASURE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MeasuresPackage.DOMAIN_MEASURE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getMeasuredElement() {
		if (measuredElement != null && measuredElement.eIsProxy()) {
			InternalEObject oldMeasuredElement = (InternalEObject)measuredElement;
			measuredElement = eResolveProxy(oldMeasuredElement);
			if (measuredElement != oldMeasuredElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasuresPackage.DOMAIN_MEASURE__MEASURED_ELEMENT, oldMeasuredElement, measuredElement));
			}
		}
		return measuredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetMeasuredElement() {
		return measuredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasuredElement(EObject newMeasuredElement) {
		EObject oldMeasuredElement = measuredElement;
		measuredElement = newMeasuredElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasuresPackage.DOMAIN_MEASURE__MEASURED_ELEMENT, oldMeasuredElement, measuredElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MeasuresPackage.DOMAIN_MEASURE__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MeasuresPackage.DOMAIN_MEASURE__VALUE:
				return getValue();
			case MeasuresPackage.DOMAIN_MEASURE__MEASURED_ELEMENT:
				if (resolve) return getMeasuredElement();
				return basicGetMeasuredElement();
			case MeasuresPackage.DOMAIN_MEASURE__UNIT:
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
			case MeasuresPackage.DOMAIN_MEASURE__VALUE:
				setValue((Number)newValue);
				return;
			case MeasuresPackage.DOMAIN_MEASURE__MEASURED_ELEMENT:
				setMeasuredElement((EObject)newValue);
				return;
			case MeasuresPackage.DOMAIN_MEASURE__UNIT:
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
			case MeasuresPackage.DOMAIN_MEASURE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case MeasuresPackage.DOMAIN_MEASURE__MEASURED_ELEMENT:
				setMeasuredElement((EObject)null);
				return;
			case MeasuresPackage.DOMAIN_MEASURE__UNIT:
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
			case MeasuresPackage.DOMAIN_MEASURE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case MeasuresPackage.DOMAIN_MEASURE__MEASURED_ELEMENT:
				return measuredElement != null;
			case MeasuresPackage.DOMAIN_MEASURE__UNIT:
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

} //DomainMeasureImpl
