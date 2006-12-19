/*
 * $Id: MType.java,v 1.1 2006-12-19 15:06:02 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.lowlevel;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 18.12.2006
 */
public abstract class MType {
	private String _name;

	public abstract MMethodDeclaration[] getDeclaredMethods();

	/**
	 * @return the name
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @param pName
	 *           the name to set
	 */
	public final void setName(String pName) {
		_name = pName;
	}
}
