/*
 * $Id: MFieldDeclaration.java,v 1.1 2007-01-01 22:11:23 concentus Exp $
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
public class MFieldDeclaration {
	private MVisibility _visibility;

	private boolean _final;

	private MType _type;

	private String _name;

	public MFieldDeclaration(MVisibility pVisibility, boolean pFinal, MType pType, String pName) {
		super();
		_visibility = pVisibility;
		_final = pFinal;
		_type = pType;
		_name = pName;
	}

	/**
	 * @return the visibility
	 */
	public final MVisibility getVisibility() {
		return _visibility;
	}

	/**
	 * @param pVisibility
	 *           the visibility to set
	 */
	public final void setVisibility(MVisibility pVisibility) {
		_visibility = pVisibility;
	}

	/**
	 * @return the final
	 */
	public final boolean isFinal() {
		return _final;
	}

	/**
	 * @param pFinal
	 *           the final to set
	 */
	public final void setFinal(boolean pFinal) {
		_final = pFinal;
	}

	/**
	 * @return the type
	 */
	public final MType getType() {
		return _type;
	}

	/**
	 * @param pType
	 *           the type to set
	 */
	public final void setType(MType pType) {
		_type = pType;
	}

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
