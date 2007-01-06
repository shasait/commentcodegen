

public class Test123 {
	// [c]
	// <property type="String" name="foo" cardinality="*" hooked="true" />
	// [/c]
	// [bs]f3ee87c7c0a8001901c041ff851f0f40[/bs]

	/**
	 *  Property foo
	 */
	public static final String PROPERTYNAME_FOO = "foos";
	/** The many property field foo. */
	private final java.util.List _foos = new java.util.ArrayList();

	/**
	 * Returns the array of all foos.
	 */
	public final String[] getFoos() {
			return (String[])_foos.toArray(new String[_foos.size()]);
	}

	/**
	 * Returns the foo at the specified index.
	 */
	public final String getFoo(final int index) {
			return (String)_foos.get(index);
	}

	/**
	 * Returns if the specified foo is contained.
	 */
	public final boolean containsFoo(final String foo) {
			return _foos.contains(foo);
	}

	/**
	 * Returns how many foos are contained.
	 */
	public final int fooSize() {
			return _foos.size();
	}

	/**
	 * Returns if foo is empty.
	 */
	public final boolean isFooEmpty() {
			return _foos.isEmpty();
	}

	/**
	 * Returns an {@link Iterator} for all foos.
	 */
	public final java.util.Iterator fooIterator() {
			return _foos.iterator();
	}

	/**
	 * Adds the specified foo.
	 */
	public final void addFoo(final String foo) {
			if (_foos.contains(foo)) {
				return;
			}
			_foos.add(foo);
			newFoo(foo);
	}
		
	/**
	 * Removes the specified foo.
	 */
	public final void removeFoo(final String foo) {
			if (!_foos.contains(foo)) {
				return;
			}
			_foos.remove(foo);
			oldFoo(foo);
	}

	/**
	 * Remove all foos.
	 */
	public final void removeAllFoos() {
		String[] foos;
			foos = getFoos();
		for (int i=0; i<foos.length; i++) {
			removeFoo(foos[i]);
		}
	}
	// [be]f3ee87c7c0a8001901c041ff851f0f40[/be]

	public final void add() {

	}
}
