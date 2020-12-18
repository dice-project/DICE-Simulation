/**
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 * 
 * SPDX-License-Identifier: EPL-1.0
 * 
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.VariableAssignment;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.VariableAssignmentImpl#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.VariableAssignmentImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.VariableAssignmentImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableAssignmentImpl extends MinimalEObjectImpl.Container implements VariableAssignment {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected InputVariableValue value;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected InputVariable variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefinitionPackage.Literals.VARIABLE_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputVariableValue getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (InputVariableValue)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVariableValue basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(InputVariableValue newValue, NotificationChain msgs) {
		InputVariableValue oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(InputVariableValue newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, DefinitionPackage.INPUT_VARIABLE_VALUE__ASSIGNMENTS, InputVariableValue.class, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, DefinitionPackage.INPUT_VARIABLE_VALUE__ASSIGNMENTS, InputVariableValue.class, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableConfiguration getConfiguration() {
		if (eContainerFeatureID() != DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION) return null;
		return (VariableConfiguration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(VariableConfiguration newConfiguration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfiguration, DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConfiguration(VariableConfiguration newConfiguration) {
		if (newConfiguration != eInternalContainer() || (eContainerFeatureID() != DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION && newConfiguration != null)) {
			if (EcoreUtil.isAncestor(this, newConfiguration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, DefinitionPackage.VARIABLE_CONFIGURATION__ASSIGNMENTS, VariableConfiguration.class, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputVariable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (InputVariable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVariable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable(InputVariable newVariable, NotificationChain msgs) {
		InputVariable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE, oldVariable, newVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariable(InputVariable newVariable) {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject)variable).eInverseRemove(this, DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS, InputVariable.class, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS, InputVariable.class, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE, newVariable, newVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE:
				if (value != null)
					msgs = ((InternalEObject)value).eInverseRemove(this, DefinitionPackage.INPUT_VARIABLE_VALUE__ASSIGNMENTS, InputVariableValue.class, msgs);
				return basicSetValue((InputVariableValue)otherEnd, msgs);
			case DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConfiguration((VariableConfiguration)otherEnd, msgs);
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE:
				if (variable != null)
					msgs = ((InternalEObject)variable).eInverseRemove(this, DefinitionPackage.INPUT_VARIABLE__ASSIGNMENTS, InputVariable.class, msgs);
				return basicSetVariable((InputVariable)otherEnd, msgs);
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
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE:
				return basicSetValue(null, msgs);
			case DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE:
				return basicSetVariable(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION:
				return eInternalContainer().eInverseRemove(this, DefinitionPackage.VARIABLE_CONFIGURATION__ASSIGNMENTS, VariableConfiguration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
			case DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION:
				return getConfiguration();
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
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
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE:
				setValue((InputVariableValue)newValue);
				return;
			case DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION:
				setConfiguration((VariableConfiguration)newValue);
				return;
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE:
				setVariable((InputVariable)newValue);
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
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE:
				setValue((InputVariableValue)null);
				return;
			case DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION:
				setConfiguration((VariableConfiguration)null);
				return;
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE:
				setVariable((InputVariable)null);
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
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VALUE:
				return value != null;
			case DefinitionPackage.VARIABLE_ASSIGNMENT__CONFIGURATION:
				return getConfiguration() != null;
			case DefinitionPackage.VARIABLE_ASSIGNMENT__VARIABLE:
				return variable != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableAssignmentImpl
