/*
 * $Id: AbstractCcgGenerator.java,v 1.1 2006-11-08 20:29:06 concentus Exp $
 * 
 * Copyright 2006 Sebastian Hasait
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

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @since 05.11.2006
 */
public abstract class AbstractCcgGenerator implements ICcgGenerator {
	private final String _description;

	protected AbstractCcgGenerator(final String description) {
		super();
		_description = description;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return _description;
	}
}
