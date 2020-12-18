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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getUnit <em>Unit</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasure()
 * @model
 * @generated
 */
public interface DomainMeasure extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Number)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasure_Value()
	 * @model id="true" dataType="es.unizar.disco.simulation.models.datatypes.Number" required="true"
	 * @generated
	 */
	Number getValue();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Number value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The default value is <code>"unspecified"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasure_Unit()
	 * @model default="unspecified" required="true"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(DomainMeasureDefinition)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasure_Definition()
	 * @model required="true"
	 * @generated
	 */
	DomainMeasureDefinition getDefinition();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(DomainMeasureDefinition value);

} // DomainMeasure
