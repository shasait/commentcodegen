/*
 * $Id: AbstractProperty.java,v 1.4 2007-01-01 22:11:24 concentus Exp $
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

import de.hasait.eclipse.ccg.javag.lowlevel.MVisibility;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.4 $
 * @since 13.12.2006
 */
public abstract class AbstractProperty {
	private final Bean _bean;

	private final String _name;

	private final String _capName;

	private final String _fieldName;

	private final String _localVarName;

	private final String _parameterVarName;

	private final String _description;

	private final String _type;

	private final String _backref;

	private AbstractProperty _backrefProperty;

	private final boolean _bound;

	private final MVisibility _setterVisibility;

	private final MVisibility _getterVisibility;

	/**
	 * Constructor.
	 */
	protected AbstractProperty(final Bean pBean, final XElement pConfigElement) {
		super();

		_bean = pBean;

		_name = pConfigElement.getRequiredAttribute("name");
		_description = pConfigElement.getAttribute("description");
		_type = pConfigElement.getRequiredAttribute("type");
		_backref = pConfigElement.getAttribute("backref");
		_bound = pConfigElement.getAttributeAsBoolean("bound", false);
		_getterVisibility = MVisibility.get(pConfigElement.getAttribute("getterVisibility", "public"));
		_setterVisibility = MVisibility.get(pConfigElement.getAttribute("setterVisibility", "public"));

		_capName = StringUtil.capitalize(_name);
		_fieldName = "_" + _name;
		_localVarName = _name;
		_parameterVarName = "p" + _capName;

		if (_bound) {
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
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @return The value of property capName.
	 */
	public final String getCapName() {
		return _capName;
	}

	/**
	 * @return The value of property fieldName.
	 */
	public final String getFieldName() {
		return _fieldName;
	}

	/**
	 * @return the localVarName
	 */
	public final String getLocalVarName() {
		return _localVarName;
	}

	/**
	 * @return the parameterVarName
	 */
	public final String getParameterVarName() {
		return _parameterVarName;
	}

	/**
	 * @return The value of property description.
	 */
	public final String getDescription() {
		return _description;
	}

	/**
	 * @return The value of property type.
	 */
	public final String getType() {
		return _type;
	}

	/**
	 * @return The value of property backref.
	 */
	public final String getBackref() {
		return _backref;
	}

	/**
	 * @return The value of property backrefProperty.
	 */
	public final AbstractProperty getBackrefProperty() {
		return _backrefProperty;
	}

	/**
	 * @return the bound
	 */
	public final boolean isBound() {
		return _bound;
	}

	/**
	 * @return The value of property getterVisibility.
	 */
	public final MVisibility getGetterVisibility() {
		return _getterVisibility;
	}

	/**
	 * @return The value of property setterVisibility.
	 */
	public final MVisibility getSetterVisibility() {
		return _setterVisibility;
	}

	public final String getNameConstant() {
		return "PROPERTY_" + StringUtil.camelCaseToUpperCase(_name) + "_NAME";
	}

	public final String getTypeConstant() {
		return "PROPERTY_" + StringUtil.camelCaseToUpperCase(_name) + "_TYPE";
	}

	public final String getFullName() {
		return _bean.getFullName() + "." + _name;
	}

	public final String getJavaDocFullName() {
		return "{@link " + _bean.getFullName() + "#" + getNameConstant() + "}";
	}

	public abstract String getAdderCall(String instance, String value);

	public abstract String getRemoverCall(String instance, String value);

	public void resolve(IProgressMonitor monitor) {
		if (_backref != null) {
			Bean typeBean = _bean.getModel().findBean(_type);
			if (typeBean == null) {
				throw new IllegalArgumentException(getFullName() + "#backref: Cannot find bean " + _type);
			}
			_backrefProperty = typeBean.findProperty(_backref);
			if (_backrefProperty == null) {
				throw new IllegalArgumentException(getFullName() + "#backref: No property " + _backref + " in bean "
				      + typeBean.getFullName());
			}
		}
	}

	public void validate(IProgressMonitor monitor) {
		if (getBackrefProperty() != null && getBackrefProperty().getBackrefProperty() != null
		      && getBackrefProperty().getBackrefProperty() != this) {
			throw new IllegalArgumentException("Backref of backref " + getBackref() + " is not " + getFullName()
			      + ", but " + getBackrefProperty().getBackrefProperty().getFullName());
		}
	}

	public void writeConstants(ContentBuffer content, IProgressMonitor monitor) {
		content.p("/** Name of property " + getName() + ". */");
		content.p("public static final String " + getNameConstant() + " = \"" + _name + "\";");

		content.p("/** Type of property " + getName() + ". */");
		content.p("public static final Class " + getTypeConstant() + " = " + _type + ".class;");
		content.p();
	}

	public void writeFields(ContentBuffer content, IProgressMonitor monitor) {
		// nop
	}

	public void writeMethods(ContentBuffer content, IProgressMonitor monitor) {
		// nop
	}
}
