package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;

/**
 * Subclasses are:<ul>
 * 	<li>{@link de.hasait.eclipse.ccg.javag.model.java.MStaticFieldDeclaration}</li>
 * 	<li>{@link de.hasait.eclipse.ccg.javag.model.java.MInstanceFieldDeclaration}</li>
 * </ul>
 * @author CCG /model/ccg/model.ccg.xml
 */
public abstract class AbstractMFieldDeclaration {
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
	
	/** Name of property visibility. */
	public static final String PROPERTY_VISIBILITY_NAME = "visibility";
	/** Type of property visibility. */
	public static final Class PROPERTY_VISIBILITY_TYPE = String.class;
	
	/** Name of property final. */
	public static final String PROPERTY_FINAL_NAME = "final";
	/** Type of property final. */
	public static final Class PROPERTY_FINAL_TYPE = boolean.class;
	
	/** Name of property value. */
	public static final String PROPERTY_VALUE_NAME = "value";
	/** Type of property value. */
	public static final Class PROPERTY_VALUE_TYPE = String.class;
	
	
	private AbstractMType _type;
	
	private String _name;
	
	private String _visibility;
	
	private boolean _final;
	
	private String _value;
	
	public AbstractMFieldDeclaration() {
		super();
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
	 * Set the value of property type to the specified value.
	 * 
	 * @param pType The new value for property type.
	 */
	public final void setType(final AbstractMType pType) {
		if (_type == pType) {
			return;
		}
		_type = pType;
	}
	
	/**
	 * Return the value of property name.
	 * 
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}
	
	/**
	 * Set the value of property name to the specified value.
	 * 
	 * @param pName The new value for property name.
	 */
	public final void setName(final String pName) {
		if (_name == pName) {
			return;
		}
		_name = pName;
	}
	
	/**
	 * Return the value of property visibility.
	 * 
	 * @return The value of property visibility.
	 */
	public final String getVisibility() {
		return _visibility;
	}
	
	/**
	 * Set the value of property visibility to the specified value.
	 * 
	 * @param pVisibility The new value for property visibility.
	 */
	public final void setVisibility(final String pVisibility) {
		if (_visibility == pVisibility) {
			return;
		}
		_visibility = pVisibility;
	}
	
	/**
	 * Return the value of property final.
	 * 
	 * @return The value of property final.
	 */
	public final boolean isFinal() {
		return _final;
	}
	
	/**
	 * Set the value of property final to the specified value.
	 * 
	 * @param pFinal The new value for property final.
	 */
	public final void setFinal(final boolean pFinal) {
		if (_final == pFinal) {
			return;
		}
		_final = pFinal;
	}
	
	/**
	 * Return the value of property value.
	 * 
	 * @return The value of property value.
	 */
	public final String getValue() {
		return _value;
	}
	
	/**
	 * Set the value of property value to the specified value.
	 * 
	 * @param pValue The new value for property value.
	 */
	public final void setValue(final String pValue) {
		if (_value == pValue) {
			return;
		}
		_value = pValue;
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
