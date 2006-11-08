/*
 * $Id: ContentBuffer.java,v 1.1 2006-11-08 16:16:41 concentus Exp $
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

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public class ContentBuffer {
	private StringBuffer _buffer = new StringBuffer();

	private final LinkedList _indents = new LinkedList();

	private String _indent;

	private String _defaultIndent;

	public ContentBuffer() {
		super();
		updateIndent();
	}

	public String getDefaultIndent() {
		return _defaultIndent;
	}

	public void setDefaultIndent(String defaultIndent) {
		_defaultIndent = defaultIndent;
	}

	private void updateIndent() {
		StringBuffer result = new StringBuffer();
		for (Iterator indentsI = _indents.iterator(); indentsI.hasNext();) {
			result.append(indentsI.next());
		}
		_indent = result.toString();
	}

	public String getIndent() {
		return _indent;
	}

	public String i(String newIndent) {
		_indents.addLast(newIndent);
		updateIndent();
		return _indent;
	}

	public String u() {
		String oldIndent = (String) _indents.removeLast();
		updateIndent();
		return oldIndent;
	}

	public void p(String line) {
		_buffer.append(_indent).append(line).append("\n");
	}

	public void p() {
		p("");
	}

	public void pi(String line, String indent) {
		p(line);
		i(indent);
	}

	public void pi(String line) {
		pi(line, _defaultIndent);
	}

	public void pu(String line) {
		u();
		p(line);
	}

	public void c() {
		_buffer = new StringBuffer();
	}

	public String getContent() {
		return _buffer.toString();
	}
}