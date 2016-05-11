/**
 */
package es.unizar.disco.simulation.models.measures;

import es.unizar.disco.simulation.models.datatypes.Unit;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getMeasuredElement <em>Measured Element</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasure()
 * @model abstract="true"
 * @generated
 */
public interface DomainMeasure extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasure_Value()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.Number" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Number getValue();

	/**
	 * Returns the value of the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measured Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measured Element</em>' reference.
	 * @see #setMeasuredElement(EObject)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasure_MeasuredElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getMeasuredElement();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getMeasuredElement <em>Measured Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measured Element</em>' reference.
	 * @see #getMeasuredElement()
	 * @generated
	 */
	void setMeasuredElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The literals are from the enumeration {@link es.unizar.disco.simulation.models.datatypes.Unit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.Unit
	 * @see #setUnit(Unit)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getDomainMeasure_Unit()
	 * @model required="true"
	 * @generated
	 */
	Unit getUnit();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.Unit
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(Unit value);

} // DomainMeasure
