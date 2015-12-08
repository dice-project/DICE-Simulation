package es.unizar.disco.pnml.m2t.utils;

import java.util.Enumeration;

import org.eclipse.emf.ecore.EObject;

import es.unizar.disco.pnextensions.pnconstants.ServerType;
import es.unizar.disco.pnextensions.pnconstants.TransitionKind;
import es.unizar.disco.pnextensions.pnutils.PnutilsFactory;
import es.unizar.disco.pnextensions.pnutils.ToolInfoUtils;

/**
 * Utility class used to communicate with {@link ToolInfoUtils} since Acceleo seems
 * to have some problems when dealing with {@link Enumeration}s
 * 
 * @author Abel Gómez <abel.gomez@unizar.es>
 *
 */
public class PnmlToolInfoUtils {

	private static final ToolInfoUtils TOOL_INFO_UTILS = PnutilsFactory.eINSTANCE.createToolInfoUtils();

	public PnmlToolInfoUtils() {
	}

	public static boolean isExponential(EObject transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionKind(transition, TransitionKind.EXPONENTIAL);
	}

	public static boolean isDeterministic(EObject transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionKind(transition, TransitionKind.DETERMINISTIC);
	}

	public static boolean isImmediate(EObject transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionKind(transition, TransitionKind.IMMEDIATE);
	}

	public static boolean isOneServer(EObject transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionServerType(transition, ServerType.ONE_SERVER);
	}
	
	public static boolean isInfiniteServer(EObject transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.isTransitionServerType(transition, ServerType.INFINITE_SERVER);
	}
	
	public Float getTransitionRate(EObject transition) throws IllegalArgumentException {
		return TOOL_INFO_UTILS.getTransitionRate(transition);
	}

	
	
}
