import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Demonstration:
 * <ul>
 * <li>Contains a hooked multi-property with afterchanged-option.</li>
 * <li>A two-sided relation.</li>
 * <li>A simple bound property.</li>
 * </ul>
 * All with a few lines of comment.
 */
public class Test123 {
	/**
	 * Callback for a <code>hooked</code> property. Invoked after an object is
	 * added or set.
	 * 
	 * @param object
	 *            the object.
	 */
	private void newObject(Object object) {
		// do something, e.g. add listener
	}

	/**
	 * Callback for a <code>hooked</code> property. Invoked after an object is
	 * removed or unset (set to <code>null</code>).
	 * 
	 * @param object
	 *            the object.
	 */
	private void oldObject(Object object) {
		// do something, e.g. remove listener installed in newObject
	}

	/**
	 * Callback for a property with <code>afterchanged</code> set to
	 * <code>true</code>.
	 * 
	 */
	private void afterObjectsChanged() {
		// e.g. iterate objects and update layout...
	}

	// [c]
	// <property name="object" type="Object" cardinality="*" hooked="true"
	// afterchanged="true" />
	// <property name="relatedObject" type="RelatedObject" cardinality="*"
	// backref="object" />
	// <property name="text" type="String" bound="true" />
	// [/c][bs]878874dd0a0a0b2401fd03ab96acde4e[/bs]

	/**
	 * Property object.
	 */
	public static final String PROPERTYNAME_OBJECT = "object";

	/**
	 * The many property field object.
	 */
	private final java.util.List _objects = new java.util.ArrayList();

	/**
	 * Return an array with all objects.
	 */
	public final Object[] getObjects() {
		return (Object[]) _objects.toArray(new Object[_objects.size()]);
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
	public final Object getObject(final int index) {
		return (Object) _objects.get(index);
	}

	/**
	 * Return if the specified object is contained.
	 */
	public final boolean containsObject(final Object object) {
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
	public final boolean isObjectsEmpty() {
		return _objects.isEmpty();
	}

	/**
	 * Return an {@link java.util.Iterator} for all objects.
	 */
	public final java.util.Iterator objectsIterator() {
		return _objects.iterator();
	}

	/**
	 * Add the specified object.
	 */
	public final void addObject(final Object object) {
		if (!doAddObject(object)) {
			return;
		}
		afterObjectsChanged();
	}

	private boolean doAddObject(final Object object) {
		if (_objects.contains(object)) {
			return false;
		}
		_objects.add(object);
		newObject(object);
		return true;
	}

	/**
	 * Add all objects.
	 */
	public final void addObjects(final Object[] objects) {
		for (int i = 0; i < objects.length; i++) {
			doAddObject(objects[i]);
		}
		afterObjectsChanged();
	}

	/**
	 * Remove the specified object.
	 */
	public final void removeObject(final Object object) {
		if (doRemoveObject(object)) {
			return;
		}
		afterObjectsChanged();
	}

	private boolean doRemoveObject(final Object object) {
		if (!_objects.contains(object)) {
			return false;
		}
		oldObject(object);
		_objects.remove(object);
		return true;
	}

	/**
	 * Remove all objects.
	 */
	public final void removeObjects() {
		Object[] objects;
		objects = getObjects();
		for (int i = 0; i < objects.length; i++) {
			doRemoveObject(objects[i]);
		}
		afterObjectsChanged();
	}

	/**
	 * Set all objects.
	 */
	public final void setObjects(final Object[] objects) {
		Object[] oldObjects;
		oldObjects = getObjects();
		for (int i = 0; i < oldObjects.length; i++) {
			doRemoveObject(oldObjects[i]);
		}
		for (int i = 0; i < objects.length; i++) {
			doAddObject(objects[i]);
		}
		afterObjectsChanged();
	}


	/**
	 * Property relatedObject.
	 */
	public static final String PROPERTYNAME_RELATEDOBJECT = "relatedObject";

	/**
	 * The many property field relatedObject.
	 */
	private final java.util.List _relatedObjects = new java.util.ArrayList();

	/**
	 * Return an array with all relatedObjects.
	 */
	public final RelatedObject[] getRelatedObjects() {
		return (RelatedObject[]) _relatedObjects.toArray(new RelatedObject[_relatedObjects.size()]);
	}

	/**
	 * Return a list with all relatedObjects.
	 */
	public final java.util.List getRelatedObjectList() {
		return new java.util.ArrayList(_relatedObjects);
	}

	/**
	 * Return the relatedObject at the specified index.
	 */
	public final RelatedObject getRelatedObject(final int index) {
		return (RelatedObject) _relatedObjects.get(index);
	}

	/**
	 * Return if the specified relatedObject is contained.
	 */
	public final boolean containsRelatedObject(final RelatedObject relatedObject) {
		return _relatedObjects.contains(relatedObject);
	}

	/**
	 * Return how many relatedObjects are contained.
	 */
	public final int relatedObjectSize() {
		return _relatedObjects.size();
	}

	/**
	 * Return if relatedObject is empty.
	 */
	public final boolean isRelatedObjectsEmpty() {
		return _relatedObjects.isEmpty();
	}

	/**
	 * Return an {@link java.util.Iterator} for all relatedObjects.
	 */
	public final java.util.Iterator relatedObjectsIterator() {
		return _relatedObjects.iterator();
	}

	/**
	 * Add the specified relatedObject.
	 */
	public final void addRelatedObject(final RelatedObject relatedObject) {
		if (!doAddRelatedObject(relatedObject)) {
			return;
		}
	}

	private boolean doAddRelatedObject(final RelatedObject relatedObject) {
		if (_relatedObjects.contains(relatedObject)) {
			return false;
		}
		relatedObject.setObject(null);
		_relatedObjects.add(relatedObject);
		relatedObject.setObject(this);
		return true;
	}

	/**
	 * Add all relatedObjects.
	 */
	public final void addRelatedObjects(final RelatedObject[] relatedObjects) {
		for (int i = 0; i < relatedObjects.length; i++) {
			doAddRelatedObject(relatedObjects[i]);
		}
	}

	/**
	 * Remove the specified relatedObject.
	 */
	public final void removeRelatedObject(final RelatedObject relatedObject) {
		if (doRemoveRelatedObject(relatedObject)) {
			return;
		}
	}

	private boolean doRemoveRelatedObject(final RelatedObject relatedObject) {
		if (!_relatedObjects.contains(relatedObject)) {
			return false;
		}
		_relatedObjects.remove(relatedObject);
		relatedObject.setObject(null);
		return true;
	}

	/**
	 * Remove all relatedObjects.
	 */
	public final void removeRelatedObjects() {
		RelatedObject[] relatedObjects;
		relatedObjects = getRelatedObjects();
		for (int i = 0; i < relatedObjects.length; i++) {
			doRemoveRelatedObject(relatedObjects[i]);
		}
	}

	/**
	 * Set all relatedObjects.
	 */
	public final void setRelatedObjects(final RelatedObject[] relatedObjects) {
		RelatedObject[] oldRelatedObjects;
		oldRelatedObjects = getRelatedObjects();
		for (int i = 0; i < oldRelatedObjects.length; i++) {
			doRemoveRelatedObject(oldRelatedObjects[i]);
		}
		for (int i = 0; i < relatedObjects.length; i++) {
			doAddRelatedObject(relatedObjects[i]);
		}
	}


	/**
	 * Property text.
	 */
	public static final String PROPERTYNAME_TEXT = "text";

	/**
	 * The single property field text.
	 */
	private String _text;

	/**
	 * Return the text.
	 */
	public final String getText() {
		return _text;
	}

	/**
	 * Set the text.
	 */
	public final void setText(final String text) {
		String oldText;
		oldText = _text;
		if (!doSetText(text)) {
			return;
		}
		firePropertyChange(PROPERTYNAME_TEXT, oldText, text);
	}

	private boolean doSetText(final String text) {
		if (_text == text) {
			return false;
		}
		_text = text;
		return true;
	}

	/**
	 * Return the text.
	 */
	protected final String useText() {
		return _text;
	}

	// [be]878874dd0a0a0b2401fd03ab96acde4e[/be]

	// The following code must be included, if bound properties are used.

	private final PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(
			this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		_propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		_propertyChangeSupport
				.addPropertyChangeListener(propertyName, listener);
	}

	public void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		_propertyChangeSupport.firePropertyChange(propertyName, oldValue,
				newValue);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		_propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		_propertyChangeSupport.removePropertyChangeListener(propertyName,
				listener);
	}
}
