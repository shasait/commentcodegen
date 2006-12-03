/*
 * $Id: AbstractJavaAstTagContentBlockGenerator.java,v 1.2 2006-12-03 01:10:09 concentus Exp $
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

package de.hasait.eclipse.ccg.javag;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import de.hasait.eclipse.ccg.generator.AbstractCcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @since 05.11.2006
 */
public abstract class AbstractJavaAstTagContentBlockGenerator extends AbstractCcgBlockGenerator {
	protected AbstractJavaAstTagContentBlockGenerator(String description, String[] tagnames) {
		super(description, tagnames);
	}

	public final String generateBlock(XElement configElement, ICcgComment comment, XFile sourceFile,
	      Map sourceFileContext, ICcgGeneratorLookup generatorLookup, IProgressMonitor monitor) throws Exception {
		// parse source file
		IJavaElement javaElement = JavaCore.create(sourceFile.getRawFile());
		if (javaElement == null || !(javaElement instanceof ICompilationUnit)) {
			throw new IllegalArgumentException("Not a Java source file");
		}
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource((ICompilationUnit) javaElement);
		parser.setResolveBindings(true);
		CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
		return generateBlock(compilationUnit, configElement, comment, sourceFile, sourceFileContext, generatorLookup,
		      monitor);
	}

	public abstract String generateBlock(CompilationUnit compilationUnit, XElement configElement, ICcgComment comment,
	      XFile sourceFile, Map sourceFileContext, ICcgGeneratorLookup generatorLookup, IProgressMonitor monitor)
	      throws Exception;
}
