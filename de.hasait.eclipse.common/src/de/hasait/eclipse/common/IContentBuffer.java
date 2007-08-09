/*
 * $Id: IContentBuffer.java,v 1.1 2007-08-09 14:20:13 concentus Exp $
 * 
 * Copyright 2007 Sebastian Hasait
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

/**
 * A smart {@link String} buffer for creating Text with indent, like sourceCode.
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 09.08.2007
 */
public interface IContentBuffer {
	/**
	 * @return The defaultIndent.
	 */
	public String getDefaultIndent();

	/**
	 * @param defaultIndent
	 *           The defaultIndent to set.
	 */
	public void setDefaultIndent(final String defaultIndent);

	/**
	 * @return The current indent.
	 */
	public String getIndent();

	/**
	 * i = indent: Add defaultIndent to indent-stack.
	 */
	public String i();

	/**
	 * i = indent: Add newIndent to indent-stack.
	 */
	public String i(String newIndent);

	/**
	 * u = unindent: Remove top from indent-stack.
	 */
	public String u();

	/**
	 * a = append: Append text.
	 */
	public IContentBuffer a(String text);

	/**
	 * p = print: Append lines and end with newline. If lines contains newlines, these will be indented, too.
	 */
	public void p(final String lines);

	/**
	 * p = print: Append newline.
	 */
	public void p();

	/**
	 * pi = print indent: {@link #p(String)} follewed by {@link #i()}.
	 */
	public void pi(String lines);

	/**
	 * pi = print indent: {@link #p(String)} follewed by {@link #i()}.
	 */
	public void pi(String lines, String indent);

	/**
	 * pni = print no indent: Append lines without handling of contained newlines.
	 */
	public void pni(final String lines);

	/**
	 * up = unindent print: {@link #u()} followed by {@link #p(String)}.
	 */
	public void up(String lines);

	/**
	 * up = unindent print indent: {@link #u()} followed by {@link #pi(String)}.
	 */
	public void upi(String lines);

	/**
	 * c = clear: Clear content (indent is not cleared).
	 */
	public void c();

	/**
	 * ci = clear indent: Clear indent.
	 */
	public void ci();

	/**
	 * @return The produced content so far.
	 */
	public String getContent();
}
