/**
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.SimulationParameter;
import es.unizar.disco.simulation.models.definition.Variable;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getDomainResource <em>Domain Resource</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getActiveScenario <em>Active Scenario</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulationDefinitionImpl extends MinimalEObjectImpl.Container implements SimulationDefinition {
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
	 * The default value of the '{@link #getDomainResource() <em>Domain Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainResource()
	 * @generated
	 * @ordered
	 */
	protected static final URI DOMAIN_RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomainResource() <em>Domain Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainResource()
	 * @generated
	 * @ordered
	 */
	protected URI domainResource = DOMAIN_RESOURCE_EDEFAULT;

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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<SimulationParameter> parameters;

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
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

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
	public URI getDomainResource() {
		return domainResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainResource(URI newDomainResource) {
		URI oldDomainResource = domainResource;
		domainResource = newDomainResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE, oldDomainResource, domainResource));
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
	public EList<SimulationParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<SimulationParameter>(SimulationParameter.class, this, DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS);
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
		// TODO: implement this method to return the 'Scenarios' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
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
			case DefinitionPackage.SIMULATION_DEFINITION__NAME:
				return getName();
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				return getDomainResource();
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				return getInvocations();
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				return getParameters();
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO:
				if (resolve) return getActiveScenario();
				return basicGetActiveScenario();
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIOS:
				return getScenarios();
			case DefinitionPackage.SIMULATION_DEFINITION__VARIABLES:
				return getVariables();
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
			case DefinitionPackage.SIMULATION_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				setDomainResource((URI)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				getInvocations().clear();
				getInvocations().addAll((Collection<? extends SimulationInvocation>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends SimulationParameter>)newValue);
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
			case DefinitionPackage.SIMULATION_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				setDomainResource(DOMAIN_RESOURCE_EDEFAULT);
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
			case DefinitionPackage.SIMULATION_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				return DOMAIN_RESOURCE_EDEFAULT == null ? domainResource != null : !DOMAIN_RESOURCE_EDEFAULT.equals(domainResource);
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				return invocations != null && !invocations.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO:
				return activeScenario != null;
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIOS:
				return !getScenarios().isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__VARIABLES:
				return variables != null && !variables.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", domainResource: ");
		result.append(domainResource);
		result.append(')');
		return result.toString();
	}

} //SimulationDefinitionImpl
