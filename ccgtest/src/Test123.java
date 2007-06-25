

public class Test123 {
	// [c]
	// <property type="String" name="foo5" final="true" />
	// [/c]
	// [bs]f3ee87c7c0a8001901c041ff851f0f40[/bs]

	/**
	 *  Property foo5
	 */
	public static final String PROPERTYNAME_FOO5 = "foo5";
	/** The single property field foo5. */
	private String _foo5;
	
	/**
	 * Returns the foo5.
	 */
	public final String getFoo5() {
			return _foo5;
	}
	
	/**
	 * Sets the foo5.
	 */
	protected final void setFoo5(final String foo5) {
			_foo5 = foo5;
	}
	// [be]f3ee87c7c0a8001901c041ff851f0f40[/be]

	public final void add() {

	}

	// [c]
	// <springin name="halloFoo" type="String" required="true" />
	// [/c][bs]528dd8100a0a0b2401892bd896fbabfa[/bs]

	private String _halloFoo;
	
	public final void setHalloFoo(final String halloFoo) {
		_halloFoo = halloFoo;
	}
	
	protected final String useHalloFoo() {
		if (_halloFoo == null) {
			throw new IllegalArgumentException("halloFoo == null");
		}
		return _halloFoo;
	}

	// [be]528dd8100a0a0b2401892bd896fbabfa[/be]	
}
