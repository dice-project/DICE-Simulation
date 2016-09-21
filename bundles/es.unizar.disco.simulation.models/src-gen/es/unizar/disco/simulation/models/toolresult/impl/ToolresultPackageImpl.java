/**
 */
package es.unizar.disco.simulation.models.toolresult.impl;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;

import es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;

import es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;

import es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl;

import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl;

import es.unizar.disco.simulation.models.simresult.SimresultPackage;

import es.unizar.disco.simulation.models.simresult.impl.SimresultPackageImpl;

import es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo;
import es.unizar.disco.simulation.models.toolresult.ToolResult;
import es.unizar.disco.simulation.models.toolresult.ToolresultFactory;
import es.unizar.disco.simulation.models.toolresult.ToolresultPackage;

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
public class ToolresultPackageImpl extends EPackageImpl implements ToolresultPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass analyzableElementInfoEClass = null;

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
	 * @see es.unizar.disco.simulation.models.toolresult.ToolresultPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ToolresultPackageImpl() {
		super(eNS_URI, ToolresultFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ToolresultPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ToolresultPackage init() {
		if (isInited) return (ToolresultPackage)EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI);

		// Obtain or create and register package
		ToolresultPackageImpl theToolresultPackage = (ToolresultPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ToolresultPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ToolresultPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) instanceof DatatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) : DatatypesPackage.eINSTANCE);
		DefinitionPackageImpl theDefinitionPackage = (DefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI) instanceof DefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI) : DefinitionPackage.eINSTANCE);
		InvocationPackageImpl theInvocationPackage = (InvocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) instanceof InvocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) : InvocationPackage.eINSTANCE);
		MeasuresPackageImpl theMeasuresPackage = (MeasuresPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) instanceof MeasuresPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) : MeasuresPackage.eINSTANCE);
		SimresultPackageImpl theSimresultPackage = (SimresultPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimresultPackage.eNS_URI) instanceof SimresultPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimresultPackage.eNS_URI) : SimresultPackage.eINSTANCE);
		TracesPackageImpl theTracesPackage = (TracesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI) instanceof TracesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI) : TracesPackage.eINSTANCE);
		WnsimPackageImpl theWnsimPackage = (WnsimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) instanceof WnsimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) : WnsimPackage.eINSTANCE);

		// Create package meta-data objects
		theToolresultPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theDefinitionPackage.createPackageContents();
		theInvocationPackage.createPackageContents();
		theMeasuresPackage.createPackageContents();
		theSimresultPackage.createPackageContents();
		theTracesPackage.createPackageContents();
		theWnsimPackage.createPackageContents();

		// Initialize created meta-data
		theToolresultPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theDefinitionPackage.initializePackageContents();
		theInvocationPackage.initializePackageContents();
		theMeasuresPackage.initializePackageContents();
		theSimresultPackage.initializePackageContents();
		theTracesPackage.initializePackageContents();
		theWnsimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theToolresultPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ToolresultPackage.eNS_URI, theToolresultPackage);
		return theToolresultPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToolResult() {
		return toolResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolResult_Timestamp() {
		return (EAttribute)toolResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToolResult_Infos() {
		return (EReference)toolResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnalyzableElementInfo() {
		return analyzableElementInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalyzableElementInfo_Value() {
		return (EAttribute)analyzableElementInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalyzableElementInfo_AnalyzedElement() {
		return (EReference)analyzableElementInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalyzableElementInfo_Unit() {
		return (EAttribute)analyzableElementInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalyzableElementInfo_ConfidenceInterval() {
		return (EAttribute)analyzableElementInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolresultFactory getToolresultFactory() {
		return (ToolresultFactory)getEFactoryInstance();
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
		toolResultEClass = createEClass(TOOL_RESULT);
		createEAttribute(toolResultEClass, TOOL_RESULT__TIMESTAMP);
		createEReference(toolResultEClass, TOOL_RESULT__INFOS);

		analyzableElementInfoEClass = createEClass(ANALYZABLE_ELEMENT_INFO);
		createEAttribute(analyzableElementInfoEClass, ANALYZABLE_ELEMENT_INFO__VALUE);
		createEReference(analyzableElementInfoEClass, ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT);
		createEAttribute(analyzableElementInfoEClass, ANALYZABLE_ELEMENT_INFO__UNIT);
		createEAttribute(analyzableElementInfoEClass, ANALYZABLE_ELEMENT_INFO__CONFIDENCE_INTERVAL);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(toolResultEClass, ToolResult.class, "ToolResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToolResult_Timestamp(), ecorePackage.getEDate(), "timestamp", null, 0, 1, ToolResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToolResult_Infos(), this.getAnalyzableElementInfo(), null, "infos", null, 0, -1, ToolResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(analyzableElementInfoEClass, AnalyzableElementInfo.class, "AnalyzableElementInfo", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnalyzableElementInfo_Value(), theDatatypesPackage.getNumber(), "value", null, 1, 1, AnalyzableElementInfo.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getAnalyzableElementInfo_AnalyzedElement(), ecorePackage.getEObject(), null, "analyzedElement", null, 1, 1, AnalyzableElementInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalyzableElementInfo_Unit(), ecorePackage.getEString(), "unit", "unspecified", 1, 1, AnalyzableElementInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalyzableElementInfo_ConfidenceInterval(), theDatatypesPackage.getNumber(), "confidenceInterval", null, 2, 2, AnalyzableElementInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ToolresultPackageImpl
