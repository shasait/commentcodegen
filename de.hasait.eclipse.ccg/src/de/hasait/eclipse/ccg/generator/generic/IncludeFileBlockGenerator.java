/*
 * $Id: IncludeFileBlockGenerator.java,v 1.6 2008-04-08 11:24:35 concentus Exp $
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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.generator.AbstractCcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.6 $
 */
public final class IncludeFileBlockGenerator extends AbstractCcgBlockGenerator {
	private static final String DESCRIPTION = "Include file generator - includes the file specified as parameter with optional replacing keywords";

	/**
	 * Constructor.
	 */
	public IncludeFileBlockGenerator() {
		super(DESCRIPTION);
	}

	public String generateBlock(final XElement configElement, final XFile sourceFile, final Map sourceFileContext,
	      final ICcgGeneratorLookup generatorLookup, final IProgressMonitor monitor)
	      throws Exception {
		String includeFilePathS = configElement.getRequiredStringAttribute("file");
		XElement[] replaceElements = configElement.getElements("replace");
		Map<String, String> replacements = new HashMap<String, String>();
		XElement replacement;
		int anon = 0;
		for (int i = 0; i < replaceElements.length; i++) {
			replacement = replaceElements[i];
			String search;
			if (replacement.hasAttribute("s")) {
				search = replacement.getStringAttribute("s");
			} else {
				search = "${" + anon + "}";
				anon++;
			}
			String replace = replacement.getStringAttribute("r", "");
			replacements.put(search, replace);
		}
		return StringUtil.replaceAll(sourceFile.getFile(includeFilePathS).read(), replacements);
	}
}
