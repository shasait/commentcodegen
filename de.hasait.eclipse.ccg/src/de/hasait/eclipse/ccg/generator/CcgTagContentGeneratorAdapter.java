/*
 * $Id: CcgTagContentGeneratorAdapter.java,v 1.5 2006-12-03 01:09:45 concentus Exp $
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

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.5 $
 */
public class CcgTagContentGeneratorAdapter extends AbstractCcgGenerator implements ICcgBlockGenerator {
	private final ICcgBlockGeneratorGenerate _generator;

	/**
	 * Constructor.
	 * 
	 * @param description
	 * @param tagNames
	 * @param generator
	 */
	public CcgTagContentGeneratorAdapter(final String description, final String[] tagNames,
	      final ICcgBlockGeneratorGenerate generator) {
		super(description, tagNames);
		//
		assert generator != null;
		_generator = generator;
	}

	public String generateBlock(XElement configElement, ICcgComment comment, XFile sourceFile, Map sourceFileContext,
	      ICcgGeneratorLookup generatorLookup, IProgressMonitor monitor) throws Exception {
		return _generator.generateBlock(configElement, comment, sourceFile, sourceFileContext, generatorLookup, monitor);
	}
}
