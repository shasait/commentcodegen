/*
 * $Id: StringListFieldEditor.java,v 1.1 2006-12-03 21:43:03 concentus Exp $
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

package de.hasait.eclipse.common.fieldeditor;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 03.12.2006
 */
public class StringListFieldEditor extends FieldEditor {
	private static final String DEFAULT_ADD_LABEL = "Add";

	private static final String DEFAULT_REMOVE_LABEL = "Remove selection";

	private static final String DEFAULT_SEPERATOR = ";";

	private static final int VERTICAL_DIALOG_UNITS_PER_CHAR = 8;

	private static final int HORIZONTAL_DIALOG_UNITS_PER_CHAR = 4;

	private static final int LIST_HEIGHT_IN_CHARS = 10;

	private static final int LIST_HEIGHT_IN_DLUS = LIST_HEIGHT_IN_CHARS * VERTICAL_DIALOG_UNITS_PER_CHAR;

	// The top-level control for the field editor.
	private Composite top;

	// The list of tags.
	private List list;

	// The text field for inputting new tags.
	private Text text;

	// The button for adding the contents of
	// the text field to the list.
	private Button add;

	// The button for removing the currently-selected list item.
	private Button remove;

	// The string used to seperate list items
	// in a single String representation.
	private String seperator = DEFAULT_SEPERATOR;

	public StringListFieldEditor(String name, String labelText, Composite parent) {
		super(name, labelText, parent);
	}

	public StringListFieldEditor(String name, String labelText, String addButtonText, String removeButtonText,
	      Composite parent) {
		super(name, labelText, parent);
		setAddButtonText(addButtonText);
		setRemoveButtonText(removeButtonText);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#adjustForNumColumns(int)
	 */
	protected void adjustForNumColumns(int numColumns) {
		((GridData) top.getLayoutData()).horizontalSpan = numColumns;
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#doFillIntoGrid (Composite, int)
	 */
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		top = parent;

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns;
		top.setLayoutData(gd);

		Label label = getLabelControl(top);
		GridData labelData = new GridData();
		labelData.verticalAlignment = SWT.BEGINNING;
		labelData.verticalIndent = 2;
		label.setLayoutData(labelData);

		// Create a composite for the add and remove
		// buttons and the input text field.
		Composite c = new Composite(top, SWT.NONE);
		GridData cData = new GridData(GridData.FILL_HORIZONTAL);
		cData.horizontalSpan = numColumns - 1;
		c.setLayoutData(cData);
		GridLayout cLayout = new GridLayout();
		cLayout.numColumns = 2;
		cLayout.marginHeight = 0;
		cLayout.marginWidth = 0;
		c.setLayout(cLayout);

		text = new Text(c, SWT.BORDER);
		GridData textData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(textData);

		add = new Button(c, SWT.NONE);
		add.setText(DEFAULT_ADD_LABEL);
		add.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				add();
			}
		});
		GridData addData = new GridData();
		add.setLayoutData(addData);

		list = new List(c, SWT.BORDER);
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectionChanged();
			}
		});
		GridData listData = new GridData(GridData.FILL_HORIZONTAL);
		listData.horizontalSpan = 2;
		listData.heightHint = convertVerticalDLUsToPixels(list, LIST_HEIGHT_IN_DLUS);
		list.setLayoutData(listData);

		remove = new Button(c, SWT.NONE);
		remove.setEnabled(false);
		remove.setText(DEFAULT_REMOVE_LABEL);
		remove.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				list.remove(list.getSelectionIndex());
				selectionChanged();
			}
		});
		GridData removeData = new GridData();
		removeData.horizontalSpan = 2;
		remove.setLayoutData(removeData);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#doLoad()
	 */
	protected void doLoad() {
		String items = getPreferenceStore().getString(getPreferenceName());
		setList(items);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#doLoadDefault()
	 */
	protected void doLoadDefault() {
		String items = getPreferenceStore().getDefaultString(getPreferenceName());
		setList(items);
	}

	// Parses the string into seperate list items and adds them to the list.
	private void setList(String items) {
		String[] itemArray = parseString(items);
		list.setItems(itemArray);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#doStore()
	 */
	protected void doStore() {
		String s = createListString(list.getItems());
		if (s != null)
			getPreferenceStore().setValue(getPreferenceName(), s);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#getNumberOfControls()
	 */
	public int getNumberOfControls() {
		return 2;
	}

	// Adds the string in the text field to the list.
	private void add() {
		String tag = text.getText();
		if (tag != null && tag.length() > 0)
			list.add(tag);
		text.setText("");
	}

	/**
	 * Sets the label for the button that adds the contents of the text field to the list.
	 */
	public void setAddButtonText(String text) {
		add.setText(text);
	}

	/**
	 * Sets the label for the button that removes the selected item from the list.
	 */
	public void setRemoveButtonText(String text) {
		remove.setText(text);
	}

	/**
	 * Sets the string that seperates items in the list when the list is stored as a single String in the preference
	 * store.
	 */
	public void setSeperator(String seperator) {
		this.seperator = seperator;
	}

	/**
	 * Creates the single String representation of the list that is stored in the preference store.
	 */
	private String createListString(String[] items) {
		StringBuffer path = new StringBuffer("");//$NON-NLS-1$

		for (int i = 0; i < items.length; i++) {
			path.append(items[i]);
			path.append(seperator);
		}
		return path.toString();
	}

	/**
	 * Parses the single String representation of the list into an array of list items.
	 */
	private String[] parseString(String stringList) {
		StringTokenizer st = new StringTokenizer(stringList, seperator); //$NON-NLS-1$
		ArrayList v = new ArrayList();
		while (st.hasMoreElements()) {
			v.add(st.nextElement());
		}
		return (String[]) v.toArray(new String[v.size()]);
	}

	// Sets the enablement of the remove button depending
	// on the selection in the list.
	private void selectionChanged() {
		int index = list.getSelectionIndex();
		remove.setEnabled(index >= 0);
	}
}
