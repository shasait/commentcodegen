/*
 * $Id: IScriptExecuter.java,v 1.1 2007-06-22 14:16:43 concentus Exp $
 * 
 * Copyright 2007 Sebastian Hasait
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

import de.hasait.eclipse.common.resource.XFile;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 22.06.2007
 */
public interface IScriptExecuter {
	/**
	 * Initialize with specified scriptFile and removes all declared variables ({@link #declareBean(String, Object, Class)}).
	 * Must be called prior to {@link #execute()}.
	 * 
	 * @param scriptFile
	 * @throws Exception
	 */
	void init(XFile scriptFile) throws Exception;

	/**
	 * Defines a variable for the script environment.
	 */
	void declareBean(String name, Object object, Class type) throws Exception;

	/**
	 * Executes the script set with {@link #init(XFile)}.
	 */
	void execute() throws Exception;
}
