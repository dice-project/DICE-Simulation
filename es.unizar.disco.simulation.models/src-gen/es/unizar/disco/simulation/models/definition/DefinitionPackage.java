/**
 */
package es.unizar.disco.simulation.models.definition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see es.unizar.disco.simulation.models.definition.DefinitionFactory
 * @model kind="package"
 * @generated
 */
public interface DefinitionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "definition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/definition/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "definition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DefinitionPackage eINSTANCE = es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl <em>Simulation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getSimulationDefinition()
	 * @generated
	 */
	int SIMULATION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Invocations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__INVOCATIONS = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__PARAMETERS = 3;

	/**
	 * The feature id for the '<em><b>Active Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__ACTIVE_SCENARIO = 4;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__SCENARIOS = 5;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__VARIABLES = 6;

	/**
	 * The feature id for the '<em><b>Domain Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__DOMAIN_RESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Max Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__MAX_EXECUTION_TIME = 8;

	/**
	 * The number of structural features of the '<em>Simulation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION_FEATURE_COUNT = 9;

	/**
	 * The operation id for the '<em>Sync Scenarios</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___SYNC_SCENARIOS = 0;

	/**
	 * The operation id for the '<em>Sync Variables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___SYNC_VARIABLES = 1;

	/**
	 * The operation id for the '<em>Get Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___GET_VARIABLE__STRING = 2;

	/**
	 * The number of operations of the '<em>Simulation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.SimulationParameterImpl <em>Simulation Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.SimulationParameterImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getSimulationParameter()
	 * @generated
	 */
	int SIMULATION_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_PARAMETER__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_PARAMETER__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Simulation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Simulation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.VariableImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.InputVariableImpl <em>Input Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.InputVariableImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getInputVariable()
	 * @generated
	 */
	int INPUT_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE__VALUES = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Deserialize Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE___DESERIALIZE_VALUES__STRING = VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Serialize Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE___SERIALIZE_VALUES = VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Input Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl <em>Output Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getOutputVariable()
	 * @generated
	 */
	int OUTPUT_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The number of structural features of the '<em>Output Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Output Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.InputVariableValueImpl <em>Input Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.InputVariableValueImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getInputVariableValue()
	 * @generated
	 */
	int INPUT_VARIABLE_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Input Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Input Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition <em>Simulation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Definition</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition
	 * @generated
	 */
	EClass getSimulationDefinition();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getIdentifier()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EAttribute getSimulationDefinition_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getName()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EAttribute getSimulationDefinition_Name();

	/**
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invocations</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getInvocations()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Invocations();

	/**
	 * Returns the meta object for the map '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Parameters</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getParameters()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Parameters();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveScenario <em>Active Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Active Scenario</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveScenario()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_ActiveScenario();

	/**
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scenarios</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenarios()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Scenarios();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariables()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Variables();

	/**
	 * Returns the meta object for the containment reference '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource <em>Domain Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain Resource</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_DomainResource();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getMaxExecutionTime <em>Max Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Execution Time</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getMaxExecutionTime()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EAttribute getSimulationDefinition_MaxExecutionTime();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#syncScenarios() <em>Sync Scenarios</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sync Scenarios</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#syncScenarios()
	 * @generated
	 */
	EOperation getSimulationDefinition__SyncScenarios();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#syncVariables() <em>Sync Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sync Variables</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#syncVariables()
	 * @generated
	 */
	EOperation getSimulationDefinition__SyncVariables();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariable(java.lang.String) <em>Get Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Variable</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariable(java.lang.String)
	 * @generated
	 */
	EOperation getSimulationDefinition__GetVariable__String();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Simulation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Parameter</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EString" valueRequired="true"
	 * @generated
	 */
	EClass getSimulationParameter();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getSimulationParameter()
	 * @generated
	 */
	EAttribute getSimulationParameter_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getSimulationParameter()
	 * @generated
	 */
	EAttribute getSimulationParameter_Value();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see es.unizar.disco.simulation.models.definition.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see es.unizar.disco.simulation.models.definition.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.InputVariable <em>Input Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Variable</em>'.
	 * @see es.unizar.disco.simulation.models.definition.InputVariable
	 * @generated
	 */
	EClass getInputVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.InputVariable#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see es.unizar.disco.simulation.models.definition.InputVariable#getValues()
	 * @see #getInputVariable()
	 * @generated
	 */
	EReference getInputVariable_Values();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.InputVariable#deserializeValues(java.lang.String) <em>Deserialize Values</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Deserialize Values</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.InputVariable#deserializeValues(java.lang.String)
	 * @generated
	 */
	EOperation getInputVariable__DeserializeValues__String();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.InputVariable#serializeValues() <em>Serialize Values</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Serialize Values</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.InputVariable#serializeValues()
	 * @generated
	 */
	EOperation getInputVariable__SerializeValues();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.OutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Variable</em>'.
	 * @see es.unizar.disco.simulation.models.definition.OutputVariable
	 * @generated
	 */
	EClass getOutputVariable();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.InputVariableValue <em>Input Variable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Variable Value</em>'.
	 * @see es.unizar.disco.simulation.models.definition.InputVariableValue
	 * @generated
	 */
	EClass getInputVariableValue();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see es.unizar.disco.simulation.models.definition.InputVariableValue#getValue()
	 * @see #getInputVariableValue()
	 * @generated
	 */
	EAttribute getInputVariableValue_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DefinitionFactory getDefinitionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl <em>Simulation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.SimulationDefinitionImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getSimulationDefinition()
		 * @generated
		 */
		EClass SIMULATION_DEFINITION = eINSTANCE.getSimulationDefinition();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__IDENTIFIER = eINSTANCE.getSimulationDefinition_Identifier();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__NAME = eINSTANCE.getSimulationDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Invocations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__INVOCATIONS = eINSTANCE.getSimulationDefinition_Invocations();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__PARAMETERS = eINSTANCE.getSimulationDefinition_Parameters();

		/**
		 * The meta object literal for the '<em><b>Active Scenario</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__ACTIVE_SCENARIO = eINSTANCE.getSimulationDefinition_ActiveScenario();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__SCENARIOS = eINSTANCE.getSimulationDefinition_Scenarios();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__VARIABLES = eINSTANCE.getSimulationDefinition_Variables();

		/**
		 * The meta object literal for the '<em><b>Domain Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__DOMAIN_RESOURCE = eINSTANCE.getSimulationDefinition_DomainResource();

		/**
		 * The meta object literal for the '<em><b>Max Execution Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__MAX_EXECUTION_TIME = eINSTANCE.getSimulationDefinition_MaxExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Sync Scenarios</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___SYNC_SCENARIOS = eINSTANCE.getSimulationDefinition__SyncScenarios();

		/**
		 * The meta object literal for the '<em><b>Sync Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___SYNC_VARIABLES = eINSTANCE.getSimulationDefinition__SyncVariables();

		/**
		 * The meta object literal for the '<em><b>Get Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___GET_VARIABLE__STRING = eINSTANCE.getSimulationDefinition__GetVariable__String();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.SimulationParameterImpl <em>Simulation Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.SimulationParameterImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getSimulationParameter()
		 * @generated
		 */
		EClass SIMULATION_PARAMETER = eINSTANCE.getSimulationParameter();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_PARAMETER__KEY = eINSTANCE.getSimulationParameter_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_PARAMETER__VALUE = eINSTANCE.getSimulationParameter_Value();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.VariableImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.InputVariableImpl <em>Input Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.InputVariableImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getInputVariable()
		 * @generated
		 */
		EClass INPUT_VARIABLE = eINSTANCE.getInputVariable();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_VARIABLE__VALUES = eINSTANCE.getInputVariable_Values();

		/**
		 * The meta object literal for the '<em><b>Deserialize Values</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INPUT_VARIABLE___DESERIALIZE_VALUES__STRING = eINSTANCE.getInputVariable__DeserializeValues__String();

		/**
		 * The meta object literal for the '<em><b>Serialize Values</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INPUT_VARIABLE___SERIALIZE_VALUES = eINSTANCE.getInputVariable__SerializeValues();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl <em>Output Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getOutputVariable()
		 * @generated
		 */
		EClass OUTPUT_VARIABLE = eINSTANCE.getOutputVariable();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.InputVariableValueImpl <em>Input Variable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.InputVariableValueImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getInputVariableValue()
		 * @generated
		 */
		EClass INPUT_VARIABLE_VALUE = eINSTANCE.getInputVariableValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_VARIABLE_VALUE__VALUE = eINSTANCE.getInputVariableValue_Value();

	}

} //DefinitionPackage
