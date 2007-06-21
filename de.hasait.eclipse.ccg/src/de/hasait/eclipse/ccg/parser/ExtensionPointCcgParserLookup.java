/*
 * $Id: ExtensionPointCcgParserLookup.java,v 1.1 2007-06-21 16:34:10 concentus Exp $
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
public final class ExtensionPointCcgParserLookup implements ICcgParserLookup {
	private final String _extensionPointId;

	private Map _parsersByFileExtension = null;

	/**
	 * Constructor.
	 * 
	 * @param extensionPointId
	 */
	public ExtensionPointCcgParserLookup(String extensionPointId) {
		super();
		_extensionPointId = extensionPointId;
	}

	private Map getParsersByFileExtension() {
		if (_parsersByFileExtension == null) {
			_parsersByFileExtension = new HashMap();
			IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(_extensionPointId);
			IExtension[] extensions = extensionPoint.getExtensions();
			IConfigurationElement[] configurationElements;
			ICcgParser parser;
			for (int extensionsI = 0; extensionsI < extensions.length; extensionsI++) {
				configurationElements = extensions[extensionsI].getConfigurationElements();
				for (int configurationElementsI = 0; configurationElementsI < configurationElements.length; configurationElementsI++) {
					try {
						parser = (ICcgParser) configurationElements[configurationElementsI]
						      .createExecutableExtension("class");
						String[] fileExtensions = parser.getFileExtensions();
						for (int fileExtensionsI = 0; fileExtensionsI < fileExtensions.length; fileExtensionsI++) {
							_parsersByFileExtension.put(fileExtensions[fileExtensionsI], parser);
						}
					} catch (Exception ce) {
						// ignore
					}
				}
			}
		}
		return _parsersByFileExtension;
	}

	public ICcgParser findParser(String fileExtension) {
		return (ICcgParser) getParsersByFileExtension().get(fileExtension);
	}

	public boolean containsParser(String fileExtension) {
		return getParsersByFileExtension().containsKey(fileExtension);
	}
}
