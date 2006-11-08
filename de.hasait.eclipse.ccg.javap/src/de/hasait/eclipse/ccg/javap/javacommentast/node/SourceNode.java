/*
 * $Id: SourceNode.java,v 1.1 2006-11-08 22:17:23 concentus Exp $
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
import de.hasait.eclipse.ccg.parser.ICcgSourceRead;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public abstract class SourceNode extends SimpleNode implements ICcgSourceRead {
    public SourceNode(int id) {
        super(id);
    }

    public SourceNode(JavaCommentParser parser, int id) {
        super(parser, id);
    }

    public String getSource() {
        StringBuffer result = new StringBuffer();
        Node child;
        for (int i = 0; i < jjtGetNumChildren(); ++i) {
            child = jjtGetChild(i);
            if (child instanceof ICcgSourceRead) {
                result.append(((ICcgSourceRead) child).getSource());
            }
        }
        return result.toString();
    }
}
