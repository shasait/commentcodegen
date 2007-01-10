/*
 * $Id: APropertySync.java,v 1.1 2007-01-10 18:04:16 concentus Exp $
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

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 10.01.2007
 */
public class APropertySync {
	private final ASingleProperty _property;

	private final String _from;

	private final String _to;

	/**
	 * @param pProperty
	 * @param pFrom
	 * @param pTo
	 */
	public APropertySync(final ASingleProperty pProperty, final String pFrom, final String pTo) {
		super();
		_property = pProperty;
		_from = pFrom;
		_to = pTo;
	}

	public void resolve() {
		AClass typeBean = (AClass) _property.getBean().getModel().findCompilationUnitByName(
		      _property.getProperty().getType());
		if (typeBean == null) {
			throw new IllegalArgumentException(_property.getProperty().getFullName() + "#backref: Cannot find bean "
			      + _property.getProperty().getType());
		}
		AbstractAProperty property = typeBean.findProperty(_from);
		if (property == null) {
			throw new IllegalArgumentException(_property.getProperty().getFullName() + "#from: No property " + _from
			      + " in bean " + typeBean.getFullName());
		}
	}

}
