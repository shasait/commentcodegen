/*
 * $Id: BlockOrLineComment.java,v 1.2 2007-01-06 00:43:04 concentus Exp $
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
package de.hasait.eclipse.ccg.javap.javacommentast.node;

import de.hasait.eclipse.ccg.javap.javacommentast.gen.JavaCommentParser;
import de.hasait.eclipse.ccg.javap.javacommentast.gen.Node;
import de.hasait.eclipse.ccg.parser.ICcgComment;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public abstract class BlockOrLineComment extends SourceNode implements ICcgComment {
	public BlockOrLineComment(final int pId) {
		super(pId);
	}

	public BlockOrLineComment(final JavaCommentParser pParser, final int pId) {
		super(pParser, pId);
	}

	public ICcgComment getComment() {
		Node vChild;
		for (int vChildI = 0; vChildI < jjtGetNumChildren(); vChildI++) {
			vChild = jjtGetChild(vChildI);
			if (vChild instanceof ICcgComment) {
				return (ICcgComment) vChild;
			}
		}
		return null;
	}

	public ICcgComment getCommentOrCreate() {
		ICcgComment vComment = getComment();
		if (vComment == null) {
			vComment = insertComment();
		}
		return vComment;
	}

	protected abstract ICcgComment insertComment();

	public String getCommand() {
		ICcgComment vComment = getComment();
		return vComment == null ? null : vComment.getCommand();
	}

	public void setCommand(final String pCommand) {
		getCommentOrCreate().setCommand(pCommand);
	}

	public String getBlockStart() {
		ICcgComment vComment = getComment();
		return vComment == null ? null : vComment.getBlockStart();
	}

	public void setBlockStart(final String pBlockStart) {
		getCommentOrCreate().setBlockStart(pBlockStart);
	}

	public String getBlockEnd() {
		ICcgComment vComment = getComment();
		return vComment == null ? null : vComment.getBlockEnd();
	}

	public void setBlockEnd(final String pBlockEnd) {
		getCommentOrCreate().setBlockEnd(pBlockEnd);
	}

	public String getCommentText() {
		ICcgComment vComment = getComment();
		return vComment == null ? null : vComment.getCommentText();
	}

	public void setCommentText(final String pCommentText) {
		getCommentOrCreate().setCommentText(pCommentText);
	}

	public String toString() {
		return super.toString() + " c=" + getCommand() + " bs=" + getBlockStart() + " be=" + getBlockEnd();
	}

	public int getBeginColumn() {
		ICcgComment vComment = getComment();
		return vComment == null ? -1 : vComment.getBeginColumn();
	}

	public int getBeginLine() {
		ICcgComment vComment = getComment();
		return vComment == null ? -1 : vComment.getBeginLine();
	}

	public int getEndColumn() {
		ICcgComment vComment = getComment();
		return vComment == null ? -1 : vComment.getEndColumn();
	}

	public int getEndLine() {
		ICcgComment vComment = getComment();
		return vComment == null ? -1 : vComment.getEndLine();
	}
}
