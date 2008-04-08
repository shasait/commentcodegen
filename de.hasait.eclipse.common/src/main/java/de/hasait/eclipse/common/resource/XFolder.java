/*
 * $Id: XFolder.java,v 1.1 2008-04-08 11:06:16 concentus Exp $
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
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 01.12.2006
 */
public class XFolder extends XContainer {
	private final IFolder _folder;

	/**
	 * @param folder
	 */
	public XFolder(final IFolder folder, final IContainer absoluteBaseContainer) {
		super(folder, absoluteBaseContainer);
		_folder = folder;
	}

	public XFolder(final IFolder folder) {
		this(folder, ResourcesPlugin.getWorkspace().getRoot());
	}

	/**
	 * @return the folder
	 */
	public final IFolder getRawFolder() {
		return _folder;
	}

	public final void create(Boolean derived, IProgressMonitor monitor) throws CoreException {
		if (!_folder.exists()) {
			XFolder parent = getParentFolder();
			if (parent != null) {
				parent.create(derived, monitor);
			}
			_folder.create(false, true, monitor);
			if (derived != null) {
				_folder.setDerived(derived.booleanValue());
			}
		}
	}
}
