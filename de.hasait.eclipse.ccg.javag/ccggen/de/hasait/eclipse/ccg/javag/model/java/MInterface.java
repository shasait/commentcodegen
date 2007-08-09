package de.hasait.eclipse.ccg.javag.model.java;

import de.hasait.eclipse.ccg.javag.util.CodeUtils;
import de.hasait.eclipse.common.ContentBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MInterface extends AbstractMType {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property extends. */
	public static final String PROPERTY_EXTENDS_NAME = "extends";
	/** Type of property extends. */
	public static final Class PROPERTY_EXTENDS_TYPE = MInterface.class;
	
	/** Name of property derived. */
	public static final String PROPERTY_DERIVED_NAME = "derived";
	/** Type of property derived. */
	public static final Class PROPERTY_DERIVED_TYPE = MInterface.class;
	
	/** Name of property implementor. */
	public static final String PROPERTY_IMPLEMENTOR_NAME = "implementor";
	/** Type of property implementor. */
	public static final Class PROPERTY_IMPLEMENTOR_TYPE = MClass.class;
	
	
	private final List _extends = new ArrayList();
	
	private final List _derived = new ArrayList();
	
	private final List _implementor = new ArrayList();
	
	public MInterface(final AbstractMTypeContainer pContainer, final String pName) {
		super(pContainer, pName);
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	public void write(final ContentBuffer pContent, final Map pUserBlockContentByName) {
		pContent.a(getVisibility());
		pContent.a(" ").a("interface").a(" ").a(getName());
		if (!isExtendsEmpty()) {
			pContent.a(" ").a("extends");
			boolean vFirst = true;
			for (Iterator vExtendsI = extendsIterator(); vExtendsI.hasNext();) {
				MInterface vExtends = (MInterface) vExtendsI.next();
				if (vFirst) {
					vFirst = false;
					pContent.a(" ");
				} else {
					pContent.a(", ");
				}
				pContent.a(vExtends.getFullQualifiedName());
			}
		}
		pContent.pi(" {");
		// userblock InterfaceBegin
		CodeUtils.writeUserBlock(pContent, pUserBlockContentByName, "InterfaceBegin");
		pContent.p();
		// constants
		if (!isStaticFieldEmpty()) {
			pContent.p("// constants");
			for (Iterator vStaticFieldI = staticFieldIterator(); vStaticFieldI.hasNext();) {
				MStaticFieldDeclaration vStaticField = (MStaticFieldDeclaration) vStaticFieldI.next();
				if (!"public".equals(vStaticField.getVisibility())) {
					throw new IllegalArgumentException(getFullQualifiedName() + " - static field " + vStaticField.getName()
					      + " has to be public for interfaces");
				}
				if (!vStaticField.isFinal()) {
					throw new IllegalArgumentException(getFullQualifiedName() + " - static field " + vStaticField.getName()
					      + " has to be final for interfaces");
				}
				vStaticField.writeWithoutFlags(pContent);
			}
			pContent.p();
		}
		// methods
		if (!isAbstractMethodEmpty()) {
			pContent.p("// methods");
			for (Iterator vAbstractMethodI = abstractMethodIterator(); vAbstractMethodI.hasNext();) {
				MMethodDeclaration vAbstractMethod = (MMethodDeclaration) vAbstractMethodI.next();
				if (!"public".equals(vAbstractMethod.getVisibility())) {
					throw new IllegalArgumentException(getFullQualifiedName() + " - abstract method "
					      + vAbstractMethod.getName() + " has to be public for interfaces");
				}
				vAbstractMethod.writeAbstractWithoutFlags(pContent);
			}
			pContent.p();
		}
		// userblock InterfaceEnd
		CodeUtils.writeUserBlock(pContent, pUserBlockContentByName, "InterfaceEnd");
		pContent.p();
		pContent.up("}");
	}
	// @ccg.userblock.end
	
	/**
	 * Returns the value of property extends at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property extends at the specified index.
	 * @see List#get(int)
	 */
	public final MInterface getExtends(final int index) {
		return (MInterface) _extends.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsExtends(final Object pObject) {
		return _extends.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property extends.
	 * @see List#iterator()
	 */
	public final Iterator extendsIterator() {
		return _extends.iterator();
	}
	
	/**
	 * @return Is property extends emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isExtendsEmpty() {
		return _extends.isEmpty();
	}
	
	/**
	 * @return The number of values of property extends.
	 * @see List#size()
	 */
	public final int extendsSize() {
		return _extends.size();
	}
	
	/**
	 * Add the specified value to property extends.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MInterface#PROPERTY_DERIVED_NAME}, which will be updated by this method.
	 * 
	 * @param pExtends The additional value for property extends.
	 * @see List#add(Object)
	 */
	public final void addExtends(final MInterface pExtends) {
		if (_extends.contains(pExtends)) {
			return;
		}
		_extends.add(pExtends);
		if (!(pExtends.containsDerived(this))) {
			pExtends.addDerived(this);
		}
	}
	
	/**
	 * Remove the specified value of property extends.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MInterface#PROPERTY_DERIVED_NAME}, which will be updated by this method.
	 * 
	 * @param pExtends The value to remove from property extends.
	 * @see List#remove(Object)
	 */
	public final void removeExtends(final MInterface pExtends) {
		if (!_extends.contains(pExtends)) {
			return;
		}
		_extends.remove(pExtends);
		if (pExtends.containsDerived(this)) {
			pExtends.removeDerived(this);
		}
	}
	
	/**
	 * Returns the value of property derived at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property derived at the specified index.
	 * @see List#get(int)
	 */
	public final MInterface getDerived(final int index) {
		return (MInterface) _derived.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsDerived(final Object pObject) {
		return _derived.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property derived.
	 * @see List#iterator()
	 */
	public final Iterator derivedIterator() {
		return _derived.iterator();
	}
	
	/**
	 * @return Is property derived emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isDerivedEmpty() {
		return _derived.isEmpty();
	}
	
	/**
	 * @return The number of values of property derived.
	 * @see List#size()
	 */
	public final int derivedSize() {
		return _derived.size();
	}
	
	/**
	 * Add the specified value to property derived.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MInterface#PROPERTY_EXTENDS_NAME}, which will be updated by this method.
	 * 
	 * @param pDerived The additional value for property derived.
	 * @see List#add(Object)
	 */
	public final void addDerived(final MInterface pDerived) {
		if (_derived.contains(pDerived)) {
			return;
		}
		_derived.add(pDerived);
		if (!(pDerived.containsExtends(this))) {
			pDerived.addExtends(this);
		}
	}
	
	/**
	 * Remove the specified value of property derived.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MInterface#PROPERTY_EXTENDS_NAME}, which will be updated by this method.
	 * 
	 * @param pDerived The value to remove from property derived.
	 * @see List#remove(Object)
	 */
	public final void removeDerived(final MInterface pDerived) {
		if (!_derived.contains(pDerived)) {
			return;
		}
		_derived.remove(pDerived);
		if (pDerived.containsExtends(this)) {
			pDerived.removeExtends(this);
		}
	}
	
	/**
	 * Returns the value of property implementor at the specified index.
	 * 
	 * @param index The index, which must be valid.
	 * @return The value of property implementor at the specified index.
	 * @see List#get(int)
	 */
	public final MClass getImplementor(final int index) {
		return (MClass) _implementor.get(index);
	}
	
	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see List#contains(Object)
	 */
	public final boolean containsImplementor(final Object pObject) {
		return _implementor.contains(pObject);
	}
	
	/**
	 * @return An {@link Iterator} over all values of property implementor.
	 * @see List#iterator()
	 */
	public final Iterator implementorIterator() {
		return _implementor.iterator();
	}
	
	/**
	 * @return Is property implementor emtpy?
	 * @see List#isEmpty()
	 */
	public final boolean isImplementorEmpty() {
		return _implementor.isEmpty();
	}
	
	/**
	 * @return The number of values of property implementor.
	 * @see List#size()
	 */
	public final int implementorSize() {
		return _implementor.size();
	}
	
	/**
	 * Add the specified value to property implementor.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MClass#PROPERTY_IMPLEMENTS_NAME}, which will be updated by this method.
	 * 
	 * @param pImplementor The additional value for property implementor.
	 * @see List#add(Object)
	 */
	public final void addImplementor(final MClass pImplementor) {
		if (_implementor.contains(pImplementor)) {
			return;
		}
		_implementor.add(pImplementor);
		if (!(pImplementor.containsImplements(this))) {
			pImplementor.addImplements(this);
		}
	}
	
	/**
	 * Remove the specified value of property implementor.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MClass#PROPERTY_IMPLEMENTS_NAME}, which will be updated by this method.
	 * 
	 * @param pImplementor The value to remove from property implementor.
	 * @see List#remove(Object)
	 */
	public final void removeImplementor(final MClass pImplementor) {
		if (!_implementor.contains(pImplementor)) {
			return;
		}
		_implementor.remove(pImplementor);
		if (pImplementor.containsImplements(this)) {
			pImplementor.removeImplements(this);
		}
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
