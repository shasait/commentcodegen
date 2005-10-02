/*
 * $Id: IncludeFileGenerator.java,v 1.2 2005-10-02 00:32:23 a-pi Exp $
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
package de.hasait.ccg.generator.generic;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import de.hasait.ccg.generator.ICcgGenerator;
import de.hasait.ccg.generator.ICcgGeneratorLookup;
import de.hasait.ccg.parser.ICcgComment;
import de.hasait.ccg.util.IOUtil;
import de.hasait.ccg.util.StringUtil;
import de.hasait.ccg.util.XmlUtil;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public class IncludeFileGenerator implements ICcgGenerator {
    private final String[] KEYWORDS = new String[] { "includeFile" };

    public String getDescription() {
        return "Include file generator - includes the file specified as parameter with optional replacing keywords";
    }

    public String[] getTagnames() {
        return KEYWORDS;
    }

    public String generate(final Element element,
            final ICcgGeneratorLookup ccgGeneratorLookup, final Map context,
            final ICcgComment ccgComment, final IFile file) throws Exception {
        String path = XmlUtil.getAttributeString(element, "path");
        NodeList replaceElements = element.getElementsByTagName("replace");
        Map replacements = new HashMap();
        Element replacement;
        int anon = 0;
        for (int i = 0; i < replaceElements.getLength(); i++) {
            replacement = (Element) replaceElements.item(i);
            if (replacement.hasAttribute("r")) {
                if (replacement.hasAttribute("s")) {
                    replacements.put(replacement.getAttribute("s"), replacement
                            .getAttribute("r"));
                } else {
                    replacements.put("${" + anon + "}", replacement
                            .getAttribute("r"));
                    anon++;
                }
            }
        }
        IFile includeFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
                new Path(path));
        InputStream inputFileIn = includeFile.getContents();
        Reader inputFileInR = new InputStreamReader(inputFileIn);
        String inputFileContent = IOUtil.readAll(inputFileInR);
        inputFileContent = StringUtil
                .replaceAll(inputFileContent, replacements);
        return inputFileContent;
    }
}
