/*
 * $Id: JavaCommentAstParser.java,v 1.2 2007-01-06 00:43:04 concentus Exp $
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
package de.hasait.eclipse.ccg.javap.javacommentast;

import java.io.StringReader;

import de.hasait.eclipse.ccg.javap.javacommentast.gen.JavaCommentParser;
import de.hasait.eclipse.ccg.javap.javacommentast.gen.Node;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTComment;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTLineComment;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTNonComment;
import de.hasait.eclipse.ccg.javap.javacommentast.node.ASTRoot;
import de.hasait.eclipse.ccg.javap.javacommentast.node.SimpleNode;
import de.hasait.eclipse.ccg.parser.ICcgParser;
import de.hasait.eclipse.ccg.parser.ICcgRoot;
import de.hasait.eclipse.common.StringUtil;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public class JavaCommentAstParser implements ICcgParser {
	private static final String[] FILE_EXTENSIONS = new String[] { "java", "cpp", "c" };

	public static ASTRoot get(String source) throws Exception {
		JavaCommentParser javaCommentParser = new JavaCommentParser(new StringReader(source));
		ASTRoot compilationUnit = javaCommentParser.Root();
		mergeComments(compilationUnit);
		mergeNonComments(compilationUnit);
		mergeLineComments(compilationUnit);
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
			if (child instanceof ASTNonComment && child2 instanceof ASTNonComment) {
				nonComment = (ASTNonComment) child;
				nonComment2 = (ASTNonComment) child2;
				nonComment.setSource(nonComment.getSource() + nonComment2.getSource());
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

	private static void mergeLineComments(final SimpleNode pSimpleNode) {
		int vChildI = 0;
		Node vChild1;
		Node vChild2;
		Node vChild3;
		Node vChild4;
		ASTNonComment vNonComment1;
		ASTLineComment vLineComment1;
		ASTNonComment vNonComment2;
		ASTLineComment vLineComment2;
		while (vChildI < pSimpleNode.jjtGetNumChildren() - 3) {
			vChild1 = pSimpleNode.jjtGetChild(vChildI);
			vChild2 = pSimpleNode.jjtGetChild(vChildI + 1);
			vChild3 = pSimpleNode.jjtGetChild(vChildI + 2);
			vChild4 = pSimpleNode.jjtGetChild(vChildI + 3);
			boolean vModified = false;
			if (vChild1 instanceof ASTNonComment && vChild2 instanceof ASTLineComment && vChild3 instanceof ASTNonComment
			      && vChild4 instanceof ASTLineComment) {
				vNonComment1 = (ASTNonComment) vChild1;
				vLineComment1 = (ASTLineComment) vChild2;
				vNonComment2 = (ASTNonComment) vChild3;
				vLineComment2 = (ASTLineComment) vChild4;
				String vNonComment2Source = vNonComment2.getSource();
				// is prefix?
				if (StringUtil.containsOnlyTheseChars(vNonComment2Source, " \t")) {
					String vNonComment1Source = vNonComment1.getSource();
					// is also prefix, but maybe more...
					if (vNonComment1Source.endsWith(vNonComment2Source)) {
						// remove prefix from first nonComment
						vNonComment1Source = vNonComment1Source.substring(0, vNonComment1Source.length()
						      - vNonComment2Source.length());
						vNonComment1.setSource(vNonComment1Source);
						vLineComment1.setLinePrefix(vNonComment2Source);
					}
					if (vLineComment1.getLinePrefix() != null && vLineComment1.getLinePrefix().equals(vNonComment2Source)) {
						vLineComment1.setCommentText(StringUtil.merge(new String[] { vLineComment1.getCommentText(),
						      vLineComment2.getCommentText() }, "\n"));
						pSimpleNode.jjtRemoveChild(vChildI + 2);
						pSimpleNode.jjtRemoveChild(vChildI + 2);
						if (StringUtil.isEmpty(vNonComment1.getSource())) {
							pSimpleNode.jjtRemoveChild(vChildI);
						}
						vModified = true;
					}
				}
			}
			if (!vModified) {
				vChildI++;
			}
		}
	}
}
