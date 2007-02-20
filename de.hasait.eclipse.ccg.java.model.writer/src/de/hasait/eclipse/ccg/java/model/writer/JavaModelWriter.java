/*
 * $Id: JavaModelWriter.java,v 1.1 2007-02-20 23:54:08 concentus Exp $
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

package de.hasait.eclipse.ccg.java.model.writer;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer;
import de.hasait.eclipse.ccg.java.model.AbstractMResource;
import de.hasait.eclipse.ccg.java.model.AbstractMType;
import de.hasait.eclipse.ccg.java.model.MCompilationUnit;
import de.hasait.eclipse.ccg.java.model.MPackage;
import de.hasait.eclipse.ccg.java.model.MResource;
import de.hasait.eclipse.ccg.java.model.MRoot;
import de.hasait.eclipse.ccg.java.model.util.ModelUtil;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 20.02.2007
 */
public class JavaModelWriter {
	static abstract class AbstractWriteContext {
		public final IProgressMonitor _monitor;

		public AbstractWriteContext(final IProgressMonitor pMonitor) {
			super();
			_monitor = pMonitor;
		}
	}

	public final void writeMRoot(final MRoot pRoot, final WritePackageContext pContext) throws CoreException {
		writeAbstractMPackageContainer(pRoot, pContext);
	}

	static class WritePackageContext extends AbstractWriteContext {
		public final XFolder _baseFolder;

		public final String _fullPackageName;

		public WritePackageContext(final IProgressMonitor pMonitor, final XFolder pBaseFolder,
		      final String pFullPackageName) {
			super(pMonitor);
			_baseFolder = pBaseFolder;
			_fullPackageName = pFullPackageName;
		}

		public WritePackageContext(final WritePackageContext pContext) {
			this(pContext._monitor, pContext._baseFolder, pContext._fullPackageName);
		}
	}

	public final void writeAbstractMPackageContainer(final AbstractMPackageContainer pPackageContainer,
	      final WritePackageContext pContext) throws CoreException {
		for (Iterator vPackageIterator = pPackageContainer.getPackages().iterator(); vPackageIterator.hasNext();) {
			MPackage vPackage = (MPackage) vPackageIterator.next();
			writeMPackage(vPackage, pContext);
		}
	}

	public final void writeMPackage(final MPackage pPackage, final WritePackageContext pContext) throws CoreException {
		String vPackageName = pPackage.getName();
		String vFullPackageName = StringUtil.join(pContext._fullPackageName, vPackageName, ".");
		String vPackagePath = vPackageName == null ? null : vPackageName.replace(".", "/");
		XFolder vPackageFolder = vPackagePath == null ? pContext._baseFolder : pContext._baseFolder
		      .getFolder(vPackagePath);
		WritePackageContext vContext = new WritePackageContext(pContext._monitor, vPackageFolder, vFullPackageName);
		for (Iterator vResourceIterator = pPackage.getResources().iterator(); vResourceIterator.hasNext();) {
			AbstractMResource vResource = (AbstractMResource) vResourceIterator.next();
			writeAbstractMResource(vResource, vContext);
		}
		writeAbstractMPackageContainer(pPackage, vContext);
	}

	static class WriteResourceContext extends WritePackageContext {
		public final XFile _targetFile;

		public final String _fullResourceName;

		public WriteResourceContext(final WritePackageContext pContext, final XFile pTargetFile,
		      final String pFullResourceName) {
			super(pContext);
			_targetFile = pTargetFile;
			_fullResourceName = pFullResourceName;
		}
	}

	public final void writeAbstractMResource(final AbstractMResource pResource, final WritePackageContext pContext)
	      throws CoreException {
		String vResourceName = pResource.getName();
		String vFullResourceName = StringUtil.join(pContext._fullPackageName, vResourceName, ".");
		XFile vResourceFile = pContext._baseFolder.getFile(vResourceName);
		WriteResourceContext vContext = new WriteResourceContext(pContext, vResourceFile, vFullResourceName);
		if (pResource instanceof MResource) {
			MResource vResource = (MResource) pResource;
			writeMResource(vResource, vContext);
		} else if (pResource instanceof MCompilationUnit) {
			MCompilationUnit vCompilationUnit = (MCompilationUnit) pResource;
			writeMCompilationUnit(vCompilationUnit, vContext);
		} else {
			throw new IllegalArgumentException("Unsupported type: " + pResource);
		}
	}

	public final void writeMResource(final MResource pResource, final WriteResourceContext pContext)
	      throws CoreException {
		byte[] vResourceContent = pResource.getContent();
		pContext._targetFile.getRawFile().setContents(new ByteArrayInputStream(vResourceContent), false, false,
		      pContext._monitor);
	}

	public final void writeMCompilationUnit(final MCompilationUnit pCompilationUnit, final WriteResourceContext pContext)
	      throws CoreException {
		ContentBuffer vContentBuffer = new ContentBuffer();
		if (pContext._fullPackageName != null) {
			vContentBuffer.a("package").a(" ").a(pContext._fullPackageName).p(";");
			vContentBuffer.p();
		}
		if (!pCompilationUnit.getImports().isEmpty()) {
			for (Iterator vImportedTypesI = pCompilationUnit.getImports().iterator(); vImportedTypesI.hasNext();) {
				AbstractMType vImportedType = (AbstractMType) vImportedTypesI.next();
				String vFullImportedTypeName = ModelUtil.getFullQualifiedName(vImportedType);
				vContentBuffer.a("import").a(" ").a(vFullImportedTypeName).p(";");
			}
			vContentBuffer.p();
		}
		// TODO writeTypes
		pContext._targetFile.write(vContentBuffer.getContent(), Boolean.TRUE, pContext._monitor);
	}
}
