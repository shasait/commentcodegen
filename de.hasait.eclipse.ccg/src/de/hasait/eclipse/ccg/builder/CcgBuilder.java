/*
 * $Id: CcgBuilder.java,v 1.2 2006-11-10 14:01:04 concentus Exp $
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
package de.hasait.eclipse.ccg.builder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.w3c.dom.Element;

import de.hasait.eclipse.ccg.generator.CcgGeneratorLookupEp;
import de.hasait.eclipse.ccg.generator.ICcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.CcgParserLookupEp;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.ccg.parser.ICcgNonComment;
import de.hasait.eclipse.ccg.parser.ICcgParser;
import de.hasait.eclipse.ccg.parser.ICcgParserLookup;
import de.hasait.eclipse.ccg.parser.ICcgRoot;
import de.hasait.eclipse.ccg.parser.ICcgTreeChild;
import de.hasait.eclipse.ccg.util.OidGenerator;
import de.hasait.eclipse.ccg.util.ResourceUtil;
import de.hasait.eclipse.ccg.util.Util;
import de.hasait.eclipse.ccg.util.XmlUtil;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public class CcgBuilder extends IncrementalProjectBuilder {
	/**
	 * ID of this builder.
	 */
	public static final String BUILDER_ID = "de.hasait.eclipse.ccg.builder";

	private static final String MARKER_TYPE = "de.hasait.eclipse.ccg.problem";

	/**
	 * ID of {@link ICcgParser} extension point.
	 */
	public static final String PARSERS_EXTENSION_POINT_ID = "de.hasait.eclipse.ccg.parsers";

	private final ICcgParserLookup _parserLookup = new CcgParserLookupEp(PARSERS_EXTENSION_POINT_ID);

	/**
	 * ID of {@link ICcgGenerator} extension point.
	 */
	public static final String GENERATORS_EXTENSION_POINT_ID = "de.hasait.eclipse.ccg.generators";

	private final ICcgGeneratorLookup _generatorLookup = new CcgGeneratorLookupEp(GENERATORS_EXTENSION_POINT_ID);

	private final Map _context = new HashMap();

	private final IResourceDeltaVisitor _resourceDeltaVisitor = new IResourceDeltaVisitor() {
		public boolean visit(final IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				applyGenerators(resource);
				break;
			case IResourceDelta.REMOVED:
				break;
			case IResourceDelta.CHANGED:
				applyGenerators(resource);
				break;
			}
			return true;
		}
	};

	private final IResourceVisitor _resourceVisitor = new IResourceVisitor() {
		public boolean visit(final IResource resource) {
			applyGenerators(resource);
			return true;
		}
	};

	protected IProject[] build(final int kind, final Map args, final IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild();
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild();
			} else {
				incrementalBuild(delta);
			}
		}
		return null;
	}

	protected void fullBuild() throws CoreException {
		getProject().accept(_resourceVisitor);
	}

	protected void incrementalBuild(final IResourceDelta delta) throws CoreException {
		delta.accept(_resourceDeltaVisitor);
	}

	private void applyGenerators(final IResource resource) {
		if (resource instanceof IFile) {
			IFile file = (IFile) resource;
			ICcgParser parser = _parserLookup.findParser(file.getFileExtension());
			if (parser != null) {
				try {
					deleteMarkers(file);
					String source = ResourceUtil.readFile(file);
					String newSource = executeGenerators(parser, source, file);
					if (!Util.equals(source, newSource)) {
						ResourceUtil.writeFile(file, newSource);
					}
				} catch (Exception e) {
					addMarker(file, e, -1, IMarker.SEVERITY_ERROR);
				}
			}
		}
	}

	private String executeGenerators(final ICcgParser parser, final String source, final IFile file) {
		ICcgRoot root;
		try {
			root = parser.parse(source);
		} catch (Exception e) {
			addMarker(file, e, -1, IMarker.SEVERITY_ERROR);
			return source;
		}
		//
		if (!executeGenerators(root, file)) {
			return source;
		}
		//
		return root.getSource();
	}

	private boolean executeGenerators(final ICcgRoot root, final IFile file) {
		_context.clear();
		int index = 0;
		while (index < root.childNodesSize()) {
			ICcgTreeChild child = root.getChildNode(index);
			if (child instanceof ICcgComment) {
				ICcgComment blockStartComment = (ICcgComment) child;
				String command = blockStartComment.getCommand();
				if (command != null) {
					String block;
					try {
						Element element = XmlUtil.buildW3cElementFromString(command);
						ICcgBlockGenerator generator = _generatorLookup.findBlockGenerator(element.getTagName());
						if (generator == null) {
							throw new IllegalArgumentException("unknown generator tag: " + element.getTagName());
						}
						block = generator.generateBlock(element, _generatorLookup, _context, blockStartComment, file);
					} catch (Exception e) {
						addMarker(file, e, -1, IMarker.SEVERITY_ERROR);
						return false;
					}
					String blockId = blockStartComment.getBlockStart();
					ICcgComment blockEndComment = null;
					if (blockId != null) {
						int a = 1;
						while (index + a < root.childNodesSize() && blockEndComment == null) {
							child = root.getChildNode(index + a);
							if (child instanceof ICcgComment && Util.equals(((ICcgComment) child).getBlockEnd(), blockId)) {
								blockEndComment = (ICcgComment) child;
							} else {
								root.removeChildNode(index + a);
							}
						}
					}
					if (blockId == null) {
						blockId = OidGenerator.getInstance().getOid();
					}
					ICcgNonComment blockNonComment = root.createNonComment();
					root.insertChildNode(index + 1, blockNonComment);
					if (blockEndComment == null) {
						blockEndComment = root.createComment();
						root.insertChildNode(index + 2, blockEndComment);
					}
					blockStartComment.setBlockStart(blockId);
					blockNonComment.setSource(block);
					blockEndComment.setBlockEnd(blockId);
				}
			}
			index++;
		}
		return true;
	}

	private void addMarker(IFile file, Exception exception, int lineNumber, int severity) {
		StringWriter messageWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(messageWriter);
		if (exception != null) {
			printWriter.println(exception.getMessage());
			exception.printStackTrace(printWriter);
		} else {
			printWriter.println("Exception is null");
		}
		addMarker(file, messageWriter.getBuffer().toString(), lineNumber, severity);
	}

	private void addMarker(IFile file, String message, int lineNumber, int severity) {
		try {
			IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber < 1 ? 1 : lineNumber);
		} catch (CoreException e) {
			// ignore
		}
	}

	private void deleteMarkers(IFile file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (CoreException e) {
			// ignore
		}
	}
}