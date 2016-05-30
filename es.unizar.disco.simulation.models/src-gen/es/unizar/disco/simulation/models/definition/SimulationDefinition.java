/**
 */
package es.unizar.disco.simulation.models.definition;

import es.unizar.disco.simulation.models.datatypes.Resource;

import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import java.util.Date;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
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
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getName <em>Name</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getParameters <em>Parameters</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveScenario <em>Active Scenario</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariables <em>Variables</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource <em>Domain Resource</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getMaxExecutionTime <em>Max Execution Time</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition()
 * @model
 * @generated
 */
public interface SimulationDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Identifier()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

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
	 * Returns the value of the '<em><b>Parameters</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' map.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Parameters()
	 * @model mapType="es.unizar.disco.simulation.models.definition.SimulationParameter<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getParameters();

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
	 * @model required="true" transient="true" derived="true"
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
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Domain Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Resource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Resource</em>' containment reference.
	 * @see #setDomainResource(Resource)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_DomainResource()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Resource getDomainResource();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource <em>Domain Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Resource</em>' containment reference.
	 * @see #getDomainResource()
	 * @generated
	 */
	void setDomainResource(Resource value);

	/**
	 * Returns the value of the '<em><b>Max Execution Time</b></em>' attribute.
	 * The default value is <code>"0000-00-00\'01:00:00"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Execution Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Execution Time</em>' attribute.
	 * @see #setMaxExecutionTime(Date)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_MaxExecutionTime()
	 * @model default="0000-00-00\'01:00:00" required="true"
	 * @generated
	 */
	Date getMaxExecutionTime();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getMaxExecutionTime <em>Max Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Execution Time</em>' attribute.
	 * @see #getMaxExecutionTime()
	 * @generated
	 */
	void setMaxExecutionTime(Date value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void syncScenarios();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void syncVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Variable getVariable(String name);

} // SimulationDefinition
