/**
 */
package es.unizar.disco.simulation.models.datatypes.impl;

import es.unizar.disco.simulation.models.datatypes.DatatypesFactory;
import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.datatypes.Measure;
import es.unizar.disco.simulation.models.datatypes.Resource;
import es.unizar.disco.simulation.models.datatypes.SimulationStatus;
import es.unizar.disco.simulation.models.datatypes.Unit;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;

import es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl;

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

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypesPackageImpl extends EPackageImpl implements DatatypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unitEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum measureEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum simulationStatusEEnum = null;

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
	private EDataType numberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType collectionEDataType = null;

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
	 * @see es.unizar.disco.simulation.models.datatypes.DatatypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatatypesPackageImpl() {
		super(eNS_URI, DatatypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DatatypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatatypesPackage init() {
		if (isInited) return (DatatypesPackage)EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);

		// Obtain or create and register package
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DatatypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DatatypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DefinitionPackageImpl theDefinitionPackage = (DefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI) instanceof DefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI) : DefinitionPackage.eINSTANCE);
		InvocationPackageImpl theInvocationPackage = (InvocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) instanceof InvocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI) : InvocationPackage.eINSTANCE);
		MeasuresPackageImpl theMeasuresPackage = (MeasuresPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) instanceof MeasuresPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI) : MeasuresPackage.eINSTANCE);
		SimresultPackageImpl theSimresultPackage = (SimresultPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimresultPackage.eNS_URI) instanceof SimresultPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimresultPackage.eNS_URI) : SimresultPackage.eINSTANCE);
		ToolresultPackageImpl theToolresultPackage = (ToolresultPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI) instanceof ToolresultPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI) : ToolresultPackage.eINSTANCE);
		TracesPackageImpl theTracesPackage = (TracesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI) instanceof TracesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI) : TracesPackage.eINSTANCE);
		WnsimPackageImpl theWnsimPackage = (WnsimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) instanceof WnsimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI) : WnsimPackage.eINSTANCE);

		// Create package meta-data objects
		theDatatypesPackage.createPackageContents();
		theDefinitionPackage.createPackageContents();
		theInvocationPackage.createPackageContents();
		theMeasuresPackage.createPackageContents();
		theSimresultPackage.createPackageContents();
		theToolresultPackage.createPackageContents();
		theTracesPackage.createPackageContents();
		theWnsimPackage.createPackageContents();

		// Initialize created meta-data
		theDatatypesPackage.initializePackageContents();
		theDefinitionPackage.initializePackageContents();
		theInvocationPackage.initializePackageContents();
		theMeasuresPackage.initializePackageContents();
		theSimresultPackage.initializePackageContents();
		theToolresultPackage.initializePackageContents();
		theTracesPackage.initializePackageContents();
		theWnsimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDatatypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatatypesPackage.eNS_URI, theDatatypesPackage);
		return theDatatypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Uri() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Resource() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnit() {
		return unitEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMeasure() {
		return measureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSimulationStatus() {
		return simulationStatusEEnum;
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
	public EDataType getNumber() {
		return numberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCollection() {
		return collectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypesFactory getDatatypesFactory() {
		return (DatatypesFactory)getEFactoryInstance();
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
		resourceEClass = createEClass(RESOURCE);
		createEAttribute(resourceEClass, RESOURCE__URI);
		createEAttribute(resourceEClass, RESOURCE__RESOURCE);

		// Create enums
		unitEEnum = createEEnum(UNIT);
		measureEEnum = createEEnum(MEASURE);
		simulationStatusEEnum = createEEnum(SIMULATION_STATUS);

		// Create data types
		uriEDataType = createEDataType(URI);
		numberEDataType = createEDataType(NUMBER);
		collectionEDataType = createEDataType(COLLECTION);
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
		addETypeParameter(collectionEDataType, "T");

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResource_Uri(), this.getURI(), "uri", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Resource(), ecorePackage.getEResource(), "resource", null, 1, 1, Resource.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(unitEEnum, Unit.class, "Unit");
		addEEnumLiteral(unitEEnum, Unit.UNSPECIFIED);
		addEEnumLiteral(unitEEnum, Unit.NONE);
		addEEnumLiteral(unitEEnum, Unit.S);
		addEEnumLiteral(unitEEnum, Unit.TICK);
		addEEnumLiteral(unitEEnum, Unit.MS);
		addEEnumLiteral(unitEEnum, Unit.US);
		addEEnumLiteral(unitEEnum, Unit.MIN);
		addEEnumLiteral(unitEEnum, Unit.HRS);
		addEEnumLiteral(unitEEnum, Unit.DAY);
		addEEnumLiteral(unitEEnum, Unit.HZ);
		addEEnumLiteral(unitEEnum, Unit.KHZ);
		addEEnumLiteral(unitEEnum, Unit.MHZ);
		addEEnumLiteral(unitEEnum, Unit.GHZ);
		addEEnumLiteral(unitEEnum, Unit.RPM);
		addEEnumLiteral(unitEEnum, Unit.W);
		addEEnumLiteral(unitEEnum, Unit.MW);
		addEEnumLiteral(unitEEnum, Unit.KW);
		addEEnumLiteral(unitEEnum, Unit.BIT);
		addEEnumLiteral(unitEEnum, Unit.BYTE);
		addEEnumLiteral(unitEEnum, Unit.KB);
		addEEnumLiteral(unitEEnum, Unit.MB);
		addEEnumLiteral(unitEEnum, Unit.GB);
		addEEnumLiteral(unitEEnum, Unit.BPER_S);
		addEEnumLiteral(unitEEnum, Unit.KB_PER_S);
		addEEnumLiteral(unitEEnum, Unit.MB_PER_S);
		addEEnumLiteral(unitEEnum, Unit.J);
		addEEnumLiteral(unitEEnum, Unit.KJ);
		addEEnumLiteral(unitEEnum, Unit.WH);
		addEEnumLiteral(unitEEnum, Unit.KWH);
		addEEnumLiteral(unitEEnum, Unit.MWH);
		addEEnumLiteral(unitEEnum, Unit.M);
		addEEnumLiteral(unitEEnum, Unit.CM);
		addEEnumLiteral(unitEEnum, Unit.MM);
		addEEnumLiteral(unitEEnum, Unit.MM2);
		addEEnumLiteral(unitEEnum, Unit.UM2);
		addEEnumLiteral(unitEEnum, Unit.G);
		addEEnumLiteral(unitEEnum, Unit.MG);
		addEEnumLiteral(unitEEnum, Unit.KG);

		initEEnum(measureEEnum, Measure.class, "Measure");
		addEEnumLiteral(measureEEnum, Measure.UNSPECIFIED);
		addEEnumLiteral(measureEEnum, Measure.RESP_T);
		addEEnumLiteral(measureEEnum, Measure.THROUGHPUT);
		addEEnumLiteral(measureEEnum, Measure.UTILIZATION);

		initEEnum(simulationStatusEEnum, SimulationStatus.class, "SimulationStatus");
		addEEnumLiteral(simulationStatusEEnum, SimulationStatus.UNKNOWN);
		addEEnumLiteral(simulationStatusEEnum, SimulationStatus.RUNNING);
		addEEnumLiteral(simulationStatusEEnum, SimulationStatus.FINISHED);
		addEEnumLiteral(simulationStatusEEnum, SimulationStatus.KILLED);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(numberEDataType, Number.class, "Number", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(collectionEDataType, Collection.class, "Collection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://es.unizar.disco/simulation/conversion/uri/1.0
		create_1Annotations();
		// http://es.unizar.disco/simulation/conversion/number/1.0
		create_1_1Annotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "conversionDelegates", "http://es.unizar.disco/simulation/conversion/number/1.0 http://es.unizar.disco/simulation/conversion/uri/1.0"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://es.unizar.disco/simulation/conversion/uri/1.0</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void create_1Annotations() {
		String source = "http://es.unizar.disco/simulation/conversion/uri/1.0";	
		addAnnotation
		  (uriEDataType, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://es.unizar.disco/simulation/conversion/number/1.0</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void create_1_1Annotations() {
		String source = "http://es.unizar.disco/simulation/conversion/number/1.0";	
		addAnnotation
		  (numberEDataType, 
		   source, 
		   new String[] {
			 "conversionDelegates", "http://es.unizar.disco/simulation/conversion/1.0"
		   });
	}

} //DatatypesPackageImpl
