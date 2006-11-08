/*
 * $Id: AbstractRemoveNatureAction.java,v 1.1 2006-11-08 16:16:41 concentus Exp $
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
package de.hasait.eclipse.common.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.hasait.eclipse.common.NatureUtil;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public abstract class AbstractRemoveNatureAction implements
		IObjectActionDelegate {
	private final String _natureId;

	private ISelection _selection;

	protected AbstractRemoveNatureAction(final String natureId) {
		super();
		_natureId = natureId;
	}

	public final void run(IAction action) {
		if (_selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) _selection)
					.getFirstElement();
			IProject project = null;
			if (element instanceof IProject) {
				project = (IProject) element;
			} else if (element instanceof IAdaptable) {
				project = (IProject) ((IAdaptable) element)
						.getAdapter(IProject.class);
			}
			if (project != null) {
				try {
					NatureUtil.removeNature(project, _natureId);
				} catch (CoreException e) {
					// ignore
				}
			}
		}
	}

	public final void selectionChanged(IAction action, ISelection selection) {
		_selection = selection;
	}

	public final void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// ignore
	}
}
