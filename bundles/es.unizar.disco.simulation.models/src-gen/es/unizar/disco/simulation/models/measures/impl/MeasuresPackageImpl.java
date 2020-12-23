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
package es.unizar.disco.simulation.models.measures.impl;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;

import es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;

import es.unizar.disco.simulation.models.definition.impl.DefinitionPackageImpl;

import es.unizar.disco.simulation.models.invocation.InvocationPackage;

import es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl;

import es.unizar.disco.simulation.models.measures.DomainMeasure;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasureCalculator;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import es.unizar.disco.simulation.models.simresult.SimresultPackage;

import es.unizar.disco.simulation.models.simresult.impl.SimresultPackageImpl;

import es.unizar.disco.simulation.models.toolresult.ToolresultPackage;

import es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl;

import es.unizar.disco.simulation.models.traces.TracesPackage;

import es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl;

import es.unizar.disco.simulation.models.wnsim.WnsimPackage;

import es.unizar.disco.simulation.models.wnsim.impl.WnsimPackageImpl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeasuresPackageImpl extends EPackageImpl implements MeasuresPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainMeasureDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryEClass = null;

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
	 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MeasuresPackageImpl() {
		super(eNS_URI, MeasuresFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MeasuresPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MeasuresPackage init() {
		if (isInited) return (MeasuresPackage)EPackage.Registry.INSTANCE.getEPackage(MeasuresPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMeasuresPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MeasuresPackageImpl theMeasuresPackage = registeredMeasuresPackage instanceof MeasuresPackageImpl ? (MeasuresPackageImpl)registeredMeasuresPackage : new MeasuresPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(registeredPackage instanceof DatatypesPackageImpl ? registeredPackage : DatatypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI);
		DefinitionPackageImpl theDefinitionPackage = (DefinitionPackageImpl)(registeredPackage instanceof DefinitionPackageImpl ? registeredPackage : DefinitionPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InvocationPackage.eNS_URI);
		InvocationPackageImpl theInvocationPackage = (InvocationPackageImpl)(registeredPackage instanceof InvocationPackageImpl ? registeredPackage : InvocationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SimresultPackage.eNS_URI);
		SimresultPackageImpl theSimresultPackage = (SimresultPackageImpl)(registeredPackage instanceof SimresultPackageImpl ? registeredPackage : SimresultPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI);
		ToolresultPackageImpl theToolresultPackage = (ToolresultPackageImpl)(registeredPackage instanceof ToolresultPackageImpl ? registeredPackage : ToolresultPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI);
		TracesPackageImpl theTracesPackage = (TracesPackageImpl)(registeredPackage instanceof TracesPackageImpl ? registeredPackage : TracesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(WnsimPackage.eNS_URI);
		WnsimPackageImpl theWnsimPackage = (WnsimPackageImpl)(registeredPackage instanceof WnsimPackageImpl ? registeredPackage : WnsimPackage.eINSTANCE);

		// Create package meta-data objects
		theMeasuresPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theDefinitionPackage.createPackageContents();
		theInvocationPackage.createPackageContents();
		theSimresultPackage.createPackageContents();
		theToolresultPackage.createPackageContents();
		theTracesPackage.createPackageContents();
		theWnsimPackage.createPackageContents();

		// Initialize created meta-data
		theMeasuresPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theDefinitionPackage.initializePackageContents();
		theInvocationPackage.initializePackageContents();
		theSimresultPackage.initializePackageContents();
		theToolresultPackage.initializePackageContents();
		theTracesPackage.initializePackageContents();
		theWnsimPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMeasuresPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MeasuresPackage.eNS_URI, theMeasuresPackage);
		return theMeasuresPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainMeasure() {
		return domainMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainMeasure_Value() {
		return (EAttribute)domainMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainMeasure_Unit() {
		return (EAttribute)domainMeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainMeasure_Definition() {
		return (EReference)domainMeasureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMeasureCalculator() {
		return measureCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMeasureCalculator__Calculate__EObject_DomainMeasureDefinition_ToolResult_TraceSet() {
		return measureCalculatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainMeasureDefinition() {
		return domainMeasureDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainMeasureDefinition_MeasuredElement() {
		return (EReference)domainMeasureDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainMeasureDefinition_Measure() {
		return (EAttribute)domainMeasureDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainMeasureDefinition_VslExpressionEntries() {
		return (EReference)domainMeasureDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainMeasureDefinition_VslExpression() {
		return (EAttribute)domainMeasureDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainMeasureDefinition_OutputVariable() {
		return (EReference)domainMeasureDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainMeasureDefinition_SimulationDefinition() {
		return (EReference)domainMeasureDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainMeasureDefinition_SlaVslExpression() {
		return (EAttribute)domainMeasureDefinitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntry() {
		return entryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntry_Key() {
		return (EAttribute)entryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntry_Value() {
		return (EAttribute)entryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MeasuresFactory getMeasuresFactory() {
		return (MeasuresFactory)getEFactoryInstance();
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
		domainMeasureEClass = createEClass(DOMAIN_MEASURE);
		createEAttribute(domainMeasureEClass, DOMAIN_MEASURE__VALUE);
		createEAttribute(domainMeasureEClass, DOMAIN_MEASURE__UNIT);
		createEReference(domainMeasureEClass, DOMAIN_MEASURE__DEFINITION);

		measureCalculatorEClass = createEClass(MEASURE_CALCULATOR);
		createEOperation(measureCalculatorEClass, MEASURE_CALCULATOR___CALCULATE__EOBJECT_DOMAINMEASUREDEFINITION_TOOLRESULT_TRACESET);

		domainMeasureDefinitionEClass = createEClass(DOMAIN_MEASURE_DEFINITION);
		createEReference(domainMeasureDefinitionEClass, DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT);
		createEAttribute(domainMeasureDefinitionEClass, DOMAIN_MEASURE_DEFINITION__MEASURE);
		createEReference(domainMeasureDefinitionEClass, DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES);
		createEAttribute(domainMeasureDefinitionEClass, DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION);
		createEReference(domainMeasureDefinitionEClass, DOMAIN_MEASURE_DEFINITION__OUTPUT_VARIABLE);
		createEReference(domainMeasureDefinitionEClass, DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION);
		createEAttribute(domainMeasureDefinitionEClass, DOMAIN_MEASURE_DEFINITION__SLA_VSL_EXPRESSION);

		entryEClass = createEClass(ENTRY);
		createEAttribute(entryEClass, ENTRY__KEY);
		createEAttribute(entryEClass, ENTRY__VALUE);
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
		ToolresultPackage theToolresultPackage = (ToolresultPackage)EPackage.Registry.INSTANCE.getEPackage(ToolresultPackage.eNS_URI);
		TracesPackage theTracesPackage = (TracesPackage)EPackage.Registry.INSTANCE.getEPackage(TracesPackage.eNS_URI);
		DefinitionPackage theDefinitionPackage = (DefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(DefinitionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(domainMeasureEClass, DomainMeasure.class, "DomainMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainMeasure_Value(), theDatatypesPackage.getNumber(), "value", null, 1, 1, DomainMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainMeasure_Unit(), ecorePackage.getEString(), "unit", "unspecified", 1, 1, DomainMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainMeasure_Definition(), this.getDomainMeasureDefinition(), null, "definition", null, 1, 1, DomainMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measureCalculatorEClass, MeasureCalculator.class, "MeasureCalculator", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getMeasureCalculator__Calculate__EObject_DomainMeasureDefinition_ToolResult_TraceSet(), this.getDomainMeasure(), "calculate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "domainElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomainMeasureDefinition(), "definition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theToolresultPackage.getToolResult(), "toolResult", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTracesPackage.getTraceSet(), "traceSet", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(domainMeasureDefinitionEClass, DomainMeasureDefinition.class, "DomainMeasureDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainMeasureDefinition_MeasuredElement(), ecorePackage.getEObject(), null, "measuredElement", null, 1, 1, DomainMeasureDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainMeasureDefinition_Measure(), ecorePackage.getEString(), "measure", null, 1, 1, DomainMeasureDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainMeasureDefinition_VslExpressionEntries(), this.getEntry(), null, "vslExpressionEntries", null, 0, -1, DomainMeasureDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainMeasureDefinition_VslExpression(), ecorePackage.getEString(), "vslExpression", null, 1, 1, DomainMeasureDefinition.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainMeasureDefinition_OutputVariable(), theDefinitionPackage.getOutputVariable(), null, "outputVariable", null, 1, 1, DomainMeasureDefinition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDomainMeasureDefinition_SimulationDefinition(), theDefinitionPackage.getSimulationDefinition(), theDefinitionPackage.getSimulationDefinition_DeclaredMeasures(), "simulationDefinition", null, 1, 1, DomainMeasureDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainMeasureDefinition_SlaVslExpression(), ecorePackage.getEString(), "slaVslExpression", null, 0, 1, DomainMeasureDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entryEClass, Map.Entry.class, "Entry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntry_Value(), ecorePackage.getEString(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MeasuresPackageImpl
