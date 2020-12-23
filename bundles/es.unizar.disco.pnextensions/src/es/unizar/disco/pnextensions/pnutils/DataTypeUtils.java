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
package es.unizar.disco.pnextensions.pnutils;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Utils</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see es.unizar.disco.pnextensions.pnutils.PnutilsPackage#getDataTypeUtils()
 * @model
 * @generated
 */
public interface DataTypeUtils extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="es.unizar.disco.pnextensions.pnutils.URI" exceptions="es.unizar.disco.pnextensions.pnutils.URISyntaxException"
	 * @generated
	 */
	URI createURI(String stringUri) throws URISyntaxException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="es.unizar.disco.pnextensions.pnutils.StringBuffer"
	 * @generated
	 */
	StringBuffer createLongString(String string);

} // DataTypeUtils
