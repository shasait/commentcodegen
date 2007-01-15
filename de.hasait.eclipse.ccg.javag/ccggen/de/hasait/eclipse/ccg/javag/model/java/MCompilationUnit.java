package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.ccg.javag.util.CodeUtils;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.resource.XFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MCompilationUnit extends AbstractMTypeContainer {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property package. */
	public static final String PROPERTY_PACKAGE_NAME = "package";
	/** Type of property package. */
	public static final Class PROPERTY_PACKAGE_TYPE = MPackage.class;
	
	/** Name of property compilationUnit. */
	public static final String PROPERTY_COMPILATION_UNIT_NAME = "compilationUnit";
	/** Type of property compilationUnit. */
	public static final Class PROPERTY_COMPILATION_UNIT_TYPE = MCompilationUnit.class;
	
	/** Name of property fullQualifiedName. */
	public static final String PROPERTY_FULL_QUALIFIED_NAME_NAME = "fullQualifiedName";
	/** Type of property fullQualifiedName. */
	public static final Class PROPERTY_FULL_QUALIFIED_NAME_TYPE = String.class;
	
	/** Name of property firstType. */
	public static final String PROPERTY_FIRST_TYPE_NAME = "firstType";
	/** Type of property firstType. */
	public static final Class PROPERTY_FIRST_TYPE_TYPE = AbstractMType.class;
	
	/** Name of property name. */
	public static final String PROPERTY_NAME_NAME = "name";
	/** Type of property name. */
	public static final Class PROPERTY_NAME_TYPE = String.class;
	
	/** Name of property file. */
	public static final String PROPERTY_FILE_NAME = "file";
	/** Type of property file. */
	public static final Class PROPERTY_FILE_TYPE = XFile.class;
	
	/** Name of property import. */
	public static final String PROPERTY_IMPORT_NAME = "import";
	/** Type of property import. */
	public static final Class PROPERTY_IMPORT_TYPE = AbstractMType.class;
	
	/** Name of property doNotWrite. */
	public static final String PROPERTY_DO_NOT_WRITE_NAME = "doNotWrite";
	/** Type of property doNotWrite. */
	public static final Class PROPERTY_DO_NOT_WRITE_TYPE = boolean.class;
	
	
	private final MPackage _package;
	
	private final MCompilationUnit _compilationUnit;
	
	private final String _fullQualifiedName;
	
	private AbstractMType _firstType;
	
	private String _name;
	
	private XFile _file;
	
	private final List _import = new ArrayList();
	
	private boolean _doNotWrite;
	
	public MCompilationUnit(final MPackage pPackage) {
		super();
		if (pPackage == null) {
			throw new IllegalArgumentException("pPackage == null");
		}
		_package = pPackage;
		if (_package != null) {
			pPackage.addCompilationUnit(this);
		}
		_compilationUnit = this;
		if (_compilationUnit == null) {
			throw new IllegalArgumentException("_compilationUnit == null");
		}
		_fullQualifiedName = getPackage().getFullQualifiedName();
		if (_fullQualifiedName == null) {
			throw new IllegalArgumentException("_fullQualifiedName == null");
		}
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public void write(final IProgressMonitor pMonitor) throws CoreException {
		if (isDoNotWrite()) {
			return;
		}
		Map vUserBlockContentByName;
		if (getFile().exists()) {
			String vFileContent = getFile().read();
			vUserBlockContentByName = CodeUtils.parseUserBlockContentByBlockName(vFileContent);
		} else {
			vUserBlockContentByName = null;
		}
		ContentBuffer vContent = new ContentBuffer();
		writeCompilationUnit(vContent, vUserBlockContentByName);
		getFile().write(vContent.getContent(), Boolean.TRUE, pMonitor);
	}

	private void writeCompilationUnit(final ContentBuffer pContent, final Map pUserBlockContentByName) {
		pContent.a("package").a(" ").a(getPackage().getFullQualifiedName()).p(";");
		pContent.p();
		if (!isImportEmpty()) {
			for (Iterator vImportI = importIterator(); vImportI.hasNext();) {
				AbstractMType vImport = (AbstractMType) vImportI.next();
				pContent.a("import").a(" ").a(vImport.getFullQualifiedName()).p(";");
			}
			pContent.p();
		}
		writeTypes(pContent, pUserBlockContentByName);
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
	 * Return the value of property compilationUnit.
	 * 
	 * @return The value of property compilationUnit.
	 */
	public final MCompilationUnit getCompilationUnit() {
		return _compilationUnit;
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
	 * Return the value of property firstType.
	 * 
	 * @return The value of property firstType.
	 */
	public final AbstractMType getFirstType() {
		return _firstType;
	}
	
	/**
	 * Set the value of property firstType to the specified value.
	 * 
	 * @param pFirstType The new value for property firstType.
	 */
	private final void setFirstType(final AbstractMType pFirstType) {
		if (_firstType == pFirstType) {
			return;
		}
		_firstType = pFirstType;
		updateName();
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
	 * Set the value of property name to the specified value.
	 * 
	 * @param pName The new value for property name.
	 */
	private final void setName(final String pName) {
		if (_name == pName) {
			return;
		}
		_name = pName;
		updateFile();
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
	 * Set the value of property file to the specified value.
	 * 
	 * @param pFile The new value for property file.
	 */
	private final void setFile(final XFile pFile) {
		if (_file == pFile) {
			return;
		}
		_file = pFile;
	}
	
	/**
	 * Returns the value of property import at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property import at the specified index.
	 * @see List#get(int)
	 */
	public final AbstractMType getImport(final int index) {
		return (AbstractMType) _import.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsImport(final Object pObject) {
		return _import.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property import.
	 * @see List#iterator()
	 */
	public final Iterator importIterator() {
		return _import.iterator();
	}
	
	/**
	 * @return Is property import emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isImportEmpty() {
		return _import.isEmpty();
	}
	
	/**
	 * @return The number of values of property import.
	 * @see List#size()
	 */
	public final int importSize() {
		return _import.size();
	}
	
	/**
	 * Add the specified value to property import.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.AbstractMType#PROPERTY_IMPORTED_NAME}, which will be updated by this method.
	 * 
	 * @param pImport The additional value for property import.
	 * @see List#add(Object)
	 */
	public final void addImport(final AbstractMType pImport) {
		if (_import.contains(pImport)) {
			return;
		}
		_import.add(pImport);
		if (!(pImport.getImported() == this)) {
			pImport.setImported(this);
		}
	}
	
	/**
	 * Remove the specified value of property import.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.AbstractMType#PROPERTY_IMPORTED_NAME}, which will be updated by this method.
	 * 
	 * @param pImport The value to remove from property import.
	 * @see List#remove(Object)
	 */
	public final void removeImport(final AbstractMType pImport) {
		if (!_import.contains(pImport)) {
			return;
		}
		_import.remove(pImport);
		if (pImport.getImported() == this) {
			pImport.setImported(null);
		}
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
	
	public final void updateFirstType() {
		super.updateFirstType();
		
							setFirstType(isTypeEmpty() ? null : getType(0));
						
	}
	
	public final void updateName() {
		
							AbstractMType vFirstType = getFirstType();
							setName(vFirstType == null ? null : vFirstType.getName());
						
	}
	
	public final void updateFile() {
		
							String vName = getName();
							setFile(vName == null ? null : getPackage().getFolder().getFile(vName));
						
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
