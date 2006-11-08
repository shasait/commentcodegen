/*
 * $Id: JavaCommentParserConstants.java,v 1.1 2006-11-08 20:54:48 concentus Exp $
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

public interface JavaCommentParserConstants {

    int EOF = 0;

    int BLOCK_COMMENT_START = 1;

    int LINE_COMMENT_START = 2;

    int NON_COMMENT = 3;

    int BLOCK_COMMENT_END = 4;

    int LINE_COMMENT_END = 5;

    int COMMENT = 6;

    int DEFAULT = 0;

    int IN_BLOCK_COMMENT = 1;

    int IN_LINE_COMMENT = 2;

    String[] tokenImage = { "<EOF>", "\"/*\"", "\"//\"", "<NON_COMMENT>",
            "\"*/\"", "<LINE_COMMENT_END>", "<COMMENT>", };

}
