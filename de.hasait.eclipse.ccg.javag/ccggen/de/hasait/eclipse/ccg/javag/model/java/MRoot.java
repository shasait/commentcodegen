package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MRoot {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property folder. */
	public static final String PROPERTY_FOLDER_NAME = "folder";
	/** Type of property folder. */
	public static final Class PROPERTY_FOLDER_TYPE = XFolder.class;
	
	/** Name of property package. */
	public static final String PROPERTY_PACKAGE_NAME = "package";
	/** Type of property package. */
	public static final Class PROPERTY_PACKAGE_TYPE = MPackage.class;
	
	
	private final XFolder _folder;
	
	private final List _package = new ArrayList();
	
	public MRoot(final XFolder pFolder) {
		super();
		if (pFolder == null) {
			throw new IllegalArgumentException("pFolder == null");
		}
		_folder = pFolder;
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public void write(final IProgressMonitor pMonitor) throws CoreException {
		for (Iterator vPackageI = packageIterator(); vPackageI.hasNext();) {
			MPackage vPackage = (MPackage) vPackageI.next();
			vPackage.write(pMonitor);
		}
	}
	// @ccg.userblock.end
	
	/**
	 * Return the value of property folder.
	 * 
	 * @return The value of property folder.
	 */
	public final XFolder getFolder() {
		return _folder;
	}
	
	/**
	 * Returns the value of property package at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property package at the specified index.
	 * @see List#get(int)
	 */
	public final MPackage getPackage(final int index) {
		return (MPackage) _package.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsPackage(final Object pObject) {
		return _package.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property package.
	 * @see List#iterator()
	 */
	public final Iterator packageIterator() {
		return _package.iterator();
	}
	
	/**
	 * @return Is property package emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isPackageEmpty() {
		return _package.isEmpty();
	}
	
	/**
	 * @return The number of values of property package.
	 * @see List#size()
	 */
	public final int packageSize() {
		return _package.size();
	}
	
	/**
	 * Add the specified value to property package.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MPackage#PROPERTY_ROOT_NAME}, which will be updated by this method.
	 * 
	 * @param pPackage The additional value for property package.
	 * @see List#add(Object)
	 */
	public final void addPackage(final MPackage pPackage) {
		if (_package.contains(pPackage)) {
			return;
		}
		if (!(pPackage.getRoot() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_package.add(pPackage);
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
