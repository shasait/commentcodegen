package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MMethodParameterDeclaration {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property type. */
	public static final String PROPERTY_TYPE_NAME = "type";
	/** Type of property type. */
	public static final Class PROPERTY_TYPE_TYPE = AbstractMType.class;
	
	/** Name of property name. */
	public static final String PROPERTY_NAME_NAME = "name";
	/** Type of property name. */
	public static final Class PROPERTY_NAME_TYPE = String.class;
	
	
	private final AbstractMType _type;
	
	private final String _name;
	
	public MMethodParameterDeclaration(final AbstractMType pType, final String pName) {
		super();
		if (pType == null) {
			throw new IllegalArgumentException("pType == null");
		}
		_type = pType;
		if (pName == null) {
			throw new IllegalArgumentException("pName == null");
		}
		_name = pName;
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	
	// @ccg.userblock.end
	
	/**
	 * Return the value of property type.
	 * 
	 * @return The value of property type.
	 */
	public final AbstractMType getType() {
		return _type;
	}
	
	/**
	 * Return the value of property name.
	 * 
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
