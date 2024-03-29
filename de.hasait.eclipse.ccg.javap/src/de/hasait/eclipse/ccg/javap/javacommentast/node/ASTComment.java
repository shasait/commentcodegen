/*
 * $Id: ASTComment.java,v 1.4 2007-06-21 16:35:50 concentus Exp $
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
import de.hasait.eclipse.ccg.javap.javacommentast.gen.JavaCommentParserTreeConstants;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.common.StringUtil;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.4 $
 */
public class ASTComment extends SourceLeaf implements ICcgComment {
	public static final String C_START = "[c]";

	public static final String C_END = "[/c]";

	public static final String BS_START = "[bs]";

	public static final String BS_END = "[/bs]";

	public static final String BE_START = "[be]";

	public static final String BE_END = "[/be]";

	public ASTComment(final int pId) {
		super(pId);
	}

	public ASTComment(final JavaCommentParser pParser, final int pId) {
		super(pParser, pId);
	}

	public static ASTComment create() {
		ASTComment comment = new ASTComment(JavaCommentParserTreeConstants.JJTCOMMENT);
		return comment;
	}

	public String getCommand() {
		return StringUtil.getMergedBlocks(getSource(), C_START, C_END);
	}

	public void setCommand(final String pCommand) {
		setCommentText(StringUtil.setMergedBlocks(getCommentText(), pCommand, C_START, C_END));
	}

	public String getBlockStart() {
		return StringUtil.getMergedBlocks(getCommentText(), BS_START, BS_END);
	}

	public void setBlockStart(final String pBlockStart) {
		setCommentText(StringUtil.setMergedBlocks(getCommentText(), pBlockStart, BS_START, BS_END));
	}

	public String getBlockEnd() {
		return StringUtil.getMergedBlocks(getCommentText(), BE_START, BE_END);
	}

	public void setBlockEnd(final String pBlockEnd) {
		setCommentText(StringUtil.setMergedBlocks(getCommentText(), pBlockEnd, BE_START, BE_END));
	}

	public final String getCommentText() {
		return getSource();
	}

	public final void setCommentText(final String pCommentText) {
		setSource(pCommentText);
	}

	public String toString() {
		return super.toString() + " c=" + getCommand() + " bs=" + getBlockStart() + " be=" + getBlockEnd();
	}
}
