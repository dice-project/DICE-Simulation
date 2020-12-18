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
package es.unizar.disco.simulation.models.measures;

import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Measure Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getMeasuredElement <em>Measured Element</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getMeasure <em>Measure</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getVslExpressionEntries <em>Vsl Expression Entries</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getVslExpression <em>Vsl Expression</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getOutputVariable <em>Output Variable</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getSimulationDefinition <em>Simulation Definition</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getSlaVslExpression <em>Sla Vsl Expression</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasureDefinition()
 * @model
 * @generated
 */
public interface DomainMeasureDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measured Element</em>' reference.
	 * @see #setMeasuredElement(EObject)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasureDefinition_MeasuredElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getMeasuredElement();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getMeasuredElement <em>Measured Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measured Element</em>' reference.
	 * @see #getMeasuredElement()
	 * @generated
	 */
	void setMeasuredElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure</em>' attribute.
	 * @see #setMeasure(String)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasureDefinition_Measure()
	 * @model required="true"
	 * @generated
	 */
	String getMeasure();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getMeasure <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure</em>' attribute.
	 * @see #getMeasure()
	 * @generated
	 */
	void setMeasure(String value);

	/**
	 * Returns the value of the '<em><b>Vsl Expression Entries</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vsl Expression Entries</em>' map.
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasureDefinition_VslExpressionEntries()
	 * @model mapType="es.unizar.disco.simulation.models.measures.Entry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getVslExpressionEntries();

	/**
	 * Returns the value of the '<em><b>Vsl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vsl Expression</em>' attribute.
	 * @see #setVslExpression(String)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasureDefinition_VslExpression()
	 * @model required="true" transient="true" volatile="true"
	 * @generated
	 */
	String getVslExpression();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getVslExpression <em>Vsl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vsl Expression</em>' attribute.
	 * @see #getVslExpression()
	 * @generated
	 */
	void setVslExpression(String value);

	/**
	 * Returns the value of the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable</em>' reference.
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasureDefinition_OutputVariable()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	OutputVariable getOutputVariable();

	/**
	 * Returns the value of the '<em><b>Simulation Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDeclaredMeasures <em>Declared Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Definition</em>' container reference.
	 * @see #setSimulationDefinition(SimulationDefinition)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasureDefinition_SimulationDefinition()
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getDeclaredMeasures
	 * @model opposite="declaredMeasures" required="true" transient="false"
	 * @generated
	 */
	SimulationDefinition getSimulationDefinition();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getSimulationDefinition <em>Simulation Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Definition</em>' container reference.
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	void setSimulationDefinition(SimulationDefinition value);

	/**
	 * Returns the value of the '<em><b>Sla Vsl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sla Vsl Expression</em>' attribute.
	 * @see #setSlaVslExpression(String)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasureDefinition_SlaVslExpression()
	 * @model
	 * @generated
	 */
	String getSlaVslExpression();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getSlaVslExpression <em>Sla Vsl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sla Vsl Expression</em>' attribute.
	 * @see #getSlaVslExpression()
	 * @generated
	 */
	void setSlaVslExpression(String value);

} // DomainMeasureDefinition
