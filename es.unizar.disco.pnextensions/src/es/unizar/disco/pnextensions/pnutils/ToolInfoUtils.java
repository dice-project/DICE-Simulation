/**
 */
package es.unizar.disco.pnextensions.pnutils;

import es.unizar.disco.pnextensions.pnconstants.ServerType;
import es.unizar.disco.pnextensions.pnconstants.TransitionKind;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool Info Utils</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see es.unizar.disco.pnextensions.pnutils.PnutilsPackage#getToolInfoUtils()
 * @model
 * @generated
 */
public interface ToolInfoUtils extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// Get the Transition EClass\r\nEPackage ePackage = eObject.eClass().getEPackage();\r\n\r\n// Get the PnObject EClass\r\nEClass pnObjectEClass = (EClass) ePackage.getEClassifier(PnmlcoremodelPackage.eINSTANCE.getPnObject().getName());\r\n\r\ntry {\r\n\tif (pnObjectEClass.isSuperTypeOf(eObject.eClass())) {\r\n\t\treturn true;\r\n\t}\r\n} catch (NullPointerException e) {\r\n}\r\nreturn false;'"
	 * @generated
	 */
	boolean isEObjectValidPnObject(EObject eObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// Get the Transition EClass\r\nEPackage ePackage = eObject.eClass().getEPackage();\r\n\r\n// Get the Transition EClass\r\nEClass transitionEClass = (EClass) ePackage.getEClassifier(PnmlcoremodelPackage.eINSTANCE.getTransition().getName());\r\n\r\ntry {\r\n\tif (transitionEClass.isInstance(eObject)) {\r\n\t\treturn true;\r\n\t}\r\n} catch (NullPointerException e) {\r\n}\r\nreturn false;'"
	 * @generated
	 */
	boolean isEObjectValidTransition(EObject eObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!isEObjectValidPnObject(pnObject)) {\r\n\tthrow new IllegalArgumentException(\"Argument is not a valid \'PnObject\'\");\r\n}\r\n\r\n// Get the Transition EClass\r\nEClass transEClass = pnObject.eClass();\r\n\r\n// Get the PnObject.toolSpecifics EStructuralFeature\r\nEStructuralFeature toolSpecificsEStructuralFeature = transEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getPnObject_Toolspecifics().getName());\r\n\r\n// Get the ToolInfo EClass\r\nEClass toolInfoEClass = (EClass) transEClass.getEPackage().getEClassifier(PnmlcoremodelPackage.eINSTANCE.getToolInfo().getName());\r\n\r\n// Get the ToolInfo.toolInfoGrammrURI EStructuralFeature\r\nEStructuralFeature toolInfoGrammarUriEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_ToolInfoGrammarURI().getName());\r\n\r\n@SuppressWarnings(\"unchecked\")\r\nEList<EObject> toolSpecifics = (EList<EObject>) pnObject.eGet(toolSpecificsEStructuralFeature);\r\nfor (EObject toolInfo : toolSpecifics) {\r\n\tjava.net.URI grammarUri = (java.net.URI) toolInfo.eGet(toolInfoGrammarUriEStructuralFeature);\r\n\tif (grammarUri != null && grammarUri.toString().equals(uri)) {\r\n\t\treturn toolInfo;\r\n\t}\r\n}\r\nreturn null;'"
	 * @generated
	 */
	EObject getToolInfoEntryByGrammarUri(EObject pnObject, String uri);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!isEObjectValidPnObject(pnObject)) {\r\n\tthrow new IllegalArgumentException(\"Argument is not a valid \'PnObject\'\");\r\n}\r\n\r\n// Get the Transition EClass\r\nEClass transEClass = pnObject.eClass();\r\n\r\n// Get the PnObject.toolSpecifics EStructuralFeature\r\nEStructuralFeature toolSpecificsEStructuralFeature = transEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getPnObject_Toolspecifics().getName());\r\n\r\n// Get the ToolInfo EClass\r\nEClass toolInfoEClass = (EClass) transEClass.getEPackage().getEClassifier(PnmlcoremodelPackage.eINSTANCE.getToolInfo().getName());\r\n\r\n// Get the ToolInfo.toolInfoGrammrURI EStructuralFeature\r\nEStructuralFeature toolInfoGrammarUriEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_ToolInfoGrammarURI().getName());\r\n\r\n@SuppressWarnings(\"unchecked\")\r\nEList<EObject> toolSpecifics = (EList<EObject>) pnObject.eGet(toolSpecificsEStructuralFeature);\r\nfor (EObject toolInfo : toolSpecifics) {\r\n\tjava.net.URI grammarUri = (java.net.URI) toolInfo.eGet(toolInfoGrammarUriEStructuralFeature);\r\n\tif (grammarUri != null && grammarUri.equals(uri)) {\r\n\t\treturn toolInfo;\r\n\t}\r\n}\r\nreturn null;'"
	 * @generated
	 */
	EObject deleteToolInfoEntryByGrammarUri(EObject pnObject, String uri);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!isEObjectValidPnObject(pnObject)) {\r\n\tthrow new IllegalArgumentException(\"Argument is not a valid \'PnObject\'\");\r\n}\r\n\r\nEObject toolInfo = getToolInfoEntryByGrammarUri(pnObject, uri);\r\nif (toolInfo != null) {\r\n\t// Get the ToolInfo EClass\r\n\tEClass toolInfoEClass = toolInfo.eClass();\r\n\t\r\n\t// Get the ToolInfo.formattedXMLBuffer EStructuralFeature\r\n\tEStructuralFeature formattedXMLBufferEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_FormattedXMLBuffer().getName());\r\n\t\r\n\ttoolInfo.eSet(formattedXMLBufferEStructuralFeature, new StringBuffer(\"<value>\" + value + \"</value>\"));\r\n} else {\r\n\t// Get the EFactory of the package of this Transition\r\n\tEFactory eFactoryInstance = pnObject.eClass().getEPackage().getEFactoryInstance();\r\n\t\r\n\t// Get the Transition EClass\r\n\tEClass transEClass = pnObject.eClass();\r\n\t\r\n\t// Get the PnObject.toolSpecifics EStructuralFeature\r\n\tEStructuralFeature toolSpecificsEStructuralFeature = transEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getPnObject_Toolspecifics().getName());\r\n\t\r\n\t// Get the ToolInfo EClass\r\n\tEClass toolInfoEClass = (EClass) transEClass.getEPackage().getEClassifier(PnmlcoremodelPackage.eINSTANCE.getToolInfo().getName());\r\n\t\r\n\t// Get the ToolInfo.tool EStructuralFeature\r\n\tEStructuralFeature toolInfoToolEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_Tool().getName());\r\n\t\r\n\t// Get the ToolInfo.versionEStructuralFeature\r\n\tEStructuralFeature toolInfoVersionEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_Version().getName());\r\n\t\r\n\t// Get the ToolInfo.toolInfoGrammrURI EStructuralFeature\r\n\tEStructuralFeature toolInfoGrammarUriEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_ToolInfoGrammarURI().getName());\r\n\t\r\n\t// Get the ToolInfo.formattedXMLBuffer EStructuralFeature\r\n\tEStructuralFeature formattedXMLBufferEStructuralFeature = toolInfoEClass.getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_FormattedXMLBuffer().getName());\r\n\r\n\t// Finally, add a fresh new ToolInfo entry for the desired TransitionKind\r\n\ttoolInfo = eFactoryInstance.create(toolInfoEClass);\r\n\ttoolInfo.eSet(toolInfoToolEStructuralFeature, ToolInfoConstants.TOOL_NAME.getLiteral());\r\n\ttoolInfo.eSet(toolInfoVersionEStructuralFeature,  ToolInfoConstants.TOOL_VERSION.getLiteral());\r\n\ttry {\r\n\t\ttoolInfo.eSet(toolInfoGrammarUriEStructuralFeature, new java.net.URI(uri));\r\n\t} catch (URISyntaxException e) {\r\n\t\tthrow new RuntimeException(\"Unable to convert argument \'uri\' to a valid URI\");\r\n\t}\r\n\ttoolInfo.eSet(formattedXMLBufferEStructuralFeature, new StringBuffer(\"<value>\" + value + \"</value>\"));\r\n\t\r\n\t@SuppressWarnings(\"unchecked\")\r\n\tEList<EObject> toolSpecifics = (EList<EObject>) pnObject.eGet(toolSpecificsEStructuralFeature);\r\n\ttoolSpecifics.add(toolInfo);\r\n}'"
	 * @generated
	 */
	void setToolInfoEntryByGrammarUri(EObject pnObject, String uri, String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="es.unizar.disco.pnextensions.pnutils.IllegalArgumentException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!isEObjectValidTransition(transition)) {\r\n\tthrow new IllegalArgumentException(\"Argument is not a valid \'Transition\'\");\r\n}\r\nreturn getToolInfoEntryByGrammarUri(transition, transitionKind.getLiteral()) != null;'"
	 * @generated
	 */
	boolean isTransitionKind(EObject transition, TransitionKind transitionKind) throws IllegalArgumentException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="es.unizar.disco.pnextensions.pnutils.IllegalArgumentException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!isEObjectValidTransition(transition)) {\r\n\tthrow new IllegalArgumentException(\"Argument is not a valid \'Transition\'\");\r\n}\r\nreturn getToolInfoEntryByGrammarUri(transition, serverType.getLiteral()) != null;'"
	 * @generated
	 */
	boolean isTransitionServerType(EObject transition, ServerType serverType) throws IllegalArgumentException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="es.unizar.disco.pnextensions.pnutils.IllegalArgumentException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!isEObjectValidTransition(transition)) {\r\n\tthrow new IllegalArgumentException(\"Argument is not a valid \'Transition\'\");\r\n}\r\nfor (TransitionKind kind : TransitionKind.VALUES) {\r\n\tdeleteToolInfoEntryByGrammarUri(transition, kind.getLiteral());\r\n}\r\nsetToolInfoEntryByGrammarUri(transition, transitionKind.getLiteral(), value.toString());'"
	 * @generated
	 */
	void setTransitionKind(EObject transition, TransitionKind transitionKind, Object value) throws IllegalArgumentException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="es.unizar.disco.pnextensions.pnutils.IllegalArgumentException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!isEObjectValidTransition(transition)) {\r\n\tthrow new IllegalArgumentException(\"Argument is not a valid \'Transition\'\");\r\n}\r\nfor (ServerType type : ServerType.VALUES) {\r\n\tdeleteToolInfoEntryByGrammarUri(transition, type.getLiteral());\r\n}\r\nsetToolInfoEntryByGrammarUri(transition, serverType.getLiteral(), value.toString());'"
	 * @generated
	 */
	void setTransitionServerType(EObject transition, ServerType serverType, Object value) throws IllegalArgumentException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="es.unizar.disco.pnextensions.pnutils.IllegalArgumentException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!isEObjectValidTransition(transition)) {\r\n\tthrow new IllegalArgumentException(\"Argument is not a valid \'Transition\'\");\r\n}\r\n// We only return a rate for Exponential and Immediate Transitions\r\nEObject toolInfo = getToolInfoEntryByGrammarUri(transition, TransitionKind.EXPONENTIAL.getLiteral());\r\nif (toolInfo == null) {\r\n\ttoolInfo = getToolInfoEntryByGrammarUri(transition, TransitionKind.IMMEDIATE.getLiteral());\r\n}\r\nif (toolInfo != null) {\r\n\tObject stringValue = toolInfo.eGet(toolInfo.eClass().getEStructuralFeature(PnmlcoremodelPackage.eINSTANCE.getToolInfo_FormattedXMLBuffer().getName()));\r\n\tif (stringValue != null) {\r\n\t\ttry {\r\n\t\t\tPattern pattern = Pattern.compile(\"<value>(.+)</value>\");\r\n\t\t\tMatcher matcher = pattern.matcher(stringValue.toString().trim());\r\n\t\t\tmatcher.matches();\r\n\t\t\treturn Float.valueOf(matcher.group(1));\r\n\t\t} catch (IllegalStateException | NullPointerException | NumberFormatException e) {\r\n\t\t\tString message = MessageFormat.format(\"Expected a float value in \'\'{0}\'\' but \'\'{1}\'\' found instead\", transition, stringValue);\r\n\t\t\tif (PnextensionsPlugin.getPlugin() != null) {\r\n\t\t\t\tPnextensionsPlugin.getPlugin().log(new Status(IStatus.ERROR, \r\n\t\t\t\t\t\tPnextensionsPlugin.getPlugin().getBundle().getSymbolicName(),\r\n\t\t\t\t\t\tmessage,\r\n\t\t\t\t\t\te));\r\n\t\t\t} else {\r\n\t\t\t\tLogger.getLogger(this.getClass().getCanonicalName()).log(Level.SEVERE, message, e);\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n}\r\nreturn null;'"
	 * @generated
	 */
	Float getTransitionRate(EObject transition) throws IllegalArgumentException;

} // ToolInfoUtils
