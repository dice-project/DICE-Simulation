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
package es.unizar.disco.pnextensions.pnconstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tool Info Constants</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.pnextensions.pnconstants.PnconstantsPackage#getToolInfoConstants()
 * @model
 * @generated
 */
public enum ToolInfoConstants implements Enumerator {
	/**
	 * The '<em><b>Tool Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOOL_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	TOOL_NAME(0, "toolName", "DICE PNML Extensions"),

	/**
	 * The '<em><b>Tool Version</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOOL_VERSION_VALUE
	 * @generated
	 * @ordered
	 */
	TOOL_VERSION(1, "toolVersion", "0.1"),

	/**
	 * The '<em><b>Uri</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #URI_VALUE
	 * @generated
	 * @ordered
	 */
	URI(2, "uri", "http://es.unizar.disco/DICE");

	/**
	 * The '<em><b>Tool Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOOL_NAME
	 * @model name="toolName" literal="DICE PNML Extensions"
	 * @generated
	 * @ordered
	 */
	public static final int TOOL_NAME_VALUE = 0;

	/**
	 * The '<em><b>Tool Version</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOOL_VERSION
	 * @model name="toolVersion" literal="0.1"
	 * @generated
	 * @ordered
	 */
	public static final int TOOL_VERSION_VALUE = 1;

	/**
	 * The '<em><b>Uri</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #URI
	 * @model name="uri" literal="http://es.unizar.disco/DICE"
	 * @generated
	 * @ordered
	 */
	public static final int URI_VALUE = 2;

	/**
	 * An array of all the '<em><b>Tool Info Constants</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ToolInfoConstants[] VALUES_ARRAY =
		new ToolInfoConstants[] {
			TOOL_NAME,
			TOOL_VERSION,
			URI,
		};

	/**
	 * A public read-only list of all the '<em><b>Tool Info Constants</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ToolInfoConstants> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tool Info Constants</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ToolInfoConstants get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ToolInfoConstants result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tool Info Constants</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ToolInfoConstants getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ToolInfoConstants result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tool Info Constants</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ToolInfoConstants get(int value) {
		switch (value) {
			case TOOL_NAME_VALUE: return TOOL_NAME;
			case TOOL_VERSION_VALUE: return TOOL_VERSION;
			case URI_VALUE: return URI;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ToolInfoConstants(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ToolInfoConstants
