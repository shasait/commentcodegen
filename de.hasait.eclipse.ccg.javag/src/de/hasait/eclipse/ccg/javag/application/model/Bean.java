/*
 * $Id: Bean.java,v 1.4 2007-01-01 22:11:24 concentus Exp $
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

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.CodeUtils;
import de.hasait.eclipse.ccg.javag.lowlevel.MVisibility;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.4 $
 * @since 13.12.2006
 */
public class Bean {
	private final Model _model;

	private final String _name;

	private final String _description;

	private final boolean _abstract;

	private final String _extends;

	private Bean _extendsBean;

	private final String _propertyChangeSupportName;

	private boolean _propertyChangeSupportNeeded;

	private final XFile _targetFile;

	private final List _properties = new ArrayList();

	private final Map _propertiesByName = new HashMap();

	private final List _derivedBeans = new ArrayList();

	/**
	 * Constructor.
	 */
	public Bean(final Model pModel, final XElement pConfigElement) {
		super();

		_model = pModel;

		_name = pConfigElement.getRequiredAttribute("name");
		_description = pConfigElement.getAttribute("description");
		_abstract = pConfigElement.getAttributeAsBoolean("abstract", false);
		_extends = pConfigElement.getAttribute("extends");

		_propertyChangeSupportName = "_propertyChangeSupport";
		_propertyChangeSupportNeeded = false;
		_targetFile = _model.getTargetFolder().getFile(_name + ".java");

		XElement[] vPropertyElements = pConfigElement.getChildElements("property");
		for (int vPropertyElementsI = 0; vPropertyElementsI < vPropertyElements.length; vPropertyElementsI++) {
			XElement vPropertyElement = vPropertyElements[vPropertyElementsI];
			String vCardinality = vPropertyElement.getAttribute("cardinality");
			AbstractProperty vProperty;
			if (vCardinality == null || vCardinality.equals("1")) {
				vProperty = new SingleProperty(this, vPropertyElement);
			} else if (vCardinality.equals("*")) {
				vProperty = new MultiProperty(this, vPropertyElement);
			} else {
				throw new IllegalArgumentException("cardinality not supported: " + vCardinality);
			}
			_properties.add(vProperty);
			_propertiesByName.put(vProperty.getName(), vProperty);
		}
	}

	/**
	 * @return The value of property model.
	 */
	public final Model getModel() {
		return _model;
	}

	/**
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return _description;
	}

	/**
	 * @return the abstract
	 */
	public final boolean isAbstract() {
		return _abstract;
	}

	/**
	 * @return the extends
	 */
	public final String getExtends() {
		return _extends;
	}

	/**
	 * @return the extendsBean
	 */
	public final Bean getExtendsBean() {
		return _extendsBean;
	}

	/**
	 * @return the propertyChangeSupportName
	 */
	public final String getPropertyChangeSupportName() {
		return _propertyChangeSupportName;
	}

	/**
	 * @return the propertyChangeSupportNeeded
	 */
	public final boolean isPropertyChangeSupportNeeded() {
		return _propertyChangeSupportNeeded;
	}

	/**
	 * Set propertyChangeSupportNeeded to true.
	 */
	public final void setPropertyChangeSupportNeeded() {
		_propertyChangeSupportNeeded = true;
	}

	/**
	 * @return the targetFile
	 */
	public final XFile getTargetFile() {
		return _targetFile;
	}

	/**
	 * @return An {@link java.util.Iterator} for all values of property property.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator propertyIterator() {
		return _properties.iterator();
	}

	/**
	 * @return the derivedBeans
	 */
	public final List getDerivedBeans() {
		return Collections.unmodifiableList(_derivedBeans);
	}

	public final String getFullName() {
		return _model.getPackage() + "." + _name;
	}

	public final String getJavaDocFullName() {
		return "{@link " + getFullName() + "}";
	}

	public final AbstractProperty findProperty(String pName) {
		return (AbstractProperty) _propertiesByName.get(pName);
	}

	public final void resolve(final IProgressMonitor pMonitor) {
		if (_extends != null) {
			_extendsBean = _model.findBean(_extends);
			if (_extendsBean != null) {
				_extendsBean._derivedBeans.add(this);
			}
		}
		for (Iterator propertyI = _properties.iterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.resolve(pMonitor);
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.validate(pMonitor);
		}
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write Bean " + getFullName());
		ContentBuffer content = new ContentBuffer();
		content.p("package " + getModel().getPackage() + ";");
		content.p();
		content.pi("/**", " * ");
		if (getDescription() != null) {
			content.p(getDescription());
			content.p();
		}
		if (!getDerivedBeans().isEmpty()) {
			content.pi("Subclasses are:<ul>");
			for (Iterator subBeansI = getDerivedBeans().iterator(); subBeansI.hasNext();) {
				Bean subBean = (Bean) subBeansI.next();
				content.p("<li>" + subBean.getJavaDocFullName() + "</li>");
			}
			content.pu("</ul>");
		}
		content.p("@author CommentCodeGen " + getModel().getApplication().getSourceFile().getFullPath().toString());
		content.pu(" */");
		content.a(MVisibility.PUBLIC.getId()).a(" ");
		if (isAbstract()) {
			content.a("abstract ");
		}
		content.a("class " + getName() + " ");
		if (getExtends() != null) {
			content.a("extends " + getExtends() + " ");
		}
		content.pi("{");
		if (isPropertyChangeSupportNeeded()) {
			content.p(PropertyChangeSupport.class.getName() + " " + getPropertyChangeSupportName() + " = new "
			      + PropertyChangeSupport.class.getName() + "(this);");
		}
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeConstants(content, pMonitor);
		}
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeFields(content, pMonitor);
		}
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeMethods(content, pMonitor);
		}
		if (isPropertyChangeSupportNeeded()) {
			CodeUtils.writeDelegation(content, getPropertyChangeSupportName(), PropertyChangeSupport.class,
			      "addProp.*|removeProp.*", "", true);
		}
		content.pu("}");
		getTargetFile().write(content.getContent(), Boolean.TRUE, pMonitor);
	}
}
