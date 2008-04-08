/*
 * $Id: AbstractCompilationUnit.java,v 1.7 2008-04-08 11:19:42 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.util.CodeUtils;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.7 $
 * @since 05.01.2007
 */
public abstract class AbstractCompilationUnit {
	private final AbstractCuContainer _cuContainer;

	private final String _namePrefix;

	private final String _nameSuffix;

	private final String _name;

	private final String _description;

	private final XFile _targetFile;

	private final SortedSet _imports = new TreeSet();

	private final List _attachedCode = new ArrayList();

	/**
	 * Constructor.
	 * 
	 * @param pNamePrefix
	 *           TODO
	 */
	public AbstractCompilationUnit(final AbstractCuContainer pCuContainer, final XElement pConfigElement,
	      final String pNamePrefix, final String pNameSuffix) {
		this(pCuContainer, pNamePrefix, pConfigElement.getRequiredStringAttribute("name"), pNameSuffix, pConfigElement
		      .getStringAttribute("description"));
		XElement[] vImportElements = pConfigElement.getElements("import");
		for (int vImportElementsI = 0; vImportElementsI < vImportElements.length; vImportElementsI++) {
			XElement vImportElement = vImportElements[vImportElementsI];
			String vImportType = vImportElement.getRequiredStringAttribute("type");
			_imports.add(vImportType);
		}
	}

	public AbstractCompilationUnit(final AbstractCuContainer pCuContainer, final String pNamePrefix, final String pName,
	      final String pNameSuffix, final String pDescription) {
		super();

		_cuContainer = pCuContainer;
		_namePrefix = pNamePrefix;
		_nameSuffix = pNameSuffix;

		_name = buildName(pName);
		_description = pDescription;

		_targetFile = _cuContainer.getTargetFolder().getFile(_name + ".java");
	}

	/**
	 * @return the cuContainer
	 */
	public final AbstractCuContainer getCuContainer() {
		return _cuContainer;
	}

	/**
	 * @return the namePrefix
	 */
	public final String getNamePrefix() {
		return _namePrefix;
	}

	/**
	 * @return the nameSuffix
	 */
	public final String getNameSuffix() {
		return _nameSuffix;
	}

	/**
	 * @return Concatination of NamePrefix, pPlainName and NameSuffix.
	 */
	public final String buildName(final String pPlainName) {
		return (_namePrefix == null ? "" : _namePrefix) + pPlainName + (_nameSuffix == null ? "" : _nameSuffix);
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return _name;
	}

	public final String getQualifiedName() {
		return getCuContainer().getPackage() + "." + getName();
	}

	public final String getJavaDocLink() {
		return "{@link " + getQualifiedName() + "}";
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return _description;
	}

	/**
	 * @return the targetFile
	 */
	public final XFile getTargetFile() {
		return _targetFile;
	}

	public final void addImport(final String pType) {
		_imports.add(pType);
	}

	public final void addAttachedCode(final String pCode) {
		_attachedCode.add(pCode);
	}

	public boolean transform(final int pLayer, final IProgressMonitor pMonitor) {
		return false;
	}

	public void validate(final IProgressMonitor pMonitor) {
		// nop
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write " + getName());
		Map vUserBlockContentByName;
		if (getTargetFile().exists()) {
			String vTargetFileContent = getTargetFile().read();
			vUserBlockContentByName = CodeUtils.parseUserBlockContentByBlockName(vTargetFileContent);
		} else {
			vUserBlockContentByName = new HashMap();
		}
		ContentBuffer vContent = new ContentBuffer();
		vContent.p("package " + getCuContainer().getPackage() + ";");
		vContent.p();
		for (Iterator vImportI = _imports.iterator(); vImportI.hasNext();) {
			String vImportType = (String) vImportI.next();
			vContent.p("import " + vImportType + ";");
		}
		vContent.p();
		vContent.pi("/**", " * ");
		if (getDescription() != null) {
			vContent.p(getDescription());
			vContent.p();
		}
		writeAdditionalCuComment(vContent, pMonitor);
		vContent.p("@author CCG " + getCuContainer().getApplication().getSourceFile().getFullPath().toString());
		vContent.up(" */");
		writeTypes(vContent, vUserBlockContentByName, pMonitor);
		getTargetFile().write(vContent.toString(), Boolean.TRUE, pMonitor);
	}

	protected void writeAdditionalCuComment(final ContentBuffer pContent, final IProgressMonitor pMonitor) {
		// nop
	}

	protected abstract void writeTypes(final ContentBuffer pContent, final Map pUserBlockContentByName,
	      final IProgressMonitor pMonitor) throws CoreException;

	protected void writeAttachedCode(final ContentBuffer pContent, final IProgressMonitor pMonitor) {
		for (Iterator vAttachedCodeI = _attachedCode.iterator(); vAttachedCodeI.hasNext();) {
			String vAttachedCode = (String) vAttachedCodeI.next();
			pContent.p(vAttachedCode);
		}
	}
}
