/*
 * $Id: MemoryCcgGeneratorLookup.java,v 1.1 2007-06-21 16:34:10 concentus Exp $
 * 
 * Copyright 2007 Sebastian Hasait
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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 21.06.2007
 */
public final class MemoryCcgGeneratorLookup implements ICcgGeneratorLookup {
	private final Map<String, ICcgBlockGenerator> _tagNameToBlockGeneratorMap = new HashMap<String, ICcgBlockGenerator>();

	private final Map<String, ICcgResourceGenerator> _tagNameToResourceGeneratorMap = new HashMap<String, ICcgResourceGenerator>();

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public ICcgBlockGenerator putBlockGenerator(final String tagName, final ICcgBlockGenerator blockGenerator) {
		return _tagNameToBlockGeneratorMap.put(tagName, blockGenerator);
	}

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public ICcgResourceGenerator putResourceGenerator(final String tagName, final ICcgResourceGenerator resourceGenerator) {
		return _tagNameToResourceGeneratorMap.put(tagName, resourceGenerator);
	}

	/**
	 * @param blockGenerator
	 */
	public void removeBlockGenerator(final ICcgBlockGenerator blockGenerator) {
		Set<String> tagNames = new HashSet<String>(_tagNameToBlockGeneratorMap.keySet());
		for (String tagName : tagNames) {
			if (_tagNameToBlockGeneratorMap.get(tagName) == blockGenerator) {
				_tagNameToBlockGeneratorMap.remove(tagName);
			}
		}
	}

	public boolean containsBlockGenerator(final String tagName) {
		return _tagNameToBlockGeneratorMap.containsKey(tagName);
	}

	public boolean containsResourceGenerator(final String tagName) {
		return _tagNameToResourceGeneratorMap.containsKey(tagName);
	}

	public ICcgBlockGenerator findBlockGenerator(final String tagName) {
		return _tagNameToBlockGeneratorMap.get(tagName);
	}

	public ICcgResourceGenerator findResourceGenerator(final String tagName) {
		return _tagNameToResourceGeneratorMap.get(tagName);
	}

	/**
    * 
    */
   public void clear() {
   	_tagNameToBlockGeneratorMap.clear();
   	_tagNameToResourceGeneratorMap.clear();
   }
}
