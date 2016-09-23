/**
 */
package es.unizar.disco.simulation.models.datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Computable NF Ptype</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.simulation.models.datatypes.DatatypesPackage#getComputableNFPtype()
 * @model
 * @generated
 */
public enum ComputableNFPtype implements Enumerator {
	/**
	 * The '<em><b>PERFORMANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERFORMANCE_VALUE
	 * @generated
	 * @ordered
	 */
	PERFORMANCE(0, "PERFORMANCE", "PERFORMANCE"),

	/**
	 * The '<em><b>RELIABILITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELIABILITY_VALUE
	 * @generated
	 * @ordered
	 */
	RELIABILITY(1, "RELIABILITY", "RELIABILITY");

	/**
	 * The '<em><b>PERFORMANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PERFORMANCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERFORMANCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PERFORMANCE_VALUE = 0;

	/**
	 * The '<em><b>RELIABILITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RELIABILITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELIABILITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RELIABILITY_VALUE = 1;

	/**
	 * An array of all the '<em><b>Computable NF Ptype</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ComputableNFPtype[] VALUES_ARRAY =
		new ComputableNFPtype[] {
			PERFORMANCE,
			RELIABILITY,
		};

	/**
	 * A public read-only list of all the '<em><b>Computable NF Ptype</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ComputableNFPtype> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Computable NF Ptype</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComputableNFPtype get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComputableNFPtype result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Computable NF Ptype</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComputableNFPtype getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComputableNFPtype result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Computable NF Ptype</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComputableNFPtype get(int value) {
		switch (value) {
			case PERFORMANCE_VALUE: return PERFORMANCE;
			case RELIABILITY_VALUE: return RELIABILITY;
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
	private ComputableNFPtype(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	
} //ComputableNFPtype
