/**
 */
package es.unizar.disco.simulation.models.definition;

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
 *   <li>{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(InputVariableValue)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getVariableAssignment_Value()
	 * @see es.unizar.disco.simulation.models.definition.InputVariableValue#getAssignments
	 * @model opposite="assignments" required="true"
	 * @generated
	 */
	InputVariableValue getValue();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(InputVariableValue value);

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.VariableConfiguration#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' container reference.
	 * @see #setConfiguration(VariableConfiguration)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getVariableAssignment_Configuration()
	 * @see es.unizar.disco.simulation.models.definition.VariableConfiguration#getAssignments
	 * @model opposite="assignments" required="true" transient="false"
	 * @generated
	 */
	VariableConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getConfiguration <em>Configuration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' container reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(VariableConfiguration value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.InputVariable#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(InputVariable)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getVariableAssignment_Variable()
	 * @see es.unizar.disco.simulation.models.definition.InputVariable#getAssignments
	 * @model opposite="assignments" required="true"
	 * @generated
	 */
	InputVariable getVariable();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(InputVariable value);

} // VariableAssignment
