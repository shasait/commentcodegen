/*
 * $Id: CcgParserLookupEp.java,v 1.1 2006-11-08 20:54:47 concentus Exp $
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
package de.hasait.eclipse.ccg.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

import de.hasait.eclipse.ccg.util.Util;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class CcgParserLookupEp implements ICcgParserLookup {
    private final String _extensionPointId;

    private List _ccgParsers = null;

    public CcgParserLookupEp(String extensionPointId) {
        super();
        _extensionPointId = extensionPointId;
    }

    private List getCcgParsers() {
        if (_ccgParsers == null) {
            _ccgParsers = new ArrayList();
            IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
                    .getExtensionPoint(_extensionPointId);
            IExtension[] extensions = extensionPoint.getExtensions();
            IConfigurationElement[] configurationElements;
            ICcgParser ccgParser;
            for (int extensionsI = 0; extensionsI < extensions.length; extensionsI++) {
                configurationElements = extensions[extensionsI]
                        .getConfigurationElements();
                for (int configurationElementsI = 0; configurationElementsI < configurationElements.length; configurationElementsI++) {
                    try {
                        ccgParser = (ICcgParser) configurationElements[configurationElementsI]
                                .createExecutableExtension("class");
                        _ccgParsers.add(ccgParser);
                    } catch (Exception ce) {
                        // ignore
                    }
                }
            }
        }
        return _ccgParsers;
    }

    public ICcgParser findCcgParser(String fileExtension) {
        List ccgParsers = getCcgParsers();
        Iterator ccgParsersI = ccgParsers.iterator();
        ICcgParser ccgParser;
        String[] fileExtensions;
        while (ccgParsersI.hasNext()) {
            ccgParser = (ICcgParser) ccgParsersI.next();
            fileExtensions = ccgParser.getFileExtensions();
            for (int fileExtensionsI = 0; fileExtensionsI < fileExtensions.length; fileExtensionsI++) {
                if (Util.equals(fileExtension, fileExtensions[fileExtensionsI])) {
                    return ccgParser;
                }
            }
        }
        return null;
    }
}
