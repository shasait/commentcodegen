/*
 * $Id: FindUnusedResourcesAction.java,v 1.4 2007-01-02 16:19:49 concentus Exp $
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

package de.hasait.eclipse.depsearch.popup.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IParent;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.depsearch.DepSearchPlugin;
import de.hasait.eclipse.depsearch.properties.DepSearchPreferenceInitializer;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.4 $
 * @since 20.12.2006
 */
public class FindUnusedResourcesAction implements IObjectActionDelegate {
	private final Set _selectedJavaProjects = new HashSet();

	private final ASTParser _astParser = ASTParser.newParser(AST.JLS3);

	/**
	 * Constructor.
	 */
	public FindUnusedResourcesAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// nop
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		List vCandidates = findUnusedResources();
		DepSearchPlugin.getDefault().setUnusedResources(vCandidates);
	}

	private List findUnusedResources() {
		// search types
		List vResult = new ArrayList();
		LinkedList vNeededTypes = new LinkedList();
		Map vUsedTypesByType = new HashMap();
		FindTypeUsagesAstVisitor vAstVisitor = new FindTypeUsagesAstVisitor(vNeededTypes, vUsedTypesByType);
		for (Iterator vSelectedJavaProjectsI = _selectedJavaProjects.iterator(); vSelectedJavaProjectsI.hasNext();) {
			IJavaProject vSelectedJavaProject = (IJavaProject) vSelectedJavaProjectsI.next();
			IJavaModel vJavaModel = vSelectedJavaProject.getJavaModel();
			try {
				findTypeRefs(vJavaModel, vAstVisitor);
			} catch (JavaModelException e) {
				vResult.add(e.getMessage());
			}
		}
		// search non-java resources
		FindResourceRefsVisitor vResourceVisitor = new FindResourceRefsVisitor(vNeededTypes, vUsedTypesByType);
		for (Iterator vSelectedJavaProjectsI = _selectedJavaProjects.iterator(); vSelectedJavaProjectsI.hasNext();) {
			IJavaProject vSelectedJavaProject = (IJavaProject) vSelectedJavaProjectsI.next();
			IProject vProject = vSelectedJavaProject.getProject();
			try {
				vProject.accept(vResourceVisitor);
			} catch (CoreException e) {
				vResult.add(e.getMessage());
			}
		}
		// mark needed resources
		Set vDeclaredTypes = vUsedTypesByType.keySet();
		Set vUsedResources = new HashSet();
		while (!vNeededTypes.isEmpty()) {
			String vType = (String) vNeededTypes.removeFirst();
			if (!vUsedResources.contains(vType) && vDeclaredTypes.contains(vType)) {
				vUsedResources.add(vType);
				Collection vUsedTypes = (Collection) vUsedTypesByType.get(vType);
				if (vUsedTypes != null) {
					List vTypesToEnqueue = new ArrayList(vUsedTypes);
					vTypesToEnqueue.removeAll(vUsedResources);
					vTypesToEnqueue.removeAll(vNeededTypes);
					vNeededTypes.addAll(vTypesToEnqueue);
				}
			}
		}
		// filter
		vDeclaredTypes.removeAll(vUsedResources);
		// output
		vResult.addAll(vUsedTypesByType.keySet());
		return vResult;
	}

	private void findTypeRefs(IJavaElement pJavaElement, ASTVisitor pAstVisitor) throws JavaModelException {
		if (pJavaElement instanceof ICompilationUnit) {
			ICompilationUnit vCompilationUnit = (ICompilationUnit) pJavaElement;
			_astParser.setSource(vCompilationUnit);
			_astParser.setResolveBindings(true);
			CompilationUnit vAstCompilationUnit = (CompilationUnit) _astParser.createAST(null);
			vAstCompilationUnit.accept(pAstVisitor);
		} else if (pJavaElement instanceof IParent) {
			IJavaElement[] vChildren = ((IParent) pJavaElement).getChildren();
			if (vChildren != null) {
				for (int vChildrenI = 0; vChildrenI < vChildren.length; vChildrenI++) {
					IJavaElement vJavaElement = vChildren[vChildrenI];
					findTypeRefs(vJavaElement, pAstVisitor);
				}
			}
		}
	}

	private final class FindTypeUsagesAstVisitor extends ASTVisitor {
		private final Collection _neededTypes;

		private final Map _usedTypesByType;

		private final LinkedList _enclosingTypeStack = new LinkedList();

		private String _enclosingType;

		private Set _usedTypes;

		/**
		 * Constructor.
		 */
		public FindTypeUsagesAstVisitor(final Collection pNeededTypes, final Map pUsedTypesByType) {
			super();
			_neededTypes = pNeededTypes;
			_usedTypesByType = pUsedTypesByType;
		}

		public boolean visit(TypeDeclaration pNode) {
			_enclosingType = pNode.resolveBinding().getQualifiedName();
			_enclosingTypeStack.addFirst(_enclosingType);
			_usedTypes = new HashSet();
			_usedTypesByType.put(_enclosingType, _usedTypes);
			return true;
		}

		public void endVisit(TypeDeclaration pNode) {
			_enclosingTypeStack.removeFirst();
			_enclosingType = _enclosingTypeStack.isEmpty() ? null : (String) _enclosingTypeStack.getFirst();
			_usedTypes = _enclosingType == null ? null : (Set) _usedTypesByType.get(_enclosingType);
		}

		public boolean visit(MethodDeclaration pNode) {
			if ("main".equals(pNode.getName().getFullyQualifiedName())) {
				int vModifiers = pNode.getModifiers();
				if (Modifier.isPublic(vModifiers) && Modifier.isStatic(vModifiers)) {
					// TODO maybe check returntype and parametertype...
					_neededTypes.add(_enclosingType);
				}
			}
			return true;
		}

		public boolean visit(ArrayType pNode) {
			try {
				visitTypeQualifiedName(pNode.resolveBinding().getQualifiedName());
			} catch (NullPointerException e) {
				// nop
			}
			return true;
		}

		public boolean visit(ParameterizedType pNode) {
			try {
				visitTypeQualifiedName(pNode.resolveBinding().getQualifiedName());
			} catch (NullPointerException e) {
				// nop
			}
			return true;
		}

		public boolean visit(QualifiedType pNode) {
			try {
				visitTypeQualifiedName(pNode.resolveBinding().getQualifiedName());
			} catch (NullPointerException e) {
				// nop
			}
			return true;
		}

		public boolean visit(SimpleType pNode) {
			try {
				visitTypeQualifiedName(pNode.resolveBinding().getQualifiedName());
			} catch (NullPointerException e) {
				// nop
			}
			return true;
		}

		private void visitTypeQualifiedName(String pTypeQualifiedName) {
			_usedTypes.add(pTypeQualifiedName);
		}
	};

	private final class FindResourceRefsVisitor implements IResourceVisitor {
		private final Collection _neededTypes;

		private final Map _usedTypesByType;

		/**
		 * Constructor.
		 */
		public FindResourceRefsVisitor(final Collection pNeededTypes, final Map pTypeToUsedInsideTypes) {
			super();
			_neededTypes = pNeededTypes;
			_usedTypesByType = pTypeToUsedInsideTypes;
		}

		public boolean visit(IResource pResource) throws CoreException {
			if (pResource.getType() == IResource.FILE) {
				IFile vResourceAsFile = (IFile) pResource;
				String vFileExtension = vResourceAsFile.getFileExtension();
				String[] vFileExtensionsFull = DepSearchPreferenceInitializer.getFileExtensionsFull();
				for (int vFileExtensionsFullI = 0; vFileExtensionsFullI < vFileExtensionsFull.length; vFileExtensionsFullI++) {
					if (vFileExtensionsFull[vFileExtensionsFullI].equalsIgnoreCase(vFileExtension)) {
						XFile vFile = new XFile(vResourceAsFile, vResourceAsFile.getParent());
						String vResource = vFile.getFullPath().toString();
						_neededTypes.add(vResource);
						Set vUsedTypes = new HashSet();
						_usedTypesByType.put(vResource, vUsedTypes);
						String vFileContent = vFile.read();
						for (Iterator declaredTypesI = _usedTypesByType.keySet().iterator(); declaredTypesI.hasNext();) {
							String vDeclaredType = (String) declaredTypesI.next();
							if (vFileContent.contains(vDeclaredType)) {
								vUsedTypes.add(vDeclaredType);
							}
						}
					}
				}
			}
			return true;
		}
	};

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction pAction, ISelection pSelection) {
		_selectedJavaProjects.clear();
		IStructuredSelection vStructuredSelection = (IStructuredSelection) pSelection;
		for (Iterator vStructuredSelectionI = vStructuredSelection.iterator(); vStructuredSelectionI.hasNext();) {
			IJavaProject vSelectedJavaProject = (IJavaProject) vStructuredSelectionI.next();
			_selectedJavaProjects.add(vSelectedJavaProject);
		}
	}
}
