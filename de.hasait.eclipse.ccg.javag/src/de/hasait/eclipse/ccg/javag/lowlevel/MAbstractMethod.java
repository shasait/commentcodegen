/*
 * $Id: MAbstractMethod.java,v 1.1 2007-01-10 18:04:16 concentus Exp $
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

import de.hasait.eclipse.common.ContentBuffer;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 10.01.2007
 */
public class MAbstractMethod {
	private final String _name;

	private final String _returnType;

	private final String[] _parameters;

	/**
	 * @param pName
	 * @param pReturnType
	 * @param pParameters
	 */
	public MAbstractMethod(final String pName, final String pReturnType, final String[] pParameters) {
		super();
		_name = pName;
		_returnType = pReturnType;
		_parameters = pParameters;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @return the parameters
	 */
	public final String[] getParameters() {
		return _parameters;
	}

	/**
	 * @return the returnType
	 */
	public final String getReturnType() {
		return _returnType;
	}

	public final void write(final ContentBuffer pContent) {
		pContent.a("public abstract ").a(_returnType).a(" ").a(_name).a("(");
		if (_parameters != null && _parameters.length > 0) {
			for (int vParametersI = 0; vParametersI < _parameters.length; vParametersI++) {
				if (vParametersI > 0) {
					pContent.a(", ");
				}
				pContent.a(_parameters[vParametersI]);
			}
		}
		pContent.a(")").p(";");
	}
}