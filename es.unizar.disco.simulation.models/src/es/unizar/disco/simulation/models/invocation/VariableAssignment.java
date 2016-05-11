/**
 */
package es.unizar.disco.simulation.models.invocation;

import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;

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
 *   <li>{@link es.unizar.disco.simulation.models.invocation.VariableAssignment#getVariable <em>Variable</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.VariableAssignment#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getVariableAssignment()
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
	 * @see #setVariable(InputVariable)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getVariableAssignment_Variable()
	 * @model required="true"
	 * @generated
	 */
	InputVariable getVariable();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.VariableAssignment#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(InputVariable value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(InputVariableValue)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getVariableAssignment_Value()
	 * @model required="true"
	 * @generated
	 */
	InputVariableValue getValue();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.VariableAssignment#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(InputVariableValue value);

} // VariableAssignment
