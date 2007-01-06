/*
 * $Id: MPackage.java,v 1.2 2007-01-06 00:39:00 concentus Exp $
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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFolder;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 18.12.2006
 */
public class MPackage {
	private final MPackage _parentPackage;

	private final String _name;

	private final String _packagePath;
	
	private final XFolder _packageFolder;

	private final List _members = new ArrayList();

	/**
	 * @param pName
	 */
	public MPackage(final MPackage pParentPackage, final String pName) {
		super();
		
		_parentPackage = pParentPackage;
		
		if (pName == null) {
			throw new IllegalArgumentException("name == null");
		}
		_name = pName;
		
		_packagePath = StringUtil.replace(_name, ".", "/");
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return _name;
	}

	public final void addPackage(final MPackage pPackage) {
		_members.add(pPackage);
	}

	public final void addCompilationUnit(final MCompilationUnit pCompilationUnit) {
		_members.add(pCompilationUnit);
	}

	public void write(final XFolder pBaseFolder, final IProgressMonitor pMonitor) throws CoreException {
		for (Iterator membersI = _members.iterator(); membersI.hasNext();) {
			Object vMember = (Object) membersI.next();
			XFolder vBaseFolder = pBaseFolder.getFolder(_packagePath);
			if (vMember instanceof MPackage) {
				((MPackage) vMember).write(vBaseFolder, pMonitor);
			} else if (vMember instanceof MCompilationUnit) {
				((MCompilationUnit) vMember).write(vBaseFolder, pMonitor);
			} else {
				throw new IllegalArgumentException("unknown member " + vMember);
			}
		}
	}
}
