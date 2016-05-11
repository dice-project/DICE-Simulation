/**
 */
package es.unizar.disco.simulation.models.definition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Domain Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__DOMAIN_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Invocations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__INVOCATIONS = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__PARAMETERS = 3;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION__SCENARIO = 4;

	/**
	 * The number of structural features of the '<em>Simulation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Simulation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DEFINITION_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_PARAMETER__NAME = 0;

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
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.ScenarioImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 2;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__VARIABLES = 0;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.VariableImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 3;

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
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.InputVariableValueImpl <em>Input Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.InputVariableValueImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getInputVariableValue()
	 * @generated
	 */
	int INPUT_VARIABLE_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE__UNIT = 1;

	/**
	 * The number of structural features of the '<em>Input Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Input Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.InputVariableImpl <em>Input Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.InputVariableImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getInputVariable()
	 * @generated
	 */
	int INPUT_VARIABLE = 5;

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
	 * The number of operations of the '<em>Input Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl <em>Output Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl
	 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getOutputVariable()
	 * @generated
	 */
	int OUTPUT_VARIABLE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE__VALUE = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE__MEASURED_ELEMENT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE__UNIT = VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Output Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Output Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource <em>Domain Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Resource</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EAttribute getSimulationDefinition_DomainResource();

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
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getParameters()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scenario</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenario()
	 * @see #getSimulationDefinition()
	 * @generated
	 */
	EReference getSimulationDefinition_Scenario();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.SimulationParameter <em>Simulation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Parameter</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationParameter
	 * @generated
	 */
	EClass getSimulationParameter();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.SimulationParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationParameter#getName()
	 * @see #getSimulationParameter()
	 * @generated
	 */
	EAttribute getSimulationParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.SimulationParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see es.unizar.disco.simulation.models.definition.SimulationParameter#getValue()
	 * @see #getSimulationParameter()
	 * @generated
	 */
	EAttribute getSimulationParameter_Value();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see es.unizar.disco.simulation.models.definition.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.definition.Scenario#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see es.unizar.disco.simulation.models.definition.Scenario#getVariables()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Variables();

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
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see es.unizar.disco.simulation.models.definition.InputVariableValue#getUnit()
	 * @see #getInputVariableValue()
	 * @generated
	 */
	EAttribute getInputVariableValue_Unit();

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
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.definition.OutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Variable</em>'.
	 * @see es.unizar.disco.simulation.models.definition.OutputVariable
	 * @generated
	 */
	EClass getOutputVariable();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__NAME = eINSTANCE.getSimulationDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Domain Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_DEFINITION__DOMAIN_RESOURCE = eINSTANCE.getSimulationDefinition_DomainResource();

		/**
		 * The meta object literal for the '<em><b>Invocations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__INVOCATIONS = eINSTANCE.getSimulationDefinition_Invocations();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__PARAMETERS = eINSTANCE.getSimulationDefinition_Parameters();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DEFINITION__SCENARIO = eINSTANCE.getSimulationDefinition_Scenario();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_PARAMETER__NAME = eINSTANCE.getSimulationParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_PARAMETER__VALUE = eINSTANCE.getSimulationParameter_Value();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.ScenarioImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__VARIABLES = eINSTANCE.getScenario_Variables();

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
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_VARIABLE_VALUE__UNIT = eINSTANCE.getInputVariableValue_Unit();

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
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl <em>Output Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.definition.impl.OutputVariableImpl
		 * @see es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl#getOutputVariable()
		 * @generated
		 */
		EClass OUTPUT_VARIABLE = eINSTANCE.getOutputVariable();

	}

} //DefinitionPackage
