/*
 * $Id: UnusedResourcesView.java,v 1.1 2007-01-02 16:19:48 concentus Exp $
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

package de.hasait.eclipse.depsearch.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import de.hasait.eclipse.depsearch.DepSearchPlugin;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 02.01.2007
 */
public class UnusedResourcesView extends ViewPart {
	private TableViewer _viewer;

	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer pViewer, Object pOldInput, Object pNewInput) {
			// nop
		}

		public void dispose() {
			// nop
		}

		public Object[] getElements(Object pParent) {
			return DepSearchPlugin.getDefault().getUnusedResources();
		}
	}

	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object pObject, int pIndex) {
			return getText(pObject);
		}

		public Image getColumnImage(Object pObject, int pIndex) {
			return getImage(pObject);
		}

		public Image getImage(Object pObject) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	class NameSorter extends ViewerSorter {
		// nop
	}

	private final PropertyChangeListener _propertyChangeListener = new PropertyChangeListener() {
		public void propertyChange(PropertyChangeEvent pEvent) {
			_viewer.refresh();
		}
	};

	/**
	 * The constructor.
	 */
	public UnusedResourcesView() {
		super();
	}

	public void createPartControl(Composite pParent) {
		_viewer = new TableViewer(pParent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		_viewer.setContentProvider(new ViewContentProvider());
		_viewer.setLabelProvider(new ViewLabelProvider());
		_viewer.setSorter(new NameSorter());
		_viewer.setInput(getViewSite());
		_viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(final DoubleClickEvent pEvent) {
				// nop
			}
		});
		DepSearchPlugin.getDefault().addPropertyChangeListener(DepSearchPlugin.PROPERTYNAME_UNUSED_RESOURCES,
		      _propertyChangeListener);
	}

	public void dispose() {
		super.dispose();
		DepSearchPlugin.getDefault().removePropertyChangeListener(DepSearchPlugin.PROPERTYNAME_UNUSED_RESOURCES,
		      _propertyChangeListener);
	}

	public void setFocus() {
		_viewer.getControl().setFocus();
	}
}
