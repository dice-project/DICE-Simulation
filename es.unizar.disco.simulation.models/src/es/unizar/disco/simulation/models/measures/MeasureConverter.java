/**
 */
package es.unizar.disco.simulation.models.measures;

import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measure Converter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.MeasureConverter#getTo <em>To</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.MeasureConverter#getFrom <em>From</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getMeasureConverter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MeasureConverter extends EObject {
	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(DomainMeasure)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getMeasureConverter_To()
	 * @model required="true"
	 * @generated
	 */
	DomainMeasure getTo();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.MeasureConverter#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(DomainMeasure value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(AnalyzableElementInfo)
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#getMeasureConverter_From()
	 * @model required="true"
	 * @generated
	 */
	AnalyzableElementInfo getFrom();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.measures.MeasureConverter#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(AnalyzableElementInfo value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void convert();

} // MeasureConverter
