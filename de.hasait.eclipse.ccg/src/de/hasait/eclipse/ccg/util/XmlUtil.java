/*
 * $Id: XmlUtil.java,v 1.1 2006-11-08 20:54:48 concentus Exp $
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
package de.hasait.eclipse.ccg.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class XmlUtil {
    private XmlUtil() {
        super();
    }

    public static Element buildW3cElementFromString(final String xml)
            throws ParserConfigurationException, FactoryConfigurationError,
            SAXException, IOException {
        assert xml != null : "xml";
        DocumentBuilder documentBuilder;
        Document document;
        documentBuilder = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder();
        byte[] bytes = xml.getBytes();
        document = documentBuilder.parse(new ByteArrayInputStream(bytes));
        return document.getDocumentElement();
    }

    /**
     * Returns required attribute's value or an {@link IllegalArgumentException}
     * if not set.
     * 
     * @param element
     *            y.k.
     * @param attribute
     *            y.k.
     * @return s.d.
     */
    public static boolean getAttributeBoolean(final Element element,
            final String attribute) {
        assert element != null : "element";
        assert attribute != null : "attribute";
        if (element.hasAttribute(attribute)) {
            return "true".equalsIgnoreCase(element.getAttribute(attribute));
        }
        throw new IllegalArgumentException("attribute \"" + attribute
                + "\" required");
    }

    /**
     * Returns the attribute's value or the <code>defaultValue</code> if not
     * set.
     * 
     * @param element
     *            y.k.
     * @param attribute
     *            y.k.
     * @param defaultValue
     *            y.k.
     * @return s.d.
     */
    public static boolean getAttributeBoolean(final Element element,
            final String attribute, final boolean defaultValue) {
        assert element != null : "element";
        assert attribute != null : "attribute";
        if (element.hasAttribute(attribute)) {
            String value = element.getAttribute(attribute);
            return "true".equalsIgnoreCase(value)
                    || "yes".equalsIgnoreCase(value);
        }
        return defaultValue;
    }

    /**
     * Returns required attribute's value or an {@link IllegalArgumentException}
     * if not set.
     * 
     * @param element
     *            y.k.
     * @param attribute
     *            y.k.
     * @return s.d.
     */
    public static String getAttributeString(final Element element,
            final String attribute) {
        assert element != null : "element";
        assert attribute != null : "attribute";
        if (element.hasAttribute(attribute)) {
            return element.getAttribute(attribute);
        }
        throw new IllegalArgumentException("attribute \"" + attribute
                + "\" required");
    }

    /**
     * Returns the attribute's value or the <code>defaultValue</code> if not
     * set.
     * 
     * @param element
     *            y.k.
     * @param attribute
     *            y.k.
     * @param defaultValue
     *            y.k.
     * @return s.d.
     */
    public static String getAttributeString(final Element element,
            final String attribute, String defaultValue) {
        assert element != null : "element";
        assert attribute != null : "attribute";
        if (element.hasAttribute(attribute)) {
            return element.getAttribute(attribute);
        }
        return defaultValue;
    }
}
