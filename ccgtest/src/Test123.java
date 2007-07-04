import java.util.Iterator;

public class Test123 {
	// [c]
	// <property type="String" name="object" final="true"
	// cardinality="*" />
	// [/c][bs]878874dd0a0a0b2401fd03ab96acde4e[/bs]
	/**
	 * Property object
	 */
	public static final String PROPERTYNAME_OBJECT = "object";

	/**
	 * The many property field object.
	 */
	private final java.util.List _objects = new java.util.ArrayList();

	/**
	 * Return an array with all objects.
	 */
	public final String[] getObjects() {
		return (String[]) _objects.toArray(new String[_objects.size()]);
	}

	/**
	 * Return a list with all objects.
	 */
	public final java.util.List getObjectList() {
		return new java.util.ArrayList(_objects);
	}

	/**
	 * Return the object at the specified index.
	 */
	public final String getObject(final int index) {
		return (String) _objects.get(index);
	}

	/**
	 * Return if the specified object is contained.
	 */
	public final boolean containsObject(final String object) {
		return _objects.contains(object);
	}

	/**
	 * Return how many objects are contained.
	 */
	public final int objectSize() {
		return _objects.size();
	}

	/**
	 * Return if object is empty.
	 */
	public final boolean isObjectEmpty() {
		return _objects.isEmpty();
	}

	/**
	 * Return an {@link Iterator} for all objects.
	 */
	public final java.util.Iterator objectIterator() {
		return _objects.iterator();
	}

	/**
	 * Add the specified object.
	 */
	protected final void addObject(final String object) {
		if (_objects.contains(object)) {
			return;
		}
		_objects.add(object);
	}

	/**
	 * Remove the specified object.
	 */
	protected final void removeObject(final String object) {
		if (!_objects.contains(object)) {
			return;
		}
		_objects.remove(object);
	}

	/**
	 * Remove all objects.
	 */
	protected final void removeAllObjects() {
		String[] objects;
		objects = getObjects();
		for (int i = 0; i < objects.length; i++) {
			removeObject(objects[i]);
		}
	}

	// [be]878874dd0a0a0b2401fd03ab96acde4e[/be]

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
