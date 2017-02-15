/**
 */
package es.unizar.disco.simulation.models.datatypes;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.datatypes.Resource#getUri <em>Uri</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.datatypes.Resource#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.datatypes.DatatypesPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(URI)
	 * @see es.unizar.disco.simulation.models.datatypes.DatatypesPackage#getResource_Uri()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.URI" required="true"
	 * @generated
	 */
	URI getUri();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.datatypes.Resource#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(URI value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.DatatypesPackage#getResource_Resource()
	 * @model required="true" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	org.eclipse.emf.ecore.resource.Resource getResource();

} // Resource
