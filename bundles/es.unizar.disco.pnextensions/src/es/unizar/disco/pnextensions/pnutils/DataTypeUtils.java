/**
 */
package es.unizar.disco.pnextensions.pnutils;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Utils</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see es.unizar.disco.pnextensions.pnutils.PnutilsPackage#getDataTypeUtils()
 * @model
 * @generated
 */
public interface DataTypeUtils extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="es.unizar.disco.pnextensions.pnutils.URI" exceptions="es.unizar.disco.pnextensions.pnutils.URISyntaxException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new URI(stringUri);'"
	 * @generated
	 */
	URI createURI(String stringUri) throws URISyntaxException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="es.unizar.disco.pnextensions.pnutils.StringBuffer"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new StringBuffer(string);'"
	 * @generated
	 */
	StringBuffer createLongString(String string);

} // DataTypeUtils
