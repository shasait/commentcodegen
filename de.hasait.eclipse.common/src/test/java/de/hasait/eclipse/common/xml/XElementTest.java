/*
 * $Id: XElementTest.java,v 1.1 2008-04-08 11:06:17 concentus Exp $
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
public class XElementTest extends TestCase {
	public void test1() throws Exception {
		String xml = "<a><b name=\"b1\">B1<c foo=\"a\">CA</c><c foo=\"b\">CB</c></b><b name=\"b2\" bar=\"foo\">B2<c foo=\"a\">CA</c><c foo=\"b\">CB</c></b></a>";
		XDocument xDocument = XDocument.parse(xml);
		System.out.println(xDocument.asFormattedXml());
		XElement xRootElement = xDocument.getRootElement();
		XElement b = xRootElement.getOrCreateElementWithAttributeValue("b", "name", "b1");
		b.replaceOrAddElement("c", "foo", "b", "<c>NEW</c>");
		assertEquals("<a><b name=\"b1\">B1<c foo=\"a\">CA</c><c foo=\"b\">NEW</c></b><b name=\"b2\" bar=\"foo\">B2<c foo=\"a\">CA</c><c foo=\"b\">CB</c></b></a>", xRootElement.asXml());
	}

	public void test2() throws Exception {
		String xml = "<a><b name=\"b1\">B1<c foo=\"a\">CA</c><c foo=\"b\">CB</c></b><b name=\"b2\" bar=\"foo\">B2<c foo=\"a\">CA</c><c foo=\"b\">CB</c></b></a>";
		XDocument xDocument = XDocument.parse(xml);
		System.out.println(xDocument.asFormattedXml());
		XElement xRootElement = xDocument.getRootElement();
		XElement b = xRootElement.getOrCreateElementWithAttributeValue("b", "name", "b2");
		b.replaceOrAddElement("c", "foo", "b", "<c>NEW</c>");
		assertEquals("<a><b name=\"b1\">B1<c foo=\"a\">CA</c><c foo=\"b\">CB</c></b><b name=\"b2\" bar=\"foo\">B2<c foo=\"a\">CA</c><c foo=\"b\">NEW</c></b></a>", xRootElement.asXml());
	}
}
