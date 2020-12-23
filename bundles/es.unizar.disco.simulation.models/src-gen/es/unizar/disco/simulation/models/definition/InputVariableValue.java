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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Variable Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariableValue()
 * @model
 * @generated
 */
public interface InputVariableValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Number)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariableValue_Value()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.Number" required="true"
	 * @generated
	 */
	Number getValue();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Number value);

	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.VariableAssignment}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariableValue_Assignments()
	 * @see es.unizar.disco.simulation.models.definition.VariableAssignment#getValue
	 * @model opposite="value" required="true"
	 * @generated
	 */
	EList<VariableAssignment> getAssignments();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.InputVariable#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' container reference.
	 * @see #setVariable(InputVariable)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariableValue_Variable()
	 * @see es.unizar.disco.simulation.models.definition.InputVariable#getValues
	 * @model opposite="values" required="true" transient="false"
	 * @generated
	 */
	InputVariable getVariable();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getVariable <em>Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' container reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(InputVariable value);

} // InputVariableValue
