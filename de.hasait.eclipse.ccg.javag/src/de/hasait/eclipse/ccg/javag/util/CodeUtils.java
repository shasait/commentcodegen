/*
 * $Id: CodeUtils.java,v 1.2 2007-01-10 18:04:17 concentus Exp $
 * 
 * Copyright 2006 Sebastian Hasait
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

package de.hasait.eclipse.ccg.javag.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 18.12.2006
 */
public final class CodeUtils {
	private CodeUtils() {
		super();
	}

	public static String getTypeName(Class pType) {
		if (pType.isAnonymousClass()) {
			throw new IllegalArgumentException("type is anonymous");
		}
		if (pType.isArray()) {
			return getTypeName(pType.getComponentType()) + "[]";
		}
		return pType.getName();
	}

	public static void writeFinalField(ContentBuffer pContent, String pFieldName, String pType, String pImplType,
	      String pConstructorArgs) {
		pContent.a("private ").a("final ").a(pType).a(" ").a(pFieldName).a(" = ").a("new ").a(pImplType).a("(");
		if (pConstructorArgs != null) {
			pContent.a(pConstructorArgs);
		}
		pContent.a(")");
		pContent.p(";");
	}

	public static void writeFinalField(ContentBuffer pContent, String pFieldName, Class pType, Class pImplType,
	      String pConstructorArgs) {
		writeFinalField(pContent, pFieldName, getTypeName(pType), getTypeName(pImplType), pConstructorArgs);
	}

	public static void writeMethodInvocation(ContentBuffer pContent, String pBase, String pMethodName,
	      List pParameterNames) {
		writeMethodInvocation(pContent, pBase, pMethodName, pParameterNames == null ? null : (String[]) pParameterNames
		      .toArray(new String[pParameterNames.size()]));
	}

	public static void writeMethodInvocation(ContentBuffer pContent, String pBase, String pMethodName,
	      String[] pParameterNames) {
		if (pBase != null) {
			pContent.a(pBase).a(".");
		}
		pContent.a(pMethodName).a("(");
		if (pParameterNames != null) {
			for (int parameterNamesI = 0; parameterNamesI < pParameterNames.length; parameterNamesI++) {
				if (parameterNamesI > 0) {
					pContent.a(", ");
				}
				pContent.a(pParameterNames[parameterNamesI]);
			}
		}
		pContent.a(")");
	}

	public static void writeDelegation(ContentBuffer pContent, String pInstance, Class pType,
	      String pMethodIncludeRegex, String pMethodExcludeRegex, boolean pMakeFinal) {
		Method[] methods = pType.getMethods();
		for (int methodsI = 0; methodsI < methods.length; methodsI++) {
			Method method = methods[methodsI];
			String methodName = method.getName();
			if (methodName.matches(pMethodIncludeRegex) && !methodName.matches(pMethodExcludeRegex)) {
				int modifiers = method.getModifiers();
				if (!Modifier.isAbstract(modifiers) && !Modifier.isNative(modifiers)) {
					if (pMakeFinal) {
						modifiers |= Modifier.FINAL;
					}
					Class[] parameterTypes = method.getParameterTypes();
					pContent.a("/** @see ").a(getTypeName(pType)).a("#").a(methodName).a("(");
					for (int parameterTypesI = 0; parameterTypesI < parameterTypes.length; parameterTypesI++) {
						Class parameterType = parameterTypes[parameterTypesI];
						if (parameterTypesI > 0) {
							pContent.a(", ");
						}
						pContent.a(getTypeName(parameterType));
					}
					pContent.a(")");
					pContent.a(" */");
					pContent.p();
					Class returnType = method.getReturnType();
					pContent.a(Modifier.toString(modifiers)).a(" ").a(getTypeName(returnType)).a(" ").a(methodName).a("(");
					List parameterNames = new ArrayList();
					for (int parameterTypesI = 0; parameterTypesI < parameterTypes.length; parameterTypesI++) {
						Class parameterType = parameterTypes[parameterTypesI];
						if (parameterTypesI > 0) {
							pContent.a(", ");
						}
						String parameterName = "p" + parameterTypesI;
						pContent.a(getTypeName(parameterType)).a(" ").a(parameterName);
						parameterNames.add(parameterName);
					}
					pContent.a(")");
					pContent.a(" ");
					Class[] exceptionTypes = method.getExceptionTypes();
					if (exceptionTypes.length > 0) {
						pContent.a("throws ");
						for (int exceptionTypesI = 0; exceptionTypesI < exceptionTypes.length; exceptionTypesI++) {
							if (exceptionTypesI > 0) {
								pContent.a(", ");
							}
							Class exceptionType = exceptionTypes[exceptionTypesI];
							pContent.a(getTypeName(exceptionType));
						}
					}
					pContent.pi("{");
					if (!Void.TYPE.equals(returnType)) {
						pContent.a("return ");
					}
					writeMethodInvocation(pContent, pInstance, methodName, parameterNames);
					pContent.a(";");
					pContent.p();
					pContent.pu("}");
					pContent.p();
				}
			}
		}
	}

	private static final String USERBLOCK_START = "// @ccg.userblock.start ";

	private static final String USERBLOCK_END = "// @ccg.userblock.end";

	public static Map parseUserBlockContentByBlockName(final String pContent) {
		Map vUserBlockContentByName = new HashMap();
		String[] vUserBlocks = StringUtil.getBlocks(USERBLOCK_START, USERBLOCK_END, pContent);
		for (int vUserBlocksI = 0; vUserBlocksI < vUserBlocks.length; vUserBlocksI++) {
			String vUserBlock = vUserBlocks[vUserBlocksI];
			String vUserBlockName = StringUtil.firstCharacters(vUserBlock);
			String vUserBlockContent = vUserBlock.substring(vUserBlockName.length()).trim();
			vUserBlockContentByName.put(vUserBlockName, vUserBlockContent);
		}
		return vUserBlockContentByName;
	}

	public static void writeUserBlock(final ContentBuffer pContent, final Map pUserBlockContentByName,
	      final String pUserBlockName) {
		pContent.a(USERBLOCK_START).p(pUserBlockName);
		String vUserBlockContent = (String) pUserBlockContentByName.get(pUserBlockName);
		if (vUserBlockContent != null) {
			pContent.p(vUserBlockContent);
		}
		pContent.p(USERBLOCK_END);
	}
}
