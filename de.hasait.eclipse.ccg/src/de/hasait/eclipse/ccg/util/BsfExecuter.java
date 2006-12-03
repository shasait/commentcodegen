/*
 * $Id: BsfExecuter.java,v 1.1 2006-12-03 01:06:43 concentus Exp $
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
package de.hasait.eclipse.ccg.util;

import java.io.IOException;
import java.util.Map;

import org.apache.bsf.BSFException;
import org.apache.bsf.BSFManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.common.bsf.BsfExceptionUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class BsfExecuter {
	private final String _script;

	private final String _scriptName;

	private final String _scriptLanguage;

	private final IProgressMonitor _monitor;

	private final BSFManager _manager;

	public BsfExecuter(final XElement configElement, final XFile sourceFile, final Map sourceFileContext,
	      final ICcgGeneratorLookup generatorLookup, final IProgressMonitor monitor) throws IOException, CoreException,
	      BSFException {
		super();
		String scriptFilePathS = configElement.getRequiredAttribute("file");
		XFile scriptFile = sourceFile.getFile(scriptFilePathS);
		if (!scriptFile.exists()) {
			throw new IllegalArgumentException("Script file does not exist: " + scriptFile);
		}
		_script = scriptFile.read();
		_scriptName = scriptFile.getLocation().toOSString();
		_scriptLanguage = BSFManager.getLangFromFilename(_scriptName);
		if (_scriptLanguage == null) {
			throw new IllegalArgumentException("Unknown scripting language for: " + scriptFile);
		}
		_monitor = monitor;
		_manager = new BSFManager();
		_manager.declareBean("configElement", configElement, XElement.class);
		_manager.declareBean("sourceFile", sourceFile, XFile.class);
		_manager.declareBean("sourceContext", sourceFileContext, Map.class);
		_manager.declareBean("generatorLookup", generatorLookup, ICcgGeneratorLookup.class);
		_manager.declareBean("scriptFile", scriptFile, XFile.class);
		_manager.declareBean("monitor", monitor, IProgressMonitor.class);
	}

	/**
	 * @see org.apache.bsf.BSFManager#declareBean(java.lang.String, java.lang.Object, java.lang.Class)
	 */
	public void declareBean(final String name, final Object object, final Class type) throws BSFException {
		_manager.declareBean(name, object, type);
	}

	public void execute() throws Exception {
		try {
			_manager.exec(_scriptLanguage, _scriptName, 0, 0, _script);
		} catch (Exception e) {
			throw BsfExceptionUtil.handleException(e);
		}
	}
}
