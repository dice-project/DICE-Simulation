/**
 */
package es.unizar.disco.simulation.models.wnsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.wnsim.PlaceInfo#getThroughput <em>Throughput</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.wnsim.WnsimPackage#getPlaceInfo()
 * @model
 * @generated
 */
public interface PlaceInfo extends WnsimElementInfo {
	/**
	 * Returns the value of the '<em><b>Throughput</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throughput</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throughput</em>' attribute.
	 * @see #setThroughput(Float)
	 * @see es.unizar.disco.simulation.models.wnsim.WnsimPackage#getPlaceInfo_Throughput()
	 * @model
	 * @generated
	 */
	Float getThroughput();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.wnsim.PlaceInfo#getThroughput <em>Throughput</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throughput</em>' attribute.
	 * @see #getThroughput()
	 * @generated
	 */
	void setThroughput(Float value);

} // PlaceInfo
