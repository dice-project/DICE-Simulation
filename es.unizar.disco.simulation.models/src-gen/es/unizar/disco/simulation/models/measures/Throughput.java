/**
 */
package es.unizar.disco.simulation.models.measures;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throughput</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.Throughput#getThroughput <em>Throughput</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getThroughput()
 * @model
 * @generated
 */
public interface Throughput extends DomainMeasure {
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
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getThroughput_Throughput()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.Number" required="true"
	 * @generated
	 */
	Number getThroughput();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.Throughput#getThroughput <em>Throughput</em>}' attribute.
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

} // Throughput
