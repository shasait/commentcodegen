/*
 * $Id: BshExecuter.java,v 1.1 2006-12-10 13:45:11 concentus Exp $
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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import bsh.EvalError;
import bsh.Interpreter;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class BshExecuter {
	private final String _script;

	private final String _scriptName;

	private final IProgressMonitor _monitor;

	private final Interpreter _interpreter;

	public BshExecuter(final XElement configElement, final XFile sourceFile, final Map sourceFileContext,
	      final ICcgGeneratorLookup generatorLookup, final IProgressMonitor monitor) throws IOException, CoreException,
	      EvalError {
		super();
		String scriptFilePathS = configElement.getRequiredAttribute("file");
		XFile scriptFile = sourceFile.getFile(scriptFilePathS);
		if (!scriptFile.exists()) {
			throw new IllegalArgumentException("Script file does not exist: " + scriptFile);
		}
		_script = scriptFile.read();
		_scriptName = scriptFile.getLocation().toOSString();
		_monitor = monitor;
		_interpreter = new Interpreter();
		_interpreter.setClassLoader(getClass().getClassLoader());
		_interpreter.set("configElement", configElement);
		_interpreter.set("sourceFile", sourceFile);
		_interpreter.set("sourceContext", sourceFileContext);
		_interpreter.set("generatorLookup", generatorLookup);
		_interpreter.set("scriptFile", scriptFile);
		_interpreter.set("monitor", monitor);
	}

	/**
	 * @see Interpreter#set(String, Object)
	 */
	public void set(final String name, final Object object) throws EvalError {
		_interpreter.set(name, object);
	}

	public void execute() throws Exception {
		_interpreter.eval(_script);
	}
}
