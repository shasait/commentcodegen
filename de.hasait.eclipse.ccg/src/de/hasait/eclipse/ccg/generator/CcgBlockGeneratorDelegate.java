/*
 * $Id: CcgBlockGeneratorDelegate.java,v 1.1 2006-11-10 14:00:58 concentus Exp $
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

package de.hasait.eclipse.ccg.generator;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.w3c.dom.Element;

import de.hasait.eclipse.ccg.parser.ICcgComment;

/**
 * Delegates generation to an instance of {@link ICcgBlockGeneratorGenerate}.
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 10.11.2006
 */
public class CcgBlockGeneratorDelegate extends AbstractCcgBlockGenerator {
	private final ICcgBlockGeneratorGenerate _generate;

	protected CcgBlockGeneratorDelegate(String description, String[] tagNames, ICcgBlockGeneratorGenerate generate) {
		super(description, tagNames);
		//
		assert generate != null;
		_generate = generate;
	}

	public final String generateBlock(Element element, ICcgGeneratorLookup generatorLookup, Map context,
	      ICcgComment ccgComment, IFile file) throws Exception {
		return _generate.generateBlock(element, generatorLookup, context, ccgComment, file);
	}
}
