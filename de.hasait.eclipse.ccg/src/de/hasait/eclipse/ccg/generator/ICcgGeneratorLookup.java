/*
 * $Id: ICcgGeneratorLookup.java,v 1.3 2006-11-10 16:20:12 concentus Exp $
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
package de.hasait.eclipse.ccg.generator;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 */
public interface ICcgGeneratorLookup {
	boolean containsBlockGenerator(String tagName);

	ICcgBlockGenerator findBlockGenerator(String tagName);

	boolean containsResourceGenerator(String tagName);

	ICcgResourceGenerator findResourceGenerator(String tagName);
}
