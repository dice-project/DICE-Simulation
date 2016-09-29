/**
 */
package es.unizar.disco.pnextensions.pnconstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transition Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.pnextensions.pnconstants.PnconstantsPackage#getTransitionKind()
 * @model
 * @generated
 */
public enum TransitionKind implements Enumerator {
	/**
	 * The '<em><b>Immediate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMMEDIATE_VALUE
	 * @generated
	 * @ordered
	 */
	IMMEDIATE(0, "Immediate", "http://es.unizar.disco/pnconstants/tkind/immediate"),

	/**
	 * The '<em><b>Exponential</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPONENTIAL_VALUE
	 * @generated
	 * @ordered
	 */
	EXPONENTIAL(1, "Exponential", "http://es.unizar.disco/pnconstants/tkind/exponential"),

	/**
	 * The '<em><b>Deterministic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DETERMINISTIC_VALUE
	 * @generated
	 * @ordered
	 */
	DETERMINISTIC(2, "Deterministic", "http://es.unizar.disco/pnconstants/tkind/deterministic"), /**
	 * The '<em><b>Immediate Priority</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMMEDIATE_PRIORITY_VALUE
	 * @generated
	 * @ordered
	 */
	IMMEDIATE_PRIORITY(3, "ImmediatePriority", "http://es.unizar.disco/pnconstants/tkind/immediatepriority");

	/**
	 * The '<em><b>Immediate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Immediate</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMMEDIATE
	 * @model name="Immediate" literal="http://es.unizar.disco/pnconstants/tkind/immediate"
	 * @generated
	 * @ordered
	 */
	public static final int IMMEDIATE_VALUE = 0;

	/**
	 * The '<em><b>Exponential</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exponential</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPONENTIAL
	 * @model name="Exponential" literal="http://es.unizar.disco/pnconstants/tkind/exponential"
	 * @generated
	 * @ordered
	 */
	public static final int EXPONENTIAL_VALUE = 1;

	/**
	 * The '<em><b>Deterministic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Deterministic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DETERMINISTIC
	 * @model name="Deterministic" literal="http://es.unizar.disco/pnconstants/tkind/deterministic"
	 * @generated
	 * @ordered
	 */
	public static final int DETERMINISTIC_VALUE = 2;

	/**
	 * The '<em><b>Immediate Priority</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Immediate Priority</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMMEDIATE_PRIORITY
	 * @model name="ImmediatePriority" literal="http://es.unizar.disco/pnconstants/tkind/immediatepriority"
	 * @generated
	 * @ordered
	 */
	public static final int IMMEDIATE_PRIORITY_VALUE = 3;

	/**
	 * An array of all the '<em><b>Transition Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransitionKind[] VALUES_ARRAY =
		new TransitionKind[] {
			IMMEDIATE,
			EXPONENTIAL,
			DETERMINISTIC,
			IMMEDIATE_PRIORITY,
		};

	/**
	 * A public read-only list of all the '<em><b>Transition Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TransitionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransitionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransitionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransitionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransitionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransitionKind get(int value) {
		switch (value) {
			case IMMEDIATE_VALUE: return IMMEDIATE;
			case EXPONENTIAL_VALUE: return EXPONENTIAL;
			case DETERMINISTIC_VALUE: return DETERMINISTIC;
			case IMMEDIATE_PRIORITY_VALUE: return IMMEDIATE_PRIORITY;
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
	private TransitionKind(int value, String name, String literal) {
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
	
} //TransitionKind
