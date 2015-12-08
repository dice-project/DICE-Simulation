/**
 */
package es.unizar.disco.pnextensions.pnconstants;

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
 * @see es.unizar.disco.pnextensions.pnconstants.PnconstantsFactory
 * @model kind="package"
 * @generated
 */
public interface PnconstantsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pnconstants";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/pnconstants/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pnconstants";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PnconstantsPackage eINSTANCE = es.unizar.disco.pnextensions.pnconstants.impl.PnconstantsPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnextensions.pnconstants.ToolInfoConstants <em>Tool Info Constants</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnextensions.pnconstants.ToolInfoConstants
	 * @see es.unizar.disco.pnextensions.pnconstants.impl.PnconstantsPackageImpl#getToolInfoConstants()
	 * @generated
	 */
	int TOOL_INFO_CONSTANTS = 0;

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnextensions.pnconstants.TransitionKind <em>Transition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnextensions.pnconstants.TransitionKind
	 * @see es.unizar.disco.pnextensions.pnconstants.impl.PnconstantsPackageImpl#getTransitionKind()
	 * @generated
	 */
	int TRANSITION_KIND = 1;

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnextensions.pnconstants.ServerType <em>Server Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnextensions.pnconstants.ServerType
	 * @see es.unizar.disco.pnextensions.pnconstants.impl.PnconstantsPackageImpl#getServerType()
	 * @generated
	 */
	int SERVER_TYPE = 2;


	/**
	 * Returns the meta object for enum '{@link es.unizar.disco.pnextensions.pnconstants.ToolInfoConstants <em>Tool Info Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tool Info Constants</em>'.
	 * @see es.unizar.disco.pnextensions.pnconstants.ToolInfoConstants
	 * @generated
	 */
	EEnum getToolInfoConstants();

	/**
	 * Returns the meta object for enum '{@link es.unizar.disco.pnextensions.pnconstants.TransitionKind <em>Transition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transition Kind</em>'.
	 * @see es.unizar.disco.pnextensions.pnconstants.TransitionKind
	 * @generated
	 */
	EEnum getTransitionKind();

	/**
	 * Returns the meta object for enum '{@link es.unizar.disco.pnextensions.pnconstants.ServerType <em>Server Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Server Type</em>'.
	 * @see es.unizar.disco.pnextensions.pnconstants.ServerType
	 * @generated
	 */
	EEnum getServerType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PnconstantsFactory getPnconstantsFactory();

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
		 * The meta object literal for the '{@link es.unizar.disco.pnextensions.pnconstants.ToolInfoConstants <em>Tool Info Constants</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnextensions.pnconstants.ToolInfoConstants
		 * @see es.unizar.disco.pnextensions.pnconstants.impl.PnconstantsPackageImpl#getToolInfoConstants()
		 * @generated
		 */
		EEnum TOOL_INFO_CONSTANTS = eINSTANCE.getToolInfoConstants();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.pnextensions.pnconstants.TransitionKind <em>Transition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnextensions.pnconstants.TransitionKind
		 * @see es.unizar.disco.pnextensions.pnconstants.impl.PnconstantsPackageImpl#getTransitionKind()
		 * @generated
		 */
		EEnum TRANSITION_KIND = eINSTANCE.getTransitionKind();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.pnextensions.pnconstants.ServerType <em>Server Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnextensions.pnconstants.ServerType
		 * @see es.unizar.disco.pnextensions.pnconstants.impl.PnconstantsPackageImpl#getServerType()
		 * @generated
		 */
		EEnum SERVER_TYPE = eINSTANCE.getServerType();

	}

} //PnconstantsPackage
