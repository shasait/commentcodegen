/*
 * $Id: Model.java,v 1.3 2007-01-01 22:11:24 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.model;

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
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 * @since 13.12.2006
 */
public class Model {
	private final Application _application;

	private final String _name;

	private final String _package;

	private final XFolder _targetFolder;

	private final List _beans = new ArrayList();

	private final Map _beansByName = new HashMap();

	/**
	 * Constructor.
	 */
	public Model(final Application pApplication, final XElement pConfigElement) {
		super();

		_application = pApplication;

		_name = pConfigElement.getRequiredAttribute("name");

		_package = StringUtil.merge(new String[] { _application.getPackage(), "model", _name }, ".");
		String vPackagePath = StringUtil.replace(_package, ".", "/");
		_targetFolder = _application.getTargetBaseFolder().getFolder(vPackagePath);

		XElement[] vBeanElements = pConfigElement.getChildElements("bean");
		for (int vBeanElementsI = 0; vBeanElementsI < vBeanElements.length; vBeanElementsI++) {
			XElement vBeanElement = vBeanElements[vBeanElementsI];
			Bean vBean = new Bean(this, vBeanElement);
			_beans.add(vBean);
			_beansByName.put(vBean.getName(), vBean);
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

	public final Iterator beanIterator() {
		return _beans.iterator();
	}

	public final Bean findBean(final String pName) {
		if (pName.indexOf('.') >= 0) {
			return getApplication().findBean(pName);
		}
		return (Bean) _beansByName.get(pName);
	}

	public final void resolve(final IProgressMonitor pMonitor) {
		for (Iterator beanI = beanIterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			bean.resolve(pMonitor);
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		for (Iterator beanI = beanIterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			bean.validate(pMonitor);
		}
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write Model " + getPackage());
		for (Iterator beanI = beanIterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			bean.write(pMonitor);
		}
	}
}
