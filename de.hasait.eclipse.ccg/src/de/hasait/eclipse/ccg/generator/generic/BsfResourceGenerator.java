/*
 * $Id: BsfResourceGenerator.java,v 1.1 2006-11-16 16:08:43 concentus Exp $
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

import de.hasait.eclipse.ccg.generator.AbstractCcgResourceGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.common.ResourceUtil;
import de.hasait.eclipse.common.XmlUtil.XElement;
import de.hasait.eclipse.common.bsf.ResourceScriptHelper;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class BsfResourceGenerator extends AbstractCcgResourceGenerator {
	private static final String DESCRIPTION = "Delegates the generation to a script";

	private static final String[] TAG_NAMES = new String[] { "bsf" };

	/**
	 * Constructor.
	 */
	public BsfResourceGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public void generateResources(XElement element, ICcgGeneratorLookup generatorLookup, Map context, IFile file)
	      throws Exception {
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
		//
		manager.declareBean("element", element, XElement.class);
		ResourceScriptHelper resourceScriptHelper = new ResourceScriptHelper(file);
		manager.declareBean("resource", resourceScriptHelper, ResourceScriptHelper.class);
		//
		manager.eval(bsfLanguage, "text", 0, 0, bsfScript);
	}
}
