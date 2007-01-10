/*
 * $Id: AbstractMProperty.java,v 1.3 2007-01-10 18:04:16 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.lowlevel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 * @since 04.01.2007
 */
public abstract class AbstractMProperty {
	private String _name;

	private String _capName;

	private String _fieldName;

	private String _localVarName;

	private String _parameterVarName;

	private String _nameConstantName;

	private String _typeConstantName;

	private String _description;

	private String _type;

	private AbstractMProperty _backrefProperty;

	private boolean _bound;

	private MVisibility _writeVisibility;

	private MVisibility _readVisibility;

	private String _beanName;

	private boolean _final;

	private String _initialValue;

	private boolean _required;

	private final List _afterChangeCode = new ArrayList();

	private String _staticEventDispatcherName;

	/**
	 * 
	 */
	public AbstractMProperty() {
		super();
		_readVisibility = MVisibility.PUBLIC;
		_writeVisibility = MVisibility.PUBLIC;
	}

	/**
	 * @return the backrefProperty
	 */
	public final AbstractMProperty getBackrefProperty() {
		return _backrefProperty;
	}

	/**
	 * @param pBackrefProperty
	 *           the backrefProperty to set
	 */
	public void setBackrefProperty(AbstractMProperty pBackrefProperty) {
		_backrefProperty = pBackrefProperty;
	}

	/**
	 * @return the bound
	 */
	public final boolean isBound() {
		return _bound;
	}

	/**
	 * @param pBound
	 *           the bound to set
	 */
	public final void setBound(boolean pBound) {
		_bound = pBound;
	}

	/**
	 * @return the final
	 */
	public final boolean isFinal() {
		return _final;
	}

	/**
	 * @param pFinal
	 *           the final to set
	 */
	public final void setFinal(boolean pFinal) {
		_final = pFinal;
	}

	/**
	 * @return the required
	 */
	public final boolean isRequired() {
		return _required;
	}

	/**
	 * @param pRequired
	 *           the required to set
	 */
	public final void setRequired(boolean pRequired) {
		_required = pRequired;
	}

	/**
	 * @return the initialValue
	 */
	public final String getInitialValue() {
		return _initialValue;
	}

	/**
	 * @param pInitialValue
	 *           the initialValue to set
	 */
	public final void setInitialValue(String pInitialValue) {
		_initialValue = pInitialValue;
	}

	/**
	 * @return the capName
	 */
	public final String getCapName() {
		return _capName;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return _description;
	}

	/**
	 * @param pDescription
	 *           the description to set
	 */
	public void setDescription(String pDescription) {
		_description = pDescription;
	}

	/**
	 * @return the fieldName
	 */
	public final String getFieldName() {
		return _fieldName;
	}

	/**
	 * @return the getterVisibility
	 */
	public final MVisibility getReadVisibility() {
		return _readVisibility;
	}

	/**
	 * @param pReadVisibility
	 *           the getterVisibility to set
	 */
	public void setReadVisibility(MVisibility pReadVisibility) {
		_readVisibility = pReadVisibility;
	}

	/**
	 * @return the localVarName
	 */
	public final String getLocalVarName() {
		return _localVarName;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @param pName
	 *           the name to set
	 */
	public void setName(String pName) {
		_name = pName;
		_capName = StringUtil.capitalize(_name);
		_fieldName = "_" + _name;
		_localVarName = "v" + _capName;
		_parameterVarName = "p" + _capName;
		_nameConstantName = "PROPERTY_" + StringUtil.camelCaseToUpperCase(_name) + "_NAME";
		_typeConstantName = "PROPERTY_" + StringUtil.camelCaseToUpperCase(_name) + "_TYPE";
	}

	/**
	 * @return the staticEventDispatcherName
	 */
	public final String getStaticEventDispatcherName() {
		return _staticEventDispatcherName;
	}

	/**
	 * @param pStaticEventDispatcherName
	 *           the staticEventDispatcherName to set
	 */
	public final void setStaticEventDispatcherName(String pStaticEventDispatcherName) {
		_staticEventDispatcherName = pStaticEventDispatcherName;
	}

	public final String getAddSingleChangeCall(final String pModificationSourceExpr, final String pOldValueExpr,
	      final String pNewValueExpr) {
		return getStaticEventDispatcherName() + ".addSingleChange(" + pModificationSourceExpr + ", "
		      + getNameConstantName() + ", " + pOldValueExpr + ", " + pNewValueExpr + ")";
	}

	public final String getAddMultiAddChangeCall(final String pModificationSourceExpr, final String pNewValueExpr) {
		return getStaticEventDispatcherName() + ".addMultiAddChange(" + pModificationSourceExpr + ", "
		      + getNameConstantName() + ", " + pNewValueExpr + ")";
	}

	public final String getAddMultiRemoveChangeCall(final String pModificationSourceExpr, final String pOldValueExpr) {
		return getStaticEventDispatcherName() + ".addMultiRemoveChange(" + pModificationSourceExpr + ", "
		      + getNameConstantName() + ", " + pOldValueExpr + ")";
	}

	/**
	 * @return the parameterVarName
	 */
	public final String getParameterVarName() {
		return _parameterVarName;
	}

	/**
	 * @return the nameConstantName
	 */
	public final String getNameConstantName() {
		return _nameConstantName;
	}

	/**
	 * @return the typeConstantName
	 */
	public final String getTypeConstantName() {
		return _typeConstantName;
	}

	/**
	 * @return the setterVisibility
	 */
	public final MVisibility getWriteVisibility() {
		return _writeVisibility;
	}

	/**
	 * @param pWriteVisibility
	 *           the setterVisibility to set
	 */
	public void setWriteVisibility(MVisibility pWriteVisibility) {
		_writeVisibility = pWriteVisibility;
	}

	/**
	 * @return the type
	 */
	public final String getType() {
		return _type;
	}

	/**
	 * @param pType
	 *           the type to set
	 */
	public void setType(String pType) {
		_type = pType;
	}

	/**
	 * @return the beanName
	 */
	public final String getBeanName() {
		return _beanName;
	}

	/**
	 * @param pBeanName
	 *           the beanName to set
	 */
	public final void setBeanName(String pBeanName) {
		_beanName = pBeanName;
	}

	public final void addAfterChangeCode(final String pAfterChangeCode) {
		_afterChangeCode.add(pAfterChangeCode);
	}

	private final Iterator afterChangeCodeIterator() {
		return _afterChangeCode.iterator();
	}

	private final boolean isAfterChangeCodeEmpty() {
		return _afterChangeCode.isEmpty();
	}

	public abstract String getAdderCall(String instance, String value);

	public abstract String getRemoverCall(String instance, String value);

	public abstract String getContainsCall(String pThisVarName, String pContainsVarName);

	public abstract String getConstructorArguments();

	public abstract void writeConstructorBody(ContentBuffer pContent);

	public final String getFullName() {
		return getBeanName() + "." + _name;
	}

	public final String getJavaDocFullName() {
		return "{@link " + getBeanName() + "#" + getNameConstantName() + "}";
	}

	public final String getArgumentDeclaration() {
		return "final " + getType() + " " + getParameterVarName();
	}

	public void writeConstants(ContentBuffer content, IProgressMonitor monitor) {
		content.p("/** Name of property " + getName() + ". */");
		content.p("public static final String " + getNameConstantName() + " = \"" + _name + "\";");

		content.p("/** Type of property " + getName() + ". */");
		content.p("public static final Class " + getTypeConstantName() + " = " + _type + ".class;");
		content.p();
	}

	public void writeFields(ContentBuffer content, IProgressMonitor monitor) {
		// nop
	}

	public void writeMethods(final ContentBuffer pContent, final Map pUserBlockContentByName,
	      final IProgressMonitor pMonitor) {
		// nop
	}

	public final void writeAfterChangeCode(final ContentBuffer pContent) {
		for (Iterator vAfterChangeCodeI = afterChangeCodeIterator(); vAfterChangeCodeI.hasNext();) {
			String vAfterChangeCode = (String) vAfterChangeCodeI.next();
			pContent.p(vAfterChangeCode);
		}
	}
}
