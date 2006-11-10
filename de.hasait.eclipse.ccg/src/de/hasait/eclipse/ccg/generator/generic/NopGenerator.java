/*
 * $Id: NopGenerator.java,v 1.2 2006-11-10 14:01:04 concentus Exp $
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
package de.hasait.eclipse.ccg.generator.generic;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.w3c.dom.Element;

import de.hasait.eclipse.ccg.generator.AbstractCcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class NopGenerator extends AbstractCcgBlockGenerator {
	private static final String DESCRIPTION = "NOP (no operation) generator - pipe through paramter";

	private static final String[] TAG_NAMES = new String[] { "NOP" };

	/**
	 * Constructor.
	 */
	public NopGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public String generateBlock(final Element element, final ICcgGeneratorLookup ccgGeneratorLookup, final Map context,
	      final ICcgComment ccgComment, final IFile file) throws Exception {
		return element.toString();
	}
}
