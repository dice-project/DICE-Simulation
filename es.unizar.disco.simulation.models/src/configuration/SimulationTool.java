/**
 */
package configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link configuration.SimulationTool#getProduces <em>Produces</em>}</li>
 * </ul>
 *
 * @see configuration.ConfigurationPackage#getSimulationTool()
 * @model abstract="true"
 * @generated
 */
public interface SimulationTool extends EObject {
	/**
	 * Returns the value of the '<em><b>Produces</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produces</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produces</em>' reference.
	 * @see #setProduces(ToolResult)
	 * @see configuration.ConfigurationPackage#getSimulationTool_Produces()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	ToolResult getProduces();

	/**
	 * Sets the value of the '{@link configuration.SimulationTool#getProduces <em>Produces</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Produces</em>' reference.
	 * @see #getProduces()
	 * @generated
	 */
	void setProduces(ToolResult value);

} // SimulationTool
