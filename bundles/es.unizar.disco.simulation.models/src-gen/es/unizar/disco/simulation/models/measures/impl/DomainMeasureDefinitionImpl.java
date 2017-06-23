/**
 */
package es.unizar.disco.simulation.models.measures.impl;

import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;

import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasuresPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Measure Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl#getMeasuredElement <em>Measured Element</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl#getVslExpressionEntries <em>Vsl Expression Entries</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl#getVslExpression <em>Vsl Expression</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl#getOutputVariable <em>Output Variable</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl#getSimulationDefinition <em>Simulation Definition</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.measures.impl.DomainMeasureDefinitionImpl#getSlaVslExpression <em>Sla Vsl Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainMeasureDefinitionImpl extends MinimalEObjectImpl.Container implements DomainMeasureDefinition {
	/**
	 * The cached value of the '{@link #getMeasuredElement() <em>Measured Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredElement()
	 * @generated
	 * @ordered
	 */
	protected EObject measuredElement;

	/**
	 * The default value of the '{@link #getMeasure() <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected String measure = MEASURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVslExpressionEntries() <em>Vsl Expression Entries</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVslExpressionEntries()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> vslExpressionEntries;

	/**
	 * The default value of the '{@link #getVslExpression() <em>Vsl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVslExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String VSL_EXPRESSION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSlaVslExpression() <em>Sla Vsl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlaVslExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String SLA_VSL_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlaVslExpression() <em>Sla Vsl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlaVslExpression()
	 * @generated
	 * @ordered
	 */
	protected String slaVslExpression = SLA_VSL_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainMeasureDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasuresPackage.Literals.DOMAIN_MEASURE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getMeasuredElement() {
		if (measuredElement != null && measuredElement.eIsProxy()) {
			InternalEObject oldMeasuredElement = (InternalEObject)measuredElement;
			measuredElement = eResolveProxy(oldMeasuredElement);
			if (measuredElement != oldMeasuredElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT, oldMeasuredElement, measuredElement));
			}
		}
		return measuredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetMeasuredElement() {
		return measuredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasuredElement(EObject newMeasuredElement) {
		EObject oldMeasuredElement = measuredElement;
		measuredElement = newMeasuredElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT, oldMeasuredElement, measuredElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasure() {
		return measure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasure(String newMeasure) {
		String oldMeasure = measure;
		measure = newMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURE, oldMeasure, measure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getVslExpressionEntries() {
		if (vslExpressionEntries == null) {
			vslExpressionEntries = new EcoreEMap<String,String>(MeasuresPackage.Literals.ENTRY, EntryImpl.class, this, MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES);
		}
		return vslExpressionEntries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVslExpression() {
		// TODO: implement this method to return the 'Vsl Expression' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVslExpression(String newVslExpression) {
		// TODO: implement this method to set the 'Vsl Expression' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVariable getOutputVariable() {
		OutputVariable outputVariable = basicGetOutputVariable();
		return outputVariable != null && outputVariable.eIsProxy() ? (OutputVariable)eResolveProxy((InternalEObject)outputVariable) : outputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVariable basicGetOutputVariable() {
		// TODO: implement this method to return the 'Output Variable' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationDefinition getSimulationDefinition() {
		if (eContainerFeatureID() != MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION) return null;
		return (SimulationDefinition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimulationDefinition(SimulationDefinition newSimulationDefinition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSimulationDefinition, MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulationDefinition(SimulationDefinition newSimulationDefinition) {
		if (newSimulationDefinition != eInternalContainer() || (eContainerFeatureID() != MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION && newSimulationDefinition != null)) {
			if (EcoreUtil.isAncestor(this, newSimulationDefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSimulationDefinition != null)
				msgs = ((InternalEObject)newSimulationDefinition).eInverseAdd(this, DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES, SimulationDefinition.class, msgs);
			msgs = basicSetSimulationDefinition(newSimulationDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION, newSimulationDefinition, newSimulationDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSlaVslExpression() {
		return slaVslExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlaVslExpression(String newSlaVslExpression) {
		String oldSlaVslExpression = slaVslExpression;
		slaVslExpression = newSlaVslExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SLA_VSL_EXPRESSION, oldSlaVslExpression, slaVslExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSimulationDefinition((SimulationDefinition)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES:
				return ((InternalEList<?>)getVslExpressionEntries()).basicRemove(otherEnd, msgs);
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION:
				return basicSetSimulationDefinition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION:
				return eInternalContainer().eInverseRemove(this, DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES, SimulationDefinition.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT:
				if (resolve) return getMeasuredElement();
				return basicGetMeasuredElement();
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURE:
				return getMeasure();
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES:
				if (coreType) return getVslExpressionEntries();
				else return getVslExpressionEntries().map();
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION:
				return getVslExpression();
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__OUTPUT_VARIABLE:
				if (resolve) return getOutputVariable();
				return basicGetOutputVariable();
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION:
				return getSimulationDefinition();
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SLA_VSL_EXPRESSION:
				return getSlaVslExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT:
				setMeasuredElement((EObject)newValue);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURE:
				setMeasure((String)newValue);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES:
				((EStructuralFeature.Setting)getVslExpressionEntries()).set(newValue);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION:
				setVslExpression((String)newValue);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION:
				setSimulationDefinition((SimulationDefinition)newValue);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SLA_VSL_EXPRESSION:
				setSlaVslExpression((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT:
				setMeasuredElement((EObject)null);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURE:
				setMeasure(MEASURE_EDEFAULT);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES:
				getVslExpressionEntries().clear();
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION:
				setVslExpression(VSL_EXPRESSION_EDEFAULT);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION:
				setSimulationDefinition((SimulationDefinition)null);
				return;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SLA_VSL_EXPRESSION:
				setSlaVslExpression(SLA_VSL_EXPRESSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURED_ELEMENT:
				return measuredElement != null;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__MEASURE:
				return MEASURE_EDEFAULT == null ? measure != null : !MEASURE_EDEFAULT.equals(measure);
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION_ENTRIES:
				return vslExpressionEntries != null && !vslExpressionEntries.isEmpty();
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__VSL_EXPRESSION:
				return VSL_EXPRESSION_EDEFAULT == null ? getVslExpression() != null : !VSL_EXPRESSION_EDEFAULT.equals(getVslExpression());
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__OUTPUT_VARIABLE:
				return basicGetOutputVariable() != null;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SIMULATION_DEFINITION:
				return getSimulationDefinition() != null;
			case MeasuresPackage.DOMAIN_MEASURE_DEFINITION__SLA_VSL_EXPRESSION:
				return SLA_VSL_EXPRESSION_EDEFAULT == null ? slaVslExpression != null : !SLA_VSL_EXPRESSION_EDEFAULT.equals(slaVslExpression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (measure: ");
		result.append(measure);
		result.append(", slaVslExpression: ");
		result.append(slaVslExpression);
		result.append(')');
		return result.toString();
	}

} //DomainMeasureDefinitionImpl
