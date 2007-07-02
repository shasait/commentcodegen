/*
 * $Id: JavaContentBuffer.java,v 1.1 2007-07-02 13:41:19 concentus Exp $
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
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 02.07.2007
 */
public class JavaContentBuffer extends ContentBuffer {
	/**
	 * 
	 */
	public JavaContentBuffer() {
		super();
	}

	/**
	 * @param defaultIndent
	 */
	public JavaContentBuffer(final String defaultIndent) {
		super(defaultIndent);
	}

	public final void blockCommentStart(final String line) {
		pi("/* " + line, " * ");
	}

	public final void blockCommentStart() {
		blockCommentStart("");
	}

	public final void blockCommentEnd(final String line) {
		pu(line + " */");
	}

	public final void blockCommentEnd() {
		blockCommentEnd("");
	}

	public final void javaDocCommentStart(final String line) {
		pi("/** " + line, " * ");
	}

	public final void javaDocStart() {
		javaDocCommentStart("");
	}

	public final void javaDocCommentEnd(final String line) {
		pu(line + " */");
	}

	public final void javaDocEnd() {
		javaDocCommentEnd("");
	}
}
