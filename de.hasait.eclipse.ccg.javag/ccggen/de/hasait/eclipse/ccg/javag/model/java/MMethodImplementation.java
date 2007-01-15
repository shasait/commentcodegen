package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.common.ContentBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	
	/** Name of property finalParameter. */
	public static final String PROPERTY_FINAL_PARAMETER_NAME = "finalParameter";
	/** Type of property finalParameter. */
	public static final Class PROPERTY_FINAL_PARAMETER_TYPE = MMethodParameterDeclaration.class;
	
	/** Name of property code. */
	public static final String PROPERTY_CODE_NAME = "code";
	/** Type of property code. */
	public static final Class PROPERTY_CODE_TYPE = MCodeBuffer.class;
	
	
	private final MClass _owner;
	
	private final MMethodDeclaration _declaration;
	
	private final List _finalParameter = new ArrayList();
	
	private final MCodeBuffer _code;
	
	public MMethodImplementation(final MClass pOwner, final MMethodDeclaration pDeclaration) {
		super();
		if (pOwner == null) {
			throw new IllegalArgumentException("pOwner == null");
		}
		_owner = pOwner;
		if (_owner != null) {
			pOwner.addImplementedMethod(this);
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
	public void write(final ContentBuffer pContent, final Map pUserBlockContentByName) {
		pContent.a(getDeclaration().getResultType().getFullQualifiedName());
		pContent.a(" ").a(getDeclaration().getName());
		pContent.a("(");
		if (!getDeclaration().isParameterEmpty()) {
			boolean vFirst = true;
			for (Iterator vParameterI = getDeclaration().parameterIterator(); vParameterI.hasNext();) {
				MMethodParameterDeclaration vParameter = (MMethodParameterDeclaration) vParameterI.next();
				if (vFirst) {
					vFirst = false;
				} else {
					pContent.a(", ");
				}
				if (containsFinalParameter(vParameter)) {
					pContent.a("final").a(" ");
				}
				pContent.a(vParameter.getType().getFullQualifiedName());
				pContent.a(" ").a(vParameter.getName());
			}
		}
		pContent.a(")").pi(" {");
		getCode().write(pContent, pUserBlockContentByName);
		pContent.pu("}");
	}
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
	 * Returns the value of property finalParameter at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property finalParameter at the specified index.
	 * @see List#get(int)
	 */
	public final MMethodParameterDeclaration getFinalParameter(final int index) {
		return (MMethodParameterDeclaration) _finalParameter.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsFinalParameter(final Object pObject) {
		return _finalParameter.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property finalParameter.
	 * @see List#iterator()
	 */
	public final Iterator finalParameterIterator() {
		return _finalParameter.iterator();
	}
	
	/**
	 * @return Is property finalParameter emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isFinalParameterEmpty() {
		return _finalParameter.isEmpty();
	}
	
	/**
	 * @return The number of values of property finalParameter.
	 * @see List#size()
	 */
	public final int finalParameterSize() {
		return _finalParameter.size();
	}
	
	/**
	 * Add the specified value to property finalParameter.
	 * 
	 * @param pFinalParameter The additional value for property finalParameter.
	 * @see List#add(Object)
	 */
	public final void addFinalParameter(final MMethodParameterDeclaration pFinalParameter) {
		if (_finalParameter.contains(pFinalParameter)) {
			return;
		}
		_finalParameter.add(pFinalParameter);
	}
	
	/**
	 * Remove the specified value of property finalParameter.
	 * 
	 * @param pFinalParameter The value to remove from property finalParameter.
	 * @see List#remove(Object)
	 */
	public final void removeFinalParameter(final MMethodParameterDeclaration pFinalParameter) {
		if (!_finalParameter.contains(pFinalParameter)) {
			return;
		}
		_finalParameter.remove(pFinalParameter);
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
