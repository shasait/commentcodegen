/*
 * $Id: ModelUtil.java,v 1.1 2007-02-21 00:02:24 concentus Exp $
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

package de.hasait.eclipse.ccg.java.model.util;

import de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType;
import de.hasait.eclipse.ccg.java.model.AbstractMExternalType;
import de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer;
import de.hasait.eclipse.ccg.java.model.AbstractMType;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer;
import de.hasait.eclipse.ccg.java.model.MCompilationUnit;
import de.hasait.eclipse.ccg.java.model.MPackage;
import de.hasait.eclipse.ccg.java.model.MRoot;
import de.hasait.eclipse.common.StringUtil;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 21.02.2007
 */
public final class ModelUtil {
	private ModelUtil() {
		super();
	}

	public static String getFullQualifiedName(final AbstractMDeclaredType pDeclaredType) {
		if (pDeclaredType == null) {
			return null;
		}
		String vFullTypeContainerName = getFullQualifiedName(pDeclaredType.getTypeContainer());
		String vTypeName = pDeclaredType.getName();
		return StringUtil.join(vFullTypeContainerName, vTypeName, ".");
	}

	public static String getFullQualifiedName(final AbstractMType pType) {
		if (pType == null) {
			return null;
		}
		if (pType instanceof AbstractMExternalType) {
			return ((AbstractMExternalType) pType).getFullQualifiedName();
		} else if (pType instanceof AbstractMDeclaredType) {
			return getFullQualifiedName((AbstractMDeclaredType) pType);
		}
		throw new IllegalArgumentException("Unsupported type: " + pType);
	}

	public static String getFullQualifiedName(final MCompilationUnit pCompilationUnit) {
		if (pCompilationUnit == null) {
			return null;
		}
		String vFullPackageName = getFullQualifiedName(pCompilationUnit.getPackage());
		String vCompilationUnitName = pCompilationUnit.getName();
		return StringUtil.join(vFullPackageName, vCompilationUnitName, ".");
	}

	public static String getFullQualifiedName(final AbstractMTypeContainer pTypeContainer) {
		if (pTypeContainer == null) {
			return null;
		}
		if (pTypeContainer instanceof AbstractMDeclaredType) {
			return getFullQualifiedName(((AbstractMDeclaredType) pTypeContainer).getTypeContainer());
		} else if (pTypeContainer instanceof MCompilationUnit) {
			return getFullQualifiedName((MCompilationUnit) pTypeContainer);
		}
		throw new IllegalArgumentException("Unsupported type: " + pTypeContainer);
	}

	public static String getFullQualifiedName(final MPackage pPackage) {
		if (pPackage == null) {
			return null;
		}
		String vFullPackageContainerName = getFullQualifiedName(pPackage.getPackageContainer());
		String vPackageName = pPackage.getName();
		return StringUtil.join(vFullPackageContainerName, vPackageName, ".");
	}

	public static String getFullQualifiedName(final AbstractMPackageContainer pPackageContainer) {
		if (pPackageContainer == null) {
			return null;
		}
		if (pPackageContainer instanceof MRoot) {
			return null;
		} else if (pPackageContainer instanceof MPackage) {
			return getFullQualifiedName((MPackage) pPackageContainer);
		}
		throw new IllegalArgumentException("Unsupported type: " + pPackageContainer);
	}
}
