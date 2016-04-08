/**
 */
package wnsim;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see wnsim.WnsimPackage
 * @generated
 */
public interface WnsimFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WnsimFactory eINSTANCE = wnsim.impl.WnsimFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result</em>'.
	 * @generated
	 */
	WnsimResult createWnsimResult();

	/**
	 * Returns a new object of class '<em>Place Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Place Info</em>'.
	 * @generated
	 */
	PlaceInfo createPlaceInfo();

	/**
	 * Returns a new object of class '<em>Transition Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Info</em>'.
	 * @generated
	 */
	TransitionInfo createTransitionInfo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WnsimPackage getWnsimPackage();

} //WnsimFactory
