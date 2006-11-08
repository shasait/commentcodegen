/*
 * $Id: ResourceUtil.java,v 1.1 2006-11-08 16:16:41 concentus Exp $
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
package de.hasait.eclipse.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class ResourceUtil {
	private ResourceUtil() {
		super();
	}

	public static String readFile(IFile file) throws IOException, CoreException {
		InputStream fileContents = file.getContents();
		Reader fileContentsReader = new InputStreamReader(fileContents, file
				.getCharset());
		String contents = IOUtil.readAll(fileContentsReader);
		fileContentsReader.close();
		fileContents.close();
		return contents;
	}

	public static void writeFile(IFile file, String contents)
			throws CoreException {
		writeFile(file, contents, null);
	}

	public static void writeFile(IFile file, String contents, Boolean derived)
			throws CoreException {
		InputStream source = new ByteArrayInputStream(contents.getBytes());
		if (file.exists()) {
			file.setContents(source, false, true, null);
		} else {
			createParentFolder(file.getParent(), derived);
			file.create(source, false, null);
		}
		if (derived != null) {
			file.setDerived(derived.booleanValue());
		}
	}

	public static void createParentFolder(IResource resource)
			throws CoreException {
		createParentFolder(resource, null);
	}

	public static void createParentFolder(IResource resource, Boolean derived)
			throws CoreException {
		if (resource != null) {
			if (!resource.exists()) {
				createParentFolder(resource.getParent(), derived);
				if (resource instanceof IFolder) {
					((IFolder) resource).create(false, true, null);
					if (derived != null) {
						resource.setDerived(derived.booleanValue());
					}
				} else {
					System.out.println(resource.getClass());
				}
			}
		}
	}

	public static IFile getRelativeFile(IContainer baseContainer, IPath path) {
		if (path.isAbsolute()) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		}
		return baseContainer.getFile(path);
	}

	public static IFile getRelativeFile(IContainer baseContainer, String pathS) {
		return getRelativeFile(baseContainer, new Path(pathS));
	}

	public static IFile getRelativeFile(IFile baseFile, IPath path) {
		return getRelativeFile(baseFile.getParent(), path);
	}

	public static IFile getRelativeFile(IFile baseFile, String pathS) {
		return getRelativeFile(baseFile.getParent(), pathS);
	}

	public static IFolder getRelativeFolder(IContainer baseContainer, IPath path) {
		if (path.isAbsolute()) {
			return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
		}
		return baseContainer.getFolder(path);
	}

	public static IFolder getRelativeFolder(IContainer baseContainer,
			String pathS) {
		return getRelativeFolder(baseContainer, new Path(pathS));
	}

	public static IFolder getRelativeFolder(IFile baseFile, IPath path) {
		return getRelativeFolder(baseFile.getParent(), path);
	}

	public static IFolder getRelativeFolder(IFile baseFile, String pathS) {
		return getRelativeFolder(baseFile.getParent(), pathS);
	}

	public static void deleteAllFiles(IContainer container)
			throws CoreException {
		deleteAllFiles(container, null);
	}

	public static void deleteAllFiles(IContainer container, Boolean derived)
			throws CoreException {
		IResource[] members = container.members();
		for (int i = 0; i < members.length; i++) {
			IResource member = members[i];
			switch (member.getType()) {
			case IResource.FILE:
				if (derived == null
						|| derived.booleanValue() == member.isDerived()) {
					member.delete(false, null);
				}
				break;
			}
		}
	}
}