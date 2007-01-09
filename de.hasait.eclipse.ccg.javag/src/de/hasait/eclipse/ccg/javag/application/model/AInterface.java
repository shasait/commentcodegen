/*
 * $Id: AInterface.java,v 1.1 2007-01-09 17:05:18 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.model;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.AbstractCompilationUnit;
import de.hasait.eclipse.ccg.javag.application.AbstractCuContainer;
import de.hasait.eclipse.ccg.javag.lowlevel.MVisibility;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 09.01.2007
 */
public class AInterface extends AbstractCompilationUnit {
	private final String[] _extends;

	private final String _code;

	/**
	 * @param pCuContainer
	 * @param pConfigElement
	 * @param pNameSuffix
	 */
	public AInterface(final AbstractCuContainer pCuContainer, final XElement pConfigElement) {
		super(pCuContainer, pConfigElement, "I", null);
		String vExtends = pConfigElement.getAttribute("extends");
		_extends = vExtends == null ? null : vExtends.split(",");
		_code = pConfigElement.getTextContent();
	}

	/**
	 * @return the extends
	 */
	public final String[] getExtends() {
		return _extends;
	}

	protected void writeCompilationUnits(final ContentBuffer pContent, final Map pUserBlockByName, IProgressMonitor pMonitor) {
		pContent.a(MVisibility.PUBLIC.getId()).a(" ");
		pContent.a("interface ").a(getName()).a(" ");
		String[] vExtends = getExtends();
		if (vExtends != null && vExtends.length > 0) {
			pContent.a("extends ");
			for (int vExtendsI = 0; vExtendsI < vExtends.length; vExtendsI++) {
				if (vExtendsI > 0) {
					pContent.a(", ");
				}
				pContent.a(vExtends[vExtendsI]);
			}
			pContent.a(" ");
		}
		pContent.pi("{");
		writeUserContent(pContent, pUserBlockByName, "InterfaceBegin");
		pContent.p(_code);
		writeUserContent(pContent, pUserBlockByName, "InterfaceEnd");
		pContent.pu("}");
	}
}
