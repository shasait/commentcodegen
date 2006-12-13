/*
 * $Id: XResource.java,v 1.3 2006-12-13 21:59:54 concentus Exp $
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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 * @since 01.12.2006
 */
public abstract class XResource {
	private final IResource _resource;

	private final IContainer _absoluteBaseContainer;

	/**
	 * @param resource
	 * @param absoluteBaseContainer
	 */
	protected XResource(final IResource resource, final IContainer absoluteBaseContainer) {
		super();
		//
		if (resource == null) {
			throw new NullPointerException("resource == null");
		}
		_resource = resource;
		//
		if (absoluteBaseContainer == null) {
			throw new IllegalArgumentException("absoluteBaseContainer == null");
		}
		_absoluteBaseContainer = absoluteBaseContainer;
	}

	public static XResource create(final IResource resource, final IContainer absoluteBaseContainer) {
		switch (resource.getType()) {
		case IResource.FILE:
			return new XFile((IFile) resource, absoluteBaseContainer);
		case IResource.FOLDER:
			return new XFolder((IFolder) resource, absoluteBaseContainer);
		case IResource.PROJECT:
			return new XProject((IProject) resource, absoluteBaseContainer);
		case IResource.ROOT:
			return new XRoot((IWorkspaceRoot) resource, absoluteBaseContainer);
		}
		throw new IllegalArgumentException("resource type unknown: " + resource.getType());
	}

	protected final XResource wrapResource(final IResource resource) {
		return create(resource, _absoluteBaseContainer);
	}

	protected final XContainer wrapContainer(final IContainer container) {
		return (XContainer) create(container, _absoluteBaseContainer);
	}

	protected final XFile wrapFile(final IFile file) {
		return new XFile(file, _absoluteBaseContainer);
	}

	protected final XFolder wrapFolder(final IFolder folder) {
		return new XFolder(folder, _absoluteBaseContainer);
	}

	protected final XProject wrapProject(final IProject project) {
		return new XProject(project, _absoluteBaseContainer);
	}

	protected final XRoot wrapRoot(final IWorkspaceRoot root) {
		return new XRoot(root, _absoluteBaseContainer);
	}

	/**
	 * @return the resource
	 */
	public final IResource getRawResource() {
		return _resource;
	}

	/**
	 * @return the absoluteBaseContainer
	 */
	public final IContainer getAbsoluteBaseContainer() {
		return _absoluteBaseContainer;
	}

	public boolean equals(Object obj) {
		if (obj instanceof XResource) {
			XResource other = (XResource) obj;
			return _resource.equals(other._resource) && _absoluteBaseContainer.equals(other._absoluteBaseContainer);
		}
		return false;
	}

	public int hashCode() {
		return _resource.hashCode();
	}

	/**
	 * @see org.eclipse.core.resources.IResource#getLocation()
	 */
	public final IPath getLocation() {
		return _resource.getLocation();
	}

	/**
	 * @see org.eclipse.core.resources.IResource#exists()
	 */
	public final boolean exists() {
		return _resource.exists();
	}

	public final boolean isFile() {
		return _resource.getType() == IResource.FILE;
	}

	public final boolean isFolder() {
		return _resource.getType() == IResource.FOLDER;
	}

	public final boolean isProject() {
		return _resource.getType() == IResource.PROJECT;
	}

	public final boolean isRoot() {
		return _resource.getType() == IResource.ROOT;
	}

	/**
	 * @see org.eclipse.core.resources.IResource#isDerived()
	 */
	public boolean isDerived() {
		return _resource.isDerived();
	}

	/**
	 * @see org.eclipse.core.resources.IResource#getFullPath()
	 */
	public IPath getFullPath() {
		return _resource.getFullPath();
	}

	/**
	 * @see org.eclipse.core.resources.IResource#getName()
	 */
	public String getName() {
		return _resource.getName();
	}

	public final XContainer getParent() {
		return wrapContainer(_resource.getParent());
	}

	public final XFolder getParentFolder() {
		IContainer parent = _resource.getParent();
		if (parent.getType() == IResource.FOLDER) {
			return wrapFolder((IFolder) parent);
		}
		return null;
	}

	protected final XFile getFile(IContainer relativeBaseContainer, String pathS) {
		IPath path = new Path(pathS);
		return wrapFile(getPathBaseContainer(relativeBaseContainer, path).getFile(path));
	}

	protected final XFolder getFolder(IContainer relativeBaseContainer, String pathS) {
		IPath path = new Path(pathS);
		return wrapFolder(getPathBaseContainer(relativeBaseContainer, path).getFolder(path));
	}

	private IContainer getPathBaseContainer(IContainer relativeBaseContainer, IPath path) {
		if (path.isAbsolute()) {
			return _absoluteBaseContainer;
		}
		return relativeBaseContainer;
	}

	public final XProject getProject() {
		return wrapProject(_resource.getProject());
	}

	/**
	 * @see org.eclipse.core.resources.IResource#delete(boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void delete(boolean force, IProgressMonitor monitor) throws CoreException {
		_resource.delete(force, monitor);
	}

	public String toString() {
		return this.getClass().getName() + "(" + getLocation().toOSString() + ")";
	}
}
