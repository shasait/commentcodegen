package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Subclasses are:<ul>
 * 	<li>{@link de.hasait.eclipse.ccg.javag.model.java.MCompilationUnit}</li>
 * 	<li>{@link de.hasait.eclipse.ccg.javag.model.java.AbstractMType}</li>
 * </ul>
 * @author CCG /model/ccg/model.ccg.xml
 */
public abstract class AbstractMTypeContainer {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property type. */
	public static final String PROPERTY_TYPE_NAME = "type";
	/** Type of property type. */
	public static final Class PROPERTY_TYPE_TYPE = AbstractMType.class;
	
	/** Name of property compilationUnit. */
	public static final String PROPERTY_COMPILATION_UNIT_NAME = "compilationUnit";
	/** Type of property compilationUnit. */
	public static final Class PROPERTY_COMPILATION_UNIT_TYPE = MCompilationUnit.class;
	
	/** Name of property fullQualifiedName. */
	public static final String PROPERTY_FULL_QUALIFIED_NAME_NAME = "fullQualifiedName";
	/** Type of property fullQualifiedName. */
	public static final Class PROPERTY_FULL_QUALIFIED_NAME_TYPE = String.class;
	
	
	private final List _type = new ArrayList();
	
	public AbstractMTypeContainer() {
		super();
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public void writeTypes(final ContentBuffer pContent) {
		for (Iterator vTypeI = _type.iterator(); vTypeI.hasNext();) {
			AbstractMType vType = (AbstractMType) vTypeI.next();
			vType.write(pContent);
		}
	}
	// @ccg.userblock.end
	
	/**
	 * Returns the value of property type at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property type at the specified index.
	 * @see List#get(int)
	 */
	public final AbstractMType getType(final int index) {
		return (AbstractMType) _type.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsType(final Object pObject) {
		return _type.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property type.
	 * @see List#iterator()
	 */
	public final Iterator typeIterator() {
		return _type.iterator();
	}
	
	/**
	 * @return Is property type emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isTypeEmpty() {
		return _type.isEmpty();
	}
	
	/**
	 * @return The number of values of property type.
	 * @see List#size()
	 */
	public final int typeSize() {
		return _type.size();
	}
	
	/**
	 * Add the specified value to property type.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.AbstractMType#PROPERTY_CONTAINER_NAME}, which will be updated by this method.
	 * 
	 * @param pType The additional value for property type.
	 * @see List#add(Object)
	 */
	public final void addType(final AbstractMType pType) {
		if (_type.contains(pType)) {
			return;
		}
		if (!(pType.getContainer() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_type.add(pType);
		updateFirstType();
	}
	
	/**
	 * Return the value of property compilationUnit.
	 * 
	 * @return The value of property compilationUnit.
	 */
	public abstract MCompilationUnit getCompilationUnit();
	
	/**
	 * Return the value of property fullQualifiedName.
	 * 
	 * @return The value of property fullQualifiedName.
	 */
	public abstract String getFullQualifiedName();
	
	/** Extended by {@link de.hasait.eclipse.ccg.javag.model.java.MCompilationUnit} */
	protected void updateFirstType() {
		// nop
	}
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
