/*
 * $Id: BshExecuter.java,v 1.2 2007-06-22 14:16:43 concentus Exp $
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

import bsh.Interpreter;
import de.hasait.eclipse.common.resource.XFile;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class BshExecuter implements IScriptExecuter {
	private String _script;

	private Interpreter _manager;

	public void init(final XFile scriptFile) throws Exception {
		if (!scriptFile.exists()) {
			throw new IllegalArgumentException("Script file does not exist: " + scriptFile);
		}
		_script = scriptFile.read();
		_manager = new Interpreter();
		_manager.setClassLoader(getClass().getClassLoader());
		declareBean("scriptFile", scriptFile, XFile.class);
	}

	public void declareBean(final String name, final Object object, final Class type) throws Exception {
		_manager.set(name, object);
	}

	public void execute() throws Exception {
		_manager.eval(_script);
	}
}
