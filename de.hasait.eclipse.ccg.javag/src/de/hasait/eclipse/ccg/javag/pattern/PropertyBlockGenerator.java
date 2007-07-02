/*
 * $Id: PropertyBlockGenerator.java,v 1.5 2007-07-02 15:11:56 concentus Exp $
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
package de.hasait.eclipse.ccg.javag.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.generator.AbstractCcgBlockGenerator;
import de.hasait.eclipse.ccg.generator.ICcgGeneratorLookup;
import de.hasait.eclipse.ccg.parser.ICcgComment;
import de.hasait.eclipse.ccg.parser.ICcgIndentSupport;
import de.hasait.eclipse.common.JavaContentBuffer;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.5 $
 */
public final class PropertyBlockGenerator extends AbstractCcgBlockGenerator {
	private static final String DESCRIPTION = "Bean Property";

	/**
	 * Constructor.
	 */
	public PropertyBlockGenerator() {
		super(DESCRIPTION);
	}

	public String generateBlock(final XElement configElement, final ICcgComment comment, final XFile sourceFile,
	      final Map sourceFileContext, final ICcgGeneratorLookup generatorLookup, final IProgressMonitor monitor)
	      throws Exception {
		String indent = configElement.getStringAttribute("indent", "\t");
		JavaContentBuffer cb = new JavaContentBuffer(indent);
		if (comment instanceof ICcgIndentSupport) {
			cb.i(((ICcgIndentSupport) comment).getIndent());
		}

		String type = configElement.getRequiredStringAttribute("type");
		String name = configElement.getRequiredStringAttribute("name");
		String capName = StringUtil.capitalize(name);
		String oldName = "old" + capName;
		String cardinality = configElement.getStringAttribute("cardinality");
		boolean many = !(cardinality == null || cardinality.equals("1"));
		boolean bound = configElement.getBooleanAttribute("bound", false);
		boolean afterSet = configElement.getBooleanAttribute("afterset", false);
		boolean beforeSet = configElement.getBooleanAttribute("beforeset", false);
		boolean hooked = configElement.getBooleanAttribute("hooked", false);
		boolean vSynchronized = configElement.getBooleanAttribute("synchronized", false);
		boolean readonly = configElement.getBooleanAttribute("final", false);
		String backref = configElement.getStringAttribute("backref");
		String vBackrefCardinality = configElement.getStringAttribute("backrefcardinality");
		boolean backrefMany = !(vBackrefCardinality == null || vBackrefCardinality.equals("1"));

		String setterVisibility = null;
		if (readonly) {
			setterVisibility = "protected";
		} else {
			setterVisibility = "public";
		}
		String capBackref = null;
		;
		if (backref != null) {
			capBackref = StringUtil.capitalize(backref);
		}
		String mName = "_" + name;
		String pName = name;
		if (many) {
			mName = mName + "s";
		}
		String getterPrefix = (type.equals("boolean") || type.equals("Boolean") || type.equals("java.lang.Boolean")) ? "is"
		      : "get";

		String nameConstant = "PROPERTYNAME_" + name.toUpperCase();

		cb.javaDocStart();
		cb.a("Property ").a(name).p();
		cb.javaDocEnd();
		cb.a("public static final String ").a(nameConstant).a(" = \"").a(name).a(many ? "s" : "").a("\"").p(";");

		if (!many) {
			cb.p();
			cb.javaDocStart();
			cb.a("The single property field ").a(name).p(".");
			cb.javaDocEnd();
			cb.a("private ").a(type).a(" ").a(mName).p(";");

			cb.p();
			cb.javaDocStart();
			cb.a("Returns the ").a(name).p(".");
			cb.javaDocEnd();
			cb.a("public final ").a(type).a(" ").a(getterPrefix).a(capName).a("() ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("return ").a(mName).p(";");
			if (vSynchronized) {
				cb.pu("}");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Sets the ").a(name).p(".");
			cb.javaDocEnd();
			cb.a(setterVisibility).a(" final void set").a(capName).a("(");
			cb.a("final ").a(type).a(" ").a(pName);
			cb.a(") ").pi("{");
			if (bound || hooked || (backref != null)) {
				cb.a(type).a(" ").a(oldName).p(";");
			}
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			if (beforeSet) {
				cb.a("if (beforeSet").a(capName).a("(").a(pName).a(")) ").pi("{");
				cb.a("return").p(";");
				cb.pu("}");
			}
			if (bound || hooked || (backref != null)) {
				cb.a("if (").a(mName).a(" == ").a(pName).a(") ").pi("{");
				cb.a("return").p(";");
				cb.pu("}");
				cb.a(oldName).a(" = ").a(mName).p(";");
			}
			if (hooked || (backref != null)) {
				cb.a("if (").a(mName).a(" != null) ").pi("{");
				cb.a(mName).a(" = null").p(";");
				if (backref != null) {
					if (backrefMany) {
						cb.a(oldName).a(".remove").a(capBackref).a("(this)").p(";");
					} else {
						cb.a(oldName).a(".set").a(capBackref).a("(null)").p(";");
					}
				}
				if (hooked) {
					cb.a("old").a(capName).a("(").a(oldName).a(")").p(";");
				}
				cb.pu("}");
			}
			cb.a(mName).a(" = ").a(pName).p(";");
			if (hooked || (backref != null)) {
				cb.a("if (").a(mName).a(" != null) ").pi("{");
				if (backref != null) {
					if (backrefMany) {
						cb.a(pName).a(".add").a(capBackref).a("(this)").p(";");
					} else {
						cb.a(pName).a(".set").a(capBackref).a("(this)").p(";");
					}
				}
				if (hooked) {
					cb.a("new").a(capName).a("(").a(pName).a(")").p(";");
				}
				cb.pu("}");
			}
			if (vSynchronized) {
				cb.pu("}");
			}
			if (bound) {
				cb.a("firePropertyChange(").a(nameConstant).a(", ").a(oldName).a(", ").a(pName).a(")").p(";");
			}
			if (afterSet) {
				cb.a("afterSet").a(capName).a("(").a(pName).a(")").p(";");
			}
			cb.pu("}");
		} else {
			cb.p();
			cb.javaDocStart();
			cb.a("The many property field ").a(name).p(".");
			cb.javaDocEnd();
			cb.a("private final ").a(List.class.getName()).a(" ").a(mName).a(" = new ").a(ArrayList.class.getName()).a("()")
			      .p(";");

			cb.p();
			cb.javaDocStart();
			cb.a("Returns the array of all ").a(name).a("s").p(".");
			cb.javaDocEnd();
			cb.a("public final ").a(type).a("[] get").a(capName).a("s() ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("return (").a(type).a("[])").a(mName).a(".toArray(new ").a(type).a("[").a(mName).a(".size()])").p(";");
			if (vSynchronized) {
				cb.pu("}");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Returns the ").a(name).a(" at the specified index").p(".");
			cb.javaDocEnd();
			cb.a("public final ").a(type).a(" get").a(capName).a("(final int index) ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("return (").a(type).a(")").a(mName).a(".get(index)").p(";");
			if (vSynchronized) {
				cb.pu("}");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Returns if the specified ").a(name).a(" is contained").p(".");
			cb.javaDocEnd();
			cb.a("public final boolean contains").a(capName).a("(final ").a(type).a(" ").a(pName).a(") ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("return ").a(mName).a(".contains(").a(pName).a(")").p(";");
			if (vSynchronized) {
				cb.pu("}");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Returns how many ").a(name).a("s are contained").p(".");
			cb.javaDocEnd();
			cb.a("public final int ").a(name).a("Size() ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("return ").a(mName).a(".size()").p(";");
			if (vSynchronized) {
				cb.pu("}");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Returns if ").a(name).a(" is empty").p(".");
			cb.javaDocEnd();
			cb.a("public final boolean is").a(capName).a("Empty() ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("return ").a(mName).a(".isEmpty()").p(";");
			if (vSynchronized) {
				cb.pu("}");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Returns an {@link Iterator} for all ").a(name).a("s").p(".");
			cb.javaDocEnd();
			cb.a("public final ").a(Iterator.class.getName()).a(" ").a(name).a("Iterator() ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("return ").a(mName).a(".iterator()").p(";");
			if (vSynchronized) {
				cb.pu("}");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Adds the specified ").a(name).p(".");
			cb.javaDocEnd();
			cb.a(setterVisibility).a(" final void add").a(capName).a("(final ").a(type).a(" ").a(pName).a(") ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("if (").a(mName).a(".contains(").a(pName).a(")) ").pi("{");
			cb.a("return").p(";");
			cb.pu("}");
			if (backref != null) {
				if (backrefMany) {
					cb.a(pName).a(".remove").a(capBackref).a("(this)").p(";");
				} else {
					cb.a(pName).a(".set").a(capBackref).a("(null)").p(";");
				}
			}
			cb.a(mName).a(".add(").a(pName).a(")").p(";");
			if (backref != null) {
				if (backrefMany) {
					cb.a(pName).a(".add").a(capBackref).a("(this)").p(";");
				} else {
					cb.a(pName).a(".set").a(capBackref).a("(this)").p(";");
				}
			}
			if (hooked) {
				cb.a("new").a(capName).a("(").a(pName).a(")").p(";");
			}
			if (vSynchronized) {
				cb.pu("}");
			}
			if (bound) {
				cb.a("firePropertyChange(").a(nameConstant).a(", null, ").a(pName).a(")").p(";");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Removes the specified ").a(name).p(".");
			cb.javaDocEnd();
			cb.a(setterVisibility).a(" final void remove").a(capName).a("(final ").a(type).a(" ").a(pName).a(") ").pi("{");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a("if (!").a(mName).a(".contains(").a(pName).a(")) ").pi("{");
			cb.a("return").p(";");
			cb.pu("}");
			cb.a(mName).a(".remove(").a(pName).a(")").p(";");
			if (backref != null) {
				if (backrefMany) {
					cb.a(pName).a(".remove").a(capBackref).a("(this)").p(";");
				} else {
					cb.a(pName).a(".set").a(capBackref).a("(null)").p(";");
				}
			}
			if (hooked) {
				cb.a("old").a(capName).a("(").a(pName).a(")").p(";");
			}
			if (vSynchronized) {
				cb.pu("}");
			}
			if (bound) {
				cb.a("firePropertyChange(").a(nameConstant).a(", ").a(pName).a(", null)").p(";");
			}
			cb.pu("}");

			cb.p();
			cb.javaDocStart();
			cb.a("Remove all ").a(name).a("s").p(".");
			cb.javaDocEnd();
			cb.a(setterVisibility).a(" final void removeAll").a(capName).a("s() ").pi("{");
			cb.a(type).a("[] ").a(name).a("s").p(";");
			if (vSynchronized) {
				cb.pi("synchronized (this) {");
			}
			cb.a(name).a("s = get").a(capName).a("s()").p(";");
			if (vSynchronized) {
				cb.pu("}");
			}
			cb.a("for (int i=0; i<").a(name).a("s.length; i++) ").pi("{");
			cb.a("remove").a(capName).a("(").a(name).a("s[i])").p(";");
			cb.pu("}");
			cb.pu("}");
		}
		cb.p();

		return cb.toString();
	}

}
