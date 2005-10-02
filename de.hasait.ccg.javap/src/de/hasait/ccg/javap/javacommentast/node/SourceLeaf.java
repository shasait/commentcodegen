/*
 * $Id: SourceLeaf.java,v 1.2 2005-10-02 00:33:52 a-pi Exp $
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
import de.hasait.ccg.javap.javacommentast.gen.Token;
import de.hasait.ccg.parser.ICcgPositionRead;
import de.hasait.ccg.parser.ICcgSourceReadWrite;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public abstract class SourceLeaf extends SourceNode implements
        ICcgPositionRead, ICcgSourceReadWrite {
    private final StringBuffer _source = new StringBuffer();

    private int _beginColumn = -1;

    private int _beginLine = -1;

    private int _endColumn = -1;

    private int _endLine = -1;

    public SourceLeaf(int id) {
        super(id);
    }

    public SourceLeaf(JavaCommentParser parser, int id) {
        super(parser, id);
    }

    public void jjtClose() {
        super.jjtClose();
        Token token = _parser.getToken(0);
        addSource(token.image);
        _beginColumn = token.beginColumn;
        _beginLine = token.beginLine;
        _endColumn = token.endColumn;
        _endLine = token.endLine;
    }

    public void jjtOpen() {
        super.jjtOpen();
    }

    public void addSource(String source) {
        _source.append(source);
    }

    public void setSource(String source) {
        _source.replace(0, _source.length(), source);
    }

    public String getSource() {
        return _source.toString();
    }

    public int getEndColumn() {
        return _endColumn;
    }

    public int getEndLine() {
        return _endLine;
    }

    public int getBeginColumn() {
        return _beginColumn;
    }

    public int getBeginLine() {
        return _beginLine;
    }
}
