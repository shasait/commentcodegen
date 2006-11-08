/*
 * $Id: CcgTagContentGeneratorAdapter.java,v 1.1 2006-11-08 20:29:06 concentus Exp $
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
package de.hasait.ccg.generator;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.w3c.dom.Element;

import de.hasait.ccg.parser.ICcgComment;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public class CcgTagContentGeneratorAdapter extends AbstractCcgTagContentGenerator {
	private final ICcgTagContentGenerator _generator;

	public CcgTagContentGeneratorAdapter(final String description, final String[] tagnames,
	      final ICcgTagContentGenerator generator) {
		super(description, tagnames);
		//
		assert generator != null;
		_generator = generator;
	}

	public final String generate(final Element element, final ICcgGeneratorLookup transformatorLookup,
	      final Map context, final ICcgComment ccgComment, final IFile file) throws Exception {
		return _generator.generate(element, transformatorLookup, context, ccgComment, file);
	}
}
