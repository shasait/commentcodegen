/*
 * $Id: RemoveCcgNatureAction.java,v 1.2 2006-11-10 14:01:01 concentus Exp $
 * 
 * Copyright 2005 Sebastian Hasait
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
package de.hasait.eclipse.ccg.action;

import de.hasait.eclipse.ccg.nature.CcgNature;
import de.hasait.eclipse.common.nature.AbstractRemoveNatureAction;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class RemoveCcgNatureAction extends AbstractRemoveNatureAction {
	/**
	 * Constructor.
	 */
	public RemoveCcgNatureAction() {
		super(CcgNature.NATURE_ID);
	}
}
