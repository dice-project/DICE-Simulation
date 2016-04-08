/**
 */
package configuration;

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
 *   <li>{@link configuration.DomainMeasure#getMeasuredElement <em>Measured Element</em>}</li>
 *   <li>{@link configuration.DomainMeasure#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see configuration.ConfigurationPackage#getDomainMeasure()
 * @model abstract="true"
 * @generated
 */
public interface DomainMeasure extends EObject {
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
	 * @see configuration.ConfigurationPackage#getDomainMeasure_MeasuredElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getMeasuredElement();

	/**
	 * Sets the value of the '{@link configuration.DomainMeasure#getMeasuredElement <em>Measured Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measured Element</em>' reference.
	 * @see #getMeasuredElement()
	 * @generated
	 */
	void setMeasuredElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see configuration.ConfigurationPackage#getDomainMeasure_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link configuration.DomainMeasure#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

} // DomainMeasure
