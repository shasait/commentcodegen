/*
 * $Id: XContainer.java,v 1.1 2006-12-03 01:12:25 concentus Exp $
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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 01.12.2006
 */
public abstract class XContainer extends XResource {
	private final IContainer _container;

	/**
	 * @param container
	 */
	protected XContainer(final IContainer container, final IContainer absoluteBaseContainer) {
		super(container, absoluteBaseContainer);
		_container = container;
	}

	/**
	 * @return the wrapped container
	 */
	public final IContainer getRawContainer() {
		return _container;
	}

	public final XFile getFile(String pathS) {
		return getFile(_container, pathS);
	}

	public final XFolder getFolder(String pathS) {
		return getFolder(_container, pathS);
	}

	public final XResource[] members() throws CoreException {
		IResource[] members = _container.members();
		XResource[] result = new XResource[members.length];
		for (int i = 0; i < members.length; i++) {
			result[i] = wrapResource(members[i]);
		}
		return result;
	}

	public final void deleteFiles(Boolean derived, IProgressMonitor monitor) throws CoreException {
		if (_container.exists()) {
			IResource[] members = _container.members();
			for (int i = 0; i < members.length; i++) {
				IResource member = members[i];
				if (member.getType() == IResource.FILE) {
					if (derived == null || derived.booleanValue() == member.isDerived()) {
						member.delete(false, monitor);
					}
				}
			}
		}
	}

	public final void deleteAll(Boolean derived, IProgressMonitor monitor) throws CoreException {
		if (_container.exists()) {
			IResource[] members = _container.members();
			for (int i = 0; i < members.length; i++) {
				IResource member = members[i];
				if (derived == null || derived.booleanValue() == member.isDerived()) {
					member.delete(false, monitor);
				}
			}
		}
	}
}
