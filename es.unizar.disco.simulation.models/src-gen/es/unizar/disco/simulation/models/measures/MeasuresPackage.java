/**
 */
package es.unizar.disco.simulation.models.measures;

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
 * @see es.unizar.disco.simulation.models.measures.MeasuresFactory
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
	MeasuresPackage eINSTANCE = es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureImpl <em>Domain Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.measures.impl.DomainMeasureImpl
	 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getDomainMeasure()
	 * @generated
	 */
	int DOMAIN_MEASURE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE__MEASURED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE__UNIT = 2;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE__OUTPUT_VARIABLE = 3;

	/**
	 * The number of structural features of the '<em>Domain Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Domain Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.measures.impl.ThroughputImpl <em>Throughput</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.measures.impl.ThroughputImpl
	 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getThroughput()
	 * @generated
	 */
	int THROUGHPUT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT__VALUE = DOMAIN_MEASURE__VALUE;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT__MEASURED_ELEMENT = DOMAIN_MEASURE__MEASURED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT__UNIT = DOMAIN_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT__OUTPUT_VARIABLE = DOMAIN_MEASURE__OUTPUT_VARIABLE;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT__THROUGHPUT = DOMAIN_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Throughput</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT_FEATURE_COUNT = DOMAIN_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT___GET_VALUE = DOMAIN_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Throughput</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROUGHPUT_OPERATION_COUNT = DOMAIN_MEASURE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.measures.impl.ResponseTimeImpl <em>Response Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.measures.impl.ResponseTimeImpl
	 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getResponseTime()
	 * @generated
	 */
	int RESPONSE_TIME = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__VALUE = DOMAIN_MEASURE__VALUE;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__MEASURED_ELEMENT = DOMAIN_MEASURE__MEASURED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__UNIT = DOMAIN_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__OUTPUT_VARIABLE = DOMAIN_MEASURE__OUTPUT_VARIABLE;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__RESPONSE_TIME = DOMAIN_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Response Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_FEATURE_COUNT = DOMAIN_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME___GET_VALUE = DOMAIN_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Response Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_OPERATION_COUNT = DOMAIN_MEASURE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.measures.impl.UtilizationImpl <em>Utilization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.measures.impl.UtilizationImpl
	 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getUtilization()
	 * @generated
	 */
	int UTILIZATION = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION__VALUE = DOMAIN_MEASURE__VALUE;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION__MEASURED_ELEMENT = DOMAIN_MEASURE__MEASURED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION__UNIT = DOMAIN_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION__OUTPUT_VARIABLE = DOMAIN_MEASURE__OUTPUT_VARIABLE;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION__UTILIZATION = DOMAIN_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Utilization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION_FEATURE_COUNT = DOMAIN_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION___GET_VALUE = DOMAIN_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Utilization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILIZATION_OPERATION_COUNT = DOMAIN_MEASURE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.measures.MeasureConverter <em>Measure Converter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.measures.MeasureConverter
	 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getMeasureConverter()
	 * @generated
	 */
	int MEASURE_CONVERTER = 4;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER__TO = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER__FROM = 1;

	/**
	 * The number of structural features of the '<em>Measure Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Convert</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER___CONVERT = 0;

	/**
	 * The number of operations of the '<em>Measure Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CONVERTER_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.measures.DomainMeasure <em>Domain Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Measure</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasure
	 * @generated
	 */
	EClass getDomainMeasure();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasure#getValue()
	 * @see #getDomainMeasure()
	 * @generated
	 */
	EAttribute getDomainMeasure_Value();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getMeasuredElement <em>Measured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Measured Element</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasure#getMeasuredElement()
	 * @see #getDomainMeasure()
	 * @generated
	 */
	EReference getDomainMeasure_MeasuredElement();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasure#getUnit()
	 * @see #getDomainMeasure()
	 * @generated
	 */
	EAttribute getDomainMeasure_Unit();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getOutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Variable</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasure#getOutputVariable()
	 * @see #getDomainMeasure()
	 * @generated
	 */
	EReference getDomainMeasure_OutputVariable();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.measures.Throughput <em>Throughput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throughput</em>'.
	 * @see es.unizar.disco.simulation.models.measures.Throughput
	 * @generated
	 */
	EClass getThroughput();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.measures.Throughput#getThroughput <em>Throughput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throughput</em>'.
	 * @see es.unizar.disco.simulation.models.measures.Throughput#getThroughput()
	 * @see #getThroughput()
	 * @generated
	 */
	EAttribute getThroughput_Throughput();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.measures.Throughput#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see es.unizar.disco.simulation.models.measures.Throughput#getValue()
	 * @generated
	 */
	EOperation getThroughput__GetValue();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.measures.ResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response Time</em>'.
	 * @see es.unizar.disco.simulation.models.measures.ResponseTime
	 * @generated
	 */
	EClass getResponseTime();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.measures.ResponseTime#getResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Time</em>'.
	 * @see es.unizar.disco.simulation.models.measures.ResponseTime#getResponseTime()
	 * @see #getResponseTime()
	 * @generated
	 */
	EAttribute getResponseTime_ResponseTime();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.measures.ResponseTime#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see es.unizar.disco.simulation.models.measures.ResponseTime#getValue()
	 * @generated
	 */
	EOperation getResponseTime__GetValue();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.measures.Utilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Utilization</em>'.
	 * @see es.unizar.disco.simulation.models.measures.Utilization
	 * @generated
	 */
	EClass getUtilization();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.measures.Utilization#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization</em>'.
	 * @see es.unizar.disco.simulation.models.measures.Utilization#getUtilization()
	 * @see #getUtilization()
	 * @generated
	 */
	EAttribute getUtilization_Utilization();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.measures.Utilization#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see es.unizar.disco.simulation.models.measures.Utilization#getValue()
	 * @generated
	 */
	EOperation getUtilization__GetValue();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.measures.MeasureConverter <em>Measure Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Converter</em>'.
	 * @see es.unizar.disco.simulation.models.measures.MeasureConverter
	 * @generated
	 */
	EClass getMeasureConverter();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.measures.MeasureConverter#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see es.unizar.disco.simulation.models.measures.MeasureConverter#getTo()
	 * @see #getMeasureConverter()
	 * @generated
	 */
	EReference getMeasureConverter_To();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.measures.MeasureConverter#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see es.unizar.disco.simulation.models.measures.MeasureConverter#getFrom()
	 * @see #getMeasureConverter()
	 * @generated
	 */
	EReference getMeasureConverter_From();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.measures.MeasureConverter#convert() <em>Convert</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Convert</em>' operation.
	 * @see es.unizar.disco.simulation.models.measures.MeasureConverter#convert()
	 * @generated
	 */
	EOperation getMeasureConverter__Convert();

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
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureImpl <em>Domain Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.measures.impl.DomainMeasureImpl
		 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getDomainMeasure()
		 * @generated
		 */
		EClass DOMAIN_MEASURE = eINSTANCE.getDomainMeasure();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MEASURE__VALUE = eINSTANCE.getDomainMeasure_Value();

		/**
		 * The meta object literal for the '<em><b>Measured Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_MEASURE__MEASURED_ELEMENT = eINSTANCE.getDomainMeasure_MeasuredElement();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MEASURE__UNIT = eINSTANCE.getDomainMeasure_Unit();

		/**
		 * The meta object literal for the '<em><b>Output Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_MEASURE__OUTPUT_VARIABLE = eINSTANCE.getDomainMeasure_OutputVariable();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.measures.impl.ThroughputImpl <em>Throughput</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.measures.impl.ThroughputImpl
		 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getThroughput()
		 * @generated
		 */
		EClass THROUGHPUT = eINSTANCE.getThroughput();

		/**
		 * The meta object literal for the '<em><b>Throughput</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROUGHPUT__THROUGHPUT = eINSTANCE.getThroughput_Throughput();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THROUGHPUT___GET_VALUE = eINSTANCE.getThroughput__GetValue();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.measures.impl.ResponseTimeImpl <em>Response Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.measures.impl.ResponseTimeImpl
		 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getResponseTime()
		 * @generated
		 */
		EClass RESPONSE_TIME = eINSTANCE.getResponseTime();

		/**
		 * The meta object literal for the '<em><b>Response Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE_TIME__RESPONSE_TIME = eINSTANCE.getResponseTime_ResponseTime();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RESPONSE_TIME___GET_VALUE = eINSTANCE.getResponseTime__GetValue();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.measures.impl.UtilizationImpl <em>Utilization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.measures.impl.UtilizationImpl
		 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getUtilization()
		 * @generated
		 */
		EClass UTILIZATION = eINSTANCE.getUtilization();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILIZATION__UTILIZATION = eINSTANCE.getUtilization_Utilization();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UTILIZATION___GET_VALUE = eINSTANCE.getUtilization__GetValue();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.measures.MeasureConverter <em>Measure Converter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.measures.MeasureConverter
		 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getMeasureConverter()
		 * @generated
		 */
		EClass MEASURE_CONVERTER = eINSTANCE.getMeasureConverter();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_CONVERTER__TO = eINSTANCE.getMeasureConverter_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_CONVERTER__FROM = eINSTANCE.getMeasureConverter_From();

		/**
		 * The meta object literal for the '<em><b>Convert</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASURE_CONVERTER___CONVERT = eINSTANCE.getMeasureConverter__Convert();

	}

} //MeasuresPackage
