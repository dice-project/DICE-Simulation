/**
 */
package es.unizar.disco.pnconfig;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.pnconfig.PnconfigPackage
 * @generated
 */
public interface PnconfigFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PnconfigFactory eINSTANCE = es.unizar.disco.pnconfig.impl.PnconfigFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Petri Net Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Petri Net Config</em>'.
	 * @generated
	 */
	PetriNetConfig createPetriNetConfig();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PnconfigPackage getPnconfigPackage();

} //PnconfigFactory
