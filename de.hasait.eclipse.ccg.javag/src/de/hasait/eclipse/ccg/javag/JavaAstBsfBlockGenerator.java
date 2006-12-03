/*
 * $Id: JavaAstBsfBlockGenerator.java,v 1.2 2006-12-03 01:07:38 concentus Exp $
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
package de.hasait.eclipse.ccg.javag;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.ccg.util.BsfExecuter;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class JavaAstBsfBlockGenerator extends AbstractJavaAstTagContentBlockGenerator {
	private static final String DESCRIPTION = "Delegates the generation to a script";

	private static final String[] TAG_NAMES = new String[] { "JavaAstBsf" };

	/**
	 * Constructor.
	 */
	public JavaAstBsfBlockGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public String generateBlock(CompilationUnit compilationUnit, XElement configElement, ICcgComment comment,
	      XFile sourceFile, Map sourceFileContext, ICcgGeneratorLookup generatorLookup, IProgressMonitor monitor)
	      throws Exception {
		BsfExecuter executer = new BsfExecuter(configElement, sourceFile, sourceFileContext, generatorLookup, monitor);
		// TODO read default-indent from configuration or source
		ContentBuffer out = new ContentBuffer("\t");
		out.i();
		executer.declareBean("out", out, ContentBuffer.class);
		executer.declareBean("compilationUnit", compilationUnit, CompilationUnit.class);
		executer.execute();
		return "\n" + out.getContent().toString() + "\n";
	}
}
