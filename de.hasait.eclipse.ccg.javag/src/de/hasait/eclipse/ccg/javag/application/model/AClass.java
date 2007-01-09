/*
 * $Id: AClass.java,v 1.1 2007-01-09 17:05:18 concentus Exp $
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

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.AbstractCompilationUnit;
import de.hasait.eclipse.ccg.javag.lowlevel.MVisibility;
import de.hasait.eclipse.ccg.javag.util.CodeUtils;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.MapUtil;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 13.12.2006
 */
public class AClass extends AbstractCompilationUnit {
	private final Model _model;

	private final String _name;

	private final String _description;

	private final boolean _abstract;

	private final String _extends;

	private AClass _extendsBean;

	private final String[] _implements;

	private final String _propertyChangeSupportName;

	private boolean _propertyChangeSupportNeeded;

	private final XFile _targetFile;

	private final List _properties = new ArrayList();

	private final Map _propertiesByName = new HashMap();

	private final List _derivedBeans = new ArrayList();

	private final List _validators = new ArrayList();

	private final Map _validatorsByBinding = new HashMap();

	private final List _abstractMethods = new ArrayList();

	/**
	 * Constructor.
	 */
	public AClass(final Model pModel, final XElement pConfigElement) {
		super(pModel, pConfigElement, null, null);

		_model = pModel;

		_name = pConfigElement.getRequiredAttribute("name");
		_description = pConfigElement.getAttribute("description");
		_abstract = pConfigElement.getAttributeAsBoolean("abstract", false);
		_extends = pConfigElement.getAttribute("extends");
		String vImplements = pConfigElement.getAttribute("implements");
		_implements = vImplements == null ? null : vImplements.split(",");

		_propertyChangeSupportName = "_propertyChangeSupport";
		_propertyChangeSupportNeeded = false;
		_targetFile = _model.getTargetFolder().getFile(_name + ".java");

		XElement[] vPropertyElements = pConfigElement.getChildElements("property");
		for (int vPropertyElementsI = 0; vPropertyElementsI < vPropertyElements.length; vPropertyElementsI++) {
			XElement vPropertyElement = vPropertyElements[vPropertyElementsI];
			String vCardinality = vPropertyElement.getAttribute("cardinality");
			AbstractProperty vProperty;
			if (vCardinality == null || vCardinality.equals("1")) {
				vProperty = new SingleProperty(this, vPropertyElement);
			} else if (vCardinality.equals("*")) {
				vProperty = new MultiProperty(this, vPropertyElement);
			} else {
				throw new IllegalArgumentException("cardinality not supported: " + vCardinality);
			}
			_properties.add(vProperty);
			_propertiesByName.put(vProperty.getProperty().getName(), vProperty);
		}

		XElement[] vValidatorElements = pConfigElement.getChildElements("validator");
		for (int vValidatorElementsI = 0; vValidatorElementsI < vValidatorElements.length; vValidatorElementsI++) {
			XElement vValidatorElement = vValidatorElements[vValidatorElementsI];
			String vValidatorExpression = vValidatorElement.getTextContent();
			String vValidatorDescription = vValidatorElement.getRequiredAttribute("description");
			String[] vValidatorBindings = vValidatorElement.getRequiredAttribute("bound").split(";");
			Validator vValidator = new Validator("id" + vValidatorElementsI, vValidatorExpression, vValidatorDescription,
			      vValidatorBindings);
			addValidator(vValidator);
		}

		XElement[] vAbstractMethodElements = pConfigElement.getChildElements("abstractmethod");
		for (int vAbstractMethodElementsI = 0; vAbstractMethodElementsI < vAbstractMethodElements.length; vAbstractMethodElementsI++) {
			XElement vAbstractMethodElement = vAbstractMethodElements[vAbstractMethodElementsI];
			String vName = vAbstractMethodElement.getAttribute("name");
			String vReturnType = vAbstractMethodElement.getAttribute("resulttype");
			String vParameters = vAbstractMethodElement.getAttribute("parameters");
			String[] vParametersArray = vParameters == null ? null : vParameters.split(",");
			AbstractMethod vAbstractMethod = new AbstractMethod(vName, vReturnType, vParametersArray);
			_abstractMethods.add(vAbstractMethod);
		}
	}

	/**
	 * @return The value of property model.
	 */
	public final Model getModel() {
		return _model;
	}

	/**
	 * @return the abstract
	 */
	public final boolean isAbstract() {
		return _abstract;
	}

	/**
	 * @return the extends
	 */
	public final String getExtends() {
		return _extends;
	}

	/**
	 * @return the extendsBean
	 */
	public final AClass getExtendsBean() {
		return _extendsBean;
	}

	/**
	 * @return the implements
	 */
	public final String[] getImplements() {
		return _implements;
	}

	/**
	 * @return the propertyChangeSupportName
	 */
	public final String getPropertyChangeSupportName() {
		return _propertyChangeSupportName;
	}

	/**
	 * @return the propertyChangeSupportNeeded
	 */
	public final boolean isPropertyChangeSupportNeeded() {
		return _propertyChangeSupportNeeded;
	}

	/**
	 * Set propertyChangeSupportNeeded to true.
	 */
	public final void setPropertyChangeSupportNeeded() {
		_propertyChangeSupportNeeded = true;
	}

	/**
	 * @return An {@link java.util.Iterator} for all values of property property.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator propertyIterator() {
		return _properties.iterator();
	}

	/**
	 * @return the derivedBeans
	 */
	public final List getDerivedBeans() {
		return Collections.unmodifiableList(_derivedBeans);
	}

	public final String getFullName() {
		return _model.getPackage() + "." + _name;
	}

	public final String getJavaDocFullName() {
		return "{@link " + getFullName() + "}";
	}

	public final AbstractProperty findProperty(String pName) {
		return (AbstractProperty) _propertiesByName.get(pName);
	}

	public final void addValidator(final Validator pValidator) {
		_validators.add(pValidator);
		String[] vValidatorBindings = pValidator.getBindings();
		for (int vValidatorBindingsI = 0; vValidatorBindingsI < vValidatorBindings.length; vValidatorBindingsI++) {
			String vValidatorBinding = vValidatorBindings[vValidatorBindingsI];
			MapUtil.mapListAdd(_validatorsByBinding, vValidatorBinding, pValidator);
		}
	}

	public final Validator[] getValidators(final String pValidatorBinding) {
		Collection vCollection = (Collection) _validatorsByBinding.get(pValidatorBinding);
		return vCollection == null ? null : (Validator[]) vCollection.toArray(new Validator[vCollection.size()]);
	}

	public final Iterator validatorIterator() {
		return _validators.iterator();
	}

	public final Iterator validatorBindingIterator() {
		return _validatorsByBinding.keySet().iterator();
	}

	static class Validator {
		private final String _name;

		private final String _messageConstantName;

		private final String _expression;

		private final String _description;

		private final String[] _bindings;

		/**
		 * @param pExpression
		 * @param pBindings
		 */
		public Validator(final String pName, final String pExpression, final String pDescription, final String[] pBindings) {
			super();
			_name = pName;
			_expression = pExpression;
			_description = pDescription;
			_bindings = pBindings;

			_messageConstantName = "VALIDATION_MESSAGE_" + StringUtil.camelCaseToUpperCase(_name);
		}

		/**
		 * @return the name
		 */
		public final String getName() {
			return _name;
		}

		/**
		 * @return the messageConstantName
		 */
		public final String getMessageConstantName() {
			return _messageConstantName;
		}

		/**
		 * @return the expression
		 */
		public final String getExpression() {
			return _expression;
		}

		/**
		 * @return the description
		 */
		public final String getDescription() {
			return _description;
		}

		/**
		 * @return the bindings
		 */
		public final String[] getBindings() {
			return _bindings;
		}
	}

	public final void resolve(final IProgressMonitor pMonitor) {
		super.resolve(pMonitor);
		if (_extends != null) {
			_extendsBean = (AClass) _model.findCompilationUnitByName(_extends);
			if (_extendsBean != null) {
				_extendsBean._derivedBeans.add(this);
			}
		}
		for (Iterator propertyI = _properties.iterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.resolve(pMonitor);
		}
		for (Iterator vValidatorI = validatorIterator(); vValidatorI.hasNext();) {
			Validator vValidator = (Validator) vValidatorI.next();
			String[] vValidatorBindings = vValidator.getBindings();
			for (int vValidatorBindingI = 0; vValidatorBindingI < vValidatorBindings.length; vValidatorBindingI++) {
				String vValidatorBinding = vValidatorBindings[vValidatorBindingI];
				AbstractProperty vValidatorBindingProperty = findProperty(vValidatorBinding);
				if (vValidatorBindingProperty == null) {
					throw new IllegalArgumentException("invalid validatorBinding " + vValidatorBinding + " for "
					      + vValidator.getDescription());
				}
				vValidatorBindingProperty.getProperty().addAfterChangeCode("//TODO validator");
			}
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		super.validate(pMonitor);
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.validate(pMonitor);
		}
	}

	protected void writeAdditionalCuComment(ContentBuffer pContent, IProgressMonitor pMonitor) {
		super.writeAdditionalCuComment(pContent, pMonitor);
		if (!getDerivedBeans().isEmpty()) {
			pContent.pi("Subclasses are:<ul>");
			for (Iterator subBeansI = getDerivedBeans().iterator(); subBeansI.hasNext();) {
				AClass subBean = (AClass) subBeansI.next();
				pContent.p("<li>" + subBean.getJavaDocFullName() + "</li>");
			}
			pContent.pu("</ul>");
		}
	}

	protected void writeCompilationUnits(final ContentBuffer pContent, final Map pUserBlockByName,
	      final IProgressMonitor pMonitor) {
		pContent.a(MVisibility.PUBLIC.getId()).a(" ");
		if (isAbstract()) {
			pContent.a("abstract ");
		}
		pContent.a("class ").a(getName()).a(" ");
		if (getExtends() != null) {
			pContent.a("extends ").a(getExtends()).a(" ");
		}
		String[] vImplements = getImplements();
		if (vImplements != null && vImplements.length > 0) {
			pContent.a("implements ");
			for (int vImplementsI = 0; vImplementsI < vImplements.length; vImplementsI++) {
				if (vImplementsI > 0) {
					pContent.a(", ");
				}
				pContent.a(vImplements[vImplementsI]);
			}
			pContent.a(" ");
		}
		pContent.pi("{");
		//
		writeUserContent(pContent, pUserBlockByName, "ClassBegin");
		pContent.p();
		// property constants
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeConstants(pContent, pMonitor);
		}
		// validation message constants
		for (Iterator vValidatorI = validatorIterator(); vValidatorI.hasNext();) {
			Validator vValidator = (Validator) vValidatorI.next();
			pContent.a("public static final String ").a(vValidator.getMessageConstantName()).a(" = ").a("\"").a(
			      vValidator.getDescription()).a("\"").p(";");
		}
		pContent.p();
		// property change support field
		if (isPropertyChangeSupportNeeded()) {
			pContent.p(PropertyChangeSupport.class.getName() + " " + getPropertyChangeSupportName() + " = new "
			      + PropertyChangeSupport.class.getName() + "(this);");
		}
		// validation field
		if (!_validators.isEmpty()) {
			pContent.p("private final " + Set.class.getName() + " _validationMessages = new " + HashSet.class.getName()
			      + "();");
		}
		// property fields
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeFields(pContent, pMonitor);
		}
		// constructor
		pContent.a(MVisibility.PUBLIC.getId()).a(" ").a(getName()).a("(");
		boolean vFirstConstructorArgument = true;
		if (getExtendsBean() != null) {
			for (Iterator propertyI = getExtendsBean().propertyIterator(); propertyI.hasNext();) {
				AbstractProperty property = (AbstractProperty) propertyI.next();
				String vConstructorArguments = property.getProperty().getConstructorArguments();
				if (vConstructorArguments != null) {
					if (vFirstConstructorArgument) {
						vFirstConstructorArgument = false;
					} else {
						pContent.a(", ");
					}
					pContent.a(vConstructorArguments);
				}
			}
		}
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			String vConstructorArguments = property.getProperty().getConstructorArguments();
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
		pContent.a("super(");
		vFirstConstructorArgument = true;
		if (getExtendsBean() != null) {
			for (Iterator propertyI = getExtendsBean().propertyIterator(); propertyI.hasNext();) {
				AbstractProperty property = (AbstractProperty) propertyI.next();
				String vConstructorArguments = property.getProperty().getConstructorArguments();
				if (vConstructorArguments != null) {
					if (vFirstConstructorArgument) {
						vFirstConstructorArgument = false;
					} else {
						pContent.a(", ");
					}
					pContent.a(property.getProperty().getParameterVarName());
				}
			}
		}
		pContent.p(");");
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.getProperty().writeConstructorBody(pContent);
		}
		for (Iterator vValidatorBindingI = validatorBindingIterator(); vValidatorBindingI.hasNext();) {
			String vValidatorBinding = (String) vValidatorBindingI.next();
			pContent.a("validate").a(vValidatorBinding).a("()").p(";");
		}
		pContent.pu("}");
		pContent.p();
		//
		writeUserContent(pContent, pUserBlockByName, "ClassAfterConstructor");
		pContent.p();
		// abstract methods
		for (Iterator vAbstractMethodsI = _abstractMethods.iterator(); vAbstractMethodsI.hasNext();) {
			AbstractMethod vAbstractMethod = (AbstractMethod) vAbstractMethodsI.next();
			vAbstractMethod.write(pContent);
			pContent.p();
		}
		// property methods
		for (Iterator propertyI = propertyIterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeMethods(pContent, pMonitor);
		}
		// property change support
		if (isPropertyChangeSupportNeeded()) {
			CodeUtils.writeDelegation(pContent, getPropertyChangeSupportName(), PropertyChangeSupport.class,
			      "addProp.*|removeProp.*", "", true);
		}
		// validator methods
		for (Iterator vValidatorBindingI = validatorBindingIterator(); vValidatorBindingI.hasNext();) {
			String vValidatorBinding = (String) vValidatorBindingI.next();
			pContent.a("public final boolean ").a("validate").a(vValidatorBinding).a("()").pi(" {");
			Validator[] vValidators = getValidators(vValidatorBinding);
			for (int vValidatorI = 0; vValidatorI < vValidators.length; vValidatorI++) {
				Validator vValidator = vValidators[vValidatorI];
				pContent.a("if (").a(vValidator.getExpression()).pi(") {");
				pContent.a("_validationMessages.remove(").a(vValidator.getMessageConstantName()).p(");");
				pContent.pui("} else {");
				pContent.a("_validationMessages.add(").a(vValidator.getMessageConstantName()).p(");");
				pContent.pu("}");
			}
			pContent.p("return _validationMessages.isEmpty();");
			pContent.pu("}");
			pContent.p();
		}
		writeUserContent(pContent, pUserBlockByName, "ClassEnd");
		pContent.pu("}");
	}

	static class AbstractMethod {
		private final String _name;

		private final String _returnType;

		private final String[] _parameters;

		/**
		 * @param pName
		 * @param pReturnType
		 * @param pParameters
		 */
		public AbstractMethod(final String pName, final String pReturnType, final String[] pParameters) {
			super();
			_name = pName;
			_returnType = pReturnType;
			_parameters = pParameters;
		}

		/**
		 * @return the name
		 */
		public final String getName() {
			return _name;
		}

		/**
		 * @return the parameters
		 */
		public final String[] getParameters() {
			return _parameters;
		}

		/**
		 * @return the returnType
		 */
		public final String getReturnType() {
			return _returnType;
		}

		public final void write(final ContentBuffer pContent) {
			pContent.a("public abstract ").a(_returnType).a(" ").a(_name).a("(");
			if (_parameters != null && _parameters.length > 0) {
				for (int vParametersI = 0; vParametersI < _parameters.length; vParametersI++) {
					if (vParametersI > 0) {
						pContent.a(", ");
					}
					pContent.a(_parameters[vParametersI]);
				}
			}
			pContent.a(")").p(";");
		}
	}
}
