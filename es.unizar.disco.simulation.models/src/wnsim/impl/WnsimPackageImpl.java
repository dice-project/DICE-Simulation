/**
 */
package wnsim.impl;

import configuration.ConfigurationPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import wnsim.PlaceInfo;
import wnsim.SimulationParameters;
import wnsim.TransitionInfo;
import wnsim.WnsimElementInfo;
import wnsim.WnsimFactory;
import wnsim.WnsimPackage;
import wnsim.WnsimResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WnsimPackageImpl extends EPackageImpl implements WnsimPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wnsimResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wnsimElementInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum simulationParametersEEnum = null;

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
	 * @see wnsim.WnsimPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WnsimPackageImpl() {
		super(eNS_URI, WnsimFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link WnsimPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WnsimPackage init() {
		if (isInited) return (WnsimPackage)EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI);

		// Obtain or create and register package
		WnsimPackageImpl theWnsimPackage = (WnsimPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WnsimPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WnsimPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConfigurationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWnsimPackage.createPackageContents();

		// Initialize created meta-data
		theWnsimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWnsimPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WnsimPackage.eNS_URI, theWnsimPackage);
		return theWnsimPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWnsimResult() {
		return wnsimResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWnsimElementInfo() {
		return wnsimElementInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlaceInfo() {
		return placeInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlaceInfo_Throughput() {
		return (EAttribute)placeInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionInfo() {
		return transitionInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionInfo_MeanNumberOfTokens() {
		return (EAttribute)transitionInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSimulationParameters() {
		return simulationParametersEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WnsimFactory getWnsimFactory() {
		return (WnsimFactory)getEFactoryInstance();
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
		wnsimResultEClass = createEClass(WNSIM_RESULT);

		wnsimElementInfoEClass = createEClass(WNSIM_ELEMENT_INFO);

		placeInfoEClass = createEClass(PLACE_INFO);
		createEAttribute(placeInfoEClass, PLACE_INFO__THROUGHPUT);

		transitionInfoEClass = createEClass(TRANSITION_INFO);
		createEAttribute(transitionInfoEClass, TRANSITION_INFO__MEAN_NUMBER_OF_TOKENS);

		// Create enums
		simulationParametersEEnum = createEEnum(SIMULATION_PARAMETERS);
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
		ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		wnsimResultEClass.getESuperTypes().add(theConfigurationPackage.getToolResult());
		wnsimElementInfoEClass.getESuperTypes().add(theConfigurationPackage.getAnalyzableElementInfo());
		placeInfoEClass.getESuperTypes().add(this.getWnsimElementInfo());
		transitionInfoEClass.getESuperTypes().add(this.getWnsimElementInfo());

		// Initialize classes, features, and operations; add parameters
		initEClass(wnsimResultEClass, WnsimResult.class, "WnsimResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wnsimElementInfoEClass, WnsimElementInfo.class, "WnsimElementInfo", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placeInfoEClass, PlaceInfo.class, "PlaceInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlaceInfo_Throughput(), ecorePackage.getEFloatObject(), "throughput", null, 0, 1, PlaceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionInfoEClass, TransitionInfo.class, "TransitionInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransitionInfo_MeanNumberOfTokens(), ecorePackage.getEFloatObject(), "meanNumberOfTokens", null, 0, 1, TransitionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(simulationParametersEEnum, SimulationParameters.class, "SimulationParameters");
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.FIRST_TR_LENGTH);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.TR_LENGTH);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.MIN_BTC);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.MAX_BTC);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.APPROX);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.CONF_LEVEL);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.SEED);

		// Create resource
		createResource(eNS_URI);
	}

} //WnsimPackageImpl
