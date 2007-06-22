/*
 * $Id: AbstractScriptResourceGenerator.java,v 1.1 2007-06-22 14:16:40 concentus Exp $
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

import de.hasait.eclipse.ccg.generator.AbstractCcgResourceGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.util.IScriptExecuter;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public abstract class AbstractScriptResourceGenerator extends AbstractCcgResourceGenerator {
	private static final String DESCRIPTION = "Delegates the generation to a script";

	private final IScriptExecuter _scriptExecuter;

	protected AbstractScriptResourceGenerator(final IScriptExecuter scriptExecuter) {
		super(DESCRIPTION);
		if (scriptExecuter == null) {
			throw new IllegalArgumentException("scriptExecuter == null");
		}
		_scriptExecuter = scriptExecuter;
	}

	public final void generateResources(final XElement configElement, final XFile sourceFile,
	      final XFolder targetBaseFolder, final Map sourceFileContext, final ICcgGeneratorLookup generatorLookup,
	      final IProgressMonitor monitor) throws Exception {
		XFile scriptFile = sourceFile.getFile(configElement.getRequiredAttribute("file"));
		_scriptExecuter.init(scriptFile);
		_scriptExecuter.declareBean("configElement", configElement, XElement.class);
		_scriptExecuter.declareBean("sourceFile", sourceFile, XFile.class);
		_scriptExecuter.declareBean("targetBaseFolder", targetBaseFolder, XFolder.class);
		_scriptExecuter.declareBean("sourceContext", sourceFileContext, Map.class);
		_scriptExecuter.declareBean("generatorLookup", generatorLookup, ICcgGeneratorLookup.class);
		_scriptExecuter.declareBean("monitor", monitor, IProgressMonitor.class);
		_scriptExecuter.execute();
	}
}
