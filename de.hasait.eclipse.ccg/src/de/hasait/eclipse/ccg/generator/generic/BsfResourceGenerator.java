/*
 * $Id: BsfResourceGenerator.java,v 1.3 2006-11-27 22:48:57 concentus Exp $
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
package de.hasait.eclipse.ccg.generator.generic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import org.apache.bsf.BSFException;
import org.apache.bsf.BSFManager;
import org.eclipse.core.resources.IFile;
import org.jruby.RubyException;
import org.jruby.exceptions.RaiseException;

import de.hasait.eclipse.ccg.generator.AbstractCcgResourceGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.common.ResourceUtil;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.XmlUtil.XElement;
import de.hasait.eclipse.common.bsf.ResourceScriptHelper;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 */
public final class BsfResourceGenerator extends AbstractCcgResourceGenerator {
	private static final String DESCRIPTION = "Delegates the generation to a script";

	private static final String[] TAG_NAMES = new String[] { "bsf" };

	/**
	 * Constructor.
	 */
	public BsfResourceGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public void generateResources(XElement element, ICcgGeneratorLookup generatorLookup, Map context, IFile file)
	      throws Exception {
		String scriptFilePathS = element.getRequiredAttribute("file");
		IFile scriptFile = ResourceUtil.getRelativeFile(file, scriptFilePathS);
		if (!scriptFile.exists()) {
			throw new IllegalArgumentException("Script-file does not exist: " + scriptFilePathS);
		}
		String scriptName = scriptFile.getLocation().toOSString();
		String scriptLang = BSFManager.getLangFromFilename(scriptName);
		if (scriptLang == null) {
			throw new IllegalArgumentException("Unknown scripting language for: " + scriptFile);
		}
		String script = ResourceUtil.readFile(scriptFile);
		// run script
		BSFManager manager = new BSFManager();
		//
		manager.declareBean("element", element, XElement.class);
		manager.declareBean("sourceFile", file, IFile.class);
		manager.declareBean("scriptFile", scriptFile, IFile.class);
		manager.declareBean("resources", new ResourceScriptHelper(), ResourceScriptHelper.class);
		//
		try {
			manager.exec(scriptLang, scriptName, 0, 0, script);
		} catch (Exception e) {
			throw handleException(e);
		}
	}

	private Exception handleException(Exception exception) {
		try {
			throw exception;
		} catch (RaiseException re) {
			RubyException rubyException = re.getException();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PrintStream pos = new PrintStream(bos);
			pos.println(StringUtil.toString(rubyException.message));
			rubyException.printBacktrace(pos);
			return new Exception(bos.toString(), re);
		} catch (BSFException e) {
			Throwable t = e.getTargetException();
			if (t instanceof Exception) {
				return handleException((Exception) t);
			}
			return e;
		} catch (Exception e) {
			return e;
		}
	}
}
