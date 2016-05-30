/**
 */
package es.unizar.disco.simulation.models.invocation;

import es.unizar.disco.simulation.models.datatypes.Resource;

import es.unizar.disco.simulation.models.definition.SimulationDefinition;

import es.unizar.disco.simulation.models.simresult.SimulationResult;

import es.unizar.disco.simulation.models.toolresult.ToolResult;

import es.unizar.disco.simulation.models.traces.TraceSet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getTraceSet <em>Trace Set</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getToolResult <em>Tool Result</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getVariableAssignments <em>Variable Assignments</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition <em>Definition</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getCalls <em>Calls</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getResults <em>Results</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getAnalyzableResource <em>Analyzable Resource</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation()
 * @model
 * @generated
 */
public interface SimulationInvocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Trace Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Set</em>' reference.
	 * @see #setTraceSet(TraceSet)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_TraceSet()
	 * @model
	 * @generated
	 */
	TraceSet getTraceSet();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getTraceSet <em>Trace Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Set</em>' reference.
	 * @see #getTraceSet()
	 * @generated
	 */
	void setTraceSet(TraceSet value);

	/**
	 * Returns the value of the '<em><b>Tool Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Result</em>' reference.
	 * @see #setToolResult(ToolResult)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_ToolResult()
	 * @model
	 * @generated
	 */
	ToolResult getToolResult();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getToolResult <em>Tool Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool Result</em>' reference.
	 * @see #getToolResult()
	 * @generated
	 */
	void setToolResult(ToolResult value);

	/**
	 * Returns the value of the '<em><b>Variable Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.invocation.VariableAssignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Assignments</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_VariableAssignments()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableAssignment> getVariableAssignments();

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(SimulationDefinition)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_Definition()
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getInvocations
	 * @model opposite="invocations" required="true"
	 * @generated
	 */
	SimulationDefinition getDefinition();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(SimulationDefinition value);

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
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_Calls()
	 * @model required="true" transient="true" volatile="true"
	 * @generated
	 */
	SimulationTool getCalls();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getCalls <em>Calls</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calls</em>' reference.
	 * @see #getCalls()
	 * @generated
	 */
	void setCalls(SimulationTool value);

	/**
	 * Returns the value of the '<em><b>Results</b></em>' reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.simresult.SimulationResult}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.simresult.SimulationResult#getInvocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' reference list.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_Results()
	 * @see es.unizar.disco.simulation.models.simresult.SimulationResult#getInvocation
	 * @model opposite="invocation"
	 * @generated
	 */
	EList<SimulationResult> getResults();

	/**
	 * Returns the value of the '<em><b>Analyzable Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analyzable Resource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analyzable Resource</em>' containment reference.
	 * @see #setAnalyzableResource(Resource)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_AnalyzableResource()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Resource getAnalyzableResource();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getAnalyzableResource <em>Analyzable Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analyzable Resource</em>' containment reference.
	 * @see #getAnalyzableResource()
	 * @generated
	 */
	void setAnalyzableResource(Resource value);

} // SimulationInvocation
