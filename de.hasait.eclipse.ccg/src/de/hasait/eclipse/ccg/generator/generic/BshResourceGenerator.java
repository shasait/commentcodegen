/*
 * $Id: BshResourceGenerator.java,v 1.3 2007-06-22 14:16:39 concentus Exp $
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

package de.hasait.eclipse.ccg.generator.generic;

import de.hasait.eclipse.ccg.util.BshExecuter;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 * @since 22.06.2007
 */
public final class BshResourceGenerator extends AbstractScriptResourceGenerator {
	/**
	 * 
	 */
	public BshResourceGenerator() {
		super(new BshExecuter());
	}
}
