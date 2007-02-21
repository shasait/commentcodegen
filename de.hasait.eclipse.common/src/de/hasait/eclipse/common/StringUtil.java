/*
 * $Id: StringUtil.java,v 1.6 2007-02-21 00:04:12 concentus Exp $
 * 
 * Copyright 2005 Sebastian Hasait
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.hasait.eclipse.common;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.6 $
 */
public final class StringUtil {
	private StringUtil() {
		super();
	}

	public static boolean isEmpty(final String pInput) {
		return pInput == null || pInput.length() == 0;
	}

	public static boolean equalsAny(final String pInput, final String[] pAnyOf) {
		if (pInput != null && pAnyOf != null) {
			for (int i = 0; i < pAnyOf.length; i++) {
				if (pInput.equals(pAnyOf[i])) {
					return true;
				}
			}
		}
		return false;
	}

	public static String capitalize(final String pInput) {
		if (pInput == null || pInput.length() == 0) {
			return pInput;
		}
		char[] chars = pInput.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		return new String(chars);
	}

	public static String uncapitalize(final String pInput) {
		if (pInput == null || pInput.length() == 0) {
			return pInput;
		}
		char[] chars = pInput.toCharArray();
		chars[0] = Character.toLowerCase(chars[0]);
		return new String(chars);
	}

	public static String camelCaseToUpperCase(final String camelCase) {
		StringBuffer result = new StringBuffer();
		boolean lastWasNotUpperCase = false;
		for (int chI = 0; chI < camelCase.length(); chI++) {
			char ch = camelCase.charAt(chI);
			if (Character.isUpperCase(ch)) {
				if (lastWasNotUpperCase) {
					result.append("_");
				}
			} else {
				lastWasNotUpperCase = true;
			}
			result.append(Character.toUpperCase(ch));
		}
		return result.toString();
	}

	public static String replaceAll(final String pInput, final Map pReplacements) {
		if (pInput == null) {
			return null;
		}
		Iterator replacementsI = pReplacements.entrySet().iterator();
		Map.Entry replacement;
		String current = pInput;
		while (replacementsI.hasNext()) {
			replacement = (Map.Entry) replacementsI.next();
			current = replace(current, (String) replacement.getKey(), (String) replacement.getValue());
		}
		return current;
	}

	public static String replace(final String pInput, final String pSearch, final String pReplace) {
		if (pInput == null) {
			return null;
		}
		int index = pInput.lastIndexOf(pSearch);
		if (index >= 0) {
			StringBuffer result = new StringBuffer(pInput);
			result.replace(index, index + pSearch.length(), pReplace);
			return replace(result.toString(), pSearch, pReplace);
		}
		return pInput;
	}

	public static String replaceAllRegex(String pInput, Map pReplacements) {
		if (pInput == null) {
			return null;
		}
		Iterator replacementsI = pReplacements.entrySet().iterator();
		Map.Entry replacement;
		String current = pInput;
		while (replacementsI.hasNext()) {
			replacement = (Map.Entry) replacementsI.next();
			current = current.replaceAll((String) replacement.getKey(), (String) replacement.getValue());
		}
		return current;
	}

	public static String join(final String[] pInput, final String pSeparator) {
		if (pInput == null || pInput.length == 0) {
			return null;
		}
		String vResult = pInput[0];
		for (int vInputI = 1; vInputI < pInput.length; vInputI++) {
			vResult = join(vResult, pInput[vInputI], pSeparator);
		}
		return vResult;
	}

	/**
	 * <ul>
	 * <li>join(null, "cde", *) = "cde"</li>
	 * <li>join("abc", null, *) = "abc"</li>
	 * <li>join("abc", "cde", null) = "abccde"</li>
	 * <li>join("abc", "cde", ".") = "abc.cde"</li>
	 * </ul>
	 * 
	 * @param pInput1
	 * @param pInput2
	 * @param pSeparator
	 * @return s.d.
	 */
	public static String join(final String pInput1, final String pInput2, final String pSeparator) {
		if (pInput1 == null) {
			return pInput2;
		}
		if (pInput2 == null) {
			return pInput1;
		}
		if (pSeparator == null) {
			return pInput1 + pInput2;
		}
		return pInput1 + pSeparator + pInput2;
	}

	/**
	 * Finds args with the pattern
	 * 
	 * <pre>
	 *                                      -argName=argValue
	 * </pre>.
	 * 
	 * @param pArgs
	 * @param pArgName
	 * @return
	 */
	public static String getArgValue(final String[] pArgs, final String pArgName) {
		if (pArgs == null || pArgName == null) {
			return null;
		}
		String argPrefix;
		String arg;
		for (int i = 0; i < pArgs.length; i++) {
			arg = pArgs[i];
			argPrefix = "-" + pArgName + "=";
			if (arg.startsWith(argPrefix)) {
				return arg.substring(argPrefix.length());
			}
		}
		return null;
	}

	public static String toString(final Object pObject, final String pNullString) {
		if (pObject == null) {
			return pNullString;
		}
		return pObject.toString();
	}

	public static String toString(final Object pObject) {
		return toString(pObject, null);
	}

	public static String[] getBlocks(final String pBlockStart, final String pBlockEnd, final String pContent) {
		List vBlocks = new ArrayList();
		int vBlockStartIndex = pContent.indexOf(pBlockStart);
		int vBlockEndIndex = vBlockStartIndex == -1 ? -1 : pContent.indexOf(pBlockEnd, vBlockStartIndex);
		while (vBlockStartIndex != -1 && vBlockEndIndex != -1) {
			vBlocks.add(pContent.substring(vBlockStartIndex + pBlockStart.length(), vBlockEndIndex));
			vBlockStartIndex = pContent.indexOf(pBlockStart, vBlockEndIndex);
			vBlockEndIndex = vBlockStartIndex == -1 ? -1 : pContent.indexOf(pBlockEnd, vBlockStartIndex);
		}
		return (String[]) vBlocks.toArray(new String[vBlocks.size()]);
	}

	public static String getMergedBlocks(String blockStart, String blockEnd, String content) {
		int s = content.indexOf(blockStart);
		if (s == -1) {
			return null;
		}
		int e = content.indexOf(blockEnd, s);
		if (e == -1) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		while (s != -1 && e != -1) {
			result.append(content.substring(s + blockStart.length(), e));
			s = content.indexOf(blockStart, e);
			if (s != -1) {
				e = content.indexOf(blockEnd, s);
			}
		}
		return result.toString();
	}

	public static String setMergedBlocks(String blockStart, String blockEnd, String content, String value) {
		String result = content;
		int s = result.indexOf(blockStart);
		if (s == -1) {
			return result + blockStart + value + blockEnd;
		}
		int e = content.indexOf(blockEnd, s);
		if (e == -1) {
			return result + blockStart + value + blockEnd;
		}
		boolean set = false;
		while (s != -1 && e != -1) {
			result = result.substring(0, s + blockStart.length()) + (set ? "" : value) + result.substring(e);
			set = true;
			s = content.indexOf(blockStart, e);
			if (s != -1) {
				e = content.indexOf(blockEnd, s);
			}
		}
		return result;
	}

	/**
	 * @param pInnerNonCommentSource
	 * @param pString
	 * @return
	 */
	public static boolean containsOnlyTheseChars(String pInnerNonCommentSource, String pChars) {
		for (int vCharI = 0; vCharI < pInnerNonCommentSource.length(); vCharI++) {
			if (pChars.indexOf(pInnerNonCommentSource.charAt(vCharI)) < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param pUserBlock
	 * @return
	 */
	public static String firstCharacters(final String pUserBlock) {
		StringBuffer vResult = new StringBuffer();
		CharacterIterator vUserBlockI = new StringCharacterIterator(pUserBlock);
		for (char vChar = vUserBlockI.first(); vChar != CharacterIterator.DONE && Character.isLetter(vChar); vChar = vUserBlockI
		      .next()) {
			vResult.append(vChar);
		}
		return vResult.toString();
	}
}
