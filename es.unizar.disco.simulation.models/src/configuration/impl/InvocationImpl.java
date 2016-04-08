/**
 */
package configuration.impl;

import configuration.ConfigurationPackage;
import configuration.Invocation;
import configuration.Resource;
import configuration.SimulationDefinition;
import configuration.SimulationTool;
import configuration.ToolResult;
import configuration.Trace;
import configuration.VariableAssignment;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link configuration.impl.InvocationImpl#getId <em>Id</em>}</li>
 *   <li>{@link configuration.impl.InvocationImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link configuration.impl.InvocationImpl#getVariableAssignments <em>Variable Assignments</em>}</li>
 *   <li>{@link configuration.impl.InvocationImpl#getToolResult <em>Tool Result</em>}</li>
 *   <li>{@link configuration.impl.InvocationImpl#getAnalizableInput <em>Analizable Input</em>}</li>
 *   <li>{@link configuration.impl.InvocationImpl#getSimulationDefinition <em>Simulation Definition</em>}</li>
 *   <li>{@link configuration.impl.InvocationImpl#getTraces <em>Traces</em>}</li>
 *   <li>{@link configuration.impl.InvocationImpl#getCalls <em>Calls</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvocationImpl extends MinimalEObjectImpl.Container implements Invocation {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final Date TIMESTAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected Date timestamp = TIMESTAMP_EDEFAULT;

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
	 * The cached value of the '{@link #getToolResult() <em>Tool Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolResult()
	 * @generated
	 * @ordered
	 */
	protected ToolResult toolResult;

	/**
	 * The cached value of the '{@link #getAnalizableInput() <em>Analizable Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalizableInput()
	 * @generated
	 * @ordered
	 */
	protected Resource analizableInput;

	/**
	 * The cached value of the '{@link #getTraces() <em>Traces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraces()
	 * @generated
	 * @ordered
	 */
	protected EList<Trace> traces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.INVOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.INVOCATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestamp(Date newTimestamp) {
		Date oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.INVOCATION__TIMESTAMP, oldTimestamp, timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableAssignment> getVariableAssignments() {
		if (variableAssignments == null) {
			variableAssignments = new EObjectContainmentEList<VariableAssignment>(VariableAssignment.class, this, ConfigurationPackage.INVOCATION__VARIABLE_ASSIGNMENTS);
		}
		return variableAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolResult getToolResult() {
		return toolResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToolResult(ToolResult newToolResult, NotificationChain msgs) {
		ToolResult oldToolResult = toolResult;
		toolResult = newToolResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.INVOCATION__TOOL_RESULT, oldToolResult, newToolResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToolResult(ToolResult newToolResult) {
		if (newToolResult != toolResult) {
			NotificationChain msgs = null;
			if (toolResult != null)
				msgs = ((InternalEObject)toolResult).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.INVOCATION__TOOL_RESULT, null, msgs);
			if (newToolResult != null)
				msgs = ((InternalEObject)newToolResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.INVOCATION__TOOL_RESULT, null, msgs);
			msgs = basicSetToolResult(newToolResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.INVOCATION__TOOL_RESULT, newToolResult, newToolResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getAnalizableInput() {
		return analizableInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalizableInput(Resource newAnalizableInput, NotificationChain msgs) {
		Resource oldAnalizableInput = analizableInput;
		analizableInput = newAnalizableInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT, oldAnalizableInput, newAnalizableInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalizableInput(Resource newAnalizableInput) {
		if (newAnalizableInput != analizableInput) {
			NotificationChain msgs = null;
			if (analizableInput != null)
				msgs = ((InternalEObject)analizableInput).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT, null, msgs);
			if (newAnalizableInput != null)
				msgs = ((InternalEObject)newAnalizableInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT, null, msgs);
			msgs = basicSetAnalizableInput(newAnalizableInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT, newAnalizableInput, newAnalizableInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationDefinition getSimulationDefinition() {
		if (eContainerFeatureID() != ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION) return null;
		return (SimulationDefinition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimulationDefinition(SimulationDefinition newSimulationDefinition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSimulationDefinition, ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulationDefinition(SimulationDefinition newSimulationDefinition) {
		if (newSimulationDefinition != eInternalContainer() || (eContainerFeatureID() != ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION && newSimulationDefinition != null)) {
			if (EcoreUtil.isAncestor(this, newSimulationDefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSimulationDefinition != null)
				msgs = ((InternalEObject)newSimulationDefinition).eInverseAdd(this, ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION, SimulationDefinition.class, msgs);
			msgs = basicSetSimulationDefinition(newSimulationDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION, newSimulationDefinition, newSimulationDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Trace> getTraces() {
		if (traces == null) {
			traces = new EObjectContainmentEList<Trace>(Trace.class, this, ConfigurationPackage.INVOCATION__TRACES);
		}
		return traces;
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
	public void createAnalizableInput() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSimulationDefinition((SimulationDefinition)otherEnd, msgs);
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
			case ConfigurationPackage.INVOCATION__VARIABLE_ASSIGNMENTS:
				return ((InternalEList<?>)getVariableAssignments()).basicRemove(otherEnd, msgs);
			case ConfigurationPackage.INVOCATION__TOOL_RESULT:
				return basicSetToolResult(null, msgs);
			case ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT:
				return basicSetAnalizableInput(null, msgs);
			case ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION:
				return basicSetSimulationDefinition(null, msgs);
			case ConfigurationPackage.INVOCATION__TRACES:
				return ((InternalEList<?>)getTraces()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION:
				return eInternalContainer().eInverseRemove(this, ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION, SimulationDefinition.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.INVOCATION__ID:
				return getId();
			case ConfigurationPackage.INVOCATION__TIMESTAMP:
				return getTimestamp();
			case ConfigurationPackage.INVOCATION__VARIABLE_ASSIGNMENTS:
				return getVariableAssignments();
			case ConfigurationPackage.INVOCATION__TOOL_RESULT:
				return getToolResult();
			case ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT:
				return getAnalizableInput();
			case ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION:
				return getSimulationDefinition();
			case ConfigurationPackage.INVOCATION__TRACES:
				return getTraces();
			case ConfigurationPackage.INVOCATION__CALLS:
				if (resolve) return getCalls();
				return basicGetCalls();
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
			case ConfigurationPackage.INVOCATION__ID:
				setId((String)newValue);
				return;
			case ConfigurationPackage.INVOCATION__TIMESTAMP:
				setTimestamp((Date)newValue);
				return;
			case ConfigurationPackage.INVOCATION__VARIABLE_ASSIGNMENTS:
				getVariableAssignments().clear();
				getVariableAssignments().addAll((Collection<? extends VariableAssignment>)newValue);
				return;
			case ConfigurationPackage.INVOCATION__TOOL_RESULT:
				setToolResult((ToolResult)newValue);
				return;
			case ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT:
				setAnalizableInput((Resource)newValue);
				return;
			case ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION:
				setSimulationDefinition((SimulationDefinition)newValue);
				return;
			case ConfigurationPackage.INVOCATION__TRACES:
				getTraces().clear();
				getTraces().addAll((Collection<? extends Trace>)newValue);
				return;
			case ConfigurationPackage.INVOCATION__CALLS:
				setCalls((SimulationTool)newValue);
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
			case ConfigurationPackage.INVOCATION__ID:
				setId(ID_EDEFAULT);
				return;
			case ConfigurationPackage.INVOCATION__TIMESTAMP:
				setTimestamp(TIMESTAMP_EDEFAULT);
				return;
			case ConfigurationPackage.INVOCATION__VARIABLE_ASSIGNMENTS:
				getVariableAssignments().clear();
				return;
			case ConfigurationPackage.INVOCATION__TOOL_RESULT:
				setToolResult((ToolResult)null);
				return;
			case ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT:
				setAnalizableInput((Resource)null);
				return;
			case ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION:
				setSimulationDefinition((SimulationDefinition)null);
				return;
			case ConfigurationPackage.INVOCATION__TRACES:
				getTraces().clear();
				return;
			case ConfigurationPackage.INVOCATION__CALLS:
				setCalls((SimulationTool)null);
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
			case ConfigurationPackage.INVOCATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ConfigurationPackage.INVOCATION__TIMESTAMP:
				return TIMESTAMP_EDEFAULT == null ? timestamp != null : !TIMESTAMP_EDEFAULT.equals(timestamp);
			case ConfigurationPackage.INVOCATION__VARIABLE_ASSIGNMENTS:
				return variableAssignments != null && !variableAssignments.isEmpty();
			case ConfigurationPackage.INVOCATION__TOOL_RESULT:
				return toolResult != null;
			case ConfigurationPackage.INVOCATION__ANALIZABLE_INPUT:
				return analizableInput != null;
			case ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION:
				return getSimulationDefinition() != null;
			case ConfigurationPackage.INVOCATION__TRACES:
				return traces != null && !traces.isEmpty();
			case ConfigurationPackage.INVOCATION__CALLS:
				return basicGetCalls() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConfigurationPackage.INVOCATION___CREATE_ANALIZABLE_INPUT:
				createAnalizableInput();
				return null;
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", timestamp: ");
		result.append(timestamp);
		result.append(')');
		return result.toString();
	}

} //InvocationImpl
