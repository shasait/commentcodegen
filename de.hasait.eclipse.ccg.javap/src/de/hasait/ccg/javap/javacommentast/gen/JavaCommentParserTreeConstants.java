/*
 * $Id: JavaCommentParserTreeConstants.java,v 1.1 2006-11-08 20:54:48 concentus Exp $
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

public interface JavaCommentParserTreeConstants {
    public int JJTROOT = 0;

    public int JJTBLOCKCOMMENT = 1;

    public int JJTBLOCKCOMMENTSTART = 2;

    public int JJTBLOCKCOMMENTEND = 3;

    public int JJTLINECOMMENT = 4;

    public int JJTLINECOMMENTSTART = 5;

    public int JJTLINECOMMENTEND = 6;

    public int JJTCOMMENT = 7;

    public int JJTNONCOMMENT = 8;

    public String[] jjtNodeName = { "Root", "BlockComment",
            "BlockCommentStart", "BlockCommentEnd", "LineComment",
            "LineCommentStart", "LineCommentEnd", "Comment", "NonComment", };
}
