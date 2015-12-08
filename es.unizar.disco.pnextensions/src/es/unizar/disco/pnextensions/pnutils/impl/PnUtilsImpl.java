/**
 */
package es.unizar.disco.pnextensions.pnutils.impl;

import es.unizar.disco.pnextensions.pnutils.PnUtils;
import es.unizar.disco.pnextensions.pnutils.PnutilsPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pn Utils</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PnUtilsImpl extends MinimalEObjectImpl.Container implements PnUtils {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PnUtilsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PnutilsPackage.Literals.PN_UTILS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void layout(EObject petriNet) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PnutilsPackage.PN_UTILS___LAYOUT__EOBJECT:
				layout((EObject)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PnUtilsImpl
