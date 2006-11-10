/*
 * $Id: XmlUtil.java,v 1.2 2006-11-10 16:20:18 concentus Exp $
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
package de.hasait.eclipse.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class XmlUtil {
	private XmlUtil() {
		super();
	}

	public static Element buildW3cElementFromString(final String xml) throws ParserConfigurationException,
	      FactoryConfigurationError, SAXException, IOException {
		if (xml == null) {
			throw new IllegalArgumentException("xml == null");
		}
		DocumentBuilder documentBuilder;
		Document document;
		documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		byte[] bytes = xml.getBytes();
		document = documentBuilder.parse(new ByteArrayInputStream(bytes));
		return document.getDocumentElement();
	}

	public static XElement buildXElementFromString(final String xml) throws ParserConfigurationException,
	      FactoryConfigurationError, SAXException, IOException {
		return new XElement(buildW3cElementFromString(xml));
	}

	/**
	 * Returns required attribute's value or an {@link IllegalArgumentException} if not set.
	 * 
	 * @param element
	 *           y.k.
	 * @param attribute
	 *           y.k.
	 * @return s.d.
	 */
	public static boolean getAttributeBoolean(final Element element, final String attribute) {
		if (element == null) {
			throw new IllegalArgumentException("element == null");
		}
		if (attribute == null) {
			throw new IllegalArgumentException("attribute == null");
		}
		if (element.hasAttribute(attribute)) {
			return "true".equalsIgnoreCase(element.getAttribute(attribute));
		}
		throw new IllegalArgumentException("attribute \"" + attribute + "\" required");
	}

	/**
	 * Returns the attribute's value or the <code>defaultValue</code> if not set.
	 * 
	 * @param element
	 *           y.k.
	 * @param attribute
	 *           y.k.
	 * @param defaultValue
	 *           y.k.
	 * @return s.d.
	 */
	public static boolean getAttributeBoolean(final Element element, final String attribute, final boolean defaultValue) {
		if (element == null) {
			throw new IllegalArgumentException("element == null");
		}
		if (attribute == null) {
			throw new IllegalArgumentException("attribute == null");
		}
		if (element.hasAttribute(attribute)) {
			String value = element.getAttribute(attribute);
			return "true".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value);
		}
		return defaultValue;
	}

	/**
	 * Returns required attribute's value or an {@link IllegalArgumentException} if not set.
	 * 
	 * @param element
	 *           y.k.
	 * @param attribute
	 *           y.k.
	 * @return s.d.
	 */
	public static String getAttributeString(final Element element, final String attribute) {
		if (element == null) {
			throw new IllegalArgumentException("element == null");
		}
		if (attribute == null) {
			throw new IllegalArgumentException("attribute == null");
		}
		if (element.hasAttribute(attribute)) {
			return element.getAttribute(attribute);
		}
		throw new IllegalArgumentException("attribute \"" + attribute + "\" required");
	}

	/**
	 * Returns the attribute's value or the <code>defaultValue</code> if not set.
	 * 
	 * @param element
	 *           y.k.
	 * @param attribute
	 *           y.k.
	 * @param defaultValue
	 *           y.k.
	 * @return s.d.
	 */
	public static String getAttributeString(final Element element, final String attribute, String defaultValue) {
		if (element == null) {
			throw new IllegalArgumentException("element == null");
		}
		if (attribute == null) {
			throw new IllegalArgumentException("attribute == null");
		}
		if (element.hasAttribute(attribute)) {
			return element.getAttribute(attribute);
		}
		return defaultValue;
	}

	public static final class XElement {
		private final Element _element;

		public XElement(Element element) {
			super();
			_element = element;
		}

		public String getTagName() {
			return _element.getTagName();
		}

		public XElement[] getChildElements(String tagName) {
			List result = new ArrayList();
			NodeList childNodes = _element.getChildNodes();
			Node childNode;
			for (int i = 0; i < childNodes.getLength(); i++) {
				childNode = childNodes.item(i);
				if (childNode.getNodeType() == Node.ELEMENT_NODE) {
					if (tagName == null || ((Element) childNode).getTagName().equals(tagName)) {
						result.add(new XElement((Element) childNode));
					}
				}
			}
			return (XElement[]) result.toArray(new XElement[result.size()]);
		}

		public XElement[] getChildElements() {
			return getChildElements(null);
		}

		public String getAttribute(String name) {
			return getAttribute(name, null);
		}

		public String getAttribute(String name, String defaultValue) {
			if (_element.hasAttribute(name)) {
				return _element.getAttribute(name);
			}
			return defaultValue;
		}

		public boolean isAttribute(String name) {
			String value = getAttribute(name);
			return value != null && (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("yes"));
		}
	}
}
