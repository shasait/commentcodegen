/*
 * $Id: BlockOrLineComment.java,v 1.1 2006-11-08 22:17:23 concentus Exp $
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
 * @version $Revision: 1.1 $
 */
public abstract class BlockOrLineComment extends SourceNode implements
        ICcgComment {
    public BlockOrLineComment(int id) {
        super(id);
    }

    public BlockOrLineComment(JavaCommentParser p, int id) {
        super(p, id);
    }

    public ICcgComment getComment() {
        Node child;
        for (int i = 0; i < jjtGetNumChildren(); i++) {
            child = jjtGetChild(i);
            if (child instanceof ICcgComment) {
                return (ICcgComment) child;
            }
        }
        return null;
    }

    public ICcgComment getCommentOrCreate() {
        ICcgComment comment = getComment();
        if (comment == null) {
            comment = insertComment();
        }
        return comment;
    }

    protected abstract ICcgComment insertComment();

    public String getCommand() {
        ICcgComment comment = getComment();
        return comment == null ? null : comment.getCommand();
    }

    public void setCommand(String command) {
        getCommentOrCreate().setCommand(command);
    }

    public String getBlockStart() {
        ICcgComment comment = getComment();
        return comment == null ? null : comment.getBlockStart();
    }

    public void setBlockStart(String blockStart) {
        getCommentOrCreate().setBlockStart(blockStart);
    }

    public String getBlockEnd() {
        ICcgComment comment = getComment();
        return comment == null ? null : comment.getBlockEnd();
    }

    public void setBlockEnd(String blockEnd) {
        getCommentOrCreate().setBlockEnd(blockEnd);
    }

    public String toString() {
        return super.toString() + " c=" + getCommand() + " bs="
                + getBlockStart() + " be=" + getBlockEnd();
    }

    public int getBeginColumn() {
        ICcgComment comment = getComment();
        return comment == null ? -1 : comment.getBeginColumn();
    }

    public int getBeginLine() {
        ICcgComment comment = getComment();
        return comment == null ? -1 : comment.getBeginLine();
    }

    public int getEndColumn() {
        ICcgComment comment = getComment();
        return comment == null ? -1 : comment.getEndColumn();
    }

    public int getEndLine() {
        ICcgComment comment = getComment();
        return comment == null ? -1 : comment.getEndLine();
    }
}
