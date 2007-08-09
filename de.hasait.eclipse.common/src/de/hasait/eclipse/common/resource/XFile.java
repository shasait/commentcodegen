/*
 * $Id: XFile.java,v 1.4 2007-08-09 15:01:28 concentus Exp $
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.dom4j.DocumentException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.IOUtil;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.4 $
 * @since 01.12.2006
 */
public class XFile extends XResource {
	private final IFile _file;

	/**
	 * @param file
	 */
	public XFile(final IFile file, final IContainer absoluteBaseContainer) {
		super(file, absoluteBaseContainer);
		_file = file;
	}

	public XFile(final IFile file) {
		this(file, ResourcesPlugin.getWorkspace().getRoot());
	}

	/**
	 * @return the folder
	 */
	public final IFile getRawFile() {
		return _file;
	}

	public final XFile getFile(String path) {
		return getFile(_file.getParent(), path);
	}

	public final XFolder getFolder(String path) {
		return getFolder(_file.getParent(), path);
	}

	public final String read() throws CoreException {
		InputStream contentsIn = _file.getContents();
		try {
			try {
				Reader contentsReader = new InputStreamReader(contentsIn, _file.getCharset());
				try {
					return IOUtil.readAll(contentsReader);
				} finally {
					contentsReader.close();
				}
			} finally {
				contentsIn.close();
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, null, IStatus.ERROR, e.getLocalizedMessage(), e));
		}
	}

	public final void write(String contents, Boolean derived, IProgressMonitor monitor) throws CoreException {
		InputStream contentsIn = new ByteArrayInputStream(contents.getBytes());
		if (_file.exists()) {
			_file.setContents(contentsIn, false, true, monitor);
		} else {
			XFolder parent = getParentFolder();
			if (parent != null) {
				parent.create(derived, monitor);
			}
			_file.create(contentsIn, false, monitor);
		}
		if (derived != null) {
			_file.setDerived(derived.booleanValue());
		}
	}

	public final XElement parseXml() throws DocumentException, CoreException {
		return XElement.parse(read());
	}

	public final String getFileExtension() {
		return _file.getFileExtension();
	}
}
