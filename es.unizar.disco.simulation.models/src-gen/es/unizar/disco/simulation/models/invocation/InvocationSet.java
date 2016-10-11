/**
 */
package es.unizar.disco.simulation.models.invocation;

import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getDefinition <em>Definition</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getStart <em>Start</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getEnd <em>End</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationSet()
 * @model
 * @generated
 */
public interface InvocationSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Invocations</b></em>' reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.invocation.SimulationInvocation}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getInvocationSet <em>Invocation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocations</em>' reference list.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationSet_Invocations()
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getInvocationSet
	 * @model opposite="invocationSet" required="true"
	 * @generated
	 */
	EList<SimulationInvocation> getInvocations();

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationSet_Start()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Date getStart();

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationSet_End()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Date getEnd();

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
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationSet_Status()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	SimulationStatus getStatus();

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(SimulationDefinition)
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationSet_Definition()
	 * @model required="true"
	 * @generated
	 */
	SimulationDefinition getDefinition();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(SimulationDefinition value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationPackage#getInvocationSet_Identifier()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getIdentifier();

} // InvocationSet
