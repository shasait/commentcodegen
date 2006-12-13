/*
 * $Id: ApplicationResourceGenerator.java,v 1.1 2006-12-13 21:58:08 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.generator.AbstractCcgResourceGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.javag.application.model.Application;
import de.hasait.eclipse.ccg.javag.application.model.Bean;
import de.hasait.eclipse.ccg.javag.application.model.Model;
import de.hasait.eclipse.ccg.javag.application.model.MultiProperty;
import de.hasait.eclipse.ccg.javag.application.model.SingleProperty;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 13.12.2006
 */
public class ApplicationResourceGenerator extends AbstractCcgResourceGenerator {
	private static final String DESCRIPTION = "Creates an application";

	private static final String[] TAG_NAMES = new String[] { "application" };

	/**
	 * Constructor.
	 */
	public ApplicationResourceGenerator() {
		super(DESCRIPTION, TAG_NAMES);
	}

	public void generateResources(XElement configElement, XFile sourceFile, XFolder targetBaseFolder,
	      Map sourceFileContext, ICcgGeneratorLookup generatorLookup, IProgressMonitor monitor) throws Exception {
		Application application = new Application(sourceFile, targetBaseFolder);
		XElement[] modelElements = configElement.getChildElements("model");
		for (int modelElementsI = 0; modelElementsI < modelElements.length; modelElementsI++) {
			XElement modelElement = modelElements[modelElementsI];
			addModels(application, modelElement);
		}
		application.resolve(monitor);
		application.validate(monitor);
		application.write(monitor);
	}

	private void addModels(Application application, XElement configElement) {
		String packagej = configElement.getRequiredAttribute("package");
		Model model = new Model(application, packagej);
		XElement[] beanElements = configElement.getChildElements("bean");
		for (int beanElementsI = 0; beanElementsI < beanElements.length; beanElementsI++) {
			XElement beanElement = beanElements[beanElementsI];
			addBean(model, beanElement);
		}
	}

	private void addBean(Model model, XElement configElement) {
		String name = configElement.getRequiredAttribute("name");
		String description = configElement.getAttribute("description");
		boolean abstractj = configElement.getAttributeAsBoolean("abstract", false);
		String extendsj = configElement.getAttribute("extends");
		Bean bean = new Bean(model, name, description, abstractj, extendsj);
		XElement[] propertyElements = configElement.getChildElements("property");
		for (int propertyElementsI = 0; propertyElementsI < propertyElements.length; propertyElementsI++) {
			XElement propertyElement = propertyElements[propertyElementsI];
			String cardinality = propertyElement.getAttribute("cardinality");
			if (cardinality == null || cardinality.equals("1")) {
				addSingleProperty(bean, propertyElement);
			} else if (cardinality.equals("*")) {
				addMultiProperty(bean, propertyElement);
			} else {
				throw new IllegalArgumentException("cardinality not supported: " + cardinality);
			}
		}
	}

	private void addSingleProperty(Bean bean, XElement configElement) {
		String name = configElement.getRequiredAttribute("name");
		String description = configElement.getAttribute("description");
		String type = configElement.getRequiredAttribute("type");
		String backref = configElement.getAttribute("backref");
		String getterVisibility = configElement.getAttribute("getterVisibility", "public");
		String setterVisibility = configElement.getAttribute("setterVisibility", "public");
		SingleProperty singleProperty = new SingleProperty(bean, name, description, type, backref, getterVisibility,
		      setterVisibility);
	}

	private void addMultiProperty(Bean bean, XElement configElement) {
		String name = configElement.getRequiredAttribute("name");
		String description = configElement.getAttribute("description");
		String type = configElement.getRequiredAttribute("type");
		String backref = configElement.getAttribute("backref");
		String getterVisibility = configElement.getAttribute("getterVisibility", "public");
		String setterVisibility = configElement.getAttribute("setterVisibility", "public");
		MultiProperty multiProperty = new MultiProperty(bean, name, description, type, backref, getterVisibility,
		      setterVisibility);
	}
}
