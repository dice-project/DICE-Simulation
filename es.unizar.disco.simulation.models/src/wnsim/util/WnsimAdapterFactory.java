/**
 */
package wnsim.util;

import configuration.AnalyzableElementInfo;
import configuration.ToolResult;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import wnsim.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see wnsim.WnsimPackage
 * @generated
 */
public class WnsimAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WnsimPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WnsimAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WnsimPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WnsimSwitch<Adapter> modelSwitch =
		new WnsimSwitch<Adapter>() {
			@Override
			public Adapter caseWnsimResult(WnsimResult object) {
				return createWnsimResultAdapter();
			}
			@Override
			public Adapter caseWnsimElementInfo(WnsimElementInfo object) {
				return createWnsimElementInfoAdapter();
			}
			@Override
			public Adapter casePlaceInfo(PlaceInfo object) {
				return createPlaceInfoAdapter();
			}
			@Override
			public Adapter caseTransitionInfo(TransitionInfo object) {
				return createTransitionInfoAdapter();
			}
			@Override
			public Adapter caseToolResult(ToolResult object) {
				return createToolResultAdapter();
			}
			@Override
			public Adapter caseAnalyzableElementInfo(AnalyzableElementInfo object) {
				return createAnalyzableElementInfoAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link wnsim.WnsimResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wnsim.WnsimResult
	 * @generated
	 */
	public Adapter createWnsimResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wnsim.WnsimElementInfo <em>Element Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wnsim.WnsimElementInfo
	 * @generated
	 */
	public Adapter createWnsimElementInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wnsim.PlaceInfo <em>Place Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wnsim.PlaceInfo
	 * @generated
	 */
	public Adapter createPlaceInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wnsim.TransitionInfo <em>Transition Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wnsim.TransitionInfo
	 * @generated
	 */
	public Adapter createTransitionInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configuration.ToolResult <em>Tool Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configuration.ToolResult
	 * @generated
	 */
	public Adapter createToolResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configuration.AnalyzableElementInfo <em>Analyzable Element Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configuration.AnalyzableElementInfo
	 * @generated
	 */
	public Adapter createAnalyzableElementInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WnsimAdapterFactory
