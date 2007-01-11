/*
 * $Id: AbstractAProperty.java,v 1.2 2007-01-11 16:29:46 concentus Exp $
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

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.lowlevel.AbstractMProperty;
import de.hasait.eclipse.ccg.javag.lowlevel.MVisibility;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 13.12.2006
 */
public abstract class AbstractAProperty {
	private final AClass _clazz;

	private final AbstractMProperty _property;

	private final String _backref;

	/**
	 * Constructor.
	 */
	protected AbstractAProperty(final AClass pClazz, final AbstractMProperty pProperty, final XElement pConfigElement) {
		super();

		_clazz = pClazz;
		_property = pProperty;

		pProperty.setBeanName(_clazz.getFullName());

		pProperty.setName(pConfigElement.getRequiredAttribute("name"));
		pProperty.setDescription(pConfigElement.getAttribute("description"));
		pProperty.setType(pConfigElement.getRequiredAttribute("type"));
		_backref = pConfigElement.getAttribute("backref");
		pProperty.setBound(pConfigElement.getAttributeAsBoolean("bound", false));
		pProperty.setFinal(pConfigElement.getAttributeAsBoolean("final", false));
		pProperty.setRequired(pConfigElement.getAttributeAsBoolean("required", false));
		pProperty.setAbstract(pConfigElement.getAttributeAsBoolean("abstract", false));
		pProperty.setInitialValue(pConfigElement.getAttribute("value"));
		pProperty.setReadVisibility(MVisibility.get(pConfigElement.getAttribute("readvisibility", "public")));
		pProperty.setWriteVisibility(MVisibility.get(pConfigElement.getAttribute("writevisibility", "public")));

		if (pProperty.isBound()) {
			getClazz().addImport(getClazz().getCuContainer().getApplication()._applicationContextCu.getQualifiedName());
			pProperty.setStaticEventDispatcherName(getClazz().getCuContainer().getApplication()._applicationContextCu
			      .getName()
			      + ".DEFAULT.ED");
		}
	}

	protected AbstractAProperty(final AClass pClazz, final AbstractMProperty pProperty, final String pBackref) {
		super();
		_clazz = pClazz;
		_property = pProperty;
		_backref = pBackref;
		
		pProperty.setBeanName(_clazz.getFullName());
	}

	/**
	 * @return The value of property clazz.
	 */
	public final AClass getClazz() {
		return _clazz;
	}

	/**
	 * @return the property
	 */
	public final AbstractMProperty getProperty() {
		return _property;
	}

	public static int BACKREF_RESOLVE_LAYER = 10;

	public boolean transform(final int pLayer, final IProgressMonitor pMonitor) {
		if (pLayer < BACKREF_RESOLVE_LAYER) {
			return true;
		}
		if (pLayer == BACKREF_RESOLVE_LAYER) {
			if (_backref != null) {
				AClass typeBean = (AClass) getClazz().getModel().findCompilationUnitByName(getProperty().getType());
				if (typeBean == null) {
					throw new IllegalArgumentException(getProperty().getQualifiedName() + "#backref: Cannot find bean "
					      + getProperty().getType());
				}
				AbstractAProperty property = typeBean.findProperty(_backref);
				if (property == null) {
					throw new IllegalArgumentException(getProperty().getQualifiedName() + "#backref: No property " + _backref
					      + " in bean " + typeBean.getFullName());
				}
				getProperty().setBackrefProperty(property.getProperty());
			}
		}
		return false;
	}

	public void validate(IProgressMonitor monitor) {
		if (getProperty().getBackrefProperty() != null && getProperty().getBackrefProperty().getBackrefProperty() != null
		      && getProperty().getBackrefProperty().getBackrefProperty() != getProperty()) {
			throw new IllegalArgumentException("Backref of backref " + _backref + " is not " + getProperty().getQualifiedName()
			      + ", but " + getProperty().getBackrefProperty().getBackrefProperty().getQualifiedName());
		}
	}

	public final void writeConstants(ContentBuffer content, IProgressMonitor monitor) {
		getProperty().writeConstants(content, monitor);
	}

	public final void writeFields(ContentBuffer content, IProgressMonitor monitor) {
		getProperty().writeFields(content, monitor);
	}

	public final void writeMethods(final ContentBuffer content, final Map pUserBlockContentByName,
	      final IProgressMonitor monitor) {
		getProperty().writeMethods(content, pUserBlockContentByName, monitor);
	}
}
