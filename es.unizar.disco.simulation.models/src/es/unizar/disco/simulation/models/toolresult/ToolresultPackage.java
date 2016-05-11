/**
 */
package es.unizar.disco.simulation.models.toolresult;

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
 * @see es.unizar.disco.simulation.models.toolresult.ToolresultFactory
 * @model kind="package"
 * @generated
 */
public interface ToolresultPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "toolresult";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/toolresult/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "toolresult";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ToolresultPackage eINSTANCE = es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.toolresult.impl.ToolResultImpl <em>Tool Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.toolresult.impl.ToolResultImpl
	 * @see es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl#getToolResult()
	 * @generated
	 */
	int TOOL_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_RESULT__TIMESTAMP = 0;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_RESULT__INFOS = 1;

	/**
	 * The number of structural features of the '<em>Tool Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_RESULT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Tool Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.toolresult.impl.AnalyzableElementInfoImpl <em>Analyzable Element Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.toolresult.impl.AnalyzableElementInfoImpl
	 * @see es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl#getAnalyzableElementInfo()
	 * @generated
	 */
	int ANALYZABLE_ELEMENT_INFO = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Analyzed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO__UNIT = 2;

	/**
	 * The number of structural features of the '<em>Analyzable Element Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Analyzable Element Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZABLE_ELEMENT_INFO_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.toolresult.ToolResult <em>Tool Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Result</em>'.
	 * @see es.unizar.disco.simulation.models.toolresult.ToolResult
	 * @generated
	 */
	EClass getToolResult();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.toolresult.ToolResult#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see es.unizar.disco.simulation.models.toolresult.ToolResult#getTimestamp()
	 * @see #getToolResult()
	 * @generated
	 */
	EAttribute getToolResult_Timestamp();

	/**
	 * Returns the meta object for the containment reference list '{@link es.unizar.disco.simulation.models.toolresult.ToolResult#getInfos <em>Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Infos</em>'.
	 * @see es.unizar.disco.simulation.models.toolresult.ToolResult#getInfos()
	 * @see #getToolResult()
	 * @generated
	 */
	EReference getToolResult_Infos();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo <em>Analyzable Element Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analyzable Element Info</em>'.
	 * @see es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo
	 * @generated
	 */
	EClass getAnalyzableElementInfo();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo#getValue()
	 * @see #getAnalyzableElementInfo()
	 * @generated
	 */
	EAttribute getAnalyzableElementInfo_Value();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo#getAnalyzedElement <em>Analyzed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Analyzed Element</em>'.
	 * @see es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo#getAnalyzedElement()
	 * @see #getAnalyzableElementInfo()
	 * @generated
	 */
	EReference getAnalyzableElementInfo_AnalyzedElement();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see es.unizar.disco.simulation.models.toolresult.AnalyzableElementInfo#getUnit()
	 * @see #getAnalyzableElementInfo()
	 * @generated
	 */
	EAttribute getAnalyzableElementInfo_Unit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ToolresultFactory getToolresultFactory();

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
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.toolresult.impl.ToolResultImpl <em>Tool Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.toolresult.impl.ToolResultImpl
		 * @see es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl#getToolResult()
		 * @generated
		 */
		EClass TOOL_RESULT = eINSTANCE.getToolResult();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_RESULT__TIMESTAMP = eINSTANCE.getToolResult_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Infos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL_RESULT__INFOS = eINSTANCE.getToolResult_Infos();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.toolresult.impl.AnalyzableElementInfoImpl <em>Analyzable Element Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.toolresult.impl.AnalyzableElementInfoImpl
		 * @see es.unizar.disco.simulation.models.toolresult.impl.ToolresultPackageImpl#getAnalyzableElementInfo()
		 * @generated
		 */
		EClass ANALYZABLE_ELEMENT_INFO = eINSTANCE.getAnalyzableElementInfo();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYZABLE_ELEMENT_INFO__VALUE = eINSTANCE.getAnalyzableElementInfo_Value();

		/**
		 * The meta object literal for the '<em><b>Analyzed Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYZABLE_ELEMENT_INFO__ANALYZED_ELEMENT = eINSTANCE.getAnalyzableElementInfo_AnalyzedElement();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYZABLE_ELEMENT_INFO__UNIT = eINSTANCE.getAnalyzableElementInfo_Unit();

	}

} //ToolresultPackage
