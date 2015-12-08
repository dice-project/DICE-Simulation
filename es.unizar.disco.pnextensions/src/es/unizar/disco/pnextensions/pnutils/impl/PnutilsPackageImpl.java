/**
 */
package es.unizar.disco.pnextensions.pnutils.impl;

import es.unizar.disco.pnextensions.pnconstants.PnconstantsPackage;

import es.unizar.disco.pnextensions.pnconstants.impl.PnconstantsPackageImpl;

import es.unizar.disco.pnextensions.pnutils.DataTypeUtils;
import es.unizar.disco.pnextensions.pnutils.PnUtils;
import es.unizar.disco.pnextensions.pnutils.PnutilsFactory;
import es.unizar.disco.pnextensions.pnutils.PnutilsPackage;
import es.unizar.disco.pnextensions.pnutils.ToolInfoUtils;

import java.net.URISyntaxException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PnutilsPackageImpl extends EPackageImpl implements PnutilsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pnUtilsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeUtilsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolInfoUtilsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriSyntaxExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringBufferEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType illegalArgumentExceptionEDataType = null;

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
	 * @see es.unizar.disco.pnextensions.pnutils.PnutilsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PnutilsPackageImpl() {
		super(eNS_URI, PnutilsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PnutilsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PnutilsPackage init() {
		if (isInited) return (PnutilsPackage)EPackage.Registry.INSTANCE.getEPackage(PnutilsPackage.eNS_URI);

		// Obtain or create and register package
		PnutilsPackageImpl thePnutilsPackage = (PnutilsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PnutilsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PnutilsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		PnconstantsPackageImpl thePnconstantsPackage = (PnconstantsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PnconstantsPackage.eNS_URI) instanceof PnconstantsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PnconstantsPackage.eNS_URI) : PnconstantsPackage.eINSTANCE);

		// Create package meta-data objects
		thePnutilsPackage.createPackageContents();
		thePnconstantsPackage.createPackageContents();

		// Initialize created meta-data
		thePnutilsPackage.initializePackageContents();
		thePnconstantsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePnutilsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PnutilsPackage.eNS_URI, thePnutilsPackage);
		return thePnutilsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPnUtils() {
		return pnUtilsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPnUtils__Layout__EObject() {
		return pnUtilsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeUtils() {
		return dataTypeUtilsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataTypeUtils__CreateURI__String() {
		return dataTypeUtilsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataTypeUtils__CreateLongString__String() {
		return dataTypeUtilsEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToolInfoUtils() {
		return toolInfoUtilsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__IsEObjectValidPnObject__EObject() {
		return toolInfoUtilsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__IsEObjectValidTransition__EObject() {
		return toolInfoUtilsEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__GetToolInfoEntryByGrammarUri__EObject_String() {
		return toolInfoUtilsEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__DeleteToolInfoEntryByGrammarUri__EObject_String() {
		return toolInfoUtilsEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__SetToolInfoEntryByGrammarUri__EObject_String_String() {
		return toolInfoUtilsEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__IsTransitionKind__EObject_TransitionKind() {
		return toolInfoUtilsEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__IsTransitionServerType__EObject_ServerType() {
		return toolInfoUtilsEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__SetTransitionKind__EObject_TransitionKind_Object() {
		return toolInfoUtilsEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__SetTransitionServerType__EObject_ServerType_Object() {
		return toolInfoUtilsEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getToolInfoUtils__GetTransitionRate__EObject() {
		return toolInfoUtilsEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURISyntaxException() {
		return uriSyntaxExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStringBuffer() {
		return stringBufferEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIllegalArgumentException() {
		return illegalArgumentExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PnutilsFactory getPnutilsFactory() {
		return (PnutilsFactory)getEFactoryInstance();
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
		pnUtilsEClass = createEClass(PN_UTILS);
		createEOperation(pnUtilsEClass, PN_UTILS___LAYOUT__EOBJECT);

		dataTypeUtilsEClass = createEClass(DATA_TYPE_UTILS);
		createEOperation(dataTypeUtilsEClass, DATA_TYPE_UTILS___CREATE_URI__STRING);
		createEOperation(dataTypeUtilsEClass, DATA_TYPE_UTILS___CREATE_LONG_STRING__STRING);

		toolInfoUtilsEClass = createEClass(TOOL_INFO_UTILS);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___IS_EOBJECT_VALID_PN_OBJECT__EOBJECT);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___IS_EOBJECT_VALID_TRANSITION__EOBJECT);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___GET_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___DELETE_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___SET_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING_STRING);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___IS_TRANSITION_KIND__EOBJECT_TRANSITIONKIND);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___IS_TRANSITION_SERVER_TYPE__EOBJECT_SERVERTYPE);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___SET_TRANSITION_KIND__EOBJECT_TRANSITIONKIND_OBJECT);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___SET_TRANSITION_SERVER_TYPE__EOBJECT_SERVERTYPE_OBJECT);
		createEOperation(toolInfoUtilsEClass, TOOL_INFO_UTILS___GET_TRANSITION_RATE__EOBJECT);

		// Create data types
		uriEDataType = createEDataType(URI);
		uriSyntaxExceptionEDataType = createEDataType(URI_SYNTAX_EXCEPTION);
		stringBufferEDataType = createEDataType(STRING_BUFFER);
		illegalArgumentExceptionEDataType = createEDataType(ILLEGAL_ARGUMENT_EXCEPTION);
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
		PnconstantsPackage thePnconstantsPackage = (PnconstantsPackage)EPackage.Registry.INSTANCE.getEPackage(PnconstantsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(pnUtilsEClass, PnUtils.class, "PnUtils", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getPnUtils__Layout__EObject(), null, "layout", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "petriNet", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataTypeUtilsEClass, DataTypeUtils.class, "DataTypeUtils", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getDataTypeUtils__CreateURI__String(), this.getURI(), "createURI", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "stringUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getURISyntaxException());

		op = initEOperation(getDataTypeUtils__CreateLongString__String(), this.getStringBuffer(), "createLongString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "string", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(toolInfoUtilsEClass, ToolInfoUtils.class, "ToolInfoUtils", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getToolInfoUtils__IsEObjectValidPnObject__EObject(), ecorePackage.getEBoolean(), "isEObjectValidPnObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "eObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getToolInfoUtils__IsEObjectValidTransition__EObject(), ecorePackage.getEBoolean(), "isEObjectValidTransition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "eObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getToolInfoUtils__GetToolInfoEntryByGrammarUri__EObject_String(), ecorePackage.getEObject(), "getToolInfoEntryByGrammarUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "pnObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getToolInfoUtils__DeleteToolInfoEntryByGrammarUri__EObject_String(), ecorePackage.getEObject(), "deleteToolInfoEntryByGrammarUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "pnObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getToolInfoUtils__SetToolInfoEntryByGrammarUri__EObject_String_String(), null, "setToolInfoEntryByGrammarUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "pnObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getToolInfoUtils__IsTransitionKind__EObject_TransitionKind(), ecorePackage.getEBoolean(), "isTransitionKind", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "transition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePnconstantsPackage.getTransitionKind(), "transitionKind", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getIllegalArgumentException());

		op = initEOperation(getToolInfoUtils__IsTransitionServerType__EObject_ServerType(), ecorePackage.getEBoolean(), "isTransitionServerType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "transition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePnconstantsPackage.getServerType(), "serverType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getIllegalArgumentException());

		op = initEOperation(getToolInfoUtils__SetTransitionKind__EObject_TransitionKind_Object(), null, "setTransitionKind", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "transition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePnconstantsPackage.getTransitionKind(), "transitionKind", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getIllegalArgumentException());

		op = initEOperation(getToolInfoUtils__SetTransitionServerType__EObject_ServerType_Object(), null, "setTransitionServerType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "transition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePnconstantsPackage.getServerType(), "serverType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getIllegalArgumentException());

		op = initEOperation(getToolInfoUtils__GetTransitionRate__EObject(), ecorePackage.getEFloatObject(), "getTransitionRate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "transition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getIllegalArgumentException());

		// Initialize data types
		initEDataType(uriEDataType, java.net.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriSyntaxExceptionEDataType, URISyntaxException.class, "URISyntaxException", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringBufferEDataType, StringBuffer.class, "StringBuffer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(illegalArgumentExceptionEDataType, IllegalArgumentException.class, "IllegalArgumentException", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PnutilsPackageImpl
