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
 * A representation of the literals of the enumeration '<em><b>Base Units Constants</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.pnextensions.pnconstants.PnconstantsPackage#getBaseUnitsConstants()
 * @model
 * @generated
 */
public enum BaseUnitsConstants implements Enumerator {
	/**
	 * The '<em><b>Base Time Unit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_TIME_UNIT_VALUE
	 * @generated
	 * @ordered
	 */
	BASE_TIME_UNIT(0, "baseTimeUnit", "http://es.unizar.dsico/pnconstants/units/basetimeunit"),

	/**
	 * The '<em><b>Base Frequency Unit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_FREQUENCY_UNIT_VALUE
	 * @generated
	 * @ordered
	 */
	BASE_FREQUENCY_UNIT(1, "baseFrequencyUnit", "http://es.unizar.dsico/pnconstants/units/basefrequencyunit");

	/**
	 * The '<em><b>Base Time Unit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_TIME_UNIT
	 * @model name="baseTimeUnit" literal="http://es.unizar.dsico/pnconstants/units/basetimeunit"
	 * @generated
	 * @ordered
	 */
	public static final int BASE_TIME_UNIT_VALUE = 0;

	/**
	 * The '<em><b>Base Frequency Unit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_FREQUENCY_UNIT
	 * @model name="baseFrequencyUnit" literal="http://es.unizar.dsico/pnconstants/units/basefrequencyunit"
	 * @generated
	 * @ordered
	 */
	public static final int BASE_FREQUENCY_UNIT_VALUE = 1;

	/**
	 * An array of all the '<em><b>Base Units Constants</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BaseUnitsConstants[] VALUES_ARRAY =
		new BaseUnitsConstants[] {
			BASE_TIME_UNIT,
			BASE_FREQUENCY_UNIT,
		};

	/**
	 * A public read-only list of all the '<em><b>Base Units Constants</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BaseUnitsConstants> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Base Units Constants</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseUnitsConstants get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BaseUnitsConstants result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Base Units Constants</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseUnitsConstants getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BaseUnitsConstants result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Base Units Constants</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseUnitsConstants get(int value) {
		switch (value) {
			case BASE_TIME_UNIT_VALUE: return BASE_TIME_UNIT;
			case BASE_FREQUENCY_UNIT_VALUE: return BASE_FREQUENCY_UNIT;
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
	private BaseUnitsConstants(int value, String name, String literal) {
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
	
} //BaseUnitsConstants
