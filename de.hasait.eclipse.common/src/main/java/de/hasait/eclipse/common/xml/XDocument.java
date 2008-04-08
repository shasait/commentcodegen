/*
 * $Id: XDocument.java,v 1.1 2008-04-08 11:06:15 concentus Exp $
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
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.FactoryConfigurationError;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Text;
import org.dom4j.VisitorSupport;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 01.12.2006
 */
public final class XDocument {
	private final Document _document;

	/**
	 * @param document
	 */
	public XDocument(final Document document) {
		super();
		if (document == null) {
			throw new IllegalArgumentException("document == null");
		}
		_document = document;
	}

	/**
	 * 
	 */
	public XDocument(final String encoding, final String rootElementName) {
		super();

		DocumentFactory df = DocumentFactory.getInstance();
		_document = df.createDocument(encoding);
		_document.setRootElement(df.createElement(rootElementName));
	}

	/**
	 * @return the document
	 */
	public Document getRawDocument() {
		return _document;
	}

	/**
	 * @param xml
	 *           A String containing XML.
	 * @return The RootElement.
	 * @throws DocumentException
	 * @throws FactoryConfigurationError
	 * @throws DocumentException
	 */
	public static XDocument parse(final String xml) throws DocumentException {
		if (xml == null) {
			throw new IllegalArgumentException("xml == null");
		}

		Document document = new SAXReader().read(new StringReader(xml));
		return new XDocument(document);
	}

	public boolean hasRootElement() {
		return _document.getRootElement() != null;
	}

	public XElement getRootElement() {
		return hasRootElement() ? new XElement(_document.getRootElement()) : null;
	}

	public void setRootElement(final XElement element) {
		_document.setRootElement(element == null ? null : element.getRawElement());
	}

	public XElement getRequiredRootElement() {
		if (hasRootElement()) {
			return getRootElement();
		}
		throw new IllegalArgumentException("no root element");
	}

	public XElement getOrCreateRootElement(final String name) {
		if (hasRootElement()) {
			XElement element = getRootElement();
			element.checkName(name);
			return element;
		}
		XElement element = new XElement(name);
		setRootElement(element);
		return element;
	}

	public String asXml() {
		return _document.asXML();
	}

	public String asFormattedXml(final String indent, final boolean newlines, final boolean trimText) {
		StringWriter sw = new StringWriter();
		try {
			OutputFormat outputFormat = new OutputFormat(indent, newlines);
			outputFormat.setTrimText(trimText);
			new XMLWriter(sw, outputFormat).write(_document);
		} catch (IOException e) {
			// Should not happen for StringWriter
			throw new RuntimeException(e);
		}
		return sw.getBuffer().toString();
	}

	public String asFormattedXml(final boolean trimText) {
		return asFormattedXml("\t", true, trimText);
	}

	public String asFormattedXml() {
		return asFormattedXml(true);
	}
}
