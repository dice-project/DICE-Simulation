/**
 */
package es.unizar.disco.simulation.models.wnsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.wnsim.TransitionInfo#getThroughput <em>Throughput</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.wnsim.WnsimPackage#getTransitionInfo()
 * @model
 * @generated
 */
public interface TransitionInfo extends WnsimElementInfo {
	/**
	 * Returns the value of the '<em><b>Throughput</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throughput</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throughput</em>' attribute.
	 * @see #setThroughput(Number)
	 * @see es.unizar.disco.simulation.models.wnsim.WnsimPackage#getTransitionInfo_Throughput()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.Number"
	 * @generated
	 */
	Number getThroughput();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.wnsim.TransitionInfo#getThroughput <em>Throughput</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throughput</em>' attribute.
	 * @see #getThroughput()
	 * @generated
	 */
	void setThroughput(Number value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="es.unizar.disco.simulation.models.datatypes.Number"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return throughput;'"
	 * @generated
	 */
	Number getValue();

} // TransitionInfo
