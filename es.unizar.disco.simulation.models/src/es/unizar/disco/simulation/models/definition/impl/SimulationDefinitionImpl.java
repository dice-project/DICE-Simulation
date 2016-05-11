/**
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.Scenario;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.SimulationParameter;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

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
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getScenario <em>Scenario</em>}</li>
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
	 * The cached value of the '{@link #getScenario() <em>Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenario()
	 * @generated
	 * @ordered
	 */
	protected Scenario scenario;

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
	public Scenario getScenario() {
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenario(Scenario newScenario, NotificationChain msgs) {
		Scenario oldScenario = scenario;
		scenario = newScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__SCENARIO, oldScenario, newScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenario(Scenario newScenario) {
		if (newScenario != scenario) {
			NotificationChain msgs = null;
			if (scenario != null)
				msgs = ((InternalEObject)scenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DefinitionPackage.SIMULATION_DEFINITION__SCENARIO, null, msgs);
			if (newScenario != null)
				msgs = ((InternalEObject)newScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DefinitionPackage.SIMULATION_DEFINITION__SCENARIO, null, msgs);
			msgs = basicSetScenario(newScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__SCENARIO, newScenario, newScenario));
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
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO:
				return basicSetScenario(null, msgs);
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
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO:
				return getScenario();
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
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO:
				setScenario((Scenario)newValue);
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
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO:
				setScenario((Scenario)null);
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
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO:
				return scenario != null;
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
