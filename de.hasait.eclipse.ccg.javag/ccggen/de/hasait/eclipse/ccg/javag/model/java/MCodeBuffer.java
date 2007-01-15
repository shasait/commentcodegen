package de.hasait.eclipse.ccg.javag.model.java;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MCodeBuffer {
	// @ccg.userblock.start ClassBegin
	// @ccg.userblock.end

	/** Name of property statement. */
	public static final String PROPERTY_STATEMENT_NAME = "statement";
	/** Type of property statement. */
	public static final Class PROPERTY_STATEMENT_TYPE = AbstractMCodeStatement.class;


	private final java.util.List _statement = new java.util.ArrayList();

	public MCodeBuffer() {
		super();
	}

	// @ccg.userblock.start ClassAfterConstructor
	// @ccg.userblock.end

	/**
	 * Returns the value of property statement at the specified index.

	 * @param index The index, which must be valid.
	 * @return The value of property statement at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final AbstractMCodeStatement getStatement(final int index) {
		return (AbstractMCodeStatement) _statement.get(index);
	}

	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsStatement(final Object pObject) {
		return _statement.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property statement.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator statementIterator() {
		return _statement.iterator();
	}

	/**
	 * @return Is property statement emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isStatementEmpty() {
		return _statement.isEmpty();
	}

	/**
	 * @return The number of values of property statement.
	 * @see java.util.List#size()
	 */
	public final int statementSize() {
		return _statement.size();
	}

	/**
	 * Add the specified value to property statement.

	 * @param pStatement The additional value for property statement.
	 * @see java.util.List#add(Object)
	 */
	public final void addStatement(final AbstractMCodeStatement pStatement) {
		if (_statement.contains(pStatement)) {
			return;
		}
		_statement.add(pStatement);
	}

	/**
	 * Remove the specified value of property statement.

	 * @param pStatement The value to remove from property statement.
	 * @see java.util.List#remove(Object)
	 */
	public final void removeStatement(final AbstractMCodeStatement pStatement) {
		if (!_statement.contains(pStatement)) {
			return;
		}
		_statement.remove(pStatement);
	}


	// @ccg.userblock.start ClassEnd
	// @ccg.userblock.end
}
