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
package es.unizar.disco.simulation.models.definition;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.InputVariable#getValues <em>Values</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.InputVariable#getAssignments <em>Assignments</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariable()
 * @model
 * @generated
 */
public interface InputVariable extends Variable {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.InputVariableValue}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariable_Values()
	 * @see es.unizar.disco.simulation.models.definition.InputVariableValue#getVariable
	 * @model opposite="variable" containment="true" required="true"
	 * @generated
	 */
	EList<InputVariableValue> getValues();

	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.VariableAssignment}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariable_Assignments()
	 * @see es.unizar.disco.simulation.models.definition.VariableAssignment#getVariable
	 * @model opposite="variable" required="true"
	 * @generated
	 */
	EList<VariableAssignment> getAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deserializeValues(String values);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String serializeValues();

} // InputVariable
