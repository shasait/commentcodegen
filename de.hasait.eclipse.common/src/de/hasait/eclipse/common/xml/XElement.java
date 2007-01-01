/*
 * $Id: XElement.java,v 1.2 2007-01-01 22:12:02 concentus Exp $
 * 
 * Copyright 2006 Sebastian Hasait
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
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 01.12.2006
 */
public final class XElement {
	private final Element _element;

	public XElement(Element element) {
		super();
		_element = element;
	}

	public static XElement parse(String xml) throws ParserConfigurationException, FactoryConfigurationError,
	      SAXException, IOException {
		if (xml == null) {
			throw new IllegalArgumentException("xml == null");
		}
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		byte[] bytes = xml.getBytes();
		Document document = documentBuilder.parse(new ByteArrayInputStream(bytes));
		return new XElement(document.getDocumentElement());
	}

	public String getTagName() {
		return _element.getTagName();
	}

	public String getTextContent() {
		return _element.getTextContent();
	}

	public boolean hasAttribute(String name) {
		return _element.hasAttribute(name);
	}

	public String getAttribute(String name) {
		return getAttribute(name, null);
	}

	public String getAttribute(String name, String defaultValue) {
		if (hasAttribute(name)) {
			return _element.getAttribute(name);
		}
		return defaultValue;
	}

	public String getRequiredAttribute(String name) {
		if (hasAttribute(name)) {
			return getAttribute(name);
		}
		throw new IllegalArgumentException("attribute \"" + name + "\" required");
	}

	public Boolean getAttributeAsBoolean(String name) {
		if (hasAttribute(name)) {
			return getRequiredAttributeAsBoolean(name) ? Boolean.TRUE : Boolean.FALSE;
		}
		return null;
	}

	public boolean getAttributeAsBoolean(String name, boolean defaultValue) {
		if (hasAttribute(name)) {
			return getRequiredAttributeAsBoolean(name);
		}
		return defaultValue;
	}

	public boolean getRequiredAttributeAsBoolean(String name) {
		if (hasAttribute(name)) {
			String value = _element.getAttribute(name);
			return "true".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) || name.equals(value);
		}
		throw new IllegalArgumentException("attribute \"" + name + "\" required");
	}

	public Integer getAttributeAsInteger(String name) {
		if (hasAttribute(name)) {
			return Integer.valueOf(getRequiredAttributeAsInteger(name));
		}
		return null;
	}

	public int getAttributeAsInteger(String name, int defaultValue) {
		if (hasAttribute(name)) {
			return getRequiredAttributeAsInteger(name);
		}
		return defaultValue;
	}

	public int getRequiredAttributeAsInteger(String name) {
		if (hasAttribute(name)) {
			String value = _element.getAttribute(name);
			return Integer.parseInt(value);
		}
		throw new IllegalArgumentException("attribute \"" + name + "\" required");
	}

	/**
	 * @param pTagName
	 *           A tagName or tagName-Path.
	 * @return All matching elements, maybe empty, but never <code>null</code>.
	 */
	public XElement[] getChildElements(String pTagName) {
		List result = new ArrayList();
		NodeList childNodes = _element.getChildNodes();
		Node childNode;
		String vTagName;
		String vTagNameRemain;
		if (pTagName == null) {
			vTagName = null;
			vTagNameRemain = null;
		} else {
			int vTagNameSlashI = pTagName.indexOf("/");
			if (vTagNameSlashI > 0) {
				vTagName = pTagName.substring(0, vTagNameSlashI);
				vTagNameRemain = pTagName.substring(vTagNameSlashI + 1);
			} else {
				vTagName = pTagName;
				vTagNameRemain = null;
			}
		}
		for (int i = 0; i < childNodes.getLength(); i++) {
			childNode = childNodes.item(i);
			if (childNode.getNodeType() == Node.ELEMENT_NODE) {
				if (vTagName == null || ((Element) childNode).getTagName().equals(vTagName)) {
					XElement childElement = new XElement((Element) childNode);
					if (vTagNameRemain == null) {
						result.add(childElement);
					} else {
						XElement[] childChildElements = childElement.getChildElements(vTagNameRemain);
						for (int childChildElementsI = 0; childChildElementsI < childChildElements.length; childChildElementsI++) {
							result.add(childChildElements[childChildElementsI]);
						}
					}
				}
			}
		}
		return (XElement[]) result.toArray(new XElement[result.size()]);
	}

	public XElement[] getChildElements() {
		return getChildElements(null);
	}
}