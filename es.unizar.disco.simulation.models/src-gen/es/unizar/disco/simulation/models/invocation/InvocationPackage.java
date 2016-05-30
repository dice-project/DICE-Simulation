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
	 * The feature id for the '<em><b>Trace Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__TRACE_SET = 0;

	/**
	 * The feature id for the '<em><b>Tool Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__TOOL_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Variable Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__VARIABLE_ASSIGNMENTS = 2;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__DEFINITION = 3;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__CALLS = 4;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__RESULTS = 5;

	/**
	 * The feature id for the '<em><b>Analyzable Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION__ANALYZABLE_RESOURCE = 6;

	/**
	 * The number of structural features of the '<em>Simulation Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Simulation Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_INVOCATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.invocation.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.invocation.impl.VariableAssignmentImpl
	 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getVariableAssignment()
	 * @generated
	 */
	int VARIABLE_ASSIGNMENT = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.invocation.impl.SimulationToolImpl <em>Simulation Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.invocation.impl.SimulationToolImpl
	 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getSimulationTool()
	 * @generated
	 */
	int SIMULATION_TOOL = 2;

	/**
	 * The feature id for the '<em><b>Produces</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_TOOL__PRODUCES = 0;

	/**
	 * The number of structural features of the '<em>Simulation Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_TOOL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Simulation Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_TOOL_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getVariableAssignments <em>Variable Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Assignments</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getVariableAssignments()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_VariableAssignments();

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
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Calls</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getCalls()
	 * @see #getSimulationInvocation()
	 * @generated
	 */
	EReference getSimulationInvocation_Calls();

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
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.invocation.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.VariableAssignment
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.VariableAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.VariableAssignment#getVariable()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Variable();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.invocation.VariableAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.VariableAssignment#getValue()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EAttribute getVariableAssignment_Value();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.invocation.SimulationTool <em>Simulation Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Tool</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationTool
	 * @generated
	 */
	EClass getSimulationTool();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.invocation.SimulationTool#getProduces <em>Produces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Produces</em>'.
	 * @see es.unizar.disco.simulation.models.invocation.SimulationTool#getProduces()
	 * @see #getSimulationTool()
	 * @generated
	 */
	EReference getSimulationTool_Produces();

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
		 * The meta object literal for the '<em><b>Variable Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__VARIABLE_ASSIGNMENTS = eINSTANCE.getSimulationInvocation_VariableAssignments();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__DEFINITION = eINSTANCE.getSimulationInvocation_Definition();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_INVOCATION__CALLS = eINSTANCE.getSimulationInvocation_Calls();

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
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.invocation.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.invocation.impl.VariableAssignmentImpl
		 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__VARIABLE = eINSTANCE.getVariableAssignment_Variable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_ASSIGNMENT__VALUE = eINSTANCE.getVariableAssignment_Value();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.invocation.impl.SimulationToolImpl <em>Simulation Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.invocation.impl.SimulationToolImpl
		 * @see es.unizar.disco.simulation.models.invocation.impl.InvocationPackageImpl#getSimulationTool()
		 * @generated
		 */
		EClass SIMULATION_TOOL = eINSTANCE.getSimulationTool();

		/**
		 * The meta object literal for the '<em><b>Produces</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_TOOL__PRODUCES = eINSTANCE.getSimulationTool_Produces();

	}

} //InvocationPackage
