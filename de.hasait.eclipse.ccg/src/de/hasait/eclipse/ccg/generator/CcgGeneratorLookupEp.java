/*
 * $Id: CcgGeneratorLookupEp.java,v 1.3 2006-11-10 14:07:54 concentus Exp $
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
package de.hasait.eclipse.ccg.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

import de.hasait.eclipse.common.Util;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 */
public final class CcgGeneratorLookupEp implements ICcgGeneratorLookup {
	private final String _extensionPointId;

	private List _generators = null;

	public CcgGeneratorLookupEp(String extensionPointId) {
		super();
		_extensionPointId = extensionPointId;
	}

	private List getGenerators() {
		if (_generators == null) {
			_generators = new ArrayList();
			IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(_extensionPointId);
			IExtension[] extensions = extensionPoint.getExtensions();
			IConfigurationElement[] configurationElements;
			ICcgGenerator ccgGenerator;
			for (int extensionsI = 0; extensionsI < extensions.length; extensionsI++) {
				configurationElements = extensions[extensionsI].getConfigurationElements();
				for (int configurationElementsI = 0; configurationElementsI < configurationElements.length; configurationElementsI++) {
					try {
						ccgGenerator = (ICcgGenerator) configurationElements[configurationElementsI]
						      .createExecutableExtension("class");
						_generators.add(ccgGenerator);
					} catch (Exception ce) {
						// ignore
					}
				}
			}
		}
		return _generators;
	}

	public ICcgBlockGenerator findBlockGenerator(String tagName) {
		List generators = getGenerators();
		for (Iterator generatorsI = generators.iterator(); generatorsI.hasNext();) {
			ICcgGenerator generator = (ICcgGenerator) generatorsI.next();
			if (generator instanceof ICcgBlockGenerator) {
				ICcgBlockGenerator blockGenerator = (ICcgBlockGenerator) generator;
				String[] tagNames = generator.getTagnames();
				for (int tagNamesI = 0; tagNamesI < tagNames.length; tagNamesI++) {
					if (Util.equals(tagName, tagNames[tagNamesI])) {
						return blockGenerator;
					}
				}
			}
		}
		return null;
	}
}