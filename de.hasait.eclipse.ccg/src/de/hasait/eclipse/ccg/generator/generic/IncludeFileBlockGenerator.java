/*
 * $Id: IncludeFileBlockGenerator.java,v 1.1 2006-11-16 16:08:43 concentus Exp $
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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;

import de.hasait.eclipse.ccg.generator.AbstractCcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.IOUtil;
import de.hasait.eclipse.common.ResourceUtil;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.XmlUtil.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
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

	public String generateBlock(final IFile file, final ICcgComment comment, final XElement element, final Map context,
	      final ICcgGeneratorLookup generatorLookup) throws Exception {
		String includeFilePathS = element.getRequiredAttribute("file");
		XElement[] replaceElements = element.getChildElements("replace");
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
		IFile includeFile = ResourceUtil.getRelativeFile(file, includeFilePathS);
		InputStream inputFileIn = includeFile.getContents();
		Reader inputFileInR = new InputStreamReader(inputFileIn);
		String inputFileContent = IOUtil.readAll(inputFileInR);
		inputFileContent = StringUtil.replaceAll(inputFileContent, replacements);
		return inputFileContent;
	}
}
