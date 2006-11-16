/*
 * $Id: ResourceScriptHelper.java,v 1.1 2006-11-16 16:08:37 concentus Exp $
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

package de.hasait.eclipse.common.bsf;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;

import de.hasait.eclipse.common.ResourceUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 16.11.2006
 */
public class ResourceScriptHelper {
	private final IFile _baseFile;

	public ResourceScriptHelper(IFile baseFile) {
		super();
		//
		_baseFile = baseFile;
	}

	/**
	 * @return Returns the baseFile.
	 */
	public final IFile getBaseFile() {
		return _baseFile;
	}

	public final IFile getRelativeFile(IContainer baseContainer, String pathS) throws Exception {
		return ResourceUtil.getRelativeFile(baseContainer, pathS);
	}

	public final IFile getRelativeFile(IFile baseFile, String pathS) throws Exception {
		return ResourceUtil.getRelativeFile(baseFile, pathS);
	}

	public final IFile getRelativeFile(String pathS) throws Exception {
		return getRelativeFile(_baseFile, pathS);
	}

	public final IFolder getRelativeFolder(IContainer baseContainer, String pathS) throws Exception {
		return ResourceUtil.getRelativeFolder(baseContainer, pathS);
	}

	public final IFolder getRelativeFolder(IFile baseFile, String pathS) throws Exception {
		return ResourceUtil.getRelativeFolder(baseFile, pathS);
	}

	public final IFolder getRelativeFolder(String pathS) throws Exception {
		return getRelativeFolder(_baseFile, pathS);
	}

	public final String readFile(IFile inFile) throws Exception {
		return ResourceUtil.readFile(inFile);
	}

	public final void writeFile(IFile outFile, String contents, Boolean derived) throws Exception {
		ResourceUtil.writeFile(outFile, contents, derived);
	}

	public final void writeFile(IFile outFile, String contents) throws Exception {
		writeFile(outFile, contents, null);
	}

	public final void deleteAllFiles(IContainer container, Boolean derived) throws Exception {
		IResource[] members = container.members();
		for (int i = 0; i < members.length; i++) {
			IResource member = members[i];
			switch (member.getType()) {
			case IResource.FILE:
				if (derived == null || derived.booleanValue() == member.isDerived()) {
					member.delete(false, null);
				}
				break;
			}
		}
	}

	public final void deleteAllFiles(IContainer container) throws Exception {
		deleteAllFiles(container, null);
	}

	public final ContentScriptHelper createContent() {
		return new ContentScriptHelper();
	}
}
