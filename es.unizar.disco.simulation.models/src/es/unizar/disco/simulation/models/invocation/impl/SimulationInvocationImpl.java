/**
 */
package es.unizar.disco.simulation.models.invocation.impl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.invocation.SimulationTool;
import es.unizar.disco.simulation.models.invocation.VariableAssignment;

import es.unizar.disco.simulation.models.toolresult.ToolResult;

import es.unizar.disco.simulation.models.traces.TraceSet;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl#getTraceSet <em>Trace Set</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl#getToolResult <em>Tool Result</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl#getVariableAssignments <em>Variable Assignments</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl#getAnalizableResource <em>Analizable Resource</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl#getCalls <em>Calls</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl#getCalculates <em>Calculates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulationInvocationImpl extends MinimalEObjectImpl.Container implements SimulationInvocation {
	/**
	 * The cached value of the '{@link #getTraceSet() <em>Trace Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceSet()
	 * @generated
	 * @ordered
	 */
	protected TraceSet traceSet;

	/**
	 * The cached value of the '{@link #getToolResult() <em>Tool Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolResult()
	 * @generated
	 * @ordered
	 */
	protected ToolResult toolResult;

	/**
	 * The cached value of the '{@link #getVariableAssignments() <em>Variable Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableAssignment> variableAssignments;

	/**
	 * The default value of the '{@link #getAnalizableResource() <em>Analizable Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalizableResource()
	 * @generated
	 * @ordered
	 */
	protected static final URI ANALIZABLE_RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnalizableResource() <em>Analizable Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalizableResource()
	 * @generated
	 * @ordered
	 */
	protected URI analizableResource = ANALIZABLE_RESOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected SimulationDefinition definition;

	/**
	 * The cached value of the '{@link #getCalculates() <em>Calculates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalculates()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputVariable> calculates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationInvocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvocationPackage.Literals.SIMULATION_INVOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSet getTraceSet() {
		if (traceSet != null && traceSet.eIsProxy()) {
			InternalEObject oldTraceSet = (InternalEObject)traceSet;
			traceSet = (TraceSet)eResolveProxy(oldTraceSet);
			if (traceSet != oldTraceSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InvocationPackage.SIMULATION_INVOCATION__TRACE_SET, oldTraceSet, traceSet));
			}
		}
		return traceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSet basicGetTraceSet() {
		return traceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceSet(TraceSet newTraceSet) {
		TraceSet oldTraceSet = traceSet;
		traceSet = newTraceSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvocationPackage.SIMULATION_INVOCATION__TRACE_SET, oldTraceSet, traceSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolResult getToolResult() {
		if (toolResult != null && toolResult.eIsProxy()) {
			InternalEObject oldToolResult = (InternalEObject)toolResult;
			toolResult = (ToolResult)eResolveProxy(oldToolResult);
			if (toolResult != oldToolResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InvocationPackage.SIMULATION_INVOCATION__TOOL_RESULT, oldToolResult, toolResult));
			}
		}
		return toolResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolResult basicGetToolResult() {
		return toolResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToolResult(ToolResult newToolResult) {
		ToolResult oldToolResult = toolResult;
		toolResult = newToolResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvocationPackage.SIMULATION_INVOCATION__TOOL_RESULT, oldToolResult, toolResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableAssignment> getVariableAssignments() {
		if (variableAssignments == null) {
			variableAssignments = new EObjectContainmentEList<VariableAssignment>(VariableAssignment.class, this, InvocationPackage.SIMULATION_INVOCATION__VARIABLE_ASSIGNMENTS);
		}
		return variableAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getAnalizableResource() {
		return analizableResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalizableResource(URI newAnalizableResource) {
		URI oldAnalizableResource = analizableResource;
		analizableResource = newAnalizableResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvocationPackage.SIMULATION_INVOCATION__ANALIZABLE_RESOURCE, oldAnalizableResource, analizableResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationDefinition getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (SimulationDefinition)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InvocationPackage.SIMULATION_INVOCATION__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationDefinition basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinition(SimulationDefinition newDefinition, NotificationChain msgs) {
		SimulationDefinition oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InvocationPackage.SIMULATION_INVOCATION__DEFINITION, oldDefinition, newDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(SimulationDefinition newDefinition) {
		if (newDefinition != definition) {
			NotificationChain msgs = null;
			if (definition != null)
				msgs = ((InternalEObject)definition).eInverseRemove(this, DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS, SimulationDefinition.class, msgs);
			if (newDefinition != null)
				msgs = ((InternalEObject)newDefinition).eInverseAdd(this, DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS, SimulationDefinition.class, msgs);
			msgs = basicSetDefinition(newDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvocationPackage.SIMULATION_INVOCATION__DEFINITION, newDefinition, newDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationTool getCalls() {
		SimulationTool calls = basicGetCalls();
		return calls != null && calls.eIsProxy() ? (SimulationTool)eResolveProxy((InternalEObject)calls) : calls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationTool basicGetCalls() {
		// TODO: implement this method to return the 'Calls' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalls(SimulationTool newCalls) {
		// TODO: implement this method to set the 'Calls' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputVariable> getCalculates() {
		if (calculates == null) {
			calculates = new EObjectResolvingEList<OutputVariable>(OutputVariable.class, this, InvocationPackage.SIMULATION_INVOCATION__CALCULATES);
		}
		return calculates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InvocationPackage.SIMULATION_INVOCATION__DEFINITION:
				if (definition != null)
					msgs = ((InternalEObject)definition).eInverseRemove(this, DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS, SimulationDefinition.class, msgs);
				return basicSetDefinition((SimulationDefinition)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InvocationPackage.SIMULATION_INVOCATION__VARIABLE_ASSIGNMENTS:
				return ((InternalEList<?>)getVariableAssignments()).basicRemove(otherEnd, msgs);
			case InvocationPackage.SIMULATION_INVOCATION__DEFINITION:
				return basicSetDefinition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InvocationPackage.SIMULATION_INVOCATION__TRACE_SET:
				if (resolve) return getTraceSet();
				return basicGetTraceSet();
			case InvocationPackage.SIMULATION_INVOCATION__TOOL_RESULT:
				if (resolve) return getToolResult();
				return basicGetToolResult();
			case InvocationPackage.SIMULATION_INVOCATION__VARIABLE_ASSIGNMENTS:
				return getVariableAssignments();
			case InvocationPackage.SIMULATION_INVOCATION__ANALIZABLE_RESOURCE:
				return getAnalizableResource();
			case InvocationPackage.SIMULATION_INVOCATION__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
			case InvocationPackage.SIMULATION_INVOCATION__CALLS:
				if (resolve) return getCalls();
				return basicGetCalls();
			case InvocationPackage.SIMULATION_INVOCATION__CALCULATES:
				return getCalculates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InvocationPackage.SIMULATION_INVOCATION__TRACE_SET:
				setTraceSet((TraceSet)newValue);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__TOOL_RESULT:
				setToolResult((ToolResult)newValue);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__VARIABLE_ASSIGNMENTS:
				getVariableAssignments().clear();
				getVariableAssignments().addAll((Collection<? extends VariableAssignment>)newValue);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__ANALIZABLE_RESOURCE:
				setAnalizableResource((URI)newValue);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__DEFINITION:
				setDefinition((SimulationDefinition)newValue);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__CALLS:
				setCalls((SimulationTool)newValue);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__CALCULATES:
				getCalculates().clear();
				getCalculates().addAll((Collection<? extends OutputVariable>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InvocationPackage.SIMULATION_INVOCATION__TRACE_SET:
				setTraceSet((TraceSet)null);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__TOOL_RESULT:
				setToolResult((ToolResult)null);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__VARIABLE_ASSIGNMENTS:
				getVariableAssignments().clear();
				return;
			case InvocationPackage.SIMULATION_INVOCATION__ANALIZABLE_RESOURCE:
				setAnalizableResource(ANALIZABLE_RESOURCE_EDEFAULT);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__DEFINITION:
				setDefinition((SimulationDefinition)null);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__CALLS:
				setCalls((SimulationTool)null);
				return;
			case InvocationPackage.SIMULATION_INVOCATION__CALCULATES:
				getCalculates().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InvocationPackage.SIMULATION_INVOCATION__TRACE_SET:
				return traceSet != null;
			case InvocationPackage.SIMULATION_INVOCATION__TOOL_RESULT:
				return toolResult != null;
			case InvocationPackage.SIMULATION_INVOCATION__VARIABLE_ASSIGNMENTS:
				return variableAssignments != null && !variableAssignments.isEmpty();
			case InvocationPackage.SIMULATION_INVOCATION__ANALIZABLE_RESOURCE:
				return ANALIZABLE_RESOURCE_EDEFAULT == null ? analizableResource != null : !ANALIZABLE_RESOURCE_EDEFAULT.equals(analizableResource);
			case InvocationPackage.SIMULATION_INVOCATION__DEFINITION:
				return definition != null;
			case InvocationPackage.SIMULATION_INVOCATION__CALLS:
				return basicGetCalls() != null;
			case InvocationPackage.SIMULATION_INVOCATION__CALCULATES:
				return calculates != null && !calculates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (analizableResource: ");
		result.append(analizableResource);
		result.append(')');
		return result.toString();
	}

} //SimulationInvocationImpl
