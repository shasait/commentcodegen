package de.hasait.eclipse.ccg.javag.model.java;

import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFolder;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MPackage {
	// @ccg.userblock.start ClassBegin
	// @ccg.userblock.end

	/** Name of property root. */
	public static final String PROPERTY_ROOT_NAME = "root";

	/** Type of property root. */
	public static final Class PROPERTY_ROOT_TYPE = MRoot.class;

	/** Name of property name. */
	public static final String PROPERTY_NAME_NAME = "name";

	/** Type of property name. */
	public static final Class PROPERTY_NAME_TYPE = String.class;

	/** Name of property fullQualifiedName. */
	public static final String PROPERTY_FULL_QUALIFIED_NAME_NAME = "fullQualifiedName";

	/** Type of property fullQualifiedName. */
	public static final Class PROPERTY_FULL_QUALIFIED_NAME_TYPE = String.class;

	/** Name of property folder. */
	public static final String PROPERTY_FOLDER_NAME = "folder";

	/** Type of property folder. */
	public static final Class PROPERTY_FOLDER_TYPE = XFolder.class;

	/** Name of property compilationUnit. */
	public static final String PROPERTY_COMPILATION_UNIT_NAME = "compilationUnit";

	/** Type of property compilationUnit. */
	public static final Class PROPERTY_COMPILATION_UNIT_TYPE = MCompilationUnit.class;

	/** Name of property resource. */
	public static final String PROPERTY_RESOURCE_NAME = "resource";

	/** Type of property resource. */
	public static final Class PROPERTY_RESOURCE_TYPE = MResource.class;

	private final MRoot _root;

	private final String _name;

	private final String _fullQualifiedName = getName();

	private final XFolder _folder = getRoot().getFolder()
	      .getFolder(StringUtil.replace(getFullQualifiedName(), ".", "/"));;

	private final java.util.List _compilationUnit = new java.util.ArrayList();

	private final java.util.List _resource = new java.util.ArrayList();

	public MPackage(final MRoot pRoot, final String pName) {
		super();
		if (pRoot == null) {
			throw new IllegalArgumentException("pRoot == null");
		}
		_root = pRoot;
		if (_root != null) {
			pRoot.addPackage(this);
		}
		if (pName == null) {
			throw new IllegalArgumentException("pName == null");
		}
		_name = pName;
		if (_fullQualifiedName == null) {
			throw new IllegalArgumentException("_fullQualifiedName == null");
		}
		if (_folder == null) {
			throw new IllegalArgumentException("_folder == null");
		}
	}

	// @ccg.userblock.start ClassAfterConstructor
	public void write(final IProgressMonitor pMonitor) throws CoreException {
		for (Iterator vCompilationUnitI = compilationUnitIterator(); vCompilationUnitI.hasNext();) {
			MCompilationUnit vCompilationUnit = (MCompilationUnit) vCompilationUnitI.next();
			vCompilationUnit.write(pMonitor);
		}
		for (Iterator vResourceI = resourceIterator(); vResourceI.hasNext();) {
			MResource vResource = (MResource) vResourceI.next();
			vResource.write(pMonitor);
		}
	}

	// @ccg.userblock.end

	/**
	 * Return the value of property root.
	 * 
	 * @return The value of property root.
	 */
	public final MRoot getRoot() {
		return _root;
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
	 * Return the value of property fullQualifiedName.
	 * 
	 * @return The value of property fullQualifiedName.
	 */
	public final String getFullQualifiedName() {
		return _fullQualifiedName;
	}

	/**
	 * Return the value of property folder.
	 * 
	 * @return The value of property folder.
	 */
	public final XFolder getFolder() {
		return _folder;
	}

	/**
	 * Returns the value of property compilationUnit at the specified index.
	 * 
	 * @param index
	 *           The index, which must be valid.
	 * @return The value of property compilationUnit at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final MCompilationUnit getCompilationUnit(final int index) {
		return (MCompilationUnit) _compilationUnit.get(index);
	}

	/**
	 * @param pObject
	 *           The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsCompilationUnit(final Object pObject) {
		return _compilationUnit.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property compilationUnit.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator compilationUnitIterator() {
		return _compilationUnit.iterator();
	}

	/**
	 * @return Is property compilationUnit emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isCompilationUnitEmpty() {
		return _compilationUnit.isEmpty();
	}

	/**
	 * @return The number of values of property compilationUnit.
	 * @see java.util.List#size()
	 */
	public final int compilationUnitSize() {
		return _compilationUnit.size();
	}

	/**
	 * Add the specified value to property compilationUnit. Referred from
	 * {@link de.hasait.eclipse.ccg.javag.model.java.MCompilationUnit#PROPERTY_PACKAGE_NAME}, which will be updated by
	 * this method.
	 * 
	 * @param pCompilationUnit
	 *           The additional value for property compilationUnit.
	 * @see java.util.List#add(Object)
	 */
	public final void addCompilationUnit(final MCompilationUnit pCompilationUnit) {
		if (_compilationUnit.contains(pCompilationUnit)) {
			return;
		}
		if (!(pCompilationUnit.getPackage() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_compilationUnit.add(pCompilationUnit);
	}

	/**
	 * Returns the value of property resource at the specified index.
	 * 
	 * @param index
	 *           The index, which must be valid.
	 * @return The value of property resource at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final MResource getResource(final int index) {
		return (MResource) _resource.get(index);
	}

	/**
	 * @param pObject
	 *           The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsResource(final Object pObject) {
		return _resource.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property resource.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator resourceIterator() {
		return _resource.iterator();
	}

	/**
	 * @return Is property resource emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isResourceEmpty() {
		return _resource.isEmpty();
	}

	/**
	 * @return The number of values of property resource.
	 * @see java.util.List#size()
	 */
	public final int resourceSize() {
		return _resource.size();
	}

	/**
	 * Add the specified value to property resource. Referred from
	 * {@link de.hasait.eclipse.ccg.javag.model.java.MResource#PROPERTY_PACKAGE_NAME}, which will be updated by this
	 * method.
	 * 
	 * @param pResource
	 *           The additional value for property resource.
	 * @see java.util.List#add(Object)
	 */
	public final void addResource(final MResource pResource) {
		if (_resource.contains(pResource)) {
			return;
		}
		if (!(pResource.getPackage() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_resource.add(pResource);
	}

	// @ccg.userblock.start ClassEnd
	// @ccg.userblock.end
}
