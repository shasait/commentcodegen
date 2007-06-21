/*
 * $Id: BsfResourceGenerator.java,v 1.5 2007-06-21 16:34:09 concentus Exp $
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
import de.hasait.eclipse.ccg.util.BsfExecuter;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.5 $
 */
public final class BsfResourceGenerator extends AbstractCcgResourceGenerator {
	private static final String DESCRIPTION = "Delegates the generation to a script";

	/**
	 * Constructor.
	 */
	public BsfResourceGenerator() {
		super(DESCRIPTION);
	}

	public void generateResources(final XElement configElement, final XFile sourceFile, final XFolder targetBaseFolder,
	      final Map sourceFileContext, final ICcgGeneratorLookup generatorLookup, final IProgressMonitor monitor)
	      throws Exception {
		BsfExecuter executer = new BsfExecuter(configElement, sourceFile, sourceFileContext, generatorLookup, monitor);
		executer.declareBean("targetBaseFolder", targetBaseFolder, XFolder.class);
		executer.declareBean("monitor", monitor, IProgressMonitor.class);
		executer.execute();
	}
}
