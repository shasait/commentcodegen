package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MResource {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property package. */
	public static final String PROPERTY_PACKAGE_NAME = "package";
	/** Type of property package. */
	public static final Class PROPERTY_PACKAGE_TYPE = MPackage.class;
	
	/** Name of property name. */
	public static final String PROPERTY_NAME_NAME = "name";
	/** Type of property name. */
	public static final Class PROPERTY_NAME_TYPE = String.class;
	
	/** Name of property file. */
	public static final String PROPERTY_FILE_NAME = "file";
	/** Type of property file. */
	public static final Class PROPERTY_FILE_TYPE = XFile.class;
	
	/** Name of property doNotWrite. */
	public static final String PROPERTY_DO_NOT_WRITE_NAME = "doNotWrite";
	/** Type of property doNotWrite. */
	public static final Class PROPERTY_DO_NOT_WRITE_TYPE = boolean.class;
	
	/** Name of property content. */
	public static final String PROPERTY_CONTENT_NAME = "content";
	/** Type of property content. */
	public static final Class PROPERTY_CONTENT_TYPE = String.class;
	
	
	private final MPackage _package;
	
	private final String _name;
	
	private final XFile _file;
	
	private boolean _doNotWrite;
	
	private final List _content = new ArrayList();
	
	public MResource(final MPackage pPackage, final String pName) {
		super();
		if (pPackage == null) {
			throw new IllegalArgumentException("pPackage == null");
		}
		_package = pPackage;
		if (_package != null) {
			pPackage.addResource(this);
		}
		if (pName == null) {
			throw new IllegalArgumentException("pName == null");
		}
		_name = pName;
		_file = getPackage().getFolder().getFile(getName());
		if (_file == null) {
			throw new IllegalArgumentException("_file == null");
		}
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public void write(final IProgressMonitor pMonitor) throws CoreException {
		if (isDoNotWrite()) {
			return;
		}
		StringBuffer vCombinedContent = new StringBuffer();
		for (Iterator vContentI = contentIterator(); vContentI.hasNext();) {
			String vContent = (String) vContentI.next();
			vCombinedContent.append(vContent);
		}
		getFile().write(vCombinedContent.toString(), Boolean.TRUE, pMonitor);
	}
	// @ccg.userblock.end
	
	/**
	 * Return the value of property package.
	 * 
	 * @return The value of property package.
	 */
	public final MPackage getPackage() {
		return _package;
	}
	
	/**
	 * Return the value of property name.
	 * 
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}
	
	/**
	 * Return the value of property file.
	 * 
	 * @return The value of property file.
	 */
	public final XFile getFile() {
		return _file;
	}
	
	/**
	 * Return the value of property doNotWrite.
	 * 
	 * @return The value of property doNotWrite.
	 */
	public final boolean isDoNotWrite() {
		return _doNotWrite;
	}
	
	/**
	 * Set the value of property doNotWrite to the specified value.
	 * 
	 * @param pDoNotWrite The new value for property doNotWrite.
	 */
	public final void setDoNotWrite(final boolean pDoNotWrite) {
		if (_doNotWrite == pDoNotWrite) {
			return;
		}
		_doNotWrite = pDoNotWrite;
	}
	
	/**
	 * Returns the value of property content at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property content at the specified index.
	 * @see List#get(int)
	 */
	public final String getContent(final int index) {
		return (String) _content.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsContent(final Object pObject) {
		return _content.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property content.
	 * @see List#iterator()
	 */
	public final Iterator contentIterator() {
		return _content.iterator();
	}
	
	/**
	 * @return Is property content emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isContentEmpty() {
		return _content.isEmpty();
	}
	
	/**
	 * @return The number of values of property content.
	 * @see List#size()
	 */
	public final int contentSize() {
		return _content.size();
	}
	
	/**
	 * Add the specified value to property content.
	 * 
	 * @param pContent The additional value for property content.
	 * @see List#add(Object)
	 */
	public final void addContent(final String pContent) {
		if (_content.contains(pContent)) {
			return;
		}
		_content.add(pContent);
	}
	
	/**
	 * Remove the specified value of property content.
	 * 
	 * @param pContent The value to remove from property content.
	 * @see List#remove(Object)
	 */
	public final void removeContent(final String pContent) {
		if (!_content.contains(pContent)) {
			return;
		}
		_content.remove(pContent);
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
