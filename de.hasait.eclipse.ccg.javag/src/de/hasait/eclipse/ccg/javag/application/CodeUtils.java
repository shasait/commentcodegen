/*
 * $Id: CodeUtils.java,v 1.1 2006-12-19 15:06:03 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import de.hasait.eclipse.common.ContentBuffer;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 18.12.2006
 */
public final class CodeUtils {
	private CodeUtils() {
		super();
	}

	public static String getTypeName(Class type) {
		if (type.isAnonymousClass()) {
			throw new IllegalArgumentException("type is anonymous");
		}
		if (type.isArray()) {
			return getTypeName(type.getComponentType()) + "[]";
		}
		return type.getName();
	}

	public static void writeFinalField(ContentBuffer content, String pFieldName, String pType, String pImplType) {
		content.a("private ").a("final ").a(pType).a(" ").a(pFieldName).a(" = ").a("new ").a(pImplType).a("(");
		content.a(")");
	}

	public static void writeFinalField(ContentBuffer content, String pFieldName, Class pType, Class pImplType) {
		writeFinalField(content, pFieldName, getTypeName(pType), getTypeName(pImplType));
	}

	public static void writeMethodInvocation(ContentBuffer content, String base, String methodName, List parameterNames) {
		writeMethodInvocation(content, base, methodName, parameterNames == null ? null : (String[]) parameterNames
		      .toArray(new String[parameterNames.size()]));
	}

	public static void writeMethodInvocation(ContentBuffer content, String base, String methodName,
	      String[] parameterNames) {
		content.a(base).a(".").a(methodName).a("(");
		if (parameterNames != null) {
			for (int parameterNamesI = 0; parameterNamesI < parameterNames.length; parameterNamesI++) {
				if (parameterNamesI > 0) {
					content.a(", ");
				}
				content.a(parameterNames[parameterNamesI]);
			}
		}
		content.a(")");
	}

	public static void writeDelegation(ContentBuffer content, String instance, Class type, String methodIncludeRegex,
	      String methodExcludeRegex, boolean finalize) {
		Method[] methods = type.getMethods();
		for (int methodsI = 0; methodsI < methods.length; methodsI++) {
			Method method = methods[methodsI];
			String methodName = method.getName();
			if (methodName.matches(methodIncludeRegex) && !methodName.matches(methodExcludeRegex)) {
				int modifiers = method.getModifiers();
				if (!Modifier.isAbstract(modifiers) && !Modifier.isNative(modifiers)) {
					if (finalize) {
						modifiers |= Modifier.FINAL;
					}
					Class[] parameterTypes = method.getParameterTypes();
					content.a("/** @see ").a(getTypeName(type)).a("#").a(methodName).a("(");
					for (int parameterTypesI = 0; parameterTypesI < parameterTypes.length; parameterTypesI++) {
						Class parameterType = parameterTypes[parameterTypesI];
						if (parameterTypesI > 0) {
							content.a(", ");
						}
						content.a(getTypeName(parameterType));
					}
					content.a(")");
					content.a(" */");
					content.p();
					Class returnType = method.getReturnType();
					content.a(Modifier.toString(modifiers)).a(" ").a(getTypeName(returnType)).a(" ").a(methodName).a("(");
					List parameterNames = new ArrayList();
					for (int parameterTypesI = 0; parameterTypesI < parameterTypes.length; parameterTypesI++) {
						Class parameterType = parameterTypes[parameterTypesI];
						if (parameterTypesI > 0) {
							content.a(", ");
						}
						String parameterName = "p" + parameterTypesI;
						content.a(getTypeName(parameterType)).a(" ").a(parameterName);
						parameterNames.add(parameterName);
					}
					content.a(")");
					content.a(" ");
					Class[] exceptionTypes = method.getExceptionTypes();
					if (exceptionTypes.length > 0) {
						content.a("throws ");
						for (int exceptionTypesI = 0; exceptionTypesI < exceptionTypes.length; exceptionTypesI++) {
							if (exceptionTypesI > 0) {
								content.a(", ");
							}
							Class exceptionType = exceptionTypes[exceptionTypesI];
							content.a(getTypeName(exceptionType));
						}
					}
					content.pi("{");
					if (!Void.TYPE.equals(returnType)) {
						content.a("return ");
					}
					writeMethodInvocation(content, instance, methodName, parameterNames);
					content.a(";");
					content.p();
					content.pu("}");
					content.p();
				}
			}
		}
	}
}
