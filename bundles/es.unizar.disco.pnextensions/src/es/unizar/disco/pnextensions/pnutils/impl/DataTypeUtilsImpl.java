/**
 */
package es.unizar.disco.pnextensions.pnutils.impl;

import es.unizar.disco.pnextensions.pnutils.DataTypeUtils;
import es.unizar.disco.pnextensions.pnutils.PnutilsPackage;

import java.lang.reflect.InvocationTargetException;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Utils</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DataTypeUtilsImpl extends MinimalEObjectImpl.Container implements DataTypeUtils {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeUtilsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PnutilsPackage.Literals.DATA_TYPE_UTILS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createURI(final String stringUri) throws URISyntaxException {
		return new URI(stringUri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringBuffer createLongString(final String string) {
		return new StringBuffer(string);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PnutilsPackage.DATA_TYPE_UTILS___CREATE_URI__STRING:
				try {
					return createURI((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case PnutilsPackage.DATA_TYPE_UTILS___CREATE_LONG_STRING__STRING:
				return createLongString((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //DataTypeUtilsImpl
