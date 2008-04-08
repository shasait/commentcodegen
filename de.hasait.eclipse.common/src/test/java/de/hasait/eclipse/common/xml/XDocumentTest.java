/*
 * $Id: XDocumentTest.java,v 1.1 2008-04-08 11:06:17 concentus Exp $
 * 
 * Copyright 2008 Sebastian Hasait
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

package de.hasait.eclipse.common.xml;

import junit.framework.TestCase;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 08.04.2008
 */
public class XDocumentTest extends TestCase {
	public void testGetRootElement() throws Exception {
		String xml = "<a></a>";
		XDocument xDocument = XDocument.parse(xml);
		XElement xElement = xDocument.getRootElement();
		assertNotNull(xElement);
		xElement.checkName("a");
	}

	public void testGetRequiredRootElement() throws Exception {
		String xml;
		XDocument xDocument;
		xml = "<a></a>";
		xDocument = XDocument.parse(xml);
		XElement xElement = xDocument.getRequiredRootElement();
		assertNotNull(xElement);
		xElement.checkName("a");

		xml = "<a></a>";
		xDocument = XDocument.parse(xml);
		xDocument.setRootElement(null);
		try {
			xDocument.getRequiredRootElement();
			fail("no exception");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("root element"));
		}
	}
}
