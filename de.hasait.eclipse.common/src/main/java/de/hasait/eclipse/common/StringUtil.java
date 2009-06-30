/*
 * $Id: StringUtil.java,v 1.2 2009-06-30 14:14:38 concentus Exp $
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
import java.util.Map.Entry;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class StringUtil {
	private StringUtil() {
		super();
	}

	public static boolean isEmpty(final String input) {
		return input == null || input.length() == 0;
	}

	public static boolean equalsAny(final String input, final String[] anyOf) {
		if (input != null && anyOf != null) {
			for (int i = 0; i < anyOf.length; i++) {
				if (input.equals(anyOf[i])) {
					return true;
				}
			}
		}
		return false;
	}

	public static String capitalize(final String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] chars = input.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		return new String(chars);
	}

	public static String uncapitalize(final String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] chars = input.toCharArray();
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
				lastWasNotUpperCase = false;
			} else {
				lastWasNotUpperCase = true;
			}
			result.append(Character.toUpperCase(ch));
		}
		return result.toString();
	}

	public static String replaceAll(final String input, final Map<String, String> replacements) {
		if (input == null) {
			return null;
		}
		Iterator<Entry<String, String>> replacementsI = replacements.entrySet().iterator();
		Entry<String, String> replacement;
		String current = input;
		while (replacementsI.hasNext()) {
			replacement = replacementsI.next();
			current = replace(current, replacement.getKey(), replacement.getValue());
		}
		return current;
	}

	public static String replace(final String input, final String search, final String replace) {
		if (input == null) {
			return null;
		}
		int index = input.lastIndexOf(search);
		if (index >= 0) {
			StringBuffer result = new StringBuffer(input);
			result.replace(index, index + search.length(), replace);
			return replace(result.toString(), search, replace);
		}
		return input;
	}

	public static String replaceAllRegex(String input, Map<String, String> replacements) {
		if (input == null) {
			return null;
		}
		Iterator<Entry<String, String>> replacementsI = replacements.entrySet().iterator();
		Entry<String, String> replacement;
		String current = input;
		while (replacementsI.hasNext()) {
			replacement = replacementsI.next();
			current = current.replaceAll(replacement.getKey(), replacement.getValue());
		}
		return current;
	}

	public static String join(final String[] inputs, final String separator) {
		if (inputs == null || inputs.length == 0) {
			return null;
		}
		String result = null;
		for (String input : inputs) {
			result = join(result, input, separator);
		}
		return result;
	}

	/**
	 * <ul>
	 * <li>join(null, "cde", *) = "cde"</li>
	 * <li>join("abc", null, *) = "abc"</li>
	 * <li>join("abc", "cde", null) = "abccde"</li>
	 * <li>join("abc", "cde", ".") = "abc.cde"</li>
	 * </ul>
	 * 
	 * @param input1
	 * @param input2
	 * @param separator
	 * @return s.d.
	 */
	public static String join(final String input1, final String input2, final String separator) {
		if (input1 == null) {
			return input2;
		}
		if (input2 == null) {
			return input1;
		}
		if (separator == null) {
			return input1 + input2;
		}
		return input1 + separator + input2;
	}

	/**
	 * Finds args with the pattern
	 * 
	 * <pre>
	 *                                      -argName=argValue
	 * </pre>.
	 * 
	 * @param args
	 * @param argName
	 * @return argValue
	 */
	public static String getArgValue(final String[] args, final String argName) {
		if (args == null || argName == null) {
			return null;
		}
		String argPrefix;
		for (String arg : args) {
			argPrefix = "-" + argName + "=";
			if (arg.startsWith(argPrefix)) {
				return arg.substring(argPrefix.length());
			}
		}
		return null;
	}

	public static String toString(final Object object, final String nullString) {
		if (object == null) {
			return nullString;
		}
		return object.toString();
	}

	public static String toString(final Object object) {
		return toString(object, null);
	}

	public static String[] getBlocks(final String input, final String blockStart, final String blockEnd) {
		List<String> result = new ArrayList<String>();
		int blockStartIndex = input.indexOf(blockStart);
		int blockEndIndex = blockStartIndex == -1 ? -1 : input.indexOf(blockEnd, blockStartIndex);
		while (blockStartIndex != -1 && blockEndIndex != -1) {
			result.add(input.substring(blockStartIndex + blockStart.length(), blockEndIndex));
			blockStartIndex = input.indexOf(blockStart, blockEndIndex);
			blockEndIndex = blockStartIndex == -1 ? -1 : input.indexOf(blockEnd, blockStartIndex);
		}
		return result.toArray(new String[result.size()]);
	}

	public static String getMergedBlocks(final String input, final String blockStart, final String blockEnd) {
		int blockStartIndex = input.indexOf(blockStart);
		if (blockStartIndex == -1) {
			return null;
		}
		int blockEndIndex = input.indexOf(blockEnd, blockStartIndex);
		if (blockEndIndex == -1) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		while (blockStartIndex != -1 && blockEndIndex != -1) {
			result.append(input.substring(blockStartIndex + blockStart.length(), blockEndIndex));
			blockStartIndex = input.indexOf(blockStart, blockEndIndex);
			if (blockStartIndex != -1) {
				blockEndIndex = input.indexOf(blockEnd, blockStartIndex);
			}
		}
		return result.toString();
	}

	public static String setMergedBlocks(final String input, final String value, final String blockStart,
	      final String blockEnd) {
		String result = input;
		int blockStartIndex = result.indexOf(blockStart);
		if (blockStartIndex == -1) {
			return result + blockStart + value + blockEnd;
		}
		int blockEndIndex = input.indexOf(blockEnd, blockStartIndex);
		if (blockEndIndex == -1) {
			return result + blockStart + value + blockEnd;
		}
		boolean set = false;
		while (blockStartIndex != -1 && blockEndIndex != -1) {
			result = result.substring(0, blockStartIndex + blockStart.length()) + (set ? "" : value)
			      + result.substring(blockEndIndex);
			set = true;
			blockStartIndex = input.indexOf(blockStart, blockEndIndex);
			if (blockStartIndex != -1) {
				blockEndIndex = input.indexOf(blockEnd, blockStartIndex);
			}
		}
		return result;
	}

	/**
	 * @param input
	 * @param pString
	 * @return
	 */
	public static boolean containsOnlyTheseChars(final String input, final String chars) {
		for (int inputI = 0; inputI < input.length(); inputI++) {
			if (chars.indexOf(input.charAt(inputI)) < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param input
	 * @return
	 */
	public static String firstCharacters(final String input) {
		StringBuffer result = new StringBuffer();
		CharacterIterator inputI = new StringCharacterIterator(input);
		for (char inputChar = inputI.first(); inputChar != CharacterIterator.DONE && Character.isLetter(inputChar); inputChar = inputI
		      .next()) {
			result.append(inputChar);
		}
		return result.toString();
	}

	/**
	 * @param text
	 * @return [line, remainingText]
	 */
	public static String[] readLine(final String text) {
		if (text == null) {
			return new String[] { null, null };
		}
		int irn = text.indexOf("\r\n");
		int ir = text.indexOf("\r");
		int in = text.indexOf("\n");
		if (irn >= 0 && (ir < 0 || irn <= ir) && (in < 0 || irn <= in)) {
			return new String[] { text.substring(0, irn), text.substring(irn + 2) };
		}
		if (ir >= 0 && (in < 0 || ir <= in)) {
			return new String[] { text.substring(0, ir), text.substring(ir + 1) };
		}
		if (in >= 0) {
			return new String[] { text.substring(0, in), text.substring(in + 1) };
		}
		return new String[] { text, null };
	}
}
