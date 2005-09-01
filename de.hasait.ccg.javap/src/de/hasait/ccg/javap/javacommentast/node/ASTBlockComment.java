/*
 * $Id: ASTBlockComment.java,v 1.1.1.1 2005-09-01 23:06:41 a-pi Exp $
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
package de.hasait.ccg.javap.javacommentast.node;

import de.hasait.ccg.javap.javacommentast.gen.JavaCommentParser;
import de.hasait.ccg.javap.javacommentast.gen.JavaCommentParserTreeConstants;
import de.hasait.ccg.parser.ICcgComment;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1.1.1 $
 */
public class ASTBlockComment extends BlockOrLineComment {
    public ASTBlockComment(int id) {
        super(id);
    }

    public ASTBlockComment(JavaCommentParser p, int id) {
        super(p, id);
    }

    protected ICcgComment insertComment() {
        ASTComment comment = ASTComment.create();
        jjtInsertChild(comment, 1);
        return comment;
    }

    public static ASTBlockComment create() {
        ASTBlockComment blockComment = new ASTBlockComment(
                JavaCommentParserTreeConstants.JJTBLOCKCOMMENT);
        blockComment.jjtAddChild(ASTBlockCommentStart.create(), 0);
        blockComment.jjtAddChild(ASTBlockCommentEnd.create(), 1);
        return blockComment;
    }
}
