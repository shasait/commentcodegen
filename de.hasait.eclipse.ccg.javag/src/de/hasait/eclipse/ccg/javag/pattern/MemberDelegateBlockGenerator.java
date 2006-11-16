/*
 * $Id: MemberDelegateBlockGenerator.java,v 1.1 2006-11-16 16:08:40 concentus Exp $
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
package de.hasait.eclipse.ccg.javag.pattern;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.javag.AbstractJavaAstTagContentBlockGenerator;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.XmlUtil.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class MemberDelegateBlockGenerator extends AbstractJavaAstTagContentBlockGenerator {
	private static final String DESCRIPTION = "Member delegate pattern generator - adds public method delegates";

	private static final String[] TAG_NAMES = new String[] { "javamemberdelegate" };

	/**
	 * Constructor.
	 */
	public MemberDelegateBlockGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public String generateBlock(IFile file, ICcgComment comment, XElement element, CompilationUnit compilationUnit,
	      Map context, ICcgGeneratorLookup generatorLookup) throws Exception {
		String name = element.getRequiredAttribute("name");
		Iterator types = compilationUnit.types().iterator();
		AbstractTypeDeclaration abstractTypeDeclaration;
		TypeDeclaration typeDeclaration;
		FieldDeclaration[] fieldDeclarations;
		FieldDeclaration fieldDeclaration;
		Iterator variableDeclarationFragments;
		VariableDeclarationFragment variableDeclarationFragment;
		while (types.hasNext()) {
			abstractTypeDeclaration = (AbstractTypeDeclaration) types.next();
			if (abstractTypeDeclaration instanceof TypeDeclaration) {
				typeDeclaration = (TypeDeclaration) abstractTypeDeclaration;
				fieldDeclarations = typeDeclaration.getFields();
				for (int f = 0; f < fieldDeclarations.length; f++) {
					fieldDeclaration = fieldDeclarations[f];
					variableDeclarationFragments = fieldDeclaration.fragments().iterator();
					while (variableDeclarationFragments.hasNext()) {
						variableDeclarationFragment = (VariableDeclarationFragment) variableDeclarationFragments.next();
						if (variableDeclarationFragment.getName().getFullyQualifiedName().equals(name)) {
							StringWriter result = new StringWriter();
							PrintWriter presult = new PrintWriter(result);
							presult.println();
							/*
							 * presult .println("\t//delegation for " + name + "(commentpos:" + ccgComment.getBeginLine() + "#" +
							 * ccgComment.getBeginColumn() + "@vardeclpos:" + compilationUnit
							 * .lineNumber(variableDeclarationFragment .getStartPosition()) + ")");
							 */
							ITypeBinding typeBinding;
							IMethodBinding[] methodBindings;
							IMethodBinding methodBinding;
							IMethod method;
							ITypeBinding[] parameterTypes;
							String[] parameterNames;
							ITypeBinding returnType;
							typeBinding = fieldDeclaration.getType().resolveBinding();
							methodBindings = typeBinding.getDeclaredMethods();
							for (int m = 0; m < methodBindings.length; m++) {
								methodBinding = methodBindings[m];
								if (Modifier.isPublic(methodBinding.getModifiers()) && !methodBinding.isConstructor()) {
									method = (IMethod) methodBinding.getJavaElement();
									parameterTypes = methodBinding.getParameterTypes();
									parameterNames = method.getParameterNames();
									presult.print("\t/** Delegate to {@link " + typeBinding.getQualifiedName() + "#"
									      + methodBinding.getName() + "(");
									for (int p = 0; p < parameterTypes.length; p++) {
										presult.print(parameterTypes[p].getQualifiedName());
										if (p + 1 < parameterTypes.length) {
											presult.print(", ");
										}
									}
									presult.println(")}. */");
									returnType = methodBinding.getReturnType();
									presult.print("\tpublic " + returnType.getQualifiedName() + " " + methodBinding.getName());
									presult.print("(");
									for (int p = 0; p < parameterTypes.length; p++) {
										presult.print(parameterTypes[p].getQualifiedName() + " " + parameterNames[p]);
										if (p + 1 < parameterTypes.length) {
											presult.print(", ");
										}
									}
									presult.println(") {");
									presult.print("\t\t");
									if (!(returnType.isPrimitive() && returnType.getName().equals("void"))) {
										presult.print("return ");
									}
									presult.print(name + "." + methodBinding.getName() + "(");
									for (int p = 0; p < parameterNames.length; p++) {
										presult.print(parameterNames[p]);
										if (p + 1 < parameterNames.length) {
											presult.print(", ");
										}
									}
									presult.println(");");
									presult.println("\t}");
									presult.println();
								}
							}
							presult.print("\t");
							return result.toString();
						}
					}
				}
			}
		}
		throw new IllegalArgumentException("Invalid or undeclared member " + name);
	}
}
