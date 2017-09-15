/**
 */
package es.unizar.disco.pnextensions.pnconstants.impl;

import es.unizar.disco.pnextensions.pnconstants.ArcKind;
import es.unizar.disco.pnextensions.pnconstants.BaseUnitsConstants;
import es.unizar.disco.pnextensions.pnconstants.Color;
import es.unizar.disco.pnextensions.pnconstants.PnconstantsFactory;
import es.unizar.disco.pnextensions.pnconstants.PnconstantsPackage;
import es.unizar.disco.pnextensions.pnconstants.ServerType;
import es.unizar.disco.pnextensions.pnconstants.ToolInfoConstants;
import es.unizar.disco.pnextensions.pnconstants.TransitionKind;

import es.unizar.disco.pnextensions.pnutils.PnutilsPackage;

import es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PnconstantsPackageImpl extends EPackageImpl implements PnconstantsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum toolInfoConstantsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transitionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum serverTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum baseUnitsConstantsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum colorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum arcKindEEnum = null;

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
	 * @see es.unizar.disco.pnextensions.pnconstants.PnconstantsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PnconstantsPackageImpl() {
		super(eNS_URI, PnconstantsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PnconstantsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PnconstantsPackage init() {
		if (isInited) return (PnconstantsPackage)EPackage.Registry.INSTANCE.getEPackage(PnconstantsPackage.eNS_URI);

		// Obtain or create and register package
		PnconstantsPackageImpl thePnconstantsPackage = (PnconstantsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PnconstantsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PnconstantsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		PnutilsPackageImpl thePnutilsPackage = (PnutilsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PnutilsPackage.eNS_URI) instanceof PnutilsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PnutilsPackage.eNS_URI) : PnutilsPackage.eINSTANCE);

		// Create package meta-data objects
		thePnconstantsPackage.createPackageContents();
		thePnutilsPackage.createPackageContents();

		// Initialize created meta-data
		thePnconstantsPackage.initializePackageContents();
		thePnutilsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePnconstantsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PnconstantsPackage.eNS_URI, thePnconstantsPackage);
		return thePnconstantsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getToolInfoConstants() {
		return toolInfoConstantsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransitionKind() {
		return transitionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServerType() {
		return serverTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBaseUnitsConstants() {
		return baseUnitsConstantsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColor() {
		return colorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getArcKind() {
		return arcKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PnconstantsFactory getPnconstantsFactory() {
		return (PnconstantsFactory)getEFactoryInstance();
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

		// Create enums
		toolInfoConstantsEEnum = createEEnum(TOOL_INFO_CONSTANTS);
		transitionKindEEnum = createEEnum(TRANSITION_KIND);
		serverTypeEEnum = createEEnum(SERVER_TYPE);
		baseUnitsConstantsEEnum = createEEnum(BASE_UNITS_CONSTANTS);
		colorEEnum = createEEnum(COLOR);
		arcKindEEnum = createEEnum(ARC_KIND);
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

		// Initialize enums and add enum literals
		initEEnum(toolInfoConstantsEEnum, ToolInfoConstants.class, "ToolInfoConstants");
		addEEnumLiteral(toolInfoConstantsEEnum, ToolInfoConstants.TOOL_NAME);
		addEEnumLiteral(toolInfoConstantsEEnum, ToolInfoConstants.TOOL_VERSION);
		addEEnumLiteral(toolInfoConstantsEEnum, ToolInfoConstants.URI);

		initEEnum(transitionKindEEnum, TransitionKind.class, "TransitionKind");
		addEEnumLiteral(transitionKindEEnum, TransitionKind.IMMEDIATE);
		addEEnumLiteral(transitionKindEEnum, TransitionKind.EXPONENTIAL);
		addEEnumLiteral(transitionKindEEnum, TransitionKind.DETERMINISTIC);
		addEEnumLiteral(transitionKindEEnum, TransitionKind.IMMEDIATE_PRIORITY);
		addEEnumLiteral(transitionKindEEnum, TransitionKind.ERLANG);

		initEEnum(serverTypeEEnum, ServerType.class, "ServerType");
		addEEnumLiteral(serverTypeEEnum, ServerType.INFINITE_SERVER);
		addEEnumLiteral(serverTypeEEnum, ServerType.ONE_SERVER);
		addEEnumLiteral(serverTypeEEnum, ServerType.LOAD_DEPENDENT);
		addEEnumLiteral(serverTypeEEnum, ServerType.MARKING_DEPENDENT);

		initEEnum(baseUnitsConstantsEEnum, BaseUnitsConstants.class, "BaseUnitsConstants");
		addEEnumLiteral(baseUnitsConstantsEEnum, BaseUnitsConstants.BASE_TIME_UNIT);
		addEEnumLiteral(baseUnitsConstantsEEnum, BaseUnitsConstants.BASE_FREQUENCY_UNIT);

		initEEnum(colorEEnum, Color.class, "Color");
		addEEnumLiteral(colorEEnum, Color.COLOR);
		addEEnumLiteral(colorEEnum, Color.COLORSET);

		initEEnum(arcKindEEnum, ArcKind.class, "ArcKind");
		addEEnumLiteral(arcKindEEnum, ArcKind.NORMAL);
		addEEnumLiteral(arcKindEEnum, ArcKind.INHIBITOR);

		// Create resource
		createResource(eNS_URI);
	}

} //PnconstantsPackageImpl
