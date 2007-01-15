package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MMethodDeclaration {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property owner. */
	public static final String PROPERTY_OWNER_NAME = "owner";
	/** Type of property owner. */
	public static final Class PROPERTY_OWNER_TYPE = AbstractMType.class;
	
	/** Name of property implementation. */
	public static final String PROPERTY_IMPLEMENTATION_NAME = "implementation";
	/** Type of property implementation. */
	public static final Class PROPERTY_IMPLEMENTATION_TYPE = MMethodImplementation.class;
	
	/** Name of property visibility. */
	public static final String PROPERTY_VISIBILITY_NAME = "visibility";
	/** Type of property visibility. */
	public static final Class PROPERTY_VISIBILITY_TYPE = String.class;
	
	/** Name of property name. */
	public static final String PROPERTY_NAME_NAME = "name";
	/** Type of property name. */
	public static final Class PROPERTY_NAME_TYPE = String.class;
	
	/** Name of property resultType. */
	public static final String PROPERTY_RESULT_TYPE_NAME = "resultType";
	/** Type of property resultType. */
	public static final Class PROPERTY_RESULT_TYPE_TYPE = AbstractMType.class;
	
	/** Name of property parameter. */
	public static final String PROPERTY_PARAMETER_NAME = "parameter";
	/** Type of property parameter. */
	public static final Class PROPERTY_PARAMETER_TYPE = MMethodParameterDeclaration.class;
	
	
	private final List _owner = new ArrayList();
	
	private final List _implementation = new ArrayList();
	
	private String _visibility;
	
	private final String _name;
	
	private AbstractMType _resultType;
	
	private final List _parameter = new ArrayList();
	
	public MMethodDeclaration(final AbstractMType[] pOwner, final String pName) {
		super();
		if (pOwner != null) {
			for (int vOwnerI = 0; vOwnerI < pOwner.length; vOwnerI++) {
				_owner.add(pOwner[vOwnerI]);
			}
		}
		if (_owner.isEmpty()) {
			throw new IllegalArgumentException("_owner.isEmpty()");
		}
		if (pName == null) {
			throw new IllegalArgumentException("pName == null");
		}
		_name = pName;
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public void writeAbstractWithoutFlags(final ContentBuffer pContent) {
		pContent.a(getResultType().getFullQualifiedName());
		pContent.a(" ").a(getName());
		pContent.a("(");
		if (!isParameterEmpty()) {
			boolean vFirst = true;
			for (Iterator vParameterI = parameterIterator(); vParameterI.hasNext();) {
				MMethodParameterDeclaration vParameter = (MMethodParameterDeclaration) vParameterI.next();
				if (vFirst) {
					vFirst = false;
				} else {
					pContent.a(", ");
				}
				pContent.a(vParameter.getType().getFullQualifiedName());
				pContent.a(" ").a(vParameter.getName());
			}
		}
		pContent.a(")").p(";");
	}

	public void writeAbstractWithFlags(final ContentBuffer pContent) {
		if (getVisibility() != null) {
			pContent.a(getVisibility()).a(" ");
		}
		pContent.a("abstract").a(" ");
		writeAbstractWithoutFlags(pContent);
	}
	// @ccg.userblock.end
	
	/**
	 * Returns the value of property owner at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property owner at the specified index.
	 * @see List#get(int)
	 */
	public final AbstractMType getOwner(final int index) {
		return (AbstractMType) _owner.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsOwner(final Object pObject) {
		return _owner.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property owner.
	 * @see List#iterator()
	 */
	public final Iterator ownerIterator() {
		return _owner.iterator();
	}
	
	/**
	 * @return Is property owner emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isOwnerEmpty() {
		return _owner.isEmpty();
	}
	
	/**
	 * @return The number of values of property owner.
	 * @see List#size()
	 */
	public final int ownerSize() {
		return _owner.size();
	}
	
	/**
	 * Returns the value of property implementation at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property implementation at the specified index.
	 * @see List#get(int)
	 */
	public final MMethodImplementation getImplementation(final int index) {
		return (MMethodImplementation) _implementation.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsImplementation(final Object pObject) {
		return _implementation.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property implementation.
	 * @see List#iterator()
	 */
	public final Iterator implementationIterator() {
		return _implementation.iterator();
	}
	
	/**
	 * @return Is property implementation emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isImplementationEmpty() {
		return _implementation.isEmpty();
	}
	
	/**
	 * @return The number of values of property implementation.
	 * @see List#size()
	 */
	public final int implementationSize() {
		return _implementation.size();
	}
	
	/**
	 * Add the specified value to property implementation.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MMethodImplementation#PROPERTY_DECLARATION_NAME}, which will be updated by this method.
	 * 
	 * @param pImplementation The additional value for property implementation.
	 * @see List#add(Object)
	 */
	public final void addImplementation(final MMethodImplementation pImplementation) {
		if (_implementation.contains(pImplementation)) {
			return;
		}
		if (!(pImplementation.getDeclaration() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_implementation.add(pImplementation);
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
	 * Return the value of property name.
	 * 
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}
	
	/**
	 * Return the value of property resultType.
	 * 
	 * @return The value of property resultType.
	 */
	public final AbstractMType getResultType() {
		return _resultType;
	}
	
	/**
	 * Set the value of property resultType to the specified value.
	 * 
	 * @param pResultType The new value for property resultType.
	 */
	public final void setResultType(final AbstractMType pResultType) {
		if (_resultType == pResultType) {
			return;
		}
		_resultType = pResultType;
	}
	
	/**
	 * Returns the value of property parameter at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property parameter at the specified index.
	 * @see List#get(int)
	 */
	public final MMethodParameterDeclaration getParameter(final int index) {
		return (MMethodParameterDeclaration) _parameter.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsParameter(final Object pObject) {
		return _parameter.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property parameter.
	 * @see List#iterator()
	 */
	public final Iterator parameterIterator() {
		return _parameter.iterator();
	}
	
	/**
	 * @return Is property parameter emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isParameterEmpty() {
		return _parameter.isEmpty();
	}
	
	/**
	 * @return The number of values of property parameter.
	 * @see List#size()
	 */
	public final int parameterSize() {
		return _parameter.size();
	}
	
	/**
	 * Add the specified value to property parameter.
	 * 
	 * @param pParameter The additional value for property parameter.
	 * @see List#add(Object)
	 */
	public final void addParameter(final MMethodParameterDeclaration pParameter) {
		if (_parameter.contains(pParameter)) {
			return;
		}
		_parameter.add(pParameter);
	}
	
	/**
	 * Remove the specified value of property parameter.
	 * 
	 * @param pParameter The value to remove from property parameter.
	 * @see List#remove(Object)
	 */
	public final void removeParameter(final MMethodParameterDeclaration pParameter) {
		if (!_parameter.contains(pParameter)) {
			return;
		}
		_parameter.remove(pParameter);
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
