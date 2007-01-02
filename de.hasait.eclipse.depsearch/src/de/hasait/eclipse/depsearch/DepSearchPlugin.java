/*
 * $Id: DepSearchPlugin.java,v 1.2 2007-01-02 16:19:47 concentus Exp $
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

package de.hasait.eclipse.depsearch;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * Plug-in class.
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 02.01.2007
 */
public class DepSearchPlugin extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "de.hasait.eclipse.depsearch";

	// The shared instance
	private static DepSearchPlugin DEFAULT_INSTANCE;

	public static final String PROPERTYNAME_UNUSED_RESOURCES = "unusedResources";

	private final List _unusedResources = new ArrayList();

	private final PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

	/**
	 * The constructor
	 */
	public DepSearchPlugin() {
		super();
	}

	public void start(final BundleContext pContext) throws Exception {
		super.start(pContext);
		if (!PLUGIN_ID.equals(getBundle().getSymbolicName())) {
			throw new RuntimeException("AssertionFailed: " + PLUGIN_ID + " != " + getBundle().getSymbolicName());
		}
		if (DEFAULT_INSTANCE != null) {
			throw new RuntimeException("Their is already an Default-Instance: " + DEFAULT_INSTANCE);
		}
		DEFAULT_INSTANCE = this;
	}

	public void stop(final BundleContext pContext) throws Exception {
		DEFAULT_INSTANCE = null;
		super.stop(pContext);
	}

	/**
	 * @return The shared instance.
	 */
	public static DepSearchPlugin getDefault() {
		return DEFAULT_INSTANCE;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path
	 * 
	 * @param pPath
	 *           the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(final String pPath) {
		return imageDescriptorFromPlugin(PLUGIN_ID, pPath);
	}

	/**
	 * @return the unusedResources
	 */
	public final Object[] getUnusedResources() {
		synchronized (_unusedResources) {
			return _unusedResources.toArray();
		}
	}

	/**
	 * @param pUnusedResources
	 *           the unusedResources to set
	 */
	public final void setUnusedResources(List pUnusedResources) {
		synchronized (_unusedResources) {
			_unusedResources.clear();
			if (pUnusedResources != null) {
				_unusedResources.addAll(pUnusedResources);
			}
		}
		_propertyChangeSupport.firePropertyChange(PROPERTYNAME_UNUSED_RESOURCES, null, null);
	}

	/**
	 * @see java.beans.PropertyChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public final void addPropertyChangeListener(PropertyChangeListener pListener) {
		_propertyChangeSupport.addPropertyChangeListener(pListener);
	}

	/**
	 * @see java.beans.PropertyChangeSupport#addPropertyChangeListener(java.lang.String,
	 *      java.beans.PropertyChangeListener)
	 */
	public final void addPropertyChangeListener(String pPropertyName, PropertyChangeListener pListener) {
		_propertyChangeSupport.addPropertyChangeListener(pPropertyName, pListener);
	}

	/**
	 * @see java.beans.PropertyChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public final void removePropertyChangeListener(PropertyChangeListener pListener) {
		_propertyChangeSupport.removePropertyChangeListener(pListener);
	}

	/**
	 * @see java.beans.PropertyChangeSupport#removePropertyChangeListener(java.lang.String,
	 *      java.beans.PropertyChangeListener)
	 */
	public final void removePropertyChangeListener(String pPropertyName, PropertyChangeListener pListener) {
		_propertyChangeSupport.removePropertyChangeListener(pPropertyName, pListener);
	}
}
