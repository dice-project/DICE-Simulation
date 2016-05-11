/**
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;

import es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl;

import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.Scenario;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.SimulationParameter;
import es.unizar.disco.simulation.models.definition.Variable;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;

import es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl;

import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl;

import es.unizar.disco.simulation.models.toolresult.ToolresultPackage;

import es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl;

import es.unizar.disco.simulation.models.traces.TracesPackage;

import es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl;

import es.unizar.disco.simulation.models.wnsim.WnsimPackage;

import es.unizar.disco.simulation.models.wnsim.impl.WnsimPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	private EClass scenarioEClass = null;

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
	private EClass inputVariableValueEClass = null;

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
		DefinitionPackageImpl theDefinitionPackage = (DefinitionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DefinitionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DefinitionPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) instanceof DatatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) : DatatypesPackage.eINSTANCE);
		InvocationPackageImpl theInvocationPackage = (InvocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) instanceof InvocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) : InvocationPackage.eINSTANCE);
		MeasuresPackageImpl theMeasuresPackage = (MeasuresPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) instanceof MeasuresPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) : MeasuresPackage.eINSTANCE);
		ToolresultPackageImpl theToolresultPackage = (ToolresultPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI) instanceof ToolresultPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI) : ToolresultPackage.eINSTANCE);
		TracesPackageImpl theTracesPackage = (TracesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI) instanceof TracesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI) : TracesPackage.eINSTANCE);
		WnsimPackageImpl theWnsimPackage = (WnsimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) instanceof WnsimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) : WnsimPackage.eINSTANCE);

		// Create package meta-data objects
		theDefinitionPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theInvocationPackage.createPackageContents();
		theMeasuresPackage.createPackageContents();
		theToolresultPackage.createPackageContents();
		theTracesPackage.createPackageContents();
		theWnsimPackage.createPackageContents();

		// Initialize created meta-data
		theDefinitionPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theInvocationPackage.initializePackageContents();
		theMeasuresPackage.initializePackageContents();
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
	public EClass getSimulationDefinition() {
		return simulationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulationDefinition_Name() {
		return (EAttribute)simulationDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulationDefinition_DomainResource() {
		return (EAttribute)simulationDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationDefinition_Invocations() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationDefinition_Parameters() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationDefinition_Scenario() {
		return (EReference)simulationDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulationParameter() {
		return simulationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulationParameter_Name() {
		return (EAttribute)simulationParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulationParameter_Value() {
		return (EAttribute)simulationParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenario() {
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Variables() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Name() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputVariableValue() {
		return inputVariableValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputVariableValue_Value() {
		return (EAttribute)inputVariableValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputVariableValue_Unit() {
		return (EAttribute)inputVariableValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputVariable() {
		return inputVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputVariable_Values() {
		return (EReference)inputVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputVariable() {
		return outputVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
		createEAttribute(simulationDefinitionEClass, SIMULATION_DEFINITION__NAME);
		createEAttribute(simulationDefinitionEClass, SIMULATION_DEFINITION__DOMAIN_RESOURCE);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__INVOCATIONS);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__PARAMETERS);
		createEReference(simulationDefinitionEClass, SIMULATION_DEFINITION__SCENARIO);

		simulationParameterEClass = createEClass(SIMULATION_PARAMETER);
		createEAttribute(simulationParameterEClass, SIMULATION_PARAMETER__NAME);
		createEAttribute(simulationParameterEClass, SIMULATION_PARAMETER__VALUE);

		scenarioEClass = createEClass(SCENARIO);
		createEReference(scenarioEClass, SCENARIO__VARIABLES);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);

		inputVariableValueEClass = createEClass(INPUT_VARIABLE_VALUE);
		createEAttribute(inputVariableValueEClass, INPUT_VARIABLE_VALUE__VALUE);
		createEAttribute(inputVariableValueEClass, INPUT_VARIABLE_VALUE__UNIT);

		inputVariableEClass = createEClass(INPUT_VARIABLE);
		createEReference(inputVariableEClass, INPUT_VARIABLE__VALUES);

		outputVariableEClass = createEClass(OUTPUT_VARIABLE);
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
		DatatypesPackage theDatatypesPackage = (DatatypesPackage)EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
		InvocationPackage theInvocationPackage = (InvocationPackage)EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI);
		MeasuresPackage theMeasuresPackage = (MeasuresPackage)EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inputVariableEClass.getESuperTypes().add(this.getVariable());
		outputVariableEClass.getESuperTypes().add(this.getVariable());
		outputVariableEClass.getESuperTypes().add(theMeasuresPackage.getDomainMeasure());

		// Initialize classes, features, and operations; add parameters
		initEClass(simulationDefinitionEClass, SimulationDefinition.class, "SimulationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimulationDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationDefinition_DomainResource(), theDatatypesPackage.getURI(), "domainResource", null, 1, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_Invocations(), theInvocationPackage.getSimulationInvocation(), theInvocationPackage.getSimulationInvocation_Definition(), "invocations", null, 0, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_Parameters(), this.getSimulationParameter(), null, "parameters", null, 0, -1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationDefinition_Scenario(), this.getScenario(), null, "scenario", null, 1, 1, SimulationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simulationParameterEClass, SimulationParameter.class, "SimulationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimulationParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, SimulationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationParameter_Value(), ecorePackage.getEString(), "value", null, 1, 1, SimulationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScenario_Variables(), this.getVariable(), null, "variables", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputVariableValueEClass, InputVariableValue.class, "InputVariableValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputVariableValue_Value(), theDatatypesPackage.getNumber(), "value", null, 1, 1, InputVariableValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInputVariableValue_Unit(), theDatatypesPackage.getUnit(), "unit", null, 1, 1, InputVariableValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputVariableEClass, InputVariable.class, "InputVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputVariable_Values(), this.getInputVariableValue(), null, "values", null, 1, -1, InputVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputVariableEClass, OutputVariable.class, "OutputVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DefinitionPackageImpl
