/*
 * $Id: CcgJetGeneratorAdapter.java,v 1.1.1.1 2005-09-01 23:06:35 a-pi Exp $
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
package de.hasait.ccg.generator;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.w3c.dom.Element;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1.1.1 $
 */
public class CcgJetGeneratorAdapter implements ICcgGenerator {
    private final String _description;

    private final String[] _tagnames;

    private final ICcgJetGenerator _domGenerator;

    public CcgJetGeneratorAdapter(final String description,
            final String[] tagnames, final ICcgJetGenerator domGenerator) {
        super();
        _description = description;
        _tagnames = tagnames;
        _domGenerator = domGenerator;
    }

    public final String getDescription() {
        return _description;
    }

    public final String[] getTagnames() {
        return _tagnames;
    }

    public final String generate(final Element element,
            final ICcgGeneratorLookup transformatorLookup, final Map context,
            final IFile file) throws Exception {
        return _domGenerator.generate(element, transformatorLookup, context,
                file);
    }
}
