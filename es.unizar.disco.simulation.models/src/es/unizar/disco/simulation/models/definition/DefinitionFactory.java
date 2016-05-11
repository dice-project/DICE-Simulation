/**
 */
package es.unizar.disco.simulation.models.definition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage
 * @generated
 */
public interface DefinitionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DefinitionFactory eINSTANCE = es.unizar.disco.simulation.models.definition.impl.DefinitionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simulation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulation Definition</em>'.
	 * @generated
	 */
	SimulationDefinition createSimulationDefinition();

	/**
	 * Returns a new object of class '<em>Simulation Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulation Parameter</em>'.
	 * @generated
	 */
	SimulationParameter createSimulationParameter();

	/**
	 * Returns a new object of class '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scenario</em>'.
	 * @generated
	 */
	Scenario createScenario();

	/**
	 * Returns a new object of class '<em>Input Variable Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Variable Value</em>'.
	 * @generated
	 */
	InputVariableValue createInputVariableValue();

	/**
	 * Returns a new object of class '<em>Input Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Variable</em>'.
	 * @generated
	 */
	InputVariable createInputVariable();

	/**
	 * Returns a new object of class '<em>Output Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Variable</em>'.
	 * @generated
	 */
	OutputVariable createOutputVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DefinitionPackage getDefinitionPackage();

} //DefinitionFactory
