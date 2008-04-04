/*
 * $Id: ContentBufferDelegate.java,v 1.2 2008-04-04 13:31:32 concentus Exp $
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

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 16.11.2006
 */
public class ContentBufferDelegate {
	private final IContentBuffer _delegate;

	/**
	 * @param delegate
	 */
	public ContentBufferDelegate(final IContentBuffer delegate) {
		super();
		_delegate = delegate;
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#a(java.lang.String)
	 */
	public final IContentBuffer a(final String text) {
		return _delegate.a(text);
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#c()
	 */
	public final void c() {
		_delegate.c();
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#ci()
	 */
	public final void ci() {
		_delegate.ci();
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#getContent()
	 */
	public final String getContent() {
		return _delegate.getContent();
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#getDefaultIndent()
	 */
	public final String getDefaultIndent() {
		return _delegate.getDefaultIndent();
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#setDefaultIndent(java.lang.String)
	 */
	public final void setDefaultIndent(final String defaultIndent) {
		_delegate.setDefaultIndent(defaultIndent);
	}

	/**
    * @see de.hasait.eclipse.common.IContentBuffer#getNewline()
    */
   public final String getNewline() {
	   return _delegate.getNewline();
   }

	/**
    * @see de.hasait.eclipse.common.IContentBuffer#setNewline(java.lang.String)
    */
   public final void setNewline(String newline) {
	   _delegate.setNewline(newline);
   }

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#getIndent()
	 */
	public final String getIndent() {
		return _delegate.getIndent();
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#i()
	 */
	public final String i() {
		return _delegate.i();
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#i(java.lang.String)
	 */
	public final String i(final String newIndent) {
		return _delegate.i(newIndent);
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#p()
	 */
	public final void p() {
		_delegate.p();
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#p(java.lang.String)
	 */
	public final void p(final String lines) {
		_delegate.p(lines);
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#pi(java.lang.String, java.lang.String)
	 */
	public final void pi(final String lines, final String indent) {
		_delegate.pi(lines, indent);
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#pi(java.lang.String)
	 */
	public final void pi(final String lines) {
		_delegate.pi(lines);
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#pni(java.lang.String)
	 */
	public final void pni(final String lines) {
		_delegate.pni(lines);
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#u()
	 */
	public final String u() {
		return _delegate.u();
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#up(java.lang.String)
	 */
	public final void up(final String lines) {
		_delegate.up(lines);
	}

	/**
	 * @see de.hasait.eclipse.common.IContentBuffer#upi(java.lang.String)
	 */
	public final void upi(final String lines) {
		_delegate.upi(lines);
	}
}
