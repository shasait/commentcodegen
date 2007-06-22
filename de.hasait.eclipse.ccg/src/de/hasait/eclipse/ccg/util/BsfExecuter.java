/*
 * $Id: BsfExecuter.java,v 1.3 2007-06-22 14:16:43 concentus Exp $
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

import org.apache.bsf.BSFManager;

import de.hasait.eclipse.common.bsf.BsfExceptionUtil;
import de.hasait.eclipse.common.resource.XFile;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 */
public final class BsfExecuter implements IScriptExecuter {
	private String _script;

	private String _scriptName;

	private String _scriptLanguage;

	private BSFManager _manager;

	public void init(final XFile scriptFile) throws Exception {
		if (!scriptFile.exists()) {
			throw new IllegalArgumentException("Script file does not exist: " + scriptFile);
		}
		_script = scriptFile.read();
		_scriptName = scriptFile.getLocation().toOSString();
		_scriptLanguage = BSFManager.getLangFromFilename(_scriptName);
		if (_scriptLanguage == null) {
			throw new IllegalArgumentException("Unknown scripting language for: " + scriptFile);
		}
		_manager = new BSFManager();
		_manager.setClassLoader(getClass().getClassLoader());
		declareBean("scriptFile", scriptFile, XFile.class);
	}

	public void declareBean(final String name, final Object object, final Class type) throws Exception {
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
