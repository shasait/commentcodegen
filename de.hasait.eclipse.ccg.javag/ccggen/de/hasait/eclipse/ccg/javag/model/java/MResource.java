package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
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
	
	
	private final MPackage _package;
	
	private final String _name;
	
	private final XFile _file;
	
	private boolean _doNotWrite;
	
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
		_file = 
						getPackage().getFolder().getFile(getName())
					;
		if (_file == null) {
			throw new IllegalArgumentException("_file == null");
		}
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public void write(IProgressMonitor pMonitor) {
		if (isDoNotWrite()) {
			return;
		}
		// TODO
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
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
