/**
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.datatypes.ComputableNFPtype;
import es.unizar.disco.simulation.models.datatypes.Resource;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.Variable;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
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
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getActiveScenario <em>Active Scenario</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getInputVariables <em>Input Variables</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getDomainResource <em>Domain Resource</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getMaxExecutionTime <em>Max Execution Time</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getOutputVariables <em>Output Variables</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getDeclaredMeasures <em>Declared Measures</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getMeasuresToCompute <em>Measures To Compute</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getBackend <em>Backend</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getPossibleConfigurations <em>Possible Configurations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getActiveConfigurations <em>Active Configurations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#isAutoSync <em>Auto Sync</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getScenarioStereotypes <em>Scenario Stereotypes</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl#getNfpToCompute <em>Nfp To Compute</em>}</li>
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
	 * The cached value of the '{@link #getInputVariables() <em>Input Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<InputVariable> inputVariables;

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
	 * The cached value of the '{@link #getOutputVariables() <em>Output Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputVariable> outputVariables;

	/**
	 * The cached value of the '{@link #getDeclaredMeasures() <em>Declared Measures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredMeasures()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainMeasureDefinition> declaredMeasures;

	/**
	 * The cached value of the '{@link #getMeasuresToCompute() <em>Measures To Compute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuresToCompute()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainMeasureDefinition> measuresToCompute;

	/**
	 * The default value of the '{@link #getBackend() <em>Backend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackend()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKEND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackend() <em>Backend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackend()
	 * @generated
	 * @ordered
	 */
	protected String backend = BACKEND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPossibleConfigurations() <em>Possible Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossibleConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableConfiguration> possibleConfigurations;

	/**
	 * The cached value of the '{@link #getActiveConfigurations() <em>Active Configurations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableConfiguration> activeConfigurations;

	/**
	 * The default value of the '{@link #isAutoSync() <em>Auto Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoSync()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_SYNC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoSync() <em>Auto Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoSync()
	 * @generated
	 * @ordered
	 */
	protected boolean autoSync = AUTO_SYNC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScenarioStereotypes() <em>Scenario Stereotypes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarioStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> scenarioStereotypes;

	/**
	 * The default value of the '{@link #getNfpToCompute() <em>Nfp To Compute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNfpToCompute()
	 * @generated
	 * @ordered
	 */
	protected static final ComputableNFPtype NFP_TO_COMPUTE_EDEFAULT = ComputableNFPtype.PERFORMANCE;

	/**
	 * The cached value of the '{@link #getNfpToCompute() <em>Nfp To Compute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNfpToCompute()
	 * @generated
	 * @ordered
	 */
	protected ComputableNFPtype nfpToCompute = NFP_TO_COMPUTE_EDEFAULT;

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
	public EList<InputVariable> getInputVariables() {
		if (inputVariables == null) {
			inputVariables = new EObjectContainmentEList<InputVariable>(InputVariable.class, this, DefinitionPackage.SIMULATION_DEFINITION__INPUT_VARIABLES);
		}
		return inputVariables;
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
	public EList<OutputVariable> getOutputVariables() {
		if (outputVariables == null) {
			outputVariables = new EObjectContainmentEList<OutputVariable>(OutputVariable.class, this, DefinitionPackage.SIMULATION_DEFINITION__OUTPUT_VARIABLES);
		}
		return outputVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainMeasureDefinition> getDeclaredMeasures() {
		if (declaredMeasures == null) {
			declaredMeasures = new EObjectContainmentWithInverseEList<DomainMeasureDefinition>(DomainMeasureDefinition.class, this, DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES, MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION);
		}
		return declaredMeasures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainMeasureDefinition> getMeasuresToCompute() {
		if (measuresToCompute == null) {
			measuresToCompute = new EObjectResolvingEList<DomainMeasureDefinition>(DomainMeasureDefinition.class, this, DefinitionPackage.SIMULATION_DEFINITION__MEASURES_TO_COMPUTE);
		}
		return measuresToCompute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBackend() {
		return backend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackend(String newBackend) {
		String oldBackend = backend;
		backend = newBackend;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__BACKEND, oldBackend, backend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableConfiguration> getPossibleConfigurations() {
		if (possibleConfigurations == null) {
			possibleConfigurations = new EObjectContainmentEList<VariableConfiguration>(VariableConfiguration.class, this, DefinitionPackage.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS);
		}
		return possibleConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableConfiguration> getActiveConfigurations() {
		if (activeConfigurations == null) {
			activeConfigurations = new EObjectResolvingEList<VariableConfiguration>(VariableConfiguration.class, this, DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS);
		}
		return activeConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoSync() {
		return autoSync;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoSync(boolean newAutoSync) {
		boolean oldAutoSync = autoSync;
		autoSync = newAutoSync;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__AUTO_SYNC, oldAutoSync, autoSync));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getScenarioStereotypes() {
		if (scenarioStereotypes == null) {
			scenarioStereotypes = new EDataTypeUniqueEList<String>(String.class, this, DefinitionPackage.SIMULATION_DEFINITION__SCENARIO_STEREOTYPES);
		}
		return scenarioStereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputableNFPtype getNfpToCompute() {
		return nfpToCompute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNfpToCompute(ComputableNFPtype newNfpToCompute) {
		ComputableNFPtype oldNfpToCompute = nfpToCompute;
		nfpToCompute = newNfpToCompute == null ? NFP_TO_COMPUTE_EDEFAULT : newNfpToCompute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefinitionPackage.SIMULATION_DEFINITION__NFP_TO_COMPUTE, oldNfpToCompute, nfpToCompute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<Variable> getVariables() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Variable> getVariablesMap() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, InputVariable> getInputVariablesMap() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, OutputVariable> getOutputVariablesMap() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	public void syncDomainMeasureDefinitions() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void syncPossibleVariableConfigurations() {
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
			case DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeclaredMeasures()).basicAdd(otherEnd, msgs);
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
			case DefinitionPackage.SIMULATION_DEFINITION__INPUT_VARIABLES:
				return ((InternalEList<?>)getInputVariables()).basicRemove(otherEnd, msgs);
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				return basicSetDomainResource(null, msgs);
			case DefinitionPackage.SIMULATION_DEFINITION__OUTPUT_VARIABLES:
				return ((InternalEList<?>)getOutputVariables()).basicRemove(otherEnd, msgs);
			case DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES:
				return ((InternalEList<?>)getDeclaredMeasures()).basicRemove(otherEnd, msgs);
			case DefinitionPackage.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS:
				return ((InternalEList<?>)getPossibleConfigurations()).basicRemove(otherEnd, msgs);
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
			case DefinitionPackage.SIMULATION_DEFINITION__INPUT_VARIABLES:
				return getInputVariables();
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				return getDomainResource();
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
				return getMaxExecutionTime();
			case DefinitionPackage.SIMULATION_DEFINITION__OUTPUT_VARIABLES:
				return getOutputVariables();
			case DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES:
				return getDeclaredMeasures();
			case DefinitionPackage.SIMULATION_DEFINITION__MEASURES_TO_COMPUTE:
				return getMeasuresToCompute();
			case DefinitionPackage.SIMULATION_DEFINITION__BACKEND:
				return getBackend();
			case DefinitionPackage.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS:
				return getPossibleConfigurations();
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS:
				return getActiveConfigurations();
			case DefinitionPackage.SIMULATION_DEFINITION__AUTO_SYNC:
				return isAutoSync();
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO_STEREOTYPES:
				return getScenarioStereotypes();
			case DefinitionPackage.SIMULATION_DEFINITION__NFP_TO_COMPUTE:
				return getNfpToCompute();
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
			case DefinitionPackage.SIMULATION_DEFINITION__INPUT_VARIABLES:
				getInputVariables().clear();
				getInputVariables().addAll((Collection<? extends InputVariable>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				setDomainResource((Resource)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
				setMaxExecutionTime((Date)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__OUTPUT_VARIABLES:
				getOutputVariables().clear();
				getOutputVariables().addAll((Collection<? extends OutputVariable>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES:
				getDeclaredMeasures().clear();
				getDeclaredMeasures().addAll((Collection<? extends DomainMeasureDefinition>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__MEASURES_TO_COMPUTE:
				getMeasuresToCompute().clear();
				getMeasuresToCompute().addAll((Collection<? extends DomainMeasureDefinition>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__BACKEND:
				setBackend((String)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS:
				getPossibleConfigurations().clear();
				getPossibleConfigurations().addAll((Collection<? extends VariableConfiguration>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS:
				getActiveConfigurations().clear();
				getActiveConfigurations().addAll((Collection<? extends VariableConfiguration>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__AUTO_SYNC:
				setAutoSync((Boolean)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO_STEREOTYPES:
				getScenarioStereotypes().clear();
				getScenarioStereotypes().addAll((Collection<? extends String>)newValue);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__NFP_TO_COMPUTE:
				setNfpToCompute((ComputableNFPtype)newValue);
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
			case DefinitionPackage.SIMULATION_DEFINITION__INPUT_VARIABLES:
				getInputVariables().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				setDomainResource((Resource)null);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
				setMaxExecutionTime(MAX_EXECUTION_TIME_EDEFAULT);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__OUTPUT_VARIABLES:
				getOutputVariables().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES:
				getDeclaredMeasures().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__MEASURES_TO_COMPUTE:
				getMeasuresToCompute().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__BACKEND:
				setBackend(BACKEND_EDEFAULT);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS:
				getPossibleConfigurations().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS:
				getActiveConfigurations().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__AUTO_SYNC:
				setAutoSync(AUTO_SYNC_EDEFAULT);
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO_STEREOTYPES:
				getScenarioStereotypes().clear();
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__NFP_TO_COMPUTE:
				setNfpToCompute(NFP_TO_COMPUTE_EDEFAULT);
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
			case DefinitionPackage.SIMULATION_DEFINITION__INVOCATIONS:
				return invocations != null && !invocations.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_SCENARIO:
				return activeScenario != null;
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__INPUT_VARIABLES:
				return inputVariables != null && !inputVariables.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
				return domainResource != null;
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
				return MAX_EXECUTION_TIME_EDEFAULT == null ? maxExecutionTime != null : !MAX_EXECUTION_TIME_EDEFAULT.equals(maxExecutionTime);
			case DefinitionPackage.SIMULATION_DEFINITION__OUTPUT_VARIABLES:
				return outputVariables != null && !outputVariables.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES:
				return declaredMeasures != null && !declaredMeasures.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__MEASURES_TO_COMPUTE:
				return measuresToCompute != null && !measuresToCompute.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__BACKEND:
				return BACKEND_EDEFAULT == null ? backend != null : !BACKEND_EDEFAULT.equals(backend);
			case DefinitionPackage.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS:
				return possibleConfigurations != null && !possibleConfigurations.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS:
				return activeConfigurations != null && !activeConfigurations.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__AUTO_SYNC:
				return autoSync != AUTO_SYNC_EDEFAULT;
			case DefinitionPackage.SIMULATION_DEFINITION__SCENARIO_STEREOTYPES:
				return scenarioStereotypes != null && !scenarioStereotypes.isEmpty();
			case DefinitionPackage.SIMULATION_DEFINITION__NFP_TO_COMPUTE:
				return nfpToCompute != NFP_TO_COMPUTE_EDEFAULT;
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
			case DefinitionPackage.SIMULATION_DEFINITION___GET_VARIABLES:
				return getVariables();
			case DefinitionPackage.SIMULATION_DEFINITION___GET_VARIABLES_MAP:
				return getVariablesMap();
			case DefinitionPackage.SIMULATION_DEFINITION___GET_INPUT_VARIABLES_MAP:
				return getInputVariablesMap();
			case DefinitionPackage.SIMULATION_DEFINITION___GET_OUTPUT_VARIABLES_MAP:
				return getOutputVariablesMap();
			case DefinitionPackage.SIMULATION_DEFINITION___SYNC_SCENARIOS:
				syncScenarios();
				return null;
			case DefinitionPackage.SIMULATION_DEFINITION___SYNC_VARIABLES:
				syncVariables();
				return null;
			case DefinitionPackage.SIMULATION_DEFINITION___SYNC_DOMAIN_MEASURE_DEFINITIONS:
				syncDomainMeasureDefinitions();
				return null;
			case DefinitionPackage.SIMULATION_DEFINITION___SYNC_POSSIBLE_VARIABLE_CONFIGURATIONS:
				syncPossibleVariableConfigurations();
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
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(", maxExecutionTime: ");
		result.append(maxExecutionTime);
		result.append(", backend: ");
		result.append(backend);
		result.append(", autoSync: ");
		result.append(autoSync);
		result.append(", scenarioStereotypes: ");
		result.append(scenarioStereotypes);
		result.append(", nfpToCompute: ");
		result.append(nfpToCompute);
		result.append(')');
		return result.toString();
	}

} //SimulationDefinitionImpl
