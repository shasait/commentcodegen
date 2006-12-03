/*
 * $Id: XFile.java,v 1.1 2006-12-03 01:12:25 concentus Exp $
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

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.xml.sax.SAXException;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.IOUtil;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
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

	/**
	 * @return the folder
	 */
	public final IFile getRawFile() {
		return _file;
	}

	public final ContentBuffer createContentBuffer() {
		return new ContentBuffer();
	}

	public final XFile getFile(String path) {
		return getFile(_file.getParent(), path);
	}

	public final XFolder getFolder(String path) {
		return getFolder(_file.getParent(), path);
	}

	public final String read() throws IOException, CoreException {
		InputStream contentsIn = _file.getContents();
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

	public final XElement parseXml() throws ParserConfigurationException, FactoryConfigurationError, SAXException,
	      IOException, CoreException {
		return XElement.parse(read());
	}

	public final String getFileExtension() {
		return _file.getFileExtension();
	}
}
