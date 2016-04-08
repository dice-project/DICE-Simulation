/**
 */
package configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link configuration.VariableAssignment#getVariable <em>Variable</em>}</li>
 *   <li>{@link configuration.VariableAssignment#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see configuration.ConfigurationPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variables)
	 * @see configuration.ConfigurationPackage#getVariableAssignment_Variable()
	 * @model required="true"
	 * @generated
	 */
	Variables getVariable();

	/**
	 * Sets the value of the '{@link configuration.VariableAssignment#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variables value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(VariableValue)
	 * @see configuration.ConfigurationPackage#getVariableAssignment_Value()
	 * @model required="true"
	 * @generated
	 */
	VariableValue getValue();

	/**
	 * Sets the value of the '{@link configuration.VariableAssignment#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(VariableValue value);

} // VariableAssignment
