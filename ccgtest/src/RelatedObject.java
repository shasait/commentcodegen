
public class RelatedObject {
	// [c]
	// <property name="object" type="Test123" backref="relatedObject" backrefcardinality="*" />
	// <property name="text" type="String" />
	// [/c][bs]878874dd0a0a0b2401fd03ab96acde4e[/bs]

	/**
	 * Property object.
	 */
	public static final String PROPERTYNAME_OBJECT = "object";

	/**
	 * The single property field object.
	 */
	private Test123 _object;

	/**
	 * Return the object.
	 */
	public final Test123 getObject() {
		return _object;
	}

	/**
	 * Set the object.
	 */
	public final void setObject(final Test123 object) {
		if (!doSetObject(object)) {
			return;
		}
	}

	private boolean doSetObject(final Test123 object) {
		if (_object == object) {
			return false;
		}
		if (_object != null) {
			Test123 oldObject = _object;
			_object = null;
			oldObject.removeRelatedObject(this);
		}
		_object = object;
		if (_object != null) {
			object.addRelatedObject(this);
		}
		return true;
	}

	/**
	 * Return the object.
	 */
	protected final Test123 useObject() {
		return _object;
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
		if (!doSetText(text)) {
			return;
		}
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
}
