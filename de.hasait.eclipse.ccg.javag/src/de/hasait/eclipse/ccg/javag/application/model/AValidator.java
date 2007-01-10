/*
 * $Id: AValidator.java,v 1.1 2007-01-10 18:04:15 concentus Exp $
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

import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 10.01.2007
 */
public class AValidator {
	private final String _name;

	private final String _messageConstantName;

	private final String _expression;

	private final String _description;

	private final String[] _bindings;

	/**
	 * @param pExpression
	 * @param pBindings
	 */
	public AValidator(final String pName, final String pExpression, final String pDescription, final String[] pBindings) {
		super();
		_name = pName;
		_expression = pExpression;
		_description = pDescription;
		_bindings = pBindings;

		_messageConstantName = "VALIDATION_MESSAGE_" + StringUtil.camelCaseToUpperCase(_name);
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @return the messageConstantName
	 */
	public final String getMessageConstantName() {
		return _messageConstantName;
	}

	/**
	 * @return the expression
	 */
	public final String getExpression() {
		return _expression;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return _description;
	}

	/**
	 * @return the bindings
	 */
	public final String[] getBindings() {
		return _bindings;
	}
}