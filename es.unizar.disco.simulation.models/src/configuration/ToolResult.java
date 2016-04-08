/**
 */
package configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link configuration.ToolResult#getInfos <em>Infos</em>}</li>
 * </ul>
 *
 * @see configuration.ConfigurationPackage#getToolResult()
 * @model abstract="true"
 * @generated
 */
public interface ToolResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Infos</b></em>' containment reference list.
	 * The list contents are of type {@link configuration.AnalyzableElementInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infos</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infos</em>' containment reference list.
	 * @see configuration.ConfigurationPackage#getToolResult_Infos()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AnalyzableElementInfo> getInfos();

} // ToolResult
