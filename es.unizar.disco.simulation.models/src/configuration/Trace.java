/**
 */
package configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link configuration.Trace#getFromDomainElement <em>From Domain Element</em>}</li>
 *   <li>{@link configuration.Trace#getToAnalyzableElement <em>To Analyzable Element</em>}</li>
 *   <li>{@link configuration.Trace#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see configuration.ConfigurationPackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject {
	/**
	 * Returns the value of the '<em><b>From Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Domain Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Domain Element</em>' reference.
	 * @see #setFromDomainElement(EObject)
	 * @see configuration.ConfigurationPackage#getTrace_FromDomainElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getFromDomainElement();

	/**
	 * Sets the value of the '{@link configuration.Trace#getFromDomainElement <em>From Domain Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Domain Element</em>' reference.
	 * @see #getFromDomainElement()
	 * @generated
	 */
	void setFromDomainElement(EObject value);

	/**
	 * Returns the value of the '<em><b>To Analyzable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Analyzable Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Analyzable Element</em>' reference.
	 * @see #setToAnalyzableElement(EObject)
	 * @see configuration.ConfigurationPackage#getTrace_ToAnalyzableElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getToAnalyzableElement();

	/**
	 * Sets the value of the '{@link configuration.Trace#getToAnalyzableElement <em>To Analyzable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Analyzable Element</em>' reference.
	 * @see #getToAnalyzableElement()
	 * @generated
	 */
	void setToAnalyzableElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' attribute.
	 * @see #setRule(String)
	 * @see configuration.ConfigurationPackage#getTrace_Rule()
	 * @model
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link configuration.Trace#getRule <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' attribute.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(String value);

} // Trace
