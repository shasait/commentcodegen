/*
 * $Id: SimpleNode.java,v 1.1 2006-11-08 22:17:23 concentus Exp $
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

import java.util.ArrayList;
import java.util.List;

import de.hasait.eclipse.ccg.javap.javacommentast.gen.JavaCommentParser;
import de.hasait.eclipse.ccg.javap.javacommentast.gen.JavaCommentParserTreeConstants;
import de.hasait.eclipse.ccg.javap.javacommentast.gen.Node;
import de.hasait.eclipse.ccg.parser.ICcgTreeChild;
import de.hasait.eclipse.ccg.parser.ICcgTreeParent;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public class SimpleNode implements Node, ICcgTreeChild, ICcgTreeParent {
    protected Node _parent;

    private final List _children = new ArrayList();

    protected int _id;

    protected JavaCommentParser _parser;

    public SimpleNode(int id) {
        _id = id;
    }

    public SimpleNode(JavaCommentParser parser, int id) {
        this(id);
        _parser = parser;
    }

    public void jjtOpen() {
        //
    }

    public void jjtClose() {
        //
    }

    public void jjtSetParent(Node parent) {
        _parent = parent;
    }

    public Node jjtGetParent() {
        return _parent;
    }

    public void jjtAddChild(Node child, int index) {
        while (index >= _children.size()) {
            _children.add(null);
        }
        _children.set(index, child);
        child.jjtSetParent(this);
    }

    public void jjtInsertChild(Node child, int index) {
        while (index > _children.size()) {
            _children.add(null);
        }
        _children.add(index, child);
        child.jjtSetParent(this);
    }

    public void jjtRemoveChild(int index) {
        _children.remove(index);
    }

    public Node jjtGetChild(int index) {
        return (Node) _children.get(index);
    }

    public int jjtGetNumChildren() {
        return _children.size();
    }

    public String toString() {
        return JavaCommentParserTreeConstants.jjtNodeName[_id];
    }

    public void dumpTree(String prefix) {
        Node child;
        System.out.println(prefix + toString());
        for (int i = 0; i < jjtGetNumChildren(); ++i) {
            child = jjtGetChild(i);
            if (child instanceof SimpleNode) {
                ((SimpleNode) child).dumpTree(prefix + "  ");
            }
        }
    }

    public void setParentNode(ICcgTreeParent parent) {
        jjtSetParent((Node) parent);
    }

    public ICcgTreeParent getParentNode() {
        return (ICcgTreeParent) jjtGetParent();
    }

    public int childNodesSize() {
        return jjtGetNumChildren();
    }

    public ICcgTreeChild getChildNode(int index) {
        return (ICcgTreeChild) jjtGetChild(index);
    }

    public void setChildNode(int index, ICcgTreeChild child) {
        jjtAddChild((Node) child, index);
    }

    public void insertChildNode(int index, ICcgTreeChild child) {
        jjtInsertChild((Node) child, index);
    }

    public void removeChildNode(int index) {
        jjtRemoveChild(index);
    }
}
