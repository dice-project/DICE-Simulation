/**
 */
package es.unizar.disco.simulation.models.definition;

import es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.VariableConfiguration#getAssignments <em>Assignments</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getVariableConfiguration()
 * @model
 * @generated
 */
public interface VariableConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.VariableAssignment}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getVariableConfiguration_Assignments()
	 * @see es.unizar.disco.simulation.models.definition.VariableAssignment#getConfiguration
	 * @model opposite="configuration" containment="true" required="true"
	 * @generated
	 */
	EList<VariableAssignment> getAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isEquivalent(VariableConfiguration config);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<PrimitiveVariableAssignment> toPrimitiveAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	VariableAssignment findAssignment(InputVariable variable);

} // VariableConfiguration
