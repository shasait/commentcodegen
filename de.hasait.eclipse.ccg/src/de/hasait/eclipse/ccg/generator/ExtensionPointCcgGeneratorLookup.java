/*
 * $Id: ExtensionPointCcgGeneratorLookup.java,v 1.1 2007-06-21 16:34:10 concentus Exp $
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
 * @version $Revision: 1.1 $
 */
public final class ExtensionPointCcgGeneratorLookup implements ICcgGeneratorLookup {
	private final String _extensionPointId;

	private Map<String, ICcgBlockGenerator> _blockGeneratorsByTagName = null;

	private Map<String, ICcgResourceGenerator> _resourceGeneratorsByTagName = null;

	/**
	 * Constructor.
	 * 
	 * @param extensionPointId
	 */
	public ExtensionPointCcgGeneratorLookup(final String extensionPointId) {
		super();
		_extensionPointId = extensionPointId;
	}

	private void initMaps() {
		if (_blockGeneratorsByTagName == null || _resourceGeneratorsByTagName == null) {
			_blockGeneratorsByTagName = new HashMap<String, ICcgBlockGenerator>();
			_resourceGeneratorsByTagName = new HashMap<String, ICcgResourceGenerator>();
			IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(_extensionPointId);
			IExtension[] extensions = extensionPoint.getExtensions();
			for (int extensionsI = 0; extensionsI < extensions.length; extensionsI++) {
				IConfigurationElement[] configurationElements = extensions[extensionsI].getConfigurationElements();
				for (int configurationElementsI = 0; configurationElementsI < configurationElements.length; configurationElementsI++) {
					IConfigurationElement configurationElement = configurationElements[configurationElementsI];
					String configurationElementName = configurationElement.getName();
					if ("blockGenerator".equals(configurationElementName)) {
						try {
							ICcgBlockGenerator blockGenerator = (ICcgBlockGenerator) configurationElement
							      .createExecutableExtension("class");
							String[] tagNames = configurationElement.getAttribute("tagnames").split(",");
							for (String tagName : tagNames) {
								_blockGeneratorsByTagName.put(tagName, blockGenerator);
							}
						} catch (Exception ce) {
							// ignore
						}
					} else if ("resourceGenerator".equals(configurationElementName)) {
						try {
							ICcgResourceGenerator resourceGenerator = (ICcgResourceGenerator) configurationElement
							      .createExecutableExtension("class");
							String[] tagNames = configurationElement.getAttribute("tagnames").split(",");
							for (String tagName : tagNames) {
								_resourceGeneratorsByTagName.put(tagName, resourceGenerator);
							}
						} catch (Exception ce) {
							// ignore
						}
					}
				}
			}
		}
	}

	public boolean containsBlockGenerator(final String tagName) {
		initMaps();
		return _blockGeneratorsByTagName.containsKey(tagName);
	}

	public boolean containsResourceGenerator(final String tagName) {
		initMaps();
		return _resourceGeneratorsByTagName.containsKey(tagName);
	}

	public ICcgBlockGenerator findBlockGenerator(final String tagName) {
		initMaps();
		return _blockGeneratorsByTagName.get(tagName);
	}

	public ICcgResourceGenerator findResourceGenerator(final String tagName) {
		initMaps();
		return _resourceGeneratorsByTagName.get(tagName);
	}
}
