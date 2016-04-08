/**
 */
package configuration.impl;

import configuration.ConfigurationPackage;
import configuration.Invocation;
import configuration.Resource;
import configuration.ScenarioInformation;
import configuration.SimulationDefinition;
import configuration.SimulationParameter;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link configuration.impl.SimulationDefinitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link configuration.impl.SimulationDefinitionImpl#getDomainInput <em>Domain Input</em>}</li>
 *   <li>{@link configuration.impl.SimulationDefinitionImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link configuration.impl.SimulationDefinitionImpl#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link configuration.impl.SimulationDefinitionImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulationDefinitionImpl extends MinimalEObjectImpl.Container implements SimulationDefinition {
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
	 * The cached value of the '{@link #getDomainInput() <em>Domain Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainInput()
	 * @generated
	 * @ordered
	 */
	protected Resource domainInput;

	/**
	 * The cached value of the '{@link #getScenario() <em>Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenario()
	 * @generated
	 * @ordered
	 */
	protected ScenarioInformation scenario;

	/**
	 * The cached value of the '{@link #getInvocation() <em>Invocation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocation()
	 * @generated
	 * @ordered
	 */
	protected EList<Invocation> invocation;

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
		return ConfigurationPackage.Literals.SIMULATION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimulationParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<SimulationParameter>(SimulationParameter.class, this, ConfigurationPackage.SIMULATION_DEFINITION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getDomainInput() {
		return domainInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomainInput(Resource newDomainInput, NotificationChain msgs) {
		Resource oldDomainInput = domainInput;
		domainInput = newDomainInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT, oldDomainInput, newDomainInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainInput(Resource newDomainInput) {
		if (newDomainInput != domainInput) {
			NotificationChain msgs = null;
			if (domainInput != null)
				msgs = ((InternalEObject)domainInput).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT, null, msgs);
			if (newDomainInput != null)
				msgs = ((InternalEObject)newDomainInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT, null, msgs);
			msgs = basicSetDomainInput(newDomainInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT, newDomainInput, newDomainInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioInformation getScenario() {
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenario(ScenarioInformation newScenario, NotificationChain msgs) {
		ScenarioInformation oldScenario = scenario;
		scenario = newScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO, oldScenario, newScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenario(ScenarioInformation newScenario) {
		if (newScenario != scenario) {
			NotificationChain msgs = null;
			if (scenario != null)
				msgs = ((InternalEObject)scenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO, null, msgs);
			if (newScenario != null)
				msgs = ((InternalEObject)newScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO, null, msgs);
			msgs = basicSetScenario(newScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO, newScenario, newScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Invocation> getInvocation() {
		if (invocation == null) {
			invocation = new EObjectContainmentWithInverseEList<Invocation>(Invocation.class, this, ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION, ConfigurationPackage.INVOCATION__SIMULATION_DEFINITION);
		}
		return invocation;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SIMULATION_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void buildScenarioInformation() {
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
			case ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInvocation()).basicAdd(otherEnd, msgs);
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
			case ConfigurationPackage.SIMULATION_DEFINITION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT:
				return basicSetDomainInput(null, msgs);
			case ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO:
				return basicSetScenario(null, msgs);
			case ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION:
				return ((InternalEList<?>)getInvocation()).basicRemove(otherEnd, msgs);
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
			case ConfigurationPackage.SIMULATION_DEFINITION__PARAMETERS:
				return getParameters();
			case ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT:
				return getDomainInput();
			case ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO:
				return getScenario();
			case ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION:
				return getInvocation();
			case ConfigurationPackage.SIMULATION_DEFINITION__NAME:
				return getName();
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
			case ConfigurationPackage.SIMULATION_DEFINITION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends SimulationParameter>)newValue);
				return;
			case ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT:
				setDomainInput((Resource)newValue);
				return;
			case ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO:
				setScenario((ScenarioInformation)newValue);
				return;
			case ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION:
				getInvocation().clear();
				getInvocation().addAll((Collection<? extends Invocation>)newValue);
				return;
			case ConfigurationPackage.SIMULATION_DEFINITION__NAME:
				setName((String)newValue);
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
			case ConfigurationPackage.SIMULATION_DEFINITION__PARAMETERS:
				getParameters().clear();
				return;
			case ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT:
				setDomainInput((Resource)null);
				return;
			case ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO:
				setScenario((ScenarioInformation)null);
				return;
			case ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION:
				getInvocation().clear();
				return;
			case ConfigurationPackage.SIMULATION_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
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
			case ConfigurationPackage.SIMULATION_DEFINITION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case ConfigurationPackage.SIMULATION_DEFINITION__DOMAIN_INPUT:
				return domainInput != null;
			case ConfigurationPackage.SIMULATION_DEFINITION__SCENARIO:
				return scenario != null;
			case ConfigurationPackage.SIMULATION_DEFINITION__INVOCATION:
				return invocation != null && !invocation.isEmpty();
			case ConfigurationPackage.SIMULATION_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
			case ConfigurationPackage.SIMULATION_DEFINITION___BUILD_SCENARIO_INFORMATION:
				buildScenarioInformation();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SimulationDefinitionImpl
