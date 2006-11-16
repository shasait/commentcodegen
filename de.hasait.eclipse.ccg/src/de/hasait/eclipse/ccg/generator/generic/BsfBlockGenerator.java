/*
 * $Id: BsfBlockGenerator.java,v 1.1 2006-11-16 16:08:43 concentus Exp $
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
package de.hasait.eclipse.ccg.generator.generic;

import java.util.Map;

import org.apache.bsf.BSFManager;
import org.eclipse.core.resources.IFile;

import de.hasait.eclipse.ccg.generator.AbstractCcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.ResourceUtil;
import de.hasait.eclipse.common.XmlUtil.XElement;
import de.hasait.eclipse.common.bsf.ContentScriptHelper;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class BsfBlockGenerator extends AbstractCcgBlockGenerator {
	private static final String DESCRIPTION = "Delegates the generation to a script";

	private static final String[] TAG_NAMES = new String[] { "bsf" };

	/**
	 * Constructor.
	 */
	public BsfBlockGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public String generateBlock(IFile file, ICcgComment comment, XElement element, Map context,
	      ICcgGeneratorLookup generatorLookup) throws Exception {
		String bsfLanguage = element.getRequiredAttribute("language");
		String bsfScriptFilePathS = element.getAttribute("file");
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
		manager.declareBean("element", element, XElement.class);
		// TODO read default-indent from configuration
		ContentScriptHelper out = new ContentScriptHelper("\t");
		out.i();
		manager.declareBean("content", out, ContentScriptHelper.class);
		//
		manager.eval(bsfLanguage, "text", 0, 0, bsfScript);
		//
		return "\n" + out.getContent().toString() + "\n";
	}
}
