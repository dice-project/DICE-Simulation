/**
 */
package es.unizar.disco.simulation.models.invocation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocations Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.InvocationsRegistry#getInvocationSets <em>Invocation Sets</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationsRegistry()
 * @model
 * @generated
 */
public interface InvocationsRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Invocation Sets</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.invocation.InvocationSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation Sets</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationsRegistry_InvocationSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<InvocationSet> getInvocationSets();

} // InvocationsRegistry
