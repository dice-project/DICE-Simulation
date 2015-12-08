/**
 */
package es.unizar.disco.pnextensions.pnutils.impl;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import es.unizar.disco.pnextensions.PnextensionsPlugin;
import es.unizar.disco.pnextensions.pnconstants.ServerType;
import es.unizar.disco.pnextensions.pnconstants.ToolInfoConstants;
import es.unizar.disco.pnextensions.pnconstants.TransitionKind;
import es.unizar.disco.pnextensions.pnutils.PnutilsPackage;
import es.unizar.disco.pnextensions.pnutils.ToolInfoUtils;
import fr.lip6.move.pnml.pnmlcoremodel.PnmlcoremodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool Info Utils</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ToolInfoUtilsImpl extends MinimalEObjectImpl.Container implements ToolInfoUtils {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolInfoUtilsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PnutilsPackage.Literals.TOOL_INFO_UTILS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEObjectValidPnObject(final EObject eObject) {
		// Get the Transition EClass
		EPackage ePackage = eObject.eClass().getEPackage();
		
		// Get the PnObject EClass
		EClass pnObjectEClass = (EClass) ePackage.getEClassifier(PnmlcoremodelPackage.eINSTANCE.getPnObject().getName());
		
		try {
			if (pnObjectEClass.isSuperTypeOf(eObject.eClass())) {
				return true;
			}
		} catch (NullPointerException e) {
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEObjectValidTransition(final EObject eObject) {
		// Get the Transition EClass
		EPackage ePackage = eObject.eClass().getEPackage();
		
		// Get the Transition EClass
		EClass transitionEClass = (EClass) ePackage.getEClassifier(PnmlcoremodelPackage.eINSTANCE.getTransition().getName());
		
		try {
			if (transitionEClass.isInstance(eObject)) {
				return true;
			}
		} catch (NullPointerException e) {
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getToolInfoEntryByGrammarUri(final EObject pnObject, final String uri) {
		if (!isEObjectValidPnObject(pnObject)) {
			throw new IllegalArgumentException("Argument is not a valid 'PnObject'");
		}
		
		// Get the Transition EClass
		EClass transEClass = pnObject.eClass();
		
		// Get the PnObject.toolSpecifics EStructuralFeature
		EStructuralFeature toolSpecificsEStructuralFeature = transEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getPnObject_Toolspecifics().getName());
		
		// Get the ToolInfo EClass
		EClass toolInfoEClass = (EClass) transEClass.getEPackage().getEClassifier(PnmlcoremodelPackage.eINSTANCE.getToolInfo().getName());
		
		// Get the ToolInfo.toolInfoGrammrURI EStructuralFeature
		EStructuralFeature toolInfoGrammarUriEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_ToolInfoGrammarURI().getName());
		
		@SuppressWarnings("unchecked")
		EList<EObject> toolSpecifics = (EList<EObject>) pnObject.eGet(toolSpecificsEStructuralFeature);
		for (EObject toolInfo : toolSpecifics) {
			java.net.URI grammarUri = (java.net.URI) toolInfo.eGet(toolInfoGrammarUriEStructuralFeature);
			if (grammarUri != null && grammarUri.toString().equals(uri)) {
				return toolInfo;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject deleteToolInfoEntryByGrammarUri(final EObject pnObject, final String uri) {
		if (!isEObjectValidPnObject(pnObject)) {
			throw new IllegalArgumentException("Argument is not a valid 'PnObject'");
		}
		
		// Get the Transition EClass
		EClass transEClass = pnObject.eClass();
		
		// Get the PnObject.toolSpecifics EStructuralFeature
		EStructuralFeature toolSpecificsEStructuralFeature = transEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getPnObject_Toolspecifics().getName());
		
		// Get the ToolInfo EClass
		EClass toolInfoEClass = (EClass) transEClass.getEPackage().getEClassifier(PnmlcoremodelPackage.eINSTANCE.getToolInfo().getName());
		
		// Get the ToolInfo.toolInfoGrammrURI EStructuralFeature
		EStructuralFeature toolInfoGrammarUriEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_ToolInfoGrammarURI().getName());
		
		@SuppressWarnings("unchecked")
		EList<EObject> toolSpecifics = (EList<EObject>) pnObject.eGet(toolSpecificsEStructuralFeature);
		for (EObject toolInfo : toolSpecifics) {
			java.net.URI grammarUri = (java.net.URI) toolInfo.eGet(toolInfoGrammarUriEStructuralFeature);
			if (grammarUri != null && grammarUri.equals(uri)) {
				return toolInfo;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToolInfoEntryByGrammarUri(final EObject pnObject, final String uri, final String value) {
		if (!isEObjectValidPnObject(pnObject)) {
			throw new IllegalArgumentException("Argument is not a valid 'PnObject'");
		}
		
		EObject toolInfo = getToolInfoEntryByGrammarUri(pnObject, uri);
		if (toolInfo != null) {
			// Get the ToolInfo EClass
			EClass toolInfoEClass = toolInfo.eClass();
			
			// Get the ToolInfo.formattedXMLBuffer EStructuralFeature
			EStructuralFeature formattedXMLBufferEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_FormattedXMLBuffer().getName());
			
			toolInfo.eSet(formattedXMLBufferEStructuralFeature, new StringBuffer("<value>" + value + "</value>"));
		} else {
			// Get the EFactory of the package of this Transition
			EFactory eFactoryInstance = pnObject.eClass().getEPackage().getEFactoryInstance();
			
			// Get the Transition EClass
			EClass transEClass = pnObject.eClass();
			
			// Get the PnObject.toolSpecifics EStructuralFeature
			EStructuralFeature toolSpecificsEStructuralFeature = transEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getPnObject_Toolspecifics().getName());
			
			// Get the ToolInfo EClass
			EClass toolInfoEClass = (EClass) transEClass.getEPackage().getEClassifier(PnmlcoremodelPackage.eINSTANCE.getToolInfo().getName());
			
			// Get the ToolInfo.tool EStructuralFeature
			EStructuralFeature toolInfoToolEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_Tool().getName());
			
			// Get the ToolInfo.versionEStructuralFeature
			EStructuralFeature toolInfoVersionEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_Version().getName());
			
			// Get the ToolInfo.toolInfoGrammrURI EStructuralFeature
			EStructuralFeature toolInfoGrammarUriEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_ToolInfoGrammarURI().getName());
			
			// Get the ToolInfo.formattedXMLBuffer EStructuralFeature
			EStructuralFeature formattedXMLBufferEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_FormattedXMLBuffer().getName());
		
			// Finally, add a fresh new ToolInfo entry for the desired TransitionKind
			toolInfo = eFactoryInstance.create(toolInfoEClass);
			toolInfo.eSet(toolInfoToolEStructuralFeature, ToolInfoConstants.TOOL_NAME.getLiteral());
			toolInfo.eSet(toolInfoVersionEStructuralFeature,  ToolInfoConstants.TOOL_VERSION.getLiteral());
			try {
				toolInfo.eSet(toolInfoGrammarUriEStructuralFeature, new java.net.URI(uri));
			} catch (URISyntaxException e) {
				throw new RuntimeException("Unable to convert argument 'uri' to a valid URI");
			}
			toolInfo.eSet(formattedXMLBufferEStructuralFeature, new StringBuffer("<value>" + value + "</value>"));
			
			@SuppressWarnings("unchecked")
			EList<EObject> toolSpecifics = (EList<EObject>) pnObject.eGet(toolSpecificsEStructuralFeature);
			toolSpecifics.add(toolInfo);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransitionKind(final EObject transition, final TransitionKind transitionKind) throws IllegalArgumentException {
		if (!isEObjectValidTransition(transition)) {
			throw new IllegalArgumentException("Argument is not a valid 'Transition'");
		}
		return getToolInfoEntryByGrammarUri(transition, transitionKind.getLiteral()) != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransitionServerType(final EObject transition, final ServerType serverType) throws IllegalArgumentException {
		if (!isEObjectValidTransition(transition)) {
			throw new IllegalArgumentException("Argument is not a valid 'Transition'");
		}
		return getToolInfoEntryByGrammarUri(transition, serverType.getLiteral()) != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionKind(final EObject transition, final TransitionKind transitionKind, final Object value) throws IllegalArgumentException {
		if (!isEObjectValidTransition(transition)) {
			throw new IllegalArgumentException("Argument is not a valid 'Transition'");
		}
		for (TransitionKind kind : TransitionKind.VALUES) {
			deleteToolInfoEntryByGrammarUri(transition, kind.getLiteral());
		}
		setToolInfoEntryByGrammarUri(transition, transitionKind.getLiteral(), value.toString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionServerType(final EObject transition, final ServerType serverType, final Object value) throws IllegalArgumentException {
		if (!isEObjectValidTransition(transition)) {
			throw new IllegalArgumentException("Argument is not a valid 'Transition'");
		}
		for (ServerType type : ServerType.VALUES) {
			deleteToolInfoEntryByGrammarUri(transition, type.getLiteral());
		}
		setToolInfoEntryByGrammarUri(transition, serverType.getLiteral(), value.toString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getTransitionRate(final EObject transition) throws IllegalArgumentException {
		if (!isEObjectValidTransition(transition)) {
			throw new IllegalArgumentException("Argument is not a valid 'Transition'");
		}
		// We only return a rate for Exponential and Immediate Transitions
		EObject toolInfo = getToolInfoEntryByGrammarUri(transition, TransitionKind.EXPONENTIAL.getLiteral());
		if (toolInfo == null) {
			toolInfo = getToolInfoEntryByGrammarUri(transition, TransitionKind.IMMEDIATE.getLiteral());
		}
		if (toolInfo != null) {
			Object stringValue = toolInfo.eGet(toolInfo.eClass().getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_FormattedXMLBuffer().getName()));
			if (stringValue != null) {
				try {
					Pattern pattern = Pattern.compile("<value>(.+)</value>");
					Matcher matcher = pattern.matcher(stringValue.toString().trim());
					matcher.matches();
					return Float.valueOf(matcher.group(1));
				} catch (IllegalStateException | NullPointerException | NumberFormatException e) {
					String message = MessageFormat.format("Expected a float value in ''{0}'' but ''{1}'' found instead", transition, stringValue);
					if (PnextensionsPlugin.getPlugin() != null) {
						PnextensionsPlugin.getPlugin().log(new Status(IStatus.ERROR, 
								PnextensionsPlugin.getPlugin().getBundle().getSymbolicName(),
								message,
								e));
					} else {
						Logger.getLogger(this.getClass().getCanonicalName()).log(Level.SEVERE, message, e);
					}
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PnutilsPackage.TOOL_INFO_UTILS___IS_EOBJECT_VALID_PN_OBJECT__EOBJECT:
				return isEObjectValidPnObject((EObject)arguments.get(0));
			case PnutilsPackage.TOOL_INFO_UTILS___IS_EOBJECT_VALID_TRANSITION__EOBJECT:
				return isEObjectValidTransition((EObject)arguments.get(0));
			case PnutilsPackage.TOOL_INFO_UTILS___GET_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING:
				return getToolInfoEntryByGrammarUri((EObject)arguments.get(0), (String)arguments.get(1));
			case PnutilsPackage.TOOL_INFO_UTILS___DELETE_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING:
				return deleteToolInfoEntryByGrammarUri((EObject)arguments.get(0), (String)arguments.get(1));
			case PnutilsPackage.TOOL_INFO_UTILS___SET_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING_STRING:
				setToolInfoEntryByGrammarUri((EObject)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2));
				return null;
			case PnutilsPackage.TOOL_INFO_UTILS___IS_TRANSITION_KIND__EOBJECT_TRANSITIONKIND:
				return isTransitionKind((EObject)arguments.get(0), (TransitionKind)arguments.get(1));
			case PnutilsPackage.TOOL_INFO_UTILS___IS_TRANSITION_SERVER_TYPE__EOBJECT_SERVERTYPE:
				return isTransitionServerType((EObject)arguments.get(0), (ServerType)arguments.get(1));
			case PnutilsPackage.TOOL_INFO_UTILS___SET_TRANSITION_KIND__EOBJECT_TRANSITIONKIND_OBJECT:
				setTransitionKind((EObject)arguments.get(0), (TransitionKind)arguments.get(1), arguments.get(2));
				return null;
			case PnutilsPackage.TOOL_INFO_UTILS___SET_TRANSITION_SERVER_TYPE__EOBJECT_SERVERTYPE_OBJECT:
				setTransitionServerType((EObject)arguments.get(0), (ServerType)arguments.get(1), arguments.get(2));
				return null;
			case PnutilsPackage.TOOL_INFO_UTILS___GET_TRANSITION_RATE__EOBJECT:
				return getTransitionRate((EObject)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ToolInfoUtilsImpl
