/*
 * $Id: ASTRoot.java,v 1.1.1.1 2005-09-01 23:06:42 a-pi Exp $
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
import de.hasait.ccg.parser.ICcgComment;
import de.hasait.ccg.parser.ICcgNonComment;
import de.hasait.ccg.parser.ICcgRoot;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1.1.1 $
 */
public class ASTRoot extends SourceNode implements ICcgRoot {
    public ASTRoot(int id) {
        super(id);
    }

    public ASTRoot(JavaCommentParser p, int id) {
        super(p, id);
    }

    public ICcgComment createComment() {
        return ASTLineComment.create();
    }

    public ICcgNonComment createNonComment() {
        return ASTNonComment.create();
    }
}
