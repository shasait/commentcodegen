/*
 * $Id: MInterface.java,v 1.1 2006-12-19 15:06:02 concentus Exp $
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

package de.hasait.eclipse.ccg.javag.application.lowlevel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 18.12.2006
 */
public class MInterface extends MType {
	private final List _extends = new ArrayList();

	private final List _members = new ArrayList();

	public void addExtends(final MInterface pInterface) {
		_extends.add(pInterface);
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
			}
		}
		if (_extends != null) {
			for (Iterator vExtendsI = _extends.iterator(); vExtendsI.hasNext();) {
				MInterface vInterface = (MInterface) vExtendsI.next();
				MMethodDeclaration[] vExtendsDeclaredMethods = vInterface.getDeclaredMethods();
				for (int vExtendsDeclaredMethodsI = 0; vExtendsDeclaredMethodsI < vExtendsDeclaredMethods.length; vExtendsDeclaredMethodsI++) {
					vDeclaredMethods.add(vExtendsDeclaredMethods[vExtendsDeclaredMethodsI]);
				}
			}
		}
		return (MMethodDeclaration[]) vDeclaredMethods.toArray(new MMethodDeclaration[vDeclaredMethods.size()]);
	}
}
