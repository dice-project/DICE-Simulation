/**
 */
package es.unizar.disco.simulation.models.invocation;

import org.eclipse.emf.ecore.EAttribute;
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
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__RESULTS = 4;

	/**
	 * The feature id for the '<em><b>Analyzable Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__ANALYZABLE_RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__START = 6;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__END = 7;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__STATUS = 8;

	/**
	 * The feature id for the '<em><b>Domain Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__DOMAIN_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Variable Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__VARIABLE_CONFIGURATION = 10;

	/**
	 * The number of structural features of the '<em>Simulation Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Simulation Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the reference list '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Results</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getResults()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_Results();

	/**
	 * Returns the meta object for the containment reference '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getAnalyzableResource <em>Analyzable Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analyzable Resource</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getAnalyzableResource()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_AnalyzableResource();

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
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDomainResource <em>Domain Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Resource</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDomainResource()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EAttribute getSimulationInvocation_DomainResource();

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
		 * The meta object literal for the '<em><b>Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__RESULTS = eINSTANCE.getSimulationInvocation_Results();

		/**
		 * The meta object literal for the '<em><b>Analyzable Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__ANALYZABLE_RESOURCE = eINSTANCE.getSimulationInvocation_AnalyzableResource();

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
		 * The meta object literal for the '<em><b>Domain Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_INVOCATION__DOMAIN_RESOURCE = eINSTANCE.getSimulationInvocation_DomainResource();

		/**
		 * The meta object literal for the '<em><b>Variable Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__VARIABLE_CONFIGURATION = eINSTANCE.getSimulationInvocation_VariableConfiguration();

	}

} //InvocationPackage
