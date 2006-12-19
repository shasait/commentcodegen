/*
 * $Id: ApplicationResourceGenerator.java,v 1.2 2006-12-19 15:06:03 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.generator.AbstractCcgResourceGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 13.12.2006
 */
public class ApplicationResourceGenerator extends AbstractCcgResourceGenerator {
	private static final String DESCRIPTION = "Creates an application";

	private static final String[] TAG_NAMES = new String[] { "application" };

	/**
	 * Constructor.
	 */
	public ApplicationResourceGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public void generateResources(XElement pConfigElement, XFile pSourceFile, XFolder pTargetBaseFolder,
	      Map pSourceFileContext, ICcgGeneratorLookup pGeneratorLookup, IProgressMonitor pMonitor) throws Exception {
		Application vApplication = new Application(pSourceFile, pTargetBaseFolder, pConfigElement);
		vApplication.resolve(pMonitor);
		vApplication.validate(pMonitor);
		vApplication.write(pMonitor);
	}
}
