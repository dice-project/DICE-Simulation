/**
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.datatypes.Resource;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.Variable;
import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getActiveScenario <em>Active Scenario</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getDomainResource <em>Domain Resource</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getMaxExecutionTime <em>Max Execution Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulationDefinitionImpl extends MinimalEObjectImpl.Container implements SimulationDefinition {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInvocations() <em>Invocations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocations()
	 * @generated
	 * @ordered
	 */
	protected EList<SimulationInvocation> invocations;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> parameters;

	/**
	 * The cached value of the '{@link #getActiveScenario() <em>Active Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveScenario()
	 * @generated
	 * @ordered
	 */
	protected EObject activeScenario;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> scenarios;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * The cached value of the '{@link #getDomainResource() <em>Domain Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainResource()
	 * @generated
	 * @ordered
	 */
	protected Resource domainResource;

	/**
	 * The default value of the '{@link #getMaxExecutionTime() <em>Max Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected static final Date MAX_EXECUTION_TIME_EDEFAULT = (Date)EcoreFactory.eINSTANCE.createFromString(EcorePackage.eINSTANCE.getEDate(), "0000-00-00\'01:00:00");

	/**
	 * The cached value of the '{@link #getMaxExecutionTime() <em>Max Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected Date maxExecutionTime = MAX_EXECUTION_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefinitionPackage.Literals.SIMULATION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimulationInvocation> getInvocations() {
		if (invocations == null) {
			invocations = new EObjectWithInverseResolvingEList<SimulationInvocation>(SimulationInvocation.class, this, DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS, InvocationPackage.SIMULATION_INVOCATION__DEFINITION);
		}
		return invocations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getParameters() {
		if (parameters == null) {
			parameters = new EcoreEMap<String,String>(DefinitionPackage.Literals.SIMULATION_PARAMETER, SimulationParameterImpl.class, this, DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getActiveScenario() {
		if (activeScenario != null && activeScenario.eIsProxy()) {
			InternalEObject oldActiveScenario = (InternalEObject)activeScenario;
			activeScenario = eResolveProxy(oldActiveScenario);
			if (activeScenario != oldActiveScenario) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO, oldActiveScenario, activeScenario));
			}
		}
		return activeScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetActiveScenario() {
		return activeScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveScenario(EObject newActiveScenario) {
		EObject oldActiveScenario = activeScenario;
		activeScenario = newActiveScenario;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO, oldActiveScenario, activeScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectResolvingEList<EObject>(EObject.class, this, DefinitionPackage.SIMULATION_DEFINITION__SCENARIOS);
		}
		return scenarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<Variable>(Variable.class, this, DefinitionPackage.SIMULATION_DEFINITION__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getDomainResource() {
		return domainResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomainResource(Resource newDomainResource, NotificationChain msgs) {
		Resource oldDomainResource = domainResource;
		domainResource = newDomainResource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE, oldDomainResource, newDomainResource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainResource(Resource newDomainResource) {
		if (newDomainResource != domainResource) {
			NotificationChain msgs = null;
			if (domainResource != null)
				msgs = ((InternalEObject)domainResource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE, null, msgs);
			if (newDomainResource != null)
				msgs = ((InternalEObject)newDomainResource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE, null, msgs);
			msgs = basicSetDomainResource(newDomainResource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE, newDomainResource, newDomainResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getMaxExecutionTime() {
		return maxExecutionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxExecutionTime(Date newMaxExecutionTime) {
		Date oldMaxExecutionTime = maxExecutionTime;
		maxExecutionTime = newMaxExecutionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME, oldMaxExecutionTime, maxExecutionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void syncScenarios() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void syncVariables() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInvocations()).basicAdd(otherEnd, msgs);
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
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				return ((InternalEList<?>)getInvocations()).basicRemove(otherEnd, msgs);
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case DefinitionPackage.SIMULATION_DEFINITION__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				return basicSetDomainResource(null, msgs);
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
			case DefinitionPackage.SIMULATION_DEFINITION__IDENTIFIER:
				return getIdentifier();
			case DefinitionPackage.SIMULATION_DEFINITION__NAME:
				return getName();
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				return getInvocations();
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				if (coreType) return getParameters();
				else return getParameters().map();
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO:
				if (resolve) return getActiveScenario();
				return basicGetActiveScenario();
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIOS:
				return getScenarios();
			case DefinitionPackage.SIMULATION_DEFINITION__VARIABLES:
				return getVariables();
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				return getDomainResource();
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
				return getMaxExecutionTime();
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
			case DefinitionPackage.SIMULATION_DEFINITION__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				getInvocations().clear();
				getInvocations().addAll((Collection<? extends SimulationInvocation>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				((EStructuralFeature.Setting)getParameters()).set(newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO:
				setActiveScenario((EObject)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends EObject>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				setDomainResource((Resource)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
				setMaxExecutionTime((Date)newValue);
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
			case DefinitionPackage.SIMULATION_DEFINITION__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				getInvocations().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				getParameters().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO:
				setActiveScenario((EObject)null);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIOS:
				getScenarios().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__VARIABLES:
				getVariables().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				setDomainResource((Resource)null);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
				setMaxExecutionTime(MAX_EXECUTION_TIME_EDEFAULT);
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
			case DefinitionPackage.SIMULATION_DEFINITION__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case DefinitionPackage.SIMULATION_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				return invocations != null && !invocations.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO:
				return activeScenario != null;
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__VARIABLES:
				return variables != null && !variables.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				return domainResource != null;
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
				return MAX_EXECUTION_TIME_EDEFAULT == null ? maxExecutionTime != null : !MAX_EXECUTION_TIME_EDEFAULT.equals(maxExecutionTime);
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
			case DefinitionPackage.SIMULATION_DEFINITION___SYNC_SCENARIOS:
				syncScenarios();
				return null;
			case DefinitionPackage.SIMULATION_DEFINITION___SYNC_VARIABLES:
				syncVariables();
				return null;
			case DefinitionPackage.SIMULATION_DEFINITION___GET_VARIABLE__STRING:
				return getVariable((String)arguments.get(0));
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
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(", name: ");
		result.append(name);
		result.append(", maxExecutionTime: ");
		result.append(maxExecutionTime);
		result.append(')');
		return result.toString();
	}

} //SimulationDefinitionImpl
