/*
 * $Id: AbstractCcgTagContentGeneratorAdapter.java,v 1.2 2008-04-04 13:13:21 concentus Exp $
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

import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public abstract class AbstractCcgTagContentGeneratorAdapter extends AbstractCcgGenerator implements ICcgBlockGenerator {
	private final ICcgBlockGeneratorGenerate _generator;

	protected AbstractCcgTagContentGeneratorAdapter(final String description, final ICcgBlockGeneratorGenerate generator) {
		super(description);

		if (generator == null) {
			throw new IllegalArgumentException("generator == null");
		}
		_generator = generator;
	}

	public final String generateBlock(final XElement configElement, final XFile sourceFile, final Map sourceFileContext,
	      final ICcgGeneratorLookup generatorLookup, final IProgressMonitor monitor)
	      throws Exception {
		return _generator.generateBlock(configElement, sourceFile, sourceFileContext, generatorLookup, monitor);
	}
}
