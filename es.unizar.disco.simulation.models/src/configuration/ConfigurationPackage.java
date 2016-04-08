/**
 */
package configuration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see configuration.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "configuration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/configuration/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "configuration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationPackage eINSTANCE = configuration.impl.ConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link configuration.impl.SimulationDefinitionImpl <em>Simulation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.SimulationDefinitionImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getSimulationDefinition()
	 * @generated
	 */
	int SIMULATION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Domain Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__DOMAIN_INPUT = 1;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__SCENARIO = 2;

	/**
	 * The feature id for the '<em><b>Invocation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__INVOCATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__NAME = 4;

	/**
	 * The number of structural features of the '<em>Simulation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Build Scenario Information</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION___BUILD_SCENARIO_INFORMATION = 0;

	/**
	 * The number of operations of the '<em>Simulation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link configuration.impl.SimulationParameterImpl <em>Simulation Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.SimulationParameterImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getSimulationParameter()
	 * @generated
	 */
	int SIMULATION_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_PARAMETER__VALUES = 1;

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
	 * The meta object id for the '{@link configuration.impl.ScenarioInformationImpl <em>Scenario Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.ScenarioInformationImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getScenarioInformation()
	 * @generated
	 */
	int SCENARIO_INFORMATION = 2;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_INFORMATION__VARIABLES = 0;

	/**
	 * The feature id for the '<em><b>Measures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_INFORMATION__MEASURES = 1;

	/**
	 * The number of structural features of the '<em>Scenario Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_INFORMATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Scenario Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_INFORMATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.ResourceImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__URI = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CONTENTS = 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.VariablesImpl <em>Variables</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.VariablesImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getVariables()
	 * @generated
	 */
	int VARIABLES = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLES__NAME = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLES__VALUES = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLES__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Variables</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLES_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Variables</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.VariableValueImpl <em>Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.VariableValueImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getVariableValue()
	 * @generated
	 */
	int VARIABLE_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.InvocationImpl <em>Invocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.InvocationImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getInvocation()
	 * @generated
	 */
	int INVOCATION = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__TIMESTAMP = 1;

	/**
	 * The feature id for the '<em><b>Variable Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__VARIABLE_ASSIGNMENTS = 2;

	/**
	 * The feature id for the '<em><b>Tool Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__TOOL_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Analizable Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__ANALIZABLE_INPUT = 4;

	/**
	 * The feature id for the '<em><b>Simulation Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__SIMULATION_DEFINITION = 5;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__TRACES = 6;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__CALLS = 7;

	/**
	 * The number of structural features of the '<em>Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_FEATURE_COUNT = 8;

	/**
	 * The operation id for the '<em>Create Analizable Input</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION___CREATE_ANALIZABLE_INPUT = 0;

	/**
	 * The number of operations of the '<em>Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link configuration.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.VariableAssignmentImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getVariableAssignment()
	 * @generated
	 */
	int VARIABLE_ASSIGNMENT = 7;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.ToolResultImpl <em>Tool Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.ToolResultImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getToolResult()
	 * @generated
	 */
	int TOOL_RESULT = 8;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_RESULT__INFOS = 0;

	/**
	 * The number of structural features of the '<em>Tool Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_RESULT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tool Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.DomainMeasureImpl <em>Domain Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.DomainMeasureImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getDomainMeasure()
	 * @generated
	 */
	int DOMAIN_MEASURE = 9;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE__MEASURED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Domain Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Domain Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.AnalyzableElementInfoImpl <em>Analyzable Element Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.AnalyzableElementInfoImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getAnalyzableElementInfo()
	 * @generated
	 */
	int ANALYZABLE_ELEMENT_INFO = 10;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Analyzable Element Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Analyzable Element Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.TraceImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 11;

	/**
	 * The feature id for the '<em><b>From Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__FROM_DOMAIN_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>To Analyzable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TO_ANALYZABLE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__RULE = 2;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.SimulationToolImpl <em>Simulation Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.SimulationToolImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getSimulationTool()
	 * @generated
	 */
	int SIMULATION_TOOL = 12;

	/**
	 * The feature id for the '<em><b>Produces</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_TOOL__PRODUCES = 0;

	/**
	 * The number of structural features of the '<em>Simulation Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_TOOL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Simulation Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_TOOL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link configuration.impl.MeasureConverterImpl <em>Measure Converter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.impl.MeasureConverterImpl
	 * @see configuration.impl.ConfigurationPackageImpl#getMeasureConverter()
	 * @generated
	 */
	int MEASURE_CONVERTER = 13;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER__FROM = 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER__TO = 1;

	/**
	 * The number of structural features of the '<em>Measure Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Convert</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER___CONVERT = 0;

	/**
	 * The number of operations of the '<em>Measure Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link configuration.VariableType <em>Variable Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configuration.VariableType
	 * @see configuration.impl.ConfigurationPackageImpl#getVariableType()
	 * @generated
	 */
	int VARIABLE_TYPE = 14;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see configuration.impl.ConfigurationPackageImpl#getURI()
	 * @generated
	 */
	int URI = 15;


	/**
	 * Returns the meta object for class '{@link configuration.SimulationDefinition <em>Simulation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Definition</em>'.
	 * @see configuration.SimulationDefinition
	 * @generated
	 */
	EClass getSimulationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link configuration.SimulationDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see configuration.SimulationDefinition#getParameters()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link configuration.SimulationDefinition#getDomainInput <em>Domain Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain Input</em>'.
	 * @see configuration.SimulationDefinition#getDomainInput()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_DomainInput();

	/**
	 * Returns the meta object for the containment reference '{@link configuration.SimulationDefinition#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scenario</em>'.
	 * @see configuration.SimulationDefinition#getScenario()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Scenario();

	/**
	 * Returns the meta object for the containment reference list '{@link configuration.SimulationDefinition#getInvocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invocation</em>'.
	 * @see configuration.SimulationDefinition#getInvocation()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Invocation();

	/**
	 * Returns the meta object for the attribute '{@link configuration.SimulationDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configuration.SimulationDefinition#getName()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EAttribute getSimulationDefinition_Name();

	/**
	 * Returns the meta object for the '{@link configuration.SimulationDefinition#buildScenarioInformation() <em>Build Scenario Information</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Scenario Information</em>' operation.
	 * @see configuration.SimulationDefinition#buildScenarioInformation()
	 * @generated
	 */
	EOperation getSimulationDefinition__BuildScenarioInformation();

	/**
	 * Returns the meta object for class '{@link configuration.SimulationParameter <em>Simulation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Parameter</em>'.
	 * @see configuration.SimulationParameter
	 * @generated
	 */
	EClass getSimulationParameter();

	/**
	 * Returns the meta object for the attribute '{@link configuration.SimulationParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configuration.SimulationParameter#getName()
	 * @see #getSimulationParameter()
	 * @generated
	 */
	EAttribute getSimulationParameter_Name();

	/**
	 * Returns the meta object for the attribute list '{@link configuration.SimulationParameter#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see configuration.SimulationParameter#getValues()
	 * @see #getSimulationParameter()
	 * @generated
	 */
	EAttribute getSimulationParameter_Values();

	/**
	 * Returns the meta object for class '{@link configuration.ScenarioInformation <em>Scenario Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario Information</em>'.
	 * @see configuration.ScenarioInformation
	 * @generated
	 */
	EClass getScenarioInformation();

	/**
	 * Returns the meta object for the containment reference list '{@link configuration.ScenarioInformation#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see configuration.ScenarioInformation#getVariables()
	 * @see #getScenarioInformation()
	 * @generated
	 */
	EReference getScenarioInformation_Variables();

	/**
	 * Returns the meta object for the reference list '{@link configuration.ScenarioInformation#getMeasures <em>Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Measures</em>'.
	 * @see configuration.ScenarioInformation#getMeasures()
	 * @see #getScenarioInformation()
	 * @generated
	 */
	EReference getScenarioInformation_Measures();

	/**
	 * Returns the meta object for class '{@link configuration.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see configuration.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link configuration.Resource#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see configuration.Resource#getUri()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Uri();

	/**
	 * Returns the meta object for the reference list '{@link configuration.Resource#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contents</em>'.
	 * @see configuration.Resource#getContents()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Contents();

	/**
	 * Returns the meta object for class '{@link configuration.Variables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variables</em>'.
	 * @see configuration.Variables
	 * @generated
	 */
	EClass getVariables();

	/**
	 * Returns the meta object for the attribute '{@link configuration.Variables#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configuration.Variables#getName()
	 * @see #getVariables()
	 * @generated
	 */
	EAttribute getVariables_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link configuration.Variables#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see configuration.Variables#getValues()
	 * @see #getVariables()
	 * @generated
	 */
	EReference getVariables_Values();

	/**
	 * Returns the meta object for the attribute '{@link configuration.Variables#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see configuration.Variables#getType()
	 * @see #getVariables()
	 * @generated
	 */
	EAttribute getVariables_Type();

	/**
	 * Returns the meta object for class '{@link configuration.VariableValue <em>Variable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Value</em>'.
	 * @see configuration.VariableValue
	 * @generated
	 */
	EClass getVariableValue();

	/**
	 * Returns the meta object for the attribute '{@link configuration.VariableValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configuration.VariableValue#getValue()
	 * @see #getVariableValue()
	 * @generated
	 */
	EAttribute getVariableValue_Value();

	/**
	 * Returns the meta object for class '{@link configuration.Invocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocation</em>'.
	 * @see configuration.Invocation
	 * @generated
	 */
	EClass getInvocation();

	/**
	 * Returns the meta object for the attribute '{@link configuration.Invocation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see configuration.Invocation#getId()
	 * @see #getInvocation()
	 * @generated
	 */
	EAttribute getInvocation_Id();

	/**
	 * Returns the meta object for the attribute '{@link configuration.Invocation#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see configuration.Invocation#getTimestamp()
	 * @see #getInvocation()
	 * @generated
	 */
	EAttribute getInvocation_Timestamp();

	/**
	 * Returns the meta object for the containment reference list '{@link configuration.Invocation#getVariableAssignments <em>Variable Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Assignments</em>'.
	 * @see configuration.Invocation#getVariableAssignments()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_VariableAssignments();

	/**
	 * Returns the meta object for the containment reference '{@link configuration.Invocation#getToolResult <em>Tool Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tool Result</em>'.
	 * @see configuration.Invocation#getToolResult()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_ToolResult();

	/**
	 * Returns the meta object for the containment reference '{@link configuration.Invocation#getAnalizableInput <em>Analizable Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analizable Input</em>'.
	 * @see configuration.Invocation#getAnalizableInput()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_AnalizableInput();

	/**
	 * Returns the meta object for the container reference '{@link configuration.Invocation#getSimulationDefinition <em>Simulation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Simulation Definition</em>'.
	 * @see configuration.Invocation#getSimulationDefinition()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_SimulationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link configuration.Invocation#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traces</em>'.
	 * @see configuration.Invocation#getTraces()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_Traces();

	/**
	 * Returns the meta object for the reference '{@link configuration.Invocation#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Calls</em>'.
	 * @see configuration.Invocation#getCalls()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_Calls();

	/**
	 * Returns the meta object for the '{@link configuration.Invocation#createAnalizableInput() <em>Create Analizable Input</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Analizable Input</em>' operation.
	 * @see configuration.Invocation#createAnalizableInput()
	 * @generated
	 */
	EOperation getInvocation__CreateAnalizableInput();

	/**
	 * Returns the meta object for class '{@link configuration.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see configuration.VariableAssignment
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the reference '{@link configuration.VariableAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see configuration.VariableAssignment#getVariable()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Variable();

	/**
	 * Returns the meta object for the reference '{@link configuration.VariableAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see configuration.VariableAssignment#getValue()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Value();

	/**
	 * Returns the meta object for class '{@link configuration.ToolResult <em>Tool Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Result</em>'.
	 * @see configuration.ToolResult
	 * @generated
	 */
	EClass getToolResult();

	/**
	 * Returns the meta object for the containment reference list '{@link configuration.ToolResult#getInfos <em>Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Infos</em>'.
	 * @see configuration.ToolResult#getInfos()
	 * @see #getToolResult()
	 * @generated
	 */
	EReference getToolResult_Infos();

	/**
	 * Returns the meta object for class '{@link configuration.DomainMeasure <em>Domain Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Measure</em>'.
	 * @see configuration.DomainMeasure
	 * @generated
	 */
	EClass getDomainMeasure();

	/**
	 * Returns the meta object for the reference '{@link configuration.DomainMeasure#getMeasuredElement <em>Measured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Measured Element</em>'.
	 * @see configuration.DomainMeasure#getMeasuredElement()
	 * @see #getDomainMeasure()
	 * @generated
	 */
	EReference getDomainMeasure_MeasuredElement();

	/**
	 * Returns the meta object for the attribute '{@link configuration.DomainMeasure#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configuration.DomainMeasure#getValue()
	 * @see #getDomainMeasure()
	 * @generated
	 */
	EAttribute getDomainMeasure_Value();

	/**
	 * Returns the meta object for class '{@link configuration.AnalyzableElementInfo <em>Analyzable Element Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analyzable Element Info</em>'.
	 * @see configuration.AnalyzableElementInfo
	 * @generated
	 */
	EClass getAnalyzableElementInfo();

	/**
	 * Returns the meta object for the reference '{@link configuration.AnalyzableElementInfo#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see configuration.AnalyzableElementInfo#getElement()
	 * @see #getAnalyzableElementInfo()
	 * @generated
	 */
	EReference getAnalyzableElementInfo_Element();

	/**
	 * Returns the meta object for the attribute '{@link configuration.AnalyzableElementInfo#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configuration.AnalyzableElementInfo#getValue()
	 * @see #getAnalyzableElementInfo()
	 * @generated
	 */
	EAttribute getAnalyzableElementInfo_Value();

	/**
	 * Returns the meta object for class '{@link configuration.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see configuration.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the reference '{@link configuration.Trace#getFromDomainElement <em>From Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Domain Element</em>'.
	 * @see configuration.Trace#getFromDomainElement()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_FromDomainElement();

	/**
	 * Returns the meta object for the reference '{@link configuration.Trace#getToAnalyzableElement <em>To Analyzable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Analyzable Element</em>'.
	 * @see configuration.Trace#getToAnalyzableElement()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_ToAnalyzableElement();

	/**
	 * Returns the meta object for the attribute '{@link configuration.Trace#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see configuration.Trace#getRule()
	 * @see #getTrace()
	 * @generated
	 */
	EAttribute getTrace_Rule();

	/**
	 * Returns the meta object for class '{@link configuration.SimulationTool <em>Simulation Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Tool</em>'.
	 * @see configuration.SimulationTool
	 * @generated
	 */
	EClass getSimulationTool();

	/**
	 * Returns the meta object for the reference '{@link configuration.SimulationTool#getProduces <em>Produces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Produces</em>'.
	 * @see configuration.SimulationTool#getProduces()
	 * @see #getSimulationTool()
	 * @generated
	 */
	EReference getSimulationTool_Produces();

	/**
	 * Returns the meta object for class '{@link configuration.MeasureConverter <em>Measure Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Converter</em>'.
	 * @see configuration.MeasureConverter
	 * @generated
	 */
	EClass getMeasureConverter();

	/**
	 * Returns the meta object for the reference '{@link configuration.MeasureConverter#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see configuration.MeasureConverter#getFrom()
	 * @see #getMeasureConverter()
	 * @generated
	 */
	EReference getMeasureConverter_From();

	/**
	 * Returns the meta object for the reference '{@link configuration.MeasureConverter#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see configuration.MeasureConverter#getTo()
	 * @see #getMeasureConverter()
	 * @generated
	 */
	EReference getMeasureConverter_To();

	/**
	 * Returns the meta object for the '{@link configuration.MeasureConverter#convert() <em>Convert</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Convert</em>' operation.
	 * @see configuration.MeasureConverter#convert()
	 * @generated
	 */
	EOperation getMeasureConverter__Convert();

	/**
	 * Returns the meta object for enum '{@link configuration.VariableType <em>Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Type</em>'.
	 * @see configuration.VariableType
	 * @generated
	 */
	EEnum getVariableType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigurationFactory getConfigurationFactory();

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
		 * The meta object literal for the '{@link configuration.impl.SimulationDefinitionImpl <em>Simulation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.SimulationDefinitionImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getSimulationDefinition()
		 * @generated
		 */
		EClass SIMULATION_DEFINITION = eINSTANCE.getSimulationDefinition();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__PARAMETERS = eINSTANCE.getSimulationDefinition_Parameters();

		/**
		 * The meta object literal for the '<em><b>Domain Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__DOMAIN_INPUT = eINSTANCE.getSimulationDefinition_DomainInput();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__SCENARIO = eINSTANCE.getSimulationDefinition_Scenario();

		/**
		 * The meta object literal for the '<em><b>Invocation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__INVOCATION = eINSTANCE.getSimulationDefinition_Invocation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__NAME = eINSTANCE.getSimulationDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Build Scenario Information</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_DEFINITION___BUILD_SCENARIO_INFORMATION = eINSTANCE.getSimulationDefinition__BuildScenarioInformation();

		/**
		 * The meta object literal for the '{@link configuration.impl.SimulationParameterImpl <em>Simulation Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.SimulationParameterImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getSimulationParameter()
		 * @generated
		 */
		EClass SIMULATION_PARAMETER = eINSTANCE.getSimulationParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_PARAMETER__NAME = eINSTANCE.getSimulationParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_PARAMETER__VALUES = eINSTANCE.getSimulationParameter_Values();

		/**
		 * The meta object literal for the '{@link configuration.impl.ScenarioInformationImpl <em>Scenario Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.ScenarioInformationImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getScenarioInformation()
		 * @generated
		 */
		EClass SCENARIO_INFORMATION = eINSTANCE.getScenarioInformation();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO_INFORMATION__VARIABLES = eINSTANCE.getScenarioInformation_Variables();

		/**
		 * The meta object literal for the '<em><b>Measures</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO_INFORMATION__MEASURES = eINSTANCE.getScenarioInformation_Measures();

		/**
		 * The meta object literal for the '{@link configuration.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.ResourceImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__URI = eINSTANCE.getResource_Uri();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__CONTENTS = eINSTANCE.getResource_Contents();

		/**
		 * The meta object literal for the '{@link configuration.impl.VariablesImpl <em>Variables</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.VariablesImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getVariables()
		 * @generated
		 */
		EClass VARIABLES = eINSTANCE.getVariables();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLES__NAME = eINSTANCE.getVariables_Name();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLES__VALUES = eINSTANCE.getVariables_Values();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLES__TYPE = eINSTANCE.getVariables_Type();

		/**
		 * The meta object literal for the '{@link configuration.impl.VariableValueImpl <em>Variable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.VariableValueImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getVariableValue()
		 * @generated
		 */
		EClass VARIABLE_VALUE = eINSTANCE.getVariableValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_VALUE__VALUE = eINSTANCE.getVariableValue_Value();

		/**
		 * The meta object literal for the '{@link configuration.impl.InvocationImpl <em>Invocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.InvocationImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getInvocation()
		 * @generated
		 */
		EClass INVOCATION = eINSTANCE.getInvocation();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOCATION__ID = eINSTANCE.getInvocation_Id();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOCATION__TIMESTAMP = eINSTANCE.getInvocation_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Variable Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__VARIABLE_ASSIGNMENTS = eINSTANCE.getInvocation_VariableAssignments();

		/**
		 * The meta object literal for the '<em><b>Tool Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__TOOL_RESULT = eINSTANCE.getInvocation_ToolResult();

		/**
		 * The meta object literal for the '<em><b>Analizable Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__ANALIZABLE_INPUT = eINSTANCE.getInvocation_AnalizableInput();

		/**
		 * The meta object literal for the '<em><b>Simulation Definition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__SIMULATION_DEFINITION = eINSTANCE.getInvocation_SimulationDefinition();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__TRACES = eINSTANCE.getInvocation_Traces();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__CALLS = eINSTANCE.getInvocation_Calls();

		/**
		 * The meta object literal for the '<em><b>Create Analizable Input</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INVOCATION___CREATE_ANALIZABLE_INPUT = eINSTANCE.getInvocation__CreateAnalizableInput();

		/**
		 * The meta object literal for the '{@link configuration.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.VariableAssignmentImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__VARIABLE = eINSTANCE.getVariableAssignment_Variable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__VALUE = eINSTANCE.getVariableAssignment_Value();

		/**
		 * The meta object literal for the '{@link configuration.impl.ToolResultImpl <em>Tool Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.ToolResultImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getToolResult()
		 * @generated
		 */
		EClass TOOL_RESULT = eINSTANCE.getToolResult();

		/**
		 * The meta object literal for the '<em><b>Infos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL_RESULT__INFOS = eINSTANCE.getToolResult_Infos();

		/**
		 * The meta object literal for the '{@link configuration.impl.DomainMeasureImpl <em>Domain Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.DomainMeasureImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getDomainMeasure()
		 * @generated
		 */
		EClass DOMAIN_MEASURE = eINSTANCE.getDomainMeasure();

		/**
		 * The meta object literal for the '<em><b>Measured Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_MEASURE__MEASURED_ELEMENT = eINSTANCE.getDomainMeasure_MeasuredElement();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MEASURE__VALUE = eINSTANCE.getDomainMeasure_Value();

		/**
		 * The meta object literal for the '{@link configuration.impl.AnalyzableElementInfoImpl <em>Analyzable Element Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.AnalyzableElementInfoImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getAnalyzableElementInfo()
		 * @generated
		 */
		EClass ANALYZABLE_ELEMENT_INFO = eINSTANCE.getAnalyzableElementInfo();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYZABLE_ELEMENT_INFO__ELEMENT = eINSTANCE.getAnalyzableElementInfo_Element();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYZABLE_ELEMENT_INFO__VALUE = eINSTANCE.getAnalyzableElementInfo_Value();

		/**
		 * The meta object literal for the '{@link configuration.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.TraceImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>From Domain Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__FROM_DOMAIN_ELEMENT = eINSTANCE.getTrace_FromDomainElement();

		/**
		 * The meta object literal for the '<em><b>To Analyzable Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TO_ANALYZABLE_ELEMENT = eINSTANCE.getTrace_ToAnalyzableElement();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE__RULE = eINSTANCE.getTrace_Rule();

		/**
		 * The meta object literal for the '{@link configuration.impl.SimulationToolImpl <em>Simulation Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.SimulationToolImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getSimulationTool()
		 * @generated
		 */
		EClass SIMULATION_TOOL = eINSTANCE.getSimulationTool();

		/**
		 * The meta object literal for the '<em><b>Produces</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_TOOL__PRODUCES = eINSTANCE.getSimulationTool_Produces();

		/**
		 * The meta object literal for the '{@link configuration.impl.MeasureConverterImpl <em>Measure Converter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.impl.MeasureConverterImpl
		 * @see configuration.impl.ConfigurationPackageImpl#getMeasureConverter()
		 * @generated
		 */
		EClass MEASURE_CONVERTER = eINSTANCE.getMeasureConverter();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_CONVERTER__FROM = eINSTANCE.getMeasureConverter_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_CONVERTER__TO = eINSTANCE.getMeasureConverter_To();

		/**
		 * The meta object literal for the '<em><b>Convert</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASURE_CONVERTER___CONVERT = eINSTANCE.getMeasureConverter__Convert();

		/**
		 * The meta object literal for the '{@link configuration.VariableType <em>Variable Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configuration.VariableType
		 * @see configuration.impl.ConfigurationPackageImpl#getVariableType()
		 * @generated
		 */
		EEnum VARIABLE_TYPE = eINSTANCE.getVariableType();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see configuration.impl.ConfigurationPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //ConfigurationPackage
