/*
 * $Id: MultiCcgGeneratorLookup.java,v 1.1 2007-06-21 16:34:09 concentus Exp $
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

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 21.06.2007
 */
public final class MultiCcgGeneratorLookup implements ICcgGeneratorLookup {
	private final List<ICcgGeneratorLookup> _generatorLookups = new ArrayList<ICcgGeneratorLookup>();

	/**
	 * 
	 */
	public MultiCcgGeneratorLookup() {
		super();
	}

	/**
	 * 
	 */
	public MultiCcgGeneratorLookup(final ICcgGeneratorLookup[] generatorLookups) {
		super();
		for (ICcgGeneratorLookup generatorLookup : generatorLookups) {
			_generatorLookups.add(generatorLookup);
		}
	}

	/**
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addGeneratorLookup(final ICcgGeneratorLookup generatorLookup) {
		return _generatorLookups.add(generatorLookup);
	}

	/**
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean removeGeneratorLookup(final ICcgGeneratorLookup generatorLookup) {
		return _generatorLookups.remove(generatorLookup);
	}

	public boolean containsBlockGenerator(final String tagName) {
		for (ICcgGeneratorLookup generatorLookup : _generatorLookups) {
			if (generatorLookup.containsBlockGenerator(tagName)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsResourceGenerator(final String tagName) {
		for (ICcgGeneratorLookup generatorLookup : _generatorLookups) {
			if (generatorLookup.containsResourceGenerator(tagName)) {
				return true;
			}
		}
		return false;
	}

	public ICcgBlockGenerator findBlockGenerator(final String tagName) {
		for (ICcgGeneratorLookup generatorLookup : _generatorLookups) {
			if (generatorLookup.containsBlockGenerator(tagName)) {
				return generatorLookup.findBlockGenerator(tagName);
			}
		}
		return null;
	}

	public ICcgResourceGenerator findResourceGenerator(final String tagName) {
		for (ICcgGeneratorLookup generatorLookup : _generatorLookups) {
			if (generatorLookup.containsResourceGenerator(tagName)) {
				return generatorLookup.findResourceGenerator(tagName);
			}
		}
		return null;
	}
}
