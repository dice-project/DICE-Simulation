/**
 */
package es.unizar.disco.simulation.models.measures.util;

import es.unizar.disco.simulation.models.measures.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see es.unizar.disco.simulation.models.measures.MeasuresPackage
 * @generated
 */
public class MeasuresAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MeasuresPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuresAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MeasuresPackage.eINSTANCE;
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
	protected MeasuresSwitch<Adapter> modelSwitch =
		new MeasuresSwitch<Adapter>() {
			@Override
			public Adapter caseDomainMeasure(DomainMeasure object) {
				return createDomainMeasureAdapter();
			}
			@Override
			public Adapter caseThroughput(Throughput object) {
				return createThroughputAdapter();
			}
			@Override
			public Adapter caseResponseTime(ResponseTime object) {
				return createResponseTimeAdapter();
			}
			@Override
			public Adapter caseUtilization(Utilization object) {
				return createUtilizationAdapter();
			}
			@Override
			public Adapter caseMeasureConverter(MeasureConverter object) {
				return createMeasureConverterAdapter();
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
	 * Creates a new adapter for an object of class '{@link es.unizar.disco.simulation.models.measures.DomainMeasure <em>Domain Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasure
	 * @generated
	 */
	public Adapter createDomainMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link es.unizar.disco.simulation.models.measures.Throughput <em>Throughput</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see es.unizar.disco.simulation.models.measures.Throughput
	 * @generated
	 */
	public Adapter createThroughputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link es.unizar.disco.simulation.models.measures.ResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see es.unizar.disco.simulation.models.measures.ResponseTime
	 * @generated
	 */
	public Adapter createResponseTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link es.unizar.disco.simulation.models.measures.Utilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see es.unizar.disco.simulation.models.measures.Utilization
	 * @generated
	 */
	public Adapter createUtilizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link es.unizar.disco.simulation.models.measures.MeasureConverter <em>Measure Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see es.unizar.disco.simulation.models.measures.MeasureConverter
	 * @generated
	 */
	public Adapter createMeasureConverterAdapter() {
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

} //MeasuresAdapterFactory
