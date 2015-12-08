/**
 */
package es.unizar.disco.pnconfig.impl;

import es.unizar.disco.pnconfig.AnalysisType;
import es.unizar.disco.pnconfig.PetriNetConfig;
import es.unizar.disco.pnconfig.PnconfigFactory;
import es.unizar.disco.pnconfig.PnconfigPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PnconfigPackageImpl extends EPackageImpl implements PnconfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass petriNetConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToEFloatObjectsMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum analysisTypeEEnum = null;

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
	 * @see es.unizar.disco.pnconfig.PnconfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PnconfigPackageImpl() {
		super(eNS_URI, PnconfigFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PnconfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PnconfigPackage init() {
		if (isInited) return (PnconfigPackage)EPackage.Registry.INSTANCE.getEPackage(PnconfigPackage.eNS_URI);

		// Obtain or create and register package
		PnconfigPackageImpl thePnconfigPackage = (PnconfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PnconfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PnconfigPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePnconfigPackage.createPackageContents();

		// Initialize created meta-data
		thePnconfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePnconfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PnconfigPackage.eNS_URI, thePnconfigPackage);
		return thePnconfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPetriNetConfig() {
		return petriNetConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPetriNetConfig_AnalysisType() {
		return (EAttribute)petriNetConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPetriNetConfig_VariableAssignments() {
		return (EReference)petriNetConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPetriNetConfig_InitialMarking() {
		return (EReference)petriNetConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEStringToEFloatObjectsMap() {
		return eStringToEFloatObjectsMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringToEFloatObjectsMap_Key() {
		return (EAttribute)eStringToEFloatObjectsMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringToEFloatObjectsMap_Value() {
		return (EAttribute)eStringToEFloatObjectsMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAnalysisType() {
		return analysisTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PnconfigFactory getPnconfigFactory() {
		return (PnconfigFactory)getEFactoryInstance();
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
		petriNetConfigEClass = createEClass(PETRI_NET_CONFIG);
		createEAttribute(petriNetConfigEClass, PETRI_NET_CONFIG__ANALYSIS_TYPE);
		createEReference(petriNetConfigEClass, PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS);
		createEReference(petriNetConfigEClass, PETRI_NET_CONFIG__INITIAL_MARKING);

		eStringToEFloatObjectsMapEClass = createEClass(ESTRING_TO_EFLOAT_OBJECTS_MAP);
		createEAttribute(eStringToEFloatObjectsMapEClass, ESTRING_TO_EFLOAT_OBJECTS_MAP__KEY);
		createEAttribute(eStringToEFloatObjectsMapEClass, ESTRING_TO_EFLOAT_OBJECTS_MAP__VALUE);

		// Create enums
		analysisTypeEEnum = createEEnum(ANALYSIS_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(petriNetConfigEClass, PetriNetConfig.class, "PetriNetConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPetriNetConfig_AnalysisType(), this.getAnalysisType(), "analysisType", null, 1, 1, PetriNetConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPetriNetConfig_VariableAssignments(), this.getEStringToEFloatObjectsMap(), null, "variableAssignments", null, 0, -1, PetriNetConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPetriNetConfig_InitialMarking(), this.getEStringToEFloatObjectsMap(), null, "initialMarking", null, 1, 1, PetriNetConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToEFloatObjectsMapEClass, Map.Entry.class, "EStringToEFloatObjectsMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToEFloatObjectsMap_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEStringToEFloatObjectsMap_Value(), ecorePackage.getEFloatObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(analysisTypeEEnum, AnalysisType.class, "AnalysisType");
		addEEnumLiteral(analysisTypeEEnum, AnalysisType.TRANSIENT);
		addEEnumLiteral(analysisTypeEEnum, AnalysisType.STEADY_STATE);

		// Create resource
		createResource(eNS_URI);
	}

} //PnconfigPackageImpl
