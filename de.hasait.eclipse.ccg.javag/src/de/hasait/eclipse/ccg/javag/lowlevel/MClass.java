/*
 * $Id: MClass.java,v 1.1 2007-01-01 22:11:23 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.lowlevel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 18.12.2006
 */
public class MClass extends MType {
	private MClass _extends;

	private final List _implements = new ArrayList();

	private boolean _forceAbstract;

	private final List _members = new ArrayList();

	/**
	 * @return the extends
	 */
	public final MClass getExtends() {
		return _extends;
	}

	/**
	 * @param pExtends
	 *           the extends to set
	 */
	public final void setExtends(MClass pExtends) {
		_extends = pExtends;
	}

	public final void addImplements(MInterface pInterface) {
		_implements.add(pInterface);
	}

	/**
	 * @return the forceAbstract
	 */
	public final boolean isForceAbstract() {
		return _forceAbstract;
	}

	/**
	 * @param pForceAbstract
	 *           the forceAbstract to set
	 */
	public final void setForceAbstract(boolean pForceAbstract) {
		_forceAbstract = pForceAbstract;
	}

	public boolean isAbstract() {
		if (_forceAbstract) {
			return true;
		}
		for (Iterator vMembersI = _members.iterator(); vMembersI.hasNext();) {
			Object vMember = vMembersI.next();
			if (vMember instanceof MMethodDeclaration) {
				return true;
			}
		}
		return false;
	}

	public void addField(final MFieldDeclaration pField) {
		_members.add(pField);
	}

	public void addMethod(final MMethodImplementation pMethod) {
		_members.add(pMethod);
	}

	public void addAbstractMethod(final MMethodDeclaration pAbstractMethod) {
		_members.add(pAbstractMethod);
	}

	public MMethodDeclaration[] getDeclaredMethods() {
		List vDeclaredMethods = new ArrayList();
		for (Iterator vMembersI = _members.iterator(); vMembersI.hasNext();) {
			Object vMember = vMembersI.next();
			if (vMember instanceof MMethodDeclaration) {
				vDeclaredMethods.add(vMember);
			} else if (vMember instanceof MMethodImplementation) {
				vDeclaredMethods.add(((MMethodImplementation) vMember).getDeclaration());
			}
		}
		if (_extends != null) {
			MMethodDeclaration[] vExtendsDeclaredMethods = _extends.getDeclaredMethods();
			for (int vExtendsDeclaredMethodsI = 0; vExtendsDeclaredMethodsI < vExtendsDeclaredMethods.length; vExtendsDeclaredMethodsI++) {
				vDeclaredMethods.add(vExtendsDeclaredMethods[vExtendsDeclaredMethodsI]);
			}
		}
		if (_implements != null) {
			for (Iterator vImplementsI = _implements.iterator(); vImplementsI.hasNext();) {
				MInterface vInterface = (MInterface) vImplementsI.next();
				MMethodDeclaration[] vImplementsDeclaredMethods = vInterface.getDeclaredMethods();
				for (int vImplementsDeclaredMethodsI = 0; vImplementsDeclaredMethodsI < vImplementsDeclaredMethods.length; vImplementsDeclaredMethodsI++) {
					vDeclaredMethods.add(vImplementsDeclaredMethods[vImplementsDeclaredMethodsI]);
				}
			}
		}
		return (MMethodDeclaration[]) vDeclaredMethods.toArray(new MMethodDeclaration[vDeclaredMethods.size()]);
	}
}
