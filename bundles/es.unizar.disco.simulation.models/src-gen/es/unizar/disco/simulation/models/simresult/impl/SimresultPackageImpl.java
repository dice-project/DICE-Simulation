/**
 */
package es.unizar.disco.simulation.models.simresult.impl;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;

import es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;

import es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;

import es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl;

import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl;

import es.unizar.disco.simulation.models.simresult.SimresultFactory;
import es.unizar.disco.simulation.models.simresult.SimresultPackage;
import es.unizar.disco.simulation.models.simresult.SimulationResult;

import es.unizar.disco.simulation.models.toolresult.ToolresultPackage;

import es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl;

import es.unizar.disco.simulation.models.traces.TracesPackage;

import es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl;

import es.unizar.disco.simulation.models.wnsim.WnsimPackage;

import es.unizar.disco.simulation.models.wnsim.impl.WnsimPackageImpl;

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
public class SimresultPackageImpl extends EPackageImpl implements SimresultPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulationResultEClass = null;

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
	 * @see es.unizar.disco.simulation.models.simresult.SimresultPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimresultPackageImpl() {
		super(eNS_URI, SimresultFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SimresultPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SimresultPackage init() {
		if (isInited) return (SimresultPackage)EPackage.Registry.INSTANCE.getEPackage(SimresultPackage.eNS_URI);

		// Obtain or create and register package
		SimresultPackageImpl theSimresultPackage = (SimresultPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SimresultPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SimresultPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) instanceof DatatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) : DatatypesPackage.eINSTANCE);
		DefinitionPackageImpl theDefinitionPackage = (DefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI) instanceof DefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI) : DefinitionPackage.eINSTANCE);
		InvocationPackageImpl theInvocationPackage = (InvocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) instanceof InvocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) : InvocationPackage.eINSTANCE);
		MeasuresPackageImpl theMeasuresPackage = (MeasuresPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) instanceof MeasuresPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) : MeasuresPackage.eINSTANCE);
		ToolresultPackageImpl theToolresultPackage = (ToolresultPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI) instanceof ToolresultPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI) : ToolresultPackage.eINSTANCE);
		TracesPackageImpl theTracesPackage = (TracesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI) instanceof TracesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI) : TracesPackage.eINSTANCE);
		WnsimPackageImpl theWnsimPackage = (WnsimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) instanceof WnsimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) : WnsimPackage.eINSTANCE);

		// Create package meta-data objects
		theSimresultPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theDefinitionPackage.createPackageContents();
		theInvocationPackage.createPackageContents();
		theMeasuresPackage.createPackageContents();
		theToolresultPackage.createPackageContents();
		theTracesPackage.createPackageContents();
		theWnsimPackage.createPackageContents();

		// Initialize created meta-data
		theSimresultPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theDefinitionPackage.initializePackageContents();
		theInvocationPackage.initializePackageContents();
		theMeasuresPackage.initializePackageContents();
		theToolresultPackage.initializePackageContents();
		theTracesPackage.initializePackageContents();
		theWnsimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimresultPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SimresultPackage.eNS_URI, theSimresultPackage);
		return theSimresultPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulationResult() {
		return simulationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationResult_Invocation() {
		return (EReference)simulationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationResult_Measures() {
		return (EReference)simulationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimresultFactory getSimresultFactory() {
		return (SimresultFactory)getEFactoryInstance();
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
		simulationResultEClass = createEClass(SIMULATION_RESULT);
		createEReference(simulationResultEClass, SIMULATION_RESULT__INVOCATION);
		createEReference(simulationResultEClass, SIMULATION_RESULT__MEASURES);
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
		MeasuresPackage theMeasuresPackage = (MeasuresPackage)EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(simulationResultEClass, SimulationResult.class, "SimulationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimulationResult_Invocation(), theInvocationPackage.getSimulationInvocation(), theInvocationPackage.getSimulationInvocation_Result(), "invocation", null, 1, 1, SimulationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationResult_Measures(), theMeasuresPackage.getDomainMeasure(), null, "measures", null, 0, -1, SimulationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SimresultPackageImpl
