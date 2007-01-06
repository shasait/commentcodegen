/*
 * $Id: AbstractCuContainer.java,v 1.1 2007-01-06 00:39:05 concentus Exp $
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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 05.01.2007
 */
public class AbstractCuContainer {
	private final Application _application;

	private final String _name;

	private final String _packageInfix;

	private final String _package;

	private final XFolder _targetFolder;

	private final List _compilationUnits = new ArrayList();

	private final Map _compilationUnitsByName = new HashMap();

	/**
	 * Constructor.
	 */
	public AbstractCuContainer(final Application pApplication, final XElement pConfigElement, final String pPackageInfix) {
		super();

		_application = pApplication;
		_packageInfix = pPackageInfix;

		_name = pConfigElement.getRequiredAttribute("name");

		_package = buildPackage(_name);
		String vPackagePath = StringUtil.replace(_package, ".", "/");
		_targetFolder = _application.getTargetBaseFolder().getFolder(vPackagePath);
	}

	protected final void addCompilationUnit(final AbstractCompilationUnit pCompilationUnit) {
		if (_compilationUnitsByName.containsKey(pCompilationUnit.getName())) {
			throw new IllegalArgumentException("duplicate name " + pCompilationUnit.getName());
		}
		_compilationUnits.add(pCompilationUnit);
		_compilationUnitsByName.put(pCompilationUnit.getName(), pCompilationUnit);
	}

	public final Iterator compilationUnitIterator() {
		return _compilationUnits.iterator();
	}

	public final AbstractCompilationUnit findCompilationUnitByName(final String pQualifiedOrSimpleName) {
		if (pQualifiedOrSimpleName.indexOf('.') >= 0) {
			// is qualified name
			return getApplication().findCompilationUnit(pQualifiedOrSimpleName);
		}
		return (AbstractCompilationUnit) _compilationUnitsByName.get(pQualifiedOrSimpleName);
	}

	/**
	 * @return the application
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
	 * @return the packageInfix
	 */
	public final String getPackageInfix() {
		return _packageInfix;
	}

	/**
	 * @return ApplicationPackage + PackageInfix + SimpleName.
	 */
	public final String buildPackage(final String pSimpleName) {
		return StringUtil.merge(new String[] { _application.getPackage(), _packageInfix, pSimpleName }, ".");
	}

	/**
	 * @return the package
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

	public final void resolve(final IProgressMonitor pMonitor) {
		for (Iterator vCompilationUnitI = compilationUnitIterator(); vCompilationUnitI.hasNext();) {
			AbstractCompilationUnit bean = (AbstractCompilationUnit) vCompilationUnitI.next();
			bean.resolve(pMonitor);
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		for (Iterator vCompilationUnitI = compilationUnitIterator(); vCompilationUnitI.hasNext();) {
			AbstractCompilationUnit bean = (AbstractCompilationUnit) vCompilationUnitI.next();
			bean.validate(pMonitor);
		}
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write Model " + getPackage());
		for (Iterator vCompilationUnitI = compilationUnitIterator(); vCompilationUnitI.hasNext();) {
			AbstractCompilationUnit vCompilationUnit = (AbstractCompilationUnit) vCompilationUnitI.next();
			vCompilationUnit.write(pMonitor);
		}
	}
}
