/*
 * $Id: CcgGeneratorLookupEp.java,v 1.1.1.1 2005-09-01 23:06:35 a-pi Exp $
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

import de.hasait.ccg.util.Util;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1.1.1 $
 */
public final class CcgGeneratorLookupEp implements ICcgGeneratorLookup {
    private final String _extensionPointId;

    private List _ccgGenerators = null;

    public CcgGeneratorLookupEp(String extensionPointId) {
        super();
        _extensionPointId = extensionPointId;
    }

    private List getCcgGenerators() {
        if (_ccgGenerators == null) {
            _ccgGenerators = new ArrayList();
            IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
                    .getExtensionPoint(_extensionPointId);
            IExtension[] extensions = extensionPoint.getExtensions();
            IConfigurationElement[] configurationElements;
            ICcgGenerator ccgGenerator;
            for (int extensionsI = 0; extensionsI < extensions.length; extensionsI++) {
                configurationElements = extensions[extensionsI]
                        .getConfigurationElements();
                for (int configurationElementsI = 0; configurationElementsI < configurationElements.length; configurationElementsI++) {
                    try {
                        ccgGenerator = (ICcgGenerator) configurationElements[configurationElementsI]
                                .createExecutableExtension("class");
                        _ccgGenerators.add(ccgGenerator);
                    } catch (Exception ce) {
                        // ignore
                    }
                }
            }
        }
        return _ccgGenerators;
    }

    public ICcgGenerator findTransformator(String keyword) {
        List ccgGenerators = getCcgGenerators();
        Iterator ccgGeneratorsI = ccgGenerators.iterator();
        ICcgGenerator ccgGenerator;
        String[] tagnames;
        while (ccgGeneratorsI.hasNext()) {
            ccgGenerator = (ICcgGenerator) ccgGeneratorsI.next();
            tagnames = ccgGenerator.getTagnames();
            for (int tagnamesI = 0; tagnamesI < tagnames.length; tagnamesI++) {
                if (Util.equals(keyword, tagnames[tagnamesI])) {
                    return ccgGenerator;
                }
            }
        }
        return null;
    }
}
