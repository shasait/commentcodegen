/*
 * $Id: CcgBuilder.java,v 1.1 2006-11-08 20:54:50 concentus Exp $
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
import de.hasait.eclipse.ccg.generator.ICcgTagGenerator;
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
 * @version $Revision: 1.1 $
 */
public class CcgBuilder extends IncrementalProjectBuilder {
    public static final String BUILDER_ID = "de.hasait.eclipse.ccg.ccgBuilder";

    private static final String MARKER_TYPE = "de.hasait.eclipse.ccg.ccgProblem";

    public static final String CCG_PARSERS_EXTENSIONPOINT_ID = "de.hasait.eclipse.ccg.ccgParsers";

    private final ICcgParserLookup _ccgParserLookup = new CcgParserLookupEp(
            CCG_PARSERS_EXTENSIONPOINT_ID);

    public static final String CCG_GENERATORS_EXTENSIONPOINT_ID = "de.hasait.eclipse.ccg.ccgGenerators";

    private final ICcgGeneratorLookup _ccgGeneratorLookup = new CcgGeneratorLookupEp(
            CCG_GENERATORS_EXTENSIONPOINT_ID);

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

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
     *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
     */
    protected IProject[] build(final int kind, final Map args,
            final IProgressMonitor monitor) throws CoreException {
        if (kind == FULL_BUILD) {
            fullBuild(monitor);
        } else {
            IResourceDelta delta = getDelta(getProject());
            if (delta == null) {
                fullBuild(monitor);
            } else {
                incrementalBuild(delta, monitor);
            }
        }
        return null;
    }

    protected void fullBuild(final IProgressMonitor monitor)
            throws CoreException {
        try {
            getProject().accept(_resourceVisitor);
        } catch (CoreException e) {
            // ignore
        }
    }

    protected void incrementalBuild(final IResourceDelta delta,
            IProgressMonitor monitor) throws CoreException {
        delta.accept(_resourceDeltaVisitor);
    }

    private void applyGenerators(final IResource resource) {
        if (resource instanceof IFile) {
            IFile file = (IFile) resource;
            ICcgParser ccgParser = _ccgParserLookup.findCcgParser(file
                    .getFileExtension());
            if (ccgParser != null) {
                try {
                    deleteMarkers(file);
                    String source = ResourceUtil.readFile(file);
                    String newSource = applyGenerators(ccgParser, source, file);
                    if (!Util.equals(source, newSource)) {
                        ResourceUtil.writeFile(file, newSource);
                    }
                } catch (Exception e) {
                    addMarker(file, e, -1, IMarker.SEVERITY_ERROR);
                }
            }
        }
    }

    private String applyGenerators(final ICcgParser ccgParser,
            final String source, final IFile file) {
        ICcgRoot ccgRoot;
        try {
            ccgRoot = ccgParser.parse(source);
        } catch (Exception e) {
            addMarker(file, e, -1, IMarker.SEVERITY_ERROR);
            return source;
        }
        //
        if (!applyTransformators(ccgRoot, file)) {
            return source;
        }
        //
        return ccgRoot.getSource();
    }

    private boolean applyTransformators(final ICcgRoot ccgRoot, final IFile file) {
        _context.clear();
        int index = 0;
        ICcgTreeChild child;
        ICcgComment ccgComment;
        String command;
        Element element;
        ICcgTagGenerator ccgGenerator;
        String ccgGeneratorResult;
        String blockId;
        ICcgNonComment ccgNonComment;
        ICcgComment blockEnd;
        while (index < ccgRoot.childNodesSize()) {
            child = ccgRoot.getChildNode(index);
            if (child instanceof ICcgComment) {
                ccgComment = (ICcgComment) child;
                command = ccgComment.getCommand();
                if (command != null) {
                    try {
                        element = XmlUtil.buildW3cElementFromString(command);
                        ccgGenerator = _ccgGeneratorLookup
                                .findGenerator(element.getTagName());
                        if (ccgGenerator == null) {
                            throw new IllegalArgumentException(
                                    "unknown generator tag: "
                                            + element.getTagName());
                        }
                        ccgGeneratorResult = ccgGenerator
                                .generate(element, _ccgGeneratorLookup,
                                        _context, ccgComment, file);
                    } catch (Exception e) {
                        addMarker(file, e, -1, IMarker.SEVERITY_ERROR);
                        return false;
                    }
                    blockId = ccgComment.getBlockStart();
                    ccgNonComment = null;
                    blockEnd = null;
                    if (blockId != null) {
                        int a = 1;
                        while (index + a < ccgRoot.childNodesSize()
                                && blockEnd == null) {
                            child = ccgRoot.getChildNode(index + a);
                            if (child instanceof ICcgComment
                                    && Util.equals(((ICcgComment) child)
                                            .getBlockEnd(), blockId)) {
                                blockEnd = (ICcgComment) child;
                            } else {
                                ccgRoot.removeChildNode(index + a);
                            }
                        }
                    }
                    if (blockId == null) {
                        blockId = OidGenerator.getInstance().getOid();
                    }
                    if (ccgNonComment == null) {
                        ccgNonComment = ccgRoot.createNonComment();
                        ccgRoot.insertChildNode(index + 1, ccgNonComment);
                    }
                    if (blockEnd == null) {
                        blockEnd = ccgRoot.createComment();
                        ccgRoot.insertChildNode(index + 2, blockEnd);
                    }
                    ccgComment.setBlockStart(blockId);
                    ccgNonComment.setSource(ccgGeneratorResult);
                    blockEnd.setBlockEnd(blockId);
                }
            }
            index++;
        }
        return true;
    }

    private void addMarker(IFile file, Exception exception, int lineNumber,
            int severity) {
        StringWriter messageWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(messageWriter);
        if (exception != null) {
            printWriter.println(exception.getMessage());
            exception.printStackTrace(printWriter);
        } else {
            printWriter.println("Exception is null");
        }
        addMarker(file, messageWriter.getBuffer().toString(), lineNumber,
                severity);
    }

    private void addMarker(IFile file, String message, int lineNumber,
            int severity) {
        try {
            IMarker marker = file.createMarker(MARKER_TYPE);
            marker.setAttribute(IMarker.MESSAGE, message);
            marker.setAttribute(IMarker.SEVERITY, severity);
            if (lineNumber < 1) {
                lineNumber = 1;
            }
            marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
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