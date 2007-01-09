/*
 * $Id: AbstractCodeBlock.java,v 1.1 2007-01-09 17:05:18 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.hasait.eclipse.common.ContentBuffer;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 09.01.2007
 */
public class AbstractCodeBlock {
	private final List _code = new ArrayList();

	public final void add(final Object pCode) {
		_code.add(pCode);
	}

	public void write(final ContentBuffer pContent) {
		for (Iterator vCodeI = _code.iterator(); vCodeI.hasNext();) {
			Object vCode = (Object) vCodeI.next();
			if (vCode instanceof AbstractCodeBlock) {
				((AbstractCodeBlock) vCode).write(pContent);
			} else {
				pContent.p(String.valueOf(vCode));
			}
		}
	}
}
