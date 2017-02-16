/**
 */
package es.unizar.disco.pnextensions.pnconstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Server Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.pnextensions.pnconstants.PnconstantsPackage#getServerType()
 * @model
 * @generated
 */
public enum ServerType implements Enumerator {
	/**
	 * The '<em><b>Infinite Server</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INFINITE_SERVER_VALUE
	 * @generated
	 * @ordered
	 */
	INFINITE_SERVER(0, "InfiniteServer", "http://es.unizar.dsico/pnconstants/tserv/infinite"),

	/**
	 * The '<em><b>One Server</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_SERVER_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_SERVER(1, "OneServer", "http://es.unizar.dsico/pnconstants/tserv/one"),

	/**
	 * The '<em><b>Load Dependent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOAD_DEPENDENT_VALUE
	 * @generated
	 * @ordered
	 */
	LOAD_DEPENDENT(2, "LoadDependent", "http://es.unizar.dsico/pnconstants/tserv/loaddep"),

	/**
	 * The '<em><b>Marking Dependent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARKING_DEPENDENT_VALUE
	 * @generated
	 * @ordered
	 */
	MARKING_DEPENDENT(3, "MarkingDependent", "http://es.unizar.dsico/pnconstants/tserv/markingddep");

	/**
	 * The '<em><b>Infinite Server</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Infinite Server</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INFINITE_SERVER
	 * @model name="InfiniteServer" literal="http://es.unizar.dsico/pnconstants/tserv/infinite"
	 * @generated
	 * @ordered
	 */
	public static final int INFINITE_SERVER_VALUE = 0;

	/**
	 * The '<em><b>One Server</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>One Server</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_SERVER
	 * @model name="OneServer" literal="http://es.unizar.dsico/pnconstants/tserv/one"
	 * @generated
	 * @ordered
	 */
	public static final int ONE_SERVER_VALUE = 1;

	/**
	 * The '<em><b>Load Dependent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Load Dependent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOAD_DEPENDENT
	 * @model name="LoadDependent" literal="http://es.unizar.dsico/pnconstants/tserv/loaddep"
	 * @generated
	 * @ordered
	 */
	public static final int LOAD_DEPENDENT_VALUE = 2;

	/**
	 * The '<em><b>Marking Dependent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Marking Dependent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MARKING_DEPENDENT
	 * @model name="MarkingDependent" literal="http://es.unizar.dsico/pnconstants/tserv/markingddep"
	 * @generated
	 * @ordered
	 */
	public static final int MARKING_DEPENDENT_VALUE = 3;

	/**
	 * An array of all the '<em><b>Server Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ServerType[] VALUES_ARRAY =
		new ServerType[] {
			INFINITE_SERVER,
			ONE_SERVER,
			LOAD_DEPENDENT,
			MARKING_DEPENDENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Server Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ServerType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Server Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServerType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServerType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Server Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServerType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServerType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Server Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServerType get(int value) {
		switch (value) {
			case INFINITE_SERVER_VALUE: return INFINITE_SERVER;
			case ONE_SERVER_VALUE: return ONE_SERVER;
			case LOAD_DEPENDENT_VALUE: return LOAD_DEPENDENT;
			case MARKING_DEPENDENT_VALUE: return MARKING_DEPENDENT;
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
	private ServerType(int value, String name, String literal) {
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
	
} //ServerType
