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
package es.unizar.disco.simulation.models.wnsim.impl;

import es.unizar.disco.simulation.models.toolresult.impl.AnalyzableElementInfoImpl;

import es.unizar.disco.simulation.models.wnsim.WnsimElementInfo;
import es.unizar.disco.simulation.models.wnsim.WnsimPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class WnsimElementInfoImpl extends AnalyzableElementInfoImpl implements WnsimElementInfo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WnsimElementInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WnsimPackage.Literals.WNSIM_ELEMENT_INFO;
	}

} //WnsimElementInfoImpl
