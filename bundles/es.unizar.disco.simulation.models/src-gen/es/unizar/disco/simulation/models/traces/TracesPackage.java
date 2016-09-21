/**
 */
package es.unizar.disco.simulation.models.traces;

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
 * @see es.unizar.disco.simulation.models.traces.TracesFactory
 * @model kind="package"
 * @generated
 */
public interface TracesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "traces";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/traces/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "traces";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracesPackage eINSTANCE = es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.traces.impl.TraceSetImpl <em>Trace Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.traces.impl.TraceSetImpl
	 * @see es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl#getTraceSet()
	 * @generated
	 */
	int TRACE_SET = 0;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SET__TRACES = 0;

	/**
	 * The number of structural features of the '<em>Trace Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Trace Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.traces.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.traces.impl.TraceImpl
	 * @see es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 1;

	/**
	 * The feature id for the '<em><b>From Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__FROM_DOMAIN_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>To Analyzable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TO_ANALYZABLE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__RULE = 2;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.traces.TraceSet <em>Trace Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Set</em>'.
	 * @see es.unizar.disco.simulation.models.traces.TraceSet
	 * @generated
	 */
	EClass getTraceSet();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.traces.TraceSet#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traces</em>'.
	 * @see es.unizar.disco.simulation.models.traces.TraceSet#getTraces()
	 * @see #getTraceSet()
	 * @generated
	 */
	EReference getTraceSet_Traces();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.traces.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see es.unizar.disco.simulation.models.traces.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.traces.Trace#getFromDomainElement <em>From Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Domain Element</em>'.
	 * @see es.unizar.disco.simulation.models.traces.Trace#getFromDomainElement()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_FromDomainElement();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.traces.Trace#getToAnalyzableElement <em>To Analyzable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Analyzable Element</em>'.
	 * @see es.unizar.disco.simulation.models.traces.Trace#getToAnalyzableElement()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_ToAnalyzableElement();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.traces.Trace#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see es.unizar.disco.simulation.models.traces.Trace#getRule()
	 * @see #getTrace()
	 * @generated
	 */
	EAttribute getTrace_Rule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TracesFactory getTracesFactory();

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
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.traces.impl.TraceSetImpl <em>Trace Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.traces.impl.TraceSetImpl
		 * @see es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl#getTraceSet()
		 * @generated
		 */
		EClass TRACE_SET = eINSTANCE.getTraceSet();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SET__TRACES = eINSTANCE.getTraceSet_Traces();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.traces.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.traces.impl.TraceImpl
		 * @see es.unizar.disco.simulation.models.traces.impl.TracesPackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>From Domain Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__FROM_DOMAIN_ELEMENT = eINSTANCE.getTrace_FromDomainElement();

		/**
		 * The meta object literal for the '<em><b>To Analyzable Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TO_ANALYZABLE_ELEMENT = eINSTANCE.getTrace_ToAnalyzableElement();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE__RULE = eINSTANCE.getTrace_Rule();

	}

} //TracesPackage
