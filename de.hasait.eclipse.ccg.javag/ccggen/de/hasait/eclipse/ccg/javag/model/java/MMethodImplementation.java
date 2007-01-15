package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MMethodImplementation {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property owner. */
	public static final String PROPERTY_OWNER_NAME = "owner";
	/** Type of property owner. */
	public static final Class PROPERTY_OWNER_TYPE = MClass.class;
	
	/** Name of property declaration. */
	public static final String PROPERTY_DECLARATION_NAME = "declaration";
	/** Type of property declaration. */
	public static final Class PROPERTY_DECLARATION_TYPE = MMethodDeclaration.class;
	
	/** Name of property parameterFinal. */
	public static final String PROPERTY_PARAMETER_FINAL_NAME = "parameterFinal";
	/** Type of property parameterFinal. */
	public static final Class PROPERTY_PARAMETER_FINAL_TYPE = Boolean.class;
	
	/** Name of property parameterName. */
	public static final String PROPERTY_PARAMETER_NAME_NAME = "parameterName";
	/** Type of property parameterName. */
	public static final Class PROPERTY_PARAMETER_NAME_TYPE = String.class;
	
	/** Name of property code. */
	public static final String PROPERTY_CODE_NAME = "code";
	/** Type of property code. */
	public static final Class PROPERTY_CODE_TYPE = MCodeBuffer.class;
	
	
	private final MClass _owner;
	
	private final MMethodDeclaration _declaration;
	
	private final List _parameterFinal = new ArrayList();
	
	private final List _parameterName = new ArrayList();
	
	private final MCodeBuffer _code;
	
	public MMethodImplementation(final MClass pOwner, final MMethodDeclaration pDeclaration) {
		super();
		if (pOwner == null) {
			throw new IllegalArgumentException("pOwner == null");
		}
		_owner = pOwner;
		if (_owner != null) {
			pOwner.addMethod(this);
		}
		if (pDeclaration == null) {
			throw new IllegalArgumentException("pDeclaration == null");
		}
		_declaration = pDeclaration;
		if (_declaration != null) {
			pDeclaration.addImplementation(this);
		}
		_code = new MCodeBuffer();
		if (_code == null) {
			throw new IllegalArgumentException("_code == null");
		}
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	
	// @ccg.userblock.end
	
	/**
	 * Return the value of property owner.
	 * 
	 * @return The value of property owner.
	 */
	public final MClass getOwner() {
		return _owner;
	}
	
	/**
	 * Return the value of property declaration.
	 * 
	 * @return The value of property declaration.
	 */
	public final MMethodDeclaration getDeclaration() {
		return _declaration;
	}
	
	/**
	 * Returns the value of property parameterFinal at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property parameterFinal at the specified index.
	 * @see List#get(int)
	 */
	public final Boolean getParameterFinal(final int index) {
		return (Boolean) _parameterFinal.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsParameterFinal(final Object pObject) {
		return _parameterFinal.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property parameterFinal.
	 * @see List#iterator()
	 */
	public final Iterator parameterFinalIterator() {
		return _parameterFinal.iterator();
	}
	
	/**
	 * @return Is property parameterFinal emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isParameterFinalEmpty() {
		return _parameterFinal.isEmpty();
	}
	
	/**
	 * @return The number of values of property parameterFinal.
	 * @see List#size()
	 */
	public final int parameterFinalSize() {
		return _parameterFinal.size();
	}
	
	/**
	 * Add the specified value to property parameterFinal.
	 * 
	 * @param pParameterFinal The additional value for property parameterFinal.
	 * @see List#add(Object)
	 */
	public final void addParameterFinal(final Boolean pParameterFinal) {
		if (_parameterFinal.contains(pParameterFinal)) {
			return;
		}
		_parameterFinal.add(pParameterFinal);
	}
	
	/**
	 * Remove the specified value of property parameterFinal.
	 * 
	 * @param pParameterFinal The value to remove from property parameterFinal.
	 * @see List#remove(Object)
	 */
	public final void removeParameterFinal(final Boolean pParameterFinal) {
		if (!_parameterFinal.contains(pParameterFinal)) {
			return;
		}
		_parameterFinal.remove(pParameterFinal);
	}
	
	/**
	 * Returns the value of property parameterName at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property parameterName at the specified index.
	 * @see List#get(int)
	 */
	public final String getParameterName(final int index) {
		return (String) _parameterName.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsParameterName(final Object pObject) {
		return _parameterName.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property parameterName.
	 * @see List#iterator()
	 */
	public final Iterator parameterNameIterator() {
		return _parameterName.iterator();
	}
	
	/**
	 * @return Is property parameterName emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isParameterNameEmpty() {
		return _parameterName.isEmpty();
	}
	
	/**
	 * @return The number of values of property parameterName.
	 * @see List#size()
	 */
	public final int parameterNameSize() {
		return _parameterName.size();
	}
	
	/**
	 * Add the specified value to property parameterName.
	 * 
	 * @param pParameterName The additional value for property parameterName.
	 * @see List#add(Object)
	 */
	public final void addParameterName(final String pParameterName) {
		if (_parameterName.contains(pParameterName)) {
			return;
		}
		_parameterName.add(pParameterName);
	}
	
	/**
	 * Remove the specified value of property parameterName.
	 * 
	 * @param pParameterName The value to remove from property parameterName.
	 * @see List#remove(Object)
	 */
	public final void removeParameterName(final String pParameterName) {
		if (!_parameterName.contains(pParameterName)) {
			return;
		}
		_parameterName.remove(pParameterName);
	}
	
	/**
	 * Return the value of property code.
	 * 
	 * @return The value of property code.
	 */
	public final MCodeBuffer getCode() {
		return _code;
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
