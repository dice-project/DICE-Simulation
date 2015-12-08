/**
 */
package es.unizar.disco.pnconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see es.unizar.disco.pnconfig.PnconfigFactory
 * @model kind="package"
 * @generated
 */
public interface PnconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pnconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/pnconfig/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pnconfig";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PnconfigPackage eINSTANCE = es.unizar.disco.pnconfig.impl.PnconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnconfig.impl.PetriNetConfigImpl <em>Petri Net Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnconfig.impl.PetriNetConfigImpl
	 * @see es.unizar.disco.pnconfig.impl.PnconfigPackageImpl#getPetriNetConfig()
	 * @generated
	 */
	int PETRI_NET_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Analysis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_CONFIG__ANALYSIS_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Variable Assignments</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS = 1;

	/**
	 * The feature id for the '<em><b>Initial Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_CONFIG__INITIAL_MARKING = 2;

	/**
	 * The number of structural features of the '<em>Petri Net Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_CONFIG_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Petri Net Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnconfig.impl.EStringToEFloatObjectsMapImpl <em>EString To EFloat Objects Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnconfig.impl.EStringToEFloatObjectsMapImpl
	 * @see es.unizar.disco.pnconfig.impl.PnconfigPackageImpl#getEStringToEFloatObjectsMap()
	 * @generated
	 */
	int ESTRING_TO_EFLOAT_OBJECTS_MAP = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EFLOAT_OBJECTS_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EFLOAT_OBJECTS_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To EFloat Objects Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EFLOAT_OBJECTS_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To EFloat Objects Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EFLOAT_OBJECTS_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnconfig.AnalysisType <em>Analysis Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnconfig.AnalysisType
	 * @see es.unizar.disco.pnconfig.impl.PnconfigPackageImpl#getAnalysisType()
	 * @generated
	 */
	int ANALYSIS_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.pnconfig.PetriNetConfig <em>Petri Net Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Petri Net Config</em>'.
	 * @see es.unizar.disco.pnconfig.PetriNetConfig
	 * @generated
	 */
	EClass getPetriNetConfig();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.pnconfig.PetriNetConfig#getAnalysisType <em>Analysis Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analysis Type</em>'.
	 * @see es.unizar.disco.pnconfig.PetriNetConfig#getAnalysisType()
	 * @see #getPetriNetConfig()
	 * @generated
	 */
	EAttribute getPetriNetConfig_AnalysisType();

	/**
	 * Returns the meta object for the map '{@link es.unizar.disco.pnconfig.PetriNetConfig#getVariableAssignments <em>Variable Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Variable Assignments</em>'.
	 * @see es.unizar.disco.pnconfig.PetriNetConfig#getVariableAssignments()
	 * @see #getPetriNetConfig()
	 * @generated
	 */
	EReference getPetriNetConfig_VariableAssignments();

	/**
	 * Returns the meta object for the reference '{@link es.unizar.disco.pnconfig.PetriNetConfig#getInitialMarking <em>Initial Marking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial Marking</em>'.
	 * @see es.unizar.disco.pnconfig.PetriNetConfig#getInitialMarking()
	 * @see #getPetriNetConfig()
	 * @generated
	 */
	EReference getPetriNetConfig_InitialMarking();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EFloat Objects Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EFloat Objects Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EFloatObject" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToEFloatObjectsMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEFloatObjectsMap()
	 * @generated
	 */
	EAttribute getEStringToEFloatObjectsMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEFloatObjectsMap()
	 * @generated
	 */
	EAttribute getEStringToEFloatObjectsMap_Value();

	/**
	 * Returns the meta object for enum '{@link es.unizar.disco.pnconfig.AnalysisType <em>Analysis Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Analysis Type</em>'.
	 * @see es.unizar.disco.pnconfig.AnalysisType
	 * @generated
	 */
	EEnum getAnalysisType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PnconfigFactory getPnconfigFactory();

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
		 * The meta object literal for the '{@link es.unizar.disco.pnconfig.impl.PetriNetConfigImpl <em>Petri Net Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnconfig.impl.PetriNetConfigImpl
		 * @see es.unizar.disco.pnconfig.impl.PnconfigPackageImpl#getPetriNetConfig()
		 * @generated
		 */
		EClass PETRI_NET_CONFIG = eINSTANCE.getPetriNetConfig();

		/**
		 * The meta object literal for the '<em><b>Analysis Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PETRI_NET_CONFIG__ANALYSIS_TYPE = eINSTANCE.getPetriNetConfig_AnalysisType();

		/**
		 * The meta object literal for the '<em><b>Variable Assignments</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET_CONFIG__VARIABLE_ASSIGNMENTS = eINSTANCE.getPetriNetConfig_VariableAssignments();

		/**
		 * The meta object literal for the '<em><b>Initial Marking</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET_CONFIG__INITIAL_MARKING = eINSTANCE.getPetriNetConfig_InitialMarking();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.pnconfig.impl.EStringToEFloatObjectsMapImpl <em>EString To EFloat Objects Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnconfig.impl.EStringToEFloatObjectsMapImpl
		 * @see es.unizar.disco.pnconfig.impl.PnconfigPackageImpl#getEStringToEFloatObjectsMap()
		 * @generated
		 */
		EClass ESTRING_TO_EFLOAT_OBJECTS_MAP = eINSTANCE.getEStringToEFloatObjectsMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EFLOAT_OBJECTS_MAP__KEY = eINSTANCE.getEStringToEFloatObjectsMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EFLOAT_OBJECTS_MAP__VALUE = eINSTANCE.getEStringToEFloatObjectsMap_Value();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.pnconfig.AnalysisType <em>Analysis Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnconfig.AnalysisType
		 * @see es.unizar.disco.pnconfig.impl.PnconfigPackageImpl#getAnalysisType()
		 * @generated
		 */
		EEnum ANALYSIS_TYPE = eINSTANCE.getAnalysisType();

	}

} //PnconfigPackage
