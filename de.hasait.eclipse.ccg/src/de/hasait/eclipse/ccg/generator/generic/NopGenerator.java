/*
 * $Id: NopGenerator.java,v 1.1 2006-11-08 20:54:47 concentus Exp $
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

import org.eclipse.core.resources.IFile;
import org.w3c.dom.Element;

import de.hasait.eclipse.ccg.generator.ICcgTagGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public class NopGenerator implements ICcgTagGenerator {
    private final String[] TAGNAMES = new String[] { "NOP" };

    public String getDescription() {
        return "NOP (no operation) generator - pipe through paramter";
    }

    public String[] getTagnames() {
        return TAGNAMES;
    }

    public String generate(final Element element,
            final ICcgGeneratorLookup ccgGeneratorLookup, final Map context,
            final ICcgComment ccgComment, final IFile file) throws Exception {
        return element.toString();
    }
}
