/*
 * $Id: MMethodImplementation.java,v 1.1 2007-01-01 22:11:23 concentus Exp $
 * 
 * Copyright 2006 Sebastian Hasait
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

package de.hasait.eclipse.ccg.javag.lowlevel;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 18.12.2006
 */
public class MMethodImplementation {
	private MMethodDeclaration _declaration;

	/**
	 * @return the declaration
	 */
	public final MMethodDeclaration getDeclaration() {
		return _declaration;
	}

	/**
	 * @param pDeclaration
	 *           the declaration to set
	 */
	public final void setDeclaration(MMethodDeclaration pDeclaration) {
		_declaration = pDeclaration;
	}
}
