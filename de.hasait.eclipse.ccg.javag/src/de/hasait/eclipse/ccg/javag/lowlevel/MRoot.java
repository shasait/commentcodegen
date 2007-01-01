/*
 * $Id: MRoot.java,v 1.1 2007-01-01 22:11:23 concentus Exp $
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

import de.hasait.eclipse.common.resource.XFolder;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 18.12.2006
 */
public class MRoot {
	private final XFolder _baseFolder;

	private final List _members = new ArrayList();

	/**
	 * @param pBaseFolder
	 */
	public MRoot(final XFolder pBaseFolder) {
		super();
		if (pBaseFolder == null) {
			throw new IllegalArgumentException("baseFolder == null");
		}
		_baseFolder = pBaseFolder;
	}

	/**
	 * @return the baseFolder
	 */
	public final XFolder getBaseFolder() {
		return _baseFolder;
	}

	public final void addPackage(final MPackage pPackage) {
		_members.add(pPackage);
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		for (Iterator membersI = _members.iterator(); membersI.hasNext();) {
			MPackage vPackage = (MPackage) membersI.next();
			vPackage.write(_baseFolder, pMonitor);
		}
	}
}
