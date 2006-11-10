/*
 * $Id: BsfGenerator.java,v 1.2 2006-11-10 14:01:11 concentus Exp $
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

import java.util.Map;

import org.apache.bsf.BSFManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.w3c.dom.Element;

import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.ccg.util.ResourceUtil;
import de.hasait.eclipse.ccg.util.XmlUtil;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class BsfGenerator extends AbstractJavaAstTagContentGenerator {
	private static final String DESCRIPTION = "Delegates the generation to a script";

	private static final String[] TAG_NAMES = new String[] { "JavaBsf" };

	public BsfGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public String generateBlock(Element element, ICcgGeneratorLookup generatorLookup, Map context, ICcgComment comment,
	      IFile file, CompilationUnit compilationUnit) throws Exception {
		String bsfLanguage = XmlUtil.getAttributeString(element, "language");
		String bsfScriptFilePathS = XmlUtil.getAttributeString(element, "file", null);
		String bsfScript;
		if (bsfScriptFilePathS != null) {
			// read script from file
			IFile bsfScriptFile = ResourceUtil.getRelativeFile(file, bsfScriptFilePathS);
			bsfScript = ResourceUtil.readFile(bsfScriptFile);
		} else {
			// get script from element's body
			bsfScript = element.getTextContent();
		}
		// run script
		BSFManager manager = new BSFManager();
		manager.declareBean("e", element, Element.class);
		manager.declareBean("cu", compilationUnit, CompilationUnit.class);
		StringBuffer out = new StringBuffer();
		manager.declareBean("out", out, StringBuffer.class);
		manager.eval(bsfLanguage, "text", 0, 0, bsfScript);
		return "\n\t" + out.toString() + "\n\t";
	}
}
