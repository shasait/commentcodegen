/*
 * $Id: AbstractCompilationUnit.java,v 1.2 2007-01-09 17:05:18 concentus Exp $
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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 05.01.2007
 */
public abstract class AbstractCompilationUnit {
	private static final String USERBLOCK_START = "// @ccg.userblock.start ";

	private static final String USERBLOCK_END = "// @ccg.userblock.end";

	private final AbstractCuContainer _cuContainer;

	private final String _namePrefix;

	private final String _nameSuffix;

	private final String _name;

	private final String _description;

	private final XFile _targetFile;

	/**
	 * Constructor.
	 * 
	 * @param pNamePrefix
	 *           TODO
	 */
	public AbstractCompilationUnit(final AbstractCuContainer pCuContainer, final XElement pConfigElement,
	      final String pNamePrefix, final String pNameSuffix) {
		super();

		_cuContainer = pCuContainer;
		_namePrefix = pNamePrefix;
		_nameSuffix = pNameSuffix;

		_name = buildName(pConfigElement.getRequiredAttribute("name"));
		_description = pConfigElement.getAttribute("description");

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

	public void resolve(final IProgressMonitor pMonitor) {
		// nop
	}

	public void validate(final IProgressMonitor pMonitor) {
		// nop
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write " + getName());
		Map vUserBlockByName = new HashMap();
		if (getTargetFile().exists()) {
			String vTargetFileContent = getTargetFile().read();
			String[] vUserBlocks = StringUtil.getBlocks(USERBLOCK_START, USERBLOCK_END, vTargetFileContent);
			for (int vUserBlocksI = 0; vUserBlocksI < vUserBlocks.length; vUserBlocksI++) {
				String vUserBlock = vUserBlocks[vUserBlocksI];
				String vUserBlockName = StringUtil.firstCharacters(vUserBlock);
				vUserBlockByName.put(vUserBlockName, vUserBlock.substring(vUserBlockName.length()).trim());
			}
		}
		ContentBuffer vContent = new ContentBuffer();
		vContent.p("package " + getCuContainer().getPackage() + ";");
		vContent.p();
		vContent.pi("/**", " * ");
		if (getDescription() != null) {
			vContent.p(getDescription());
			vContent.p();
		}
		writeAdditionalCuComment(vContent, pMonitor);
		vContent.p("@author CCG " + getCuContainer().getApplication().getSourceFile().getFullPath().toString());
		vContent.pu(" */");
		writeCompilationUnits(vContent, vUserBlockByName, pMonitor);
		getTargetFile().write(vContent.getContent(), Boolean.TRUE, pMonitor);
	}

	protected void writeAdditionalCuComment(final ContentBuffer pContent, final IProgressMonitor pMonitor) {
		// nop
	}

	protected abstract void writeCompilationUnits(final ContentBuffer pContent, final Map pUserBlockByName,
	      final IProgressMonitor pMonitor);

	protected final void writeUserContent(final ContentBuffer pContent, final Map pUserBlockByName,
	      final String pBlockName) {
		pContent.a(USERBLOCK_START).p(pBlockName);
		String vUserBlock = (String) pUserBlockByName.get(pBlockName);
		if (vUserBlock != null) {
			pContent.p(vUserBlock);
		}
		pContent.p(USERBLOCK_END);
	}
}
