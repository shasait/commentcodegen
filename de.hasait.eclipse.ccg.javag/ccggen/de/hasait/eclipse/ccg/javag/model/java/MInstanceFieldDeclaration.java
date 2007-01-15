package de.hasait.eclipse.ccg.javag.model.java;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MInstanceFieldDeclaration extends AbstractMFieldDeclaration {
	// @ccg.userblock.start ClassBegin
	// @ccg.userblock.end

	/** Name of property owner. */
	public static final String PROPERTY_OWNER_NAME = "owner";
	/** Type of property owner. */
	public static final Class PROPERTY_OWNER_TYPE = MClass.class;


	private final MClass _owner;

	public MInstanceFieldDeclaration(final MClass pOwner) {
		super();
		if (pOwner == null) {
			throw new IllegalArgumentException("pOwner == null");
		}
		_owner = pOwner;
		if (_owner != null) {
			pOwner.addInstanceField(this);
		}
	}

	// @ccg.userblock.start ClassAfterConstructor
	// @ccg.userblock.end

	/**
	 * Return the value of property owner.

	 * @return The value of property owner.
	 */
	public final MClass getOwner() {
		return _owner;
	}


	// @ccg.userblock.start ClassEnd
	// @ccg.userblock.end
}
