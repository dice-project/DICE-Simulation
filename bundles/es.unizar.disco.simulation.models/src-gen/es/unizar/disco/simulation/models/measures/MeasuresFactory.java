/**
 */
package es.unizar.disco.simulation.models.measures;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage
 * @generated
 */
public interface MeasuresFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeasuresFactory eINSTANCE = es.unizar.disco.simulation.models.measures.impl.MeasuresFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Domain Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Measure</em>'.
	 * @generated
	 */
	DomainMeasure createDomainMeasure();

	/**
	 * Returns a new object of class '<em>Domain Measure Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Measure Definition</em>'.
	 * @generated
	 */
	DomainMeasureDefinition createDomainMeasureDefinition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MeasuresPackage getMeasuresPackage();

} //MeasuresFactory
