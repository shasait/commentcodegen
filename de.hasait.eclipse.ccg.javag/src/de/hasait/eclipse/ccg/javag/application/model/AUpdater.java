/*
 * $Id: AUpdater.java,v 1.1 2007-01-10 18:04:15 concentus Exp $
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

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
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
		_clazz = pClazz;
		_name = pName;
		_listenTo = pListenTo;
		_code = pCode;
	}

	public String getUpdateMethodName() {
		return "update" + StringUtil.capitalize(_name);
	}

	public void resolve() {
		for (int vListenToI = 0; vListenToI < _listenTo.length; vListenToI++) {
			String vListenTo = _listenTo[vListenToI];
			if (vListenTo.indexOf(".") < 0) {
				AbstractAProperty vListenToProperty = _clazz.findProperty(vListenTo);
				if (vListenToProperty == null) {
					throw new IllegalArgumentException("property " + vListenTo + " not found for listenTo in "
					      + _clazz.getQualifiedName());
				}
				vListenToProperty.getProperty().addAfterChangeCode(getUpdateMethodName() + "();");
			} else {
				throw new IllegalArgumentException("property navigation not supported for listenTo " + vListenTo + " in "
				      + _clazz.getQualifiedName() + " - sync foreign property and use sync-to instead");
			}
		}
	}

	public void write(final ContentBuffer pContent) {
		pContent.pi("public final void " + getUpdateMethodName() + "() {");
		pContent.p(_code);
		pContent.pu("}");
	}
}
