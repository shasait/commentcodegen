/*
 * $Id: MSingleProperty.java,v 1.6 2007-08-09 14:20:19 concentus Exp $
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

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.ObjectUtil;
import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.6 $
 * @since 04.01.2007
 */
public class MSingleProperty extends AbstractMProperty {
	private String _getMethodName;

	private String _setMethodName;

	public MSingleProperty() {
		super();
	}

	public void setName(String pName) {
		super.setName(pName);
		updateMethodNames();
	}

	public void setType(String pType) {
		super.setType(pType);
		updateMethodNames();
	}

	private void updateMethodNames() {
		if (ObjectUtil.equals(getType(), "boolean")) {
			_getMethodName = "is" + getCapName();
		} else {
			_getMethodName = "get" + getCapName();
		}
		_setMethodName = "set" + getCapName();
	}

	/**
	 * @return the getMethodName
	 */
	public final String getGetMethodName() {
		return _getMethodName;
	}

	/**
	 * @return the setMethodName
	 */
	public final String getSetMethodName() {
		return _setMethodName;
	}

	public String getAdderCall(final String pInstance, final String pValue) {
		return (pInstance == null ? "" : pInstance + ".") + getSetMethodName() + "(" + pValue + ")";
	}

	public String getRemoverCall(final String pInstance, final String pValue) {
		return (pInstance == null ? "" : pInstance + ".") + getSetMethodName() + "(" + "null" + ")";
	}

	public String getGetCall(final String pInstance) {
		return (pInstance == null ? "" : pInstance + ".") + getGetMethodName() + "()";
	}

	public String getContainsCall(String pInstance, String pContainsVarName) {
		return getGetCall(pInstance) + " == " + pContainsVarName;
	}

	public final String getConstructorArguments() {
		if ((isRequired() || isFinal()) && getInitialValue() == null) {
			return getArgumentDeclaration();
		}
		return null;
	}

	public final void writeConstructorBody(ContentBuffer pContent) {
		if (isRequired()) {
			if (getInitialValue() == null) {
				writeRequiredCheck(pContent, getParameterVarName());
			} else {
				pContent.a(getFieldName()).a(" = ").a(getInitialValue()).p(";");
				writeRequiredCheck(pContent, getFieldName());
			}
		}
		if ((isRequired() || isFinal()) && getInitialValue() == null) {
			pContent.a(getFieldName()).a(" = ").a(getParameterVarName()).p(";");
			if (getBackrefProperty() != null) {
				pContent.pi("if (" + getFieldName() + " != null) {");
				pContent.p(getBackrefProperty().getAdderCall(getParameterVarName(), "this") + ";");
				pContent.up("}");
			}
		}
	}

	public void writeFields(ContentBuffer pContent, IProgressMonitor pMonitor) {
		super.writeFields(pContent, pMonitor);
		if (!isAbstract()) {
			pContent.a("private ");
			if (isFinal()) {
				pContent.a("final ");
			}
			pContent.a(getType()).a(" ").a(getFieldName()).p(";");
			pContent.p();
		}
	}

	public void writeMethods(ContentBuffer pContent, Map pUserBlockContentByName, IProgressMonitor pMonitor) {
		super.writeMethods(pContent, pUserBlockContentByName, pMonitor);
		if (!(isAbstract() && getReadVisibility() == MVisibility.PRIVATE)) {
			writeSingleGetter(pContent);
		}
		if (!isFinal() && !(isAbstract() && getWriteVisibility() == MVisibility.PRIVATE)) {
			writeSingleSetter(pContent);
		}
	}

	/**
	 * @param pContent
	 */
	private void writeSingleSetter(ContentBuffer pContent) {
		//
		// setter
		//
		pContent.pi("/**", " * ");
		pContent.p("Set the value of property " + getName() + " to the specified value.");
		if (getBackrefProperty() != null) {
			pContent.p("Referred from " + getBackrefProperty().getJavaDocFullName()
			      + ", which will be updated by this method.");
		}
		if (getDescription() != null) {
			pContent.p();
			pContent.p(getDescription());
		}
		pContent.p();
		pContent.p("@param " + getParameterVarName() + " The new value for property " + getName() + ".");
		pContent.up(" */");
		if (isAbstract()) {
			pContent.p(getWriteVisibility().getId() + " abstract void " + getSetMethodName() + "(final " + getType() + " "
			      + getParameterVarName() + ");");
		} else {
			pContent.pi(getWriteVisibility().getId() + " final void " + getSetMethodName() + "(final " + getType() + " "
			      + getParameterVarName() + ") {");
			if (isRequired()) {
				writeRequiredCheck(pContent, getParameterVarName());
			}
			pContent.pi("if (" + getFieldName() + " == " + getParameterVarName() + ") {");
			pContent.p("return;");
			pContent.up("}");
			if (getBackrefProperty() != null && getBackrefProperty().isFinal()) {
				pContent.pi("if (!(" + getBackrefProperty().getContainsCall(getParameterVarName(), "this") + ")) {");
				pContent.p("throw new IllegalArgumentException(\"backref != this\");");
				pContent.up("}");
			}
			if (isBound() || (getBackrefProperty() != null && !getBackrefProperty().isFinal())) {
				pContent.p(getType() + " " + getLocalVarName() + " = " + getFieldName() + ";");
			}
			writeBeforeChangeCode(pContent);
			pContent.p(getFieldName() + " = " + getParameterVarName() + ";");
			if (isBound()) {
				pContent.p(getAddSingleChangeCall("this", getLocalVarName(), getParameterVarName()) + ";");
			}
			writeAfterChangeCode(pContent);
			if (getBackrefProperty() != null && !getBackrefProperty().isFinal()) {
				pContent.pi("if (" + getLocalVarName() + " != null) {");
				pContent.pi("if (" + getBackrefProperty().getContainsCall(getLocalVarName(), "this") + ") {");
				pContent.p(getBackrefProperty().getRemoverCall(getLocalVarName(), "this") + ";");
				pContent.up("}");
				pContent.up("}");
				pContent.pi("if (" + getParameterVarName() + " != null) {");
				pContent.p(getBackrefProperty().getAdderCall(getParameterVarName(), "this") + ";");
				pContent.up("}");
			}
			pContent.up("}");
		}
		pContent.p();
	}

	/**
	 * @param pContent
	 */
	private void writeSingleGetter(ContentBuffer pContent) {
		//
		// getter
		//
		pContent.pi("/**", " * ");
		pContent.p("Return the value of property " + getName() + ".");
		if (getDescription() != null) {
			pContent.p();
			pContent.p(getDescription());
		}
		pContent.p();
		pContent.p("@return The value of property " + getName() + ".");
		pContent.up(" */");
		if (isAbstract()) {
			pContent.p(getReadVisibility().getId() + " abstract " + getType() + " " + getGetMethodName() + "();");
		} else {
			pContent.pi(getReadVisibility().getId() + " final " + getType() + " " + getGetMethodName() + "() {");
			pContent.p("return " + getFieldName() + ";");
			pContent.up("}");
		}
		pContent.p();
	}

	private void writeRequiredCheck(final ContentBuffer pContent, final String pVarName) {
		if (!StringUtil.equalsAny(getType(), new String[] { "boolean", "short", "int", "long", "float", "double" })) {
			String vCheck = pVarName + " == " + "null";
			pContent.a("if (").a(vCheck).a(")").pi(" {");
			pContent.p("throw new IllegalArgumentException(\"" + vCheck + "\");");
			pContent.up("}");
		}
	}
}
