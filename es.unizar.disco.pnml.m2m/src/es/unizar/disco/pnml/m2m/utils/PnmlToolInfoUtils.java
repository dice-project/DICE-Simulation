package es.unizar.disco.pnml.m2m.utils;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

import es.unizar.disco.pnextensions.pnconstants.ServerType;
import es.unizar.disco.pnextensions.pnconstants.TransitionKind;
import es.unizar.disco.pnextensions.pnutils.PnutilsFactory;
import es.unizar.disco.pnextensions.pnutils.ToolInfoUtils;

public class PnmlToolInfoUtils {

	
	private static final ToolInfoUtils TOOL_INFO_UTILS = PnutilsFactory.eINSTANCE.createToolInfoUtils();

	public PnmlToolInfoUtils() {
	}

	/**
	 * @param transition
	 * @param serverType
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType)
	 */
	@Operation(contextual=true)
	public static boolean isTransitionServerType(fr.lip6.move.pnml.pnmlcoremodel.Transition transition, ServerType serverType) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionServerType(transition, serverType);
	}

	/**
	 * @param transition
	 * @param transitionKind
	 * @param value
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind, java.lang.Object)
	 */
	@Operation(contextual=true)
	public static void setTransitionKind(fr.lip6.move.pnml.pnmlcoremodel.Transition transition, TransitionKind transitionKind, Object value)
			throws IllegalArgumentException {
		TOOL_INFO_UTILS.setTransitionKind(transition, transitionKind, value);
	}

	/**
	 * @param transition
	 * @param serverType
	 * @param value
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType, java.lang.Object)
	 */
	@Operation(contextual=true)
	public static void setTransitionServerType(fr.lip6.move.pnml.pnmlcoremodel.Transition transition, ServerType serverType, Object value)
			throws IllegalArgumentException {
		TOOL_INFO_UTILS.setTransitionServerType(transition, serverType, value);
	}

	/**
	 * @param transition
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#getTransitionRate(org.eclipse.emf.ecore.EObject)
	 */
	@Operation(contextual=true)
	public static Float getTransitionRate(fr.lip6.move.pnml.pnmlcoremodel.Transition transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.getTransitionRate(transition);
	}

	/**
	 * @param transition
	 * @param transitionKind
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind)
	 */
	@Operation(contextual=true)
	public static boolean isTransitionKind(fr.lip6.move.pnml.pnmlcoremodel.Transition transition, TransitionKind transitionKind) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionKind(transition, transitionKind);
	}

	/**
	 * @param transition
	 * @param serverType
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType)
	 */
	@Operation(contextual=true)
	public static boolean isTransitionServerType(fr.lip6.move.pnml.ptnet.Transition transition, ServerType serverType) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionServerType(transition, serverType);
	}

	/**
	 * @param transition
	 * @param transitionKind
	 * @param value
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind, java.lang.Object)
	 */
	@Operation(contextual=true)
	public static void setTransitionKind(fr.lip6.move.pnml.ptnet.Transition transition, TransitionKind transitionKind, Object value)
			throws IllegalArgumentException {
		TOOL_INFO_UTILS.setTransitionKind(transition, transitionKind, value);
	}

	/**
	 * @param transition
	 * @param serverType
	 * @param value
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType, java.lang.Object)
	 */
	@Operation(contextual=true)
	public static void setTransitionServerType(fr.lip6.move.pnml.ptnet.Transition transition, ServerType serverType, Object value)
			throws IllegalArgumentException {
		TOOL_INFO_UTILS.setTransitionServerType(transition, serverType, value);
	}

	/**
	 * @param transition
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#getTransitionRate(org.eclipse.emf.ecore.EObject)
	 */
	@Operation(contextual=true)
	public static Float getTransitionRate(fr.lip6.move.pnml.ptnet.Transition transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.getTransitionRate(transition);
	}

	/**
	 * @param transition
	 * @param transitionKind
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind)
	 */
	@Operation(contextual=true)
	public static boolean isTransitionKind(fr.lip6.move.pnml.ptnet.Transition transition, TransitionKind transitionKind) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionKind(transition, transitionKind);
	}

	/**
	 * @param transition
	 * @param serverType
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType)
	 */
	@Operation(contextual=true)
	public static boolean isTransitionServerType(fr.lip6.move.pnml.hlpn.hlcorestructure.Transition transition, ServerType serverType) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionServerType(transition, serverType);
	}

	/**
	 * @param transition
	 * @param transitionKind
	 * @param value
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind, java.lang.Object)
	 */
	@Operation(contextual=true)
	public static void setTransitionKind(fr.lip6.move.pnml.hlpn.hlcorestructure.Transition transition, TransitionKind transitionKind, Object value)
			throws IllegalArgumentException {
		TOOL_INFO_UTILS.setTransitionKind(transition, transitionKind, value);
	}

	/**
	 * @param transition
	 * @param serverType
	 * @param value
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType, java.lang.Object)
	 */
	@Operation(contextual=true)
	public static void setTransitionServerType(fr.lip6.move.pnml.hlpn.hlcorestructure.Transition transition, ServerType serverType, Object value)
			throws IllegalArgumentException {
		TOOL_INFO_UTILS.setTransitionServerType(transition, serverType, value);
	}

	/**
	 * @param transition
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#getTransitionRate(org.eclipse.emf.ecore.EObject)
	 */
	@Operation(contextual=true)
	public static Float getTransitionRate(fr.lip6.move.pnml.hlpn.hlcorestructure.Transition transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.getTransitionRate(transition);
	}

	/**
	 * @param transition
	 * @param transitionKind
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind)
	 */
	@Operation(contextual=true)
	public static boolean isTransitionKind(fr.lip6.move.pnml.hlpn.hlcorestructure.Transition transition, TransitionKind transitionKind) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionKind(transition, transitionKind);
	}

	/**
	 * @param transition
	 * @param serverType
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType)
	 */
	@Operation(contextual=true)
	public static boolean isTransitionServerType(fr.lip6.move.pnml.symmetricnet.hlcorestructure.Transition transition, ServerType serverType) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionServerType(transition, serverType);
	}

	/**
	 * @param transition
	 * @param transitionKind
	 * @param value
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind, java.lang.Object)
	 */
	@Operation(contextual=true)
	public static void setTransitionKind(fr.lip6.move.pnml.symmetricnet.hlcorestructure.Transition transition, TransitionKind transitionKind, Object value)
			throws IllegalArgumentException {
		TOOL_INFO_UTILS.setTransitionKind(transition, transitionKind, value);
	}

	/**
	 * @param transition
	 * @param serverType
	 * @param value
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#setTransitionServerType(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.ServerType, java.lang.Object)
	 */
	@Operation(contextual=true)
	public static void setTransitionServerType(fr.lip6.move.pnml.symmetricnet.hlcorestructure.Transition transition, ServerType serverType, Object value)
			throws IllegalArgumentException {
		TOOL_INFO_UTILS.setTransitionServerType(transition, serverType, value);
	}

	/**
	 * @param transition
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#getTransitionRate(org.eclipse.emf.ecore.EObject)
	 */
	@Operation(contextual=true)
	public static Float getTransitionRate(fr.lip6.move.pnml.symmetricnet.hlcorestructure.Transition transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.getTransitionRate(transition);
	}

	/**
	 * @param transition
	 * @param transitionKind
	 * @return
	 * @throws IllegalArgumentException
	 * @see es.unizar.disco.pnextensions.pnutils.ToolInfoUtils#isTransitionKind(org.eclipse.emf.ecore.EObject, es.unizar.disco.pnextensions.pnconstants.TransitionKind)
	 */
	@Operation(contextual=true)
	public static boolean isTransitionKind(fr.lip6.move.pnml.symmetricnet.hlcorestructure.Transition transition, TransitionKind transitionKind) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionKind(transition, transitionKind);
	}

}
