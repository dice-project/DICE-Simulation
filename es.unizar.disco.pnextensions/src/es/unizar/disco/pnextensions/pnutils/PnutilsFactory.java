/**
 */
package es.unizar.disco.pnextensions.pnutils;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.pnextensions.pnutils.PnutilsPackage
 * @generated
 */
public interface PnutilsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PnutilsFactory eINSTANCE = es.unizar.disco.pnextensions.pnutils.impl.PnutilsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Pn Utils</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pn Utils</em>'.
	 * @generated
	 */
	PnUtils createPnUtils();

	/**
	 * Returns a new object of class '<em>Data Type Utils</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Utils</em>'.
	 * @generated
	 */
	DataTypeUtils createDataTypeUtils();

	/**
	 * Returns a new object of class '<em>Tool Info Utils</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Info Utils</em>'.
	 * @generated
	 */
	ToolInfoUtils createToolInfoUtils();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PnutilsPackage getPnutilsPackage();

} //PnutilsFactory
