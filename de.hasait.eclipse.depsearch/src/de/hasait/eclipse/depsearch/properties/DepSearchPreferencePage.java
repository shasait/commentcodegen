/*
 * $Id: DepSearchPreferencePage.java,v 1.1 2007-01-02 13:56:25 concentus Exp $
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

package de.hasait.eclipse.depsearch.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PropertyPage;

import de.hasait.eclipse.depsearch.DepSearchPlugin;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 03.12.2006
 */
public class DepSearchPreferencePage extends PropertyPage implements IWorkbenchPreferencePage {
	public static final String PAGE_ID = DepSearchPlugin.PLUGIN_ID + ".page";

	private final List _fieldEditors = new ArrayList();

	/**
	 * Constructor.
	 */
	public DepSearchPreferencePage() {
		super();
	}

	public void init(IWorkbench pWorkbench) {
		// nop
	}

	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);
		GridData compositeGridData = new GridData();
		compositeGridData.verticalAlignment = GridData.FILL;
		compositeGridData.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(compositeGridData);

		setPreferenceStore(DepSearchPlugin.getDefault().getPreferenceStore());
		addFieldEditor(DepSearchPreferenceInitializer.getFileExtensionsFullFieldEditor(composite));

		return composite;
	}

	protected final void addFieldEditor(FieldEditor fieldEditor) {
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
		return super.performOk();
	}
}
