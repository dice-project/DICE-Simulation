/**
 */
package es.unizar.disco.simulation.models.invocation;

import es.unizar.disco.simulation.models.datatypes.SimulationStatus;

import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;

import es.unizar.disco.simulation.models.simresult.SimulationResult;

import es.unizar.disco.simulation.models.toolresult.ToolResult;

import es.unizar.disco.simulation.models.traces.TraceSet;

import java.util.Date;

import org.eclipse.core.runtime.IStatus;

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
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getTraceSet <em>Trace Set</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getToolResult <em>Tool Result</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition <em>Definition</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getResult <em>Result</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getStart <em>Start</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getEnd <em>End</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getStatus <em>Status</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getVariableConfiguration <em>Variable Configuration</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getAnalyzableModel <em>Analyzable Model</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#isAutoBuild <em>Auto Build</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getInvocationSet <em>Invocation Set</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation()
 * @model
 * @generated
 */
public interface SimulationInvocation extends EObject {
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
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_Identifier()
	 * @model id="true" required="true" derived="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

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
	 * @model derived="true"
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
	 * Returns the value of the '<em><b>Result</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.simresult.SimulationResult#getInvocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' reference.
	 * @see #setResult(SimulationResult)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_Result()
	 * @see es.unizar.disco.simulation.models.simresult.SimulationResult#getInvocation
	 * @model opposite="invocation"
	 * @generated
	 */
	SimulationResult getResult();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getResult <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(SimulationResult value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(Date)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_Start()
	 * @model
	 * @generated
	 */
	Date getStart();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Date value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(Date)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_End()
	 * @model
	 * @generated
	 */
	Date getEnd();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Date value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link es.unizar.disco.simulation.models.datatypes.SimulationStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.SimulationStatus
	 * @see #setStatus(SimulationStatus)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_Status()
	 * @model
	 * @generated
	 */
	SimulationStatus getStatus();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.SimulationStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(SimulationStatus value);

	/**
	 * Returns the value of the '<em><b>Variable Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Configuration</em>' reference.
	 * @see #setVariableConfiguration(VariableConfiguration)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_VariableConfiguration()
	 * @model required="true"
	 * @generated
	 */
	VariableConfiguration getVariableConfiguration();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getVariableConfiguration <em>Variable Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Configuration</em>' reference.
	 * @see #getVariableConfiguration()
	 * @generated
	 */
	void setVariableConfiguration(VariableConfiguration value);

	/**
	 * Returns the value of the '<em><b>Analyzable Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analyzable Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analyzable Model</em>' reference list.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_AnalyzableModel()
	 * @model derived="true"
	 * @generated
	 */
	EList<EObject> getAnalyzableModel();

	/**
	 * Returns the value of the '<em><b>Auto Build</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Build</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Build</em>' attribute.
	 * @see #setAutoBuild(boolean)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_AutoBuild()
	 * @model default="false" required="true" transient="true"
	 * @generated
	 */
	boolean isAutoBuild();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#isAutoBuild <em>Auto Build</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Build</em>' attribute.
	 * @see #isAutoBuild()
	 * @generated
	 */
	void setAutoBuild(boolean value);

	/**
	 * Returns the value of the '<em><b>Invocation Set</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation Set</em>' reference.
	 * @see #setInvocationSet(InvocationSet)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getSimulationInvocation_InvocationSet()
	 * @see es.unizar.disco.simulation.models.invocation.InvocationSet#getInvocations
	 * @model opposite="invocations"
	 * @generated
	 */
	InvocationSet getInvocationSet();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getInvocationSet <em>Invocation Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation Set</em>' reference.
	 * @see #getInvocationSet()
	 * @generated
	 */
	void setInvocationSet(InvocationSet value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.IStatus"
	 * @generated
	 */
	IStatus buildAnalyzableModel();

} // SimulationInvocation
