/*
 * $Id: DepSearchPreferenceInitializer.java,v 1.1 2007-01-02 13:56:25 concentus Exp $
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

package de.hasait.eclipse.depsearch.properties;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.widgets.Composite;

import de.hasait.eclipse.common.fieldeditor.StringListFieldEditor;
import de.hasait.eclipse.depsearch.DepSearchPlugin;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 02.01.2007
 */
public class DepSearchPreferenceInitializer extends AbstractPreferenceInitializer {
	public static final String FILE_EXTENSIONS_FULL_TITLE = "&Full search file extensions:";

	public static final String FILE_EXTENSIONS_FULL_KEY = "fullfileexts";

	public static final String FILE_EXTENSIONS_FULL_DEFAULT_VALUE = "xml;properties";

	public void initializeDefaultPreferences() {
		IEclipsePreferences preferences = new DefaultScope().getNode(DepSearchPlugin.PLUGIN_ID);
		preferences.put(FILE_EXTENSIONS_FULL_KEY, FILE_EXTENSIONS_FULL_DEFAULT_VALUE);
	}

	public static String[] getFileExtensionsFull() {
		return new InstanceScope().getNode(DepSearchPlugin.PLUGIN_ID).get(FILE_EXTENSIONS_FULL_KEY,
		      FILE_EXTENSIONS_FULL_DEFAULT_VALUE).split(";");
	}

	public static FieldEditor getFileExtensionsFullFieldEditor(Composite pParent) {
		return new StringListFieldEditor(FILE_EXTENSIONS_FULL_KEY, FILE_EXTENSIONS_FULL_TITLE, pParent);
	}
}
