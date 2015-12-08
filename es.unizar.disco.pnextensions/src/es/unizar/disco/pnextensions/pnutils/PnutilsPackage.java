/**
 */
package es.unizar.disco.pnextensions.pnutils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see es.unizar.disco.pnextensions.pnutils.PnutilsFactory
 * @model kind="package"
 * @generated
 */
public interface PnutilsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pnutils";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es.unizar.disco/pnutils/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pnutils";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PnutilsPackage eINSTANCE = es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnextensions.pnutils.impl.PnUtilsImpl <em>Pn Utils</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnextensions.pnutils.impl.PnUtilsImpl
	 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getPnUtils()
	 * @generated
	 */
	int PN_UTILS = 0;

	/**
	 * The number of structural features of the '<em>Pn Utils</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PN_UTILS_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Layout</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PN_UTILS___LAYOUT__EOBJECT = 0;

	/**
	 * The number of operations of the '<em>Pn Utils</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PN_UTILS_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnextensions.pnutils.impl.DataTypeUtilsImpl <em>Data Type Utils</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnextensions.pnutils.impl.DataTypeUtilsImpl
	 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getDataTypeUtils()
	 * @generated
	 */
	int DATA_TYPE_UTILS = 1;

	/**
	 * The number of structural features of the '<em>Data Type Utils</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_UTILS_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Create URI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_UTILS___CREATE_URI__STRING = 0;

	/**
	 * The operation id for the '<em>Create Long String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_UTILS___CREATE_LONG_STRING__STRING = 1;

	/**
	 * The number of operations of the '<em>Data Type Utils</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_UTILS_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link es.unizar.disco.pnextensions.pnutils.impl.ToolInfoUtilsImpl <em>Tool Info Utils</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.unizar.disco.pnextensions.pnutils.impl.ToolInfoUtilsImpl
	 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getToolInfoUtils()
	 * @generated
	 */
	int TOOL_INFO_UTILS = 2;

	/**
	 * The number of structural features of the '<em>Tool Info Utils</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Is EObject Valid Pn Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___IS_EOBJECT_VALID_PN_OBJECT__EOBJECT = 0;

	/**
	 * The operation id for the '<em>Is EObject Valid Transition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___IS_EOBJECT_VALID_TRANSITION__EOBJECT = 1;

	/**
	 * The operation id for the '<em>Get Tool Info Entry By Grammar Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___GET_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING = 2;

	/**
	 * The operation id for the '<em>Delete Tool Info Entry By Grammar Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___DELETE_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING = 3;

	/**
	 * The operation id for the '<em>Set Tool Info Entry By Grammar Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___SET_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING_STRING = 4;

	/**
	 * The operation id for the '<em>Is Transition Kind</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___IS_TRANSITION_KIND__EOBJECT_TRANSITIONKIND = 5;

	/**
	 * The operation id for the '<em>Is Transition Server Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___IS_TRANSITION_SERVER_TYPE__EOBJECT_SERVERTYPE = 6;

	/**
	 * The operation id for the '<em>Set Transition Kind</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___SET_TRANSITION_KIND__EOBJECT_TRANSITIONKIND_OBJECT = 7;

	/**
	 * The operation id for the '<em>Set Transition Server Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___SET_TRANSITION_SERVER_TYPE__EOBJECT_SERVERTYPE_OBJECT = 8;

	/**
	 * The operation id for the '<em>Get Transition Rate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS___GET_TRANSITION_RATE__EOBJECT = 9;

	/**
	 * The number of operations of the '<em>Tool Info Utils</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_UTILS_OPERATION_COUNT = 10;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.net.URI
	 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getURI()
	 * @generated
	 */
	int URI = 3;

	/**
	 * The meta object id for the '<em>URI Syntax Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.net.URISyntaxException
	 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getURISyntaxException()
	 * @generated
	 */
	int URI_SYNTAX_EXCEPTION = 4;

	/**
	 * The meta object id for the '<em>String Buffer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.StringBuffer
	 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getStringBuffer()
	 * @generated
	 */
	int STRING_BUFFER = 5;

	/**
	 * The meta object id for the '<em>Illegal Argument Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getIllegalArgumentException()
	 * @generated
	 */
	int ILLEGAL_ARGUMENT_EXCEPTION = 6;


	/**
	 * Returns the meta object for class '{@link es.unizar.disco.pnextensions.pnutils.PnUtils <em>Pn Utils</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pn Utils</em>'.
	 * @see es.unizar.disco.pnextensions.pnutils.PnUtils
	 * @generated
	 */
	EClass getPnUtils();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.PnUtils#layout(org.eclipse.emf.ecore.EObject) <em>Layout</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Layout</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.PnUtils#layout(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getPnUtils__Layout__EObject();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.pnextensions.pnutils.DataTypeUtils <em>Data Type Utils</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Utils</em>'.
	 * @see es.unizar.disco.pnextensions.pnutils.DataTypeUtils
	 * @generated
	 */
	EClass getDataTypeUtils();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.DataTypeUtils#createURI(java.lang.String) <em>Create URI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create URI</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.DataTypeUtils#createURI(java.lang.String)
	 * @generated
	 */
	EOperation getDataTypeUtils__CreateURI__String();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.DataTypeUtils#createLongString(java.lang.String) <em>Create Long String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Long String</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.DataTypeUtils#createLongString(java.lang.String)
	 * @generated
	 */
	EOperation getDataTypeUtils__CreateLongString__String();

	/**
	 * Returns the meta object for class '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils <em>Tool Info Utils</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Info Utils</em>'.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils
	 * @generated
	 */
	EClass getToolInfoUtils();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isEObjectValidPnObject(org.eclipse.emf.ecore.EObject) <em>Is EObject Valid Pn Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is EObject Valid Pn Object</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isEObjectValidPnObject(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getToolInfoUtils__IsEObjectValidPnObject__EObject();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isEObjectValidTransition(org.eclipse.emf.ecore.EObject) <em>Is EObject Valid Transition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is EObject Valid Transition</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isEObjectValidTransition(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getToolInfoUtils__IsEObjectValidTransition__EObject();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#getToolInfoEntryByGrammarUri(org.eclipse.emf.ecore.EObject, java.lang.String) <em>Get Tool Info Entry By Grammar Uri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Tool Info Entry By Grammar Uri</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#getToolInfoEntryByGrammarUri(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * @generated
	 */
	EOperation getToolInfoUtils__GetToolInfoEntryByGrammarUri__EObject_String();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#deleteToolInfoEntryByGrammarUri(org.eclipse.emf.ecore.EObject, java.lang.String) <em>Delete Tool Info Entry By Grammar Uri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Tool Info Entry By Grammar Uri</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#deleteToolInfoEntryByGrammarUri(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * @generated
	 */
	EOperation getToolInfoUtils__DeleteToolInfoEntryByGrammarUri__EObject_String();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setToolInfoEntryByGrammarUri(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.String) <em>Set Tool Info Entry By Grammar Uri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Tool Info Entry By Grammar Uri</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setToolInfoEntryByGrammarUri(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getToolInfoUtils__SetToolInfoEntryByGrammarUri__EObject_String_String();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind) <em>Is Transition Kind</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Transition Kind</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind)
	 * @generated
	 */
	EOperation getToolInfoUtils__IsTransitionKind__EObject_TransitionKind();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType) <em>Is Transition Server Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Transition Server Type</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType)
	 * @generated
	 */
	EOperation getToolInfoUtils__IsTransitionServerType__EObject_ServerType();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind, java.lang.Object) <em>Set Transition Kind</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Transition Kind</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind, java.lang.Object)
	 * @generated
	 */
	EOperation getToolInfoUtils__SetTransitionKind__EObject_TransitionKind_Object();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType, java.lang.Object) <em>Set Transition Server Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Transition Server Type</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType, java.lang.Object)
	 * @generated
	 */
	EOperation getToolInfoUtils__SetTransitionServerType__EObject_ServerType_Object();

	/**
	 * Returns the meta object for the '{@link es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#getTransitionRate(org.eclipse.emf.ecore.EObject) <em>Get Transition Rate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Transition Rate</em>' operation.
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#getTransitionRate(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getToolInfoUtils__GetTransitionRate__EObject();

	/**
	 * Returns the meta object for data type '{@link java.net.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see java.net.URI
	 * @model instanceClass="java.net.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the meta object for data type '{@link java.net.URISyntaxException <em>URI Syntax Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI Syntax Exception</em>'.
	 * @see java.net.URISyntaxException
	 * @model instanceClass="java.net.URISyntaxException" serializeable="false"
	 * @generated
	 */
	EDataType getURISyntaxException();

	/**
	 * Returns the meta object for data type '{@link java.lang.StringBuffer <em>String Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Buffer</em>'.
	 * @see java.lang.StringBuffer
	 * @model instanceClass="java.lang.StringBuffer"
	 * @generated
	 */
	EDataType getStringBuffer();

	/**
	 * Returns the meta object for data type '{@link java.lang.IllegalArgumentException <em>Illegal Argument Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Illegal Argument Exception</em>'.
	 * @see java.lang.IllegalArgumentException
	 * @model instanceClass="java.lang.IllegalArgumentException" serializeable="false"
	 * @generated
	 */
	EDataType getIllegalArgumentException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PnutilsFactory getPnutilsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link es.unizar.disco.pnextensions.pnutils.impl.PnUtilsImpl <em>Pn Utils</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnextensions.pnutils.impl.PnUtilsImpl
		 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getPnUtils()
		 * @generated
		 */
		EClass PN_UTILS = eINSTANCE.getPnUtils();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PN_UTILS___LAYOUT__EOBJECT = eINSTANCE.getPnUtils__Layout__EObject();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.pnextensions.pnutils.impl.DataTypeUtilsImpl <em>Data Type Utils</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnextensions.pnutils.impl.DataTypeUtilsImpl
		 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getDataTypeUtils()
		 * @generated
		 */
		EClass DATA_TYPE_UTILS = eINSTANCE.getDataTypeUtils();

		/**
		 * The meta object literal for the '<em><b>Create URI</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_TYPE_UTILS___CREATE_URI__STRING = eINSTANCE.getDataTypeUtils__CreateURI__String();

		/**
		 * The meta object literal for the '<em><b>Create Long String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_TYPE_UTILS___CREATE_LONG_STRING__STRING = eINSTANCE.getDataTypeUtils__CreateLongString__String();

		/**
		 * The meta object literal for the '{@link es.unizar.disco.pnextensions.pnutils.impl.ToolInfoUtilsImpl <em>Tool Info Utils</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.unizar.disco.pnextensions.pnutils.impl.ToolInfoUtilsImpl
		 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getToolInfoUtils()
		 * @generated
		 */
		EClass TOOL_INFO_UTILS = eINSTANCE.getToolInfoUtils();

		/**
		 * The meta object literal for the '<em><b>Is EObject Valid Pn Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___IS_EOBJECT_VALID_PN_OBJECT__EOBJECT = eINSTANCE.getToolInfoUtils__IsEObjectValidPnObject__EObject();

		/**
		 * The meta object literal for the '<em><b>Is EObject Valid Transition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___IS_EOBJECT_VALID_TRANSITION__EOBJECT = eINSTANCE.getToolInfoUtils__IsEObjectValidTransition__EObject();

		/**
		 * The meta object literal for the '<em><b>Get Tool Info Entry By Grammar Uri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___GET_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING = eINSTANCE.getToolInfoUtils__GetToolInfoEntryByGrammarUri__EObject_String();

		/**
		 * The meta object literal for the '<em><b>Delete Tool Info Entry By Grammar Uri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___DELETE_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING = eINSTANCE.getToolInfoUtils__DeleteToolInfoEntryByGrammarUri__EObject_String();

		/**
		 * The meta object literal for the '<em><b>Set Tool Info Entry By Grammar Uri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___SET_TOOL_INFO_ENTRY_BY_GRAMMAR_URI__EOBJECT_STRING_STRING = eINSTANCE.getToolInfoUtils__SetToolInfoEntryByGrammarUri__EObject_String_String();

		/**
		 * The meta object literal for the '<em><b>Is Transition Kind</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___IS_TRANSITION_KIND__EOBJECT_TRANSITIONKIND = eINSTANCE.getToolInfoUtils__IsTransitionKind__EObject_TransitionKind();

		/**
		 * The meta object literal for the '<em><b>Is Transition Server Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___IS_TRANSITION_SERVER_TYPE__EOBJECT_SERVERTYPE = eINSTANCE.getToolInfoUtils__IsTransitionServerType__EObject_ServerType();

		/**
		 * The meta object literal for the '<em><b>Set Transition Kind</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___SET_TRANSITION_KIND__EOBJECT_TRANSITIONKIND_OBJECT = eINSTANCE.getToolInfoUtils__SetTransitionKind__EObject_TransitionKind_Object();

		/**
		 * The meta object literal for the '<em><b>Set Transition Server Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___SET_TRANSITION_SERVER_TYPE__EOBJECT_SERVERTYPE_OBJECT = eINSTANCE.getToolInfoUtils__SetTransitionServerType__EObject_ServerType_Object();

		/**
		 * The meta object literal for the '<em><b>Get Transition Rate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOOL_INFO_UTILS___GET_TRANSITION_RATE__EOBJECT = eINSTANCE.getToolInfoUtils__GetTransitionRate__EObject();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.net.URI
		 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '<em>URI Syntax Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.net.URISyntaxException
		 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getURISyntaxException()
		 * @generated
		 */
		EDataType URI_SYNTAX_EXCEPTION = eINSTANCE.getURISyntaxException();

		/**
		 * The meta object literal for the '<em>String Buffer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.StringBuffer
		 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getStringBuffer()
		 * @generated
		 */
		EDataType STRING_BUFFER = eINSTANCE.getStringBuffer();

		/**
		 * The meta object literal for the '<em>Illegal Argument Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.IllegalArgumentException
		 * @see es.unizar.disco.pnextensions.pnutils.impl.PnutilsPackageImpl#getIllegalArgumentException()
		 * @generated
		 */
		EDataType ILLEGAL_ARGUMENT_EXCEPTION = eINSTANCE.getIllegalArgumentException();

	}

} //PnutilsPackage
