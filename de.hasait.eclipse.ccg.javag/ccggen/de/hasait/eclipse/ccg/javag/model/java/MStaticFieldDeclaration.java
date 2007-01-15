package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MStaticFieldDeclaration extends AbstractMFieldDeclaration {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property owner. */
	public static final String PROPERTY_OWNER_NAME = "owner";
	/** Type of property owner. */
	public static final Class PROPERTY_OWNER_TYPE = AbstractMType.class;
	
	
	private final AbstractMType _owner;
	
	public MStaticFieldDeclaration(final AbstractMType pOwner) {
		super();
		if (pOwner == null) {
			throw new IllegalArgumentException("pOwner == null");
		}
		_owner = pOwner;
		if (_owner != null) {
			pOwner.addStaticField(this);
		}
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public void writeWithoutFlags(final ContentBuffer pContent) {
		pContent.a(getType().getFullQualifiedName());
		pContent.a(" ").a(getName());
		pContent.a(" = ").a(getValue());
		pContent.p(";");
	}

	public void writeWithFlags(final ContentBuffer pContent) {
		if (getVisibility() != null) {
			pContent.a(getVisibility()).a(" ");
		}
		if (isFinal()) {
			pContent.a("final").a(" ");
		}
		writeWithoutFlags(pContent);
	}
	// @ccg.userblock.end
	
	/**
	 * Return the value of property owner.
	 * 
	 * @return The value of property owner.
	 */
	public final AbstractMType getOwner() {
		return _owner;
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
