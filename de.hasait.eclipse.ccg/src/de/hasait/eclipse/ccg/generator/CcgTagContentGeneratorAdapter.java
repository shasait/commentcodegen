/*
 * $Id: CcgTagContentGeneratorAdapter.java,v 1.3 2006-11-10 16:20:12 concentus Exp $
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

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.w3c.dom.Element;

import de.hasait.eclipse.ccg.parser.ICcgComment;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 */
public class CcgTagContentGeneratorAdapter extends AbstractCcgGenerator {
	private final ICcgBlockGenerator _generator;

	public CcgTagContentGeneratorAdapter(final String description, final String[] tagnames,
	      final ICcgBlockGenerator generator) {
		super(description, tagnames);
		//
		assert generator != null;
		_generator = generator;
	}

	public final String generate(final Element element, final ICcgGeneratorLookup transformatorLookup,
	      final Map context, final ICcgComment ccgComment, final IFile file) throws Exception {
		return _generator.generateBlock(file, ccgComment, element, context, transformatorLookup);
	}
}
