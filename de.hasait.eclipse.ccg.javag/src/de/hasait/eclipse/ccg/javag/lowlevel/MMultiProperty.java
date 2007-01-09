/*
 * $Id: MMultiProperty.java,v 1.2 2007-01-09 17:05:17 concentus Exp $
 * 
 * Copyright 2007 Sebastian Hasait
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

package de.hasait.eclipse.ccg.javag.lowlevel;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.util.CodeUtils;
import de.hasait.eclipse.common.ContentBuffer;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 04.01.2007
 */
public class MMultiProperty extends AbstractMProperty {
	private String _addMethodName;

	private String _removeMethodName;

	private Class _collectionClass;

	private Class _collectionImplClass;

	/**
	 * @return the collectionImplClass
	 */
	public final Class getCollectionImplClass() {
		return _collectionImplClass;
	}

	/**
	 * @param pCollectionImplClass
	 *           the collectionImplClass to set
	 */
	public final void setCollectionImplClass(Class pCollectionImplClass) {
		_collectionImplClass = pCollectionImplClass;
	}

	/**
	 * @return the removeMethodName
	 */
	public final String getRemoveMethodName() {
		return _removeMethodName;
	}

	/**
	 * @return the addMethodName
	 */
	public final String getAddMethodName() {
		return _addMethodName;
	}

	/**
	 * @param pCollectionClass
	 *           the collectionClass to set
	 */
	public final void setCollectionClass(Class pCollectionClass) {
		_collectionClass = pCollectionClass;
	}

	/**
	 * @return the collectionClass
	 */
	public final Class getCollectionClass() {
		return _collectionClass;
	}

	public void setName(String pName) {
		super.setName(pName);
		updateMethodNames();
	}

	private void updateMethodNames() {
		_addMethodName = "add" + getCapName();
		_removeMethodName = "remove" + getCapName();
	}

	public final String getAdderCall(String instance, String value) {
		return instance + "." + getAddMethodName() + "(" + value + ")";
	}

	public final String getRemoverCall(String instance, String value) {
		return instance + "." + getRemoveMethodName() + "(" + value + ")";
	}

	public final String getContainsCall(String pThisVarName, String pContainsVarName) {
		return pThisVarName + ".contains" + getCapName() + "(" + pContainsVarName + ")";
	}

	public final String getConstructorArguments() {
		if ((isFinal() || isRequired()) && getInitialValue() == null) {
			return "final " + getType() + "[] " + getParameterVarName();
		}
		return null;
	}

	public final void writeConstructorBody(ContentBuffer pContent) {
		if ((isFinal() || isRequired()) && getInitialValue() == null) {
			pContent.a("if (").a(getParameterVarName()).a(" != ").a("null").a(")").pi(" {");
			String indexVarName = getLocalVarName() + "I";
			pContent.a("for (").a("int ").a(indexVarName).a(" = ").a("0").a("; ").a(indexVarName).a(" < ").a(
			      getParameterVarName()).a(".").a("length").a("; ").a(indexVarName).a("++").a(")").pi(" {");
			pContent.a(getFieldName()).a(".").a("add(").a(getParameterVarName()).a("[").a(indexVarName).a("]").a(")").p(
			      ";");
			pContent.pu("}");
			pContent.pu("}");
		}
		if (isRequired()) {
			writeRequiredCheck(pContent);
		}
	}

	public void writeFields(ContentBuffer content, IProgressMonitor monitor) {
		super.writeFields(content, monitor);
		CodeUtils.writeFinalField(content, getFieldName(), getCollectionClass(), getCollectionImplClass(),
		      getInitialValue());
		content.p();
	}

	public void writeMethods(final ContentBuffer pContent, final IProgressMonitor pMonitor) {
		super.writeMethods(pContent, pMonitor);
		writeMultiGetter(pContent);
		writeMultiContains(pContent);
		writeMultiIterator(pContent);
		writeMultiSize(pContent);
		if (!isFinal()) {
			writeMultiAdder(pContent);
			if (getBackrefProperty() == null || !getBackrefProperty().isFinal()) {
				writeMultiRemover(pContent);
			}
		}
		pContent.p();
	}

	/**
	 * @param pContent
	 */
	private void writeMultiRemover(final ContentBuffer pContent) {
		//
		// remover
		//
		pContent.pi("/**", " * ");
		pContent.p("Remove the specified value of property " + getName() + ".");
		if (getBackrefProperty() != null) {
			pContent.p("Referred from " + getBackrefProperty().getJavaDocFullName()
			      + ", which will be updated by this method.");
		}
		if (getDescription() != null) {
			pContent.p();
			pContent.p(getDescription());
		}
		pContent.p();
		pContent.p("@param " + getParameterVarName() + " The value to remove from property " + getName() + ".");
		pContent.p("@see " + getCollectionClass().getName() + "#remove(Object)");
		pContent.pu(" */");

		pContent.pi(getSetterVisibility().getId() + " final void " + getRemoveMethodName() + "(final " + getType() + " "
		      + getParameterVarName() + ") {");
		pContent.pi("if (!" + getFieldName() + ".contains(" + getParameterVarName() + ")) {");
		pContent.p("return;");
		pContent.pu("}");
		if (isRequired()) {
			writeRequiredCheckPreRemove(pContent);
		}
		pContent.p(getFieldName() + ".remove(" + getParameterVarName() + ");");
		if (getBackrefProperty() != null) {
			pContent.pi("if (" + getBackrefProperty().getContainsCall(getParameterVarName(), "this") + ") {");
			pContent.p(getBackrefProperty().getRemoverCall(getParameterVarName(), "this") + ";");
			pContent.pu("}");
		}
		if (isBound()) {
			pContent.p("// fire change event");
			pContent.p(getPropertyChangeSupportName() + ".firePropertyChange(" + getNameConstantName() + ", "
			      + getParameterVarName() + ", " + "null" + ");");
		}
		pContent.pu("}");
	}

	/**
	 * @param pContent
	 */
	private void writeMultiAdder(final ContentBuffer pContent) {
		//
		// adder
		//
		pContent.pi("/**", " * ");
		pContent.p("Add the specified value to property " + getName() + ".");
		if (getBackrefProperty() != null) {
			pContent.p("Referred from " + getBackrefProperty().getJavaDocFullName()
			      + ", which will be updated by this method.");
		}
		if (getDescription() != null) {
			pContent.p();
			pContent.p(getDescription());
		}
		pContent.p();
		pContent.p("@param " + getParameterVarName() + " The additional value for property " + getName() + ".");
		pContent.p("@see " + getCollectionClass().getName() + "#add(Object)");
		pContent.pu(" */");

		pContent.pi(getSetterVisibility().getId() + " final void " + getAddMethodName() + "(final " + getType() + " "
		      + getParameterVarName() + ") {");
		pContent.pi("if (" + getFieldName() + ".contains(" + getParameterVarName() + ")) {");
		pContent.p("return;");
		pContent.pu("}");
		if (getBackrefProperty() != null && getBackrefProperty().isFinal()) {
			pContent.pi("if (!(" + getBackrefProperty().getContainsCall(getParameterVarName(), "this") + ")) {");
			pContent.p("throw new IllegalArgumentException(\"backref != this\");");
			pContent.pu("}");
		}
		pContent.p(getFieldName() + ".add(" + getParameterVarName() + ");");
		if (getBackrefProperty() != null && !getBackrefProperty().isFinal()) {
			pContent.pi("if (!(" + getBackrefProperty().getContainsCall(getParameterVarName(), "this") + ")) {");
			pContent.p(getBackrefProperty().getAdderCall(getParameterVarName(), "this") + ";");
			pContent.pu("}");
		}
		if (isBound()) {
			pContent.p("// fire change event");
			pContent.p(getPropertyChangeSupportName() + ".firePropertyChange(" + getNameConstantName() + ", " + "null"
			      + ", " + getParameterVarName() + ");");
		}
		pContent.pu("}");

		pContent.p();
	}

	/**
	 * @param pContent
	 */
	private void writeMultiSize(final ContentBuffer pContent) {
		//
		// size
		//
		pContent.pi("/**", " * ");
		pContent.p("@return The number of values of property " + getName() + ".");
		pContent.p("@see " + getCollectionClass().getName() + "#size()");
		pContent.pu(" */");

		pContent.pi(getGetterVisibility().getId() + " final int " + getName() + "Size() {");
		pContent.p("return " + getFieldName() + ".size();");
		pContent.pu("}");

		pContent.p();
	}

	/**
	 * @param pContent
	 */
	private void writeMultiIterator(final ContentBuffer pContent) {
		//
		// iterator
		//
		pContent.pi("/**", " * ");
		pContent.p("@return An {@link " + Iterator.class.getName() + "} over all values of property " + getName() + ".");
		pContent.p("@see " + getCollectionClass().getName() + "#iterator()");
		pContent.pu(" */");

		pContent.pi(getGetterVisibility().getId() + " final " + Iterator.class.getName() + " " + getName()
		      + "Iterator() {");
		pContent.p("return " + getFieldName() + ".iterator();");
		pContent.pu("}");

		pContent.p();
	}

	/**
	 * @param pContent
	 */
	private void writeMultiContains(final ContentBuffer pContent) {
		//
		// contains
		//
		pContent.pi("/**", " * ");
		pContent.p("@param pObject The object to check for containment.");
		pContent.p("@return Does this property contain the specified object?");
		pContent.p("@see " + getCollectionClass().getName() + "#contains(Object)");
		pContent.pu(" */");

		pContent.pi(getGetterVisibility().getId() + " final boolean contains" + getCapName() + "(Object pObject) {");
		pContent.p("return " + getFieldName() + ".contains(pObject);");
		pContent.pu("}");

		pContent.p();
	}

	/**
	 * @param pContent
	 */
	private void writeMultiGetter(final ContentBuffer pContent) {
		//
		// getter
		//
		pContent.pi("/**", " * ");
		pContent.p("Returns the value of property " + getName() + " at the specified index.");
		if (getDescription() != null) {
			pContent.p();
			pContent.p(getDescription());
		}
		pContent.p();
		pContent.p("@param index The index, which must be valid.");
		pContent.p("@return The value of property " + getName() + " at the specified index.");
		pContent.p("@see " + getCollectionClass().getName() + "#get(int)");
		pContent.pu(" */");

		pContent.pi(getGetterVisibility().getId() + " final " + getType() + " get" + getCapName() + "(int index) {");
		pContent.p("return (" + getType() + ") " + getFieldName() + ".get(index);");
		pContent.pu("}");

		pContent.p();
	}

	private void writeRequiredCheck(final ContentBuffer pContent) {
		String vCheck = getFieldName() + "." + "isEmpty()";
		pContent.a("if (").a(vCheck).a(")").pi(" {");
		pContent.p("throw new IllegalArgumentException(\"" + vCheck + "\");");
		pContent.pu("}");
	}

	private void writeRequiredCheckPreRemove(final ContentBuffer pContent) {
		String vCheck = getFieldName() + "." + "size()" + " <= " + "1";
		pContent.a("if (").a(vCheck).a(")").pi(" {");
		pContent.p("throw new IllegalArgumentException(\"" + vCheck + "\");");
		pContent.pu("}");
	}
}
