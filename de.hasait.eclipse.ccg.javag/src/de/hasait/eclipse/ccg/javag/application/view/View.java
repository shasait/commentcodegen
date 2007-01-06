/*
 * $Id: View.java,v 1.2 2007-01-06 00:39:00 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.view;

import de.hasait.eclipse.ccg.javag.application.AbstractCuContainer;
import de.hasait.eclipse.ccg.javag.application.Application;
import de.hasait.eclipse.common.xml.XElement;

/**
 * <dialogs package=""> <dialog name="editKonto"> <parameters> <parameter name="konto" type="Konto" /> </parameters>
 * <view> <field label="ID" property="parameters.konto.id" editable="false" /> <field label="Nummer"
 * property="parameters.konto.nummer" /> <field name="kontoKunde" label="Kunde" property="parameters.konto.kunde" />
 * <button label="OK" /> <button label="Abbrechen" /> </view> <validators> <validator severity="error" description="Kein
 * Kunde gewählt" expression="konto.kunde != null" anchor="kontoKunde" /> </validators> </dialog> <dialog
 * name="selectKonto"> <parameters> <parameter name="selectableKonten" type="Konto[]" /> </parameters> <view>
 * <multiselection name="kontoSelection" label="Konten" property="parameters.selectableKonten"> <column title="Nummer"
 * property="row.nummer" /> </multiselection> </view> <validation> </validation> <results> <result name="selectedKonten"
 * type="Konto" value="view.kontoSelection.selection" /> </results> </dialog> </dialogs>
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 13.12.2006
 */
public class View extends AbstractCuContainer {
	/**
	 * Constructor.
	 */
	public View(final Application pApplication, final XElement pConfigElement) {
		super(pApplication, pConfigElement, "view");

		XElement[] vDialogElements = pConfigElement.getChildElements("dialog");
		for (int vDialogElementsI = 0; vDialogElementsI < vDialogElements.length; vDialogElementsI++) {
			XElement vDialogElement = vDialogElements[vDialogElementsI];
			Dialog vDialog = new Dialog(this, vDialogElement);
			addCompilationUnit(vDialog);
		}
	}
}
