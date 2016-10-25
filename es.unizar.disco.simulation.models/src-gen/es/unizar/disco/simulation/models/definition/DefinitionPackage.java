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
	 * The feature id for the '<em><b>Invocations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__INVOCATIONS = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__PARAMETERS = 2;

	/**
	 * The feature id for the '<em><b>Active Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__ACTIVE_SCENARIO = 3;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__SCENARIOS = 4;

	/**
	 * The feature id for the '<em><b>Input Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__INPUT_VARIABLES = 5;

	/**
	 * The feature id for the '<em><b>Domain Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__DOMAIN_RESOURCE = 6;

	/**
	 * The feature id for the '<em><b>Max Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__MAX_EXECUTION_TIME = 7;

	/**
	 * The feature id for the '<em><b>Output Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__OUTPUT_VARIABLES = 8;

	/**
	 * The feature id for the '<em><b>Declared Measures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__DECLARED_MEASURES = 9;

	/**
	 * The feature id for the '<em><b>Measures To Compute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__MEASURES_TO_COMPUTE = 10;

	/**
	 * The feature id for the '<em><b>Backend</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__BACKEND = 11;

	/**
	 * The feature id for the '<em><b>Possible Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS = 12;

	/**
	 * The feature id for the '<em><b>Active Configurations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS = 13;

	/**
	 * The feature id for the '<em><b>Auto Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__AUTO_SYNC = 14;

	/**
	 * The feature id for the '<em><b>Scenario Stereotypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__SCENARIO_STEREOTYPES = 15;

	/**
	 * The number of structural features of the '<em>Simulation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION_FEATURE_COUNT = 16;

	/**
	 * The operation id for the '<em>Get Variables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___GET_VARIABLES = 0;

	/**
	 * The operation id for the '<em>Get Variables Map</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___GET_VARIABLES_MAP = 1;

	/**
	 * The operation id for the '<em>Get Input Variables Map</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___GET_INPUT_VARIABLES_MAP = 2;

	/**
	 * The operation id for the '<em>Get Output Variables Map</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___GET_OUTPUT_VARIABLES_MAP = 3;

	/**
	 * The operation id for the '<em>Sync Scenarios</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___SYNC_SCENARIOS = 4;

	/**
	 * The operation id for the '<em>Sync Variables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___SYNC_VARIABLES = 5;

	/**
	 * The operation id for the '<em>Sync Domain Measure Definitions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___SYNC_DOMAIN_MEASURE_DEFINITIONS = 6;

	/**
	 * The operation id for the '<em>Sync Possible Variable Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___SYNC_POSSIBLE_VARIABLE_CONFIGURATIONS = 7;

	/**
	 * The number of operations of the '<em>Simulation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION_OPERATION_COUNT = 8;

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
	 * The feature id for the '<em><b>Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE__ASSIGNMENTS = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Input Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE__ASSIGNMENTS = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE__VARIABLE = 2;

	/**
	 * The number of structural features of the '<em>Input Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Input Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.VariableAssignmentImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getVariableAssignment()
	 * @generated
	 */
	int VARIABLE_ASSIGNMENT = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VARIABLE = 2;

	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.VariableConfigurationImpl <em>Variable Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.VariableConfigurationImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getVariableConfiguration()
	 * @generated
	 */
	int VARIABLE_CONFIGURATION = 7;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONFIGURATION__ASSIGNMENTS = 0;

	/**
	 * The number of structural features of the '<em>Variable Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Is Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONFIGURATION___IS_EQUIVALENT__VARIABLECONFIGURATION = 0;

	/**
	 * The operation id for the '<em>To Primitive Assignments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONFIGURATION___TO_PRIMITIVE_ASSIGNMENTS = 1;

	/**
	 * The operation id for the '<em>Find Assignment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONFIGURATION___FIND_ASSIGNMENT__INPUTVARIABLE = 2;

	/**
	 * The number of operations of the '<em>Variable Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONFIGURATION_OPERATION_COUNT = 3;


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
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getInputVariables <em>Input Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Variables</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getInputVariables()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_InputVariables();

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
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getOutputVariables <em>Output Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Variables</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getOutputVariables()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_OutputVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDeclaredMeasures <em>Declared Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Measures</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getDeclaredMeasures()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_DeclaredMeasures();

	/**
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getMeasuresToCompute <em>Measures To Compute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Measures To Compute</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getMeasuresToCompute()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_MeasuresToCompute();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getBackend <em>Backend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backend</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getBackend()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EAttribute getSimulationDefinition_Backend();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getPossibleConfigurations <em>Possible Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possible Configurations</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getPossibleConfigurations()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_PossibleConfigurations();

	/**
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveConfigurations <em>Active Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active Configurations</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveConfigurations()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_ActiveConfigurations();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#isAutoSync <em>Auto Sync</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Sync</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#isAutoSync()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EAttribute getSimulationDefinition_AutoSync();

	/**
	 * Returns the meta object for the attribute list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenarioStereotypes <em>Scenario Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Scenario Stereotypes</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenarioStereotypes()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EAttribute getSimulationDefinition_ScenarioStereotypes();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariables() <em>Get Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Variables</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariables()
	 * @generated
	 */
	EOperation getSimulationDefinition__GetVariables();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariablesMap() <em>Get Variables Map</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Variables Map</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getVariablesMap()
	 * @generated
	 */
	EOperation getSimulationDefinition__GetVariablesMap();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getInputVariablesMap() <em>Get Input Variables Map</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Input Variables Map</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getInputVariablesMap()
	 * @generated
	 */
	EOperation getSimulationDefinition__GetInputVariablesMap();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getOutputVariablesMap() <em>Get Output Variables Map</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Output Variables Map</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getOutputVariablesMap()
	 * @generated
	 */
	EOperation getSimulationDefinition__GetOutputVariablesMap();

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
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#syncDomainMeasureDefinitions() <em>Sync Domain Measure Definitions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sync Domain Measure Definitions</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#syncDomainMeasureDefinitions()
	 * @generated
	 */
	EOperation getSimulationDefinition__SyncDomainMeasureDefinitions();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#syncPossibleVariableConfigurations() <em>Sync Possible Variable Configurations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sync Possible Variable Configurations</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#syncPossibleVariableConfigurations()
	 * @generated
	 */
	EOperation getSimulationDefinition__SyncPossibleVariableConfigurations();

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
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.definition.InputVariable#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assignments</em>'.
	 * @see es.unizar.disco.simulation.models.definition.InputVariable#getAssignments()
	 * @see #getInputVariable()
	 * @generated
	 */
	EReference getInputVariable_Assignments();

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
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assignments</em>'.
	 * @see es.unizar.disco.simulation.models.definition.InputVariableValue#getAssignments()
	 * @see #getInputVariableValue()
	 * @generated
	 */
	EReference getInputVariableValue_Assignments();

	/**
	 * Returns the meta object for the container reference '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Variable</em>'.
	 * @see es.unizar.disco.simulation.models.definition.InputVariableValue#getVariable()
	 * @see #getInputVariableValue()
	 * @generated
	 */
	EReference getInputVariableValue_Variable();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see es.unizar.disco.simulation.models.definition.VariableAssignment
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see es.unizar.disco.simulation.models.definition.VariableAssignment#getValue()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Value();

	/**
	 * Returns the meta object for the container reference '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Configuration</em>'.
	 * @see es.unizar.disco.simulation.models.definition.VariableAssignment#getConfiguration()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Configuration();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.definition.VariableAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see es.unizar.disco.simulation.models.definition.VariableAssignment#getVariable()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Variable();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.VariableConfiguration <em>Variable Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Configuration</em>'.
	 * @see es.unizar.disco.simulation.models.definition.VariableConfiguration
	 * @generated
	 */
	EClass getVariableConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.VariableConfiguration#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignments</em>'.
	 * @see es.unizar.disco.simulation.models.definition.VariableConfiguration#getAssignments()
	 * @see #getVariableConfiguration()
	 * @generated
	 */
	EReference getVariableConfiguration_Assignments();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.VariableConfiguration#isEquivalent(es.unizar.disco.simulation.models.definition.VariableConfiguration) <em>Is Equivalent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Equivalent</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.VariableConfiguration#isEquivalent(es.unizar.disco.simulation.models.definition.VariableConfiguration)
	 * @generated
	 */
	EOperation getVariableConfiguration__IsEquivalent__VariableConfiguration();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.VariableConfiguration#toPrimitiveAssignments() <em>To Primitive Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Primitive Assignments</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.VariableConfiguration#toPrimitiveAssignments()
	 * @generated
	 */
	EOperation getVariableConfiguration__ToPrimitiveAssignments();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.definition.VariableConfiguration#findAssignment(es.unizar.disco.simulation.models.definition.InputVariable) <em>Find Assignment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Assignment</em>' operation.
	 * @see es.unizar.disco.simulation.models.definition.VariableConfiguration#findAssignment(es.unizar.disco.simulation.models.definition.InputVariable)
	 * @generated
	 */
	EOperation getVariableConfiguration__FindAssignment__InputVariable();

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
		 * The meta object literal for the '<em><b>Input Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__INPUT_VARIABLES = eINSTANCE.getSimulationDefinition_InputVariables();

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
		 * The meta object literal for the '<em><b>Output Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__OUTPUT_VARIABLES = eINSTANCE.getSimulationDefinition_OutputVariables();

		/**
		 * The meta object literal for the '<em><b>Declared Measures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__DECLARED_MEASURES = eINSTANCE.getSimulationDefinition_DeclaredMeasures();

		/**
		 * The meta object literal for the '<em><b>Measures To Compute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__MEASURES_TO_COMPUTE = eINSTANCE.getSimulationDefinition_MeasuresToCompute();

		/**
		 * The meta object literal for the '<em><b>Backend</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__BACKEND = eINSTANCE.getSimulationDefinition_Backend();

		/**
		 * The meta object literal for the '<em><b>Possible Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS = eINSTANCE.getSimulationDefinition_PossibleConfigurations();

		/**
		 * The meta object literal for the '<em><b>Active Configurations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS = eINSTANCE.getSimulationDefinition_ActiveConfigurations();

		/**
		 * The meta object literal for the '<em><b>Auto Sync</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__AUTO_SYNC = eINSTANCE.getSimulationDefinition_AutoSync();

		/**
		 * The meta object literal for the '<em><b>Scenario Stereotypes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__SCENARIO_STEREOTYPES = eINSTANCE.getSimulationDefinition_ScenarioStereotypes();

		/**
		 * The meta object literal for the '<em><b>Get Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___GET_VARIABLES = eINSTANCE.getSimulationDefinition__GetVariables();

		/**
		 * The meta object literal for the '<em><b>Get Variables Map</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___GET_VARIABLES_MAP = eINSTANCE.getSimulationDefinition__GetVariablesMap();

		/**
		 * The meta object literal for the '<em><b>Get Input Variables Map</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___GET_INPUT_VARIABLES_MAP = eINSTANCE.getSimulationDefinition__GetInputVariablesMap();

		/**
		 * The meta object literal for the '<em><b>Get Output Variables Map</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___GET_OUTPUT_VARIABLES_MAP = eINSTANCE.getSimulationDefinition__GetOutputVariablesMap();

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
		 * The meta object literal for the '<em><b>Sync Domain Measure Definitions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___SYNC_DOMAIN_MEASURE_DEFINITIONS = eINSTANCE.getSimulationDefinition__SyncDomainMeasureDefinitions();

		/**
		 * The meta object literal for the '<em><b>Sync Possible Variable Configurations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___SYNC_POSSIBLE_VARIABLE_CONFIGURATIONS = eINSTANCE.getSimulationDefinition__SyncPossibleVariableConfigurations();

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
		 * The meta object literal for the '<em><b>Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_VARIABLE__ASSIGNMENTS = eINSTANCE.getInputVariable_Assignments();

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

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_VARIABLE_VALUE__ASSIGNMENTS = eINSTANCE.getInputVariableValue_Assignments();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_VARIABLE_VALUE__VARIABLE = eINSTANCE.getInputVariableValue_Variable();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.VariableAssignmentImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__VALUE = eINSTANCE.getVariableAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__CONFIGURATION = eINSTANCE.getVariableAssignment_Configuration();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__VARIABLE = eINSTANCE.getVariableAssignment_Variable();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.VariableConfigurationImpl <em>Variable Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.VariableConfigurationImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getVariableConfiguration()
		 * @generated
		 */
		EClass VARIABLE_CONFIGURATION = eINSTANCE.getVariableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CONFIGURATION__ASSIGNMENTS = eINSTANCE.getVariableConfiguration_Assignments();

		/**
		 * The meta object literal for the '<em><b>Is Equivalent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_CONFIGURATION___IS_EQUIVALENT__VARIABLECONFIGURATION = eINSTANCE.getVariableConfiguration__IsEquivalent__VariableConfiguration();

		/**
		 * The meta object literal for the '<em><b>To Primitive Assignments</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_CONFIGURATION___TO_PRIMITIVE_ASSIGNMENTS = eINSTANCE.getVariableConfiguration__ToPrimitiveAssignments();

		/**
		 * The meta object literal for the '<em><b>Find Assignment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_CONFIGURATION___FIND_ASSIGNMENT__INPUTVARIABLE = eINSTANCE.getVariableConfiguration__FindAssignment__InputVariable();

	}

} //DefinitionPackage
