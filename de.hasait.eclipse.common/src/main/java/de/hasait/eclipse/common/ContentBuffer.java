/*
 * $Id: ContentBuffer.java,v 1.1 2008-04-08 11:06:07 concentus Exp $
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
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 16.11.2006
 */
public final class ContentBuffer implements IContentBuffer {
	private String _newline;

	private String _defaultIndent;

	private StringBuffer _buffer = new StringBuffer();

	private final LinkedList<String> _indents = new LinkedList<String>();

	private String _indent;

	private boolean _indentNeeded;

	/**
	 * @param defaultIndent
	 * @param newline
	 */
	public ContentBuffer(final String defaultIndent, final String newline) {
		super();

		setNewline(newline);

		setDefaultIndent(defaultIndent);

		updateIndent();

		_indentNeeded = true;
	}

	/**
	 * @param defaultIndent
	 */
	public ContentBuffer(final String defaultIndent) {
		this(defaultIndent, "\n");
	}

	/**
	 * Create with tab as defaultIndent.
	 */
	public ContentBuffer() {
		this("\t");
	}

	/**
	 * @return the newline
	 */
	public final String getNewline() {
		return _newline;
	}

	/**
	 * @param newline
	 *           the newline to set
	 */
	public final void setNewline(final String newline) {
		if (newline == null) {
			throw new IllegalArgumentException("newline == null");
		}
		_newline = newline;
	}

	public String getDefaultIndent() {
		return _defaultIndent;
	}

	public void setDefaultIndent(final String defaultIndent) {
		if (defaultIndent == null) {
			throw new IllegalArgumentException("defaultIndent == null");
		}
		_defaultIndent = defaultIndent;
	}

	private void updateIndent() {
		StringBuffer indent = new StringBuffer();
		for (Iterator indentsI = _indents.iterator(); indentsI.hasNext();) {
			indent.append((String) indentsI.next());
		}
		_indent = indent.toString();
	}

	public String getIndent() {
		return _indent;
	}

	public String i(final String newIndent) {
		_indents.addLast(newIndent);
		updateIndent();
		return _indent;
	}

	public String i() {
		return i(_defaultIndent);
	}

	public String u() {
		String oldIndent = _indents.removeLast();
		updateIndent();
		return oldIndent;
	}

	private void bi() {
		if (_indentNeeded) {
			_buffer.append(_indent);
			_indentNeeded = false;
		}
	}

	public ContentBuffer a(final String text) {
		bi();
		_buffer.append(text);
		return this;
	}

	private void bn() {
		_buffer.append(_newline);
		_indentNeeded = true;
	}

	public void p(final String lines) {
		if (lines.length() == 0) {
			// a("");
			bn();
		} else {
			BufferedReader lineReader = new BufferedReader(new StringReader(lines));
			String line;
			try {
				while ((line = lineReader.readLine()) != null) {
					a(line);
					bn();
				}
			} catch (IOException e) {
				// can not occur
			}
		}
	}

	public void pni(final String lines) {
		if (lines.length() == 0) {
			bn();
		} else {
			BufferedReader lineReader = new BufferedReader(new StringReader(lines));
			String line;
			try {
				while ((line = lineReader.readLine()) != null) {
					_buffer.append(line);
					bn();
				}
			} catch (IOException e) {
				// can not occur
			}
		}
	}

	public void p() {
		p("");
	}

	public void pi(final String lines, final String indent) {
		p(lines);
		i(indent);
	}

	public void pi(final String lines) {
		pi(lines, _defaultIndent);
	}

	public void up(final String lines) {
		u();
		p(lines);
	}

	public void upi(final String lines) {
		u();
		pi(lines);
	}

	public void c() {
		_buffer = new StringBuffer();
	}

	public void ci() {
		_indents.clear();
		updateIndent();
	}

	public String getContent() {
		return _buffer.toString();
	}

	@Override
	public String toString() {
		return getContent();
	}
}
