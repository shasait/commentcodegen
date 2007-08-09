/*
 * $Id: CcgProjectConfiguration.java,v 1.2 2007-08-09 10:27:17 concentus Exp $
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

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;

import de.hasait.eclipse.common.fieldeditor.StringListFieldEditor;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 03.12.2006
 */
public final class CcgProjectConfiguration {
	private static final String PREFERENCE_FILENAME = ".ccgpreferences";

	private static final String OUTPUT_FOLDER_PATH_TITLE = "&Outputfolder:";

	private static final String OUTPUT_FOLDER_PATH_KEY = "outputFolder";

	private static final String OUTPUT_FOLDER_PATH_DEFAULT_VALUE = "/ccgout";

	private static final String SOURCE_FOLDER_PATHS_TITLE = "&Sourcefolders:";

	private static final String SOURCE_FOLDER_PATHS_KEY = "sourceFolders";

	private static final String SOURCE_FOLDER_PATHS_DEFAULT_VALUE = "/ccg";

	private static final String GENERATOR_FOLDER_PATHS_TITLE = "&Generatorfolders:";

	private static final String GENERATOR_FOLDER_PATHS_KEY = "generatorFolders";

	private static final String GENERATOR_FOLDER_PATHS_DEFAULT_VALUE = "/ccg";

	private final PreferenceStore _preferenceStore;

	private CcgProjectConfiguration(final String filename) {
		super();
		_preferenceStore = new PreferenceStore(filename);
		_preferenceStore.setDefault(OUTPUT_FOLDER_PATH_KEY, OUTPUT_FOLDER_PATH_DEFAULT_VALUE);
		_preferenceStore.setDefault(SOURCE_FOLDER_PATHS_KEY, SOURCE_FOLDER_PATHS_DEFAULT_VALUE);
		_preferenceStore.setDefault(GENERATOR_FOLDER_PATHS_KEY, GENERATOR_FOLDER_PATHS_DEFAULT_VALUE);
		try {
			_preferenceStore.load();
		} catch (IOException e) {
			// ignore
		}
	}

	public static final CcgProjectConfiguration getProjectConfiguration(final IProject project) {
		String filename = project.getFile(PREFERENCE_FILENAME).getLocation().toOSString();
		return new CcgProjectConfiguration(filename);
	}

	/**
	 * @return the store
	 */
	public IPreferenceStore getPreferenceStore() {
		return _preferenceStore;
	}

	/**
	 * @return the outputFolderPath
	 */
	public String getOutputFolderPath() {
		return _preferenceStore.getString(OUTPUT_FOLDER_PATH_KEY);
	}

	public FieldEditor createOutputFolderPathFieldEditor(final Composite parent) {
		return new StringFieldEditor(OUTPUT_FOLDER_PATH_KEY, OUTPUT_FOLDER_PATH_TITLE, parent);
	}

	/**
	 * @return the sourceFolderPaths
	 */
	public String[] getSourceFolderPaths() {
		return _preferenceStore.getString(SOURCE_FOLDER_PATHS_KEY).split(";");
	}

	public FieldEditor createSourceFolderPathsFieldEditor(final Composite parent) {
		return new StringListFieldEditor(SOURCE_FOLDER_PATHS_KEY, SOURCE_FOLDER_PATHS_TITLE, parent);
	}

	/**
	 * @return the generatorFolderPaths
	 */
	public String[] getGeneratorFolderPaths() {
		return _preferenceStore.getString(GENERATOR_FOLDER_PATHS_KEY).split(";");
	}

	public FieldEditor createGeneratorFolderPathsFieldEditor(final Composite parent) {
		return new StringListFieldEditor(GENERATOR_FOLDER_PATHS_KEY, GENERATOR_FOLDER_PATHS_TITLE, parent);
	}

	/**
	 * @see org.eclipse.jface.preference.PreferenceStore#load()
	 */
	public void load() throws IOException {
		_preferenceStore.load();
	}

	/**
	 * @see org.eclipse.jface.preference.PreferenceStore#save()
	 */
	public void save() throws IOException {
		_preferenceStore.save();
	}
}
