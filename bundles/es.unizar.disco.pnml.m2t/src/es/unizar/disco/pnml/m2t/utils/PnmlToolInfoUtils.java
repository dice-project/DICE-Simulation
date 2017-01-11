package es.unizar.disco.pnml.m2t.utils;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.unizar.disco.pnextensions.pnconstants.ArcKind;
import es.unizar.disco.pnextensions.pnconstants.Color;
import es.unizar.disco.pnextensions.pnconstants.ServerType;
import es.unizar.disco.pnextensions.pnconstants.TransitionKind;
import fr.lip6.move.pnml.ptnet.Arc;
import fr.lip6.move.pnml.ptnet.ToolInfo;
import fr.lip6.move.pnml.ptnet.Transition;

/**
 * Utility class used to communicate with {@link ToolInfoUtils} since Acceleo
 * seems to have some problems when dealing with {@link Enumeration}s
 * 
 * @author Abel G�mez <abel.gomez@unizar.es>
 *
 */
public class PnmlToolInfoUtils {

	public static final String VALUE_PATTERN = "<value grammar=\"(.+)\">(.+)</value>";
	private static final String SERVER_TYPE_PATTERN = "<value grammar=\"(.+)\"/>";
	private static final String COLOR_PATTERN = "<value grammar=\"([^>]+)\">([^<]+)</value>";
	private static final String ARC_TYPE_PATTERN = "<value grammar=\"(.+)\"/>"; /**/

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

	public static boolean isImmediatePriority(Transition transition) throws IllegalArgumentException {
		for (ToolInfo info : transition.getToolspecifics()) {
			Matcher matcher = Pattern.compile(VALUE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches()) {
				if (TransitionKind.IMMEDIATE_PRIORITY.getLiteral().equals(matcher.group(1))) {
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
	
	public static Integer getTransitionPriority(Transition transition) throws IllegalArgumentException {
		for (ToolInfo info : transition.getToolspecifics()) {
			Matcher matcher = Pattern.compile(VALUE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches() && TransitionKind.IMMEDIATE_PRIORITY.getLiteral().equals(matcher.group(1))) {
				return Integer.valueOf(matcher.group(2));
			}
		}
		return 1;
	}

	public static boolean isNormalArc(Arc arc) throws IllegalArgumentException {
		for (ToolInfo info : arc.getToolspecifics()) {
			Matcher matcher = Pattern.compile(ARC_TYPE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches() && ArcKind.NORMAL.getLiteral().equals(matcher.group(1))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isInhibitorArc(Arc arc) throws IllegalArgumentException {
		for (ToolInfo info : arc.getToolspecifics()) {
			Matcher matcher = Pattern.compile(ARC_TYPE_PATTERN).matcher(info.getFormattedXMLBuffer());
			if (matcher.matches() && ArcKind.INHIBITOR.getLiteral().equals(matcher.group(1))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isColorSet(ToolInfo toolinfo) throws IllegalArgumentException {
		Matcher matcher = Pattern.compile(COLOR_PATTERN).matcher(toolinfo.getFormattedXMLBuffer());
		boolean find = matcher.find();
		if (find && Color.COLORSET.getLiteral().equals(matcher.group(1))) {
			return true;
		}
		return false;
	}
	
	public static boolean isColor(ToolInfo toolinfo) throws IllegalArgumentException {
		Matcher matcher = Pattern.compile(COLOR_PATTERN).matcher(toolinfo.getFormattedXMLBuffer());
		boolean find = matcher.find(); 
		if (find && Color.COLOR.getLiteral().equals(matcher.group(1))) {
			return true;
		}
		return false;
	}
	
	public String getColorSetName(ToolInfo toolinfo) throws IllegalArgumentException {
		Matcher matcher = Pattern.compile(COLOR_PATTERN).matcher(toolinfo.getFormattedXMLBuffer());
		boolean find = matcher.find();
		if (find && Color.COLORSET.getLiteral().equals(matcher.group(1))) {
			return String.valueOf(matcher.group(2));
		}
		return null;
	}

	public Integer getColorSetTypeIndex(ToolInfo toolinfo) throws IllegalArgumentException {
		Matcher matcher = Pattern.compile(COLOR_PATTERN).matcher(toolinfo.getFormattedXMLBuffer());
		matcher.find();
		boolean find = matcher.find();
		//matcher.find(2) 
		if (find && Color.COLORSET.getLiteral().equals(matcher.group(1))) {
			return Integer.valueOf(matcher.group(2));
		}
		return 0;
	}
	
	public String getColorSetType(ToolInfo toolinfo) throws IllegalArgumentException {
		return getColorSetTypeIndex(toolinfo).toString();
		//return null;
	}
	
	public String getColorName(ToolInfo toolinfo) throws IllegalArgumentException {
		return getColorSetNameColor(toolinfo)+getColorNameIndex(toolinfo);
	}
	
	public String getColorNameIndex(ToolInfo toolinfo) throws IllegalArgumentException {
		Matcher matcher = Pattern.compile(COLOR_PATTERN).matcher(toolinfo.getFormattedXMLBuffer());
		int a = Character.getNumericValue('a');
		boolean find = matcher.find();
		if (find && Color.COLOR.getLiteral().equals(matcher.group(1))) {
			//return String.valueOf(matcher.group(2));
			return String.valueOf(Character.forDigit(a+Integer.parseInt(matcher.group(2)), 36));
		}
		return null;
	}
	
	public String getColorSetNameColor(ToolInfo toolinfo) throws IllegalArgumentException {
		Matcher matcher = Pattern.compile(COLOR_PATTERN).matcher(toolinfo.getFormattedXMLBuffer());
		matcher.find();
		boolean find = matcher.find();
		//matcher.find(2)
		if (find && Color.COLOR.getLiteral().equals(matcher.group(1))) {
			return String.valueOf(matcher.group(2));//"21";
		}
		return null; //"2"
	}
	
	public Integer getnumElementsColor(ToolInfo toolinfo) throws IllegalArgumentException {
		Matcher matcher = Pattern.compile(COLOR_PATTERN).matcher(toolinfo.getFormattedXMLBuffer());
		matcher.find();
		matcher.find();
		boolean find = matcher.find();
		//matcher.find(3)
		if (find && Color.COLOR.getLiteral().equals(matcher.group(1))) {
			return Integer.valueOf(matcher.group(2));
		}
		return 0;
	}
	
	public String getnumElementsColor2(ToolInfo toolinfo) throws IllegalArgumentException {
		Matcher matcher = Pattern.compile(COLOR_PATTERN).matcher(toolinfo.getFormattedXMLBuffer());
		matcher.find();
		matcher.find();
		boolean find = matcher.find();
		//matcher.find(3)
		if (find && Color.COLOR.getLiteral().equals(matcher.group(1))) {
			return matcher.group(2);
		}
		return null;
	}
}
