/**
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 * 
 * SPDX-License-Identifier: EPL-1.0
 * 
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;

import es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl;

import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.Variable;
import es.unizar.disco.simulation.models.definition.VariableAssignment;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;

import es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl;

import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl;

import es.unizar.disco.simulation.models.simresult.SimresultPackage;

import es.unizar.disco.simulation.models.simresult.impl.SimresultPackageImpl;

import es.unizar.disco.simulation.models.toolresult.ToolresultPackage;

import es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl;

import es.unizar.disco.simulation.models.traces.TracesPackage;

import es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl;

import es.unizar.disco.simulation.models.wnsim.WnsimPackage;

import es.unizar.disco.simulation.models.wnsim.impl.WnsimPackageImpl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DefinitionPackageImpl extends EPackageImpl implements DefinitionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulationParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputVariableValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DefinitionPackageImpl() {
		super(eNS_URI, DefinitionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DefinitionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DefinitionPackage init() {
		if (isInited) return (DefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDefinitionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DefinitionPackageImpl theDefinitionPackage = registeredDefinitionPackage instanceof DefinitionPackageImpl ? (DefinitionPackageImpl)registeredDefinitionPackage : new DefinitionPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(registeredPackage instanceof DatatypesPackageImpl ? registeredPackage : DatatypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI);
		InvocationPackageImpl theInvocationPackage = (InvocationPackageImpl)(registeredPackage instanceof InvocationPackageImpl ? registeredPackage : InvocationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI);
		MeasuresPackageImpl theMeasuresPackage = (MeasuresPackageImpl)(registeredPackage instanceof MeasuresPackageImpl ? registeredPackage : MeasuresPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SimresultPackage.eNS_URI);
		SimresultPackageImpl theSimresultPackage = (SimresultPackageImpl)(registeredPackage instanceof SimresultPackageImpl ? registeredPackage : SimresultPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI);
		ToolresultPackageImpl theToolresultPackage = (ToolresultPackageImpl)(registeredPackage instanceof ToolresultPackageImpl ? registeredPackage : ToolresultPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI);
		TracesPackageImpl theTracesPackage = (TracesPackageImpl)(registeredPackage instanceof TracesPackageImpl ? registeredPackage : TracesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI);
		WnsimPackageImpl theWnsimPackage = (WnsimPackageImpl)(registeredPackage instanceof WnsimPackageImpl ? registeredPackage : WnsimPackage.eINSTANCE);

		// Create package meta-data objects
		theDefinitionPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theInvocationPackage.createPackageContents();
		theMeasuresPackage.createPackageContents();
		theSimresultPackage.createPackageContents();
		theToolresultPackage.createPackageContents();
		theTracesPackage.createPackageContents();
		theWnsimPackage.createPackageContents();

		// Initialize created meta-data
		theDefinitionPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theInvocationPackage.initializePackageContents();
		theMeasuresPackage.initializePackageContents();
		theSimresultPackage.initializePackageContents();
		theToolresultPackage.initializePackageContents();
		theTracesPackage.initializePackageContents();
		theWnsimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDefinitionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DefinitionPackage.eNS_URI, theDefinitionPackage);
		return theDefinitionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimulationDefinition() {
		return simulationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulationDefinition_Identifier() {
		return (EAttribute)simulationDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_Invocations() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_Parameters() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_ActiveScenario() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_Scenarios() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_InputVariables() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_DomainResource() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulationDefinition_MaxExecutionTime() {
		return (EAttribute)simulationDefinitionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_OutputVariables() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_DeclaredMeasures() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_MeasuresToCompute() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulationDefinition_Backend() {
		return (EAttribute)simulationDefinitionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_PossibleConfigurations() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulationDefinition_ActiveConfigurations() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulationDefinition_AutoSync() {
		return (EAttribute)simulationDefinitionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulationDefinition_ScenarioStereotypes() {
		return (EAttribute)simulationDefinitionEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulationDefinition_NfpToCompute() {
		return (EAttribute)simulationDefinitionEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSimulationDefinition__GetVariables() {
		return simulationDefinitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSimulationDefinition__GetVariablesMap() {
		return simulationDefinitionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSimulationDefinition__GetInputVariablesMap() {
		return simulationDefinitionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSimulationDefinition__GetOutputVariablesMap() {
		return simulationDefinitionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSimulationDefinition__SyncScenarios() {
		return simulationDefinitionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSimulationDefinition__SyncVariables() {
		return simulationDefinitionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSimulationDefinition__SyncDomainMeasureDefinitions() {
		return simulationDefinitionEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSimulationDefinition__SyncPossibleVariableConfigurations() {
		return simulationDefinitionEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimulationParameter() {
		return simulationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulationParameter_Key() {
		return (EAttribute)simulationParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulationParameter_Value() {
		return (EAttribute)simulationParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariable_Name() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInputVariable() {
		return inputVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInputVariable_Values() {
		return (EReference)inputVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInputVariable_Assignments() {
		return (EReference)inputVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInputVariable__DeserializeValues__String() {
		return inputVariableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInputVariable__SerializeValues() {
		return inputVariableEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOutputVariable() {
		return outputVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInputVariableValue() {
		return inputVariableValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInputVariableValue_Value() {
		return (EAttribute)inputVariableValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInputVariableValue_Assignments() {
		return (EReference)inputVariableValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInputVariableValue_Variable() {
		return (EReference)inputVariableValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableAssignment() {
		return variableAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableAssignment_Value() {
		return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableAssignment_Configuration() {
		return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableAssignment_Variable() {
		return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableConfiguration() {
		return variableConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableConfiguration_Assignments() {
		return (EReference)variableConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getVariableConfiguration__IsEquivalent__VariableConfiguration() {
		return variableConfigurationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getVariableConfiguration__ToPrimitiveAssignments() {
		return variableConfigurationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getVariableConfiguration__FindAssignment__InputVariable() {
		return variableConfigurationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefinitionFactory getDefinitionFactory() {
		return (DefinitionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		simulationDefinitionEClass = createEClass(SIMULATION_DEFINITION);
		createEAttribute(simulationDefinitionEClass, SIMULATION_DEFINITION__IDENTIFIER);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__INVOCATIONS);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__PARAMETERS);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__ACTIVE_SCENARIO);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__SCENARIOS);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__INPUT_VARIABLES);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__DOMAIN_RESOURCE);
		createEAttribute(simulationDefinitionEClass, SIMULATION_DEFINITION__MAX_EXECUTION_TIME);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__OUTPUT_VARIABLES);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__DECLARED_MEASURES);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__MEASURES_TO_COMPUTE);
		createEAttribute(simulationDefinitionEClass, SIMULATION_DEFINITION__BACKEND);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS);
		createEAttribute(simulationDefinitionEClass, SIMULATION_DEFINITION__AUTO_SYNC);
		createEAttribute(simulationDefinitionEClass, SIMULATION_DEFINITION__SCENARIO_STEREOTYPES);
		createEAttribute(simulationDefinitionEClass, SIMULATION_DEFINITION__NFP_TO_COMPUTE);
		createEOperation(simulationDefinitionEClass, SIMULATION_DEFINITION___GET_VARIABLES);
		createEOperation(simulationDefinitionEClass, SIMULATION_DEFINITION___GET_VARIABLES_MAP);
		createEOperation(simulationDefinitionEClass, SIMULATION_DEFINITION___GET_INPUT_VARIABLES_MAP);
		createEOperation(simulationDefinitionEClass, SIMULATION_DEFINITION___GET_OUTPUT_VARIABLES_MAP);
		createEOperation(simulationDefinitionEClass, SIMULATION_DEFINITION___SYNC_SCENARIOS);
		createEOperation(simulationDefinitionEClass, SIMULATION_DEFINITION___SYNC_VARIABLES);
		createEOperation(simulationDefinitionEClass, SIMULATION_DEFINITION___SYNC_DOMAIN_MEASURE_DEFINITIONS);
		createEOperation(simulationDefinitionEClass, SIMULATION_DEFINITION___SYNC_POSSIBLE_VARIABLE_CONFIGURATIONS);

		simulationParameterEClass = createEClass(SIMULATION_PARAMETER);
		createEAttribute(simulationParameterEClass, SIMULATION_PARAMETER__KEY);
		createEAttribute(simulationParameterEClass, SIMULATION_PARAMETER__VALUE);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);

		inputVariableEClass = createEClass(INPUT_VARIABLE);
		createEReference(inputVariableEClass, INPUT_VARIABLE__VALUES);
		createEReference(inputVariableEClass, INPUT_VARIABLE__ASSIGNMENTS);
		createEOperation(inputVariableEClass, INPUT_VARIABLE___DESERIALIZE_VALUES__STRING);
		createEOperation(inputVariableEClass, INPUT_VARIABLE___SERIALIZE_VALUES);

		outputVariableEClass = createEClass(OUTPUT_VARIABLE);

		inputVariableValueEClass = createEClass(INPUT_VARIABLE_VALUE);
		createEAttribute(inputVariableValueEClass, INPUT_VARIABLE_VALUE__VALUE);
		createEReference(inputVariableValueEClass, INPUT_VARIABLE_VALUE__ASSIGNMENTS);
		createEReference(inputVariableValueEClass, INPUT_VARIABLE_VALUE__VARIABLE);

		variableAssignmentEClass = createEClass(VARIABLE_ASSIGNMENT);
		createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__VALUE);
		createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__CONFIGURATION);
		createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__VARIABLE);

		variableConfigurationEClass = createEClass(VARIABLE_CONFIGURATION);
		createEReference(variableConfigurationEClass, VARIABLE_CONFIGURATION__ASSIGNMENTS);
		createEOperation(variableConfigurationEClass, VARIABLE_CONFIGURATION___IS_EQUIVALENT__VARIABLECONFIGURATION);
		createEOperation(variableConfigurationEClass, VARIABLE_CONFIGURATION___TO_PRIMITIVE_ASSIGNMENTS);
		createEOperation(variableConfigurationEClass, VARIABLE_CONFIGURATION___FIND_ASSIGNMENT__INPUTVARIABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		InvocationPackage theInvocationPackage = (InvocationPackage)EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI);
		DatatypesPackage theDatatypesPackage = (DatatypesPackage)EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
		MeasuresPackage theMeasuresPackage = (MeasuresPackage)EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inputVariableEClass.getESuperTypes().add(this.getVariable());
		outputVariableEClass.getESuperTypes().add(this.getVariable());

		// Initialize classes, features, and operations; add parameters
		initEClass(simulationDefinitionEClass, SimulationDefinition.class, "SimulationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimulationDefinition_Identifier(), ecorePackage.getEString(), "identifier", null, 1, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_Invocations(), theInvocationPackage.getSimulationInvocation(), theInvocationPackage.getSimulationInvocation_Definition(), "invocations", null, 0, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_Parameters(), this.getSimulationParameter(), null, "parameters", null, 0, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_ActiveScenario(), ecorePackage.getEObject(), null, "activeScenario", null, 1, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_Scenarios(), ecorePackage.getEObject(), null, "scenarios", null, 1, -1, SimulationDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_InputVariables(), this.getInputVariable(), null, "inputVariables", null, 0, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSimulationDefinition_DomainResource(), theDatatypesPackage.getResource(), null, "domainResource", null, 1, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationDefinition_MaxExecutionTime(), ecorePackage.getEDate(), "maxExecutionTime", "0000-00-00\'01:00:00", 1, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_OutputVariables(), this.getOutputVariable(), null, "outputVariables", null, 0, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSimulationDefinition_DeclaredMeasures(), theMeasuresPackage.getDomainMeasureDefinition(), theMeasuresPackage.getDomainMeasureDefinition_SimulationDefinition(), "declaredMeasures", null, 1, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_MeasuresToCompute(), theMeasuresPackage.getDomainMeasureDefinition(), null, "measuresToCompute", null, 1, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationDefinition_Backend(), ecorePackage.getEString(), "backend", null, 1, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_PossibleConfigurations(), this.getVariableConfiguration(), null, "possibleConfigurations", null, 0, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_ActiveConfigurations(), this.getVariableConfiguration(), null, "activeConfigurations", null, 0, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationDefinition_AutoSync(), ecorePackage.getEBoolean(), "autoSync", "false", 1, 1, SimulationDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationDefinition_ScenarioStereotypes(), ecorePackage.getEString(), "scenarioStereotypes", null, 1, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationDefinition_NfpToCompute(), theDatatypesPackage.getComputableNFPtype(), "nfpToCompute", null, 0, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getSimulationDefinition__GetVariables(), null, "getVariables", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(theDatatypesPackage.getCollection());
		EGenericType g2 = createEGenericType(this.getVariable());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getSimulationDefinition__GetVariablesMap(), null, "getVariablesMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getVariable());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getSimulationDefinition__GetInputVariablesMap(), null, "getInputVariablesMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getInputVariable());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getSimulationDefinition__GetOutputVariablesMap(), null, "getOutputVariablesMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getOutputVariable());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEOperation(getSimulationDefinition__SyncScenarios(), null, "syncScenarios", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSimulationDefinition__SyncVariables(), null, "syncVariables", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSimulationDefinition__SyncDomainMeasureDefinitions(), null, "syncDomainMeasureDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSimulationDefinition__SyncPossibleVariableConfigurations(), null, "syncPossibleVariableConfigurations", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(simulationParameterEClass, Map.Entry.class, "SimulationParameter", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimulationParameter_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationParameter_Value(), ecorePackage.getEString(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputVariableEClass, InputVariable.class, "InputVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputVariable_Values(), this.getInputVariableValue(), this.getInputVariableValue_Variable(), "values", null, 1, -1, InputVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputVariable_Assignments(), this.getVariableAssignment(), this.getVariableAssignment_Variable(), "assignments", null, 1, -1, InputVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getInputVariable__DeserializeValues__String(), null, "deserializeValues", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "values", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getInputVariable__SerializeValues(), ecorePackage.getEString(), "serializeValues", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(outputVariableEClass, OutputVariable.class, "OutputVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputVariableValueEClass, InputVariableValue.class, "InputVariableValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputVariableValue_Value(), theDatatypesPackage.getNumber(), "value", null, 1, 1, InputVariableValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputVariableValue_Assignments(), this.getVariableAssignment(), this.getVariableAssignment_Value(), "assignments", null, 1, -1, InputVariableValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputVariableValue_Variable(), this.getInputVariable(), this.getInputVariable_Values(), "variable", null, 1, 1, InputVariableValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableAssignmentEClass, VariableAssignment.class, "VariableAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableAssignment_Value(), this.getInputVariableValue(), this.getInputVariableValue_Assignments(), "value", null, 1, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableAssignment_Configuration(), this.getVariableConfiguration(), this.getVariableConfiguration_Assignments(), "configuration", null, 1, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableAssignment_Variable(), this.getInputVariable(), this.getInputVariable_Assignments(), "variable", null, 1, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableConfigurationEClass, VariableConfiguration.class, "VariableConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableConfiguration_Assignments(), this.getVariableAssignment(), this.getVariableAssignment_Configuration(), "assignments", null, 1, -1, VariableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVariableConfiguration__IsEquivalent__VariableConfiguration(), ecorePackage.getEBoolean(), "isEquivalent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableConfiguration(), "config", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getVariableConfiguration__ToPrimitiveAssignments(), theDatatypesPackage.getPrimitiveVariableAssignment(), "toPrimitiveAssignments", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getVariableConfiguration__FindAssignment__InputVariable(), this.getVariableAssignment(), "findAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInputVariable(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DefinitionPackageImpl
