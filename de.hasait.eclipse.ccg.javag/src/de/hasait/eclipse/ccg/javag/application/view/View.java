/*
 * $Id: View.java,v 1.1 2007-01-01 22:11:24 concentus Exp $
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.Application;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFolder;
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
 * @version $Revision: 1.1 $
 * @since 13.12.2006
 */
public class View {
	private final Application _application;

	private final String _name;

	private final String _package;

	private final XFolder _targetFolder;

	private final List _dialogs = new ArrayList();

	private final Map _dialogsByName = new HashMap();

	/**
	 * Constructor.
	 */
	public View(final Application pApplication, final XElement pConfigElement) {
		super();

		_application = pApplication;

		_name = pConfigElement.getRequiredAttribute("name");

		_package = StringUtil.merge(new String[] { _application.getPackage(), "view", _name }, ".");
		String vPackagePath = StringUtil.replace(_package, ".", "/");
		_targetFolder = _application.getTargetBaseFolder().getFolder(vPackagePath);

		XElement[] vDialogElements = pConfigElement.getChildElements("dialog");
		for (int vDialogElementsI = 0; vDialogElementsI < vDialogElements.length; vDialogElementsI++) {
			XElement vDialogElement = vDialogElements[vDialogElementsI];
			Dialog vDialog = new Dialog(this, vDialogElement);
			_dialogs.add(vDialog);
			_dialogsByName.put(vDialog.getName(), vDialog);
		}
	}

	/**
	 * @return The value of property application.
	 */
	public final Application getApplication() {
		return _application;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @return The value of property package.
	 */
	public final String getPackage() {
		return _package;
	}

	/**
	 * @return the targetFolder
	 */
	public final XFolder getTargetFolder() {
		return _targetFolder;
	}

	public final Iterator dialogIterator() {
		return _dialogs.iterator();
	}

	public final Dialog findDialog(final String pName) {
		if (pName.indexOf('.') >= 0) {
			return getApplication().findDialog(pName);
		}
		return (Dialog) _dialogsByName.get(pName);
	}

	public final void resolve(final IProgressMonitor pMonitor) {
		for (Iterator dialogI = dialogIterator(); dialogI.hasNext();) {
			Dialog dialog = (Dialog) dialogI.next();
			dialog.resolve(pMonitor);
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		for (Iterator dialogI = dialogIterator(); dialogI.hasNext();) {
			Dialog dialog = (Dialog) dialogI.next();
			dialog.validate(pMonitor);
		}
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write View " + getPackage());
		for (Iterator dialogI = dialogIterator(); dialogI.hasNext();) {
			Dialog dialog = (Dialog) dialogI.next();
			dialog.write(pMonitor);
		}
	}
}
