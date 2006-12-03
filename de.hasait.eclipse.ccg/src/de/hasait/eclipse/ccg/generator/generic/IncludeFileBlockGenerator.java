/*
 * $Id: IncludeFileBlockGenerator.java,v 1.2 2006-12-03 01:09:45 concentus Exp $
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
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class IncludeFileBlockGenerator extends AbstractCcgBlockGenerator {
	private static final String DESCRIPTION = "Include file generator - includes the file specified as parameter with optional replacing keywords";

	private static final String[] TAG_NAMES = new String[] { "includefile" };

	/**
	 * Constructor.
	 */
	public IncludeFileBlockGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public String generateBlock(final XElement configElement, final ICcgComment comment, final XFile sourceFile,
	      final Map sourceFileContext, final ICcgGeneratorLookup generatorLookup, final IProgressMonitor monitor)
	      throws Exception {
		String includeFilePathS = configElement.getRequiredAttribute("file");
		XElement[] replaceElements = configElement.getChildElements("replace");
		Map replacements = new HashMap();
		XElement replacement;
		int anon = 0;
		for (int i = 0; i < replaceElements.length; i++) {
			replacement = replaceElements[i];
			String search;
			if (replacement.hasAttribute("s")) {
				search = replacement.getAttribute("s");
			} else {
				search = "${" + anon + "}";
				anon++;
			}
			String replace = replacement.getAttribute("r", "");
			replacements.put(search, replace);
		}
		return sourceFile.getFile(includeFilePathS).read();
	}
}
