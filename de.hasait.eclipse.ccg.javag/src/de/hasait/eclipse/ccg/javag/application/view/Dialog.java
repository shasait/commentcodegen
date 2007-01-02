/*
 * $Id: Dialog.java,v 1.2 2007-01-02 18:54:56 concentus Exp $
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

import javax.swing.JPanel;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * <code>
 * Parameters:
 * - Konto konto
 * - String foo
 * 
 * State:
 * predefined: boolean valid
 * 
 * Actions:
 * predefined: commit, revert
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
 * @version $Revision: 1.2 $
 * @since 13.12.2006
 */
public class Dialog {
	private final View _view;

	private final String _name;

	private final String _description;

	private final XFile _targetFile;

	private final List _parameters = new ArrayList();

	private final List _states = new ArrayList();

	private final List _actions = new ArrayList();

	private final List _components = new ArrayList();

	/**
	 * Constructor.
	 */
	public Dialog(final View pView, final XElement pConfigElement) {
		super();

		_view = pView;

		_name = pConfigElement.getRequiredAttribute("name") + "Dialog";
		_description = pConfigElement.getAttribute("description");

		_targetFile = _view.getTargetFolder().getFile(_name + ".java");

		XElement[] vParameterElements = pConfigElement.getChildElements("parameters/parameter");
		for (int vParameterElementsI = 0; vParameterElementsI < vParameterElements.length; vParameterElementsI++) {
			XElement vParameterElement = vParameterElements[vParameterElementsI];
			String vParameterType = vParameterElement.getRequiredAttribute("type");
			String vParameterName = vParameterElement.getRequiredAttribute("name");
			Parameter vParameter = new Parameter(vParameterType, vParameterName);
			_parameters.add(vParameter);
		}

		XElement[] vStateElements = pConfigElement.getChildElements("states/state");
		for (int vStateElementsI = 0; vStateElementsI < vStateElements.length; vStateElementsI++) {
			XElement vStateElement = vStateElements[vStateElementsI];
			String vStateType = vStateElement.getRequiredAttribute("type");
			String vStateName = vStateElement.getRequiredAttribute("name");
			String vStateValue = vStateElement.getRequiredAttribute("value");
			State vState = new State(vStateType, vStateName, vStateValue);
			_states.add(vState);
		}

		XElement[] vActionElements = pConfigElement.getChildElements("actions/action");
		for (int vActionElementsI = 0; vActionElementsI < vActionElements.length; vActionElementsI++) {
			XElement vActionElement = vActionElements[vActionElementsI];
			String vActionName = vActionElement.getRequiredAttribute("name");
			Action vAction = new Action(vActionName);
			_actions.add(vAction);
		}
	}

	/**
	 * @return The value of property view.
	 */
	public final View getView() {
		return _view;
	}

	/**
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return _description;
	}

	public final String getFullName() {
		return _view.getPackage() + "." + _name;
	}

	/**
	 * @return the targetFile
	 */
	public final XFile getTargetFile() {
		return _targetFile;
	}

	public final void resolve(final IProgressMonitor pMonitor) {
	}

	public final void validate(final IProgressMonitor pMonitor) {
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write Dialog " + getName());
		pMonitor.subTask("write Bean " + getFullName());
		ContentBuffer content = new ContentBuffer();
		content.p("package " + getView().getPackage() + ";");
		content.p();
		content.pi("/**", " * ");
		if (getDescription() != null) {
			content.p(getDescription());
			content.p();
		}
		content.p("@author CommentCodeGen " + getView().getApplication().getSourceFile().getFullPath().toString());
		content.pu(" */");
		content.a("public ");
		content.a("class " + getName() + " ");
		content.a("extends " + JPanel.class.getName() + " ");
		content.pi("{");
		// parameter fields
		content.p("// parameter fields");
		for (Iterator vParametersI = _parameters.iterator(); vParametersI.hasNext();) {
			Parameter vParameter = (Parameter) vParametersI.next();
			content.a("private final ");
			content.a(vParameter.getType()).a(" ");
			content.a(vParameter.getFieldName());
			content.p(";");
		}
		// state fields
		content.p("// state fields");
		for (Iterator vStatesI = _states.iterator(); vStatesI.hasNext();) {
			State vState = (State) vStatesI.next();
			content.a("private final ");
			content.a(vState.getType()).a(" ");
			content.a(vState.getFieldName());
			content.p(";");
		}
		// controller field
		content.p("// controller fields");
		if (_actions.isEmpty()) {
			content.p("private final Controller _controller = new Controller();");
		} else {
			content.p("private final Controller _controller;");
		}
		content.p();
		// constructor
		content.a("public ").a(getName()).a("(");
		for (Iterator vParametersI = _parameters.iterator(); vParametersI.hasNext();) {
			Parameter vParameter = (Parameter) vParametersI.next();
			content.a("final ");
			content.a(vParameter.getType()).a(" ");
			content.a(vParameter.getParameterVarName());
			if (vParametersI.hasNext()) {
				content.a(", ");
			}
		}
		if (!_actions.isEmpty()) {
			if (!_parameters.isEmpty()) {
				content.a(", ");
			}
			content.a("final Controller pController");
		}
		content.pi(") {");
		// constructor body
		content.p("super();");
		content.p("// store parameters");
		for (Iterator vParametersI = _parameters.iterator(); vParametersI.hasNext();) {
			Parameter vParameter = (Parameter) vParametersI.next();
			content.a(vParameter.getFieldName());
			content.a(" = ");
			content.a(vParameter.getParameterVarName());
			content.p(";");
		}
		if (!_actions.isEmpty()) {
			content.p("_controller = pController;");
		}
		content.p("// init states");
		for (Iterator vStatesI = _states.iterator(); vStatesI.hasNext();) {
			State vState = (State) vStatesI.next();
			content.a(vState.getFieldName());
			content.a(" = ");
			content.a(vState.getValue());
			content.p(";");
		}
		content.pu("}");
		content.p();
		// modelToUi
		content.pi("public final void modelToUi() {");
		content.pu("}");
		content.p();
		// uiToModel
		content.pi("public final void uiToModel() {");
		content.pu("}");
		content.p();
		// write [abstract] controller class
		content.a("public ");
		if (!_actions.isEmpty()) {
			content.a("abstract ");
		}
		content.pi("static class Controller {");
		content.pi("public final void commit(final " + getName() + " pDialog) {");
		content.p("pDialog.uiToModel();");
		content.pu("}");
		content.p();
		content.pi("public final void revert(final " + getName() + " pDialog) {");
		content.p("pDialog.modelToUi();");
		content.pu("}");
		content.p();
		for (Iterator vActionsI = _actions.iterator(); vActionsI.hasNext();) {
			Action vAction = (Action) vActionsI.next();
			content.p("public abstract void " + vAction.getName() + "(final " + getName() + " pDialog);");
			content.p();
		}
		content.pu("}");
		//
		content.pu("}");
		getTargetFile().write(content.getContent(), Boolean.TRUE, pMonitor);
	}

	private static class Parameter {
		private final String _type;

		private final String _name;

		private final String _capName;

		private final String _fieldName;

		private final String _parameterVarName;

		/**
		 * @param pType
		 * @param pName
		 */
		public Parameter(final String pType, final String pName) {
			super();
			_type = pType;
			_name = pName;
			_capName = StringUtil.capitalize(_name);
			_fieldName = "_" + _name;
			_parameterVarName = "p" + _capName;
		}

		/**
		 * @return the type
		 */
		public final String getType() {
			return _type;
		}

		/**
		 * @return the name
		 */
		public final String getName() {
			return _name;
		}

		/**
		 * @return the capName
		 */
		public final String getCapName() {
			return _capName;
		}

		/**
		 * @return the fieldName
		 */
		public final String getFieldName() {
			return _fieldName;
		}

		/**
		 * @return the parameterVarName
		 */
		public final String getParameterVarName() {
			return _parameterVarName;
		}
	}

	private static class State {
		private final String _type;

		private final String _name;

		private final String _value;

		private final String _capName;

		private final String _fieldName;

		private final String _parameterVarName;

		/**
		 * @param pType
		 * @param pName
		 */
		public State(final String pType, final String pName, final String pValue) {
			super();
			_type = pType;
			_name = pName;
			_value = pValue;
			_capName = StringUtil.capitalize(_name);
			_fieldName = "_" + _name;
			_parameterVarName = "p" + _capName;
		}

		/**
		 * @return the type
		 */
		public final String getType() {
			return _type;
		}

		/**
		 * @return the name
		 */
		public final String getName() {
			return _name;
		}

		/**
		 * @return the value
		 */
		public final String getValue() {
			return _value;
		}

		/**
		 * @return the capName
		 */
		public final String getCapName() {
			return _capName;
		}

		/**
		 * @return the fieldName
		 */
		public final String getFieldName() {
			return _fieldName;
		}

		/**
		 * @return the parameterVarName
		 */
		public final String getParameterVarName() {
			return _parameterVarName;
		}
	}

	private static class Action {
		private final String _name;

		/**
		 * @param pName
		 */
		public Action(final String pName) {
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
