/*
 * $Id: AUpdater.java,v 1.3 2007-07-02 13:41:28 concentus Exp $
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

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 * @since 10.01.2007
 */
public class AUpdater {
	private final AClass _clazz;

	private final String _name;

	private final String[] _listenTo;

	private final String _code;

	/**
	 * @param pClazz
	 * @param pName
	 * @param pListenTo
	 * @param pCode
	 */
	public AUpdater(final AClass pClazz, final String pName, final String[] pListenTo, final String pCode) {
		super();
		if (pClazz == null) {
			throw new IllegalArgumentException("pClazz == null");
		}
		_clazz = pClazz;
		_name = pName;
		_listenTo = pListenTo;
		_code = pCode;
	}

	public String getUpdateMethodName() {
		return "update" + StringUtil.capitalize(_name);
	}

	public static final int ADD_AFTER_CHANGE_CODE_LAYER = 8;

	public boolean transform(int pLayer, IProgressMonitor pMonitor) {
		if (pLayer < ADD_AFTER_CHANGE_CODE_LAYER) {
			return true;
		}
		if (pLayer == ADD_AFTER_CHANGE_CODE_LAYER) {
			AClass vTopMostClass = _clazz;
			for (int vListenToI = 0; vListenToI < _listenTo.length; vListenToI++) {
				String vListenTo = _listenTo[vListenToI];
				if (vListenTo.indexOf(".") < 0) {
					AClass vExtends = _clazz;
					boolean vUpdateTopMostClass = false;
					AbstractAProperty vListenToProperty;
					do {
						vListenToProperty = vExtends.findProperty(vListenTo);
						if (vExtends == vTopMostClass) {
							vUpdateTopMostClass = true;
						}
					} while (vListenToProperty == null && (vExtends = vExtends.getExtendsClass()) != null);
					if (vUpdateTopMostClass) {
						vTopMostClass = vExtends;
					}
					if (vListenToProperty == null) {
						throw new IllegalArgumentException("property " + vListenTo + " not found for listenTo in "
						      + _clazz.getQualifiedName());
					}
					vListenToProperty.getProperty().addAfterChangeCode(getUpdateMethodName() + "();");
				} else {
					throw new IllegalArgumentException("property navigation not supported for listenTo " + vListenTo
					      + " in " + _clazz.getQualifiedName() + " - sync foreign property and use sync-to instead");
				}
			}
			ContentBuffer vAttachedCode = new ContentBuffer();
			vAttachedCode.pi("public final void " + getUpdateMethodName() + "() {");
			if (vTopMostClass != _clazz) {
				vAttachedCode.p("super." + getUpdateMethodName() + "();");
			}
			vAttachedCode.p(_code);
			vAttachedCode.pu("}");
			vAttachedCode.p();
			_clazz.addAttachedCode(vAttachedCode.toString());
			if (vTopMostClass != _clazz) {
				vAttachedCode.c();
				vAttachedCode.p("/** Extended by " + _clazz.getJavaDocLink() + " */");
				vAttachedCode.pi("protected void " + getUpdateMethodName() + "() {");
				vAttachedCode.p("// nop");
				vAttachedCode.pu("}");
				vTopMostClass.addAttachedCode(vAttachedCode.toString());
			}
		}
		return false;
	}
}
