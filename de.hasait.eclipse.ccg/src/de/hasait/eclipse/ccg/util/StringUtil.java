/*
 * $Id: StringUtil.java,v 1.1 2006-11-08 20:54:48 concentus Exp $
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
package de.hasait.eclipse.ccg.util;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class StringUtil {
    private StringUtil() {
        super();
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

    public static String replaceAll(final String pInput, final Map pReplacements) {
        if (pInput == null) {
            return null;
        }
        Iterator replacementsI = pReplacements.entrySet().iterator();
        Map.Entry replacement;
        String current = pInput;
        while (replacementsI.hasNext()) {
            replacement = (Map.Entry) replacementsI.next();
            current = replace(current, (String) replacement.getKey(),
                    (String) replacement.getValue());
        }
        return current;
    }

    public static String replace(final String pInput, final String pSearch,
            final String pReplace) {
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

    public static String merge(final String[] pInput, final String pSeparator) {
        StringBuffer result = new StringBuffer();
        if (pInput != null) {
            for (int i = 0; i < pInput.length; i++) {
                result.append(pInput[i]);
                if (i < pInput.length - 1) {
                    result.append(pSeparator);
                }
            }
        }
        return result.toString();
    }

    /**
     * Finds args with the pattern
     * 
     * <pre>
     *   -argName=argValue
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

    public static String getMergedBlocks(String blockStart, String blockEnd,
            String content) {
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

    public static String setMergedBlocks(String blockStart, String blockEnd,
            String content, String value) {
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
            result = result.substring(0, s + blockStart.length())
                    + (set ? "" : value) + result.substring(e);
            set = true;
            s = content.indexOf(blockStart, e);
            if (s != -1) {
                e = content.indexOf(blockEnd, s);
            }
        }
        return result;
    }
}