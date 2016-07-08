package es.unizar.disco.pnml.m2t.utils;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.unizar.disco.pnextensions.pnconstants.ServerType;
import es.unizar.disco.pnextensions.pnconstants.TransitionKind;
import fr.lip6.move.pnml.ptnet.ToolInfo;
import fr.lip6.move.pnml.ptnet.Transition;

/**
 * Utility class used to communicate with {@link ToolInfoUtils} since Acceleo
 * seems to have some problems when dealing with {@link Enumeration}s
 * 
 * @author Abel Gómez <abel.gomez@unizar.es>
 *
 */
public class PnmlToolInfoUtils {

	private static final String VALUE_PATTERN = "<value grammar=\"(.+)\">(.+)</value>";
	private static final String SERVER_TYPE_PATTERN = "<value grammar=\"(.+)\"/>";

	public PnmlToolInfoUtils() {
	}

	public static boolean isExponential(Transition transition) throws IllegalArgumentException {
		for (ToolInfo info : transition.getToolspecifics()) {
			Matcher matcher = Pattern.compile(VALUE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches()) {
				if (TransitionKind.EXPONENTIAL.getLiteral().equals(matcher.group(1))) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isImmediate(Transition transition) throws IllegalArgumentException {
		Set<String> otherTransitionKinds = new HashSet<>();
		otherTransitionKinds.add(TransitionKind.EXPONENTIAL.getLiteral());
		otherTransitionKinds.add(TransitionKind.DETERMINISTIC.getLiteral());

		for (ToolInfo info : transition.getToolspecifics()) {
			Matcher matcher = Pattern.compile(VALUE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches()) {
				String uri = matcher.group(1);
				if (TransitionKind.IMMEDIATE.getLiteral().equals(uri)) {
					return true;
				} else if (otherTransitionKinds.contains(uri)) {
					return false;
				}
			}
		}
		// We return true since if no transition kind has been specified it is
		// immediate
		return true;
	}

	public static boolean isOneServer(Transition transition) throws IllegalArgumentException {
		for (ToolInfo info : transition.getToolspecifics()) {
			Matcher matcher = Pattern.compile(SERVER_TYPE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches() && ServerType.ONE_SERVER.getLiteral().equals(matcher.group(1))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isInfiniteServer(Transition transition) throws IllegalArgumentException {
		for (ToolInfo info : transition.getToolspecifics()) {
			Matcher matcher = Pattern.compile(SERVER_TYPE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches() && ServerType.INFINITE_SERVER.getLiteral().equals(matcher.group(1))) {
				return true;
			}
		}
		return false;
	}

	public Float getTransitionRate(Transition transition) throws IllegalArgumentException {
		for (ToolInfo info : transition.getToolspecifics()) {
			Matcher matcher = Pattern.compile(VALUE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches() && TransitionKind.EXPONENTIAL.getLiteral().equals(matcher.group(1))) {
				return Float.valueOf(matcher.group(2));
			}
		}
		return 1f;
	}

	public Float getTransitionProbability(Transition transition) throws IllegalArgumentException {
		for (ToolInfo info : transition.getToolspecifics()) {
			Matcher matcher = Pattern.compile(VALUE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches() && TransitionKind.IMMEDIATE.getLiteral().equals(matcher.group(1))) {
				return Float.valueOf(matcher.group(2));
			}
		}
		return 1f;
	}

}
