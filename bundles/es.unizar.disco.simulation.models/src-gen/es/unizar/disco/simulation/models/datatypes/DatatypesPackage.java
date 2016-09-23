/**
 */
package es.unizar.disco.simulation.models.datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see es.unizar.disco.simulation.models.datatypes.DatatypesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore conversionDelegates='http://es.unizar.disco/simulation/conversion/number/1.0 http://es.unizar.disco/simulation/conversion/uri/1.0'"
 * @generated
 */
public interface DatatypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/datatypes/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatatypesPackage eINSTANCE = es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.datatypes.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.datatypes.impl.ResourceImpl
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__URI = 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RESOURCE = 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.datatypes.impl.PrimitiveVariableAssignmentImpl <em>Primitive Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.datatypes.impl.PrimitiveVariableAssignmentImpl
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getPrimitiveVariableAssignment()
	 * @generated
	 */
	int PRIMITIVE_VARIABLE_ASSIGNMENT = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_ASSIGNMENT__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_ASSIGNMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Primitive Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_ASSIGNMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Primitive Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_ASSIGNMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.datatypes.SimulationStatus <em>Simulation Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.datatypes.SimulationStatus
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getSimulationStatus()
	 * @generated
	 */
	int SIMULATION_STATUS = 2;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.datatypes.NonStandardUnits <em>Non Standard Units</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.datatypes.NonStandardUnits
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getNonStandardUnits()
	 * @generated
	 */
	int NON_STANDARD_UNITS = 3;

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.datatypes.ComputableNFPtype <em>Computable NF Ptype</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.datatypes.ComputableNFPtype
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getComputableNFPtype()
	 * @generated
	 */
	int COMPUTABLE_NF_PTYPE = 4;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getURI()
	 * @generated
	 */
	int URI = 5;

	/**
	 * The meta object id for the '<em>Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getNumber()
	 * @generated
	 */
	int NUMBER = 6;

	/**
	 * The meta object id for the '<em>IStatus</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IStatus
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getIStatus()
	 * @generated
	 */
	int ISTATUS = 7;

	/**
	 * The meta object id for the '<em>Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 8;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.datatypes.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.datatypes.Resource#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.Resource#getUri()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Uri();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.datatypes.Resource#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.Resource#getResource()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Resource();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment <em>Primitive Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Variable Assignment</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment
	 * @generated
	 */
	EClass getPrimitiveVariableAssignment();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment#getVariable()
	 * @see #getPrimitiveVariableAssignment()
	 * @generated
	 */
	EAttribute getPrimitiveVariableAssignment_Variable();

	/**
	 * Returns the meta object for the attribute '{@link es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.PrimitiveVariableAssignment#getValue()
	 * @see #getPrimitiveVariableAssignment()
	 * @generated
	 */
	EAttribute getPrimitiveVariableAssignment_Value();

	/**
	 * Returns the meta object for enum '{@link es.unizar.disco.simulation.models.datatypes.SimulationStatus <em>Simulation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Simulation Status</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.SimulationStatus
	 * @generated
	 */
	EEnum getSimulationStatus();

	/**
	 * Returns the meta object for enum '{@link es.unizar.disco.simulation.models.datatypes.NonStandardUnits <em>Non Standard Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Non Standard Units</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.NonStandardUnits
	 * @generated
	 */
	EEnum getNonStandardUnits();

	/**
	 * Returns the meta object for enum '{@link es.unizar.disco.simulation.models.datatypes.ComputableNFPtype <em>Computable NF Ptype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Computable NF Ptype</em>'.
	 * @see es.unizar.disco.simulation.models.datatypes.ComputableNFPtype
	 * @generated
	 */
	EEnum getComputableNFPtype();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 *        annotation="http://es.unizar.disco/simulation/conversion/number/1.0 conversionDelegates='http://es.unizar.disco/simulation/conversion/1.0'"
	 * @generated
	 */
	EDataType getNumber();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IStatus <em>IStatus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IStatus</em>'.
	 * @see org.eclipse.core.runtime.IStatus
	 * @model instanceClass="org.eclipse.core.runtime.IStatus" serializeable="false"
	 * @generated
	 */
	EDataType getIStatus();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection" typeParameters="T"
	 * @generated
	 */
	EDataType getCollection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatatypesFactory getDatatypesFactory();

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
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.datatypes.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.datatypes.impl.ResourceImpl
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__URI = eINSTANCE.getResource_Uri();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__RESOURCE = eINSTANCE.getResource_Resource();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.datatypes.impl.PrimitiveVariableAssignmentImpl <em>Primitive Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.datatypes.impl.PrimitiveVariableAssignmentImpl
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getPrimitiveVariableAssignment()
		 * @generated
		 */
		EClass PRIMITIVE_VARIABLE_ASSIGNMENT = eINSTANCE.getPrimitiveVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_VARIABLE_ASSIGNMENT__VARIABLE = eINSTANCE.getPrimitiveVariableAssignment_Variable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_VARIABLE_ASSIGNMENT__VALUE = eINSTANCE.getPrimitiveVariableAssignment_Value();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.datatypes.SimulationStatus <em>Simulation Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.datatypes.SimulationStatus
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getSimulationStatus()
		 * @generated
		 */
		EEnum SIMULATION_STATUS = eINSTANCE.getSimulationStatus();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.datatypes.NonStandardUnits <em>Non Standard Units</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.datatypes.NonStandardUnits
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getNonStandardUnits()
		 * @generated
		 */
		EEnum NON_STANDARD_UNITS = eINSTANCE.getNonStandardUnits();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.datatypes.ComputableNFPtype <em>Computable NF Ptype</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.datatypes.ComputableNFPtype
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getComputableNFPtype()
		 * @generated
		 */
		EEnum COMPUTABLE_NF_PTYPE = eINSTANCE.getComputableNFPtype();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '<em>Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getNumber()
		 * @generated
		 */
		EDataType NUMBER = eINSTANCE.getNumber();

		/**
		 * The meta object literal for the '<em>IStatus</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IStatus
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getIStatus()
		 * @generated
		 */
		EDataType ISTATUS = eINSTANCE.getIStatus();

		/**
		 * The meta object literal for the '<em>Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see es.unizar.disco.simulation.models.datatypes.impl.DatatypesPackageImpl#getCollection()
		 * @generated
		 */
		EDataType COLLECTION = eINSTANCE.getCollection();

	}

} //DatatypesPackage
