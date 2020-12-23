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
package es.unizar.disco.simulation.models.wnsim;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Simulation Parameters</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.simulation.models.wnsim.WnsimPackage#getSimulationParameters()
 * @model
 * @generated
 */
public enum SimulationParameters implements Enumerator {
	/**
	 * The '<em><b>First tr length</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_TR_LENGTH_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST_TR_LENGTH(0, "first_tr_length", "-f"),

	/**
	 * The '<em><b>Tr length</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TR_LENGTH_VALUE
	 * @generated
	 * @ordered
	 */
	TR_LENGTH(1, "tr_length", "-t"),

	/**
	 * The '<em><b>Min btc</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIN_BTC_VALUE
	 * @generated
	 * @ordered
	 */
	MIN_BTC(2, "min_btc", "-m"),

	/**
	 * The '<em><b>Max btc</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_BTC_VALUE
	 * @generated
	 * @ordered
	 */
	MAX_BTC(3, "max_btc", "-M"),

	/**
	 * The '<em><b>Approx</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPROX_VALUE
	 * @generated
	 * @ordered
	 */
	APPROX(4, "approx", "-a"),

	/**
	 * The '<em><b>Conf level</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONF_LEVEL_VALUE
	 * @generated
	 * @ordered
	 */
	CONF_LEVEL(5, "conf_level", "-c"),

	/**
	 * The '<em><b>Seed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEED_VALUE
	 * @generated
	 * @ordered
	 */
	SEED(6, "seed", "-s"),

	/**
	 * The '<em><b>Start</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_VALUE
	 * @generated
	 * @ordered
	 */
	START(7, "start", "-o"),

	/**
	 * The '<em><b>Binary file path</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_FILE_PATH_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_FILE_PATH(10, "binary_file_path", "binary_file_path");

	/**
	 * The '<em><b>First tr length</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_TR_LENGTH
	 * @model name="first_tr_length" literal="-f"
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_TR_LENGTH_VALUE = 0;

	/**
	 * The '<em><b>Tr length</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TR_LENGTH
	 * @model name="tr_length" literal="-t"
	 * @generated
	 * @ordered
	 */
	public static final int TR_LENGTH_VALUE = 1;

	/**
	 * The '<em><b>Min btc</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIN_BTC
	 * @model name="min_btc" literal="-m"
	 * @generated
	 * @ordered
	 */
	public static final int MIN_BTC_VALUE = 2;

	/**
	 * The '<em><b>Max btc</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_BTC
	 * @model name="max_btc" literal="-M"
	 * @generated
	 * @ordered
	 */
	public static final int MAX_BTC_VALUE = 3;

	/**
	 * The '<em><b>Approx</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPROX
	 * @model name="approx" literal="-a"
	 * @generated
	 * @ordered
	 */
	public static final int APPROX_VALUE = 4;

	/**
	 * The '<em><b>Conf level</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONF_LEVEL
	 * @model name="conf_level" literal="-c"
	 * @generated
	 * @ordered
	 */
	public static final int CONF_LEVEL_VALUE = 5;

	/**
	 * The '<em><b>Seed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEED
	 * @model name="seed" literal="-s"
	 * @generated
	 * @ordered
	 */
	public static final int SEED_VALUE = 6;

	/**
	 * The '<em><b>Start</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START
	 * @model name="start" literal="-o"
	 * @generated
	 * @ordered
	 */
	public static final int START_VALUE = 7;

	/**
	 * The '<em><b>Binary file path</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_FILE_PATH
	 * @model name="binary_file_path"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_FILE_PATH_VALUE = 10;

	/**
	 * An array of all the '<em><b>Simulation Parameters</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SimulationParameters[] VALUES_ARRAY =
		new SimulationParameters[] {
			FIRST_TR_LENGTH,
			TR_LENGTH,
			MIN_BTC,
			MAX_BTC,
			APPROX,
			CONF_LEVEL,
			SEED,
			START,
			BINARY_FILE_PATH,
		};

	/**
	 * A public read-only list of all the '<em><b>Simulation Parameters</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SimulationParameters> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Simulation Parameters</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SimulationParameters get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SimulationParameters result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Simulation Parameters</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SimulationParameters getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SimulationParameters result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Simulation Parameters</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SimulationParameters get(int value) {
		switch (value) {
			case FIRST_TR_LENGTH_VALUE: return FIRST_TR_LENGTH;
			case TR_LENGTH_VALUE: return TR_LENGTH;
			case MIN_BTC_VALUE: return MIN_BTC;
			case MAX_BTC_VALUE: return MAX_BTC;
			case APPROX_VALUE: return APPROX;
			case CONF_LEVEL_VALUE: return CONF_LEVEL;
			case SEED_VALUE: return SEED;
			case START_VALUE: return START;
			case BINARY_FILE_PATH_VALUE: return BINARY_FILE_PATH;
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
	private SimulationParameters(int value, String name, String literal) {
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
	
} //SimulationParameters
