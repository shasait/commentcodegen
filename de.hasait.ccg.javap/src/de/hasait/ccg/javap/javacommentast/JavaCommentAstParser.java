/*
 * $Id: JavaCommentAstParser.java,v 1.1.1.1 2005-09-01 23:06:39 a-pi Exp $
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
package de.hasait.ccg.javap.javacommentast;

import java.io.StringReader;

import de.hasait.ccg.javap.javacommentast.gen.JavaCommentParser;
import de.hasait.ccg.javap.javacommentast.gen.Node;
import de.hasait.ccg.javap.javacommentast.node.ASTComment;
import de.hasait.ccg.javap.javacommentast.node.ASTNonComment;
import de.hasait.ccg.javap.javacommentast.node.ASTRoot;
import de.hasait.ccg.javap.javacommentast.node.SimpleNode;
import de.hasait.ccg.parser.ICcgParser;
import de.hasait.ccg.parser.ICcgRoot;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1.1.1 $
 */
public class JavaCommentAstParser implements ICcgParser {
    private static final String[] FILE_EXTENSIONS = new String[] { "java", "cpp", "c" };

    public static ASTRoot get(String source) throws Exception {
        JavaCommentParser javaCommentParser = new JavaCommentParser(
                new StringReader(source));
        ASTRoot compilationUnit = javaCommentParser.Root();
        mergeComments(compilationUnit);
        mergeNonComments(compilationUnit);
        return compilationUnit;
    }

    public String[] getFileExtensions() {
        return FILE_EXTENSIONS;
    }

    public ICcgRoot parse(String source) throws Exception {
        return get(source);
    }

    public static void mergeComments(SimpleNode simpleNode) {
        int index = 0;
        Node child;
        Node child2;
        ASTComment comment;
        ASTComment comment2;
        while (index < simpleNode.jjtGetNumChildren() - 1) {
            child = simpleNode.jjtGetChild(index);
            child2 = simpleNode.jjtGetChild(index + 1);
            if (child instanceof ASTComment && child2 instanceof ASTComment) {
                comment = (ASTComment) child;
                comment2 = (ASTComment) child2;
                comment.setSource(comment.getSource() + comment2.getSource());
                simpleNode.jjtRemoveChild(index + 1);
            } else {
                if (child instanceof SimpleNode) {
                    mergeComments((SimpleNode) child);
                }
                if (child2 instanceof SimpleNode) {
                    mergeComments((SimpleNode) child2);
                }
                index++;
            }
        }
    }

    public static void mergeNonComments(SimpleNode simpleNode) {
        int index = 0;
        Node child;
        Node child2;
        ASTNonComment nonComment;
        ASTNonComment nonComment2;
        while (index < simpleNode.jjtGetNumChildren() - 1) {
            child = simpleNode.jjtGetChild(index);
            child2 = simpleNode.jjtGetChild(index + 1);
            if (child instanceof ASTNonComment
                    && child2 instanceof ASTNonComment) {
                nonComment = (ASTNonComment) child;
                nonComment2 = (ASTNonComment) child2;
                nonComment.setSource(nonComment.getSource()
                        + nonComment2.getSource());
                simpleNode.jjtRemoveChild(index + 1);
            } else {
                if (child instanceof SimpleNode) {
                    mergeNonComments((SimpleNode) child);
                }
                if (child2 instanceof SimpleNode) {
                    mergeNonComments((SimpleNode) child2);
                }
                index++;
            }
        }
    }
}
