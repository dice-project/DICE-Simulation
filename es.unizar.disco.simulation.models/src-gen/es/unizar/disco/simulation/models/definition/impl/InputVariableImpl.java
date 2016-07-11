/**
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.VariableAssignment;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.InputVariableImpl#getValues <em>Values</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.InputVariableImpl#getAssignments <em>Assignments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputVariableImpl extends VariableImpl implements InputVariable {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<InputVariableValue> values;

	/**
	 * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableAssignment> assignments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefinitionPackage.Literals.INPUT_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputVariableValue> getValues() {
		if (values == null) {
			values = new EObjectContainmentWithInverseEList<InputVariableValue>(InputVariableValue.class, this, DefinitionPackage.INPUT_VARIABLE__VALUES, DefinitionPackage.INPUT_VARIABLE_VALUE__VARIABLE);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableAssignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectWithInverseResolvingEList<VariableAssignment>(VariableAssignment.class, this, DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS, DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void deserializeValues(String values) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String serializeValues() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DefinitionPackage.INPUT_VARIABLE__VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getValues()).basicAdd(otherEnd, msgs);
			case DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignments()).basicAdd(otherEnd, msgs);
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
			case DefinitionPackage.INPUT_VARIABLE__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
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
			case DefinitionPackage.INPUT_VARIABLE__VALUES:
				return getValues();
			case DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS:
				return getAssignments();
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
			case DefinitionPackage.INPUT_VARIABLE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends InputVariableValue>)newValue);
				return;
			case DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends VariableAssignment>)newValue);
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
			case DefinitionPackage.INPUT_VARIABLE__VALUES:
				getValues().clear();
				return;
			case DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS:
				getAssignments().clear();
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
			case DefinitionPackage.INPUT_VARIABLE__VALUES:
				return values != null && !values.isEmpty();
			case DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
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
			case DefinitionPackage.INPUT_VARIABLE___DESERIALIZE_VALUES__STRING:
				deserializeValues((String)arguments.get(0));
				return null;
			case DefinitionPackage.INPUT_VARIABLE___SERIALIZE_VALUES:
				return serializeValues();
		}
		return super.eInvoke(operationID, arguments);
	}

} //InputVariableImpl
