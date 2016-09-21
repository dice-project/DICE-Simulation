/**
 */
package es.unizar.disco.simulation.models.simresult;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.simulation.models.simresult.SimresultPackage
 * @generated
 */
public interface SimresultFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimresultFactory eINSTANCE = es.unizar.disco.simulation.models.simresult.impl.SimresultFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simulation Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulation Result</em>'.
	 * @generated
	 */
	SimulationResult createSimulationResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimresultPackage getSimresultPackage();

} //SimresultFactory
