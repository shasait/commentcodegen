/*
 * $Id: XElement.java,v 1.3 2008-06-09 11:32:08 concentus Exp $
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

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import de.hasait.eclipse.common.ObjectUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
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
	 * @param name
	 */
	public XElement(final String name) {
		this(DocumentFactory.getInstance().createElement(name));
	}

	/**
	 * @return the element
	 */
	public Element getRawElement() {
		return _element;
	}

	public void checkName(final String name) {
		String elementName = getName();
		if (!elementName.equals(name)) {
			throw new IllegalArgumentException("name is not " + name + " but " + elementName);
		}
	}

	public String getName() {
		return _element.getName();
	}

	public String getText() {
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

	public void setStringAttributes(final String... nameValuePairs) {
		for (int i = 0; i < nameValuePairs.length;) {
			String name = nameValuePairs[i++];
			String value = nameValuePairs[i++];
			_element.addAttribute(name, value);
		}
	}

	public void setStringAttribute(final String name, final String value) {
		setStringAttributes(name, value);
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

	public void removeAllAttributes() {
		Iterator<Attribute> attributeI = _element.attributes().iterator();
		while (attributeI.hasNext()) {
			attributeI.next();
			attributeI.remove();
		}
	}

	public boolean matchesAttributes(final String... nameValuePairs) {
		for (int i = 0; i < nameValuePairs.length;) {
			String name = nameValuePairs[i++];
			String value = nameValuePairs[i++];
			if (!ObjectUtil.equals(getStringAttribute(name), value)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Removes all attributes except the one with the provided name.
	 * 
	 * @param names
	 *           The names of the attributes not to remove.
	 */
	public void removeAllAttributesExclude(final String... names) {
		Iterator<Attribute> attributeI = _element.attributes().iterator();
		while (attributeI.hasNext()) {
			Attribute attribute = attributeI.next();
			for (int i = 0; i < names.length; i++) {
				String name = names[i];
				if (attribute.getName().equals(name)) {
					continue;
				}
			}
			attributeI.remove();
		}
	}

	/**
	 * @param name
	 *           The element name or <code>null</code>.
	 * @return All child elements with the provided name or all child elements if name is <code>null</code>, may be
	 *         empty, but never <code>null</code>.
	 */
	public XElement[] getElements(final String name) {
		List<XElement> result = new ArrayList<XElement>();
		Iterator<Element> elementI = name == null ? _element.elementIterator() : _element.elementIterator(name);
		while (elementI.hasNext()) {
			Element element = elementI.next();
			result.add(new XElement(element));
		}
		return result.toArray(new XElement[result.size()]);
	}

	/**
	 * @return All child elements, maybe empty, but never <code>null</code>.
	 */
	public XElement[] getElements() {
		return getElements(null);
	}

	/**
	 * @param element
	 *           The element to add.
	 */
	public void addElement(final XElement element) {
		_element.add(element.getRawElement());
	}

	/**
	 * @param element
	 *           The element to remove.
	 */
	public void removeElement(final XElement element) {
		_element.remove(element.getRawElement());
	}

	/**
	 * @param xml
	 *           XML with one root element.
	 * @return The root element, which was added to this element.
	 * @throws DocumentException
	 */
	public XElement addElementXml(final String xml) throws DocumentException {
		XElement element = XDocument.parse(xml).getRequiredRootElement();
		addElement(element);
		return element;
	}

	public void removeAllElements() {
		for (XElement element : getElements()) {
			removeElement(element);
		}
	}

	public void removeElements(final String name, final String... attributeNameValuePairs) {
		for (XElement element : getElements(name)) {
			if (element.matchesAttributes(attributeNameValuePairs)) {
				removeElement(element);
			}
		}
	}

	public void removeAll() {
		removeAllAttributes();
		_element.clearContent();
	}

	public void copyElement(final XElement element) {
		_element.appendAttributes(element.getRawElement());
		_element.appendContent(element.getRawElement());
	}

	public XElement getOrCreateElementWithAttributeValue(final String name, final String... attributeNameValuePairs) {
		for (XElement element : getElements(name)) {
			if (element.matchesAttributes(attributeNameValuePairs)) {
				return element;
			}
		}
		XElement element = new XElement(name);
		element.setStringAttributes(attributeNameValuePairs);
		addElement(element);
		return element;
	}

	public void replaceOrAddElement(final String xml, final String name, final String... attributeNameValuePairs)
	      throws DocumentException {
		XElement baseElement = null;
		for (XElement element : getElements(name)) {
			if (element.matchesAttributes(attributeNameValuePairs)) {
				if (baseElement == null) {
					baseElement = element;
				} else {
					removeElement(element);
				}
			}
		}
		XElement newElement = XDocument.parse(xml).getRequiredRootElement();
		newElement.checkName(name);
		for (int i = 0; i < attributeNameValuePairs.length;) {
			String attributeName = attributeNameValuePairs[i++];
			String attributeValue = attributeNameValuePairs[i++];
			if (newElement.hasAttribute(attributeName)) {
				if (!ObjectUtil.equals(newElement.getStringAttribute(attributeName), attributeValue)) {
					throw new IllegalArgumentException("root element's attribute value differs " + attributeName + "="
					      + attributeValue + ": " + xml);
				}
				newElement.setStringAttribute(attributeName, null);
			}
		}
		if (baseElement == null) {
			baseElement = new XElement(name);
			addElement(baseElement);
		}
		baseElement.removeAll();
		baseElement.setStringAttributes(attributeNameValuePairs);
		baseElement.copyElement(newElement);
	}

	public String asXml() {
		return _element.asXML();
	}

	public String asFormattedXml(final String lineSeparator, final String indent, final boolean newlines,
	      final boolean trimText) {
		StringWriter sw = new StringWriter();
		try {
			OutputFormat outputFormat = new OutputFormat(indent, newlines);
			outputFormat.setTrimText(trimText);
			outputFormat.setLineSeparator(lineSeparator);
			new XMLWriter(sw, outputFormat).write(_element);
		} catch (IOException e) {
			// Should not happen for StringWriter
			throw new RuntimeException(e);
		}
		return sw.getBuffer().toString();
	}

	public String asFormattedXml(final String lineSeparator, final boolean trimText) {
		return asFormattedXml(lineSeparator, "\t", true, trimText);
	}

	public String asFormattedXml(final String lineSeparator) {
		return asFormattedXml(lineSeparator, true);
	}

	public String asFormattedXml(final String lineSeparator, final String indent) {
		return asFormattedXml(lineSeparator, indent, true, true);
	}

	public String asFormattedXml(final boolean trimText) {
		return asFormattedXml("\n", trimText);
	}

	public String asFormattedXml() {
		return asFormattedXml(true);
	}
}
