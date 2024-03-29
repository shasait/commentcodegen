/*
 * $Id: APropertySync.java,v 1.6 2007-08-09 14:20:18 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.model;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.lowlevel.MSingleProperty;
import de.hasait.eclipse.ccg.javag.lowlevel.MVisibility;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.6 $
 * @since 10.01.2007
 */
public class APropertySync {
	private final ASingleProperty _property;

	private final String _from;

	private final String _to;

	private final boolean _bound;

	/**
	 * @param pProperty
	 * @param pFrom
	 * @param pTo
	 * @param pBound
	 *           TODO
	 */
	public APropertySync(final ASingleProperty pProperty, final String pFrom, final String pTo, boolean pBound) {
		super();
		_property = pProperty;
		_from = pFrom;
		_to = pTo;
		_bound = pBound;
	}

	private static final int ADD_SYNC_PROPERTY_LAYER = 5;

	public boolean transform(int pLayer, IProgressMonitor pMonitor) {
		if (pLayer < ADD_SYNC_PROPERTY_LAYER) {
			return true;
		}
		if (pLayer == ADD_SYNC_PROPERTY_LAYER) {
			AClass vClazz = _property.getClazz();
			AClass typeBean = (AClass) vClazz.getModel().findCompilationUnitByName(_property.getProperty().getType());
			if (typeBean == null) {
				throw new IllegalArgumentException(_property.getProperty().getQualifiedName()
				      + "#type: Cannot find bean " + _property.getProperty().getType());
			}
			AbstractAProperty vFromProperty = typeBean.findProperty(_from);
			if (vFromProperty == null) {
				throw new IllegalArgumentException(_property.getProperty().getQualifiedName() + "#from: No property "
				      + _from + " in bean " + typeBean.getFullName());
			}
			if (!(vFromProperty instanceof ASingleProperty)) {
				throw new IllegalArgumentException(_property.getProperty().getQualifiedName()
				      + "#from: Not single property " + _from + " in bean " + typeBean.getFullName());
			}
			MSingleProperty vParentMSingleProperty = _property.getSingleProperty();
			MSingleProperty vFromMSingleProperty = ((ASingleProperty) vFromProperty).getSingleProperty();
			ASingleProperty vToSingleProperty = new ASingleProperty(vClazz, new MSingleProperty(), null);
			MSingleProperty vToMSingleProperty = vToSingleProperty.getSingleProperty();
			vToMSingleProperty.setName(_to);
			vToMSingleProperty.setType(vFromMSingleProperty.getType());
			vToMSingleProperty.setWriteVisibility(MVisibility.PRIVATE);
			vToMSingleProperty.setBound(_bound);
			vToMSingleProperty.setStaticEventDispatcherName(vFromMSingleProperty.getStaticEventDispatcherName());
			vClazz.addProperty(vToSingleProperty);
			vClazz.addImport(vClazz.getModel().getApplication()._modelEventDispatcherCu.getQualifiedName());
			vClazz.addImport(vClazz.getModel().getApplication()._applicationContextCu.getQualifiedName());
			String vAppContextName = vClazz.getModel().getApplication()._applicationContextCu.getName();
			String vChangeListenerInstanceName = "_" + _to + "SyncFromChangeListener";
			String vUpdateMethodName = "update" + StringUtil.capitalize(_to) + "SyncTarget";

			ContentBuffer vAttachedCode = new ContentBuffer();
			// class code attachment
			vAttachedCode.pi("private final ModelEventDispatcher.IChangeListener " + vChangeListenerInstanceName
			      + " = new ModelEventDispatcher.IChangeListener() {");
			vAttachedCode.pi("public void handle(ModelEventDispatcher.AbstractChange pChange) {");
			vAttachedCode.p(vUpdateMethodName + "()" + ";");
			vAttachedCode.up("}");
			vAttachedCode.up("};");
			vAttachedCode.p();
			vAttachedCode.pi("public void " + vUpdateMethodName + "() {");
			vAttachedCode.p(vParentMSingleProperty.getType() + " " + vParentMSingleProperty.getLocalVarName() + " = "
			      + vParentMSingleProperty.getGetCall(null) + ";");
			vAttachedCode.p(vToMSingleProperty.getAdderCall(null, vParentMSingleProperty.getLocalVarName()
			      + " == null ? null : " + vFromMSingleProperty.getGetCall(vParentMSingleProperty.getLocalVarName()))
			      + ";");
			vAttachedCode.up("}");
			vAttachedCode.p();
			vClazz.addAttachedCode(vAttachedCode.toString());
			vAttachedCode.c();
			// constructor body code attachment
			vAttachedCode.p(vUpdateMethodName + "()" + ";");
			vClazz.addConstructorBodyAttachCode(vAttachedCode.toString());
			vAttachedCode.c();
			// beforeChange code attachment
			vAttachedCode.pi("if (" + vParentMSingleProperty.getFieldName() + " != null) {");
			vAttachedCode
			      .p(vAppContextName + ".DEFAULT.ED.removeChangeListener(" + vParentMSingleProperty.getFieldName() + ", "
			            + vFromMSingleProperty.getNameConstantQualifiedName() + ", " + vChangeListenerInstanceName + ");");
			vAttachedCode.up("}");
			_property.getProperty().addBeforeChangeCode(vAttachedCode.toString());
			vAttachedCode.c();
			// afterChange code attachment
			vAttachedCode.pi("if (" + vParentMSingleProperty.getFieldName() + " != null) {");
			vAttachedCode
			      .p(vAppContextName + ".DEFAULT.ED.addChangeListener(" + vParentMSingleProperty.getFieldName() + ", "
			            + vFromMSingleProperty.getNameConstantQualifiedName() + ", " + vChangeListenerInstanceName + ");");
			vAttachedCode.up("}");
			vAttachedCode.p(vUpdateMethodName + "()" + ";");
			_property.getProperty().addAfterChangeCode(vAttachedCode.toString());
			vAttachedCode.c();
		}
		return false;
	}
}
