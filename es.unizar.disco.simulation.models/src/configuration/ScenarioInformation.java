/**
 */
package configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link configuration.ScenarioInformation#getVariables <em>Variables</em>}</li>
 *   <li>{@link configuration.ScenarioInformation#getMeasures <em>Measures</em>}</li>
 * </ul>
 *
 * @see configuration.ConfigurationPackage#getScenarioInformation()
 * @model
 * @generated
 */
public interface ScenarioInformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link configuration.Variables}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see configuration.ConfigurationPackage#getScenarioInformation_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variables> getVariables();

	/**
	 * Returns the value of the '<em><b>Measures</b></em>' reference list.
	 * The list contents are of type {@link configuration.DomainMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measures</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measures</em>' reference list.
	 * @see configuration.ConfigurationPackage#getScenarioInformation_Measures()
	 * @model required="true"
	 * @generated
	 */
	EList<DomainMeasure> getMeasures();

} // ScenarioInformation
