/*
 * $Id: ICcgBlockGeneratorGenerate.java,v 1.5 2008-04-04 13:13:21 concentus Exp $
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
 * Generates a code block.
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.5 $
 */
public interface ICcgBlockGeneratorGenerate {
	/**
	 * @param configElement
	 *           The generators XML configuration.
	 * @param sourceFile
	 *           The source file containing the comment.
	 * @param sourceFileContext
	 *           A context bound to the sourceFile - not preserved between multiple sourceFile changes.
	 * @param generatorLookup
	 *           Can be used to lookup other generators e.g. for nested generation.
	 * @param monitor
	 *           The progress monitor.
	 * @return The code block to insert after the comment.
	 * @throws Exception
	 *            Give me your exceptions...
	 */
	String generateBlock(XElement configElement, XFile sourceFile, Map sourceFileContext,
	      ICcgGeneratorLookup generatorLookup, IProgressMonitor monitor) throws Exception;
}
