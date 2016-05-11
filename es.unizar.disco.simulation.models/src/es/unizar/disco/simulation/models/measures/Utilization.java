/**
 */
package es.unizar.disco.simulation.models.measures;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Utilization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.Utilization#getUtilization <em>Utilization</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getUtilization()
 * @model
 * @generated
 */
public interface Utilization extends DomainMeasure {

	/**
	 * Returns the value of the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization</em>' attribute.
	 * @see #setUtilization(Number)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getUtilization_Utilization()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.Number" required="true"
	 * @generated
	 */
	Number getUtilization();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.Utilization#getUtilization <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization</em>' attribute.
	 * @see #getUtilization()
	 * @generated
	 */
	void setUtilization(Number value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="es.unizar.disco.simulation.models.datatypes.Number"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return utilization;'"
	 * @generated
	 */
	Number getValue();
} // Utilization
