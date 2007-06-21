/*
 * $Id: AbstractCcgBlockGeneratorDelegate.java,v 1.1 2007-06-21 16:34:10 concentus Exp $
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

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * Delegates generation to an instance of {@link ICcgBlockGeneratorGenerate}.
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 10.11.2006
 */
public abstract class AbstractCcgBlockGeneratorDelegate extends AbstractCcgBlockGenerator {
	private final ICcgBlockGeneratorGenerate _generate;

	protected AbstractCcgBlockGeneratorDelegate(final String description, final ICcgBlockGeneratorGenerate generate) {
		super(description);

		if (generate == null) {
			throw new IllegalArgumentException("generate == null");
		}
		_generate = generate;
	}

	public final String generateBlock(final XElement configElement, final ICcgComment comment, final XFile sourceFile,
	      final Map sourceContext, final ICcgGeneratorLookup generatorLookup, final IProgressMonitor monitor)
	      throws Exception {
		return _generate.generateBlock(configElement, comment, sourceFile, sourceContext, generatorLookup, monitor);
	}
}
