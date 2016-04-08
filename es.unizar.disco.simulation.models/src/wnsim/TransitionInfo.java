/**
 */
package wnsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link wnsim.TransitionInfo#getMeanNumberOfTokens <em>Mean Number Of Tokens</em>}</li>
 * </ul>
 *
 * @see wnsim.WnsimPackage#getTransitionInfo()
 * @model
 * @generated
 */
public interface TransitionInfo extends WnsimElementInfo {
	/**
	 * Returns the value of the '<em><b>Mean Number Of Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean Number Of Tokens</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean Number Of Tokens</em>' attribute.
	 * @see #setMeanNumberOfTokens(Float)
	 * @see wnsim.WnsimPackage#getTransitionInfo_MeanNumberOfTokens()
	 * @model
	 * @generated
	 */
	Float getMeanNumberOfTokens();

	/**
	 * Sets the value of the '{@link wnsim.TransitionInfo#getMeanNumberOfTokens <em>Mean Number Of Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean Number Of Tokens</em>' attribute.
	 * @see #getMeanNumberOfTokens()
	 * @generated
	 */
	void setMeanNumberOfTokens(Float value);

} // TransitionInfo
