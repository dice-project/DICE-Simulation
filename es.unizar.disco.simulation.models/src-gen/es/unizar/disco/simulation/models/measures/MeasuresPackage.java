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
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE__UNIT = 1;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE__DEFINITION = 2;

	/**
	 * The number of structural features of the '<em>Domain Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Domain Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.measures.MeasureCalculator <em>Measure Calculator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.measures.MeasureCalculator
	 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getMeasureCalculator()
	 * @generated
	 */
	int MEASURE_CALCULATOR = 1;

	/**
	 * The number of structural features of the '<em>Measure Calculator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CALCULATOR_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Calculate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CALCULATOR___CALCULATE__EOBJECT_TRACESET = 0;

	/**
	 * The number of operations of the '<em>Measure Calculator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CALCULATOR_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl <em>Domain Measure Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl
	 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getDomainMeasureDefinition()
	 * @generated
	 */
	int DOMAIN_MEASURE_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Measured Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_DEFINITION__MEASURE = 1;

	/**
	 * The feature id for the '<em><b>Vsl Expression Entries</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES = 2;

	/**
	 * The feature id for the '<em><b>Vsl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_DEFINITION__OUTPUT_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Simulation Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION = 5;

	/**
	 * The number of structural features of the '<em>Domain Measure Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_DEFINITION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Domain Measure Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MEASURE_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.measures.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.measures.impl.EntryImpl
	 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.measures.DomainMeasure#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasure#getDefinition()
	 * @see #getDomainMeasure()
	 * @generated
	 */
	EReference getDomainMeasure_Definition();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.measures.MeasureCalculator <em>Measure Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Calculator</em>'.
	 * @see es.unizar.disco.simulation.models.measures.MeasureCalculator
	 * @model instanceClass="es.unizar.disco.simulation.models.measures.MeasureCalculator"
	 * @generated
	 */
	EClass getMeasureCalculator();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.simulation.models.measures.MeasureCalculator#calculate(org.eclipse.emf.ecore.EObject, es.unizar.disco.simulation.models.toolresult.ToolResult, es.unizar.disco.simulation.models.traces.TraceSet) <em>Calculate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Calculate</em>' operation.
	 * @see es.unizar.disco.simulation.models.measures.MeasureCalculator#calculate(org.eclipse.emf.ecore.EObject, es.unizar.disco.simulation.models.toolresult.ToolResult, es.unizar.disco.simulation.models.traces.TraceSet)
	 * @generated
	 */
	EOperation getMeasureCalculator__Calculate__EObject_TraceSet();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition <em>Domain Measure Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Measure Definition</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasureDefinition
	 * @generated
	 */
	EClass getDomainMeasureDefinition();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getMeasuredElement <em>Measured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Measured Element</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getMeasuredElement()
	 * @see #getDomainMeasureDefinition()
	 * @generated
	 */
	EReference getDomainMeasureDefinition_MeasuredElement();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getMeasure()
	 * @see #getDomainMeasureDefinition()
	 * @generated
	 */
	EAttribute getDomainMeasureDefinition_Measure();

	/**
	 * Returns the meta object for the map '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getVslExpressionEntries <em>Vsl Expression Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Vsl Expression Entries</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getVslExpressionEntries()
	 * @see #getDomainMeasureDefinition()
	 * @generated
	 */
	EReference getDomainMeasureDefinition_VslExpressionEntries();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getVslExpression <em>Vsl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vsl Expression</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getVslExpression()
	 * @see #getDomainMeasureDefinition()
	 * @generated
	 */
	EAttribute getDomainMeasureDefinition_VslExpression();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getOutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Variable</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getOutputVariable()
	 * @see #getDomainMeasureDefinition()
	 * @generated
	 */
	EReference getDomainMeasureDefinition_OutputVariable();

	/**
	 * Returns the meta object for the container reference '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getSimulationDefinition <em>Simulation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Simulation Definition</em>'.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getSimulationDefinition()
	 * @see #getDomainMeasureDefinition()
	 * @generated
	 */
	EReference getDomainMeasureDefinition_SimulationDefinition();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EString" valueRequired="true"
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Value();

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
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MEASURE__UNIT = eINSTANCE.getDomainMeasure_Unit();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_MEASURE__DEFINITION = eINSTANCE.getDomainMeasure_Definition();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.measures.MeasureCalculator <em>Measure Calculator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.measures.MeasureCalculator
		 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getMeasureCalculator()
		 * @generated
		 */
		EClass MEASURE_CALCULATOR = eINSTANCE.getMeasureCalculator();

		/**
		 * The meta object literal for the '<em><b>Calculate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASURE_CALCULATOR___CALCULATE__EOBJECT_TRACESET = eINSTANCE.getMeasureCalculator__Calculate__EObject_TraceSet();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl <em>Domain Measure Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl
		 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getDomainMeasureDefinition()
		 * @generated
		 */
		EClass DOMAIN_MEASURE_DEFINITION = eINSTANCE.getDomainMeasureDefinition();

		/**
		 * The meta object literal for the '<em><b>Measured Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT = eINSTANCE.getDomainMeasureDefinition_MeasuredElement();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MEASURE_DEFINITION__MEASURE = eINSTANCE.getDomainMeasureDefinition_Measure();

		/**
		 * The meta object literal for the '<em><b>Vsl Expression Entries</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES = eINSTANCE.getDomainMeasureDefinition_VslExpressionEntries();

		/**
		 * The meta object literal for the '<em><b>Vsl Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION = eINSTANCE.getDomainMeasureDefinition_VslExpression();

		/**
		 * The meta object literal for the '<em><b>Output Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_MEASURE_DEFINITION__OUTPUT_VARIABLE = eINSTANCE.getDomainMeasureDefinition_OutputVariable();

		/**
		 * The meta object literal for the '<em><b>Simulation Definition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION = eINSTANCE.getDomainMeasureDefinition_SimulationDefinition();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.measures.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.measures.impl.EntryImpl
		 * @see es.unizar.disco.simulation.models.measures.impl.MeasuresPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__KEY = eINSTANCE.getEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__VALUE = eINSTANCE.getEntry_Value();

	}

} //MeasuresPackage
