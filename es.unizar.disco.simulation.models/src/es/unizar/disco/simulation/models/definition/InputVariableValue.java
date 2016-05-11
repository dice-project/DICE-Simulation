/**
 */
package es.unizar.disco.simulation.models.definition;

import es.unizar.disco.simulation.models.datatypes.Unit;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Variable Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getValue <em>Value</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariableValue()
 * @model
 * @generated
 */
public interface InputVariableValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Number)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariableValue_Value()
	 * @model dataType="es.unizar.disco.simulation.models.datatypes.Number" required="true"
	 * @generated
	 */
	Number getValue();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Number value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The literals are from the enumeration {@link es.unizar.disco.simulation.models.datatypes.Unit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.Unit
	 * @see #setUnit(Unit)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getInputVariableValue_Unit()
	 * @model required="true"
	 * @generated
	 */
	Unit getUnit();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.InputVariableValue#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.Unit
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(Unit value);

} // InputVariableValue
