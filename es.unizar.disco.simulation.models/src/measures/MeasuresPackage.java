/**
 */
package measures;

import configuration.ConfigurationPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see measures.MeasuresFactory
 * @model kind="package"
 * @generated
 */
public interface MeasuresPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "measures";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/measures/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "measures";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeasuresPackage eINSTANCE = measures.impl.MeasuresPackageImpl.init();

	/**
	 * The meta object id for the '{@link measures.impl.ThroughputImpl <em>Throughput</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measures.impl.ThroughputImpl
	 * @see measures.impl.MeasuresPackageImpl#getThroughput()
	 * @generated
	 */
	int THROUGHPUT = 0;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT__MEASURED_ELEMENT = ConfigurationPackage.DOMAIN_MEASURE__MEASURED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT__VALUE = ConfigurationPackage.DOMAIN_MEASURE__VALUE;

	/**
	 * The number of structural features of the '<em>Throughput</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT_FEATURE_COUNT = ConfigurationPackage.DOMAIN_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Throughput</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT_OPERATION_COUNT = ConfigurationPackage.DOMAIN_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link measures.impl.ResponseTimeImpl <em>Response Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measures.impl.ResponseTimeImpl
	 * @see measures.impl.MeasuresPackageImpl#getResponseTime()
	 * @generated
	 */
	int RESPONSE_TIME = 1;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__MEASURED_ELEMENT = ConfigurationPackage.DOMAIN_MEASURE__MEASURED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__VALUE = ConfigurationPackage.DOMAIN_MEASURE__VALUE;

	/**
	 * The number of structural features of the '<em>Response Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_FEATURE_COUNT = ConfigurationPackage.DOMAIN_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Response Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_OPERATION_COUNT = ConfigurationPackage.DOMAIN_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link measures.impl.UtilizationImpl <em>Utilization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measures.impl.UtilizationImpl
	 * @see measures.impl.MeasuresPackageImpl#getUtilization()
	 * @generated
	 */
	int UTILIZATION = 2;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION__MEASURED_ELEMENT = ConfigurationPackage.DOMAIN_MEASURE__MEASURED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION__VALUE = ConfigurationPackage.DOMAIN_MEASURE__VALUE;

	/**
	 * The number of structural features of the '<em>Utilization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION_FEATURE_COUNT = ConfigurationPackage.DOMAIN_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Utilization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION_OPERATION_COUNT = ConfigurationPackage.DOMAIN_MEASURE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link measures.Throughput <em>Throughput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throughput</em>'.
	 * @see measures.Throughput
	 * @generated
	 */
	EClass getThroughput();

	/**
	 * Returns the meta object for class '{@link measures.ResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response Time</em>'.
	 * @see measures.ResponseTime
	 * @generated
	 */
	EClass getResponseTime();

	/**
	 * Returns the meta object for class '{@link measures.Utilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Utilization</em>'.
	 * @see measures.Utilization
	 * @generated
	 */
	EClass getUtilization();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MeasuresFactory getMeasuresFactory();

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
		 * The meta object literal for the '{@link measures.impl.ThroughputImpl <em>Throughput</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measures.impl.ThroughputImpl
		 * @see measures.impl.MeasuresPackageImpl#getThroughput()
		 * @generated
		 */
		EClass THROUGHPUT = eINSTANCE.getThroughput();

		/**
		 * The meta object literal for the '{@link measures.impl.ResponseTimeImpl <em>Response Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measures.impl.ResponseTimeImpl
		 * @see measures.impl.MeasuresPackageImpl#getResponseTime()
		 * @generated
		 */
		EClass RESPONSE_TIME = eINSTANCE.getResponseTime();

		/**
		 * The meta object literal for the '{@link measures.impl.UtilizationImpl <em>Utilization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measures.impl.UtilizationImpl
		 * @see measures.impl.MeasuresPackageImpl#getUtilization()
		 * @generated
		 */
		EClass UTILIZATION = eINSTANCE.getUtilization();

	}

} //MeasuresPackage
