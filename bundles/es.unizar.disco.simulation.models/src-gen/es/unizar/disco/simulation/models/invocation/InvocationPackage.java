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
package es.unizar.disco.simulation.models.invocation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see es.unizar.disco.simulation.models.invocation.InvocationFactory
 * @model kind="package"
 * @generated
 */
public interface InvocationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "invocation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/invocation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "invocation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvocationPackage eINSTANCE = es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl <em>Simulation Invocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl
	 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getSimulationInvocation()
	 * @generated
	 */
	int SIMULATION_INVOCATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Trace Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__TRACE_SET = 1;

	/**
	 * The feature id for the '<em><b>Tool Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__TOOL_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__DEFINITION = 3;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__RESULT = 4;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__START = 5;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__END = 6;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__STATUS = 7;

	/**
	 * The feature id for the '<em><b>Variable Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__VARIABLE_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Analyzable Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__ANALYZABLE_MODEL = 9;

	/**
	 * The feature id for the '<em><b>Auto Build</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__AUTO_BUILD = 10;

	/**
	 * The feature id for the '<em><b>Invocation Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__INVOCATION_SET = 11;

	/**
	 * The number of structural features of the '<em>Simulation Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION_FEATURE_COUNT = 12;

	/**
	 * The operation id for the '<em>Build Analyzable Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION___BUILD_ANALYZABLE_MODEL = 0;

	/**
	 * The number of operations of the '<em>Simulation Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.invocation.impl.InvocationsRegistryImpl <em>Invocations Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationsRegistryImpl
	 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getInvocationsRegistry()
	 * @generated
	 */
	int INVOCATIONS_REGISTRY = 1;

	/**
	 * The feature id for the '<em><b>Invocation Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATIONS_REGISTRY__INVOCATION_SETS = 0;

	/**
	 * The number of structural features of the '<em>Invocations Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATIONS_REGISTRY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Invocations Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATIONS_REGISTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.invocation.impl.InvocationSetImpl <em>Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationSetImpl
	 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getInvocationSet()
	 * @generated
	 */
	int INVOCATION_SET = 2;

	/**
	 * The feature id for the '<em><b>Invocations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_SET__INVOCATIONS = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_SET__DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_SET__IDENTIFIER = 2;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_SET__START = 3;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_SET__END = 4;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_SET__STATUS = 5;

	/**
	 * The number of structural features of the '<em>Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_SET_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_SET_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation <em>Simulation Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Invocation</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation
	 * @generated
	 */
	EClass getSimulationInvocation();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getIdentifier()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EAttribute getSimulationInvocation_Identifier();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getTraceSet <em>Trace Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trace Set</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getTraceSet()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_TraceSet();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getToolResult <em>Tool Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tool Result</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getToolResult()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_ToolResult();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_Definition();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getResult()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_Result();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getStart()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EAttribute getSimulationInvocation_Start();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getEnd()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EAttribute getSimulationInvocation_End();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getStatus()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EAttribute getSimulationInvocation_Status();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getVariableConfiguration <em>Variable Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Configuration</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getVariableConfiguration()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_VariableConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getAnalyzableModel <em>Analyzable Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Analyzable Model</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getAnalyzableModel()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_AnalyzableModel();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#isAutoBuild <em>Auto Build</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Build</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#isAutoBuild()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EAttribute getSimulationInvocation_AutoBuild();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getInvocationSet <em>Invocation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Invocation Set</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getInvocationSet()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_InvocationSet();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#buildAnalyzableModel() <em>Build Analyzable Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Analyzable Model</em>' operation.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#buildAnalyzableModel()
	 * @generated
	 */
	EOperation getSimulationInvocation__BuildAnalyzableModel();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.invocation.InvocationsRegistry <em>Invocations Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocations Registry</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationsRegistry
	 * @generated
	 */
	EClass getInvocationsRegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.invocation.InvocationsRegistry#getInvocationSets <em>Invocation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invocation Sets</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationsRegistry#getInvocationSets()
	 * @see #getInvocationsRegistry()
	 * @generated
	 */
	EReference getInvocationsRegistry_InvocationSets();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.invocation.InvocationSet <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationSet
	 * @generated
	 */
	EClass getInvocationSet();

	/**
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invocations</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationSet#getInvocations()
	 * @see #getInvocationSet()
	 * @generated
	 */
	EReference getInvocationSet_Invocations();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationSet#getDefinition()
	 * @see #getInvocationSet()
	 * @generated
	 */
	EReference getInvocationSet_Definition();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationSet#getIdentifier()
	 * @see #getInvocationSet()
	 * @generated
	 */
	EAttribute getInvocationSet_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationSet#getStart()
	 * @see #getInvocationSet()
	 * @generated
	 */
	EAttribute getInvocationSet_Start();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationSet#getEnd()
	 * @see #getInvocationSet()
	 * @generated
	 */
	EAttribute getInvocationSet_End();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.InvocationSet#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.InvocationSet#getStatus()
	 * @see #getInvocationSet()
	 * @generated
	 */
	EAttribute getInvocationSet_Status();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InvocationFactory getInvocationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl <em>Simulation Invocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.invocation.impl.SimulationInvocationImpl
		 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getSimulationInvocation()
		 * @generated
		 */
		EClass SIMULATION_INVOCATION = eINSTANCE.getSimulationInvocation();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_INVOCATION__IDENTIFIER = eINSTANCE.getSimulationInvocation_Identifier();

		/**
		 * The meta object literal for the '<em><b>Trace Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__TRACE_SET = eINSTANCE.getSimulationInvocation_TraceSet();

		/**
		 * The meta object literal for the '<em><b>Tool Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__TOOL_RESULT = eINSTANCE.getSimulationInvocation_ToolResult();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__DEFINITION = eINSTANCE.getSimulationInvocation_Definition();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__RESULT = eINSTANCE.getSimulationInvocation_Result();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_INVOCATION__START = eINSTANCE.getSimulationInvocation_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_INVOCATION__END = eINSTANCE.getSimulationInvocation_End();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_INVOCATION__STATUS = eINSTANCE.getSimulationInvocation_Status();

		/**
		 * The meta object literal for the '<em><b>Variable Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__VARIABLE_CONFIGURATION = eINSTANCE.getSimulationInvocation_VariableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Analyzable Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__ANALYZABLE_MODEL = eINSTANCE.getSimulationInvocation_AnalyzableModel();

		/**
		 * The meta object literal for the '<em><b>Auto Build</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_INVOCATION__AUTO_BUILD = eINSTANCE.getSimulationInvocation_AutoBuild();

		/**
		 * The meta object literal for the '<em><b>Invocation Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__INVOCATION_SET = eINSTANCE.getSimulationInvocation_InvocationSet();

		/**
		 * The meta object literal for the '<em><b>Build Analyzable Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMULATION_INVOCATION___BUILD_ANALYZABLE_MODEL = eINSTANCE.getSimulationInvocation__BuildAnalyzableModel();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.invocation.impl.InvocationsRegistryImpl <em>Invocations Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationsRegistryImpl
		 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getInvocationsRegistry()
		 * @generated
		 */
		EClass INVOCATIONS_REGISTRY = eINSTANCE.getInvocationsRegistry();

		/**
		 * The meta object literal for the '<em><b>Invocation Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATIONS_REGISTRY__INVOCATION_SETS = eINSTANCE.getInvocationsRegistry_InvocationSets();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.invocation.impl.InvocationSetImpl <em>Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationSetImpl
		 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getInvocationSet()
		 * @generated
		 */
		EClass INVOCATION_SET = eINSTANCE.getInvocationSet();

		/**
		 * The meta object literal for the '<em><b>Invocations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION_SET__INVOCATIONS = eINSTANCE.getInvocationSet_Invocations();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION_SET__DEFINITION = eINSTANCE.getInvocationSet_Definition();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOCATION_SET__IDENTIFIER = eINSTANCE.getInvocationSet_Identifier();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOCATION_SET__START = eINSTANCE.getInvocationSet_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOCATION_SET__END = eINSTANCE.getInvocationSet_End();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOCATION_SET__STATUS = eINSTANCE.getInvocationSet_Status();

	}

} //InvocationPackage
