/*
 * $Id: JavaCommentParserTokenManager.java,v 1.1 2006-11-08 20:54:48 concentus Exp $
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

public class JavaCommentParserTokenManager implements
        JavaCommentParserConstants {
    public java.io.PrintStream debugStream = System.out;

    public void setDebugStream(java.io.PrintStream ds) {
        debugStream = ds;
    }

    private final int jjStopAtPos(int pos, int kind) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        return pos + 1;
    }

    private final int jjMoveStringLiteralDfa0_1() {
        switch (curChar) {
        case 42:
            return jjMoveStringLiteralDfa1_1(0x10L);
        default:
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa1_1(long active0) {
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            return 1;
        }
        switch (curChar) {
        case 47:
            if ((active0 & 0x10L) != 0L)
                return jjStopAtPos(1, 4);
            break;
        default:
            return 2;
        }
        return 2;
    }

    private final int jjMoveStringLiteralDfa0_0() {
        switch (curChar) {
        case 47:
            return jjMoveStringLiteralDfa1_0(0x6L);
        default:
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa1_0(long active0) {
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            return 1;
        }
        switch (curChar) {
        case 42:
            if ((active0 & 0x2L) != 0L)
                return jjStopAtPos(1, 1);
            break;
        case 47:
            if ((active0 & 0x4L) != 0L)
                return jjStopAtPos(1, 2);
            break;
        default:
            return 2;
        }
        return 2;
    }

    private final int jjMoveStringLiteralDfa0_2() {
        return jjMoveNfa_2(0, 0);
    }

    private final int jjMoveNfa_2(int startState, int curPos) {
        int startsAt = 0;
        jjnewStateCnt = 3;
        int i = 1;
        jjstateSet[0] = startState;
        int kind = 0x7fffffff;
        for (;;) {
            if (++jjround == 0x7fffffff)
                ReInitRounds();
            if (curChar < 64) {
                long l = 1L << curChar;
                MatchLoop: do {
                    switch (jjstateSet[--i]) {
                    case 0:
                        if ((0x2400L & l) != 0L) {
                            if (kind > 5)
                                kind = 5;
                        }
                        if (curChar == 13)
                            jjstateSet[jjnewStateCnt++] = 1;
                        break;
                    case 1:
                        if (curChar == 10 && kind > 5)
                            kind = 5;
                        break;
                    case 2:
                        if (curChar == 13)
                            jjstateSet[jjnewStateCnt++] = 1;
                        break;
                    default:
                        break;
                    }
                } while (i != startsAt);
            } else if (curChar < 128) {
                MatchLoop: do {
                    switch (jjstateSet[--i]) {
                    default:
                        break;
                    }
                } while (i != startsAt);
            } else {
                MatchLoop: do {
                    switch (jjstateSet[--i]) {
                    default:
                        break;
                    }
                } while (i != startsAt);
            }
            if (kind != 0x7fffffff) {
                jjmatchedKind = kind;
                jjmatchedPos = curPos;
                kind = 0x7fffffff;
            }
            ++curPos;
            if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
                return curPos;
            try {
                curChar = input_stream.readChar();
            } catch (java.io.IOException e) {
                return curPos;
            }
        }
    }

    static final int[] jjnextStates = {};

    public static final String[] jjstrLiteralImages = { "", "\57\52", "\57\57",
            null, "\52\57", null, null, };

    public static final String[] lexStateNames = { "DEFAULT",
            "IN_BLOCK_COMMENT", "IN_LINE_COMMENT", };

    public static final int[] jjnewLexState = { -1, 1, 2, -1, 0, 0, -1, };

    protected JavaCharStream input_stream;

    private final int[] jjrounds = new int[3];

    private final int[] jjstateSet = new int[6];

    protected char curChar;

    public JavaCommentParserTokenManager(JavaCharStream stream) {
        if (JavaCharStream.staticFlag)
            throw new Error(
                    "ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
        input_stream = stream;
    }

    public JavaCommentParserTokenManager(JavaCharStream stream, int lexState) {
        this(stream);
        SwitchTo(lexState);
    }

    public void ReInit(JavaCharStream stream) {
        jjmatchedPos = jjnewStateCnt = 0;
        curLexState = defaultLexState;
        input_stream = stream;
        ReInitRounds();
    }

    private final void ReInitRounds() {
        int i;
        jjround = 0x80000001;
        for (i = 3; i-- > 0;)
            jjrounds[i] = 0x80000000;
    }

    public void ReInit(JavaCharStream stream, int lexState) {
        ReInit(stream);
        SwitchTo(lexState);
    }

    public void SwitchTo(int lexState) {
        if (lexState >= 3 || lexState < 0)
            throw new TokenMgrError("Error: Ignoring invalid lexical state : "
                    + lexState + ". State unchanged.",
                    TokenMgrError.INVALID_LEXICAL_STATE);
        curLexState = lexState;
    }

    protected Token jjFillToken() {
        Token t = Token.newToken(jjmatchedKind);
        t.kind = jjmatchedKind;
        String im = jjstrLiteralImages[jjmatchedKind];
        t.image = (im == null) ? input_stream.GetImage() : im;
        t.beginLine = input_stream.getBeginLine();
        t.beginColumn = input_stream.getBeginColumn();
        t.endLine = input_stream.getEndLine();
        t.endColumn = input_stream.getEndColumn();
        return t;
    }

    int curLexState = 0;

    int defaultLexState = 0;

    int jjnewStateCnt;

    int jjround;

    int jjmatchedPos;

    int jjmatchedKind;

    public Token getNextToken() {
        Token matchedToken;
        int curPos = 0;

        EOFLoop: for (;;) {
            try {
                curChar = input_stream.BeginToken();
            } catch (java.io.IOException e) {
                jjmatchedKind = 0;
                matchedToken = jjFillToken();
                return matchedToken;
            }

            switch (curLexState) {
            case 0:
                jjmatchedKind = 0x7fffffff;
                jjmatchedPos = 0;
                curPos = jjMoveStringLiteralDfa0_0();
                if (jjmatchedPos == 0 && jjmatchedKind > 3) {
                    jjmatchedKind = 3;
                }
                break;
            case 1:
                jjmatchedKind = 0x7fffffff;
                jjmatchedPos = 0;
                curPos = jjMoveStringLiteralDfa0_1();
                if (jjmatchedPos == 0 && jjmatchedKind > 6) {
                    jjmatchedKind = 6;
                }
                break;
            case 2:
                jjmatchedKind = 0x7fffffff;
                jjmatchedPos = 0;
                curPos = jjMoveStringLiteralDfa0_2();
                if (jjmatchedPos == 0 && jjmatchedKind > 6) {
                    jjmatchedKind = 6;
                }
                break;
            }
            if (jjmatchedKind != 0x7fffffff) {
                if (jjmatchedPos + 1 < curPos)
                    input_stream.backup(curPos - jjmatchedPos - 1);
                matchedToken = jjFillToken();
                if (jjnewLexState[jjmatchedKind] != -1)
                    curLexState = jjnewLexState[jjmatchedKind];
                return matchedToken;
            }
            int error_line = input_stream.getEndLine();
            int error_column = input_stream.getEndColumn();
            String error_after = null;
            boolean EOFSeen = false;
            try {
                input_stream.readChar();
                input_stream.backup(1);
            } catch (java.io.IOException e1) {
                EOFSeen = true;
                error_after = curPos <= 1 ? "" : input_stream.GetImage();
                if (curChar == '\n' || curChar == '\r') {
                    error_line++;
                    error_column = 0;
                } else
                    error_column++;
            }
            if (!EOFSeen) {
                input_stream.backup(1);
                error_after = curPos <= 1 ? "" : input_stream.GetImage();
            }
            throw new TokenMgrError(EOFSeen, curLexState, error_line,
                    error_column, error_after, curChar,
                    TokenMgrError.LEXICAL_ERROR);
        }
    }

}
