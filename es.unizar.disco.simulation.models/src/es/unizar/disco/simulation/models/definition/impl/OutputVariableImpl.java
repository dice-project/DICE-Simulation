/**
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.datatypes.Unit;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.OutputVariable;

import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl#getMeasuredElement <em>Measured Element</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutputVariableImpl extends VariableImpl implements OutputVariable {
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
	protected OutputVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefinitionPackage.Literals.OUTPUT_VARIABLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.OUTPUT_VARIABLE__VALUE, oldValue, value));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DefinitionPackage.OUTPUT_VARIABLE__MEASURED_ELEMENT, oldMeasuredElement, measuredElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.OUTPUT_VARIABLE__MEASURED_ELEMENT, oldMeasuredElement, measuredElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.OUTPUT_VARIABLE__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DefinitionPackage.OUTPUT_VARIABLE__VALUE:
				return getValue();
			case DefinitionPackage.OUTPUT_VARIABLE__MEASURED_ELEMENT:
				if (resolve) return getMeasuredElement();
				return basicGetMeasuredElement();
			case DefinitionPackage.OUTPUT_VARIABLE__UNIT:
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
			case DefinitionPackage.OUTPUT_VARIABLE__VALUE:
				setValue((Number)newValue);
				return;
			case DefinitionPackage.OUTPUT_VARIABLE__MEASURED_ELEMENT:
				setMeasuredElement((EObject)newValue);
				return;
			case DefinitionPackage.OUTPUT_VARIABLE__UNIT:
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
			case DefinitionPackage.OUTPUT_VARIABLE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case DefinitionPackage.OUTPUT_VARIABLE__MEASURED_ELEMENT:
				setMeasuredElement((EObject)null);
				return;
			case DefinitionPackage.OUTPUT_VARIABLE__UNIT:
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
			case DefinitionPackage.OUTPUT_VARIABLE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case DefinitionPackage.OUTPUT_VARIABLE__MEASURED_ELEMENT:
				return measuredElement != null;
			case DefinitionPackage.OUTPUT_VARIABLE__UNIT:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DomainMeasure.class) {
			switch (derivedFeatureID) {
				case DefinitionPackage.OUTPUT_VARIABLE__VALUE: return MeasuresPackage.DOMAIN_MEASURE__VALUE;
				case DefinitionPackage.OUTPUT_VARIABLE__MEASURED_ELEMENT: return MeasuresPackage.DOMAIN_MEASURE__MEASURED_ELEMENT;
				case DefinitionPackage.OUTPUT_VARIABLE__UNIT: return MeasuresPackage.DOMAIN_MEASURE__UNIT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DomainMeasure.class) {
			switch (baseFeatureID) {
				case MeasuresPackage.DOMAIN_MEASURE__VALUE: return DefinitionPackage.OUTPUT_VARIABLE__VALUE;
				case MeasuresPackage.DOMAIN_MEASURE__MEASURED_ELEMENT: return DefinitionPackage.OUTPUT_VARIABLE__MEASURED_ELEMENT;
				case MeasuresPackage.DOMAIN_MEASURE__UNIT: return DefinitionPackage.OUTPUT_VARIABLE__UNIT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //OutputVariableImpl
