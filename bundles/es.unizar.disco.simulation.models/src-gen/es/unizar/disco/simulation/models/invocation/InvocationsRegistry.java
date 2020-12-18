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
package es.unizar.disco.simulation.models.invocation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocations Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.InvocationsRegistry#getInvocationSets <em>Invocation Sets</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationsRegistry()
 * @model
 * @generated
 */
public interface InvocationsRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Invocation Sets</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.invocation.InvocationSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation Sets</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationsRegistry_InvocationSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<InvocationSet> getInvocationSets();

} // InvocationsRegistry
