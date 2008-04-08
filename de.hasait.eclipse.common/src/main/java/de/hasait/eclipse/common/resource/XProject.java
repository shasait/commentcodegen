/*
 * $Id: XProject.java,v 1.1 2008-04-08 11:06:16 concentus Exp $
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

package de.hasait.eclipse.common.resource;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 01.12.2006
 */
public class XProject extends XContainer {
	private final IProject _project;

	/**
	 * @param project
	 */
	public XProject(final IProject project, final IContainer absoluteBaseContainer) {
		super(project, absoluteBaseContainer);
		_project = project;
	}

	public XProject(final IProject project) {
		this(project, ResourcesPlugin.getWorkspace().getRoot());
	}

	/**
	 * @return the project
	 */
	public final IProject getRawProject() {
		return _project;
	}
}
