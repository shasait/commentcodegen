/*
 * $Id: CcgGeneratorLookupEp.java,v 1.5 2006-12-03 01:09:45 concentus Exp $
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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.5 $
 */
public final class CcgGeneratorLookupEp implements ICcgGeneratorLookup {
	private final String _extensionPointId;

	private Map _blockGeneratorsByTagName = null;

	private Map _resourceGeneratorsByTagName = null;

	/**
	 * Constructor.
	 * 
	 * @param extensionPointId
	 */
	public CcgGeneratorLookupEp(String extensionPointId) {
		super();
		_extensionPointId = extensionPointId;
	}

	private void initMaps() {
		if (_blockGeneratorsByTagName == null || _resourceGeneratorsByTagName == null) {
			_blockGeneratorsByTagName = new HashMap();
			_resourceGeneratorsByTagName = new HashMap();
			IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(_extensionPointId);
			IExtension[] extensions = extensionPoint.getExtensions();
			for (int extensionsI = 0; extensionsI < extensions.length; extensionsI++) {
				IConfigurationElement[] configurationElements = extensions[extensionsI].getConfigurationElements();
				for (int configurationElementsI = 0; configurationElementsI < configurationElements.length; configurationElementsI++) {
					IConfigurationElement configurationElement = configurationElements[configurationElementsI];
					String configurationElementName = configurationElement.getName();
					if ("blockGenerator".equals(configurationElementName)) {
						try {
							ICcgBlockGenerator blockGenerator = (ICcgBlockGenerator) configurationElements[configurationElementsI]
							      .createExecutableExtension("class");
							String[] tagNames = blockGenerator.getTagNames();
							for (int tagNamesI = 0; tagNamesI < tagNames.length; tagNamesI++) {
								_blockGeneratorsByTagName.put(tagNames[tagNamesI], blockGenerator);
							}
						} catch (Exception ce) {
							// ignore
						}
					} else if ("resourceGenerator".equals(configurationElementName)) {
						try {
							ICcgResourceGenerator resourceGenerator = (ICcgResourceGenerator) configurationElements[configurationElementsI]
							      .createExecutableExtension("class");
							String[] tagNames = resourceGenerator.getTagNames();
							for (int tagNamesI = 0; tagNamesI < tagNames.length; tagNamesI++) {
								_resourceGeneratorsByTagName.put(tagNames[tagNamesI], resourceGenerator);
							}
						} catch (Exception ce) {
							// ignore
						}
					}
				}
			}
		}
	}

	public boolean containsBlockGenerator(String tagName) {
		initMaps();
		return _blockGeneratorsByTagName.containsKey(tagName);
	}

	public ICcgBlockGenerator findBlockGenerator(String tagName) {
		initMaps();
		return (ICcgBlockGenerator) _blockGeneratorsByTagName.get(tagName);
	}

	public boolean containsResourceGenerator(String tagName) {
		initMaps();
		return _resourceGeneratorsByTagName.containsKey(tagName);
	}

	public ICcgResourceGenerator findResourceGenerator(String tagName) {
		initMaps();
		return (ICcgResourceGenerator) _resourceGeneratorsByTagName.get(tagName);
	}
}
