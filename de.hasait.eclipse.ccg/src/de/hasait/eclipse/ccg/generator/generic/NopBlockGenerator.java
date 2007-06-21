/*
 * $Id: NopBlockGenerator.java,v 1.3 2007-06-21 16:34:09 concentus Exp $
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

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.generator.AbstractCcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 */
public final class NopBlockGenerator extends AbstractCcgBlockGenerator {
	private static final String DESCRIPTION = "NOP (no operation) generator";

	/**
	 * Constructor.
	 */
	public NopBlockGenerator() {
		super(DESCRIPTION);
	}

	public String generateBlock(final XElement configElement, final ICcgComment comment, final XFile sourceFile,
	      final Map sourceFileContext, final ICcgGeneratorLookup generatorLookup, IProgressMonitor monitor)
	      throws Exception {
		return null;
	}
}
