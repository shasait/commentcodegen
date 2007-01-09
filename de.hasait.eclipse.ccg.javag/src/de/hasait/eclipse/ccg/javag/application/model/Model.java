/*
 * $Id: Model.java,v 1.5 2007-01-09 17:05:18 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.model;

import de.hasait.eclipse.ccg.javag.application.AbstractCuContainer;
import de.hasait.eclipse.ccg.javag.application.Application;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.5 $
 * @since 13.12.2006
 */
public class Model extends AbstractCuContainer {
	public Model(final Application pApplication, final XElement pConfigElement) {
		super(pApplication, pConfigElement, "model");

		XElement[] vClassElements = pConfigElement.getChildElements("class");
		for (int vClassElementsI = 0; vClassElementsI < vClassElements.length; vClassElementsI++) {
			XElement vClassElement = vClassElements[vClassElementsI];
			AClass vClass = new AClass(this, vClassElement);
			addCompilationUnit(vClass);
		}

		XElement[] vInterfaceElements = pConfigElement.getChildElements("interface");
		for (int vInterfaceElementsI = 0; vInterfaceElementsI < vInterfaceElements.length; vInterfaceElementsI++) {
			XElement vInterfaceElement = vInterfaceElements[vInterfaceElementsI];
			AInterface vInterface = new AInterface(this, vInterfaceElement);
			addCompilationUnit(vInterface);
		}
	}
}
