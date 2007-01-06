/*
 * $Id: AbstractProperty.java,v 1.5 2007-01-06 00:39:04 concentus Exp $
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

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.lowlevel.AbstractMProperty;
import de.hasait.eclipse.ccg.javag.lowlevel.MVisibility;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.5 $
 * @since 13.12.2006
 */
public abstract class AbstractProperty {
	private final Bean _bean;

	private final AbstractMProperty _property;

	private final String _backref;

	/**
	 * Constructor.
	 */
	protected AbstractProperty(final Bean pBean, final AbstractMProperty pProperty, final XElement pConfigElement) {
		super();

		_bean = pBean;
		_property = pProperty;

		pProperty.setBeanName(_bean.getFullName());
		pProperty.setPropertyChangeSupportName(_bean.getPropertyChangeSupportName());

		pProperty.setName(pConfigElement.getRequiredAttribute("name"));
		pProperty.setDescription(pConfigElement.getAttribute("description"));
		pProperty.setType(pConfigElement.getRequiredAttribute("type"));
		_backref = pConfigElement.getAttribute("backref");
		pProperty.setBound(pConfigElement.getAttributeAsBoolean("bound", false));
		pProperty.setFinal(pConfigElement.getAttributeAsBoolean("final", false));
		pProperty.setRequired(pConfigElement.getAttributeAsBoolean("required", false));
		pProperty.setInitialValue(pConfigElement.getAttribute("value"));
		pProperty.setGetterVisibility(MVisibility.get(pConfigElement.getAttribute("getterVisibility", "public")));
		pProperty.setSetterVisibility(MVisibility.get(pConfigElement.getAttribute("setterVisibility", "public")));

		if (pProperty.isBound()) {
			_bean.setPropertyChangeSupportNeeded();
		}
	}

	/**
	 * @return The value of property bean.
	 */
	public final Bean getBean() {
		return _bean;
	}

	/**
	 * @return the property
	 */
	public final AbstractMProperty getProperty() {
		return _property;
	}

	public void resolve(IProgressMonitor monitor) {
		if (_backref != null) {
			Bean typeBean = (Bean) getBean().getModel().findCompilationUnitByName(getProperty().getType());
			if (typeBean == null) {
				throw new IllegalArgumentException(getProperty().getFullName() + "#backref: Cannot find bean "
				      + getProperty().getType());
			}
			AbstractProperty property = typeBean.findProperty(_backref);
			if (property == null) {
				throw new IllegalArgumentException(getProperty().getFullName() + "#backref: No property " + _backref
				      + " in bean " + typeBean.getFullName());
			}
			getProperty().setBackrefProperty(property.getProperty());
		}
	}

	public void validate(IProgressMonitor monitor) {
		if (getProperty().getBackrefProperty() != null && getProperty().getBackrefProperty().getBackrefProperty() != null
		      && getProperty().getBackrefProperty().getBackrefProperty() != getProperty()) {
			throw new IllegalArgumentException("Backref of backref " + _backref + " is not " + getProperty().getFullName()
			      + ", but " + getProperty().getBackrefProperty().getBackrefProperty().getFullName());
		}
	}

	public final void writeConstants(ContentBuffer content, IProgressMonitor monitor) {
		getProperty().writeConstants(content, monitor);
	}

	public final void writeFields(ContentBuffer content, IProgressMonitor monitor) {
		getProperty().writeFields(content, monitor);
	}

	public final void writeMethods(ContentBuffer content, IProgressMonitor monitor) {
		getProperty().writeMethods(content, monitor);
	}
}
