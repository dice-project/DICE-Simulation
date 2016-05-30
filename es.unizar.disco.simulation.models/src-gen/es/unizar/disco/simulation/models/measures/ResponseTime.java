/**
 */
package es.unizar.disco.simulation.models.measures;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.ResponseTime#getResponseTime <em>Response Time</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getResponseTime()
 * @model
 * @generated
 */
public interface ResponseTime extends DomainMeasure {
	/**
	 * Returns the value of the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Time</em>' attribute.
	 * @see #setResponseTime(Number)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getResponseTime_ResponseTime()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.Number" required="true"
	 * @generated
	 */
	Number getResponseTime();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.ResponseTime#getResponseTime <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Time</em>' attribute.
	 * @see #getResponseTime()
	 * @generated
	 */
	void setResponseTime(Number value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="es.unizar.disco.simulation.models.datatypes.Number"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return responseTime;'"
	 * @generated
	 */
	Number getValue();

} // ResponseTime
