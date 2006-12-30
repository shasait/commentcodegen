/*
 * $Id: CrBuilder.java,v 1.2 2006-12-30 18:29:29 concentus Exp $
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
package de.hasait.eclipse.charreplacer.builder;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
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

import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFile;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public class CrBuilder extends IncrementalProjectBuilder {
	public static final String BUILDER_ID = "de.hasait.eclipse.charreplacer.crBuilder";

	private static final String MARKER_TYPE = "de.hasait.eclipse.charreplacer.crProblem";

	private final IResourceDeltaVisitor _resourceDeltaVisitor = new IResourceDeltaVisitor() {
		public boolean visit(final IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				replaceCharacters(resource);
				break;
			case IResourceDelta.REMOVED:
				break;
			case IResourceDelta.CHANGED:
				replaceCharacters(resource);
				break;
			}
			return true;
		}
	};

	private final IResourceVisitor _resourceVisitor = new IResourceVisitor() {
		public boolean visit(final IResource resource) throws CoreException {
			replaceCharacters(resource);
			return true;
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int, java.util.Map,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(final int kind, final Map args, final IProgressMonitor monitor) throws CoreException {
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

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(_resourceVisitor);
		} catch (CoreException e) {
			// ignore
		}
	}

	protected void incrementalBuild(final IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		delta.accept(_resourceDeltaVisitor);
	}

	private static final String SPLIT = "===";

	private static class Config {
		public final String[] _extensions;

		public final Map _replacements;

		private Config(String[] extensions, Map replacements) {
			_extensions = new String[extensions.length];
			System.arraycopy(extensions, 0, _extensions, 0, extensions.length);
			_replacements = new HashMap(replacements);
		}

		public static Config parse(String content) throws Exception {
			if (content == null) {
				return null;
			}
			BufferedReader contentReader = new BufferedReader(new StringReader(content));
			String line = contentReader.readLine();
			String[] extensions = line.split(",");
			Map replacements = new HashMap();
			int indexOfSplit;
			String key;
			String value;
			while ((line = contentReader.readLine()) != null) {
				indexOfSplit = line.indexOf(SPLIT);
				key = line.substring(0, indexOfSplit);
				value = line.substring(indexOfSplit + SPLIT.length());
				replacements.put(key, value);
			}
			return new Config(extensions, replacements);
		}

		public String toString() {
			return "extensions=" + Arrays.asList(_extensions) + " replacements=" + _replacements + " "
			      + _replacements.keySet() + " " + _replacements.values();
		}
	}

	private Config _config = null;

	private void replaceCharacters(final IResource resource) throws CoreException {
		if (resource instanceof IFile) {
			XFile file = new XFile((IFile) resource);
			file.deleteMarkers(MARKER_TYPE);
			try {
				XFile configFile = file.getProject().getFile("charreplacer.config");
				if (file.equals(configFile)) {
					_config = null;
				} else {
					if (_config == null) {
						if (configFile.exists()) {
							configFile.deleteMarkers(MARKER_TYPE);
							try {
								_config = Config.parse(configFile.read());
							} catch (Exception e) {
								configFile.createMarker(MARKER_TYPE, IMarker.SEVERITY_ERROR, "parse", -1);
							}
						} else {
							System.out.println("configfile not found");
						}
					}
					System.out.println("config=" + _config);
					if (_config != null) {
						if (StringUtil.equalsAny(file.getFileExtension(), _config._extensions)) {
							String fileContent = file.read();
							fileContent = StringUtil.replaceAllRegex(fileContent, _config._replacements);
							file.write(fileContent, null, null);
						}
					}
				}
			} catch (Exception e) {
				file.createMarker(MARKER_TYPE, IMarker.SEVERITY_ERROR, "general", -1);
			}
		}
	}
}
