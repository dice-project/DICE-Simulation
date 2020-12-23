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
package es.unizar.disco.simulation.models.wnsim.impl;

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

import es.unizar.disco.simulation.models.toolresult.ToolresultPackage;

import es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl;

import es.unizar.disco.simulation.models.traces.TracesPackage;

import es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl;

import es.unizar.disco.simulation.models.wnsim.PlaceInfo;
import es.unizar.disco.simulation.models.wnsim.SimulationParameters;
import es.unizar.disco.simulation.models.wnsim.TransitionInfo;
import es.unizar.disco.simulation.models.wnsim.WnsimElementInfo;
import es.unizar.disco.simulation.models.wnsim.WnsimFactory;
import es.unizar.disco.simulation.models.wnsim.WnsimPackage;
import es.unizar.disco.simulation.models.wnsim.WnsimResult;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
	 * @see es.unizar.disco.simulation.models.wnsim.WnsimPackage#eNS_URI
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
		Object registeredWnsimPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		WnsimPackageImpl theWnsimPackage = registeredWnsimPackage instanceof WnsimPackageImpl ? (WnsimPackageImpl)registeredWnsimPackage : new WnsimPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(registeredPackage instanceof DatatypesPackageImpl ? registeredPackage : DatatypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI);
		DefinitionPackageImpl theDefinitionPackage = (DefinitionPackageImpl)(registeredPackage instanceof DefinitionPackageImpl ? registeredPackage : DefinitionPackage.eINSTANCE);
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

		// Create package meta-data objects
		theWnsimPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theDefinitionPackage.createPackageContents();
		theInvocationPackage.createPackageContents();
		theMeasuresPackage.createPackageContents();
		theSimresultPackage.createPackageContents();
		theToolresultPackage.createPackageContents();
		theTracesPackage.createPackageContents();

		// Initialize created meta-data
		theWnsimPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theDefinitionPackage.initializePackageContents();
		theInvocationPackage.initializePackageContents();
		theMeasuresPackage.initializePackageContents();
		theSimresultPackage.initializePackageContents();
		theToolresultPackage.initializePackageContents();
		theTracesPackage.initializePackageContents();

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
	@Override
	public EClass getWnsimResult() {
		return wnsimResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWnsimElementInfo() {
		return wnsimElementInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPlaceInfo() {
		return placeInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlaceInfo_MeanNumberOfTokens() {
		return (EAttribute)placeInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPlaceInfo__GetValue() {
		return placeInfoEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransitionInfo() {
		return transitionInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTransitionInfo_Throughput() {
		return (EAttribute)transitionInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTransitionInfo__GetValue() {
		return transitionInfoEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSimulationParameters() {
		return simulationParametersEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		createEAttribute(placeInfoEClass, PLACE_INFO__MEAN_NUMBER_OF_TOKENS);
		createEOperation(placeInfoEClass, PLACE_INFO___GET_VALUE);

		transitionInfoEClass = createEClass(TRANSITION_INFO);
		createEAttribute(transitionInfoEClass, TRANSITION_INFO__THROUGHPUT);
		createEOperation(transitionInfoEClass, TRANSITION_INFO___GET_VALUE);

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
		ToolresultPackage theToolresultPackage = (ToolresultPackage)EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI);
		DatatypesPackage theDatatypesPackage = (DatatypesPackage)EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		wnsimResultEClass.getESuperTypes().add(theToolresultPackage.getToolResult());
		wnsimElementInfoEClass.getESuperTypes().add(theToolresultPackage.getAnalyzableElementInfo());
		placeInfoEClass.getESuperTypes().add(this.getWnsimElementInfo());
		transitionInfoEClass.getESuperTypes().add(this.getWnsimElementInfo());

		// Initialize classes, features, and operations; add parameters
		initEClass(wnsimResultEClass, WnsimResult.class, "WnsimResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wnsimElementInfoEClass, WnsimElementInfo.class, "WnsimElementInfo", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placeInfoEClass, PlaceInfo.class, "PlaceInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlaceInfo_MeanNumberOfTokens(), theDatatypesPackage.getNumber(), "meanNumberOfTokens", null, 0, 1, PlaceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPlaceInfo__GetValue(), theDatatypesPackage.getNumber(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(transitionInfoEClass, TransitionInfo.class, "TransitionInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransitionInfo_Throughput(), theDatatypesPackage.getNumber(), "throughput", null, 0, 1, TransitionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTransitionInfo__GetValue(), theDatatypesPackage.getNumber(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(simulationParametersEEnum, SimulationParameters.class, "SimulationParameters");
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.FIRST_TR_LENGTH);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.TR_LENGTH);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.MIN_BTC);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.MAX_BTC);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.APPROX);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.CONF_LEVEL);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.SEED);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.START);
		addEEnumLiteral(simulationParametersEEnum, SimulationParameters.BINARY_FILE_PATH);

		// Create resource
		createResource(eNS_URI);
	}

} //WnsimPackageImpl
