/*
 * $Id: ContentBuffer.java,v 1.7 2007-01-15 20:39:47 concentus Exp $
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

package de.hasait.eclipse.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.7 $
 * @since 16.11.2006
 */
public class ContentBuffer {
	private StringBuffer _buffer = new StringBuffer();

	private final LinkedList _indents = new LinkedList();

	private String _indent;

	private String _defaultIndent;

	private boolean _indentNeeded;

	public ContentBuffer(String defaultIndent) {
		super();
		updateIndent();
		_defaultIndent = defaultIndent == null ? "\t" : defaultIndent;
		_indentNeeded = true;
	}

	public ContentBuffer() {
		this(null);
	}

	public final String getDefaultIndent() {
		return _defaultIndent;
	}

	public final void setDefaultIndent(String defaultIndent) {
		_defaultIndent = defaultIndent == null ? "\t" : defaultIndent;
	}

	private void updateIndent() {
		StringBuffer indent = new StringBuffer();
		for (Iterator indentsI = _indents.iterator(); indentsI.hasNext();) {
			indent.append((String) indentsI.next());
		}
		_indent = indent.toString();
	}

	public final String getIndent() {
		return _indent;
	}

	public final String i(String newIndent) {
		_indents.addLast(newIndent);
		updateIndent();
		return _indent;
	}

	public final String i() {
		return i(_defaultIndent);
	}

	public final String u() {
		String oldIndent = (String) _indents.removeLast();
		updateIndent();
		return oldIndent;
	}

	protected final void bi() {
		if (_indentNeeded) {
			_buffer.append(_indent);
			_indentNeeded = false;
		}
	}

	public final ContentBuffer a(String text) {
		bi();
		_buffer.append(text);
		return this;
	}

	protected final void bn() {
		_buffer.append("\n");
		_indentNeeded = true;
	}

	public final void p(final String pLines) {
		if (pLines.length() == 0) {
			a("");
			bn();
		} else {
			BufferedReader vLineReader = new BufferedReader(new StringReader(pLines));
			String vLine;
			try {
				while ((vLine = vLineReader.readLine()) != null) {
					a(vLine);
					bn();
				}
			} catch (IOException e) {
				// can not occur
			}
		}
	}

	public final void pni(final String pLines) {
		if (pLines.length() == 0) {
			bn();
		} else {
			BufferedReader vLineReader = new BufferedReader(new StringReader(pLines));
			String vLine;
			try {
				while ((vLine = vLineReader.readLine()) != null) {
					_buffer.append(vLine);
					bn();
				}
			} catch (IOException e) {
				// can not occur
			}
		}
	}

	public final void p() {
		p("");
	}

	public final void pi(String line, String indent) {
		p(line);
		i(indent);
	}

	public final void pi(String line) {
		pi(line, _defaultIndent);
	}

	public final void pu(String line) {
		u();
		p(line);
	}

	public final void pui(String line) {
		u();
		pi(line);
	}

	public final void c() {
		_buffer = new StringBuffer();
	}

	public final String getContent() {
		return _buffer.toString();
	}
}
