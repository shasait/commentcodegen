package de.hasait.eclipse.ccg.javag.model.java;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MInterface extends AbstractMType {
	// @ccg.userblock.start ClassBegin
	// @ccg.userblock.end

	/** Name of property implementor. */
	public static final String PROPERTY_IMPLEMENTOR_NAME = "implementor";
	/** Type of property implementor. */
	public static final Class PROPERTY_IMPLEMENTOR_TYPE = MClass.class;


	private final java.util.List _implementor = new java.util.ArrayList();

	public MInterface(final AbstractMTypeContainer pContainer, final String pName) {
		super(pContainer, pName);
	}

	// @ccg.userblock.start ClassAfterConstructor
	// @ccg.userblock.end

	/**
	 * Returns the value of property implementor at the specified index.

	 * @param index The index, which must be valid.
	 * @return The value of property implementor at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final MClass getImplementor(final int index) {
		return (MClass) _implementor.get(index);
	}

	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsImplementor(final Object pObject) {
		return _implementor.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property implementor.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator implementorIterator() {
		return _implementor.iterator();
	}

	/**
	 * @return Is property implementor emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isImplementorEmpty() {
		return _implementor.isEmpty();
	}

	/**
	 * @return The number of values of property implementor.
	 * @see java.util.List#size()
	 */
	public final int implementorSize() {
		return _implementor.size();
	}

	/**
	 * Add the specified value to property implementor.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MClass#PROPERTY_IMPLEMENTS_NAME}, which will be updated by this method.

	 * @param pImplementor The additional value for property implementor.
	 * @see java.util.List#add(Object)
	 */
	public final void addImplementor(final MClass pImplementor) {
		if (_implementor.contains(pImplementor)) {
			return;
		}
		_implementor.add(pImplementor);
		if (!(pImplementor.containsImplements(this))) {
			pImplementor.addImplements(this);
		}
	}

	/**
	 * Remove the specified value of property implementor.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MClass#PROPERTY_IMPLEMENTS_NAME}, which will be updated by this method.

	 * @param pImplementor The value to remove from property implementor.
	 * @see java.util.List#remove(Object)
	 */
	public final void removeImplementor(final MClass pImplementor) {
		if (!_implementor.contains(pImplementor)) {
			return;
		}
		_implementor.remove(pImplementor);
		if (pImplementor.containsImplements(this)) {
			pImplementor.removeImplements(this);
		}
	}


	// @ccg.userblock.start ClassEnd
	// @ccg.userblock.end
}
