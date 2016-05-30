/**
 */
package es.unizar.disco.simulation.models.marteconstants;

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
 * @see es.unizar.disco.simulation.models.marteconstants.MarteconstantsFactory
 * @model kind="package"
 * @generated
 */
public interface MarteconstantsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "marteconstants";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/simulation/marte/constants/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "marteconstants";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MarteconstantsPackage eINSTANCE = es.unizar.disco.simulation.models.marteconstants.impl.MarteconstantsPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.simulation.models.marteconstants.SupportedMetrics <em>Supported Metrics</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.simulation.models.marteconstants.SupportedMetrics
	 * @see es.unizar.disco.simulation.models.marteconstants.impl.MarteconstantsPackageImpl#getSupportedMetrics()
	 * @generated
	 */
	int SUPPORTED_METRICS = 0;


	/**
	 * Returns the meta object for enum '{@link es.unizar.disco.simulation.models.marteconstants.SupportedMetrics <em>Supported Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Supported Metrics</em>'.
	 * @see es.unizar.disco.simulation.models.marteconstants.SupportedMetrics
	 * @generated
	 */
	EEnum getSupportedMetrics();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MarteconstantsFactory getMarteconstantsFactory();

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
		 * The meta object literal for the '{@link es.unizar.disco.simulation.models.marteconstants.SupportedMetrics <em>Supported Metrics</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.simulation.models.marteconstants.SupportedMetrics
		 * @see es.unizar.disco.simulation.models.marteconstants.impl.MarteconstantsPackageImpl#getSupportedMetrics()
		 * @generated
		 */
		EEnum SUPPORTED_METRICS = eINSTANCE.getSupportedMetrics();

	}

} //MarteconstantsPackage
