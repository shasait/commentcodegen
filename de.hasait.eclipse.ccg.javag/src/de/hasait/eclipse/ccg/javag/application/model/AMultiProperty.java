/*
 * $Id: AMultiProperty.java,v 1.2 2007-01-15 20:38:08 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.hasait.eclipse.ccg.javag.lowlevel.MMultiProperty;
import de.hasait.eclipse.common.xml.XElement;

/**
 * Generated by CommentCodeGen: /ccgtest/ccg/test1.ccg.xml
 */
public class AMultiProperty extends AbstractAProperty {
	/**
	 * Constructor.
	 */
	public AMultiProperty(final AClass pClazz, final XElement pConfigElement) {
		super(pClazz, new MMultiProperty(), pConfigElement);
		pClazz.addImport(List.class.getName());
		pClazz.addImport(ArrayList.class.getName());
		pClazz.addImport(Iterator.class.getName());
		getMultiProperty().setCollectionClass("List");
		getMultiProperty().setCollectionImplClass("ArrayList");
	}

	public final MMultiProperty getMultiProperty() {
		return (MMultiProperty) getProperty();
	}
}
