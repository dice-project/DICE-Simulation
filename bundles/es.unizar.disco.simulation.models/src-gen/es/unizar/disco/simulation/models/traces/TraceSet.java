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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.traces.TraceSet#getTraces <em>Traces</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.traces.TracesPackage#getTraceSet()
 * @model
 * @generated
 */
public interface TraceSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Traces</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.traces.Trace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.traces.TracesPackage#getTraceSet_Traces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Trace> getTraces();

} // TraceSet
