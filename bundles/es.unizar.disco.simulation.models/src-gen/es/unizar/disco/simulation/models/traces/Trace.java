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
package es.unizar.disco.simulation.models.traces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.traces.Trace#getFromDomainElement <em>From Domain Element</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.traces.Trace#getToAnalyzableElement <em>To Analyzable Element</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.traces.Trace#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.traces.TracesPackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject {
	/**
	 * Returns the value of the '<em><b>From Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Domain Element</em>' reference.
	 * @see #setFromDomainElement(EObject)
	 * @see es.unizar.disco.simulation.models.traces.TracesPackage#getTrace_FromDomainElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getFromDomainElement();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.traces.Trace#getFromDomainElement <em>From Domain Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Domain Element</em>' reference.
	 * @see #getFromDomainElement()
	 * @generated
	 */
	void setFromDomainElement(EObject value);

	/**
	 * Returns the value of the '<em><b>To Analyzable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Analyzable Element</em>' reference.
	 * @see #setToAnalyzableElement(EObject)
	 * @see es.unizar.disco.simulation.models.traces.TracesPackage#getTrace_ToAnalyzableElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getToAnalyzableElement();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.traces.Trace#getToAnalyzableElement <em>To Analyzable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Analyzable Element</em>' reference.
	 * @see #getToAnalyzableElement()
	 * @generated
	 */
	void setToAnalyzableElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' attribute.
	 * @see #setRule(String)
	 * @see es.unizar.disco.simulation.models.traces.TracesPackage#getTrace_Rule()
	 * @model
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.traces.Trace#getRule <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' attribute.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(String value);

} // Trace
