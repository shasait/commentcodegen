/*
 * $Id: AbstractJavaAstTagContentGenerator.java,v 1.1 2006-11-08 20:29:28 concentus Exp $
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

package de.hasait.ccg.javag.pattern;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.w3c.dom.Element;

import de.hasait.ccg.generator.AbstractCcgTagContentGenerator;
import de.hasait.ccg.generator.ICcgGeneratorLookup;
import de.hasait.ccg.parser.ICcgComment;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @since 05.11.2006
 */
public abstract class AbstractJavaAstTagContentGenerator extends AbstractCcgTagContentGenerator {
	protected AbstractJavaAstTagContentGenerator(String description, String[] tagnames) {
		super(description, tagnames);
	}

	public final String generate(Element element, ICcgGeneratorLookup generatorLookup, Map context,
	      ICcgComment ccgComment, IFile file) throws Exception {
		// parse source file
		IJavaElement javaElement = JavaCore.create(file);
		if (javaElement == null || !(javaElement instanceof ICompilationUnit)) {
			throw new IllegalArgumentException("Not a Java source file");
		}
		ASTParser astParser = ASTParser.newParser(AST.JLS3);
		astParser.setSource((ICompilationUnit) javaElement);
		astParser.setResolveBindings(true);
		CompilationUnit compilationUnit = (CompilationUnit) astParser.createAST(null);
		return generate(element, generatorLookup, context, ccgComment, file, compilationUnit);
	}

	public abstract String generate(Element element, ICcgGeneratorLookup generatorLookup, Map context,
	      ICcgComment ccgComment, IFile file, CompilationUnit compilationUnit) throws Exception;
}
