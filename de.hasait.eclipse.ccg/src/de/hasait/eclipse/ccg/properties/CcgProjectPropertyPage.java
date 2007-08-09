/*
 * $Id: CcgProjectPropertyPage.java,v 1.3 2007-08-09 10:27:17 concentus Exp $
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

package de.hasait.eclipse.ccg.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 * @since 03.12.2006
 */
public class CcgProjectPropertyPage extends PropertyPage {
	public static final String PAGE_ID = "de.hasait.eclipse.ccg.properties.ccgProjectPropertyPage";

	private CcgProjectConfiguration _configuration;

	private final List _fieldEditors = new ArrayList();

	/**
	 * Constructor.
	 */
	public CcgProjectPropertyPage() {
		super();
	}

	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(final Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);
		GridData compositeGridData = new GridData();
		compositeGridData.verticalAlignment = GridData.FILL;
		compositeGridData.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(compositeGridData);

		_configuration = CcgProjectConfiguration.getProjectConfiguration((IProject) getElement());
		setPreferenceStore(_configuration.getPreferenceStore());

		addFieldEditor(_configuration.createOutputFolderPathFieldEditor(composite));
		addFieldEditor(_configuration.createSourceFolderPathsFieldEditor(composite));
		addFieldEditor(_configuration.createGeneratorFolderPathsFieldEditor(composite));

		return composite;
	}

	protected final void addFieldEditor(final FieldEditor fieldEditor) {
		_fieldEditors.add(fieldEditor);
		fieldEditor.setPage(this);
		fieldEditor.setPreferenceStore(getPreferenceStore());
		fieldEditor.load();
	}

	protected void performDefaults() {
		for (Iterator fieldEditorsI = _fieldEditors.iterator(); fieldEditorsI.hasNext();) {
			FieldEditor fieldEditor = (FieldEditor) fieldEditorsI.next();
			fieldEditor.loadDefault();
		}
		super.performDefaults();
	}

	public boolean performOk() {
		for (Iterator fieldEditorsI = _fieldEditors.iterator(); fieldEditorsI.hasNext();) {
			FieldEditor fieldEditor = (FieldEditor) fieldEditorsI.next();
			fieldEditor.store();
		}
		try {
			_configuration.save();
		} catch (IOException e) {
			return false;
		}
		return super.performOk();
	}
}
