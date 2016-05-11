/**
 */
package es.unizar.disco.simulation.models.traces.impl;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;

import es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;

import es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;

import es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl;

import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl;

import es.unizar.disco.simulation.models.toolresult.ToolresultPackage;

import es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl;

import es.unizar.disco.simulation.models.traces.Trace;
import es.unizar.disco.simulation.models.traces.TraceSet;
import es.unizar.disco.simulation.models.traces.TracesFactory;
import es.unizar.disco.simulation.models.traces.TracesPackage;

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
public class TracesPackageImpl extends EPackageImpl implements TracesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceEClass = null;

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
	 * @see es.unizar.disco.simulation.models.traces.TracesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TracesPackageImpl() {
		super(eNS_URI, TracesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TracesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TracesPackage init() {
		if (isInited) return (TracesPackage)EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI);

		// Obtain or create and register package
		TracesPackageImpl theTracesPackage = (TracesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TracesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TracesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) instanceof DatatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) : DatatypesPackage.eINSTANCE);
		DefinitionPackageImpl theDefinitionPackage = (DefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI) instanceof DefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI) : DefinitionPackage.eINSTANCE);
		InvocationPackageImpl theInvocationPackage = (InvocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) instanceof InvocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) : InvocationPackage.eINSTANCE);
		MeasuresPackageImpl theMeasuresPackage = (MeasuresPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) instanceof MeasuresPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) : MeasuresPackage.eINSTANCE);
		ToolresultPackageImpl theToolresultPackage = (ToolresultPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI) instanceof ToolresultPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI) : ToolresultPackage.eINSTANCE);
		WnsimPackageImpl theWnsimPackage = (WnsimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) instanceof WnsimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) : WnsimPackage.eINSTANCE);

		// Create package meta-data objects
		theTracesPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theDefinitionPackage.createPackageContents();
		theInvocationPackage.createPackageContents();
		theMeasuresPackage.createPackageContents();
		theToolresultPackage.createPackageContents();
		theWnsimPackage.createPackageContents();

		// Initialize created meta-data
		theTracesPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theDefinitionPackage.initializePackageContents();
		theInvocationPackage.initializePackageContents();
		theMeasuresPackage.initializePackageContents();
		theToolresultPackage.initializePackageContents();
		theWnsimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTracesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TracesPackage.eNS_URI, theTracesPackage);
		return theTracesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceSet() {
		return traceSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceSet_Traces() {
		return (EReference)traceSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrace() {
		return traceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_FromDomainElement() {
		return (EReference)traceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_ToAnalyzableElement() {
		return (EReference)traceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrace_Rule() {
		return (EAttribute)traceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracesFactory getTracesFactory() {
		return (TracesFactory)getEFactoryInstance();
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
		traceSetEClass = createEClass(TRACE_SET);
		createEReference(traceSetEClass, TRACE_SET__TRACES);

		traceEClass = createEClass(TRACE);
		createEReference(traceEClass, TRACE__FROM_DOMAIN_ELEMENT);
		createEReference(traceEClass, TRACE__TO_ANALYZABLE_ELEMENT);
		createEAttribute(traceEClass, TRACE__RULE);
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
		initEClass(traceSetEClass, TraceSet.class, "TraceSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceSet_Traces(), this.getTrace(), null, "traces", null, 0, -1, TraceSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceEClass, Trace.class, "Trace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrace_FromDomainElement(), ecorePackage.getEObject(), null, "fromDomainElement", null, 1, 1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_ToAnalyzableElement(), ecorePackage.getEObject(), null, "toAnalyzableElement", null, 1, 1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrace_Rule(), ecorePackage.getEString(), "rule", null, 0, 1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TracesPackageImpl
