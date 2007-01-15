package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.ccg.javag.util.CodeUtils;
import de.hasait.eclipse.common.ContentBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Subclasses are:<ul>
 * 	<li>{@link de.hasait.eclipse.ccg.javag.model.java.MClass}</li>
 * 	<li>{@link de.hasait.eclipse.ccg.javag.model.java.MInterface}</li>
 * </ul>
 * @author CCG /model/ccg/model.ccg.xml
 */
public abstract class AbstractMType extends AbstractMTypeContainer {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property container. */
	public static final String PROPERTY_CONTAINER_NAME = "container";
	/** Type of property container. */
	public static final Class PROPERTY_CONTAINER_TYPE = AbstractMTypeContainer.class;
	
	/** Name of property compilationUnit. */
	public static final String PROPERTY_COMPILATION_UNIT_NAME = "compilationUnit";
	/** Type of property compilationUnit. */
	public static final Class PROPERTY_COMPILATION_UNIT_TYPE = MCompilationUnit.class;
	
	/** Name of property name. */
	public static final String PROPERTY_NAME_NAME = "name";
	/** Type of property name. */
	public static final Class PROPERTY_NAME_TYPE = String.class;
	
	/** Name of property fullQualifiedName. */
	public static final String PROPERTY_FULL_QUALIFIED_NAME_NAME = "fullQualifiedName";
	/** Type of property fullQualifiedName. */
	public static final Class PROPERTY_FULL_QUALIFIED_NAME_TYPE = String.class;
	
	/** Name of property imported. */
	public static final String PROPERTY_IMPORTED_NAME = "imported";
	/** Type of property imported. */
	public static final Class PROPERTY_IMPORTED_TYPE = MCompilationUnit.class;
	
	/** Name of property abstractMethod. */
	public static final String PROPERTY_ABSTRACT_METHOD_NAME = "abstractMethod";
	/** Type of property abstractMethod. */
	public static final Class PROPERTY_ABSTRACT_METHOD_TYPE = MMethodDeclaration.class;
	
	/** Name of property staticField. */
	public static final String PROPERTY_STATIC_FIELD_NAME = "staticField";
	/** Type of property staticField. */
	public static final Class PROPERTY_STATIC_FIELD_TYPE = MStaticFieldDeclaration.class;
	
	/** Name of property visibility. */
	public static final String PROPERTY_VISIBILITY_NAME = "visibility";
	/** Type of property visibility. */
	public static final Class PROPERTY_VISIBILITY_TYPE = String.class;
	
	
	private final AbstractMTypeContainer _container;
	
	private final MCompilationUnit _compilationUnit;
	
	private final String _name;
	
	private final String _fullQualifiedName;
	
	private MCompilationUnit _imported;
	
	private final List _abstractMethod = new ArrayList();
	
	private final List _staticField = new ArrayList();
	
	private String _visibility;
	
	public AbstractMType(final AbstractMTypeContainer pContainer, final String pName) {
		super();
		if (pContainer == null) {
			throw new IllegalArgumentException("pContainer == null");
		}
		_container = pContainer;
		if (_container != null) {
			pContainer.addType(this);
		}
		_compilationUnit = getContainer().getCompilationUnit();
		if (_compilationUnit == null) {
			throw new IllegalArgumentException("_compilationUnit == null");
		}
		if (pName == null) {
			throw new IllegalArgumentException("pName == null");
		}
		_name = pName;
		_fullQualifiedName = getContainer().getFullQualifiedName() + "." + getName();
		if (_fullQualifiedName == null) {
			throw new IllegalArgumentException("_fullQualifiedName == null");
		}
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public abstract void write(ContentBuffer pContent, Map pUserBlockContentByName);
	// @ccg.userblock.end
	
	/**
	 * Return the value of property container.
	 * 
	 * @return The value of property container.
	 */
	public final AbstractMTypeContainer getContainer() {
		return _container;
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
	 * Return the value of property imported.
	 * 
	 * @return The value of property imported.
	 */
	public final MCompilationUnit getImported() {
		return _imported;
	}
	
	/**
	 * Set the value of property imported to the specified value.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MCompilationUnit#PROPERTY_IMPORT_NAME}, which will be updated by this method.
	 * 
	 * @param pImported The new value for property imported.
	 */
	public final void setImported(final MCompilationUnit pImported) {
		if (_imported == pImported) {
			return;
		}
		MCompilationUnit vImported = _imported;
		_imported = pImported;
		if (vImported != null) {
			if (vImported.containsImport(this)) {
				vImported.removeImport(this);
			}
		}
		if (pImported != null) {
			pImported.addImport(this);
		}
	}
	
	/**
	 * Returns the value of property abstractMethod at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property abstractMethod at the specified index.
	 * @see List#get(int)
	 */
	public final MMethodDeclaration getAbstractMethod(final int index) {
		return (MMethodDeclaration) _abstractMethod.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsAbstractMethod(final Object pObject) {
		return _abstractMethod.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property abstractMethod.
	 * @see List#iterator()
	 */
	public final Iterator abstractMethodIterator() {
		return _abstractMethod.iterator();
	}
	
	/**
	 * @return Is property abstractMethod emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isAbstractMethodEmpty() {
		return _abstractMethod.isEmpty();
	}
	
	/**
	 * @return The number of values of property abstractMethod.
	 * @see List#size()
	 */
	public final int abstractMethodSize() {
		return _abstractMethod.size();
	}
	
	/**
	 * Add the specified value to property abstractMethod.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MMethodDeclaration#PROPERTY_OWNER_NAME}, which will be updated by this method.
	 * 
	 * @param pAbstractMethod The additional value for property abstractMethod.
	 * @see List#add(Object)
	 */
	public final void addAbstractMethod(final MMethodDeclaration pAbstractMethod) {
		if (_abstractMethod.contains(pAbstractMethod)) {
			return;
		}
		if (!(pAbstractMethod.containsOwner(this))) {
			throw new IllegalArgumentException("backref != this");
		}
		_abstractMethod.add(pAbstractMethod);
	}
	
	/**
	 * Returns the value of property staticField at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property staticField at the specified index.
	 * @see List#get(int)
	 */
	public final MStaticFieldDeclaration getStaticField(final int index) {
		return (MStaticFieldDeclaration) _staticField.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsStaticField(final Object pObject) {
		return _staticField.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property staticField.
	 * @see List#iterator()
	 */
	public final Iterator staticFieldIterator() {
		return _staticField.iterator();
	}
	
	/**
	 * @return Is property staticField emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isStaticFieldEmpty() {
		return _staticField.isEmpty();
	}
	
	/**
	 * @return The number of values of property staticField.
	 * @see List#size()
	 */
	public final int staticFieldSize() {
		return _staticField.size();
	}
	
	/**
	 * Add the specified value to property staticField.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MStaticFieldDeclaration#PROPERTY_OWNER_NAME}, which will be updated by this method.
	 * 
	 * @param pStaticField The additional value for property staticField.
	 * @see List#add(Object)
	 */
	public final void addStaticField(final MStaticFieldDeclaration pStaticField) {
		if (_staticField.contains(pStaticField)) {
			return;
		}
		if (!(pStaticField.getOwner() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_staticField.add(pStaticField);
	}
	
	/**
	 * Return the value of property visibility.
	 * 
	 * @return The value of property visibility.
	 */
	public final String getVisibility() {
		return _visibility;
	}
	
	/**
	 * Set the value of property visibility to the specified value.
	 * 
	 * @param pVisibility The new value for property visibility.
	 */
	public final void setVisibility(final String pVisibility) {
		if (_visibility == pVisibility) {
			return;
		}
		_visibility = pVisibility;
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
