/**
 */
package es.unizar.disco.pnconfig;

import java.util.Map;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Petri Net Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.pnconfig.PetriNetConfig#getAnalysisType <em>Analysis Type</em>}</li>
 *   <li>{@link es.unizar.disco.pnconfig.PetriNetConfig#getVariableAssignments <em>Variable Assignments</em>}</li>
 *   <li>{@link es.unizar.disco.pnconfig.PetriNetConfig#getInitialMarking <em>Initial Marking</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.pnconfig.PnconfigPackage#getPetriNetConfig()
 * @model
 * @generated
 */
public interface PetriNetConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Analysis Type</b></em>' attribute.
	 * The literals are from the enumeration {@link es.unizar.disco.pnconfig.AnalysisType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Type</em>' attribute.
	 * @see es.unizar.disco.pnconfig.AnalysisType
	 * @see #setAnalysisType(AnalysisType)
	 * @see es.unizar.disco.pnconfig.PnconfigPackage#getPetriNetConfig_AnalysisType()
	 * @model required="true"
	 * @generated
	 */
	AnalysisType getAnalysisType();

	/**
	 * Sets the value of the '{@link es.unizar.disco.pnconfig.PetriNetConfig#getAnalysisType <em>Analysis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Type</em>' attribute.
	 * @see es.unizar.disco.pnconfig.AnalysisType
	 * @see #getAnalysisType()
	 * @generated
	 */
	void setAnalysisType(AnalysisType value);

	/**
	 * Returns the value of the '<em><b>Variable Assignments</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Float},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Assignments</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Assignments</em>' map.
	 * @see es.unizar.disco.pnconfig.PnconfigPackage#getPetriNetConfig_VariableAssignments()
	 * @model mapType="es.unizar.disco.pnconfig.EStringToEFloatObjectsMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EFloatObject>"
	 * @generated
	 */
	EMap<String, Float> getVariableAssignments();

	/**
	 * Returns the value of the '<em><b>Initial Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Marking</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Marking</em>' reference.
	 * @see #setInitialMarking(Map.Entry)
	 * @see es.unizar.disco.pnconfig.PnconfigPackage#getPetriNetConfig_InitialMarking()
	 * @model mapType="es.unizar.disco.pnconfig.EStringToEFloatObjectsMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EFloatObject>"
	 * @generated
	 */
	Map.Entry<String, Float> getInitialMarking();

	/**
	 * Sets the value of the '{@link es.unizar.disco.pnconfig.PetriNetConfig#getInitialMarking <em>Initial Marking</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Marking</em>' reference.
	 * @see #getInitialMarking()
	 * @generated
	 */
	void setInitialMarking(Map.Entry<String, Float> value);

} // PetriNetConfig
