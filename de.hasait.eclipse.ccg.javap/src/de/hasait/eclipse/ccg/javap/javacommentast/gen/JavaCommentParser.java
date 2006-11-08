/*
 * $Id: JavaCommentParser.java,v 1.1 2006-11-08 22:17:24 concentus Exp $
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
package de.hasait.eclipse.ccg.javap.javacommentast.gen;

import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTBlockComment;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTBlockCommentEnd;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTBlockCommentStart;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTComment;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTLineComment;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTLineCommentEnd;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTLineCommentStart;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTNonComment;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTRoot;

/**
 * Grammar to parse Java comments
 * 
 * @author Sebastian Hasait
 */
public class JavaCommentParser/* @bgen(jjtree) */implements
        JavaCommentParserTreeConstants, JavaCommentParserConstants {/* @bgen(jjtree) */
    protected JJTJavaCommentParserState jjtree = new JJTJavaCommentParserState();

    /*
     * Program structuring syntax follows.
     */
    final public ASTRoot Root() throws ParseException {
        /* @bgen(jjtree) Root */
        ASTRoot jjtn000 = new ASTRoot(this,
                JJTROOT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            label_1: while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case BLOCK_COMMENT_START:
                case LINE_COMMENT_START:
                case NON_COMMENT:
                    ;
                    break;
                default:
                    break label_1;
                }
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case BLOCK_COMMENT_START:
                    BlockComment();
                    break;
                case LINE_COMMENT_START:
                    LineComment();
                    break;
                case NON_COMMENT:
                    NonComment();
                    break;
                default:
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            jj_consume_token(0);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            {
                if (true)
                    return jjtn000;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true)
                        throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true)
                        throw (ParseException) jjte000;
                }
            }
            {
                if (true)
                    throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public void BlockComment() throws ParseException {
        /* @bgen(jjtree) BlockComment */
        ASTBlockComment jjtn000 = new ASTBlockComment(this, JJTBLOCKCOMMENT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            BlockCommentStart();
            label_2: while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case COMMENT:
                    ;
                    break;
                default:
                    break label_2;
                }
                Comment();
            }
            BlockCommentEnd();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true)
                        throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true)
                        throw (ParseException) jjte000;
                }
            }
            {
                if (true)
                    throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void BlockCommentStart() throws ParseException {
        /* @bgen(jjtree) BlockCommentStart */
        ASTBlockCommentStart jjtn000 = new ASTBlockCommentStart(this,
                JJTBLOCKCOMMENTSTART);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(BLOCK_COMMENT_START);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void BlockCommentEnd() throws ParseException {
        /* @bgen(jjtree) BlockCommentEnd */
        ASTBlockCommentEnd jjtn000 = new ASTBlockCommentEnd(this,
                JJTBLOCKCOMMENTEND);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(BLOCK_COMMENT_END);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void LineComment() throws ParseException {
        /* @bgen(jjtree) LineComment */
        ASTLineComment jjtn000 = new ASTLineComment(this, JJTLINECOMMENT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            LineCommentStart();
            label_3: while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case COMMENT:
                    ;
                    break;
                default:
                    break label_3;
                }
                Comment();
            }
            LineCommentEnd();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true)
                        throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true)
                        throw (ParseException) jjte000;
                }
            }
            {
                if (true)
                    throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void LineCommentStart() throws ParseException {
        /* @bgen(jjtree) LineCommentStart */
        ASTLineCommentStart jjtn000 = new ASTLineCommentStart(this,
                JJTLINECOMMENTSTART);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LINE_COMMENT_START);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void LineCommentEnd() throws ParseException {
        /* @bgen(jjtree) LineCommentEnd */
        ASTLineCommentEnd jjtn000 = new ASTLineCommentEnd(this,
                JJTLINECOMMENTEND);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LINE_COMMENT_END);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void Comment() throws ParseException {
        /* @bgen(jjtree) Comment */
        ASTComment jjtn000 = new ASTComment(this, JJTCOMMENT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(COMMENT);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void NonComment() throws ParseException {
        /* @bgen(jjtree) NonComment */
        ASTNonComment jjtn000 = new ASTNonComment(this, JJTNONCOMMENT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(NON_COMMENT);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    public JavaCommentParserTokenManager token_source;

    JavaCharStream jj_input_stream;

    public Token token, jj_nt;

    private int jj_ntk;

    public JavaCommentParser(java.io.InputStream stream) {
        jj_input_stream = new JavaCharStream(stream, 1, 1);
        token_source = new JavaCommentParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
    }

    public void ReInit(java.io.InputStream stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jjtree.reset();
    }

    public JavaCommentParser(java.io.Reader stream) {
        jj_input_stream = new JavaCharStream(stream, 1, 1);
        token_source = new JavaCommentParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
    }

    public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jjtree.reset();
    }

    public JavaCommentParser(JavaCommentParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
    }

    public void ReInit(JavaCommentParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jjtree.reset();
    }

    final private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null)
            token = token.next;
        else
            token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        if (token.kind == kind) {
            return token;
        }
        token = oldToken;
        throw generateParseException();
    }

    final public Token getNextToken() {
        if (token.next != null)
            token = token.next;
        else
            token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        return token;
    }

    final public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null)
                t = t.next;
            else
                t = t.next = token_source.getNextToken();
        }
        return t;
    }

    final private int jj_ntk() {
        if ((jj_nt = token.next) == null)
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);

        return (jj_ntk = jj_nt.kind);
    }

    public ParseException generateParseException() {
        Token errortok = token.next;
        int line = errortok.beginLine, column = errortok.beginColumn;
        String mess = (errortok.kind == 0) ? tokenImage[0] : errortok.image;
        return new ParseException("Parse error at line " + line + ", column "
                + column + ".  Encountered: " + mess);
    }

    final public void enable_tracing() {
        //
    }

    final public void disable_tracing() {
        //
    }

}
