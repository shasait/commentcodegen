package de.hasait.eclipse.ccg.javag.model.java;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MClass extends AbstractMType {
	// @ccg.userblock.start ClassBegin
	// @ccg.userblock.end

	/** Name of property abstract. */
	public static final String PROPERTY_ABSTRACT_NAME = "abstract";
	/** Type of property abstract. */
	public static final Class PROPERTY_ABSTRACT_TYPE = boolean.class;

	/** Name of property final. */
	public static final String PROPERTY_FINAL_NAME = "final";
	/** Type of property final. */
	public static final Class PROPERTY_FINAL_TYPE = boolean.class;

	/** Name of property extends. */
	public static final String PROPERTY_EXTENDS_NAME = "extends";
	/** Type of property extends. */
	public static final Class PROPERTY_EXTENDS_TYPE = MClass.class;

	/** Name of property derived. */
	public static final String PROPERTY_DERIVED_NAME = "derived";
	/** Type of property derived. */
	public static final Class PROPERTY_DERIVED_TYPE = MClass.class;

	/** Name of property implements. */
	public static final String PROPERTY_IMPLEMENTS_NAME = "implements";
	/** Type of property implements. */
	public static final Class PROPERTY_IMPLEMENTS_TYPE = MInterface.class;

	/** Name of property constructor. */
	public static final String PROPERTY_CONSTRUCTOR_NAME = "constructor";
	/** Type of property constructor. */
	public static final Class PROPERTY_CONSTRUCTOR_TYPE = MConstructorImplementation.class;

	/** Name of property instanceField. */
	public static final String PROPERTY_INSTANCE_FIELD_NAME = "instanceField";
	/** Type of property instanceField. */
	public static final Class PROPERTY_INSTANCE_FIELD_TYPE = MInstanceFieldDeclaration.class;

	/** Name of property method. */
	public static final String PROPERTY_METHOD_NAME = "method";
	/** Type of property method. */
	public static final Class PROPERTY_METHOD_TYPE = MMethodImplementation.class;


	private boolean _abstract;

	private boolean _final;

	private final MClass _extends;

	private final java.util.List _derived = new java.util.ArrayList();

	private final java.util.List _implements = new java.util.ArrayList();

	private final java.util.List _constructor = new java.util.ArrayList();

	private final java.util.List _instanceField = new java.util.ArrayList();

	private final java.util.List _method = new java.util.ArrayList();

	public MClass(final AbstractMTypeContainer pContainer, final String pName, final MClass pExtends) {
		super(pContainer, pName);
		_extends = pExtends;
		if (_extends != null) {
			pExtends.addDerived(this);
		}
	}

	// @ccg.userblock.start ClassAfterConstructor
	// @ccg.userblock.end

	/**
	 * Return the value of property abstract.

	 * @return The value of property abstract.
	 */
	public final boolean isAbstract() {
		return _abstract;
	}

	/**
	 * Set the value of property abstract to the specified value.

	 * @param pAbstract The new value for property abstract.
	 */
	public final void setAbstract(final boolean pAbstract) {
		if (_abstract == pAbstract) {
			return;
		}
		_abstract = pAbstract;
	}

	/**
	 * Return the value of property final.

	 * @return The value of property final.
	 */
	public final boolean isFinal() {
		return _final;
	}

	/**
	 * Set the value of property final to the specified value.

	 * @param pFinal The new value for property final.
	 */
	public final void setFinal(final boolean pFinal) {
		if (_final == pFinal) {
			return;
		}
		_final = pFinal;
	}

	/**
	 * Return the value of property extends.

	 * @return The value of property extends.
	 */
	public final MClass getExtends() {
		return _extends;
	}

	/**
	 * Returns the value of property derived at the specified index.

	 * @param index The index, which must be valid.
	 * @return The value of property derived at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final MClass getDerived(final int index) {
		return (MClass) _derived.get(index);
	}

	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsDerived(final Object pObject) {
		return _derived.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property derived.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator derivedIterator() {
		return _derived.iterator();
	}

	/**
	 * @return Is property derived emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isDerivedEmpty() {
		return _derived.isEmpty();
	}

	/**
	 * @return The number of values of property derived.
	 * @see java.util.List#size()
	 */
	public final int derivedSize() {
		return _derived.size();
	}

	/**
	 * Add the specified value to property derived.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MClass#PROPERTY_EXTENDS_NAME}, which will be updated by this method.

	 * @param pDerived The additional value for property derived.
	 * @see java.util.List#add(Object)
	 */
	public final void addDerived(final MClass pDerived) {
		if (_derived.contains(pDerived)) {
			return;
		}
		if (!(pDerived.getExtends() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_derived.add(pDerived);
	}

	/**
	 * Returns the value of property implements at the specified index.

	 * @param index The index, which must be valid.
	 * @return The value of property implements at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final MInterface getImplements(final int index) {
		return (MInterface) _implements.get(index);
	}

	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsImplements(final Object pObject) {
		return _implements.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property implements.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator implementsIterator() {
		return _implements.iterator();
	}

	/**
	 * @return Is property implements emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isImplementsEmpty() {
		return _implements.isEmpty();
	}

	/**
	 * @return The number of values of property implements.
	 * @see java.util.List#size()
	 */
	public final int implementsSize() {
		return _implements.size();
	}

	/**
	 * Add the specified value to property implements.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MInterface#PROPERTY_IMPLEMENTOR_NAME}, which will be updated by this method.

	 * @param pImplements The additional value for property implements.
	 * @see java.util.List#add(Object)
	 */
	public final void addImplements(final MInterface pImplements) {
		if (_implements.contains(pImplements)) {
			return;
		}
		_implements.add(pImplements);
		if (!(pImplements.containsImplementor(this))) {
			pImplements.addImplementor(this);
		}
	}

	/**
	 * Remove the specified value of property implements.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MInterface#PROPERTY_IMPLEMENTOR_NAME}, which will be updated by this method.

	 * @param pImplements The value to remove from property implements.
	 * @see java.util.List#remove(Object)
	 */
	public final void removeImplements(final MInterface pImplements) {
		if (!_implements.contains(pImplements)) {
			return;
		}
		_implements.remove(pImplements);
		if (pImplements.containsImplementor(this)) {
			pImplements.removeImplementor(this);
		}
	}

	/**
	 * Returns the value of property constructor at the specified index.

	 * @param index The index, which must be valid.
	 * @return The value of property constructor at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final MConstructorImplementation getConstructor(final int index) {
		return (MConstructorImplementation) _constructor.get(index);
	}

	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsConstructor(final Object pObject) {
		return _constructor.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property constructor.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator constructorIterator() {
		return _constructor.iterator();
	}

	/**
	 * @return Is property constructor emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isConstructorEmpty() {
		return _constructor.isEmpty();
	}

	/**
	 * @return The number of values of property constructor.
	 * @see java.util.List#size()
	 */
	public final int constructorSize() {
		return _constructor.size();
	}

	/**
	 * Add the specified value to property constructor.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MConstructorImplementation#PROPERTY_OWNER_NAME}, which will be updated by this method.

	 * @param pConstructor The additional value for property constructor.
	 * @see java.util.List#add(Object)
	 */
	public final void addConstructor(final MConstructorImplementation pConstructor) {
		if (_constructor.contains(pConstructor)) {
			return;
		}
		if (!(pConstructor.getOwner() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_constructor.add(pConstructor);
	}

	/**
	 * Returns the value of property instanceField at the specified index.

	 * @param index The index, which must be valid.
	 * @return The value of property instanceField at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final MInstanceFieldDeclaration getInstanceField(final int index) {
		return (MInstanceFieldDeclaration) _instanceField.get(index);
	}

	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsInstanceField(final Object pObject) {
		return _instanceField.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property instanceField.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator instanceFieldIterator() {
		return _instanceField.iterator();
	}

	/**
	 * @return Is property instanceField emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isInstanceFieldEmpty() {
		return _instanceField.isEmpty();
	}

	/**
	 * @return The number of values of property instanceField.
	 * @see java.util.List#size()
	 */
	public final int instanceFieldSize() {
		return _instanceField.size();
	}

	/**
	 * Add the specified value to property instanceField.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MInstanceFieldDeclaration#PROPERTY_OWNER_NAME}, which will be updated by this method.

	 * @param pInstanceField The additional value for property instanceField.
	 * @see java.util.List#add(Object)
	 */
	public final void addInstanceField(final MInstanceFieldDeclaration pInstanceField) {
		if (_instanceField.contains(pInstanceField)) {
			return;
		}
		if (!(pInstanceField.getOwner() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_instanceField.add(pInstanceField);
	}

	/**
	 * Returns the value of property method at the specified index.

	 * @param index The index, which must be valid.
	 * @return The value of property method at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final MMethodImplementation getMethod(final int index) {
		return (MMethodImplementation) _method.get(index);
	}

	/**
	 * @param pObject The object to check for containment.
	 * @return Does this property contain the specified object?
	 * @see java.util.List#contains(Object)
	 */
	public final boolean containsMethod(final Object pObject) {
		return _method.contains(pObject);
	}

	/**
	 * @return An {@link java.util.Iterator} over all values of property method.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator methodIterator() {
		return _method.iterator();
	}

	/**
	 * @return Is property method emtpy?
	 * @see java.util.List#isEmpty()
	 */
	public final boolean isMethodEmpty() {
		return _method.isEmpty();
	}

	/**
	 * @return The number of values of property method.
	 * @see java.util.List#size()
	 */
	public final int methodSize() {
		return _method.size();
	}

	/**
	 * Add the specified value to property method.
	 * Referred from {@link de.hasait.eclipse.ccg.javag.model.java.MMethodImplementation#PROPERTY_OWNER_NAME}, which will be updated by this method.

	 * @param pMethod The additional value for property method.
	 * @see java.util.List#add(Object)
	 */
	public final void addMethod(final MMethodImplementation pMethod) {
		if (_method.contains(pMethod)) {
			return;
		}
		if (!(pMethod.getOwner() == this)) {
			throw new IllegalArgumentException("backref != this");
		}
		_method.add(pMethod);
	}


	// @ccg.userblock.start ClassEnd
	// @ccg.userblock.end
}
