/**
 */
package configuration.impl;

import configuration.ConfigurationPackage;
import configuration.Trace;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link configuration.impl.TraceImpl#getFromDomainElement <em>From Domain Element</em>}</li>
 *   <li>{@link configuration.impl.TraceImpl#getToAnalyzableElement <em>To Analyzable Element</em>}</li>
 *   <li>{@link configuration.impl.TraceImpl#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceImpl extends MinimalEObjectImpl.Container implements Trace {
	/**
	 * The cached value of the '{@link #getFromDomainElement() <em>From Domain Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromDomainElement()
	 * @generated
	 * @ordered
	 */
	protected EObject fromDomainElement;

	/**
	 * The cached value of the '{@link #getToAnalyzableElement() <em>To Analyzable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToAnalyzableElement()
	 * @generated
	 * @ordered
	 */
	protected EObject toAnalyzableElement;

	/**
	 * The default value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected String rule = RULE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getFromDomainElement() {
		if (fromDomainElement != null && fromDomainElement.eIsProxy()) {
			InternalEObject oldFromDomainElement = (InternalEObject)fromDomainElement;
			fromDomainElement = eResolveProxy(oldFromDomainElement);
			if (fromDomainElement != oldFromDomainElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.TRACE__FROM_DOMAIN_ELEMENT, oldFromDomainElement, fromDomainElement));
			}
		}
		return fromDomainElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetFromDomainElement() {
		return fromDomainElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromDomainElement(EObject newFromDomainElement) {
		EObject oldFromDomainElement = fromDomainElement;
		fromDomainElement = newFromDomainElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.TRACE__FROM_DOMAIN_ELEMENT, oldFromDomainElement, fromDomainElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getToAnalyzableElement() {
		if (toAnalyzableElement != null && toAnalyzableElement.eIsProxy()) {
			InternalEObject oldToAnalyzableElement = (InternalEObject)toAnalyzableElement;
			toAnalyzableElement = eResolveProxy(oldToAnalyzableElement);
			if (toAnalyzableElement != oldToAnalyzableElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.TRACE__TO_ANALYZABLE_ELEMENT, oldToAnalyzableElement, toAnalyzableElement));
			}
		}
		return toAnalyzableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetToAnalyzableElement() {
		return toAnalyzableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToAnalyzableElement(EObject newToAnalyzableElement) {
		EObject oldToAnalyzableElement = toAnalyzableElement;
		toAnalyzableElement = newToAnalyzableElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.TRACE__TO_ANALYZABLE_ELEMENT, oldToAnalyzableElement, toAnalyzableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(String newRule) {
		String oldRule = rule;
		rule = newRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.TRACE__RULE, oldRule, rule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.TRACE__FROM_DOMAIN_ELEMENT:
				if (resolve) return getFromDomainElement();
				return basicGetFromDomainElement();
			case ConfigurationPackage.TRACE__TO_ANALYZABLE_ELEMENT:
				if (resolve) return getToAnalyzableElement();
				return basicGetToAnalyzableElement();
			case ConfigurationPackage.TRACE__RULE:
				return getRule();
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
			case ConfigurationPackage.TRACE__FROM_DOMAIN_ELEMENT:
				setFromDomainElement((EObject)newValue);
				return;
			case ConfigurationPackage.TRACE__TO_ANALYZABLE_ELEMENT:
				setToAnalyzableElement((EObject)newValue);
				return;
			case ConfigurationPackage.TRACE__RULE:
				setRule((String)newValue);
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
			case ConfigurationPackage.TRACE__FROM_DOMAIN_ELEMENT:
				setFromDomainElement((EObject)null);
				return;
			case ConfigurationPackage.TRACE__TO_ANALYZABLE_ELEMENT:
				setToAnalyzableElement((EObject)null);
				return;
			case ConfigurationPackage.TRACE__RULE:
				setRule(RULE_EDEFAULT);
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
			case ConfigurationPackage.TRACE__FROM_DOMAIN_ELEMENT:
				return fromDomainElement != null;
			case ConfigurationPackage.TRACE__TO_ANALYZABLE_ELEMENT:
				return toAnalyzableElement != null;
			case ConfigurationPackage.TRACE__RULE:
				return RULE_EDEFAULT == null ? rule != null : !RULE_EDEFAULT.equals(rule);
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
		result.append(" (rule: ");
		result.append(rule);
		result.append(')');
		return result.toString();
	}

} //TraceImpl
