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
 *   <li>{@link es.unizar.disco.simulation.models.wnsim.PlaceInfo#getMeanNumberOfTokens <em>Mean Number Of Tokens</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.wnsim.WnsimPackage#getPlaceInfo()
 * @model
 * @generated
 */
public interface PlaceInfo extends WnsimElementInfo {
	/**
	 * Returns the value of the '<em><b>Mean Number Of Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean Number Of Tokens</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean Number Of Tokens</em>' attribute.
	 * @see #setMeanNumberOfTokens(Number)
	 * @see es.unizar.disco.simulation.models.wnsim.WnsimPackage#getPlaceInfo_MeanNumberOfTokens()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.Number"
	 * @generated
	 */
	Number getMeanNumberOfTokens();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.wnsim.PlaceInfo#getMeanNumberOfTokens <em>Mean Number Of Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean Number Of Tokens</em>' attribute.
	 * @see #getMeanNumberOfTokens()
	 * @generated
	 */
	void setMeanNumberOfTokens(Number value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="es.unizar.disco.simulation.models.datatypes.Number"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return meanNumberOfTokens;'"
	 * @generated
	 */
	Number getValue();

} // PlaceInfo
