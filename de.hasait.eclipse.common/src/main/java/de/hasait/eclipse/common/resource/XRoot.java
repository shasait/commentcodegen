/*
 * $Id: XRoot.java,v 1.1 2008-04-08 11:06:16 concentus Exp $
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
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 01.12.2006
 */
public class XRoot extends XContainer {
	private final IWorkspaceRoot _root;

	/**
	 * @param root
	 */
	public XRoot(final IWorkspaceRoot root, final IContainer absoluteBaseContainer) {
		super(root, absoluteBaseContainer);
		_root = root;
	}

	public XRoot(final IWorkspaceRoot root) {
		this(root, ResourcesPlugin.getWorkspace().getRoot());
	}

	/**
	 * @return the root
	 */
	public final IWorkspaceRoot getRawRoot() {
		return _root;
	}

	public final XProject getProject(String name) {
		return wrapProject(_root.getProject(name));
	}
}
