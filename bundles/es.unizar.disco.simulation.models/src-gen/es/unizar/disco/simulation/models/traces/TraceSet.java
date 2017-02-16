/**
 */
package es.unizar.disco.simulation.models.traces;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.traces.TraceSet#getTraces <em>Traces</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.traces.TracesPackage#getTraceSet()
 * @model
 * @generated
 */
public interface TraceSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Traces</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.traces.Trace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.traces.TracesPackage#getTraceSet_Traces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Trace> getTraces();

} // TraceSet
