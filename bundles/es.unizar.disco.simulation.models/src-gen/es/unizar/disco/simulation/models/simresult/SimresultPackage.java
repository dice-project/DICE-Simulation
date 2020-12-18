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
package es.unizar.disco.simulation.models.simresult;

import org.eclipse.emf.ecore.EClass;
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
 * @see es.unizar.disco.simulation.models.simresult.SimresultFactory
 * @model kind="package"
 * @generated
 */
public interface SimresultPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simresult";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/simresult/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simresult";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimresultPackage eINSTANCE = es.unizar.disco.simulation.models.simresult.impl.SimresultPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.simresult.impl.SimulationResultImpl <em>Simulation Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.simresult.impl.SimulationResultImpl
	 * @see es.unizar.disco.simulation.models.simresult.impl.SimresultPackageImpl#getSimulationResult()
	 * @generated
	 */
	int SIMULATION_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Invocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_RESULT__INVOCATION = 0;

	/**
	 * The feature id for the '<em><b>Measures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_RESULT__MEASURES = 1;

	/**
	 * The number of structural features of the '<em>Simulation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_RESULT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Simulation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_RESULT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.simresult.SimulationResult <em>Simulation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Result</em>'.
	 * @see es.unizar.disco.simulation.models.simresult.SimulationResult
	 * @generated
	 */
	EClass getSimulationResult();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.simresult.SimulationResult#getInvocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Invocation</em>'.
	 * @see es.unizar.disco.simulation.models.simresult.SimulationResult#getInvocation()
	 * @see #getSimulationResult()
	 * @generated
	 */
	EReference getSimulationResult_Invocation();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.simresult.SimulationResult#getMeasures <em>Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measures</em>'.
	 * @see es.unizar.disco.simulation.models.simresult.SimulationResult#getMeasures()
	 * @see #getSimulationResult()
	 * @generated
	 */
	EReference getSimulationResult_Measures();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimresultFactory getSimresultFactory();

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
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.simresult.impl.SimulationResultImpl <em>Simulation Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.simresult.impl.SimulationResultImpl
		 * @see es.unizar.disco.simulation.models.simresult.impl.SimresultPackageImpl#getSimulationResult()
		 * @generated
		 */
		EClass SIMULATION_RESULT = eINSTANCE.getSimulationResult();

		/**
		 * The meta object literal for the '<em><b>Invocation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_RESULT__INVOCATION = eINSTANCE.getSimulationResult_Invocation();

		/**
		 * The meta object literal for the '<em><b>Measures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_RESULT__MEASURES = eINSTANCE.getSimulationResult_Measures();

	}

} //SimresultPackage
