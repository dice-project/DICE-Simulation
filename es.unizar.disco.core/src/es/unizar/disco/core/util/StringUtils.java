package es.unizar.disco.core.util;

public class StringUtils {

	/**
	 * <p>
	 * Compares two CharSequences, returning {@code true} if they represent
	 * equal sequences of characters.
	 * </p>
	 *
	 * <p>
	 * {@code null}s are handled without exceptions. Two {@code null} references
	 * are considered to be equal. The comparison is case sensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.equals(null, null)   = true
	 * StringUtils.equals(null, "abc")  = false
	 * StringUtils.equals("abc", null)  = false
	 * StringUtils.equals("abc", "abc") = true
	 * StringUtils.equals("abc", "ABC") = false
	 * </pre>
	 *
	 * @see Object#equals(Object)
	 * @param cs1
	 *            the first CharSequence, may be {@code null}
	 * @param cs2
	 *            the second CharSequence, may be {@code null}
	 * @return {@code true} if the CharSequences are equal (case-sensitive), or
	 *         both {@code null}
	 * @since 3.0 Changed signature from equals(String, String) to
	 *        equals(CharSequence, CharSequence)
	 */
	public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
		if (cs1 == cs2) {
			return true;
		}
		if (cs1 == null || cs2 == null) {
			return false;
		}
		if (cs1 instanceof String && cs2 instanceof String) {
			return cs1.equals(cs2);
		}
		return regionMatches(cs1, false, 0, cs2, 0, Math.max(cs1.length(), cs2.length()));
	}

	/**
	 * Green implementation of regionMatches.
	 *
	 * @param cs
	 *            the {@code CharSequence} to be processed
	 * @param ignoreCase
	 *            whether or not to be case insensitive
	 * @param thisStart
	 *            the index to start on the {@code cs} CharSequence
	 * @param substring
	 *            the {@code CharSequence} to be looked for
	 * @param start
	 *            the index to start on the {@code substring} CharSequence
	 * @param length
	 *            character length of the region
	 * @return whether the region matched
	 */
	static boolean regionMatches(final CharSequence cs, final boolean ignoreCase, final int thisStart,
			final CharSequence substring, final int start, final int length) {
		if (cs instanceof String && substring instanceof String) {
			return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
		}
		int index1 = thisStart;
		int index2 = start;
		int tmpLen = length;

		while (tmpLen-- > 0) {
			final char c1 = cs.charAt(index1++);
			final char c2 = substring.charAt(index2++);

			if (c1 == c2) {
				continue;
			}

			if (!ignoreCase) {
				return false;
			}

			// The same check as in String.regionMatches():
			if (Character.toUpperCase(c1) != Character.toUpperCase(c2)
					&& Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
				return false;
			}
		}

		return true;
	}

}
