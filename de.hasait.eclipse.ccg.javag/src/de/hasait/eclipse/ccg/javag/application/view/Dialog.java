/*
 * $Id: Dialog.java,v 1.7 2007-08-09 14:20:18 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.AbstractCompilationUnit;
import de.hasait.eclipse.ccg.javag.lowlevel.AbstractMProperty;
import de.hasait.eclipse.ccg.javag.lowlevel.MSingleProperty;
import de.hasait.eclipse.ccg.javag.lowlevel.MVisibility;
import de.hasait.eclipse.ccg.javag.util.CodeUtils;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.xml.XElement;

/**
 * <code>
 * Parameters:
 * - Konto konto
 * - String foo
 * 
 * PresentationModel:
 * - boolean fooEnabled
 * 
 * Actions (landen im PresentationModel):
 * - commit, revert
 * - bla
 * 
 * Components:
 * - label
 * - textfield
 * - textarea
 * - datefield
 * - numberfield
 * - button
 * 
 * Constructor:
 * - each parameter as argument
 * - controller with action-methods (if user-defined actions)
 *   controller is an abstract class defined inside dialog 
 * </code>
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.7 $
 * @since 13.12.2006
 */
public class Dialog extends AbstractCompilationUnit {
	private final View _view;

	private final List _presentationModelProperties = new ArrayList();

	private final List _presentationModelActions = new ArrayList();

	private final List _components = new ArrayList();

	/**
	 * Constructor.
	 */
	public Dialog(final View pView, final XElement pConfigElement) {
		super(pView, pConfigElement, null, "Dialog");

		_view = pView;

		XElement[] vPresentationModelPropertyElements = pConfigElement.getChildElements("presentationmodel/property");
		for (int vPresentationModelPropertyElementsI = 0; vPresentationModelPropertyElementsI < vPresentationModelPropertyElements.length; vPresentationModelPropertyElementsI++) {
			XElement vPresentationModelPropertyElement = vPresentationModelPropertyElements[vPresentationModelPropertyElementsI];
			MSingleProperty vPresentationModelProperty = new MSingleProperty();
			vPresentationModelProperty.setFinal(vPresentationModelPropertyElement.getBooleanAttribute("final", false));
			vPresentationModelProperty.setRequired(vPresentationModelPropertyElement.getBooleanAttribute("required",
			      false));
			vPresentationModelProperty.setType(vPresentationModelPropertyElement.getRequiredStringAttribute("type"));
			vPresentationModelProperty.setName(vPresentationModelPropertyElement.getRequiredStringAttribute("name"));
			vPresentationModelProperty.setInitialValue(vPresentationModelPropertyElement.getStringAttribute("value"));
			vPresentationModelProperty.setBound(true);
			_presentationModelProperties.add(vPresentationModelProperty);
		}

		XElement[] vPresentationModelActionElements = pConfigElement.getChildElements("presentationmodel/action");
		for (int vPresentationModelActionElementsI = 0; vPresentationModelActionElementsI < vPresentationModelActionElements.length; vPresentationModelActionElementsI++) {
			XElement vPresentationModelActionElement = vPresentationModelActionElements[vPresentationModelActionElementsI];
			String vActionName = vPresentationModelActionElement.getRequiredStringAttribute("name");
			PresentationModelAction vAction = new PresentationModelAction(vActionName);
			_presentationModelActions.add(vAction);
		}
	}

	/**
	 * @return The value of property view.
	 */
	public final View getView() {
		return _view;
	}

	protected void writeTypes(final ContentBuffer pContent, final Map pUserBlockContentByName,
	      final IProgressMonitor pMonitor) {
		pContent.a("public ");
		pContent.a("class " + getName() + " ");
		pContent.a("extends " + JPanel.class.getName() + " ");
		pContent.pi("{");
		//
		CodeUtils.writeUserBlock(pContent, pUserBlockContentByName, "DialogBegin");
		// presentation model field
		pContent.p("// presentation model field");
		pContent.p("private final PresentationModel _presentationModel;");
		pContent.p();
		// constructor
		pContent.a("public ").a(getName()).a("(");
		pContent.a("final PresentationModel pPresentationModel");
		pContent.pi(") {");
		// constructor body
		pContent.p("super();");
		pContent.p("_presentationModel = pPresentationModel;");
		pContent.up("}");
		pContent.p();
		// modelToUi
		pContent.pi("public final void presentationModelToUi() {");
		pContent.up("}");
		pContent.p();
		// uiToModel
		pContent.pi("public final void uiToPresentationModel() {");
		pContent.up("}");
		pContent.p();
		// write abstract presentation model class
		pContent.a("public ");
		pContent.a("abstract ");
		pContent.pi("static class PresentationModel {");
		// presentation model constants
		pContent.p("// presentation model fields");
		for (Iterator vPresentationModelPropertiesI = _presentationModelProperties.iterator(); vPresentationModelPropertiesI
		      .hasNext();) {
			AbstractMProperty vPresentationModelProperty = (AbstractMProperty) vPresentationModelPropertiesI.next();
			vPresentationModelProperty.writeConstants(pContent, pMonitor);
		}
		pContent.p();
		// presentation model fields
		pContent.p("// presentation model fields");
		for (Iterator vPresentationModelPropertiesI = _presentationModelProperties.iterator(); vPresentationModelPropertiesI
		      .hasNext();) {
			AbstractMProperty vPresentationModelProperty = (AbstractMProperty) vPresentationModelPropertiesI.next();
			vPresentationModelProperty.writeFields(pContent, pMonitor);
		}
		pContent.p();
		// presentation model constructor
		pContent.a(MVisibility.PUBLIC.getId()).a(" ").a("PresentationModel").a("(");
		boolean vFirstConstructorArgument = true;
		for (Iterator vPresentationModelPropertiesI = _presentationModelProperties.iterator(); vPresentationModelPropertiesI
		      .hasNext();) {
			AbstractMProperty vPresentationModelProperty = (AbstractMProperty) vPresentationModelPropertiesI.next();
			String vConstructorArguments = vPresentationModelProperty.getConstructorArguments();
			if (vConstructorArguments != null) {
				if (vFirstConstructorArgument) {
					vFirstConstructorArgument = false;
				} else {
					pContent.a(", ");
				}
				pContent.a(vConstructorArguments);
			}
		}
		pContent.pi(") {");
		pContent.p("super();");
		for (Iterator vPresentationModelPropertiesI = _presentationModelProperties.iterator(); vPresentationModelPropertiesI
		      .hasNext();) {
			AbstractMProperty vPresentationModelProperty = (AbstractMProperty) vPresentationModelPropertiesI.next();
			vPresentationModelProperty.writeConstructorBody(pContent);
		}
		pContent.up("}");
		pContent.p();
		// presentation model field accessors
		for (Iterator vPresentationModelPropertiesI = _presentationModelProperties.iterator(); vPresentationModelPropertiesI
		      .hasNext();) {
			AbstractMProperty vPresentationModelProperty = (AbstractMProperty) vPresentationModelPropertiesI.next();
			vPresentationModelProperty.writeMethods(pContent, pUserBlockContentByName, pMonitor);
		}
		pContent.p();
		// presentation model actions
		for (Iterator vPresentationModelActionsI = _presentationModelActions.iterator(); vPresentationModelActionsI
		      .hasNext();) {
			PresentationModelAction vPresentationModelAction = (PresentationModelAction) vPresentationModelActionsI.next();
			pContent.p("public abstract void " + vPresentationModelAction.getName() + "();");
			pContent.p();
		}
		pContent.up("}");
		//
		CodeUtils.writeUserBlock(pContent, pUserBlockContentByName, "DialogEnd");
		pContent.up("}");
	}

	private static class PresentationModelAction {
		private final String _name;

		/**
		 * @param pName
		 */
		public PresentationModelAction(final String pName) {
			super();
			_name = pName;
		}

		/**
		 * @return the name
		 */
		public final String getName() {
			return _name;
		}
	}

	private static class Component {

	}
}
