/*
 * $Id: CcgBuilder.java,v 1.5 2006-11-16 16:08:44 concentus Exp $
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

import de.hasait.eclipse.ccg.generator.CcgGeneratorLookupEp;
import de.hasait.eclipse.ccg.generator.ICcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.generator.ICcgResourceGenerator;
import de.hasait.eclipse.ccg.parser.CcgParserLookupEp;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.ccg.parser.ICcgNonComment;
import de.hasait.eclipse.ccg.parser.ICcgParser;
import de.hasait.eclipse.ccg.parser.ICcgParserLookup;
import de.hasait.eclipse.ccg.parser.ICcgRoot;
import de.hasait.eclipse.ccg.parser.ICcgTreeChild;
import de.hasait.eclipse.common.OidGenerator;
import de.hasait.eclipse.common.ResourceUtil;
import de.hasait.eclipse.common.Util;
import de.hasait.eclipse.common.XmlUtil;
import de.hasait.eclipse.common.XmlUtil.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.5 $
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

	/**
	 * File extension used for resource generator scripts.
	 */
	public static final String RESOURCE_GENERATOR_FILE_EXTENSION = "ccg";

	/**
	 * File extension used for resource generator scripts.
	 */
	public static final String RESOURCE_GENERATOR_ROOT_TAG_NAME = "ccg";

	private final Map _context = new HashMap();

	private final IResourceDeltaVisitor _resourceDeltaVisitor = new IResourceDeltaVisitor() {
		public boolean visit(final IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				executeGenerators(resource);
				break;
			case IResourceDelta.REMOVED:
				break;
			case IResourceDelta.CHANGED:
				executeGenerators(resource);
				break;
			}
			return true;
		}
	};

	private final IResourceVisitor _resourceVisitor = new IResourceVisitor() {
		public boolean visit(final IResource resource) {
			executeGenerators(resource);
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

	private void executeGenerators(final IResource resource) {
		if (resource instanceof IFile) {
			IFile file = (IFile) resource;
			String fileExtension = file.getFileExtension();
			if (RESOURCE_GENERATOR_FILE_EXTENSION.equals(fileExtension) || _parserLookup.containsParser(fileExtension)) {
				executeGenerators(file, fileExtension);
			}
		}
	}

	private void executeGenerators(final IFile file, final String fileExtension) {
		try {
			deleteMarkers(file);
			String source = ResourceUtil.readFile(file);
			if (RESOURCE_GENERATOR_FILE_EXTENSION.equals(fileExtension)) {
				// our own file-format - execute generators...
				executeResourceGenerators(file, source);
			} else {
				// foreign file - lookup comment-parser...
				ICcgParser parser = _parserLookup.findParser(fileExtension);
				if (parser != null) {
					// ok - found a parser - try to parse...
					ICcgRoot root = parser.parse(source);
					if (root != null) {
						// parsed - execute generators...
						if (executeBlockGenerators(file, root)) {
							ResourceUtil.writeFile(file, root.getSource());
						}
					}
				}
			}
		} catch (Exception e) {
			addMarker(file, e, -1, IMarker.SEVERITY_ERROR);
		}
	}

	private void executeResourceGenerators(final IFile file, final String source) throws Exception {
		XElement element = XmlUtil.buildXElementFromString(source);
		if (RESOURCE_GENERATOR_ROOT_TAG_NAME.equals(element.getTagName())) {
			// contains our tag - continue...
			// create a context to allow data-exchange between generators...
			Map context = new HashMap();
			// each childElement of root represents a generator...
			XElement[] childElements = element.getChildElements();
			for (int childElementsI = 0; childElementsI < childElements.length; childElementsI++) {
				XElement childElement = childElements[childElementsI];
				String childElementTagName = childElement.getTagName();
				ICcgResourceGenerator generator = _generatorLookup.findResourceGenerator(childElementTagName);
				if (generator != null) {
					// found a generator for tagName - execute...
					generator.generateResources(element, _generatorLookup, context, file);
				}
			}
		}
	}

	private boolean executeBlockGenerators(final IFile file, final ICcgRoot root) {
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
						XElement element = XmlUtil.buildXElementFromString(command);
						ICcgBlockGenerator generator = _generatorLookup.findBlockGenerator(element.getTagName());
						if (generator == null) {
							throw new IllegalArgumentException("unknown generator tag: " + element.getTagName());
						}
						block = generator.generateBlock(file, blockStartComment, element, _context, _generatorLookup);
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