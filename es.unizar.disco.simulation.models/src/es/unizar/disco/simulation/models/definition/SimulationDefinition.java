/**
 */
package es.unizar.disco.simulation.models.definition;

import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

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
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getName <em>Name</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource <em>Domain Resource</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getParameters <em>Parameters</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveScenario <em>Active Scenario</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition()
 * @model
 * @generated
 */
public interface SimulationDefinition extends EObject {
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
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Domain Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Resource</em>' attribute.
	 * @see #setDomainResource(URI)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_DomainResource()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.URI" required="true"
	 * @generated
	 */
	URI getDomainResource();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource <em>Domain Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Resource</em>' attribute.
	 * @see #getDomainResource()
	 * @generated
	 */
	void setDomainResource(URI value);

	/**
	 * Returns the value of the '<em><b>Invocations</b></em>' reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.invocation.SimulationInvocation}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocations</em>' reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Invocations()
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition
	 * @model opposite="definition"
	 * @generated
	 */
	EList<SimulationInvocation> getInvocations();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.SimulationParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimulationParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Active Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Scenario</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Scenario</em>' reference.
	 * @see #setActiveScenario(EObject)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_ActiveScenario()
	 * @model required="true"
	 * @generated
	 */
	EObject getActiveScenario();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveScenario <em>Active Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Scenario</em>' reference.
	 * @see #getActiveScenario()
	 * @generated
	 */
	void setActiveScenario(EObject value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenarios</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Scenarios()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<EObject> getScenarios();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

} // SimulationDefinition
