/*
 * $Id: XResource.java,v 1.4 2006-12-30 18:30:17 concentus Exp $
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
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.4 $
 * @since 01.12.2006
 */
public abstract class XResource {
	private final IResource _resource;

	private final IContainer _absoluteBaseContainer;

	/**
	 * @param pResource
	 * @param pAbsoluteBaseContainer
	 */
	protected XResource(final IResource pResource, final IContainer pAbsoluteBaseContainer) {
		super();
		//
		if (pResource == null) {
			throw new NullPointerException("resource == null");
		}
		_resource = pResource;
		//
		if (pAbsoluteBaseContainer == null) {
			throw new IllegalArgumentException("absoluteBaseContainer == null");
		}
		_absoluteBaseContainer = pAbsoluteBaseContainer;
	}

	protected XResource(final IResource pResource) {
		this(pResource, ResourcesPlugin.getWorkspace().getRoot());
	}

	public static XResource create(final IResource pResource, final IContainer pAbsoluteBaseContainer) {
		switch (pResource.getType()) {
		case IResource.FILE:
			return new XFile((IFile) pResource, pAbsoluteBaseContainer);
		case IResource.FOLDER:
			return new XFolder((IFolder) pResource, pAbsoluteBaseContainer);
		case IResource.PROJECT:
			return new XProject((IProject) pResource, pAbsoluteBaseContainer);
		case IResource.ROOT:
			return new XRoot((IWorkspaceRoot) pResource, pAbsoluteBaseContainer);
		}
		throw new IllegalArgumentException("resource type unknown: " + pResource.getType());
	}

	protected final XResource wrapResource(final IResource pResource) {
		return create(pResource, _absoluteBaseContainer);
	}

	protected final XContainer wrapContainer(final IContainer pContainer) {
		return (XContainer) create(pContainer, _absoluteBaseContainer);
	}

	protected final XFile wrapFile(final IFile pFile) {
		return new XFile(pFile, _absoluteBaseContainer);
	}

	protected final XFolder wrapFolder(final IFolder pFolder) {
		return new XFolder(pFolder, _absoluteBaseContainer);
	}

	protected final XProject wrapProject(final IProject pProject) {
		return new XProject(pProject, _absoluteBaseContainer);
	}

	protected final XRoot wrapRoot(final IWorkspaceRoot pRoot) {
		return new XRoot(pRoot, _absoluteBaseContainer);
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

	public boolean equals(final Object pOther) {
		if (pOther instanceof XResource) {
			XResource other = (XResource) pOther;
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

	protected final XFile getFile(final IContainer pRelativeBaseContainer,final  String pPathS) {
		IPath path = new Path(pPathS);
		return wrapFile(getPathBaseContainer(pRelativeBaseContainer, path).getFile(path));
	}

	protected final XFolder getFolder(final IContainer pRelativeBaseContainer, final String pPathS) {
		IPath path = new Path(pPathS);
		return wrapFolder(getPathBaseContainer(pRelativeBaseContainer, path).getFolder(path));
	}

	private IContainer getPathBaseContainer(IContainer pRelativeBaseContainer, IPath pPath) {
		if (pPath.isAbsolute()) {
			return _absoluteBaseContainer;
		}
		return pRelativeBaseContainer;
	}

	public final XProject getProject() {
		return wrapProject(_resource.getProject());
	}

	/**
	 * @see org.eclipse.core.resources.IResource#delete(boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public final void delete(final boolean pForce, final IProgressMonitor pMonitor) throws CoreException {
		_resource.delete(pForce, pMonitor);
	}

	/**
	 * @see org.eclipse.core.resources.IResource#createMarker(java.lang.String)
	 */
	public final IMarker createMarker(final String pType) throws CoreException {
		return _resource.createMarker(pType);
	}

	/**
	 * Create marker and set attributes.
	 * 
	 * @see org.eclipse.core.resources.IResource#createMarker(java.lang.String)
	 */
	public final IMarker createMarker(final String pType, final int pSeverity, final String pMessage,
	      final int pLineNumber) throws CoreException {
		IMarker marker = createMarker(pType);
		marker.setAttribute(IMarker.SEVERITY, pSeverity);
		marker.setAttribute(IMarker.MESSAGE, pMessage);
		marker.setAttribute(IMarker.LINE_NUMBER, pLineNumber < 1 ? 1 : pLineNumber);
		return marker;
	}

	/**
	 * @see org.eclipse.core.resources.IResource#deleteMarkers(java.lang.String, boolean, int)
	 */
	public final void deleteMarkers(final String pType, final boolean pIncludeSubtypes, final int pDepth)
	      throws CoreException {
		_resource.deleteMarkers(pType, pIncludeSubtypes, pDepth);
	}

	/**
	 * Delete markers - not subtypes and DEPTH_ZERO.
	 * 
	 * @see org.eclipse.core.resources.IResource#deleteMarkers(java.lang.String, boolean, int)
	 */
	public final void deleteMarkers(final String pType) throws CoreException {
		deleteMarkers(pType, false, IResource.DEPTH_ZERO);
	}

	public String toString() {
		return this.getClass().getName() + "(" + getLocation().toOSString() + ")";
	}
}
