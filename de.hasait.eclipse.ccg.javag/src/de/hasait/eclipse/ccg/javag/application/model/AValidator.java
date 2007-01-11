/*
 * $Id: AValidator.java,v 1.2 2007-01-11 16:29:46 concentus Exp $
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

import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 10.01.2007
 */
public class AValidator {
	private final AClass _clazz;

	private final String _name;

	private final String _messageConstantName;

	private final String _expression;

	private final String _description;

	private final String[] _bindings;

	/**
	 * @param pExpression
	 * @param pBindings
	 */
	public AValidator(final AClass pClazz, final String pName, final String pExpression, final String pDescription,
	      final String[] pBindings) {
		super();
		_clazz = pClazz;
		_name = pName;
		_expression = pExpression;
		_description = pDescription;
		_bindings = pBindings;

		_messageConstantName = "VALIDATION_MESSAGE_" + StringUtil.camelCaseToUpperCase(_name);
	}

	/**
	 * @return the clazz
	 */
	public final AClass getClazz() {
		return _clazz;
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

	public static final int ADD_AFTER_CHANGE_CODE_LAYER = 5;

	public boolean transform(final int pLayer, final IProgressMonitor pMonitor) {
		if (pLayer < ADD_AFTER_CHANGE_CODE_LAYER) {
			return true;
		}
		if (pLayer == ADD_AFTER_CHANGE_CODE_LAYER) {
			String[] vValidatorBindings = getBindings();
			for (int vValidatorBindingI = 0; vValidatorBindingI < vValidatorBindings.length; vValidatorBindingI++) {
				String vValidatorBinding = vValidatorBindings[vValidatorBindingI];
				AbstractAProperty vValidatorBindingProperty = getClazz().findProperty(vValidatorBinding);
				if (vValidatorBindingProperty == null) {
					throw new IllegalArgumentException("invalid validatorBinding " + vValidatorBinding + " for "
					      + getDescription());
				}
				vValidatorBindingProperty.getProperty().addAfterChangeCode("//TODO validator");
			}
		}
		return false;
	}
}
