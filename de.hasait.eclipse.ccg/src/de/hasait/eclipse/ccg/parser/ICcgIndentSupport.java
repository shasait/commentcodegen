/*
 * $Id: ICcgIndentSupport.java,v 1.1 2007-07-02 15:12:00 concentus Exp $
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

package de.hasait.eclipse.ccg.parser;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 02.07.2007
 */
public interface ICcgIndentSupport {
	/**
	 * @return The absolute indent of this element.
	 */
	String getIndent();

	/**
	 * @param indent
	 *           The absolute indent to set.
	 */
	void setIndent(String indent);
}
