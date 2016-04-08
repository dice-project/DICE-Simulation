/**
 */
package configuration;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link configuration.Invocation#getId <em>Id</em>}</li>
 *   <li>{@link configuration.Invocation#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link configuration.Invocation#getVariableAssignments <em>Variable Assignments</em>}</li>
 *   <li>{@link configuration.Invocation#getToolResult <em>Tool Result</em>}</li>
 *   <li>{@link configuration.Invocation#getAnalizableInput <em>Analizable Input</em>}</li>
 *   <li>{@link configuration.Invocation#getSimulationDefinition <em>Simulation Definition</em>}</li>
 *   <li>{@link configuration.Invocation#getTraces <em>Traces</em>}</li>
 *   <li>{@link configuration.Invocation#getCalls <em>Calls</em>}</li>
 * </ul>
 *
 * @see configuration.ConfigurationPackage#getInvocation()
 * @model
 * @generated
 */
public interface Invocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see configuration.ConfigurationPackage#getInvocation_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link configuration.Invocation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(Date)
	 * @see configuration.ConfigurationPackage#getInvocation_Timestamp()
	 * @model required="true"
	 * @generated
	 */
	Date getTimestamp();

	/**
	 * Sets the value of the '{@link configuration.Invocation#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(Date value);

	/**
	 * Returns the value of the '<em><b>Variable Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link configuration.VariableAssignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Assignments</em>' containment reference list.
	 * @see configuration.ConfigurationPackage#getInvocation_VariableAssignments()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableAssignment> getVariableAssignments();

	/**
	 * Returns the value of the '<em><b>Tool Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Result</em>' containment reference.
	 * @see #setToolResult(ToolResult)
	 * @see configuration.ConfigurationPackage#getInvocation_ToolResult()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ToolResult getToolResult();

	/**
	 * Sets the value of the '{@link configuration.Invocation#getToolResult <em>Tool Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool Result</em>' containment reference.
	 * @see #getToolResult()
	 * @generated
	 */
	void setToolResult(ToolResult value);

	/**
	 * Returns the value of the '<em><b>Analizable Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analizable Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analizable Input</em>' containment reference.
	 * @see #setAnalizableInput(Resource)
	 * @see configuration.ConfigurationPackage#getInvocation_AnalizableInput()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Resource getAnalizableInput();

	/**
	 * Sets the value of the '{@link configuration.Invocation#getAnalizableInput <em>Analizable Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analizable Input</em>' containment reference.
	 * @see #getAnalizableInput()
	 * @generated
	 */
	void setAnalizableInput(Resource value);

	/**
	 * Returns the value of the '<em><b>Simulation Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link configuration.SimulationDefinition#getInvocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simulation Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Definition</em>' container reference.
	 * @see #setSimulationDefinition(SimulationDefinition)
	 * @see configuration.ConfigurationPackage#getInvocation_SimulationDefinition()
	 * @see configuration.SimulationDefinition#getInvocation
	 * @model opposite="invocation" required="true" transient="false"
	 * @generated
	 */
	SimulationDefinition getSimulationDefinition();

	/**
	 * Sets the value of the '{@link configuration.Invocation#getSimulationDefinition <em>Simulation Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Definition</em>' container reference.
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	void setSimulationDefinition(SimulationDefinition value);

	/**
	 * Returns the value of the '<em><b>Traces</b></em>' containment reference list.
	 * The list contents are of type {@link configuration.Trace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' containment reference list.
	 * @see configuration.ConfigurationPackage#getInvocation_Traces()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Trace> getTraces();

	/**
	 * Returns the value of the '<em><b>Calls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calls</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls</em>' reference.
	 * @see #setCalls(SimulationTool)
	 * @see configuration.ConfigurationPackage#getInvocation_Calls()
	 * @model required="true" transient="true" volatile="true"
	 * @generated
	 */
	SimulationTool getCalls();

	/**
	 * Sets the value of the '{@link configuration.Invocation#getCalls <em>Calls</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calls</em>' reference.
	 * @see #getCalls()
	 * @generated
	 */
	void setCalls(SimulationTool value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void createAnalizableInput();

} // Invocation
