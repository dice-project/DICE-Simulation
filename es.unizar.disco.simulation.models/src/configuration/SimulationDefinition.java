/**
 */
package configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link configuration.SimulationDefinition#getParameters <em>Parameters</em>}</li>
 *   <li>{@link configuration.SimulationDefinition#getDomainInput <em>Domain Input</em>}</li>
 *   <li>{@link configuration.SimulationDefinition#getScenario <em>Scenario</em>}</li>
 *   <li>{@link configuration.SimulationDefinition#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link configuration.SimulationDefinition#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see configuration.ConfigurationPackage#getSimulationDefinition()
 * @model
 * @generated
 */
public interface SimulationDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link configuration.SimulationParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see configuration.ConfigurationPackage#getSimulationDefinition_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimulationParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Domain Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Input</em>' containment reference.
	 * @see #setDomainInput(Resource)
	 * @see configuration.ConfigurationPackage#getSimulationDefinition_DomainInput()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Resource getDomainInput();

	/**
	 * Sets the value of the '{@link configuration.SimulationDefinition#getDomainInput <em>Domain Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Input</em>' containment reference.
	 * @see #getDomainInput()
	 * @generated
	 */
	void setDomainInput(Resource value);

	/**
	 * Returns the value of the '<em><b>Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario</em>' containment reference.
	 * @see #setScenario(ScenarioInformation)
	 * @see configuration.ConfigurationPackage#getSimulationDefinition_Scenario()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ScenarioInformation getScenario();

	/**
	 * Sets the value of the '{@link configuration.SimulationDefinition#getScenario <em>Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario</em>' containment reference.
	 * @see #getScenario()
	 * @generated
	 */
	void setScenario(ScenarioInformation value);

	/**
	 * Returns the value of the '<em><b>Invocation</b></em>' containment reference list.
	 * The list contents are of type {@link configuration.Invocation}.
	 * It is bidirectional and its opposite is '{@link configuration.Invocation#getSimulationDefinition <em>Simulation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation</em>' containment reference list.
	 * @see configuration.ConfigurationPackage#getSimulationDefinition_Invocation()
	 * @see configuration.Invocation#getSimulationDefinition
	 * @model opposite="simulationDefinition" containment="true"
	 * @generated
	 */
	EList<Invocation> getInvocation();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see configuration.ConfigurationPackage#getSimulationDefinition_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link configuration.SimulationDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void buildScenarioInformation();

} // SimulationDefinition
