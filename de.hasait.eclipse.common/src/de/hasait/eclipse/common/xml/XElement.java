/*
 * $Id: XElement.java,v 1.4 2007-07-02 15:11:54 concentus Exp $
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

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.FactoryConfigurationError;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.4 $
 * @since 01.12.2006
 */
public final class XElement {
	private final Element _element;

	/**
	 * @param element
	 */
	public XElement(final Element element) {
		super();
		if (element == null) {
			throw new IllegalArgumentException("element == null");
		}
		_element = element;
	}

	/**
	 * @param xml
	 *           A String containing XML.
	 * @return The RootElement.
	 * @throws DocumentException
	 * @throws FactoryConfigurationError
	 * @throws DocumentException
	 */
	public static XElement parse(final String xml) throws DocumentException {
		if (xml == null) {
			throw new IllegalArgumentException("xml == null");
		}

		Document document = new SAXReader().read(new StringReader(xml));
		return new XElement(document.getRootElement());
	}

	public String getTagName() {
		return _element.getName();
	}

	public String getTextContent() {
		return _element.getText();
	}

	public boolean hasAttribute(final String name) {
		return _element.attribute(name) != null;
	}

	public String getStringAttribute(final String name) {
		return _element.attributeValue(name);
	}

	public String getStringAttribute(final String name, final String defaultValue) {
		return _element.attributeValue(name, defaultValue);
	}

	public String getRequiredStringAttribute(final String name) {
		if (hasAttribute(name)) {
			return getStringAttribute(name);
		}
		throw new IllegalArgumentException("attribute \"" + name + "\" required");
	}

	public Boolean getBooleanAttribute(final String name) {
		if (hasAttribute(name)) {
			return Boolean.valueOf(getRequiredBooleanAttribute(name));
		}
		return null;
	}

	public boolean getBooleanAttribute(final String name, final boolean defaultValue) {
		if (hasAttribute(name)) {
			return getRequiredBooleanAttribute(name);
		}
		return defaultValue;
	}

	public boolean getRequiredBooleanAttribute(final String name) {
		String value = getRequiredStringAttribute(name);
		return "true".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) || name.equals(value);
	}

	public Integer getIntegerAttribute(final String name) {
		if (hasAttribute(name)) {
			return Integer.valueOf(getRequiredIntegerAttribute(name));
		}
		return null;
	}

	public int getIntegerAttribute(final String name, final int defaultValue) {
		if (hasAttribute(name)) {
			return getRequiredIntegerAttribute(name);
		}
		return defaultValue;
	}

	public int getRequiredIntegerAttribute(final String name) {
		String value = getRequiredStringAttribute(name);
		return Integer.parseInt(value);
	}

	/**
	 * @param tagNamePath
	 *           A tagName or tagName-Path (e.g. elem/subelem/subsubelem).
	 * @return All matching elements, maybe empty, but never <code>null</code>.
	 */
	public XElement[] getChildElements(final String tagNamePath) {
		List<XElement> result = new ArrayList<XElement>();

		Iterator elementI = tagNamePath == null ? _element.elementIterator() : _element.elementIterator(tagNamePath);

		while (elementI.hasNext()) {
			Element element = (Element) elementI.next();
			result.add(new XElement(element));
		}
		return result.toArray(new XElement[result.size()]);
	}

	/**
	 * @return All child elements, maybe empty, but never <code>null</code>.
	 */
	public XElement[] getChildElements() {
		return getChildElements(null);
	}
}
